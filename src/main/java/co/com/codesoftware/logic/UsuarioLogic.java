package co.com.codesoftware.logic;

import co.com.codesoftware.servicio.usuario.UsuarioEntity;
import co.com.codesoftware.utilities.WSGeneralInterface;

public class UsuarioLogic implements WSGeneralInterface {
	/**
	 * Funcion la cual se encarga de llamar el Web Service para el cambio de
	 * contraseña
	 * 
	 * @return
	 */
	public boolean cambiaContrausuario(UsuarioEntity usuario) {
		boolean rta = false;
		try {
			rta = conexionWSUsuario().getPortUsuario().cambiaClaveUsuario(usuario);
			//rta = conexionWSPrinSaf().getPortSafPrinc().cambiaClaveUsuario(usuario);
		} catch (Exception e) {
			return false;
		}
		return rta;
	}

}
