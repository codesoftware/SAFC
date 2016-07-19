package co.com.codesoftware.logic;

import java.util.ArrayList;
import java.util.List;

import co.com.codesoftware.servicio.general.ParametrosEmpresaEntity;
import co.com.codesoftware.servicio.general.SedeEntity;
import co.com.codesoftware.servicio.usuario.UsuarioEntity;
import co.com.codesoftware.utilities.WSGeneralInterface;

public class DataSessionLogic implements WSGeneralInterface {

	/**
	 * Metodo en el cual se obtiene la informacion basica de la compañoa
	 * @return
	 */
	public List<ParametrosEmpresaEntity> getDataCompany() {
		List<ParametrosEmpresaEntity> result = new ArrayList<>();
		try {
			//result = conexionWSPrinSaf().getPortSafPrinc().getParamsEmpresa();
			result = conexionWSGeneral().getPortGeneral().obtenerParametrosEmpresa();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * metodo que consulta las sedes del sistema y luego filtra por la del
	 * usuario
	 * 
	 * @return
	 */
	public SedeEntity consultaSedes(Integer sede) {
		SedeEntity sedeObjeto = new SedeEntity();
		try {
			List<SedeEntity> sedes = conexionWSGeneral().getPortGeneral().obtenerSedes();
			for (SedeEntity item : sedes) {
				if (item.getId() == sede) {
					sedeObjeto = item;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return sedeObjeto;
	}

	/**
	 * Funcion con la cual obtengo los datos de un usuario por medio de su
	 * usuario de acceso al sistema
	 * 
	 * @return
	 */
	public UsuarioEntity obtieneDatosUsuario(String user) {
		UsuarioEntity rta = null;
		try {
			rta = conexionWSUsuario().getPortUsuario().obtenerUsuarioXUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rta;
	}

	/**
	 * Funcion con la cual obtengo los permisos que tiene el usuario dentro de
	 * la aplicacion
	 * 
	 * @param usuario
	 */
	public String buscaPermisosUsuario(String usuario) {
		String permisos = "";
		try {
			UsuarioEntity usuarioEntity = conexionWSUsuario().getPortUsuario().obtenerUsuarioXUser(usuario);
			permisos = usuarioEntity.getPerfil().getPermisos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return permisos;
	}
}
