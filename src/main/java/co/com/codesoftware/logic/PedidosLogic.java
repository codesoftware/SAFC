package co.com.codesoftware.logic;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import co.com.codesoftware.entities.GenericProductEntity;
import co.com.codesoftware.servicio.general.MapaEntity;
import co.com.codesoftware.servicio.pedido.ClienteEntity;
import co.com.codesoftware.servicio.pedido.PedidoEntity;
import co.com.codesoftware.servicio.pedido.PedidoProductoEntity;
import co.com.codesoftware.servicio.pedido.RespuestaEntity;
import co.com.codesoftware.servicio.pedido.RespuestaPedidoEntity;
import co.com.codesoftware.servicio.pedido.SedeEntity;
import co.com.codesoftware.servicio.pedido.UsuarioEntity;
import co.com.codesoftware.servicio.producto.ExistenciaXSedeEntity;
import co.com.codesoftware.servicio.producto.PrecioProductoEntity;
import co.com.codesoftware.utilities.WSGeneralInterface;

public class PedidosLogic implements WSGeneralInterface {

	/**
	 * Metodo por el cual se hace la inserción en la base de datos
	 * 
	 * @param productos
	 * @return
	 */
	public RespuestaEntity insertaPedidoProducto(List<GenericProductEntity> productos, Integer sede, Integer usuario, Integer idCliente, String estado) {
		RespuestaEntity respuesta = new RespuestaEntity();
		SedeEntity sedeObj = new SedeEntity();
		sedeObj.setId(sede);
		ClienteEntity clientObj = new ClienteEntity();
		clientObj.setId(idCliente);
		UsuarioEntity usuObj = new UsuarioEntity();
		usuObj.setId(usuario);
		try {
			if (productos.size() < 0) {
				respuesta.setCodigoRespuesta(0);
				respuesta.setMensajeRespuesta("La lista no puede ir nula");
			} else {
				Integer idPedido = insertPedido(clientObj, sedeObj, usuObj, estado);
				if (idPedido == 0) {
					respuesta.setCodigoRespuesta(0);
					respuesta.setMensajeRespuesta("La lista no puede ir nula");
				} else {
					respuesta = insertaProducto(idPedido, productos);
				}
			}
		} catch (Exception e) {
			respuesta.setCodigoRespuesta(0);
			respuesta.setDescripcionRespuesta(e.toString());
			respuesta.setMensajeRespuesta(e.getMessage());
			e.printStackTrace();
		}
		return respuesta;
	}

	/**
	 * metodo que inserta el pedido, si es 0 quiere decir que no se pudo
	 * ingresar el pedido
	 * 
	 * @return
	 */
	public Integer insertPedido(ClienteEntity cliente, SedeEntity sede, UsuarioEntity usuario, String estado) {
		PedidoEntity pedido = new PedidoEntity();
		Integer idPedido = 0;
		try {
			pedido.setCliente(cliente);
			pedido.setEstado(estado);
			pedido.setSede(sede);
			pedido.setUsuario(usuario);
			// RespuestaEntity respuesta=
			// conexionWSPrinSaf().getPortSafPrinc().insertaPedidosProducto(pedido);
			RespuestaEntity respuesta = conexionWSPedido().getPortPedido().insertaPedidosProducto(pedido);
			idPedido = respuesta.getCodigoRespuesta();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return idPedido;
	}

	/**
	 * funcion que inserta los productos al pedido
	 * 
	 * @param idPedido
	 * @param productos
	 * @return
	 */
	public RespuestaEntity insertaProducto(Integer idPedido, List<GenericProductEntity> productos) {
		RespuestaEntity respuesta = new RespuestaEntity();
		try {
			// respuesta =
			// conexionWSPrinSaf().getPortSafPrinc().insertaProductosXPedido(cambioEntidad(idPedido,
			// productos), idPedido);
			respuesta = conexionWSPedido().getPortPedido().insertaProductosXPedido(cambioEntidad(idPedido, productos), idPedido);
		} catch (Exception e) {
			respuesta.setCodigoRespuesta(0);
			respuesta.setDescripcionRespuesta(e.getMessage());
			respuesta.setMensajeRespuesta(e.toString());
			e.printStackTrace();
		}
		return respuesta;

	}

	/**
	 * funcion que setea la lista de generica a la lista que recibe el
	 * webservice
	 * 
	 * @param idPedido
	 * @param productos
	 * @return
	 */
	public List<PedidoProductoEntity> cambioEntidad(Integer idPedido, List<GenericProductEntity> productos) {
		List<PedidoProductoEntity> respuesta = new ArrayList<PedidoProductoEntity>();
		try {
			for (GenericProductEntity item : productos) {
				respuesta.add(cambiaEntidad(item, idPedido));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respuesta;
	}

	/**
	 * Metodo que convierte de ela entidad generica a la entidad que requiere el
	 * webservice
	 * 
	 * @param entidadGenerica
	 * @return
	 */
	public PedidoProductoEntity cambiaEntidad(GenericProductEntity entidadGenerica, Integer idPedido) {
		PedidoProductoEntity respuesta = new PedidoProductoEntity();
		respuesta.setCantidad(entidadGenerica.getAmount());
		respuesta.setPedido(idPedido);
		respuesta.setPrecio(entidadGenerica.getPrice());
		respuesta.setProducto(entidadGenerica.getId());
		respuesta.setCodigo(entidadGenerica.getCode());
		respuesta.setDescuento(new BigDecimal(0));
		respuesta.setNombre(entidadGenerica.getName());
		return respuesta;
	}

	/**
	 * Genera codigo de barras del pedido
	 * 
	 * @param id
	 * @return
	 */
	public String generarPdfXIdPedi(Integer id) {
		String rta = "";
		try {
			// String imagen =
			// conexionWSPrinSaf().getPortSafPrinc().generaCodigoPedido(id);
			String imagen = conexionWSPedido().getPortPedido().generaCodigoPedido(id);
			ExternalContext tmpEC;
			tmpEC = FacesContext.getCurrentInstance().getExternalContext();
			String realPath = tmpEC.getRealPath("/resources/images/pedidos/");
			CodificaBase64 codifica64 = new CodificaBase64();
			codifica64.setDocumento(imagen);
			boolean valida = codifica64.decodificaBase64(realPath, "pedido_" + id + ".pdf");
			if (valida) {
				System.out.println("Codifico la imagen: " + realPath + "pedido_" + id + ".pdf");
				rta = "Ok";
			}
		} catch (Exception e) {
			e.printStackTrace();
			rta = "Error";
		}
		return rta;
	}

	/**
	 * metodo que consulta un pedido por ID
	 * 
	 * @param idPedido
	 * @return
	 */
	public RespuestaPedidoEntity consultaPedidoLogica(Integer idPedido) {
		RespuestaPedidoEntity respuesta = null;
		try {
			respuesta = conexionWSPedido().getPortPedido().obtenerPedidoXId(idPedido);
		} catch (Exception e) {
			RespuestaEntity res = new RespuestaEntity();
			res.setCodigoRespuesta(0);
			res.setDescripcionRespuesta(e.toString());
			res.setMensajeRespuesta(e.getMessage());
			e.printStackTrace();
		}
		return respuesta;
	}

	/**
	 * Funcion con la cual obtengo la informacion principal de un pedido por
	 * medio de su id
	 * 
	 * @param idPedido
	 * @return
	 */
	public PedidoEntity obtenerInfoPrincPedido(Integer idPedido) {
		PedidoEntity rta = null;
		try {
			rta = conexionWSPedido().getPortPedido().obtenerDatPrincPedidoXId(idPedido);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rta;
	}

	/**
	 * metodo que consulta un listado de pedidos por estado se organiza del mas
	 * reciente al mas antiguo
	 * 
	 * @param estado
	 * @return
	 */
	public List<PedidoEntity> consultaPedidoEstado(String estado) {
		List<PedidoEntity> pedidos = null;
		try {
			pedidos = conexionWSPedido().getPortPedido().consultaPedidosXEstado(estado);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pedidos;
	}

	/**
	 * Funcion que reemplaza el objeto modificado
	 * 
	 * @param lista
	 * @param objeto
	 * @return
	 */

	public List<GenericProductEntity> actualizaProductos(List<GenericProductEntity> lista, GenericProductEntity objeto) {
		Iterator<GenericProductEntity> it = lista.iterator();
		while (it.hasNext()) {
			GenericProductEntity aux = it.next();
			if (aux.getCode().equalsIgnoreCase(objeto.getCode())) {
				aux.setAmount(objeto.getAmount());
				aux.setPrice(objeto.getPrice());
				aux.setTotalPrice(objeto.getTotalPrice());
				break;
			}
		}
		return lista;

	}

	/**
	 * Funcion que consulta las existencias del producto
	 * 
	 * @param entidad
	 * @return
	 */
	public Integer consultaExistenciasProducto(PrecioProductoEntity entidad, Integer sede, Integer cantidad) {
		Integer resultado = 0;
		try {
			ExistenciaXSedeEntity cCantidad = null;
			// cCantidad =
			// conexionWSPrinSaf().getPortSafPrinc().consultaCantidadesXSede(sede,
			// entidad.getIdProducto().getId());
			cCantidad = conexionWSProd().getPortProd().obtenerCantidadesXSede(sede, entidad.getProducto().getId());
			// obtenerCantidadesXSede
			resultado = cCantidad.getExistencias() - cantidad;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;
	}

	/**
	 * Funcion con la cual consulto las cantidades que tiene un producto en
	 * especifico en cada sede de la empresa
	 * 
	 * @param producto
	 * @return
	 */
	public List<ExistenciaXSedeEntity> consultaCantidadesProd(Integer producto) {
		List<ExistenciaXSedeEntity> resultado = null;
		try {
			// resultado =
			// conexionWSPrinSaf().getPortSafPrinc().consultaCantidadesXProducto(producto);
			resultado = conexionWSProd().getPortProd().obtenerCantidadesXProducto(producto);
			// cambio por obtenerCantidadesXProducto
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;
	}

	/**
	 * Metodo que elimina un pedido
	 * 
	 * @param id
	 * @return
	 */
	public boolean eliminaPedidoId(Integer id) {
		boolean rta = false;
		try {
			rta = conexionWSPedido().getPortPedido().eliminaPedido(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rta;
	}

	/**
	 * Funcion que consulta los pedidos por filtros
	 * 
	 * @param fechaIncial
	 * @param fechaFinal
	 * @param estado
	 * @param idUsuario
	 * @return
	 */
	public List<PedidoEntity> consultaPedidosFiltros(Date fechaIncial, Date fechaFinal, String estado, Integer idUsuario) {
		List<PedidoEntity> pedidos = null;
		try {
			GregorianCalendar c = new GregorianCalendar();
			c.setTime(fechaIncial);
			XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
			GregorianCalendar c2 = new GregorianCalendar();
			c.setTime(fechaIncial);
			XMLGregorianCalendar date = DatatypeFactory.newInstance().newXMLGregorianCalendar(c2);
			// pedidos =
			// conexionWSPrinSaf().getPortSafPrinc().consultaPedidosXFiltros(estado,
			// date2, date, idUsuario);
			pedidos = conexionWSPedido().getPortPedido().consultaPedidosXFiltros(estado, date2, date, idUsuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pedidos;
	}

	/**
	 * Funcion con la cual se cancela un pedido
	 * 
	 * @param idPedido
	 * @return
	 */
	public boolean cancelaPedido(Integer idPedido) {
		boolean rta = false;
		try {
			// rta =
			// conexionWSPrinSaf().getPortSafPrinc().cambiaEstadoPedido(idPedido,
			// "CA");
			rta = conexionWSPedido().getPortPedido().cambiaEstadoPedido(idPedido, "CA");
		} catch (Exception e) {
			e.printStackTrace();
			rta = false;
		}
		return rta;
	}

	/**
	 * Funcion con la cual cambio el estado del pedido
	 * 
	 * @param idPedido
	 * @param estado
	 * @return
	 */
	public boolean cambiaEstadoPedido(Integer idPedido, String estado) {
		boolean rta = false;
		try {
			rta = conexionWSPedido().getPortPedido().cambiaEstadoPedido(idPedido, estado);
		} catch (Exception e) {
			e.printStackTrace();
			rta = false;
		}
		return rta;
	}

	/**
	 * Genera pdf con la cotizacion y la materializo
	 * 
	 * @param id
	 * @return
	 */
	public String generarPdfXIdCotiza(Integer idPedid) {
		String rta = "";
		try {
			String imagen = conexionWSPedido().getPortPedido().generaPdfCotizacion(idPedid);
			ExternalContext tmpEC;
			tmpEC = FacesContext.getCurrentInstance().getExternalContext();
			String realPath = tmpEC.getRealPath("/resources/images/cotizacion/");
			CodificaBase64 codifica64 = new CodificaBase64();
			codifica64.setDocumento(imagen);
			boolean valida = codifica64.decodificaBase64(realPath, "cotiza_" + idPedid + ".pdf");
			if (valida) {
				System.out.println("Codifico la imagen: " + realPath + "cotiza_" + idPedid + ".pdf");
				rta = "Ok";
			}
		} catch (Exception e) {
			e.printStackTrace();
			rta = "Error";
		}
		return rta;
	}

	/**
	 * funcion que llama el servicio web de verificacion de promedio ponderado
	 * 
	 * @param idProd
	 * @param valorProducto
	 * @return
	 */
	public String consultaPromedioPonderado(Integer idProd, BigDecimal valorProducto) {
		String rta = "";
		try {
			// rta =
			// conexionWSProd().getPortProd().verificaPromedioPonderado(idProd,
			// valorProducto);
			rta = conexionWSProd().getPortProd().consultaPromPonderado(idProd, valorProducto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rta;
	}

	/**
	 * Funcion con la cual busco todas las cotizaciones que tiene asociada un
	 * cliente
	 * 
	 * @param idCliente
	 * @return
	 */
	public List<PedidoEntity> buscaCotizacionesXCliente(Integer idCliente) {
		List<PedidoEntity> rta = null;
		try {
			rta = conexionWSPedido().getPortPedido().buscaCotizacionPorCliente(idCliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rta;
	}

	/**
	 * Funcion con la cual busco todas las remisiones que tiene asociada un
	 * cliente
	 * 
	 * @param idCliente
	 * @return
	 */
	public List<PedidoEntity> buscaRemsionesXCliente(Integer idCliente) {
		List<PedidoEntity> rta = null;
		try {
			rta = conexionWSPedido().getPortPedido().obtenerRemisionesPorCliente(idCliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rta;
	}
	/**
	 * Funcion con el cual busco el detalle de los pedidos 
	 * @param idPedido
	 * @return
	 */
	public List<PedidoProductoEntity> buscaDetallePedido(Integer idPedido ){
		List<PedidoProductoEntity> rta = null;
		try {
			rta = conexionWSPedido().getPortPedido().obtenerProductosPedido(idPedido);
		} catch (Exception e) {	
			e.printStackTrace();
		}
		return rta;
	}
	/**
	 * Funcion con la cual genero la remision de un pedido
	 * @return
	 */
	public String generaRemision(Integer idPedido, Integer idTius){
		String rta = "";
		try {
			rta = conexionWSPedido().getPortPedido().generarRemision(idPedido,idTius);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rta;
	}
	/**
	 * Funcion con la cual genero el pdf de la remision
	 * @param idRemi
	 * @return
	 */
	public String generaPdfRemision(Integer idRemi){
		String rta = "";
		try {
			List<MapaEntity> datos = new ArrayList<MapaEntity>();
			MapaEntity entity = new MapaEntity();
			entity.setClave("remi_remi");
			entity.setValor(""+idRemi);
			datos.add(entity);
			entity = new MapaEntity();
			entity.setClave("rutaImagen");
			datos.add(entity);
			entity = new MapaEntity();
			
			List<MapaEntity> parametros = new  ArrayList<MapaEntity>();
			entity = new MapaEntity();
			entity.setClave("tipoReporte");
			entity.setValor("pdf");
			parametros.add(entity);
			entity = new MapaEntity();
			entity.setClave("nombreReporte");
			entity.setValor("RemisionConPrecio");
			parametros.add(entity);
			parametros.add(entity);
			rta = conexionWSGeneral().getPortGeneral().generaReportes(datos, parametros);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rta;
	}
	
	/**
	 * Funcion con la cual genero el pdf de una imagen apartir de un String en base 64
	 * @param documento
	 * @return
	 */
	public String materializaImagenSeridor(String documento,Integer idRemision){
		String rta = "";
		try {
			ExternalContext tmpEC;
			tmpEC = FacesContext.getCurrentInstance().getExternalContext();
			String realPath = tmpEC.getRealPath("/resources/images/remisiones/");
			CodificaBase64 codifica64 = new CodificaBase64();
			codifica64.setDocumento(documento);
			boolean valida = codifica64.decodificaBase64(realPath, "remision_" + idRemision + ".pdf");
			if (valida) {
				rta = "Ok";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rta;
	}
}
