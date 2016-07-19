
package co.com.codesoftware.servicio.usuario;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the co.com.codesoftware.servicio.usuario package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _UpdateClienteResponse_QNAME = new QName("http://usuario.servicio.codesoftware.com.co/", "updateClienteResponse");
    private final static QName _Login_QNAME = new QName("http://usuario.servicio.codesoftware.com.co/", "login");
    private final static QName _ObtenerClienteXCedula_QNAME = new QName("http://usuario.servicio.codesoftware.com.co/", "obtenerClienteXCedula");
    private final static QName _InsertaCliente_QNAME = new QName("http://usuario.servicio.codesoftware.com.co/", "insertaCliente");
    private final static QName _CambiaClaveUsuario_QNAME = new QName("http://usuario.servicio.codesoftware.com.co/", "cambiaClaveUsuario");
    private final static QName _ObtenerClientes_QNAME = new QName("http://usuario.servicio.codesoftware.com.co/", "obtenerClientes");
    private final static QName _ObtenerClienteXCedulaResponse_QNAME = new QName("http://usuario.servicio.codesoftware.com.co/", "obtenerClienteXCedulaResponse");
    private final static QName _ObtenerClientesResponse_QNAME = new QName("http://usuario.servicio.codesoftware.com.co/", "obtenerClientesResponse");
    private final static QName _CambiaClaveUsuarioResponse_QNAME = new QName("http://usuario.servicio.codesoftware.com.co/", "cambiaClaveUsuarioResponse");
    private final static QName _ObtenerUsuarioXUser_QNAME = new QName("http://usuario.servicio.codesoftware.com.co/", "obtenerUsuarioXUser");
    private final static QName _InsertaClienteResponse_QNAME = new QName("http://usuario.servicio.codesoftware.com.co/", "insertaClienteResponse");
    private final static QName _ObtenerUsuarioXUserResponse_QNAME = new QName("http://usuario.servicio.codesoftware.com.co/", "obtenerUsuarioXUserResponse");
    private final static QName _UpdateCliente_QNAME = new QName("http://usuario.servicio.codesoftware.com.co/", "updateCliente");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: co.com.codesoftware.servicio.usuario
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ObtenerClienteXCedulaResponse }
     * 
     */
    public ObtenerClienteXCedulaResponse createObtenerClienteXCedulaResponse() {
        return new ObtenerClienteXCedulaResponse();
    }

    /**
     * Create an instance of {@link ObtenerClientes }
     * 
     */
    public ObtenerClientes createObtenerClientes() {
        return new ObtenerClientes();
    }

    /**
     * Create an instance of {@link CambiaClaveUsuario }
     * 
     */
    public CambiaClaveUsuario createCambiaClaveUsuario() {
        return new CambiaClaveUsuario();
    }

    /**
     * Create an instance of {@link InsertaCliente }
     * 
     */
    public InsertaCliente createInsertaCliente() {
        return new InsertaCliente();
    }

    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link ObtenerClienteXCedula }
     * 
     */
    public ObtenerClienteXCedula createObtenerClienteXCedula() {
        return new ObtenerClienteXCedula();
    }

    /**
     * Create an instance of {@link UpdateClienteResponse }
     * 
     */
    public UpdateClienteResponse createUpdateClienteResponse() {
        return new UpdateClienteResponse();
    }

    /**
     * Create an instance of {@link UpdateCliente }
     * 
     */
    public UpdateCliente createUpdateCliente() {
        return new UpdateCliente();
    }

    /**
     * Create an instance of {@link InsertaClienteResponse }
     * 
     */
    public InsertaClienteResponse createInsertaClienteResponse() {
        return new InsertaClienteResponse();
    }

    /**
     * Create an instance of {@link ObtenerUsuarioXUserResponse }
     * 
     */
    public ObtenerUsuarioXUserResponse createObtenerUsuarioXUserResponse() {
        return new ObtenerUsuarioXUserResponse();
    }

    /**
     * Create an instance of {@link CambiaClaveUsuarioResponse }
     * 
     */
    public CambiaClaveUsuarioResponse createCambiaClaveUsuarioResponse() {
        return new CambiaClaveUsuarioResponse();
    }

    /**
     * Create an instance of {@link ObtenerUsuarioXUser }
     * 
     */
    public ObtenerUsuarioXUser createObtenerUsuarioXUser() {
        return new ObtenerUsuarioXUser();
    }

    /**
     * Create an instance of {@link ObtenerClientesResponse }
     * 
     */
    public ObtenerClientesResponse createObtenerClientesResponse() {
        return new ObtenerClientesResponse();
    }

    /**
     * Create an instance of {@link PersonaEntity }
     * 
     */
    public PersonaEntity createPersonaEntity() {
        return new PersonaEntity();
    }

    /**
     * Create an instance of {@link UsuarioEntity }
     * 
     */
    public UsuarioEntity createUsuarioEntity() {
        return new UsuarioEntity();
    }

    /**
     * Create an instance of {@link PerfilEntity }
     * 
     */
    public PerfilEntity createPerfilEntity() {
        return new PerfilEntity();
    }

    /**
     * Create an instance of {@link ClienteEntity }
     * 
     */
    public ClienteEntity createClienteEntity() {
        return new ClienteEntity();
    }

    /**
     * Create an instance of {@link SedeEntity }
     * 
     */
    public SedeEntity createSedeEntity() {
        return new SedeEntity();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateClienteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://usuario.servicio.codesoftware.com.co/", name = "updateClienteResponse")
    public JAXBElement<UpdateClienteResponse> createUpdateClienteResponse(UpdateClienteResponse value) {
        return new JAXBElement<UpdateClienteResponse>(_UpdateClienteResponse_QNAME, UpdateClienteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Login }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://usuario.servicio.codesoftware.com.co/", name = "login")
    public JAXBElement<Login> createLogin(Login value) {
        return new JAXBElement<Login>(_Login_QNAME, Login.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerClienteXCedula }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://usuario.servicio.codesoftware.com.co/", name = "obtenerClienteXCedula")
    public JAXBElement<ObtenerClienteXCedula> createObtenerClienteXCedula(ObtenerClienteXCedula value) {
        return new JAXBElement<ObtenerClienteXCedula>(_ObtenerClienteXCedula_QNAME, ObtenerClienteXCedula.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertaCliente }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://usuario.servicio.codesoftware.com.co/", name = "insertaCliente")
    public JAXBElement<InsertaCliente> createInsertaCliente(InsertaCliente value) {
        return new JAXBElement<InsertaCliente>(_InsertaCliente_QNAME, InsertaCliente.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CambiaClaveUsuario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://usuario.servicio.codesoftware.com.co/", name = "cambiaClaveUsuario")
    public JAXBElement<CambiaClaveUsuario> createCambiaClaveUsuario(CambiaClaveUsuario value) {
        return new JAXBElement<CambiaClaveUsuario>(_CambiaClaveUsuario_QNAME, CambiaClaveUsuario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerClientes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://usuario.servicio.codesoftware.com.co/", name = "obtenerClientes")
    public JAXBElement<ObtenerClientes> createObtenerClientes(ObtenerClientes value) {
        return new JAXBElement<ObtenerClientes>(_ObtenerClientes_QNAME, ObtenerClientes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerClienteXCedulaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://usuario.servicio.codesoftware.com.co/", name = "obtenerClienteXCedulaResponse")
    public JAXBElement<ObtenerClienteXCedulaResponse> createObtenerClienteXCedulaResponse(ObtenerClienteXCedulaResponse value) {
        return new JAXBElement<ObtenerClienteXCedulaResponse>(_ObtenerClienteXCedulaResponse_QNAME, ObtenerClienteXCedulaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerClientesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://usuario.servicio.codesoftware.com.co/", name = "obtenerClientesResponse")
    public JAXBElement<ObtenerClientesResponse> createObtenerClientesResponse(ObtenerClientesResponse value) {
        return new JAXBElement<ObtenerClientesResponse>(_ObtenerClientesResponse_QNAME, ObtenerClientesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CambiaClaveUsuarioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://usuario.servicio.codesoftware.com.co/", name = "cambiaClaveUsuarioResponse")
    public JAXBElement<CambiaClaveUsuarioResponse> createCambiaClaveUsuarioResponse(CambiaClaveUsuarioResponse value) {
        return new JAXBElement<CambiaClaveUsuarioResponse>(_CambiaClaveUsuarioResponse_QNAME, CambiaClaveUsuarioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerUsuarioXUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://usuario.servicio.codesoftware.com.co/", name = "obtenerUsuarioXUser")
    public JAXBElement<ObtenerUsuarioXUser> createObtenerUsuarioXUser(ObtenerUsuarioXUser value) {
        return new JAXBElement<ObtenerUsuarioXUser>(_ObtenerUsuarioXUser_QNAME, ObtenerUsuarioXUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertaClienteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://usuario.servicio.codesoftware.com.co/", name = "insertaClienteResponse")
    public JAXBElement<InsertaClienteResponse> createInsertaClienteResponse(InsertaClienteResponse value) {
        return new JAXBElement<InsertaClienteResponse>(_InsertaClienteResponse_QNAME, InsertaClienteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerUsuarioXUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://usuario.servicio.codesoftware.com.co/", name = "obtenerUsuarioXUserResponse")
    public JAXBElement<ObtenerUsuarioXUserResponse> createObtenerUsuarioXUserResponse(ObtenerUsuarioXUserResponse value) {
        return new JAXBElement<ObtenerUsuarioXUserResponse>(_ObtenerUsuarioXUserResponse_QNAME, ObtenerUsuarioXUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateCliente }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://usuario.servicio.codesoftware.com.co/", name = "updateCliente")
    public JAXBElement<UpdateCliente> createUpdateCliente(UpdateCliente value) {
        return new JAXBElement<UpdateCliente>(_UpdateCliente_QNAME, UpdateCliente.class, null, value);
    }

}
