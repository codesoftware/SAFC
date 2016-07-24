package co.com.codesoftware.logic;

import java.util.ArrayList;
import java.util.List;

import co.com.codesoftware.servicio.producto.ExistenciaXSedeEntity;
import co.com.codesoftware.servicio.producto.ProductoGenericoEntity;
import co.com.codesoftware.servicio.producto.RespuestaEntity;
import co.com.codesoftware.servicio.producto.SolicitudEntity;
import co.com.codesoftware.servicio.producto.SolicitudProdEntity;
import co.com.codesoftware.utilities.WSGeneralInterface;

public class SolicitudLogica implements WSGeneralInterface {

	/**
	 * metodo que inserta la solicitud
	 * 
	 * @param solicitud
	 * @return
	 */
	public SolicitudEntity insertaSolicitud(SolicitudEntity solicitud) {
		SolicitudEntity respuesta = new SolicitudEntity();
		try {
			RespuestaEntity res = conexionWSProd().getPortProd().insertaSolicitud(solicitud);
			if (res.getCodigoRespuesta() == 1) {
				respuesta = conexionWSProd().getPortProd().obtenerSolicitudXfiltro(solicitud.getFecha(),
						solicitud.getSede().getId(), solicitud.getUsuario().getId());
			}else{
				respuesta=null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			respuesta=null;
		}
		return respuesta;
	}

	/**
	 * metodo que valida si los productos cumplen con lo establecido
	 * 
	 * @param productos
	 * @return
	 */
	public String validaProductos(List<SolicitudProdEntity> productos, SolicitudEntity solicitud) {
		String respuesta = "OK";
		try {
			if (productos.size() == 0) {
				respuesta = "Debe agregar por lo menos un producto a la solicitud";
			} else if (solicitud.getId() == null) {
				respuesta = "Debe crear la solicitud";
			} else {
				for (SolicitudProdEntity item : productos) {
					if (item.getCantidadSolicitada() == 0 || item.getCantidadSolicitada() == null) {
						respuesta = "El producto" + item.getProducto().getNombre() + "No tiene una cantidad valida";
						break;
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			respuesta = "Error " + e.getMessage();

		}
		return respuesta;
	}

	/**
	 * metodo que ingresa los productos a la solicitud
	 * 
	 * @param productos
	 * @param solicitud
	 * @return
	 */
	public String ingresaProductosSolicitud(List<SolicitudProdEntity> productos, SolicitudEntity solicitud) {
		String respuesta = "OK";
		try {
			for(SolicitudProdEntity item:productos){
				item.setSolicitud(solicitud);
			}
			if ("OK".equalsIgnoreCase(respuesta)) {
				RespuestaEntity respuestaSW = conexionWSProd().getPortProd().insertaProductosSolicitud(productos);
				respuesta = respuestaSW.getDescripcionRespuesta();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respuesta;
	}
	
	/**
	 * metodo que consulta las cantidades de un producto por ID
	 * @param idProducto
	 * @return
	 */
	public Integer consultaCantidadesXId(Integer idProducto){
		Integer rta = 0;
		try {
			List<ExistenciaXSedeEntity> lista = new ArrayList<>();
			lista = conexionWSProd().getPortProd().obtenerCantidadesXProducto(idProducto);
			if(lista==null || lista.isEmpty()){
				rta =0;
			}else{
				rta = lista.get(0).getExistencias();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rta;
	}
	
	/**
	 * metodo que consulta las existencias totales
	 * @param idProducto
	 * @return
	 */
	public List<ExistenciaXSedeEntity> consultaExistenciasXId(Integer idProducto){
		 List<ExistenciaXSedeEntity> lista = new ArrayList<ExistenciaXSedeEntity>();
		 try {
			lista =conexionWSProd().getPortProd().obtenerCantidadesXProducto(idProducto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return lista;
	}
	
	
	/**
	 * metodo que consulta las existencias totales
	 * @param idProducto
	 * @return
	 */
	public Integer consultaExistenciasTotales(Integer idProducto){
		 List<ExistenciaXSedeEntity> lista = new ArrayList<ExistenciaXSedeEntity>();
		 Integer respuesta = 0;
		 try {
			lista =conexionWSProd().getPortProd().obtenerCantidadesXProducto(idProducto);
			if(lista!=null && !lista.isEmpty()){
				for(ExistenciaXSedeEntity item:lista){
					respuesta += item.getExistencias();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return respuesta;
	}
	
	/**
	 * metodo que consulta un producto por el código externo
	 * @param codigo
	 * @return
	 */
	
	public ProductoGenericoEntity consultaProductoXCodigo(String codigo){
		try {
			return conexionWSProd().getPortProd().obtenerProdcutoGeneriXCodExt(codigo);
		} catch (Exception e) {
			return null;
		}
	}
}
