package co.com.codesoftware.logic;

import java.util.HashMap;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;

public class WsLogica {

	/**
	 * metodo que consulta las url parametrizadas en el context del tomcat
	 * 
	 * @return
	 */
	public Map<String, String> consultaURLWebServices() {
		Map<String, String> rta = new HashMap<String, String>();
		try {
			Context initCtx = new InitialContext();
			String endPointAdministracion = (String) initCtx.lookup("java:comp/env/endPointAdministracion");
			String endPointProductosSAFC = (String) initCtx.lookup("java:comp/env/endPointProducto");
			String endPointConteo = (String) initCtx.lookup("java:comp/env/endPointConteo");
			String endPointUsuario = (String) initCtx.lookup("java:comp/env/endPointUsuario");
			String endPointGeneral = (String) initCtx.lookup("java:comp/env/endPointGeneral");
			String endPointFacturacion = (String) initCtx.lookup("java:comp/env/endPointFacturacion");
			String endPointProductos = (String) initCtx.lookup("java:comp/env/endPointProductos");
			String endPointProducto = (String) initCtx.lookup("java:comp/env/endPointProducto");
			String endPointPedido = (String) initCtx.lookup("java:comp/env/endPointPedido");
			rta.put("Productos", endPointProductos);
			rta.put("Producto", endPointProducto);
			rta.put("General", endPointGeneral);
			rta.put("Usuario", endPointUsuario);
			rta.put("Facturacion", endPointFacturacion);
			rta.put("Pedido", endPointPedido);

			rta.put("Administracion", endPointAdministracion);
			rta.put("ProductosSAFC", endPointProductosSAFC);
			rta.put("Conteo", endPointConteo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rta;
	}

}
