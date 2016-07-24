package co.com.codesoftware.entities;

import java.io.Serializable;
import java.util.List;


import co.com.codesoftware.servicio.general.ParametrosEmpresaEntity;
import co.com.codesoftware.servicio.usuario.SedeEntity;
import co.com.codesoftware.servicio.usuario.UsuarioEntity;

public class DatosSessionEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<ParametrosEmpresaEntity> dataCompany;
	private UsuarioEntity dataUser;
	private SedeEntity sede;

	public List<ParametrosEmpresaEntity> getDataCompany() {
		return dataCompany;
	}

	public void setDataCompany(List<ParametrosEmpresaEntity> dataCompany) {
		this.dataCompany = dataCompany;
	}

	public SedeEntity getSede() {
		return sede;
	}

	public void setSede(SedeEntity sede) {
		this.sede = sede;
	}

	public UsuarioEntity getDataUser() {
		return dataUser;
	}

	public void setDataUser(UsuarioEntity dataUser) {
		this.dataUser = dataUser;
	}

}
