package co.com.codesoftware.logic;

import java.util.List;

import co.com.codesoftware.servicio.usuario.ClienteEntity;
import co.com.codesoftware.utilities.WSGeneralInterface;

public class SearchTopLogic implements WSGeneralInterface {
	/**
	 * Funcion con la cual busco todos los clientes del sistema
	 * 
	 * @return
	 */
	public List<ClienteEntity> searchClient() {
		List<ClienteEntity> listResponse = null;
		try {
			listResponse = conexionWSUsuario().getPortUsuario().obtenerClientes();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listResponse;
	}

	/**
	 * Funcion con la cual adiciono un cliente
	 * 
	 * @param cliente
	 * @return
	 */
	public Integer getLogicAddClient(ClienteEntity cliente) {
		Integer idCliente = null;
		try {
			idCliente =  conexionWSUsuario().getPortUsuario().insertaCliente(cliente);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return idCliente;

	}

	/**
	 * Funcion con la cual obtengo un cliente por cedula
	 * 
	 * @return
	 */
	public ClienteEntity obtieneClienteXCedula(String cedula) {
		ClienteEntity cliente = null;
		try {
			cliente = conexionWSUsuario().getPortUsuario().obtenerClienteXCedula(cedula);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return cliente;
	}
}
