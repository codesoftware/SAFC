package co.com.codesoftware.mb;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import co.com.codesoftware.entities.DatosSessionEntity;
import co.com.codesoftware.logic.ConsultaFacturaLogic;
import co.com.codesoftware.logic.FacturacionLogic;
import co.com.codesoftware.servicio.facturacion.FacturaEntity;
import co.com.codesoftware.servicio.usuario.ClienteEntity;

@ManagedBean
@ViewScoped
public class ConsultaFacturacionBean {

	private Date fechaInicio;
	private Date fechaFinal;
	private List<FacturaEntity> facturas;
	private List<FacturaEntity> facturasFiltradas;
	private FacturaEntity factComplete;
	private Date fechaExacta;
	private DatosSessionEntity entitySession;
	private BigDecimal totalCaja;
	private String bandera = "Error";
	private String idFacturaAbrir;
	private Integer idFactura;
	private ClienteEntity clienteSelect;
	private String codigoExterno;

	public DatosSessionEntity getEntitySession() {
		return entitySession;
	}

	public void setEntitySession(DatosSessionEntity entitySession) {
		this.entitySession = entitySession;
	}

	public BigDecimal getTotalCaja() {
		return totalCaja;
	}

	public void setTotalCaja(BigDecimal totalCaja) {
		this.totalCaja = totalCaja;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}	

	@PostConstruct
	public void init() {
		try {
			FacesMessage message = null;
			FacesContext context = FacesContext.getCurrentInstance();
			this.entitySession = (DatosSessionEntity) context.getExternalContext().getSessionMap().get("dataSession");
			if (entitySession == null) {
				message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Esta intentando a un sitio no permitido porfavor realice el login primero");
				context.getExternalContext().redirect("../index.jsf");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Funcion con la cual busco las facturas en un rango determinado de fechas
	 */
	public void consultaFacturasXFechas() {
		if (fechaInicio == null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "La fecha inicial no puede ser nula"));
			return;
		}
		if (fechaFinal == null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "La fecha final no puede ser nula"));
			return;
		}
		
		ConsultaFacturaLogic logic = new ConsultaFacturaLogic();
		long idCliente = 0;
		if(clienteSelect != null){
			idCliente = clienteSelect.getId();
		}
		this.facturas = logic.consultaFacturasRangoFechas(fechaInicio, fechaFinal, idFactura,""+idCliente,codigoExterno);
		if (this.facturas == null || this.facturas.size() == 0) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "La consulta no arrojo ningun resultado"));
		}

	}

	/**
	 * Funcion que actualiza la pantalla de consultar el saldo
	 */
	public void consultaSaldoCaja() {
		ConsultaFacturaLogic logic = new ConsultaFacturaLogic();
		totalCaja = logic.consultaCajaXSede(this.entitySession.getDataUser().getSede().getId());
	}

	/**
	 * Funcion encargada de realizar la busqueda de una factura en especifico
	 * 
	 * @param obj
	 */
	public void buscaFacturaEspecifico(FacturaEntity obj) {
		ConsultaFacturaLogic logic = new ConsultaFacturaLogic();
		try {
			this.factComplete = logic.consutlaFacturaXId(obj.getId());
			this.fechaExacta = factComplete.getFechaExacta().toGregorianCalendar().getTime();
			if (this.factComplete == null) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "La consulta de la factura especifica no arrojo ningun resultado"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String redireccionConsultaFacturacion() {
		return "/ACTIONS/FACTURACION/buscaFacturas";
	}

	public Date getFechaExacta() {
		return fechaExacta;
	}

	public void setFechaExacta(Date fechaExacta) {
		this.fechaExacta = fechaExacta;
	}

	/**
	 * Funcion con la cual genero el pdf de la factura indicada
	 */
	public void generaFacturacion() {
		try {
			FacturacionLogic objLogic = new FacturacionLogic();
			String rta = objLogic.generarPdfXIdFact(factComplete.getId());
			if ("Ok".equalsIgnoreCase(rta)) {
				idFacturaAbrir = "" + factComplete.getId();
				bandera = "Ok";
			} else {
				bandera = "Error";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getBandera() {
		return bandera;
	}

	public void setBandera(String bandera) {
		this.bandera = bandera;
	}

	public String getIdFacturaAbrir() {
		return idFacturaAbrir;
	}

	public void setIdFacturaAbrir(String idFacturaAbrir) {
		this.idFacturaAbrir = idFacturaAbrir;
	}

	public Integer getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(Integer idFactura) {
		this.idFactura = idFactura;
	}
	/**
	 * Funcion con la cual se selecciona un cliente
	 */
	public void seleccionaCliente(ClienteEntity cliente){
		try {
			this.clienteSelect = cliente;			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getCodigoExterno() {
		return codigoExterno;
	}

	public void setCodigoExterno(String codigoExterno) {
		this.codigoExterno = codigoExterno;
	}

	public List<FacturaEntity> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<FacturaEntity> facturas) {
		this.facturas = facturas;
	}

	public List<FacturaEntity> getFacturasFiltradas() {
		return facturasFiltradas;
	}

	public void setFacturasFiltradas(List<FacturaEntity> facturasFiltradas) {
		this.facturasFiltradas = facturasFiltradas;
	}

	public FacturaEntity getFactComplete() {
		return factComplete;
	}

	public void setFactComplete(FacturaEntity factComplete) {
		this.factComplete = factComplete;
	}

	public ClienteEntity getClienteSelect() {
		return clienteSelect;
	}

	public void setClienteSelect(ClienteEntity clienteSelect) {
		this.clienteSelect = clienteSelect;
	}
}