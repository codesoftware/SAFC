package co.com.codesoftware.mb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import co.com.codesoftware.entities.DatosSessionEntity;
import co.com.codesoftware.logic.ConteosLogica;
import co.com.codesoftware.servicio.conteos.ConteoEntity;
import co.com.codesoftware.servicio.conteos.ProductoConteoEntity;
import co.com.codesoftware.servicio.conteos.RespuestaEntity;
import co.com.codesoftware.servicio.producto.PrecioProductoEntity;
import co.com.codesoftware.utilities.ConsultaSingleton;
import co.com.codesoftware.utilities.ErrorEnum;

@ManagedBean
@ViewScoped
public class ConteoProdBean {

	private PrecioProductoEntity producto;
	private List<PrecioProductoEntity> listaProductosGeneric;
	private List<PrecioProductoEntity> listaProductosGenericFiltro;
	private List<ConteoEntity> listaConteos;
	private ConteoEntity conteo;
	private DatosSessionEntity entitySession;
	private String codigoExterno;
	private Integer cantidad;
	private String codigoBarras;
	private ErrorEnum enumer;
	private String ubicacion;
	// Lista con los productos contados
	private List<ProductoConteoEntity> listaProdContados;

	/**
	 * Funcion con la cual se inicia todo los objetos necesarios para los
	 * conteos
	 */
	@PostConstruct
	public void init() {
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			this.entitySession = (DatosSessionEntity) context.getExternalContext().getSessionMap().get("dataSession");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Funcion que consulta los productos genericos
	 */
	public void buscaProductosGenericos() {
		try {
			ConsultaSingleton con = ConsultaSingleton.getInstance();
			listaProductosGeneric = con.consultaProductos(this.entitySession.getDataUser().getSede().getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Funcion con la cual se adiciona un producto
	 * 
	 * @param entidad
	 */
	public void addProductXCategoria(PrecioProductoEntity entidad) {
		try {
			this.codigoExterno = entidad.getProducto().getCodigoExt();
			this.producto = entidad;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Funcion con la cual se requiere buscar todos los conteos abiertos del
	 * sistema
	 */
	public void consultaConteosAbiertos() {
		ConteosLogica logica = new ConteosLogica();
		try {
			this.listaConteos = logica.consultaConteosAbiertos();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Funcion con la cual selecciono el conteo al cual le deseo hacer el conteo
	 */
	public void seleccionaConteo(ConteoEntity conteo) {
		try {
			this.conteo = conteo;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Funcion con la cual se adiciona un producto al conteo con cantidad
	 */
	public void adicionaProductosConteos() {
		try {
			if ("".contentEquals(codigoBarras) && "".equalsIgnoreCase(codigoExterno)) {
				this.setEnumer(ErrorEnum.ERROR);
				this.messageBean("No pueden ser vacios el codigo de barras y el codigo externo");
			} else if (conteo == null) {
				this.setEnumer(ErrorEnum.ERROR);
				this.messageBean("Por favor seleccione un conteo");
			} else {
				ConteosLogica logica = new ConteosLogica();
				RespuestaEntity rta = logica.adicionaConteo(codigoExterno, conteo.getId(), cantidad, codigoBarras,
						ubicacion);
				ProductoConteoEntity aux = logica.buscaProductoConteo(codigoExterno, conteo.getId());
				if (aux == null) {
					this.setEnumer(ErrorEnum.ERROR);
					this.messageBean("Error al buscar el producto en el conteo");
				} else {
					if (rta.getCodigoRespuesta() == 0) {
						this.setEnumer(ErrorEnum.SUCCESS);
						this.messageBean("Producto adicionado correctamente");
						if (this.listaProdContados == null) {
							this.listaProdContados = new ArrayList<>(50);
						}
						this.remplazaItemConteo(aux);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Funcion la cual remplaza un item del conteo
	 */
	public void remplazaItemConteo(ProductoConteoEntity aux) {
		try {
			if (this.listaProdContados != null) {
				Iterator<ProductoConteoEntity> it = this.listaProdContados.iterator();
				while (it.hasNext()) {
					if (aux.getProducto().getCodigoExt().equalsIgnoreCase(it.next().getProducto().getCodigoExt())) {
						it.remove();
					}
				}
			}else{
				this.listaProdContados = new ArrayList<>();
			}
			this.listaProdContados.add(0, aux);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Funcion con la cual busco todos los productos que tiene un conteo
	 */
	public void buscaTodoConteo() {
		try {
			if (conteo != null) {
				ConteosLogica logica = new ConteosLogica();
				this.listaProdContados = logica.buscaTodosLosProductosConteo(conteo.getId());
			} else {
				this.setEnumer(ErrorEnum.ERROR);
				this.messageBean("Error por favor seleccione un conteo");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Metodo generico para mostrar mensajes de error o advertencia
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

	public PrecioProductoEntity getProducto() {
		return producto;
	}

	public void setProducto(PrecioProductoEntity producto) {
		this.producto = producto;
	}

	public List<PrecioProductoEntity> getListaProductosGeneric() {
		return listaProductosGeneric;
	}

	public void setListaProductosGeneric(List<PrecioProductoEntity> listaProductosGeneric) {
		this.listaProductosGeneric = listaProductosGeneric;
	}

	public DatosSessionEntity getEntitySession() {
		return entitySession;
	}

	public void setEntitySession(DatosSessionEntity entitySession) {
		this.entitySession = entitySession;
	}

	public List<PrecioProductoEntity> getListaProductosGenericFiltro() {
		return listaProductosGenericFiltro;
	}

	public void setListaProductosGenericFiltro(List<PrecioProductoEntity> listaProductosGenericFiltro) {
		this.listaProductosGenericFiltro = listaProductosGenericFiltro;
	}

	public String getCodigoExterno() {
		return codigoExterno;
	}

	public void setCodigoExterno(String codigoExterno) {
		this.codigoExterno = codigoExterno;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public List<ConteoEntity> getListaConteos() {
		return listaConteos;
	}

	public void setListaConteos(List<ConteoEntity> listaConteos) {
		this.listaConteos = listaConteos;
	}

	public ConteoEntity getConteo() {
		return conteo;
	}

	public void setConteo(ConteoEntity conteo) {
		this.conteo = conteo;
	}

	public ErrorEnum getEnumer() {
		return enumer;
	}

	public void setEnumer(ErrorEnum enumer) {
		this.enumer = enumer;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public List<ProductoConteoEntity> getListaProdContados() {
		return listaProdContados;
	}

	public void setListaProdContados(List<ProductoConteoEntity> listaProdContados) {
		this.listaProdContados = listaProdContados;
	}

}
