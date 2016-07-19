package co.com.codesoftware.mapeos;

import co.com.codesoftware.servicio.usuario.ClienteEntity;

public class PedidoToUsuarioMp {
	
	public static ClienteEntity clienteEntityMp(co.com.codesoftware.servicio.pedido.ClienteEntity objEntity){
		ClienteEntity cliente = new ClienteEntity();
		cliente.setApellidos(objEntity.getApellidos());
		cliente.setCedula(objEntity.getCedula());
		cliente.setCorreo(objEntity.getCorreo());
		cliente.setDireccion(objEntity.getDireccion());
		cliente.setId(objEntity.getId());
		cliente.setNombres(objEntity.getNombres());
		cliente.setTelefono(objEntity.getTelefono());
		return cliente;
	}
}
