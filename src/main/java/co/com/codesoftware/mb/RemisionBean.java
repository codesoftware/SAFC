package co.com.codesoftware.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import co.com.codesoftware.entities.DatosSessionEntity;
import co.com.codesoftware.logic.PedidosLogic;
import co.com.codesoftware.logic.SearchTopLogic;
import co.com.codesoftware.servicio.pedido.PedidoEntity;
import co.com.codesoftware.servicio.pedido.PedidoProductoEntity;
import co.com.codesoftware.servicio.usuario.ClienteEntity;
import co.com.codesoftware.utilities.ErrorEnum;

@ManagedBean
@ViewScoped
public class RemisionBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<ClienteEntity> clientes;
	private List<ClienteEntity> clientesFilter;
	private ClienteEntity clienteSelected;
	private ErrorEnum enumer;
	private List<PedidoEntity> resultRemisiones;
	private PedidoEntity remisionEspecifica;
	// Objetos necesarios para el modal de confirmacion de remision
	private PedidoEntity remisionModal;
	private List<PedidoProductoEntity> productosPedidoMod;
	// Objeto el cual contiene los datos del usuario logeado
	private DatosSessionEntity entitySession;
	// Ruta de la remision generada
	private String rutaRemision;

	@PostConstruct
	public void init() {
		try {
			FacesMessage message = null;
			FacesContext context = FacesContext.getCurrentInstance();
			this.entitySession = (DatosSessionEntity) context.getExternalContext().getSessionMap().get("dataSession");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Funcion encargada de Buscar los cliente del sistema
	 */
	public void buscaClientes() {
		try {
			clientes = new ArrayList<ClienteEntity>();
			SearchTopLogic logic = new SearchTopLogic();
			clientes = logic.searchClient();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Funcion con la cual se selecciona un cliente
	 */
	public void seleccionarCliente(ClienteEntity cliente) {
		try {
			this.clienteSelected = cliente;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Funcion con al cual llama al web services que busca remisiones por
	 * cliente
	 */
	public void consultaRemisiones() {
		try {
			if (clienteSelected == null) {
				this.setEnumer(ErrorEnum.ERROR);
				this.messageBean("Error por favor selecciones un cliente");
			} else {
				PedidosLogic objLogic = new PedidosLogic();
				this.resultRemisiones = objLogic.buscaRemsionesXCliente(clienteSelected.getId());
				if (this.resultRemisiones == null) {
					this.setEnumer(ErrorEnum.ERROR);
					this.messageBean("Error la consulta no arrojo ningun resultado");
				} else if (this.resultRemisiones.size() == 0) {
					this.setEnumer(ErrorEnum.ERROR);
					this.messageBean("Error la consulta no arrojo ningun resultado");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<ClienteEntity> getClientes() {
		return clientes;
	}

	public void setClientes(List<ClienteEntity> clientes) {
		this.clientes = clientes;
	}

	public List<ClienteEntity> getClientesFilter() {
		return clientesFilter;
	}

	public void setClientesFilter(List<ClienteEntity> clientesFilter) {
		this.clientesFilter = clientesFilter;
	}

	public ClienteEntity getClienteSelected() {
		return clienteSelected;
	}

	public void setClienteSelected(ClienteEntity clienteSelected) {
		this.clienteSelected = clienteSelected;
	}

	public ErrorEnum getEnumer() {
		return enumer;
	}

	public void setEnumer(ErrorEnum enumer) {
		this.enumer = enumer;
	}

	/**
	 * Funcion generica para mostrar el mensaje
	 * 
	 * @param message
	 */
	public void messageBean(String message) {
		switch (this.enumer) {
		case ERROR:
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", message));
			break;
		case FATAL:
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, "Fatal!", "Error de sistema"));
			break;
		case SUCCESS:
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Ok!", message));
			break;

		default:
			break;
		}
	}

	/**
	 * Funcion con la cual consulto una remision en especifico
	 * 
	 * @param remision
	 */
	public void consultaRemision(PedidoEntity remision) {
		PedidosLogic objLogica = new PedidosLogic();
		this.remisionModal = new PedidoEntity();
		this.productosPedidoMod = null;
		try {
			this.remisionModal = objLogica.obtenerInfoPrincPedido(remision.getId());
			if (this.remisionModal == null) {
				this.setEnumer(ErrorEnum.ERROR);
				this.messageBean("Error al buscar el pedido especifico");
			} else {
				this.productosPedidoMod = objLogica.buscaDetallePedido(remision.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Funcion con la cual se remisiona el pedido
	 * 
	 * @return
	 */
	public void enviarRemision() {
		try {
			if (this.remisionModal.getId() != null) {
				PedidosLogic objLogica = new PedidosLogic();
				String rta = objLogica.generaRemision(this.remisionModal.getId(),
						this.entitySession.getDataUser().getId());
				// if("Ok".equalsIgnoreCase(rta)){
				if (rta.toUpperCase().contains("OK")) {
					String[] aux = rta.split("-");
					System.out.println("Este es el id de la remision: " + aux[1]);
					this.generaPdfRemision(Integer.parseInt(aux[1]));
					this.setEnumer(ErrorEnum.SUCCESS);
					this.messageBean("Remision generada correctamente ");
					this.resultRemisiones = null;
				} else {
					this.setEnumer(ErrorEnum.ERROR);
					this.messageBean("Error al generar la remision: " + rta);
				}
			} else {
				this.setEnumer(ErrorEnum.ERROR);
				this.messageBean("Error el pedido no puede ser nulo");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Funcion con la cual genero el pdf de la remision
	 */
	public void generaPdfRemision(Integer idRemi){
		try {
			PedidosLogic objLogic = new PedidosLogic();
			String documento = objLogic.generaPdfRemision(idRemi);
			String valida = objLogic.materializaImagenSeridor(documento, idRemi);
			if(valida.toUpperCase().contains("OK")){
				this.setEnumer(ErrorEnum.SUCCESS);
				this.messageBean("Remision generada correctamente");
				ExternalContext tmpEC;
				tmpEC = FacesContext.getCurrentInstance().getExternalContext();
				//String realPath = tmpEC.getRealPath("/resources/images/remisiones/");
				String realPath = "/resources/images/remisiones/";
				realPath += "remision_" + idRemi + ".pdf";
				this.rutaRemision = realPath;
				RequestContext requestContext = RequestContext.getCurrentInstance();
				requestContext.execute("PF('dialogVisorPdfRem').show()");
			}else{
				this.setEnumer(ErrorEnum.SUCCESS);
				this.messageBean("Error al generar la remision por favor contacte al administrador");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<PedidoEntity> getResultRemisiones() {
		return resultRemisiones;
	}

	public void setResultRemisiones(List<PedidoEntity> resultRemisiones) {
		this.resultRemisiones = resultRemisiones;
	}

	public PedidoEntity getRemisionEspecifica() {
		return remisionEspecifica;
	}

	public void setRemisionEspecifica(PedidoEntity remisionEspecifica) {
		this.remisionEspecifica = remisionEspecifica;
	}

	public PedidoEntity getRemisionModal() {
		return remisionModal;
	}

	public void setRemisionModal(PedidoEntity remisionModal) {
		this.remisionModal = remisionModal;
	}

	public List<PedidoProductoEntity> getProductosPedidoMod() {
		return productosPedidoMod;
	}

	public void setProductosPedidoMod(List<PedidoProductoEntity> productosPedidoMod) {
		this.productosPedidoMod = productosPedidoMod;
	}

	public DatosSessionEntity getEntitySession() {
		return entitySession;
	}

	public void setEntitySession(DatosSessionEntity entitySession) {
		this.entitySession = entitySession;
	}

	public String getRutaRemision() {
		return rutaRemision;
	}

	public void setRutaRemision(String rutaRemision) {
		this.rutaRemision = rutaRemision;
	}

}