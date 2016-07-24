package co.com.codesoftware.mb;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Date;
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
import co.com.codesoftware.logic.FacturacionLogic;
import co.com.codesoftware.logic.PedidosLogic;
import co.com.codesoftware.logic.ProductosHomeLogic;
import co.com.codesoftware.logic.ProductsLogic;
import co.com.codesoftware.logic.SearchTopLogic;
import co.com.codesoftware.mapeos.PedidoToUsuarioMp;
import co.com.codesoftware.mapeos.UsuarioToPedidoMp;
import co.com.codesoftware.services.CargaProductosService;
import co.com.codesoftware.servicio.pedido.ClienteEntity;
import co.com.codesoftware.servicio.pedido.PedidoEntity;
import co.com.codesoftware.servicio.pedido.ProductoGenEntity;
import co.com.codesoftware.servicio.pedido.RespuestaEntity;
import co.com.codesoftware.servicio.pedido.RespuestaPedidoEntity;
import co.com.codesoftware.servicio.producto.ExistenciaXSedeEntity;
import co.com.codesoftware.servicio.producto.PrecioProductoEntity;
import co.com.codesoftware.servicio.producto.ProductoEntity;
import co.com.codesoftware.servicio.producto.ProductoGenericoEntity;
import co.com.codesoftware.servicio.producto.PromPonderaEntity;
import co.com.codesoftware.utilities.ConsultaSingleton;
import co.com.codesoftware.utilities.ErrorEnum;

@ManagedBean(name = "pedidosBean")
@ViewScoped
public class PedidosBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<PrecioProductoEntity> listaProductos;
	private List<PrecioProductoEntity> listaProductosFiltro;
	private List<PrecioProductoEntity> listaProductosGeneric;
	private List<PrecioProductoEntity> listaProductosGenericFiltro;
	private List<ProductoGenericoEntity> productosGenericos;
	private List<ProductoGenericoEntity> productosFilter;
	// Lista en la cual se guardan las existencias de un producto
	private List<ExistenciaXSedeEntity> prodExistencias;
	private PromPonderaEntity prodPromPond;
	private List<ClienteEntity> clientes;
	private List<ClienteEntity> clientesFilter;
	private ClienteEntity cliente;
	private Integer clienteId;
	private CargaProductosService service;
	private List<GenericProductEntity> listPedi;
	private List<GenericProductEntity> listPediMod;
	private BigDecimal valorTotal;
	private ErrorEnum enumer;
	private String idFacturaAbrir;
	private String banderaPDF = "Error";
	private DatosSessionEntity entitySession;
	private GenericProductEntity product;
	private MathContext mc;
	private Integer cantidadProd;
	private String codigoExterno;
	private String codigoApp;
	private Integer cantidad;
	private BigDecimal precioNuevo;
	private GenericProductEntity productoModificar;
	private PrecioProductoEntity productoConsulta;
	private List<ExistenciaXSedeEntity> cantidadesSedes;
	private String mensajeExistencias;
	private List<PedidoEntity> pedidos;
	private Date fechaInicial;
	private Date fechaFinal;
	private Integer tipoPedido;
	private RespuestaPedidoEntity pedidoRespuesta;
	private Integer idPedido;
	private String codigoBarras;

	private Integer idCotizacion;

	@PostConstruct
	public void init() {
		mc = new MathContext(5);
		// panel1Categoria = cargaCategoria1();
		// panel2Categoria = cargaCategoria2();
		try {
			FacesMessage message = null;
			FacesContext context = FacesContext.getCurrentInstance();
			this.entitySession = (DatosSessionEntity) context.getExternalContext().getSessionMap().get("dataSession");
			if (entitySession == null) {
				message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error",
						"Esta intentando a un sitio no permitido porfavor realice el login primero");
				context.getExternalContext().redirect("../index.jsf");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// ------------------------------------------------------------------
	// ------------PRODUCTOS----------------------------------------------
	// /**
	// * metodo que consulta las subcategorias de la categoria 1
	// *
	// * @return
	// */
	// public List<ProductosHomeEntity> cargaCategoria1() {
	// List<ProductosHomeEntity> lista = null;
	// try {
	// if (service == null) {
	// service = new CargaProductosService();
	// }
	// lista = service.consultaReferencias(3);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return lista;
	//
	// }

	// /**
	// * metodo que consulta las subcategorias de la categoria 1
	// *
	// * @return
	// */
	// public List<ProductosHomeEntity> cargaCategoria2() {
	// List<ProductosHomeEntity> lista = null;
	// try {
	// if (service == null) {
	// service = new CargaProductosService();
	// }
	// lista = service.consultaReferencias2(4);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return lista;
	//
	// }

	/**
	 * metodo que consulta los productos por referencia
	 * 
	 * @return
	 */

	public void consultaProductosXReferencia(Integer referencia) {
		try {
			// ProductosHomeLogic logic = new ProductosHomeLogic();
			// this.listaProductos =
			// logic.consultaProductosXReferencia(referencia);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void consultaProductosXSede() {
		try {
			ProductosHomeLogic logic = new ProductosHomeLogic();
			this.listaProductos = logic.consultaProductosXSede(entitySession.getDataUser().getSede().getId());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Funcion que agrega los prodcutos desde la busqueda de subcaegorias al
	 * home
	 * 
	 * @param entidad
	 */
	public void addProductXCategoria(PrecioProductoEntity entidad) {
		this.listaProductosFiltro = null;
		this.listaProductosGenericFiltro = null;
		if (this.listPedi == null) {
			this.listPedi = new ArrayList<GenericProductEntity>();
		}
		if (this.valorTotal == null) {
			valorTotal = new BigDecimal(0);
		}
		PedidosLogic logic = new PedidosLogic();
		if (logic.consultaExistenciasProducto(entidad, entitySession.getDataUser().getSede().getId(), 1) < 0) {
			mensajeExistencias = "El Producto no tiene las existencias disponibles, EXISTENCIAS 0";
			cantidadesSedes = logic.consultaCantidadesProd(entidad.getProducto().getId());
			RequestContext context = RequestContext.getCurrentInstance();
			context.execute("PF('verExistencias').show();");

		} else {
			convierteObjGenericoProd(entidad, 1);
		}
	}

	/**
	 * Funcion que convierte a objeto generico el objeto de precioProducto
	 * 
	 * @param entidad
	 * @return
	 */
	public void convierteObjGenericoProd(PrecioProductoEntity entidad, Integer cantidad) {
		GenericProductEntity rta = new GenericProductEntity();
		BigDecimal price = entidad.getPrecioIva();
		Integer index = 0;
		Integer bandera = 0;
		try {
			if (listPedi == null) {
				listPedi = new ArrayList<>();
			}
			if (this.valorTotal == null) {
				this.valorTotal = new BigDecimal("0");
			}
			if (cantidad == 0) {
				cantidad = 1;
			}
			if (listPedi.size() != 0) {
				for (GenericProductEntity item : listPedi) {
					if (item.getCode().equalsIgnoreCase(entidad.getProducto().getCodigo())) {
						listPedi.get(index).setAmount(item.getAmount() + cantidad);
						BigDecimal aux = price.multiply(new BigDecimal(cantidad));
						listPedi.get(index).setTotalPrice(item.getTotalPrice().add(aux));
						bandera = 1;
						this.valorTotal = valorTotal.add(price);
					}
					index++;

				}
				if (bandera == 0) {
					rta.setAmount(cantidad);
					rta.setCode(entidad.getProducto().getCodigo());
					rta.setName(entidad.getProducto().getDescripcion());
					rta.setPrice(price);
					BigDecimal aux = price.multiply(new BigDecimal(cantidad));
					rta.setTotalPrice(aux);
					rta.setId(entidad.getProducto().getId());
					rta.setPrecioXCien(entidad.getPrecioXCien());
					rta.setPrecioXUnidad(entidad.getPrecioXUnidad());
					rta.setPrecioXMil(entidad.getPrecioXMil());
					listPedi.add(0, rta);
					this.valorTotal = valorTotal.add(aux);
				}
			} else {
				rta.setAmount(cantidad);
				rta.setCode(entidad.getProducto().getCodigo());
				rta.setName(entidad.getProducto().getDescripcion());
				rta.setPrice(price);
				BigDecimal aux = price.multiply(new BigDecimal(cantidad));
				rta.setTotalPrice(aux);
				rta.setId(entidad.getProducto().getId());
				rta.setPrecioXCien(entidad.getPrecioXCien());
				rta.setPrecioXUnidad(entidad.getPrecioXUnidad());
				rta.setPrecioXMil(entidad.getPrecioXMil());
				listPedi.add(0, rta);
				valorTotal = valorTotal.add(aux);
				cantidad = 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Funcion que se encarga de realizar la accion de pedidos
	 * @param estado
	 */
	public void insertaPedido(String estado) {
		// falta consultar por sesion el usuario y la sede
		try {
			PedidosLogic logica = new PedidosLogic();
			if (cliente.getId() == null || cliente.getId() == 0) {
				this.setEnumer(enumer.ERROR);
				messageBean("El cliente no puede ir nulo");
			} else {
				Integer rta = 0;
				Integer cantidades = 0;
				String producto = "";
				Integer produc = 0;
				PedidosLogic logicPedido = new PedidosLogic();
				for (GenericProductEntity item : this.listPedi) {
					PrecioProductoEntity entity = new PrecioProductoEntity();
					ProductoEntity prod = new ProductoEntity();
					prod.setId(item.getId());
					entity.setProducto(prod);
					rta = logicPedido.consultaExistenciasProducto(entity, entitySession.getDataUser().getSede().getId(),
							new Integer(item.getAmount()));
					produc = entity.getProducto().getId();
					if (rta < 0) {
						cantidades = rta + item.getAmount();
						producto = item.getName();
						break;
					}
				}
				if (rta >= 0) {
					boolean eliminaPedido = true;
					if (idPedido != null && idPedido != 0) {
						eliminaPedido = logica.eliminaPedidoId(this.idPedido);
					}
					idPedido = null;
					if (eliminaPedido) {
						RespuestaEntity respuesta = logica.insertaPedidoProducto(this.listPedi,
								entitySession.getDataUser().getSede().getId(), entitySession.getDataUser().getId(),
								new Integer(Integer.valueOf(this.cliente.getId().intValue())), estado);

						if ("CR".equalsIgnoreCase(estado)) {
							this.setEnumer(enumer.SUCCESS);
							messageBean(respuesta.getMensajeRespuesta());
							limpiaBean();
							generaPdfPedido(respuesta.getCodigoRespuesta());
						} else if ("GU".equalsIgnoreCase(estado)) {
							this.setEnumer(enumer.SUCCESS);
							messageBean("Pedido Guardado correctamente");
							limpiaBean();
							generaPdfPedido(respuesta.getCodigoRespuesta());
						} else if ("CO".equalsIgnoreCase(estado)) {
							this.setEnumer(enumer.SUCCESS);
							messageBean("Cotizacion Creada correctamente");
							limpiaBean();
							this.generaPdfCotizacion(respuesta.getCodigoRespuesta());
						} else if ("SR".equalsIgnoreCase(estado)){
							this.setEnumer(enumer.SUCCESS);
							messageBean("Solicitud de remision generada correctamente");
							limpiaBean();
						}
					} else {
						mensajeExistencias = "El producto " + producto + " Contiene Solo " + cantidades
								+ " En esta sede";
						cantidadesSedes = logicPedido.consultaCantidadesProd(produc);
						RequestContext context = RequestContext.getCurrentInstance();
						context.execute("PF('verExistencias').show();");
					}
				} else {
					messageBean("Error al borrar el pedido");
				}
			}
		} catch (Exception e) {
			this.setEnumer(enumer.ERROR);
			messageBean("Los datos no pueden ir vacios.");
			e.printStackTrace();
		}

	}

	/**
	 * Funcion que limpia el bean despues de cualquier bean
	 */
	public void limpiaBean() {
		this.cliente = new ClienteEntity();
		this.listPedi = new ArrayList<GenericProductEntity>();
		this.valorTotal = new BigDecimal(0);
		this.idPedido = null;
	}

	/**
	 * Funcion que muestra el pdf de codigo de barras del pedido
	 */
	public void generaPdfPedido(Integer idPedido) {
		PedidosLogic logica = new PedidosLogic();
		String respuesta = logica.generarPdfXIdPedi(idPedido);
		if (respuesta.equalsIgnoreCase("OK")) {
			idFacturaAbrir = idPedido.toString();
			banderaPDF = "Ok";
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
				banderaPDF = "Ok";
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
	 * Funcion que selecciona un producto generico desde la consulta
	 * 
	 * @param producto
	 */
	public void seleccionarProductoGenerico(ProductoGenericoEntity producto) {
		try {
			this.product = new GenericProductEntity();
			if (this.listPedi == null) {
				this.listPedi = new ArrayList<GenericProductEntity>();
			}
			this.product = setDataEntityGeneric(producto);
			int exist = existProduct();

			if (exist > -1) {
				this.listPedi.get(exist).setAmount(this.listPedi.get(exist).getAmount() + 1);
				this.listPedi.get(exist).setTotalPrice(this.listPedi.get(exist).getPrice()
						.multiply(new BigDecimal(this.listPedi.get(exist).getAmount()), mc));
			} else {
				product.setTotalPrice(producto.getPrecio());
				this.listPedi.add(0, product);
			}
			addTotal();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Funcion con la cual paso un objeto tipo producto a un objeto entity
	 * 
	 * @param prod
	 * @return
	 */
	public GenericProductEntity setDataEntityGeneric(ProductoGenericoEntity prod) {
		GenericProductEntity genProduct = new GenericProductEntity();
		genProduct.setAmount(1);
		genProduct.setCode(prod.getCodigo());
		genProduct.setId(prod.getId());
		genProduct.setName(prod.getNombre());
		genProduct.setPrice(prod.getPrecio());
		genProduct.setPrice(prod.getPrecio());
		return genProduct;
	}

	public int existProduct() {
		int result = -1;
		if (listPedi == null) {
			listPedi = new ArrayList<GenericProductEntity>();
		}
		for (int i = 0; i < this.listPedi.size(); i++) {
			if (this.listPedi.get(i).getCode().equalsIgnoreCase(product.getCode())) {
				result = i;
				i = this.listPedi.size();
			}
		}
		return result;
	}

	/**
	 * metodo que modifica el precio de un producto
	 */
	public void addTotal() {
		BigDecimal result = new BigDecimal("0");
		if (this.listPedi.size() == 0) {
			this.valorTotal = new BigDecimal(0);
		}
		FacturacionLogic factuacionLogic = new FacturacionLogic();

		for (int i = 0; i < this.listPedi.size(); i++) {

			BigDecimal aux = factuacionLogic.updatePrice(this.listPedi.get(i).getPrice(),
					this.listPedi.get(i).getAmount());
			if (aux.intValue() == 0) {
				this.setEnumer(ErrorEnum.ERROR);
				messageBean("Producto sin parametrizar precio.");
			} else {
				result = result.add(aux);
				this.valorTotal = result;
			}
		}

	}

	/**
	 * Funcion que elimina una fila de la factura
	 * 
	 * @param prod
	 */
	public void deleteRow(GenericProductEntity prod) {
		this.listPedi.remove(prod);
		addTotal();
	}

	/**
	 * funcion que actualiza la cantidad de productos
	 * 
	 * @param prod
	 */
	public void updateRow(GenericProductEntity prod) {
		if (prod.getAmount() < 2) {
			this.listPedi.remove(prod);
		} else {
			FacturacionLogic log = new FacturacionLogic();
			prod.setAmount(prod.getAmount() - 1);
			prod.setTotalPrice(log.updatePrice(prod.getPrice(), prod.getAmount()));
		}
		addTotal();
	}

	/**
	 * funcion que anade las cantidades del producto
	 * 
	 * @param prod
	 */
	public void updateRowProd() {
		FacturacionLogic log = new FacturacionLogic();
		this.productoModificar.setAmount(this.productoModificar.getAmount() + this.cantidadProd);
		this.productoModificar
				.setTotalPrice(log.updatePrice(this.productoModificar.getPrice(), this.productoModificar.getAmount()));
		PedidosLogic logicaPed = new PedidosLogic();
		addTotal();
		listPedi = logicaPed.actualizaProductos(listPedi, this.productoModificar);

	}

	public void searchProdId() {
		FacturacionLogic log = new FacturacionLogic();
		if (log.validateCodigo(codigoApp)) {
			ProductsLogic prod = new ProductsLogic();
			if (codigoApp.startsWith("1-")) {
				if (cantidad == null) {
					cantidad = 1;
				}
				product = prod.getProductXCode(codigoApp, cantidad, this.entitySession);
			} else if (codigoApp.startsWith("3-")) {
				product = prod.getRecetaForCode(codigoApp, cantidad, this.entitySession);
			}
			if (product == null) {
				this.setEnumer(ErrorEnum.ERROR);
				messageBean("Producto inexistente.");
			}
		} else {
			this.setEnumer(ErrorEnum.ERROR);
			messageBean("Codigo del producto incorrecto.");
		}
	}

	public void addProductFact() {
		if (this.listPedi == null) {
			this.listPedi = new ArrayList<GenericProductEntity>();
		}
		FacturacionLogic log = new FacturacionLogic();
		// Verifica si el codigo esta correcto
		if (log.validateCodigo(codigoApp)) {
			// Verifica si la cantidad esta correcta
			if (log.validateCantidad(cantidad)) {
				int exist = existProduct();
				if (exist > -1) {
					this.listPedi.get(exist).setAmount(this.listPedi.get(exist).getAmount() + cantidad);
					if (log.updatePrice(this.listPedi.get(exist).getPrice(),
							this.listPedi.get(exist).getAmount()) == null) {
						this.setEnumer(ErrorEnum.ERROR);
						messageBean("Al producto no se le ha parametrizado el precio");
					} else {
						this.listPedi.get(exist).setTotalPrice(log.updatePrice(this.listPedi.get(exist).getPrice(),
								this.listPedi.get(exist).getAmount()));
					}
				} else {
					product.setAmount(this.cantidad);
					product.setTotalPrice(product.getPrice().multiply(new BigDecimal(cantidad), mc));
					// product.setTotalPrice(String.valueOf(Double.parseDouble(product.getPrice())
					// * this.cantidad));
					this.listPedi.add(0, product);
				}
				addTotal();

			} else {
				this.setEnumer(ErrorEnum.ERROR);
				messageBean("Digite cantidad valida");
			}

		} else {
			this.setEnumer(ErrorEnum.ERROR);
			messageBean("Codigo invalido");
		}
	}

	/**
	 * Funcion que cambia el precio nuevo
	 * 
	 * @param precio
	 */

	public void cambiaPrecioNuevo(BigDecimal precio) {
		if (this.precioNuevo == null) {
			this.precioNuevo = new BigDecimal(0);
		}
		this.precioNuevo = precio;

		updatePrice();
	}

	/**
	 * metodo que actualiza el precio de un producto
	 */
	public void updatePrice() {
		PedidosLogic pedi = new PedidosLogic();
		String rta = pedi.consultaPromedioPonderado(this.productoModificar.getId(), this.precioNuevo);
		if ("OK".equalsIgnoreCase(rta)) {
			FacturacionLogic log = new FacturacionLogic();
			PedidosLogic logicaPed = new PedidosLogic();
			this.productoModificar.setPrice(this.precioNuevo);
			this.productoModificar.setTotalPrice(
					log.updatePrice(this.productoModificar.getPrice(), this.productoModificar.getAmount()));
			RequestContext context = RequestContext.getCurrentInstance();
			context.execute("PF('cambioPrecio').hide();");
			addTotal();
			listPedi = logicaPed.actualizaProductos(listPedi, this.productoModificar);
			this.precioNuevo = new BigDecimal(0);
		} else {
			this.setEnumer(ErrorEnum.ERROR);
			messageBean(rta);
		}

	}

	/**
	 * metodo en el cual se almacena el producto que se debe modificar
	 * 
	 * @param prod
	 */
	public void guardaObjeto(GenericProductEntity prod) {
		if (this.productoModificar == null) {
			this.productoModificar = new GenericProductEntity();
		}
		this.productoModificar = prod;
		this.precioNuevo = new BigDecimal(0);
	}

	public void guardaObjetoPrecios(GenericProductEntity prod) {
		if (this.productoModificar == null) {
			this.productoModificar = new GenericProductEntity();
		}
		this.productoModificar = prod;
	}

	// --------------------------------------------------------------
	// --------------------CLIENTES---------------------------------
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

	// /**
	// * Funcion que setea los datos de los dos diferentes objetos
	// *
	// * @param entity
	// * @return
	// */
	//
	// public ClienteEntity setDataEntity(ClienteEntity entity) {
	// ClienteEntity cliente = new ClienteEntity();
	// cliente.setId(entity.getId());
	// cliente.setApellido(entity.getApellidos());
	// cliente.setCedula(entity.getCedula());
	// cliente.setCorreo(entity.getCorreo());
	// cliente.setNombre(entity.getNombres());
	// cliente.setTelefono(entity.getTelefono());
	// cliente.setDireccion(entity.getDireccion());
	// return cliente;
	// }

	/**
	 * Funcion encargada de Buscar los cliente del sistema
	 */
	public void buscaClientes() {
		try {
			clientes = new ArrayList<ClienteEntity>();
			SearchTopLogic logic = new SearchTopLogic();
			clientes = UsuarioToPedidoMp.clienteEntityLsMp(logic.searchClient());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Funcion encargada de insertar un cliente en la base de datos del sistema
	 */
	public void addCliente() {
		SearchTopLogic logic = new SearchTopLogic();
		this.clienteId = logic.getLogicAddClient(PedidoToUsuarioMp.clienteEntityMp(cliente));
		if (this.clienteId != null) {
			this.cliente.setId(clienteId);
			RequestContext.getCurrentInstance().execute("PF('insertClient').hide()");
		} else {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No Inserto Correctamente", "Error");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}

	}

	// public Cliente setData(ClienteEntity entity) {
	// Cliente cliente = new Cliente();
	// cliente.setId(null);
	// cliente.setApellidos(entity.getApellido());
	// cliente.setCedula(entity.getCedula());
	// cliente.setCorreo(entity.getCorreo());
	// cliente.setNombres(entity.getNombre());
	// cliente.setTelefono(entity.getTelefono());
	// cliente.setDireccion(entity.getDireccion());
	// return cliente;
	// }

	/**
	 * Funcion con la cual actualizo el cliente
	 * 
	 * @param cliente
	 */
	public void updatecliente() {
		try {
			ClienteLogic logic = new ClienteLogic();
			boolean valida = logic.updateCliente(PedidoToUsuarioMp.clienteEntityMp(this.cliente));
			if (valida) {
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ok",
						"Cliente Actualizado correctamente");
				FacesContext.getCurrentInstance().addMessage(null, message);
				RequestContext.getCurrentInstance().execute("PF('actualizarClient').hide()");
			} else {
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al actualizar el Cliente",
						"Error");
				FacesContext.getCurrentInstance().addMessage(null, message);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// public Cliente setDataWithId(ClienteEntity entity) {
	// Cliente cliente = new Cliente();
	// cliente.setId(entity.getId());
	// cliente.setApellidos(entity.getApellido());
	// cliente.setCedula(entity.getCedula());
	// cliente.setCorreo(entity.getCorreo());
	// cliente.setNombres(entity.getNombre());
	// cliente.setTelefono(entity.getTelefono());
	// cliente.setDireccion(entity.getDireccion());
	// return cliente;
	// }

	/**
	 * Funcion con la cual busca un producto por medio de su codigo externo
	 */
	public void buscaProductoPorCodExterno() {
		ProductsLogic objLogic = new ProductsLogic();
		try {
			this.productoConsulta = objLogic.consultaProductoCodExt(codigoExterno,
					this.entitySession.getDataUser().getSede().getId());
			if (this.productoConsulta == null) {
				this.setEnumer(ErrorEnum.ERROR);
				messageBean(
						"No existe ningun Producto con el exacto proporcionado, Por favor ingrese otro e intente de nuevo");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Funcion con la cual con el producto obtenida de la consulta por codigo
	 * externo adiciona a la lista de pedidos
	 */
	public void adicionaProductoLista() {
		try {
			convierteObjGenericoProd(productoConsulta, cantidad);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * funcion que consulta el pedido del usuario dependiendo del estado
	 */
	public void consultaPedidosXEstado() {
		try {
			String estado = "";
			if (this.tipoPedido == 4)
				estado = "CA";
			if (this.tipoPedido == 3)
				estado = "GU";
			if (this.tipoPedido == 2)
				estado = "FA";
			if (this.tipoPedido == 1)
				estado = "CR";
			PedidosLogic logica = new PedidosLogic();
			this.pedidos = logica.consultaPedidosFiltros(this.fechaInicial, this.fechaFinal, estado,
					this.entitySession.getDataUser().getId());
			if(this.pedidos == null || this.pedidos.size() == 0){
				this.setEnumer(ErrorEnum.ERROR);
				this.messageBean("La consulta no arrojo ningun resultado");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * funcion que resetea la consulta de pedidos
	 */
	public void resetConsultaPedidos() {
		this.pedidos = null;
	}

	/**
	 * Funcion que consulta un pedido dependiendo del estado para facturar
	 * 
	 * @param pedido
	 */
	public void addPedidoHome(PedidoEntity pedido) {
		limpiaBean();
		if (pedido.getEstado().equalsIgnoreCase("FA")) {
			this.setEnumer(enumer.ERROR);
			messageBean("Este pedido ya no se puede modificar.");
		} else {
			PedidosLogic logic = new PedidosLogic();
			this.pedidoRespuesta = logic.consultaPedidoLogica(pedido.getId());
			// Se mapean los objetos
			this.idPedido = pedido.getId();
			this.cliente = this.pedidoRespuesta.getCliente();
			mapeaEntidadesProd(this.pedidoRespuesta.getListaProductos());
			RequestContext context = RequestContext.getCurrentInstance();
			context.execute("PF('consultaPedidosXEstado').hide();");
			this.setEnumer(enumer.SUCCESS);
			messageBean("Pedido cargado Correctamente.");
		}
	}

	// public void mapeaCliente(Cliente clienteEntity) {
	// this.cliente = new ClienteEntity();
	// this.cliente.setApellido(clienteEntity.getApellidos());
	// this.cliente.setCedula(clienteEntity.getCedula());
	// this.cliente.setCorreo("");
	// this.cliente.setDireccion(clienteEntity.getDireccion());
	// this.cliente.setId(clienteEntity.getId());
	// this.cliente.setNombre(clienteEntity.getNombres());
	// this.cliente.setTelefono(clienteEntity.getTelefono());
	//
	// }

	public void mapeaEntidadesProd(List<ProductoGenEntity> productos) {
		listPedi = new ArrayList<GenericProductEntity>();
		for (ProductoGenEntity item : productos) {
			GenericProductEntity entidad = new GenericProductEntity();
			entidad.setAmount(item.getAmount());
			entidad.setCode(item.getCode());
			entidad.setId(item.getId());
			entidad.setName(item.getName());
			entidad.setPrice(item.getPrice());
			entidad.setTotalPrice(item.getTotalPrice());
			if (this.valorTotal == null)
				this.valorTotal = new BigDecimal(0);
			this.valorTotal = this.valorTotal.add(item.getTotalPrice());
			entidad.setRoutImage("");
			entidad.setType(item.getType());
			listPedi.add(0, entidad);

		}
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

	public CargaProductosService getService() {
		return service;
	}

	public void setService(CargaProductosService service) {
		this.service = service;
	}

	public List<PrecioProductoEntity> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(List<PrecioProductoEntity> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public List<PrecioProductoEntity> getListaProductosFiltro() {
		return listaProductosFiltro;
	}

	public void setListaProductosFiltro(List<PrecioProductoEntity> listaProductosFiltro) {
		this.listaProductosFiltro = listaProductosFiltro;
	}

	public ClienteEntity getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}

	public List<GenericProductEntity> getListPedi() {
		return listPedi;
	}

	public void setListPedi(List<GenericProductEntity> listPedi) {
		this.listPedi = listPedi;
	}

	// constructor
	public PedidosBean() {
		cliente = new ClienteEntity();
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public ErrorEnum getEnumer() {
		return enumer;
	}

	public void setEnumer(ErrorEnum enumer) {
		this.enumer = enumer;
	}

	public String getIdFacturaAbrir() {
		return idFacturaAbrir;
	}

	public void setIdFacturaAbrir(String idFacturaAbrir) {
		this.idFacturaAbrir = idFacturaAbrir;
	}

	public String getBanderaPDF() {
		return banderaPDF;
	}

	public void setBanderaPDF(String banderaPDF) {
		this.banderaPDF = banderaPDF;
	}

	public DatosSessionEntity getEntitySession() {
		return entitySession;
	}

	public void setEntitySession(DatosSessionEntity entitySession) {
		this.entitySession = entitySession;
	}

	public List<ProductoGenericoEntity> getProductosGenericos() {
		return productosGenericos;
	}

	public void setProductosGenericos(List<ProductoGenericoEntity> productosGenericos) {
		this.productosGenericos = productosGenericos;
	}

	public List<ProductoGenericoEntity> getProductosFilter() {
		return productosFilter;
	}

	public void setProductosFilter(List<ProductoGenericoEntity> productosFilter) {
		this.productosFilter = productosFilter;
	}

	public GenericProductEntity getProduct() {
		return product;
	}

	public void setProduct(GenericProductEntity product) {
		this.product = product;
	}

	public MathContext getMc() {
		return mc;
	}

	public void setMc(MathContext mc) {
		this.mc = mc;
	}

	public Integer getCantidadProd() {
		return cantidadProd;
	}

	public void setCantidadProd(Integer cantidadProd) {
		this.cantidadProd = cantidadProd;
	}

	public String getCodigoExterno() {
		return codigoExterno;
	}

	public void setCodigoExterno(String codigoExterno) {
		this.codigoExterno = codigoExterno;
	}

	public String getCodigoApp() {
		return codigoApp;
	}

	public void setCodigoApp(String codigoApp) {
		this.codigoApp = codigoApp;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getPrecioNuevo() {
		return precioNuevo;
	}

	public void setPrecioNuevo(BigDecimal precioNuevo) {
		this.precioNuevo = precioNuevo;
	}

	public List<PrecioProductoEntity> getListaProductosGeneric() {
		return listaProductosGeneric;
	}

	public void setListaProductosGeneric(List<PrecioProductoEntity> listaProductosGeneric) {
		this.listaProductosGeneric = listaProductosGeneric;
	}

	public List<PrecioProductoEntity> getListaProductosGenericFiltro() {
		return listaProductosGenericFiltro;
	}

	public void setListaProductosGenericFiltro(List<PrecioProductoEntity> listaProductosGenericFiltro) {
		this.listaProductosGenericFiltro = listaProductosGenericFiltro;
	}

	public GenericProductEntity getProductoModificar() {
		return productoModificar;
	}

	public void setProductoModificar(GenericProductEntity productoModificar) {
		this.productoModificar = productoModificar;
	}

	public List<GenericProductEntity> getListPediMod() {
		return listPediMod;
	}

	public void setListPediMod(List<GenericProductEntity> listPediMod) {
		this.listPediMod = listPediMod;
	}

	public PrecioProductoEntity getProductoConsulta() {
		return productoConsulta;
	}

	public void setProductoConsulta(PrecioProductoEntity productoConsulta) {
		this.productoConsulta = productoConsulta;
	}

	public String getMensajeExistencias() {
		return mensajeExistencias;
	}

	public void setMensajeExistencias(String mensajeExistencias) {
		this.mensajeExistencias = mensajeExistencias;
	}

	public List<PedidoEntity> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<PedidoEntity> pedidos) {
		this.pedidos = pedidos;
	}

	public Date getFechaInicial() {
		return fechaInicial;
	}

	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	public Date getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public Integer getTipoPedido() {
		return tipoPedido;
	}

	public void setTipoPedido(Integer tipoPedido) {
		this.tipoPedido = tipoPedido;
	}

	public RespuestaPedidoEntity getPedidoRespuesta() {
		return pedidoRespuesta;
	}

	public void setPedidoRespuesta(RespuestaPedidoEntity pedidoRespuesta) {
		this.pedidoRespuesta = pedidoRespuesta;
	}

	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	/**
	 * Funcion con la cual se buscan las existencias de un producto dentro de
	 * todas las sedes
	 * 
	 * @param entidad
	 */
	public void existenciasProd(PrecioProductoEntity entidad) {
		try {
			ProductsLogic objLogic = new ProductsLogic();
			this.prodExistencias = objLogic.buscaExistenciasProducto(entidad.getProducto().getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Funcion con la cual se busca el promedio ponderado de un producto
	 * 
	 * @param entidad
	 */
	public void promPonderadoprod(PrecioProductoEntity entidad) {
		try {
			ProductsLogic objLogic = new ProductsLogic();
			this.prodPromPond = objLogic.buscaPromedioPonderadoProducto(entidad.getProducto().getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Integer getIdCotizacion() {
		return idCotizacion;
	}

	public void setIdCotizacion(Integer idCotizacion) {
		this.idCotizacion = idCotizacion;
	}

	/**
	 * Funcion con la cual reinicio la secuencia de la consulta general de
	 * productos
	 */
	public void reiniciarListaSedeProd() {
		try {
			ConsultaSingleton con = ConsultaSingleton.getInstance();
			con.reinicioListaProdSede(this.entitySession.getDataUser().getSede().getId());
			listaProductosGeneric = con.consultaProductos(this.entitySession.getDataUser().getSede().getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	/**
	 * funcion con la cual busco un producto por medio de el codigo de barras
	 */
	public void buscaProdCodigoBarras() {
		try {
			ProductsLogic objLogic = new ProductsLogic();
			PrecioProductoEntity rta = objLogic.buscaProductoXCodBarras(this.codigoBarras,this.entitySession.getSede().getId());
			if (rta == null) {
				this.setEnumer(ErrorEnum.ERROR);
				this.messageBean("No existe ninguna coincidencia con el codigo de barras: " + this.codigoBarras);
			} else {
				convierteObjGenericoProd(rta, 1);
			}
			this.codigoBarras = "";
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<ExistenciaXSedeEntity> getProdExistencias() {
		return prodExistencias;
	}

	public void setProdExistencias(List<ExistenciaXSedeEntity> prodExistencias) {
		this.prodExistencias = prodExistencias;
	}

	public PromPonderaEntity getProdPromPond() {
		return prodPromPond;
	}

	public void setProdPromPond(PromPonderaEntity prodPromPond) {
		this.prodPromPond = prodPromPond;
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

	public List<ExistenciaXSedeEntity> getCantidadesSedes() {
		return cantidadesSedes;
	}

	public void setCantidadesSedes(List<ExistenciaXSedeEntity> cantidadesSedes) {
		this.cantidadesSedes = cantidadesSedes;
	}

}