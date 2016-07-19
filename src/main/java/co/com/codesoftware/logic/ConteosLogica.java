package co.com.codesoftware.logic;

import java.util.List;

import co.com.codesoftware.servicio.conteos.ConteoEntity;
import co.com.codesoftware.servicio.conteos.ProductoConteoEntity;
import co.com.codesoftware.servicio.conteos.RespuestaEntity;
import co.com.codesoftware.utilities.WSGeneralInterface;

public class ConteosLogica implements WSGeneralInterface{
	/**
	 * Funcion con la cual se llama al webservice que consulta todos los conteos
	 * registrados en la aplicacion
	 * 
	 * @return
	 */
	public List<ConteoEntity> consultaConteosAbiertos() {
		List<ConteoEntity> conteos = null;
		try {
			conteos = conexionWSConteo().getPortConteo().obtenerConteoEstado("A");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conteos;
	}

	/**
	 * Funcion con la cual se llama el web service que adiciona un producto al conteo
	 * @param codigoExterno
	 * @param idConteo
	 * @param cantidad
	 * @param codigoBarras
	 */
	public RespuestaEntity adicionaConteo(String codigoExterno, Integer idConteo, Integer cantidad, String codigoBarras,String ubicacion){
		RespuestaEntity valida = null;
		try {
			valida = conexionWSConteo().getPortConteo().insertaProductoConteo(codigoExterno, idConteo, cantidad, codigoBarras,ubicacion);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}		
		return valida;
	}
	/**
	 * Funcion con la cual buscamos como va un producto dentro de un conteo
	 * @param codigoExterno
	 * @param idConteo
	 */
	public ProductoConteoEntity buscaProductoConteo(String codigoExterno, Integer idConteo){
		ProductoConteoEntity producto = null;
		try {
			producto = conexionWSConteo().getPortConteo().obtenerProdConteo(codigoExterno, idConteo);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return producto;
	}
	/**
	 * Funcion con la cual se buscan todos los productos del conteo
	 * @param conteo
	 * @return
	 */
	public List<ProductoConteoEntity> buscaTodosLosProductosConteo(Integer conteo){
		 List<ProductoConteoEntity> rta = null;
		try {
			rta = conexionWSConteo().getPortConteo().obtenerProductosConteo(conteo);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rta;
	}

}
