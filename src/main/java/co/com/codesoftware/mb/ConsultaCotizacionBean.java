package co.com.codesoftware.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import co.com.codesoftware.logic.PedidosLogic;
import co.com.codesoftware.logic.SearchTopLogic;
import co.com.codesoftware.servicio.pedido.PedidoEntity;
import co.com.codesoftware.servicio.usuario.ClienteEntity;
import co.com.codesoftware.utilities.ErrorEnum;

@ManagedBean
@ViewScoped
public class ConsultaCotizacionBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<ClienteEntity> clientes;
	private List<ClienteEntity> clientesFilter;
	private ClienteEntity clienteSelected;
	private ErrorEnum enumer;
	private List<PedidoEntity> resultCotiza;
	private String banderaPDF;
	private Integer idCotizacion;

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
	 * Funcion con al cual llama al web services que cotizaciones por cliente
	 */
	public void consultaCotizaciones() {
		try {
			if (clienteSelected == null) {
				this.setEnumer(ErrorEnum.ERROR);
				this.messageBean("Error por favor selecciones un cliente");
			} else {
				PedidosLogic objLogic = new PedidosLogic();
				this.resultCotiza = objLogic.buscaCotizacionesXCliente(clienteSelected.getId());
				if (resultCotiza == null) {
					this.setEnumer(ErrorEnum.ERROR);
					this.messageBean("Error la consulta no arrojo ningun resultado");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Funcion con la cual muestra pdf de la cotizacion
	 */
	public void generaPdfCotizacion(Integer idCotizacion) {
		try {
			PedidosLogic objLogica = new PedidosLogic();
			String rta = objLogica.generarPdfXIdCotiza(idCotizacion);
			if ("Ok".equalsIgnoreCase(rta)) {
				this.banderaPDF = "Ok";
				this.idCotizacion = idCotizacion;
			} else {
				this.setEnumer(ErrorEnum.ERROR);
				this.messageBean("Error al intentar mostrar el pdf de la cotizacion");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Funcion con la cual cambio de estado la cotizacion y la convierto a pedido
	 * @param objEntity
	 */
	public void activoCotizacion(PedidoEntity objEntity){
		try {
			Date fechaCotiza = objEntity.getFecha().toGregorianCalendar().getTime();
			Date hoy = new Date();
			long cotiza = fechaCotiza.getTime();
			long hoyLong = hoy.getTime();
			final long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000;
			long dias = (cotiza - hoyLong) / MILLSECS_PER_DAY;
			if(dias > -15){
				PedidosLogic objLogic = new PedidosLogic();
				boolean valida = objLogic.cambiaEstadoPedido(objEntity.getId(), "CR");
				if(valida == true){
					this.setEnumer(ErrorEnum.SUCCESS);					
					this.messageBean("La cotizacion convertida en pedido");
				}else{
					this.setEnumer(ErrorEnum.ERROR);					
					this.messageBean("Error al convertir el pedido a cotizacion");
				}
			}else{
				this.setEnumer(ErrorEnum.ERROR);
				this.messageBean("La cotizacion excede los 15 dias de valides, por favor cree otro pedido");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
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

	public List<PedidoEntity> getResultCotiza() {
		return resultCotiza;
	}

	public void setResultCotiza(List<PedidoEntity> resultCotiza) {
		this.resultCotiza = resultCotiza;
	}

	public String getBanderaPDF() {
		return banderaPDF;
	}

	public void setBanderaPDF(String banderaPDF) {
		this.banderaPDF = banderaPDF;
	}

	public Integer getIdCotizacion() {
		return idCotizacion;
	}

	public void setIdCotizacion(Integer idCotizacion) {
		this.idCotizacion = idCotizacion;
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
	
	

}
