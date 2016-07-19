package co.com.codesoftware.utilities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import co.com.codesoftware.logic.ProductosHomeLogic;
import co.com.codesoftware.servicio.producto.PrecioProductoEntity;

public class ConsultaSingleton {

	private static ConsultaSingleton consultaSingleton;
	private static List<PrecioProductoEntity> productosGenericos;
	private static Map<Integer, List<PrecioProductoEntity>> productosXSede;

	private ConsultaSingleton() {

	}

	public static ConsultaSingleton getInstance() {
		if (consultaSingleton == null) {
			consultaSingleton = new ConsultaSingleton();
		}
		return consultaSingleton;
	}

	/**
	 * funcion que consulta los productos
	 * 
	 * @param sede
	 * @return
	 */
	public List<PrecioProductoEntity> consultaProductos(Integer sede) {
		try {
			if (sede != null) {
				if (productosXSede == null) {
					productosXSede = new HashMap<Integer, List<PrecioProductoEntity>>();
				}
				if (productosXSede.get(sede) == null) {
					ProductosHomeLogic logic = new ProductosHomeLogic();
					productosGenericos = null;
					productosGenericos = logic.consultaProductosXSede(sede);
					productosXSede.put(sede, productosGenericos);
				} else {
					productosGenericos = productosXSede.get(sede);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return productosGenericos;
	}
	/**
	 * Funcion con la cual reseto la consulta de productos por sede 
	 */
	public void reinicioListaProdSede(Integer idSede){
		if (productosXSede.get(idSede) != null) {
			productosXSede.put(idSede, null);
		}
	}

}
