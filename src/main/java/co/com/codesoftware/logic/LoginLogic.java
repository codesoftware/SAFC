package co.com.codesoftware.logic;

import java.io.File;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.commons.io.FileUtils;

import co.com.codesoftware.servicio.usuario.UsuarioEntity;
import co.com.codesoftware.utilities.WSGeneralInterface;

public class LoginLogic implements WSGeneralInterface {
	/**
	 * Metodo el cual consulta la operacion del webservice que muestra el
	 * resultado del logueo
	 * 
	 * @param user
	 * @param password
	 * @return
	 */
	public String login(String user, String password) {
		List<String> listResponse = null;
		try {
			listResponse  = conexionWSUsuario().getPortUsuario().login(user, password);
		} catch (Exception e) {
			e.printStackTrace();
			return "Error_conexion";
		}
		return listResponse.get(0);
	}

	/**
	 * Metodo el cual valida si el usuario puede realizar facturacion o no
	 * 
	 * @param idTius
	 * @return
	 */
	public boolean permisoFacturador(UsuarioEntity usuario) {
		boolean rta = false;
		try {
			rta = usuario.getPerfil().getPermisos().contains(".FcCr1.");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return rta;
	}
	

	/**
	 * Funcion con la cual copio la imagen del servidor a la aplicacion para
	 * vizualizar en que aplicacion se encuentra
	 */
	public void copiaLogoServer(String rutaDestino) {
		try {
			File file = new File(rutaDestino);
			this.guardaImagenServidor(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
     * Funcion con la cual guardo la imagen en el repositorio de imagenes
     * @return 
     */
    public String guardaImagenServidor(File file){
        String rta = "Ok";
        try {
        	String rutaBase = this.obtieneParametroContext();
            File origen = new File(rutaBase+"logo.jpg");
            FileUtils.copyFile(origen, file);
        } catch (Exception e) {
            e.printStackTrace();
            rta = "Error "+ e;
        }
        return rta;
    }
    
    /**
     * Funcion con la cual obtengo la ruta base de sigemco para las aplicaciones
     * @return 
     */
    public String obtieneParametroContext() {
        String parametro = "";
        try {
           Context initCtx = new InitialContext();
           String envCtx = (String) initCtx.lookup("java:comp/env/RutaBaseApp");
            parametro = envCtx;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return parametro;
    }
}
