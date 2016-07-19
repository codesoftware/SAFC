package co.com.codesoftware.utilities;

import java.net.URL;

import co.com.codesoftware.entities.EntityWS;
import co.com.codesoftware.servicio.conteos.ConteoWS;
import co.com.codesoftware.servicio.conteos.ConteoWS_Service;
import co.com.codesoftware.servicio.facturacion.FacturacionWS;
import co.com.codesoftware.servicio.facturacion.FacturacionWS_Service;
import co.com.codesoftware.servicio.general.GeneralWS;
import co.com.codesoftware.servicio.general.GeneralWS_Service;
import co.com.codesoftware.servicio.pedido.PedidoWS;
import co.com.codesoftware.servicio.pedido.PedidoWS_Service;
import co.com.codesoftware.servicio.producto.ProductoWS;
import co.com.codesoftware.servicio.producto.ProductoWS_Service;
import co.com.codesoftware.servicio.usuario.UsuarioWS;
import co.com.codesoftware.servicio.usuario.UsuarioWS_Service;


public interface WSGeneralInterface {

	/**
	 * metodo que valida la conexion y devuelve el objeto tipo port conteo
	 * 
	 * @return
	 */
	default EntityWS conexionWSConteo() {
		EntityWS entity = new EntityWS();
		try {
			ConSingletonWS con = ConSingletonWS.getInstance();
			String url = con.consultaUrl().get("Conteo");
			ConteoWS_Service service = new ConteoWS_Service(new URL(url));
			ConteoWS port = service.getConteoWSPort();
			entity.setPortConteo(port);
			entity.setValidaConexionCont("OK");
		} catch (Exception e) {
			e.printStackTrace();
			entity.setValidaConexionCont("ERROR DE CONEXION");
		}
		return entity;
	}	
	/**
	 * metodo que valida la conexion y devuelve el objeto tipo port safws principal 
	 * @return
	 */
	default EntityWS conexionWSProd() {
		EntityWS entity = new EntityWS();
		try {
			ConSingletonWS con = ConSingletonWS.getInstance();
			String url = con.consultaUrl().get("ProductosSAFC");
			System.out.println("dfg"+url);
			ProductoWS_Service service = new ProductoWS_Service(new URL(url));
			ProductoWS port = service.getProductoWSPort();
			entity.setPortProd(port);
			entity.setValidaConexionProd("OK");
		} catch (Exception e) {
			e.printStackTrace();
			entity.setValidaConexionCont("ERROR DE CONEXION");
		}
		return entity;
	}
	
	/**
	 * metodo que valida la conexion y devuelve el objeto tipo port usuario  
	 * @return
	 */
	default EntityWS conexionWSUsuario() {
		EntityWS entity = new EntityWS();
		try {
			ConSingletonWS con = ConSingletonWS.getInstance();
			String url = con.consultaUrl().get("Usuario");
			UsuarioWS_Service service = new UsuarioWS_Service(new URL(url));
			UsuarioWS port = service.getUsuarioWSPort();
			entity.setPortUsuario(port);
			entity.setValidaConexionUsuario("OK");
			
		} catch (Exception e) {
			e.printStackTrace();
			entity.setValidaConexionUsuario("ERROR DE CONEXION");
		}
		return entity;
	}
	
	/**
	 * metodo que valida la conexion y devuelve el objeto tipo port usuario  
	 * @return
	 */
	default EntityWS conexionWSGeneral() {
		EntityWS entity = new EntityWS();
		try {
			ConSingletonWS con = ConSingletonWS.getInstance();
			String url = con.consultaUrl().get("General");
			GeneralWS_Service service = new GeneralWS_Service(new URL(url));
			GeneralWS port = service.getGeneralWSPort();
			entity.setPortGeneral(port);
			entity.setValidaConexionGeneral("OK");			
		} catch (Exception e) {
			e.printStackTrace();
			entity.setValidaConexionUsuario("ERROR DE CONEXION");
		}
		return entity;
	}
	
	/**
	 * metodo que valida la conexion y devuelve el objeto tipo port usuario  
	 * @return
	 */
	default EntityWS conexionWSFacturacion() {
		EntityWS entity = new EntityWS();
		try {
			ConSingletonWS con = ConSingletonWS.getInstance();
			String url = con.consultaUrl().get("Facturacion");
			FacturacionWS_Service service = new FacturacionWS_Service(new URL(url));
			FacturacionWS port = service.getFacturacionWSPort();
			entity.setPortFacturacion(port);
			entity.setValidaConexionFacturacion("OK");			
		} catch (Exception e) {
			e.printStackTrace();
			entity.setValidaConexionFacturacion("ERROR DE CONEXION");
		}
		return entity;
	}
	
	/**
	 * metodo que valida la conexion y devuelve el objeto tipo port usuario  
	 * @return
	 */
	default EntityWS conexionWSPedido() {
		EntityWS entity = new EntityWS();
		try {
			ConSingletonWS con = ConSingletonWS.getInstance();
			String url = con.consultaUrl().get("Pedido");
			PedidoWS_Service service = new PedidoWS_Service(new URL(url));
			PedidoWS port = service.getPedidoWSPort();
			entity.setPortPedido(port);
			entity.setValidaConexionPedido("OK");			
		} catch (Exception e) {
			e.printStackTrace();
			entity.setValidaConexionPedido("ERROR DE CONEXION");
		}
		return entity;
	}

}
