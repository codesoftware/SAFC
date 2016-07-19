package co.com.codesoftware.logic;

import co.com.codesoftware.servicio.usuario.ClienteEntity;
import co.com.codesoftware.utilities.WSGeneralInterface;

public class ClienteLogic implements WSGeneralInterface {

	/**
	 * Funcion que consulta el cliente generico
	 * @return
	 */
	public ClienteEntity getDefaultClient() {
		ClienteEntity cliente = new ClienteEntity();
		try {
			cliente = conexionWSUsuario().getPortUsuario().obtenerClienteXCedula("0");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cliente;
	}
	/**
	 * Funcion con la cual actualizo un cliente
	 * @param cliente
	 * @return
	 */
	public boolean updateCliente(ClienteEntity cliente){
		boolean valida;
		try {
			valida = conexionWSUsuario().getPortUsuario().updateCliente(cliente);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return valida;
	}

}
