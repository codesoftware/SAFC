package co.com.codesoftware.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import co.com.codesoftware.entities.DatosSessionEntity;
import co.com.codesoftware.logic.ProductsLogic;
import co.com.codesoftware.logic.SolicitudLogica;
import co.com.codesoftware.servicio.producto.ExistenciaXSedeEntity;
import co.com.codesoftware.servicio.producto.ProductoGenericoEntity;
import co.com.codesoftware.servicio.producto.ProductoSimpleEntity;
import co.com.codesoftware.servicio.producto.SedeEntity;
import co.com.codesoftware.servicio.producto.SolicitudEntity;
import co.com.codesoftware.servicio.producto.SolicitudProdEntity;
import co.com.codesoftware.servicio.producto.UsuarioEntity;
import co.com.codesoftware.utilities.Conversions;
import co.com.codesoftware.utilities.ErrorEnum;

@ManagedBean
@ViewScoped
public class SolicitudBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private SolicitudEntity solicitud;
	private SolicitudLogica logica;
	private DatosSessionEntity entitySession;
	private ErrorEnum enumer;
	private List<ProductoGenericoEntity> productosGenericos;
	private List<ProductoGenericoEntity> productosGenericosFilter;
	private List<SolicitudProdEntity> productosSolicitud;
	private List<ExistenciaXSedeEntity> listaExistencia;
	private String codigoExterno;
	private Integer cantidad;
	private Integer cantidadTotal;

	@PostConstruct
	public void init() {
		solicitud = new SolicitudEntity();
		logica = new SolicitudLogica();
		FacesMessage message = null;
		FacesContext context = FacesContext.getCurrentInstance();
		this.entitySession = (DatosSessionEntity) context.getExternalContext().getSessionMap().get("dataSession");

	}

	/**
	 * metodo que inserta una solicitud
	 */
	public void insertaSolicitud() {
		Conversions con = new Conversions();
		this.solicitud.setFecha(con.dateToXMLGC(new Date()));
		SedeEntity sede = new SedeEntity();
		sede.setId(this.entitySession.getSede().getId());
		sede.setName(this.entitySession.getSede().getName());
		this.solicitud.setSede(sede);
		UsuarioEntity usuario = new UsuarioEntity();
		usuario.setId(this.entitySession.getDataUser().getId());
		this.solicitud.setUsuario(usuario);
		this.solicitud.setEstado("C");
		// this.solicitud = logica.insertaSolicitud(this.solicitud);
		// this.productosSolicitud = new ArrayList<>();

	}

	/**
	 * Funcion con la cual busco los productos del sistema
	 */
	public void buscaProductosGenericos() {
		try {
			if (this.productosGenericos == null) {
				this.productosGenericos = new ArrayList<>();
				ProductsLogic logic = new ProductsLogic();
				this.productosGenericos = logic
						.buscaProductosAplicacionGenericos(this.entitySession.getDataUser().getSede().getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * metodo que agrega el producto a la lista
	 * 
	 * @param entidad
	 */
	public void seleccionaProducto(ProductoGenericoEntity entidad) {
		if (this.productosSolicitud == null) {
			this.productosSolicitud = new ArrayList<>();
		}
		this.codigoExterno = entidad.getCodigoExterno();
		if (cantidad != null && cantidad > 0) {
			consultaTotalExistencias(entidad.getId());
			if (this.cantidadTotal == null || this.cantidadTotal < 1 || this.cantidadTotal < this.cantidad) {
				this.setEnumer(enumer.ERROR);
				messageBean("No existe las cantidades solicitadas en el inventario. Las cantidades que existen: "
						+ this.cantidadTotal);
			} else {
				if (!verificaListaProducto(entidad)) {
					this.productosSolicitud.add(0, mapeaProducto(entidad));
					this.codigoExterno = "";
					this.cantidad = 0;
					this.enumer = enumer.SUCCESS;
					messageBean("Producto " + entidad.getCodigoExterno() + " ingresado correctamente");
				} else {
					this.enumer = enumer.ERROR;
					messageBean("Producto ya ingresado");
				}
			}
		} else {
			this.setEnumer(enumer.ERROR);
			messageBean("Debe ingresar una cantidad valida");
		}

	}

	public void seleccionaProductoTabla(String codigoExt) {
		this.codigoExterno = codigoExt;
		seleccionaProductoCodigoExt();
	}

	/**
	 * metodo que consulta un producto por su codigo externo
	 */
	public void seleccionaProductoCodigoExt() {
		ProductoGenericoEntity entidad = new ProductoGenericoEntity();
		try {
			entidad = logica.consultaProductoXCodigo(this.codigoExterno);
			if (entidad != null && entidad.getCodigoExterno() != null) {
				seleccionaProducto(entidad);
			} else {
				this.setEnumer(enumer.ERROR);
				messageBean("No se encuentra el producto con ese codigo");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * metodo que verifica si en la lista ya existe el producto
	 * 
	 * @param entidad
	 * @return
	 */
	public boolean verificaListaProducto(ProductoGenericoEntity entidad) {
		boolean respuesta = false;
		try {
			for (SolicitudProdEntity item : this.productosSolicitud) {
				if (item.getProducto().getCodigoExt().equalsIgnoreCase(entidad.getCodigoExterno())) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respuesta;
	}

	/**
	 * metodo que valida e inserta los productos de la solicitud
	 */
	public void validaProductos() {
		try {
			if (this.getProductosSolicitud() == null || this.productosSolicitud.isEmpty()) {
				this.enumer = ErrorEnum.ERROR;
				messageBean("Debe ingresar por lo menos un producto");
			} else if (this.solicitud == null || this.solicitud.getSede() == null) {
				this.enumer = ErrorEnum.ERROR;
				messageBean("Debe crear la solicitud");
			} else {
				SolicitudEntity sol = new SolicitudEntity();
				sol = logica.insertaSolicitud(this.solicitud);
				if (sol != null) {
					String mensaje = logica.ingresaProductosSolicitud(this.productosSolicitud, sol);
					if ("OK".equalsIgnoreCase(mensaje)) {
						this.enumer = ErrorEnum.SUCCESS;
						messageBean("INSERTO SOLICTUD CORRECTAMENTE");
						this.productosSolicitud = new ArrayList<>();
						this.solicitud = new SolicitudEntity();
						this.solicitud.setComentario("");
					} else {
						this.enumer = ErrorEnum.ERROR;
						messageBean(mensaje);
					}
				}else{
					this.enumer = ErrorEnum.ERROR;
					messageBean("Error al insertar solicitud");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * metodo que recorre la lista
	 * 
	 * @param idProducto
	 */
	public void recorreLista(Integer idProducto) {
		for (SolicitudProdEntity item : this.productosSolicitud) {
			if (item.getProducto().getId() == idProducto) {
				item.setCantidadSolicitada(item.getCantidadSede());
				break;
			}
		}
	}

	/**
	 * metodo que mapea el producto generico a el producto de la solicitud
	 * 
	 * @param entidad
	 * @return
	 */
	public SolicitudProdEntity mapeaProducto(ProductoGenericoEntity entidad) {
		SolicitudProdEntity objetoProd = new SolicitudProdEntity();
		try {
			ProductoSimpleEntity prod = new ProductoSimpleEntity();
			prod.setId(0);
			prod.setId(entidad.getId());
			prod.setNombre(entidad.getNombre());
			prod.setCodigoExt(entidad.getCodigoExterno());
			objetoProd.setProducto(prod);
			objetoProd.setSolicitud(this.solicitud);
			objetoProd.setCantidadSolicitada(this.cantidad);
			objetoProd.setCantidadEnvidada(0);
			objetoProd.setCantidadSede(logica.consultaCantidadesXId(entidad.getId()));
			SedeEntity sede = new SedeEntity();
			sede.setId(1);
			objetoProd.setSedeProducto(sede);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objetoProd;
	}

	/**
	 * metodo que elimina un producto de la solicitud
	 * 
	 * @param codigoExterno
	 */
	public void eliminaProducto(String codigoExterno) {
		for (SolicitudProdEntity item : this.productosSolicitud) {
			if (item.getProducto().getCodigoExt().equalsIgnoreCase(codigoExterno)) {
				this.productosSolicitud.remove(item);
				break;
			}
		}
	}

	/**
	 * metodo que consulta las existencias en todas la sedes
	 * 
	 * @param idProducto
	 * @return
	 */

	public void consultaExistenciaSedes(Integer idProducto) {
		this.listaExistencia = logica.consultaExistenciasXId(idProducto);
	}

	public void consultaTotalExistencias(Integer idProducto) {
		this.cantidadTotal = logica.consultaExistenciasTotales(idProducto);
	}

	public SolicitudEntity getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(SolicitudEntity solicitud) {
		this.solicitud = solicitud;
	}

	public DatosSessionEntity getEntitySession() {
		return entitySession;
	}

	public void setEntitySession(DatosSessionEntity entitySession) {
		this.entitySession = entitySession;
	}

	public ErrorEnum getEnumer() {
		return enumer;
	}

	public void setEnumer(ErrorEnum enumer) {
		this.enumer = enumer;
	}

	public List<SolicitudProdEntity> getProductosSolicitud() {
		return productosSolicitud;
	}

	public void setProductosSolicitud(List<SolicitudProdEntity> productosSolicitud) {
		this.productosSolicitud = productosSolicitud;
	}

	public List<ProductoGenericoEntity> getProductosGenericos() {
		return productosGenericos;
	}

	public void setProductosGenericos(List<ProductoGenericoEntity> productosGenericos) {
		this.productosGenericos = productosGenericos;
	}

	public List<ExistenciaXSedeEntity> getListaExistencia() {
		return listaExistencia;
	}

	public void setListaExistencia(List<ExistenciaXSedeEntity> listaExistencia) {
		this.listaExistencia = listaExistencia;
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

	public List<ProductoGenericoEntity> getProductosGenericosFilter() {
		return productosGenericosFilter;
	}

	public void setProductosGenericosFilter(List<ProductoGenericoEntity> productosGenericosFilter) {
		this.productosGenericosFilter = productosGenericosFilter;
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

}
