package co.com.codesoftware.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import co.com.codesoftware.entities.DatosSessionEntity;
import co.com.codesoftware.entities.GenericProductEntity;
import co.com.codesoftware.logic.ClienteLogic;
import co.com.codesoftware.logic.ProductsLogic;
import co.com.codesoftware.logic.RecetasLogic;
import co.com.codesoftware.logic.SearchTopLogic;
import co.com.codesoftware.servicio.usuario.ClienteEntity;

@ManagedBean
@ViewScoped
public class ClienteBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ClienteEntity cliente;
	private List<ClienteEntity> clientes;
	private List<ClienteEntity> clientesFilter;
	private Integer clienteId;
////	private List<PantallaPrincipalFacTable> recetas;
////	private List<PantallaPrincipalFacTable> productos;
////	private List<RecetaTable> dishes;
//	private List<RecetaTable> dishesFilter;
	private GenericProductEntity prod;
	private DatosSessionEntity entitySession;
	/**
	 * Constructor del bean
	 */
	public ClienteBean() {
		cliente = new ClienteEntity();
	}
	@PostConstruct
	/*
	 * Metodo en el cual carga todo lo que se necesita al inicio
	 */
	public void init() {
		try {
			FacesMessage message = null;
			FacesContext context = FacesContext.getCurrentInstance();
			this.entitySession = (DatosSessionEntity) context.getExternalContext().getSessionMap().get("dataSession");
			if (entitySession == null) {
				message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Esta intentando a un sitio no permitido porfavor realice el login primero");
				context.getExternalContext().redirect("../index.jsf");
			} else {
//				RecetasLogic logic = new RecetasLogic();
//				ProductsLogic logicPrd = new ProductsLogic();
//				this.productos = logicPrd.getEspecialProduct(entitySession.getDataUser().getSede().getId());
//				this.recetas = logic.getEspecialReceta(entitySession.getDataUser().getSede().getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ClienteEntity getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}

	public GenericProductEntity getProd() {
		return prod;
	}

	public void setProd(GenericProductEntity prod) {
		this.prod = prod;
	}

	/**
	 * Funcion encargada de insertar un cliente en la base de datos del sistema
	 */
	public void addCliente() {
		SearchTopLogic logic = new SearchTopLogic();
		ClienteEntity clienteAux = logic.obtieneClienteXCedula(cliente.getCedula());
		if(clienteAux == null){
			this.cliente.setId(null);
			this.clienteId = logic.getLogicAddClient(this.cliente);
		}else{
			this.clienteId = clienteAux.getId();
			cliente.setNombres(clienteAux.getNombres());
			cliente.setApellidos(clienteAux.getApellidos());
			cliente.setTelefono(clienteAux.getTelefono());
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "El cliente ya estaba en la base de datos", "Ok");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		if (this.clienteId != null) {
			this.cliente.setId(clienteId);
			RequestContext.getCurrentInstance().execute("PF('insertClient').hide()");
		} else {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No Inserto Correctamente", "Error");
			FacesContext.getCurrentInstance().addMessage(null, message);
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
	 * Funcion con la cual selecciono un cliente
	 */
	public void seleccionarCliente(ClienteEntity cliente) {
		try {
			this.cliente = cliente;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	

	/**
	 * metodo que consulta el cliente Generico
	 */
	public void genericClient() {
		ClienteLogic logic = new ClienteLogic();
		this.cliente = logic.getDefaultClient();
	}

	/**
	 * Funcion con la cual se setea el cliente para prepararlo para actualizarlo
	 * 
	 * @param cliente
	 */
	public void preUpdCliente(ClienteEntity cliente) {
		try {
			this.cliente = cliente;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Funcion con la cual actualizo el cliente
	 * 
	 * @param cliente
	 */
	public void updatecliente() {
		try {
			ClienteLogic logic = new ClienteLogic();
			boolean valida = logic.updateCliente(this.cliente);
			if (valida) {
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ok", "Cliente Actualizado correctamente");
				FacesContext.getCurrentInstance().addMessage(null, message);
				RequestContext.getCurrentInstance().execute("PF('actualizarClient').hide()");
			} else {
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al actualizar el Cliente", "Error");
				FacesContext.getCurrentInstance().addMessage(null, message);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public DatosSessionEntity getEntitySession() {
		return entitySession;
	}

	public void setEntitySession(DatosSessionEntity entitySession) {
		this.entitySession = entitySession;
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
	public Integer getClienteId() {
		return clienteId;
	}
	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}
}
