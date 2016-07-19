package co.com.codesoftware.entities;

import co.com.codesoftware.servicio.conteos.ConteoWS;
import co.com.codesoftware.servicio.facturacion.FacturacionWS;
import co.com.codesoftware.servicio.general.GeneralWS;
import co.com.codesoftware.servicio.pedido.PedidoWS;
import co.com.codesoftware.servicio.producto.ProductoWS;
import co.com.codesoftware.servicio.usuario.UsuarioWS;

public class EntityWS {

	private String validaConexionCont;
	private ConteoWS portConteo;

	private String validaConexionProd;
	private ProductoWS portProd;

	private String validaConexionUsuario;
	private UsuarioWS portUsuario;

	private String validaConexionGeneral;
	private GeneralWS portGeneral;

	private String validaConexionFacturacion;
	private FacturacionWS portFacturacion;

	private String validaConexionPedido;
	private PedidoWS portPedido;

	public String getValidaConexionCont() {
		return validaConexionCont;
	}

	public void setValidaConexionCont(String validaConexionCont) {
		this.validaConexionCont = validaConexionCont;
	}

	public ConteoWS getPortConteo() {
		return portConteo;
	}

	public void setPortConteo(ConteoWS portConteo) {
		this.portConteo = portConteo;
	}

	public String getValidaConexionProd() {
		return validaConexionProd;
	}

	public void setValidaConexionProd(String validaConexionProd) {
		this.validaConexionProd = validaConexionProd;
	}

	public String getValidaConexionUsuario() {
		return validaConexionUsuario;
	}

	public void setValidaConexionUsuario(String validaConexionUsuario) {
		this.validaConexionUsuario = validaConexionUsuario;
	}

	public UsuarioWS getPortUsuario() {
		return portUsuario;
	}

	public void setPortUsuario(UsuarioWS portUsuario) {
		this.portUsuario = portUsuario;
	}

	public String getValidaConexionGeneral() {
		return validaConexionGeneral;
	}

	public void setValidaConexionGeneral(String validaConexionGeneral) {
		this.validaConexionGeneral = validaConexionGeneral;
	}

	public GeneralWS getPortGeneral() {
		return portGeneral;
	}

	public void setPortGeneral(GeneralWS portGeneral) {
		this.portGeneral = portGeneral;
	}

	public ProductoWS getPortProd() {
		return portProd;
	}

	public void setPortProd(ProductoWS portProd) {
		this.portProd = portProd;
	}

	public String getValidaConexionFacturacion() {
		return validaConexionFacturacion;
	}

	public void setValidaConexionFacturacion(String validaConexionFacturacion) {
		this.validaConexionFacturacion = validaConexionFacturacion;
	}

	public FacturacionWS getPortFacturacion() {
		return portFacturacion;
	}

	public void setPortFacturacion(FacturacionWS portFacturacion) {
		this.portFacturacion = portFacturacion;
	}

	public String getValidaConexionPedido() {
		return validaConexionPedido;
	}

	public void setValidaConexionPedido(String validaConexionPedido) {
		this.validaConexionPedido = validaConexionPedido;
	}

	public PedidoWS getPortPedido() {
		return portPedido;
	}

	public void setPortPedido(PedidoWS portPedido) {
		this.portPedido = portPedido;
	}

}
