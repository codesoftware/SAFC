package co.com.codesoftware.mapeos;

import java.util.ArrayList;
import java.util.List;

import co.com.codesoftware.servicio.pedido.ClienteEntity;

public class UsuarioToPedidoMp {
	/**
	 * Funcion con la cual mapeo un lista de objetos tipo usuario a unos tipo
	 * pedido
	 * 
	 * @param listaCliente
	 * @return
	 */
	public static List<ClienteEntity> clienteEntityLsMp(
			List<co.com.codesoftware.servicio.usuario.ClienteEntity> listaCliente) {
		List<ClienteEntity> rta = null;
		if (listaCliente != null) {
			for (co.com.codesoftware.servicio.usuario.ClienteEntity objEntity : listaCliente) {
				if (rta == null) {
					rta = new ArrayList<>();
				}
				ClienteEntity cliente = new ClienteEntity();
				cliente.setApellidos(objEntity.getApellidos());
				cliente.setCedula(objEntity.getCedula());
				cliente.setCorreo(objEntity.getCorreo());
				cliente.setDireccion(objEntity.getDireccion());
				cliente.setId(objEntity.getId());
				cliente.setNombres(objEntity.getNombres());
				cliente.setTelefono(objEntity.getTelefono());
				rta.add(cliente);
			}
		}
		return rta;
	}

}
