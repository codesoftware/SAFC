package co.com.codesoftware.logic;

import co.com.codesoftware.utilities.WSGeneralInterface;

public class RecetasLogic implements WSGeneralInterface{

//	/**
//	 * Metodo que consulta las recetas de la pantalla principal
//	 * @return
//	 */
//	public List<PantallaPrincipalFacTable> getEspecialReceta(Integer sede_sede) {
//		List<PantallaPrincipalFacTable> list = new ArrayList<PantallaPrincipalFacTable>();
//		try {
//			//list = conexionWSPrinSaf().getPortSafPrinc().getDishesPrincipalScreen(sede_sede);
//			//list = getImage(list);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return list;
//	}
//
//	public List<RecetaTable> getReceta() {
//		List<RecetaTable> list = new ArrayList<RecetaTable>();
//		list = conexionWSPrinSaf().getPortSafPrinc().getRecetas(1);
//		return list;
//
//	}
//	
//	public GenericProductEntity getProductXCode(String code,int cantidad){
//		RecetaTable receta = null;
//		GenericProductEntity result = new GenericProductEntity();
//		try {
//			receta = new RecetaTable();
//			//receta = port.getProductForCode(code,1);
//			result = setGenericProduct(result, receta,cantidad);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return result;
//	}
//	
//	public GenericProductEntity setGenericProduct(GenericProductEntity result,RecetaTable product,int cantidad){
//		result.setCode(product.getCodigo());
//		result.setId(product.getId());
//		result.setName(product.getNombre());	
//		result.setAmount(cantidad);
//		result.setPrice(product.getPrecios().get(0).getPrecio());
//		return result;
//	}
//	
//	public  List<PantallaPrincipalFacTable> getImage(List<PantallaPrincipalFacTable> list){
//		ImagesUtilities ut = new ImagesUtilities();
//	
//		for(int i=0;i<list.size();i++){
//			if(ut.encodeB64ToImage(list.get(i).getImagen(),list.get(i).getNombre()+"."+list.get(i).getExtension())){
//				list.get(i).setRuta(list.get(i).getCodigo()+"."+list.get(i).getExtension());
//			}
//		}
//		return list;
//	}
	
}
