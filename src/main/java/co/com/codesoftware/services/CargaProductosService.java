package co.com.codesoftware.services;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "cargaProductosService", eager = true)
@ApplicationScoped
public class CargaProductosService {
//	private List<ProductosHomeEntity> categoria1;
//	private List<ProductosHomeEntity> categoria2;
//	private static boolean banderaCategoria1;
//	private static boolean banderaCategoria2;
//	 /**
//	  * Funcion en la cual se inicia la carga
//	  */
//	@PostConstruct
//	public void init(){
//		banderaCategoria1 = false;
//		banderaCategoria2 = false;
//	}
//	
//	/**
//	 * Metodo donde se llama a la logica para que cargue la lista de categorias
//	 * @return
//	 */
//	public List<ProductosHomeEntity> consultaReferencias(Integer cat){
//		try {
//			if(!banderaCategoria1 || categoria1==null || categoria1.isEmpty()){
//				ProductosHomeLogic logica = new ProductosHomeLogic();
//				categoria1 = logica.consultaProductosCategoria1(cat);
//				banderaCategoria1=true;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return categoria1;
//		
//	}
//	/**
//	 * Metodo donde se llama a la logica para que cargue la lista de categorias
//	 * @return
//	 */
//	public List<ProductosHomeEntity> consultaReferencias2(Integer cat){
//		try {
//			if(!banderaCategoria2 || categoria2==null || categoria2.isEmpty()){
//				ProductosHomeLogic logica = new ProductosHomeLogic();
//				categoria2 = logica.consultaProductosCategoria1(cat);
//				banderaCategoria2=true;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return categoria2;
//		
//	}
//	
//	
//	
//	//accesors y mutators
//	public List<ProductosHomeEntity> getCategoria1() {
//		return categoria1;
//	}
//	public void setCategoria1(List<ProductosHomeEntity> categoria1) {
//		this.categoria1 = categoria1;
//	}
//	public static boolean isBanderaCategoria1() {
//		return banderaCategoria1;
//	}
//	public static void setBanderaCategoria1(boolean banderaCategoria1) {
//		CargaProductosService.banderaCategoria1 = banderaCategoria1;
//	}
//
//	public List<ProductosHomeEntity> getCategoria2() {
//		return categoria2;
//	}
//
//	public void setCategoria2(List<ProductosHomeEntity> categoria2) {
//		this.categoria2 = categoria2;
//	}
//	
}
