package co.com.codesoftware.mb;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import co.com.codesoftware.entities.DatosSessionEntity;
import co.com.codesoftware.logic.UsuarioLogic;
import co.com.codesoftware.servicio.usuario.UsuarioEntity;

@ManagedBean
@ViewScoped
public class CambioContraBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String contraPrinci;
	private String contraSecund;
	private String usuario;
	private DatosSessionEntity entitySession;
	private String permisosUsuario;

	@PostConstruct
	public void init() {
		FacesContext context = FacesContext.getCurrentInstance();
		this.entitySession = (DatosSessionEntity) context.getExternalContext().getSessionMap().get("dataSession");
		this.permisosUsuario = (String) context.getExternalContext().getSessionMap().get("permisosUsuario");
	}

	public String getContraPrinci() {
		return contraPrinci;
	}

	public void setContraPrinci(String contraPrinci) {
		this.contraPrinci = contraPrinci;
	}

	public String getContraSecund() {
		return contraSecund;
	}

	public void setContraSecund(String contraSecund) {
		this.contraSecund = contraSecund;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * Funcion con la cual se genera la accion de cambiar la clave
	 * obligatoriamente
	 * 
	 * @return
	 */
	public String cambiaContrasenaObliga() {
		String redireccion = "";
		try {
			if (contraPrinci.equals(contraSecund)) {
				if (contraPrinci.length() > 7) {
					UsuarioEntity usuario = new UsuarioEntity();
					usuario.setUsuario(this.usuario);
					usuario.setPassword(contraPrinci);
					UsuarioLogic usuarioLogic = new UsuarioLogic();
					boolean rta = usuarioLogic.cambiaContrausuario(usuario);
					if (rta) {
						FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Exitoso", "Contraseña actualiza correctamente, ingrese al sistemada con su nueva contraseñas");
						FacesContext.getCurrentInstance().addMessage(null, message);
						redireccion = "/index";
					} else {
						FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al actualzar la contraseña");
						FacesContext.getCurrentInstance().addMessage(null, message);
					}

				} else {
					FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "La contraseña puede tener minimo siete caracteres");
					FacesContext.getCurrentInstance().addMessage(null, message);
				}
			} else {
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Las contraseñas no coinciden", "Error");
				FacesContext.getCurrentInstance().addMessage(null, message);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return redireccion;
	}

	/**
	 * Funcion con la cual se genera la accion de cambiar la clave en cualquier
	 * momento
	 * 
	 * @return
	 */
	public String cambiaContrasena() {
		String redireccion = "";
		try {
			this.usuario = this.obtieneUsuarioSession();
			if (this.usuario == null) {
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al obtener tu usuario de la sesión", "Error");
				FacesContext.getCurrentInstance().addMessage(null, message);
			} else {
				if (contraPrinci.equals(contraSecund)) {
					if (contraPrinci.length() > 7) {
						UsuarioEntity usuario = new UsuarioEntity();
						usuario.setUsuario(this.usuario);
						usuario.setPassword(contraPrinci);
						UsuarioLogic usuarioLogic = new UsuarioLogic();
						boolean rta = usuarioLogic.cambiaContrausuario(usuario);
						if (rta) {
							FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Contraseña actualizada correctamente, ingrese al sistema con su nueva contraseña", "Exitoso");
							FacesContext.getCurrentInstance().addMessage(null, message);
							redireccion = "/index";
						} else {
							FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al actualzar la contraseña", "Error");
							FacesContext.getCurrentInstance().addMessage(null, message);
						}

					} else {
						FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "La contraseña puede tener minimo siete caracteres", "Error");
						FacesContext.getCurrentInstance().addMessage(null, message);
					}
				} else {
					FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Las contraseñas no coinciden", "Error");
					FacesContext.getCurrentInstance().addMessage(null, message);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return redireccion;
	}

	/**
	 * Funcion con la cual obtengo el usuario de la sesion
	 * 
	 * @return
	 */
	public String obtieneUsuarioSession() {
		String usuario = null;
		try {
			DatosSessionEntity dataSession = (DatosSessionEntity) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("dataSession");
			usuario = dataSession.getDataUser().getUsuario();
		} catch (Exception e) {
			usuario = null;
			e.printStackTrace();
		}
		return usuario;
	}

	public DatosSessionEntity getEntitySession() {
		return entitySession;
	}

	public void setEntitySession(DatosSessionEntity entitySession) {
		this.entitySession = entitySession;
	}

	public String getPermisosUsuario() {
		return permisosUsuario;
	}

	public void setPermisosUsuario(String permisosUsuario) {
		this.permisosUsuario = permisosUsuario;
	}

}
