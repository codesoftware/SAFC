package co.com.codesoftware.logic;

import java.util.List;

import co.com.codesoftware.servicio.producto.PrecioProductoEntity;
import co.com.codesoftware.utilities.WSGeneralInterface;

public class ProductosHomeLogic implements WSGeneralInterface {

//	/**
//	 * metodo que consulta los productos de la categoria 1
//	 * 
//	 * @param categoria
//	 * @return
//	 */
//	public List<ProductosHomeEntity> consultaProductosCategoria1(Integer categoria) {
//		try {
//			//return conexionWSPrinSaf().getPortSafPrinc().consultaReferenciasHomeCategoria(categoria);
//			return null;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//	}

	/**
	 * Funcion que consulta los productos
	 * 
	 * @param referencia
	 * @return
	 */
	public List<PrecioProductoEntity> consultaProductosXReferencia(Integer referencia) {
		List<PrecioProductoEntity> lista = null;
		try {
			//return lista = conexionWSPrinSaf().getPortSafPrinc().consultaProductosXReferencia(referencia);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * Funcion con la cual se consultan los productos que se pueden vender en una sede en especifico
	 * @param sede
	 * @return
	 */
	public List<PrecioProductoEntity> consultaProductosXSede(Integer sede) {
		 List<PrecioProductoEntity> lista = null;
		try {
			//return lista = conexionWSPrinSaf().getPortSafPrinc().consultaPedidoSede(sede);
			return lista = conexionWSProd().getPortProd().obtenerProductoXSede(sede);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}



}
