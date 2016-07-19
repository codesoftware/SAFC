
package co.com.codesoftware.servicio.general;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the co.com.codesoftware.servicio.general package. 
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

    private final static QName _ObtenerParametrosEmpresa_QNAME = new QName("http://general.servicio.codesoftware.com.co/", "obtenerParametrosEmpresa");
    private final static QName _ObtenerSedesResponse_QNAME = new QName("http://general.servicio.codesoftware.com.co/", "obtenerSedesResponse");
    private final static QName _ObtenerRemisionesXClienteResponse_QNAME = new QName("http://general.servicio.codesoftware.com.co/", "obtenerRemisionesXClienteResponse");
    private final static QName _ObtenerResolucionesFactResponse_QNAME = new QName("http://general.servicio.codesoftware.com.co/", "obtenerResolucionesFactResponse");
    private final static QName _ObtenerRemisionesXCliente_QNAME = new QName("http://general.servicio.codesoftware.com.co/", "obtenerRemisionesXCliente");
    private final static QName _ActualizaResolucion_QNAME = new QName("http://general.servicio.codesoftware.com.co/", "actualizaResolucion");
    private final static QName _RealizarFacturaXRemisionResponse_QNAME = new QName("http://general.servicio.codesoftware.com.co/", "realizarFacturaXRemisionResponse");
    private final static QName _ActualizarSedeResponse_QNAME = new QName("http://general.servicio.codesoftware.com.co/", "actualizarSedeResponse");
    private final static QName _ActualizarSede_QNAME = new QName("http://general.servicio.codesoftware.com.co/", "actualizarSede");
    private final static QName _RealizarFacturaXRemision_QNAME = new QName("http://general.servicio.codesoftware.com.co/", "realizarFacturaXRemision");
    private final static QName _ObtenerSedes_QNAME = new QName("http://general.servicio.codesoftware.com.co/", "obtenerSedes");
    private final static QName _InsertarResolucionResponse_QNAME = new QName("http://general.servicio.codesoftware.com.co/", "insertarResolucionResponse");
    private final static QName _ObtenerDetalleRemisionResponse_QNAME = new QName("http://general.servicio.codesoftware.com.co/", "obtenerDetalleRemisionResponse");
    private final static QName _ActualizaResolucionResponse_QNAME = new QName("http://general.servicio.codesoftware.com.co/", "actualizaResolucionResponse");
    private final static QName _ObtenerDetalleRemision_QNAME = new QName("http://general.servicio.codesoftware.com.co/", "obtenerDetalleRemision");
    private final static QName _ObtenerParametrosEmpresaResponse_QNAME = new QName("http://general.servicio.codesoftware.com.co/", "obtenerParametrosEmpresaResponse");
    private final static QName _InsertarResolucion_QNAME = new QName("http://general.servicio.codesoftware.com.co/", "insertarResolucion");
    private final static QName _ObtenerResolucionesFact_QNAME = new QName("http://general.servicio.codesoftware.com.co/", "obtenerResolucionesFact");
    private final static QName _GeneraReportesResponse_QNAME = new QName("http://general.servicio.codesoftware.com.co/", "generaReportesResponse");
    private final static QName _GeneraReportes_QNAME = new QName("http://general.servicio.codesoftware.com.co/", "generaReportes");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: co.com.codesoftware.servicio.general
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ObtenerResolucionesFact }
     * 
     */
    public ObtenerResolucionesFact createObtenerResolucionesFact() {
        return new ObtenerResolucionesFact();
    }

    /**
     * Create an instance of {@link GeneraReportesResponse }
     * 
     */
    public GeneraReportesResponse createGeneraReportesResponse() {
        return new GeneraReportesResponse();
    }

    /**
     * Create an instance of {@link GeneraReportes }
     * 
     */
    public GeneraReportes createGeneraReportes() {
        return new GeneraReportes();
    }

    /**
     * Create an instance of {@link ObtenerDetalleRemision }
     * 
     */
    public ObtenerDetalleRemision createObtenerDetalleRemision() {
        return new ObtenerDetalleRemision();
    }

    /**
     * Create an instance of {@link ObtenerParametrosEmpresaResponse }
     * 
     */
    public ObtenerParametrosEmpresaResponse createObtenerParametrosEmpresaResponse() {
        return new ObtenerParametrosEmpresaResponse();
    }

    /**
     * Create an instance of {@link InsertarResolucion }
     * 
     */
    public InsertarResolucion createInsertarResolucion() {
        return new InsertarResolucion();
    }

    /**
     * Create an instance of {@link ObtenerDetalleRemisionResponse }
     * 
     */
    public ObtenerDetalleRemisionResponse createObtenerDetalleRemisionResponse() {
        return new ObtenerDetalleRemisionResponse();
    }

    /**
     * Create an instance of {@link ActualizaResolucionResponse }
     * 
     */
    public ActualizaResolucionResponse createActualizaResolucionResponse() {
        return new ActualizaResolucionResponse();
    }

    /**
     * Create an instance of {@link InsertarResolucionResponse }
     * 
     */
    public InsertarResolucionResponse createInsertarResolucionResponse() {
        return new InsertarResolucionResponse();
    }

    /**
     * Create an instance of {@link ActualizarSede }
     * 
     */
    public ActualizarSede createActualizarSede() {
        return new ActualizarSede();
    }

    /**
     * Create an instance of {@link RealizarFacturaXRemision }
     * 
     */
    public RealizarFacturaXRemision createRealizarFacturaXRemision() {
        return new RealizarFacturaXRemision();
    }

    /**
     * Create an instance of {@link ObtenerSedes }
     * 
     */
    public ObtenerSedes createObtenerSedes() {
        return new ObtenerSedes();
    }

    /**
     * Create an instance of {@link ObtenerRemisionesXCliente }
     * 
     */
    public ObtenerRemisionesXCliente createObtenerRemisionesXCliente() {
        return new ObtenerRemisionesXCliente();
    }

    /**
     * Create an instance of {@link ActualizaResolucion }
     * 
     */
    public ActualizaResolucion createActualizaResolucion() {
        return new ActualizaResolucion();
    }

    /**
     * Create an instance of {@link RealizarFacturaXRemisionResponse }
     * 
     */
    public RealizarFacturaXRemisionResponse createRealizarFacturaXRemisionResponse() {
        return new RealizarFacturaXRemisionResponse();
    }

    /**
     * Create an instance of {@link ActualizarSedeResponse }
     * 
     */
    public ActualizarSedeResponse createActualizarSedeResponse() {
        return new ActualizarSedeResponse();
    }

    /**
     * Create an instance of {@link ObtenerResolucionesFactResponse }
     * 
     */
    public ObtenerResolucionesFactResponse createObtenerResolucionesFactResponse() {
        return new ObtenerResolucionesFactResponse();
    }

    /**
     * Create an instance of {@link ObtenerParametrosEmpresa }
     * 
     */
    public ObtenerParametrosEmpresa createObtenerParametrosEmpresa() {
        return new ObtenerParametrosEmpresa();
    }

    /**
     * Create an instance of {@link ObtenerSedesResponse }
     * 
     */
    public ObtenerSedesResponse createObtenerSedesResponse() {
        return new ObtenerSedesResponse();
    }

    /**
     * Create an instance of {@link ObtenerRemisionesXClienteResponse }
     * 
     */
    public ObtenerRemisionesXClienteResponse createObtenerRemisionesXClienteResponse() {
        return new ObtenerRemisionesXClienteResponse();
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
     * Create an instance of {@link ProductoEntity }
     * 
     */
    public ProductoEntity createProductoEntity() {
        return new ProductoEntity();
    }

    /**
     * Create an instance of {@link RemisionEntity }
     * 
     */
    public RemisionEntity createRemisionEntity() {
        return new RemisionEntity();
    }

    /**
     * Create an instance of {@link ClienteEntity }
     * 
     */
    public ClienteEntity createClienteEntity() {
        return new ClienteEntity();
    }

    /**
     * Create an instance of {@link DetProdRemision }
     * 
     */
    public DetProdRemision createDetProdRemision() {
        return new DetProdRemision();
    }

    /**
     * Create an instance of {@link SedeEntity }
     * 
     */
    public SedeEntity createSedeEntity() {
        return new SedeEntity();
    }

    /**
     * Create an instance of {@link ParametrosEmpresaEntity }
     * 
     */
    public ParametrosEmpresaEntity createParametrosEmpresaEntity() {
        return new ParametrosEmpresaEntity();
    }

    /**
     * Create an instance of {@link PerfilEntity }
     * 
     */
    public PerfilEntity createPerfilEntity() {
        return new PerfilEntity();
    }

    /**
     * Create an instance of {@link SubCuentaEntity }
     * 
     */
    public SubCuentaEntity createSubCuentaEntity() {
        return new SubCuentaEntity();
    }

    /**
     * Create an instance of {@link ResolucionFactEntity }
     * 
     */
    public ResolucionFactEntity createResolucionFactEntity() {
        return new ResolucionFactEntity();
    }

    /**
     * Create an instance of {@link MapaEntity }
     * 
     */
    public MapaEntity createMapaEntity() {
        return new MapaEntity();
    }

    /**
     * Create an instance of {@link CategoriaEntity }
     * 
     */
    public CategoriaEntity createCategoriaEntity() {
        return new CategoriaEntity();
    }

    /**
     * Create an instance of {@link MarcaEntity }
     * 
     */
    public MarcaEntity createMarcaEntity() {
        return new MarcaEntity();
    }

    /**
     * Create an instance of {@link ReferenciaEntity }
     * 
     */
    public ReferenciaEntity createReferenciaEntity() {
        return new ReferenciaEntity();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerParametrosEmpresa }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://general.servicio.codesoftware.com.co/", name = "obtenerParametrosEmpresa")
    public JAXBElement<ObtenerParametrosEmpresa> createObtenerParametrosEmpresa(ObtenerParametrosEmpresa value) {
        return new JAXBElement<ObtenerParametrosEmpresa>(_ObtenerParametrosEmpresa_QNAME, ObtenerParametrosEmpresa.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerSedesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://general.servicio.codesoftware.com.co/", name = "obtenerSedesResponse")
    public JAXBElement<ObtenerSedesResponse> createObtenerSedesResponse(ObtenerSedesResponse value) {
        return new JAXBElement<ObtenerSedesResponse>(_ObtenerSedesResponse_QNAME, ObtenerSedesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerRemisionesXClienteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://general.servicio.codesoftware.com.co/", name = "obtenerRemisionesXClienteResponse")
    public JAXBElement<ObtenerRemisionesXClienteResponse> createObtenerRemisionesXClienteResponse(ObtenerRemisionesXClienteResponse value) {
        return new JAXBElement<ObtenerRemisionesXClienteResponse>(_ObtenerRemisionesXClienteResponse_QNAME, ObtenerRemisionesXClienteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerResolucionesFactResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://general.servicio.codesoftware.com.co/", name = "obtenerResolucionesFactResponse")
    public JAXBElement<ObtenerResolucionesFactResponse> createObtenerResolucionesFactResponse(ObtenerResolucionesFactResponse value) {
        return new JAXBElement<ObtenerResolucionesFactResponse>(_ObtenerResolucionesFactResponse_QNAME, ObtenerResolucionesFactResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerRemisionesXCliente }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://general.servicio.codesoftware.com.co/", name = "obtenerRemisionesXCliente")
    public JAXBElement<ObtenerRemisionesXCliente> createObtenerRemisionesXCliente(ObtenerRemisionesXCliente value) {
        return new JAXBElement<ObtenerRemisionesXCliente>(_ObtenerRemisionesXCliente_QNAME, ObtenerRemisionesXCliente.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActualizaResolucion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://general.servicio.codesoftware.com.co/", name = "actualizaResolucion")
    public JAXBElement<ActualizaResolucion> createActualizaResolucion(ActualizaResolucion value) {
        return new JAXBElement<ActualizaResolucion>(_ActualizaResolucion_QNAME, ActualizaResolucion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RealizarFacturaXRemisionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://general.servicio.codesoftware.com.co/", name = "realizarFacturaXRemisionResponse")
    public JAXBElement<RealizarFacturaXRemisionResponse> createRealizarFacturaXRemisionResponse(RealizarFacturaXRemisionResponse value) {
        return new JAXBElement<RealizarFacturaXRemisionResponse>(_RealizarFacturaXRemisionResponse_QNAME, RealizarFacturaXRemisionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActualizarSedeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://general.servicio.codesoftware.com.co/", name = "actualizarSedeResponse")
    public JAXBElement<ActualizarSedeResponse> createActualizarSedeResponse(ActualizarSedeResponse value) {
        return new JAXBElement<ActualizarSedeResponse>(_ActualizarSedeResponse_QNAME, ActualizarSedeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActualizarSede }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://general.servicio.codesoftware.com.co/", name = "actualizarSede")
    public JAXBElement<ActualizarSede> createActualizarSede(ActualizarSede value) {
        return new JAXBElement<ActualizarSede>(_ActualizarSede_QNAME, ActualizarSede.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RealizarFacturaXRemision }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://general.servicio.codesoftware.com.co/", name = "realizarFacturaXRemision")
    public JAXBElement<RealizarFacturaXRemision> createRealizarFacturaXRemision(RealizarFacturaXRemision value) {
        return new JAXBElement<RealizarFacturaXRemision>(_RealizarFacturaXRemision_QNAME, RealizarFacturaXRemision.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerSedes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://general.servicio.codesoftware.com.co/", name = "obtenerSedes")
    public JAXBElement<ObtenerSedes> createObtenerSedes(ObtenerSedes value) {
        return new JAXBElement<ObtenerSedes>(_ObtenerSedes_QNAME, ObtenerSedes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertarResolucionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://general.servicio.codesoftware.com.co/", name = "insertarResolucionResponse")
    public JAXBElement<InsertarResolucionResponse> createInsertarResolucionResponse(InsertarResolucionResponse value) {
        return new JAXBElement<InsertarResolucionResponse>(_InsertarResolucionResponse_QNAME, InsertarResolucionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerDetalleRemisionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://general.servicio.codesoftware.com.co/", name = "obtenerDetalleRemisionResponse")
    public JAXBElement<ObtenerDetalleRemisionResponse> createObtenerDetalleRemisionResponse(ObtenerDetalleRemisionResponse value) {
        return new JAXBElement<ObtenerDetalleRemisionResponse>(_ObtenerDetalleRemisionResponse_QNAME, ObtenerDetalleRemisionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActualizaResolucionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://general.servicio.codesoftware.com.co/", name = "actualizaResolucionResponse")
    public JAXBElement<ActualizaResolucionResponse> createActualizaResolucionResponse(ActualizaResolucionResponse value) {
        return new JAXBElement<ActualizaResolucionResponse>(_ActualizaResolucionResponse_QNAME, ActualizaResolucionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerDetalleRemision }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://general.servicio.codesoftware.com.co/", name = "obtenerDetalleRemision")
    public JAXBElement<ObtenerDetalleRemision> createObtenerDetalleRemision(ObtenerDetalleRemision value) {
        return new JAXBElement<ObtenerDetalleRemision>(_ObtenerDetalleRemision_QNAME, ObtenerDetalleRemision.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerParametrosEmpresaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://general.servicio.codesoftware.com.co/", name = "obtenerParametrosEmpresaResponse")
    public JAXBElement<ObtenerParametrosEmpresaResponse> createObtenerParametrosEmpresaResponse(ObtenerParametrosEmpresaResponse value) {
        return new JAXBElement<ObtenerParametrosEmpresaResponse>(_ObtenerParametrosEmpresaResponse_QNAME, ObtenerParametrosEmpresaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertarResolucion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://general.servicio.codesoftware.com.co/", name = "insertarResolucion")
    public JAXBElement<InsertarResolucion> createInsertarResolucion(InsertarResolucion value) {
        return new JAXBElement<InsertarResolucion>(_InsertarResolucion_QNAME, InsertarResolucion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerResolucionesFact }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://general.servicio.codesoftware.com.co/", name = "obtenerResolucionesFact")
    public JAXBElement<ObtenerResolucionesFact> createObtenerResolucionesFact(ObtenerResolucionesFact value) {
        return new JAXBElement<ObtenerResolucionesFact>(_ObtenerResolucionesFact_QNAME, ObtenerResolucionesFact.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeneraReportesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://general.servicio.codesoftware.com.co/", name = "generaReportesResponse")
    public JAXBElement<GeneraReportesResponse> createGeneraReportesResponse(GeneraReportesResponse value) {
        return new JAXBElement<GeneraReportesResponse>(_GeneraReportesResponse_QNAME, GeneraReportesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeneraReportes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://general.servicio.codesoftware.com.co/", name = "generaReportes")
    public JAXBElement<GeneraReportes> createGeneraReportes(GeneraReportes value) {
        return new JAXBElement<GeneraReportes>(_GeneraReportes_QNAME, GeneraReportes.class, null, value);
    }

}
