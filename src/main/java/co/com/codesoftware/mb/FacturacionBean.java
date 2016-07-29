package co.com.codesoftware.mb;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import co.com.codesoftware.entities.DatosSessionEntity;
import co.com.codesoftware.entities.GenericProductEntity;
import co.com.codesoftware.logic.FacturacionLogic;
import co.com.codesoftware.logic.PedidosLogic;
import co.com.codesoftware.logic.ProductsLogic;
import co.com.codesoftware.mapeos.PedidoToFacturacionMp;
import co.com.codesoftware.mapeos.PedidoToUsuarioMp;
import co.com.codesoftware.mapeos.UsuarioToFacturacionMp;
import co.com.codesoftware.servicio.facturacion.ClienteEntity;
import co.com.codesoftware.servicio.facturacion.DetProduFacturaEntity;
import co.com.codesoftware.servicio.facturacion.FacturaEntity;
import co.com.codesoftware.servicio.pedido.PedidoEntity;
import co.com.codesoftware.servicio.pedido.ProductoGenEntity;
import co.com.codesoftware.servicio.pedido.RespuestaPedidoEntity;
import co.com.codesoftware.servicio.producto.PrecioProductoEntity;
import co.com.codesoftware.servicio.producto.ProductoGenericoEntity;
import co.com.codesoftware.utilities.ErrorEnum;

@ManagedBean(name = "facturacionBean")
@ViewScoped
public class FacturacionBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String bandera;
	private ClienteEntity cliente;
	private GenericProductEntity product;
	private DatosSessionEntity entitySession;
	@ManagedProperty(value = "#{clienteBean}")
	private ClienteBean clientebean;
	private String codigoProducto;
	private int cantidad;
	private List<GenericProductEntity> listProd;
	private String codigoAdd;
	private String codigoExt;
	private BigDecimal total;
	private String priceTotal;
	private ErrorEnum enumer;
	private List<PrecioProductoEntity> productos;
	private List<ProductoGenericoEntity> productosGenericos;
	private List<ProductoGenericoEntity> productosFilter;
	private BigDecimal totalChange;
	private BigDecimal totalCliente;
	private boolean domicilio;
	private String summary;
	private MathContext mc;
	private String idFacturaAbrir;
	private String banderaPDF = "Error";
	private Integer idPedido;
	private List<PedidoEntity> listaPedidos;
	private List<PedidoEntity> listaPedidosFilter;
	private String permisosUsuario;
	// Nuevos desarollos consulta de factura;
	private List<DetProduFacturaEntity> listaProductos;
	private FacturaEntity fact;
	private BigDecimal valorTotFact;
	private String aplicaRetencion;
	// Campo para buscar el producto por nombre
	private String buscaNombre;
	// Campo en el cual se almacena el codigo del autocomplete
	private String codigoAddLs;
	// Variables utilizadas para la realizacion de pagos con tarjeta
	private String tipoPago;
	private BigDecimal pagoTarjeta;
	private String idVoucher;

	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	public String getBanderaPDF() {
		return banderaPDF;
	}

	public void setBanderaPDF(String banderaPDF) {
		this.banderaPDF = banderaPDF;
	}

	public String getIdFacturaAbrir() {
		return idFacturaAbrir;
	}

	public void setIdFacturaAbrir(String idFacturaAbrir) {
		this.idFacturaAbrir = idFacturaAbrir;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getPriceTotal() {
		return priceTotal;
	}

	public void setPriceTotal(String priceTotal) {
		this.priceTotal = priceTotal;
	}

	public BigDecimal getTotalChange() {
		return totalChange;
	}

	public boolean isDomicilio() {
		return domicilio;
	}

	public void setDomicilio(boolean domicilio) {
		this.domicilio = domicilio;
	}

	public void setTotalChange(BigDecimal totalChange) {
		this.totalChange = totalChange;
	}

	public BigDecimal getTotalCliente() {
		return totalCliente;
	}

	public void setTotalCliente(BigDecimal totalCliente) {
		this.totalCliente = totalCliente;
	}

	public ErrorEnum getEnumer() {
		return enumer;
	}

	public void setEnumer(ErrorEnum enumer) {
		this.enumer = enumer;
	}

	public FacturacionBean() {
		super();
		this.product = new GenericProductEntity();
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public List<GenericProductEntity> getListProd() {
		return listProd;
	}

	public void setListProd(List<GenericProductEntity> listProd) {
		this.listProd = listProd;
	}

	public ClienteEntity getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}

	public GenericProductEntity getProduct() {
		return product;
	}

	public void setProduct(GenericProductEntity product) {
		this.product = product;
	}

	public ClienteBean getClientebean() {
		return clientebean;
	}

	public void setClientebean(ClienteBean clientebean) {
		this.clientebean = clientebean;
	}

	public String getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getCodigoAdd() {
		return codigoAdd;
	}

	public void setCodigoAdd(String codigoAdd) {
		this.codigoAdd = codigoAdd;
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

	public List<PedidoEntity> getListaPedidos() {
		return listaPedidos;
	}

	public void setListaPedidos(List<PedidoEntity> listaPedidos) {
		this.listaPedidos = listaPedidos;
	}

	public List<PedidoEntity> getListaPedidosFilter() {
		return listaPedidosFilter;
	}

	public void setListaPedidosFilter(List<PedidoEntity> listaPedidosFilter) {
		this.listaPedidosFilter = listaPedidosFilter;
	}

	@PostConstruct
	public void init() {
		try {
			this.aplicaRetencion = "N";
			mc = new MathContext(5); // Da la precicion de las operaciones a las
										// operaciones con bigDecimal
			this.totalChange = new BigDecimal("0");
			this.cantidad = 1;
			this.total = new BigDecimal("0");
			FacesMessage message = null;
			FacesContext context = FacesContext.getCurrentInstance();
			this.entitySession = (DatosSessionEntity) context.getExternalContext().getSessionMap().get("dataSession");
			this.permisosUsuario = (String) context.getExternalContext().getSessionMap().get("permisosUsuario");
			if (entitySession == null) {
				message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Esta intentando a un sitio no permitido porfavor realice el login primero");
				context.getExternalContext().redirect("../index.jsf");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo que ejecuta la facturacion
	 */

	public void facturar() {
		if ("T".equalsIgnoreCase(this.tipoPago)) {
			this.totalCliente = this.total;
		} else if ("M".equalsIgnoreCase(this.tipoPago)) {
			this.totalCliente = this.totalCliente.add(this.pagoTarjeta);
		}
		int res = total.compareTo(totalCliente);
		if (res == 0 || res == -1) {
			checkProducts("1");
		} else {
			this.setEnumer(ErrorEnum.ERROR);
			this.messageBean("El valor que debe pagar el cliente debe ser mayor o igual al total de la factura ");
		}
	}

	/**
	 * metodo que ejecuta la facturacion sin imprimir el pdf
	 */
	public void registrar() {
		if ("T".equalsIgnoreCase(this.tipoPago)) {
			this.totalCliente = this.total;
		} else if ("M".equalsIgnoreCase(this.tipoPago)) {
			this.totalCliente = this.totalCliente.add(this.pagoTarjeta);
		}
		// Realizo validacion del precio
		int res = total.compareTo(totalCliente);
		if (res == 0 || res == -1) {
			checkProducts("2");
		} else {
			this.setEnumer(ErrorEnum.ERROR);
			this.messageBean("El valor que debe pagar el cliente debe ser mayor o igual al total de la factura ");
		}

	}

	public List<ProductoGenericoEntity> getProductosFilter() {
		return productosFilter;
	}

	public void setProductosFilter(List<ProductoGenericoEntity> productosFilter) {
		this.productosFilter = productosFilter;
	}

	/**
	 * Funcion con la cual busco un producto por medio de su codigo externo mas
	 * no el codigo de la aplicacion
	 */
	public void searchProdCodExt() {
		product = null;
		ProductsLogic objLogic = new ProductsLogic();
		try {
			PrecioProductoEntity objPrecioProd = new PrecioProductoEntity();
			objPrecioProd = objLogic.consultaProductoCodExt(codigoExt, this.entitySession.getDataUser().getSede().getId());
			if (objPrecioProd == null) {
				this.setEnumer(ErrorEnum.ERROR);
				this.messageBean("La consulta no arrojo ningun resultado");
			} else {
				if (product == null) {
					product = new GenericProductEntity();
				}
				product.setId(objPrecioProd.getProducto().getId());
				codigoAdd = objPrecioProd.getProducto().getCodigo();
				product.setCodigoPropio(codigoAdd);
				product.setCode(codigoAdd);
				product.setName(objPrecioProd.getProducto().getDescripcion());
				product.setPrice(objPrecioProd.getPrecioIva());

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Funcion que valida que tipo de producto es y asi poderlo mostrar
	 */
	public void searchProdId() {
		FacturacionLogic log = new FacturacionLogic();
		if (log.validateCodigo(codigoAdd)) {
			ProductsLogic prod = new ProductsLogic();
			if (codigoAdd.startsWith("1-")) {
				product = prod.getProductXCode(codigoAdd, cantidad, this.entitySession);
			} else if (codigoAdd.startsWith("3-")) {
				product = prod.getRecetaForCode(codigoAdd, cantidad, this.entitySession);
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

	/**
	 * Funcion que añade los productos a la factura
	 */

	public void addProductFact() {
		try {
			if (this.listProd == null) {
				this.listProd = new ArrayList<GenericProductEntity>();
			}
			FacturacionLogic log = new FacturacionLogic();
			// Verifica si el codigo esta correcto
			if (log.validateCodigo(codigoAdd)) {
				// Verifica si la cantidad esta correcta
				if (log.validateCantidad(cantidad)) {
					int exist = existProduct();
					if (exist > -1) {
						this.listProd.get(exist).setAmount(this.listProd.get(exist).getAmount() + cantidad);
						if (log.updatePrice(this.listProd.get(exist).getPrice(), this.listProd.get(exist).getAmount()) == null) {
							this.setEnumer(ErrorEnum.ERROR);
							messageBean("Al producto no se le ha parametrizado el precio");
						} else {
							this.listProd.get(exist).setTotalPrice(log.updatePrice(this.listProd.get(exist).getPrice(), this.listProd.get(exist).getAmount()));
						}
					} else {
						product.setAmount(this.cantidad);
						product.setTotalPrice(product.getPrice().multiply(new BigDecimal(cantidad), mc));
						// product.setTotalPrice(String.valueOf(Double.parseDouble(product.getPrice())
						// * this.cantidad));
						this.listProd.add(product);
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// /**
	// * Funcion que añade un producto al darle clic en el panel
	// */
	// public void addProductPanel(PantallaPrincipalFacTable table) {
	// if (this.listProd == null) {
	// this.listProd = new ArrayList<GenericProductEntity>();
	// }
	// if (table.getPrecio() == null) {
	// this.setEnumer(ErrorEnum.ERROR);
	// messageBean("Al producto no se le ha parametrizado el precio");
	// } else {
	// setData(table);
	// int exist = existProduct();
	// if (exist > -1) {
	// this.listProd.get(exist).setAmount(this.listProd.get(exist).getAmount() +
	// cantidad);
	// this.listProd.get(exist).setTotalPrice(this.listProd.get(exist).getPrice()
	// .multiply(new BigDecimal(listProd.get(exist).getAmount()), mc));
	// } else {
	// this.listProd.add(product);
	// }
	// addTotal();
	// }
	// }

	/**
	 * Funcion que valida si el producto ya existe
	 * 
	 * @return
	 */

	public int existProduct() {
		int result = -1;
		if (listProd == null) {
			listProd = new ArrayList<GenericProductEntity>();
		}
		for (int i = 0; i < this.listProd.size(); i++) {
			if (this.listProd.get(i).getCode().equalsIgnoreCase(product.getCode())) {
				result = i;
				i = this.listProd.size();
			}
		}
		return result;
	}

	// /**
	// * Funcion que setea al objeto generico de factura
	// *
	// * @param table
	// */
	//
	// public void setData(PantallaPrincipalFacTable table) {
	// this.product = new GenericProductEntity();
	// this.product.setAmount(1);
	// this.product.setPrice(new BigDecimal(table.getPrecio()));
	// this.product.setCode(table.getCodigo());
	// this.product.setName(table.getNombre());
	// this.product.setTotalPrice(new BigDecimal(table.getPrecio()));
	// this.product.setId(table.getIdReceta());
	// }

	/**
	 * Funcion que elimina una fila de la factura
	 * 
	 * @param prod
	 */
	public void deleteRow(GenericProductEntity prod) {
		this.listProd.remove(prod);
		addTotal();
	}

	/**
	 * funcion que actualiza la cantidad de productos
	 * 
	 * @param prod
	 */
	public void updateRow(GenericProductEntity prod) {
		if (prod.getAmount() < 2) {
			this.listProd.remove(prod);
		} else {
			FacturacionLogic log = new FacturacionLogic();
			prod.setAmount(prod.getAmount() - 1);
			prod.setTotalPrice(log.updatePrice(prod.getPrice(), prod.getAmount()));
		}
		addTotal();
	}

	/**
	 * Funcion que actualiza el total de la factura
	 * 
	 */
	public void addTotal() {
		BigDecimal result = new BigDecimal("0");
		for (int i = 0; i < this.listProd.size(); i++) {
			FacturacionLogic factuacionLogic = new FacturacionLogic();
			BigDecimal aux = factuacionLogic.updatePrice(this.listProd.get(i).getPrice(), this.listProd.get(i).getAmount());
			if (aux.intValue() == 0) {
				this.setEnumer(ErrorEnum.ERROR);
				messageBean("Producto sin parametrizar precio.");
			} else {
				result = result.add(aux);
				this.total = result;
			}
		}

	}

	/**
	 * Funcion con la cual busco los productos del sistema
	 */
	public void buscaProductos() {
		try {
			ProductsLogic logic = new ProductsLogic();
			this.productos = logic.buscaProductosAplicacion(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Funcion con la cual busco los productos del sistema
	 */
	public void buscaProductosGenericos() {
		try {
			ProductsLogic logic = new ProductsLogic();
			this.productosGenericos = logic.buscaProductosAplicacionGenericos(this.entitySession.getDataUser().getSede().getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Funcion que ejecuta la facturacion y envia el parametro dependiendo de la
	 * acción
	 * 
	 * @param type
	 */
	public void checkProducts(String type) {
		bandera = "no";
		FacturacionLogic logic = new FacturacionLogic();
		// valida si no hay productos o si el cliente esta nulo
		String validate = logic.validaDatos(this.listProd, UsuarioToFacturacionMp.clienteEntityMp(clientebean.getCliente()), this.summary);
		if (!"OK".equalsIgnoreCase(validate)) {
			this.setEnumer(ErrorEnum.ERROR);
			messageBean(validate);
			bandera = "no";
		} else {

			ExternalContext tmpEC;
			tmpEC = FacesContext.getCurrentInstance().getExternalContext();
			String realPath = tmpEC.getRealPath("/resources/images/products/");
			// String rta = logic.facturar(this.listProd,
			// this.clientebean.getCliente(), realPath, this.entitySession,
			// type, this.totalChange.toString(), this.totalCliente.toString(),
			// this.summary);
			String rta = logic.facturarAvanzada(this.listProd, UsuarioToFacturacionMp.clienteEntityMp(this.clientebean.getCliente()), realPath, this.entitySession, type, this.totalChange.toString(), this.totalCliente.toString(), this.summary,
					this.idPedido, this.aplicaRetencion, this.tipoPago, this.idVoucher, this.pagoTarjeta);
			boolean valida = rta.contains("ERROR");
			if (!valida) {
				if ("1".equalsIgnoreCase(type)) {
					this.enumer = ErrorEnum.SUCCESS;
					messageBean("FACTURACIÓN REALIZADA CORRECTAMENTE");
					resetValuesBill();
					resetValuesClient();
					resetValuesCambio();
					bandera = "si";
					idFacturaAbrir = "" + logic.getFactID();
					banderaPDF = "Ok";
				}
				// Pop up de factura cuando no se imprime
				else {
					// Cambios consulta de nuevo factura
					this.fact = logic.consultaFacturaXID(Integer.parseInt(rta));
					this.listaProductos = fact.getDetalleProductos();
					this.valorTotFact = fact.getValor().add(fact.getVlrIva());
					this.enumer = ErrorEnum.SUCCESS;
					messageBean("FACTURACIÓN REALIZADA CORRECTAMENTE");
					viewResumeBill();
					bandera = "no";
				}
			} else {

				this.enumer = ErrorEnum.ERROR;
				messageBean(rta);
				bandera = "no";
			}

		}
	}

	public void viewResumeBill() {
		RequestContext context = RequestContext.getCurrentInstance();
		context.execute("PF('viewBill').show();");

	}

	/**
	 * Metodo para cerrar el pop up del resumen de la factura
	 */

	public void cerrarFacturaProv() {
		resetValuesBill();
		resetValuesClient();
		resetValuesCambio();
	}

	/**
	 * Metodo el cual añade el producto a la lista de productos
	 * 
	 * @param productTable
	 */
	public void seleccionarProducto(PrecioProductoEntity productTable) {
		try {
			this.product = new GenericProductEntity();
			if (this.listProd == null) {
				this.listProd = new ArrayList<GenericProductEntity>();
			}
			this.product = setDataEntity(productTable);
			int exist = existProduct();

			if (exist > -1) {
				this.listProd.get(exist).setAmount(this.listProd.get(exist).getAmount() + 1);
				this.listProd.get(exist).setTotalPrice(this.listProd.get(exist).getPrice().multiply(new BigDecimal(this.listProd.get(exist).getAmount()), mc));
			} else {
				this.listProd.add(product);
			}
			addTotal();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo el cual añade el productoo receta a la lista de productos
	 * 
	 * @param productTable
	 */
	public void seleccionarProductoGenerico(ProductoGenericoEntity producto) {
		try {
			this.product = new GenericProductEntity();
			if (this.listProd == null) {
				this.listProd = new ArrayList<GenericProductEntity>();
			}
			FacturacionLogic logica = new FacturacionLogic();
			BigDecimal precio = logica.consultaProductoXCodigo(producto.getCodigo(), this.entitySession.getSede().getId()).getPrecio();
			producto.setPrecio(precio);
			this.product = setDataEntityGeneric(producto);
			int exist = existProduct();
			if (exist > -1) {
				this.listProd.get(exist).setAmount(this.listProd.get(exist).getAmount() + 1);
				this.listProd.get(exist).setTotalPrice(this.listProd.get(exist).getPrice().multiply(new BigDecimal(this.listProd.get(exist).getAmount()), mc));
			} else {
				product.setTotalPrice(producto.getPrecio());
				this.listProd.add(product);
			}
			addTotal();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Funcion con la cual convierte un objeto producto table y lo convierte en
	 * un objeto generico
	 * 
	 * @param prod
	 * @return
	 */
	public GenericProductEntity setDataEntity(PrecioProductoEntity prod) {
		GenericProductEntity genProduct = new GenericProductEntity();
		genProduct.setAmount(1);
		genProduct.setCode(prod.getProducto().getCodigo());
		genProduct.setId(prod.getId());
		genProduct.setName(prod.getProducto().getNombre());
		genProduct.setPrice(prod.getPrecio());
		return genProduct;
	}

	/**
	 * Funcion con la cual convierte un objeto producto table y lo convierte en
	 * un objeto generico
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

	/**
	 * Funcion que resetea los valores de la factura
	 */
	public void resetValuesBill() {
		this.listProd = null;
		this.listProd = new ArrayList<GenericProductEntity>();
		this.total = new BigDecimal(0);
	}

	public void resetValuesCambio() {
		this.totalChange = new BigDecimal(0);
		this.totalCliente = new BigDecimal(0);
	}

	/**
	 * funcion que resetea los valores del cliente
	 */
	public void resetValuesClient() {
		this.clientebean.setCliente(null);
		this.clientebean.setCliente(new co.com.codesoftware.servicio.usuario.ClienteEntity());
	}

	/**
	 * Funcion con la cual se calcula el cambio que se tiene que dar al cliente
	 */
	public void getCambio() {
		this.totalChange = totalCliente.subtract(this.total);
		if (totalChange.doubleValue() < 0) {
			this.totalChange = new BigDecimal(0);
		}
	}

	/**
	 * Funcion con la cual se validan los datos que se deben tener cuando se
	 * paga con tarjeta
	 * 
	 * @return
	 */
	public boolean validaDatosCredito() {
		try {
			if ("E".equalsIgnoreCase(this.tipoPago)) {

			} else if ("T".equalsIgnoreCase(this.tipoPago)) {
				if ("".equalsIgnoreCase(this.idVoucher)) {
					this.setEnumer(ErrorEnum.ERROR);
					messageBean("Los pagos con Tarjeta deben referenciar un id de vaucher");
					return false;
				}
			} else if ("M".equalsIgnoreCase(this.tipoPago)) {
				if ("".equalsIgnoreCase(this.idVoucher)) {
					this.setEnumer(ErrorEnum.ERROR);
					messageBean("Los pagos Mixtos deben referenciar un id de vaucher");
					return false;
				}
				if (this.pagoTarjeta == null) {
					this.setEnumer(ErrorEnum.ERROR);
					messageBean("En el pago mixto no puede ser nulo ");
				} else {
					if (this.pagoTarjeta.compareTo(new BigDecimal(0)) == 0) {
						this.setEnumer(ErrorEnum.ERROR);
						messageBean("El campo de pago en efectivo no puede ser cero ");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * Funcion donde se controla que la factura este lista para mostrar el pop
	 * up de facturacion donde el cliente ingresa el valor a pagar
	 */

	public void viewTotalPrice() {
		boolean valida = this.validaDatosCredito();
		if (valida) {
			FacturacionLogic logic = new FacturacionLogic();
			// valida si no hay productos o si el cliente esta nulo;
			String validate = logic.validaDatos(this.listProd, UsuarioToFacturacionMp.clienteEntityMp(clientebean.getCliente()), this.summary);
			if ("Ok".equalsIgnoreCase(validate)) {
				BigDecimal baseIva = total.divide(new BigDecimal("1.16"), 8, RoundingMode.HALF_UP);
				RequestContext context = RequestContext.getCurrentInstance();
				if("M".equalsIgnoreCase(tipoPago) || "T".equalsIgnoreCase(tipoPago) ){
					this.totalCliente = this.total;
				}
				if (baseIva.compareTo(new BigDecimal("803000")) >= 0) {
					context.execute("PF('viewRetencion').show();");
				} else {
					context.execute("PF('viewPrice').show();");
				}
				this.aplicaRetencion = "N";
			} else {
				this.setEnumer(ErrorEnum.ERROR);
				messageBean(validate);
			}
		}
	}

	/**
	 * Funcion que controla el check de domicilios
	 */
	public void addAjaxCheck() {
		this.summary = this.domicilio ? "Checked" : "Unchecked";
	}

	/**
	 * Metodo generico para mostrar mensajes de error o advertencia
	 * 
	 * @param message
	 */

	public void messageBean(String message) {
		switch (this.enumer) {
		case ERROR:
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", message));
			break;
		case FATAL:
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Fatal!", "Error de sistema"));
			break;
		case SUCCESS:
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Ok!", message));
			break;

		default:
			break;
		}
	}

	// public void pruebaSlider(PantallaPrincipalFacTable producto) {
	// try {
	// if (this.listProd == null) {
	// this.listProd = new ArrayList<GenericProductEntity>();
	// }
	// if (producto.getPrecio() == null) {
	// this.setEnumer(ErrorEnum.ERROR);
	// messageBean("Al producto no se le ha parametrizado el precio");
	// } else {
	// setData(producto);
	// int exist = existProduct();
	// if (exist > -1) {
	// this.listProd.get(exist).setAmount(this.listProd.get(exist).getAmount() +
	// cantidad);
	// this.listProd.get(exist).setTotalPrice(this.listProd.get(exist).getPrice()
	// .multiply(new BigDecimal(listProd.get(exist).getAmount()), mc));
	// } else {
	// this.listProd.add(product);
	// }
	// addTotal();
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }

	public String getBandera() {
		return bandera;
	}

	public void setBandera(String bandera) {
		this.bandera = bandera;
	}

	/**
	 * metodo que consulta un pedido por el ID
	 */
	public void consultaPedido() {
		RespuestaPedidoEntity respuesta = new RespuestaPedidoEntity();
		PedidosLogic logica = new PedidosLogic();
		respuesta = logica.consultaPedidoLogica(this.idPedido);
		this.clientebean.setCliente(PedidoToUsuarioMp.clienteEntityMp(respuesta.getCliente()));
		mapeaEntidadesProd(respuesta.getListaProductos());

	}

	/**
	 * Metodo que se utiliza para consultar una lista de pedidos para facturar
	 */
	public void consultaPedidoXFacturar() {
		PedidosLogic logica = new PedidosLogic();
		this.listaPedidos = new ArrayList<PedidoEntity>();
		this.listaPedidos = logica.consultaPedidoEstado("CR");
	}

	public void consultaIdPedido(Integer id) {
		this.idPedido = id;
		consultaPedido();
	}

	/**
	 * funcion que mapea la lista de productos
	 * 
	 * @param productos
	 */
	public void mapeaEntidadesProd(List<ProductoGenEntity> productos) {
		listProd = new ArrayList<GenericProductEntity>();
		for (ProductoGenEntity item : productos) {
			GenericProductEntity entidad = new GenericProductEntity();
			entidad.setAmount(item.getAmount());
			entidad.setCode(item.getCode());
			entidad.setId(item.getId());
			entidad.setName(item.getName());
			entidad.setPrice(item.getPrice());
			entidad.setTotalPrice(item.getTotalPrice());
			this.total = this.total.add(item.getTotalPrice());
			entidad.setRoutImage("");
			entidad.setType(item.getType());
			listProd.add(entidad);
		}
	}

	public String getCodigoExt() {
		return codigoExt;
	}

	public void setCodigoExt(String codigoExt) {
		this.codigoExt = codigoExt;
	}

	public String getPermisosUsuario() {
		return permisosUsuario;
	}

	public void setPermisosUsuario(String permisosUsuario) {
		this.permisosUsuario = permisosUsuario;
	}

	public BigDecimal getValorTotFact() {
		return valorTotFact;
	}

	public void setValorTotFact(BigDecimal valorTotFact) {
		this.valorTotFact = valorTotFact;
	}

	public String getAplicaRetencion() {
		return aplicaRetencion;
	}

	public void setAplicaRetencion(String aplicaRetencion) {
		this.aplicaRetencion = aplicaRetencion;
	}

	/**
	 * Funcion con la cual seteo la validacion de la retencion en la fuente
	 * 
	 * @param valida
	 */
	public void validaRetefuente(String valida) {
		try {
			RequestContext context = RequestContext.getCurrentInstance();
			this.aplicaRetencion = valida;
			context.execute("PF('viewPrice').show();");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Funcion con la cual cancela un pedido para que no aparezca en la lista
	 * 
	 * @param id
	 */
	public void cancelarPedido(Integer id) {
		try {
			PedidosLogic objLogica = new PedidosLogic();
			boolean rta = objLogica.cancelaPedido(id);
			if (rta) {
				this.setEnumer(ErrorEnum.SUCCESS);
				messageBean("Pedido cancelado correctamente");
			} else {
				this.setEnumer(ErrorEnum.ERROR);
				messageBean("Error al cancelar el pedido");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getBuscaNombre() {
		return buscaNombre;
	}

	public void setBuscaNombre(String buscaNombre) {
		this.buscaNombre = buscaNombre;
	}

	/**
	 * Funcion con la cual se busca todos los productos que coincidan con un
	 * criterio
	 */
	public List<ProductoGenericoEntity> consultaAutComNombreProd(String query) {
		List<ProductoGenericoEntity> rta = null;
		try {
			if (query.length() > 2) {
				ProductsLogic objLogic = new ProductsLogic();
				rta = objLogic.buscaProductosXCriterio(this.entitySession.getSede().getId(), query);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rta;
	}

	/**
	 * Funcion con la cual busco un producto por medio del autocomplete que
	 * selecciono el usuario
	 */
	public void buscaProdAutoComplete() {
		try {
			System.out.println("Paso por aqui" + codigoAdd);
			codigoAdd = codigoAddLs;
			searchProdId();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getCodigoAddLs() {
		return codigoAddLs;
	}

	public void setCodigoAddLs(String codigoAddLs) {
		this.codigoAddLs = codigoAddLs;
	}

	public List<PrecioProductoEntity> getProductos() {
		return productos;
	}

	public void setProductos(List<PrecioProductoEntity> productos) {
		this.productos = productos;
	}

	public MathContext getMc() {
		return mc;
	}

	public void setMc(MathContext mc) {
		this.mc = mc;
	}

	public List<DetProduFacturaEntity> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(List<DetProduFacturaEntity> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public FacturaEntity getFact() {
		return fact;
	}

	public void setFact(FacturaEntity fact) {
		this.fact = fact;
	}

	public String getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}

	public String getIdVoucher() {
		return idVoucher;
	}

	public void setIdVoucher(String idVoucher) {
		this.idVoucher = idVoucher;
	}

	public BigDecimal getPagoTarjeta() {
		return pagoTarjeta;
	}

	public void setPagoTarjeta(BigDecimal pagoTarjeta) {
		this.pagoTarjeta = pagoTarjeta;
	}

}
