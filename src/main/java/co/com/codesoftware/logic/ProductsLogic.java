package co.com.codesoftware.logic;

import java.util.List;

import co.com.codesoftware.entities.DatosSessionEntity;
import co.com.codesoftware.entities.GenericProductEntity;
import co.com.codesoftware.servicio.producto.ExistenciaXSedeEntity;
import co.com.codesoftware.servicio.producto.PrecioProductoEntity;
import co.com.codesoftware.servicio.producto.PrecioRecetaEntity;
import co.com.codesoftware.servicio.producto.ProductoGenericoEntity;
import co.com.codesoftware.servicio.producto.PromPonderaEntity;
import co.com.codesoftware.utilities.WSGeneralInterface;

public class ProductsLogic implements WSGeneralInterface {
	/**
	 * Funcion que consulta un producto por codigo y devuelve la entidad de este
	 * 
	 * @param id
	 * @return
	 */
	public GenericProductEntity getProductXCode(String code, int cantidad, DatosSessionEntity session) {
		PrecioProductoEntity product = null;
		GenericProductEntity result = new GenericProductEntity();
		try {
			product = conexionWSProd().getPortProd().obtenerProductoXCodigo(code, session.getDataUser().getSede().getId());
			if (product != null) {
				result = setGenericProduct(result, product, cantidad);
			} else {
				result = null;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * Consulta recetas por el codigo
	 * 
	 * @param code
	 * @param cantidad
	 * @param session
	 * @return
	 */
	public GenericProductEntity getRecetaForCode(String code, int cantidad, DatosSessionEntity session) {
		PrecioRecetaEntity receta = null;
		GenericProductEntity result = new GenericProductEntity();
		try {
			receta =  conexionWSProd().getPortProd().obtenerRecetaXCodigo(code, session.getDataUser().getSede().getId());
			if (receta != null) {
				result = setGenericReceta(result, receta, cantidad);
			} else {
				result = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}

	public GenericProductEntity setGenericProduct(GenericProductEntity result, PrecioProductoEntity product, int cantidad) {
		result.setCode(product.getProducto().getCodigo());
		result.setId(product.getProducto().getId());
		result.setName(product.getProducto().getDescripcion());
		result.setAmount(cantidad);
		result.setPrice( product.getPrecio());
		result.setTotalPrice( product.getPrecio());
		return result;
	}

/**
 * metodo que mapea la receta a un producto generico
 * @param result
 * @param product
 * @param cantidad
 * @return
 */
	public GenericProductEntity setGenericReceta(GenericProductEntity result, PrecioRecetaEntity product, int cantidad) {
		result.setCode(product.getReceta().getCodigo());
		result.setId(product.getReceta().getId());
		result.setName(product.getReceta().getNombre());
		result.setAmount(cantidad);
		result.setPrice(product.getPrecio());
		return result;
	}

//	public List<PantallaPrincipalFacTable> getImage(List<PantallaPrincipalFacTable> list) {
//		ImagesUtilities ut = new ImagesUtilities();
//		for (PantallaPrincipalFacTable item : list) {
//			if (ut.encodeB64ToImage(item.getImagen(), item.getNombre() + "." + item.getExtension())) {
//				item.setRuta(item.getCodigo() + "." + item.getExtension());
//			}
//		}
//		return list;
//	}

	/**
	 * Funcion la cual busca todos los productos activos de la aplicacion
	 * 
	 * @return
	 */
	public List<PrecioProductoEntity> buscaProductosAplicacion(Integer sede) {
		 List<PrecioProductoEntity> productos = null;
		try {
			productos = conexionWSProd().getPortProd().obtenerProductoXSede(sede);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productos;
	}

	/**
	 * Funcion con la cual obtengo todos los productos y recetas del sistema
	 * 
	 * @param sede_sede
	 * @return
	 */
	public List<ProductoGenericoEntity> buscaProductosAplicacionGenericos(Integer sede_sede) {
		 List<ProductoGenericoEntity> productosGenericos = null;
		try {
			productosGenericos = conexionWSProd().getPortProd().obtenerProductosXSede(sede_sede);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productosGenericos;

	}

	/**
	 * Funcion con la cual se busca un producto por su codigo externo
	 * 
	 * @param codigoExt
	 * @return
	 */
	public PrecioProductoEntity consultaProductoCodExt(String codigoExt, Integer idSede) {
		PrecioProductoEntity objEntity = null;
		try {
			objEntity = conexionWSProd().getPortProd().obtenerProductoXCodExt(codigoExt,idSede);
					
			//objEntity = conexionWSPrinSaf().getPortSafPrinc().consultaProductoCodigoExterno(codigoExt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objEntity;
	}

	/**
	 * Funcion con la cual busco todas las existencias de un producto en todas
	 * las sedes del sistema
	 * 
	 * @param idDska
	 */
	public List<ExistenciaXSedeEntity> buscaExistenciasProducto(Integer idDska) {
		List<ExistenciaXSedeEntity> rta = null;
		try {
			//rta = conexionWSProd().getPortProd().buscaExistenciasProdu(idDska);
			rta = conexionWSProd().getPortProd().obtenerExistenciasProducto(idDska);
			//Cambia por obtenerExistenciasProducto
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rta;
	}

	/**
	 * Funcion con la cual obtengo el promedio ponderado de un producto en
	 * especifico
	 * 
	 * @param idDska
	 * @return
	 */
	public PromPonderaEntity buscaPromedioPonderadoProducto(Integer idDska) {
		 PromPonderaEntity rta = null;
		try {
			rta = conexionWSProd().getPortProd().obtenerPromedioPonderadoProducto(idDska);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rta;
	}

	/**
	 * Funcion con la cual busco un producto por medio de su codigo de barras
	 * 
	 * @param codigoBarras
	 * @param idSede
	 * @return
	 */
	public PrecioProductoEntity buscaProductoXCodBarras(String codigoBarras, Integer idSede) {
		PrecioProductoEntity rta = null;
		try {
			rta = conexionWSProd().getPortProd().obtenerProductoXCodBarras(codigoBarras, idSede);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rta;
	}

	/**
	 * Funcion con el cual busco todos los productos de una sede que cumplan con
	 * un criterio dado
	 * 
	 * @param idSede
	 * @param criterio
	 */
	public List<ProductoGenericoEntity> buscaProductosXCriterio(Integer idSede, String criterio) {
		List<ProductoGenericoEntity> rta = null;
		try {
			rta = conexionWSProd().getPortProd().obtenerProductosYRecetasXCriterio(idSede, criterio);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rta;
	}
}
