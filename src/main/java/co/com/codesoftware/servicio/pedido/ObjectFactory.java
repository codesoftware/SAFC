
package co.com.codesoftware.servicio.pedido;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the co.com.codesoftware.servicio.pedido package. 
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

    private final static QName _GeneraPdfCotizacionResponse_QNAME = new QName("http://pedido.servicio.codesoftware.com.co/", "generaPdfCotizacionResponse");
    private final static QName _InsertaPedidosProducto_QNAME = new QName("http://pedido.servicio.codesoftware.com.co/", "insertaPedidosProducto");
    private final static QName _ObtenerRemisionesPorClienteResponse_QNAME = new QName("http://pedido.servicio.codesoftware.com.co/", "obtenerRemisionesPorClienteResponse");
    private final static QName _ConsultaPedidosXEstadoResponse_QNAME = new QName("http://pedido.servicio.codesoftware.com.co/", "consultaPedidosXEstadoResponse");
    private final static QName _ObtenerRemisionesPorCliente_QNAME = new QName("http://pedido.servicio.codesoftware.com.co/", "obtenerRemisionesPorCliente");
    private final static QName _ObtenerProductosPedido_QNAME = new QName("http://pedido.servicio.codesoftware.com.co/", "obtenerProductosPedido");
    private final static QName _CambiaEstadoPedido_QNAME = new QName("http://pedido.servicio.codesoftware.com.co/", "cambiaEstadoPedido");
    private final static QName _ObtenerPedidoXId_QNAME = new QName("http://pedido.servicio.codesoftware.com.co/", "obtenerPedidoXId");
    private final static QName _InsertaProductosXPedidoResponse_QNAME = new QName("http://pedido.servicio.codesoftware.com.co/", "insertaProductosXPedidoResponse");
    private final static QName _ConsultaPedidosXFiltros_QNAME = new QName("http://pedido.servicio.codesoftware.com.co/", "consultaPedidosXFiltros");
    private final static QName _ConsultaPedidosXEstado_QNAME = new QName("http://pedido.servicio.codesoftware.com.co/", "consultaPedidosXEstado");
    private final static QName _CambiaEstadoPedidoResponse_QNAME = new QName("http://pedido.servicio.codesoftware.com.co/", "cambiaEstadoPedidoResponse");
    private final static QName _ObtenerDatPrincPedidoXIdResponse_QNAME = new QName("http://pedido.servicio.codesoftware.com.co/", "obtenerDatPrincPedidoXIdResponse");
    private final static QName _GenerarRemisionResponse_QNAME = new QName("http://pedido.servicio.codesoftware.com.co/", "generarRemisionResponse");
    private final static QName _ObtenerDatPrincPedidoXId_QNAME = new QName("http://pedido.servicio.codesoftware.com.co/", "obtenerDatPrincPedidoXId");
    private final static QName _EliminaPedidoResponse_QNAME = new QName("http://pedido.servicio.codesoftware.com.co/", "eliminaPedidoResponse");
    private final static QName _ObtenerPedidoXIdResponse_QNAME = new QName("http://pedido.servicio.codesoftware.com.co/", "obtenerPedidoXIdResponse");
    private final static QName _InsertaProductosXPedido_QNAME = new QName("http://pedido.servicio.codesoftware.com.co/", "insertaProductosXPedido");
    private final static QName _BuscaCotizacionPorClienteResponse_QNAME = new QName("http://pedido.servicio.codesoftware.com.co/", "buscaCotizacionPorClienteResponse");
    private final static QName _GeneraCodigoPedido_QNAME = new QName("http://pedido.servicio.codesoftware.com.co/", "generaCodigoPedido");
    private final static QName _GeneraCodigoPedidoResponse_QNAME = new QName("http://pedido.servicio.codesoftware.com.co/", "generaCodigoPedidoResponse");
    private final static QName _EliminaPedido_QNAME = new QName("http://pedido.servicio.codesoftware.com.co/", "eliminaPedido");
    private final static QName _GeneraPdfCotizacion_QNAME = new QName("http://pedido.servicio.codesoftware.com.co/", "generaPdfCotizacion");
    private final static QName _GenerarRemision_QNAME = new QName("http://pedido.servicio.codesoftware.com.co/", "generarRemision");
    private final static QName _ObtenerProductosPedidoResponse_QNAME = new QName("http://pedido.servicio.codesoftware.com.co/", "obtenerProductosPedidoResponse");
    private final static QName _InsertaPedidosProductoResponse_QNAME = new QName("http://pedido.servicio.codesoftware.com.co/", "insertaPedidosProductoResponse");
    private final static QName _ConsultaPedidosXFiltrosResponse_QNAME = new QName("http://pedido.servicio.codesoftware.com.co/", "consultaPedidosXFiltrosResponse");
    private final static QName _BuscaCotizacionPorCliente_QNAME = new QName("http://pedido.servicio.codesoftware.com.co/", "buscaCotizacionPorCliente");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: co.com.codesoftware.servicio.pedido
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GenerarRemisionResponse }
     * 
     */
    public GenerarRemisionResponse createGenerarRemisionResponse() {
        return new GenerarRemisionResponse();
    }

    /**
     * Create an instance of {@link InsertaProductosXPedido }
     * 
     */
    public InsertaProductosXPedido createInsertaProductosXPedido() {
        return new InsertaProductosXPedido();
    }

    /**
     * Create an instance of {@link EliminaPedidoResponse }
     * 
     */
    public EliminaPedidoResponse createEliminaPedidoResponse() {
        return new EliminaPedidoResponse();
    }

    /**
     * Create an instance of {@link ObtenerPedidoXIdResponse }
     * 
     */
    public ObtenerPedidoXIdResponse createObtenerPedidoXIdResponse() {
        return new ObtenerPedidoXIdResponse();
    }

    /**
     * Create an instance of {@link ObtenerDatPrincPedidoXId }
     * 
     */
    public ObtenerDatPrincPedidoXId createObtenerDatPrincPedidoXId() {
        return new ObtenerDatPrincPedidoXId();
    }

    /**
     * Create an instance of {@link EliminaPedido }
     * 
     */
    public EliminaPedido createEliminaPedido() {
        return new EliminaPedido();
    }

    /**
     * Create an instance of {@link GeneraPdfCotizacion }
     * 
     */
    public GeneraPdfCotizacion createGeneraPdfCotizacion() {
        return new GeneraPdfCotizacion();
    }

    /**
     * Create an instance of {@link GenerarRemision }
     * 
     */
    public GenerarRemision createGenerarRemision() {
        return new GenerarRemision();
    }

    /**
     * Create an instance of {@link InsertaPedidosProductoResponse }
     * 
     */
    public InsertaPedidosProductoResponse createInsertaPedidosProductoResponse() {
        return new InsertaPedidosProductoResponse();
    }

    /**
     * Create an instance of {@link ObtenerProductosPedidoResponse }
     * 
     */
    public ObtenerProductosPedidoResponse createObtenerProductosPedidoResponse() {
        return new ObtenerProductosPedidoResponse();
    }

    /**
     * Create an instance of {@link GeneraCodigoPedido }
     * 
     */
    public GeneraCodigoPedido createGeneraCodigoPedido() {
        return new GeneraCodigoPedido();
    }

    /**
     * Create an instance of {@link BuscaCotizacionPorClienteResponse }
     * 
     */
    public BuscaCotizacionPorClienteResponse createBuscaCotizacionPorClienteResponse() {
        return new BuscaCotizacionPorClienteResponse();
    }

    /**
     * Create an instance of {@link GeneraCodigoPedidoResponse }
     * 
     */
    public GeneraCodigoPedidoResponse createGeneraCodigoPedidoResponse() {
        return new GeneraCodigoPedidoResponse();
    }

    /**
     * Create an instance of {@link ConsultaPedidosXFiltrosResponse }
     * 
     */
    public ConsultaPedidosXFiltrosResponse createConsultaPedidosXFiltrosResponse() {
        return new ConsultaPedidosXFiltrosResponse();
    }

    /**
     * Create an instance of {@link BuscaCotizacionPorCliente }
     * 
     */
    public BuscaCotizacionPorCliente createBuscaCotizacionPorCliente() {
        return new BuscaCotizacionPorCliente();
    }

    /**
     * Create an instance of {@link ConsultaPedidosXEstadoResponse }
     * 
     */
    public ConsultaPedidosXEstadoResponse createConsultaPedidosXEstadoResponse() {
        return new ConsultaPedidosXEstadoResponse();
    }

    /**
     * Create an instance of {@link GeneraPdfCotizacionResponse }
     * 
     */
    public GeneraPdfCotizacionResponse createGeneraPdfCotizacionResponse() {
        return new GeneraPdfCotizacionResponse();
    }

    /**
     * Create an instance of {@link InsertaPedidosProducto }
     * 
     */
    public InsertaPedidosProducto createInsertaPedidosProducto() {
        return new InsertaPedidosProducto();
    }

    /**
     * Create an instance of {@link ObtenerRemisionesPorClienteResponse }
     * 
     */
    public ObtenerRemisionesPorClienteResponse createObtenerRemisionesPorClienteResponse() {
        return new ObtenerRemisionesPorClienteResponse();
    }

    /**
     * Create an instance of {@link ObtenerProductosPedido }
     * 
     */
    public ObtenerProductosPedido createObtenerProductosPedido() {
        return new ObtenerProductosPedido();
    }

    /**
     * Create an instance of {@link ObtenerRemisionesPorCliente }
     * 
     */
    public ObtenerRemisionesPorCliente createObtenerRemisionesPorCliente() {
        return new ObtenerRemisionesPorCliente();
    }

    /**
     * Create an instance of {@link ObtenerPedidoXId }
     * 
     */
    public ObtenerPedidoXId createObtenerPedidoXId() {
        return new ObtenerPedidoXId();
    }

    /**
     * Create an instance of {@link CambiaEstadoPedido }
     * 
     */
    public CambiaEstadoPedido createCambiaEstadoPedido() {
        return new CambiaEstadoPedido();
    }

    /**
     * Create an instance of {@link ConsultaPedidosXFiltros }
     * 
     */
    public ConsultaPedidosXFiltros createConsultaPedidosXFiltros() {
        return new ConsultaPedidosXFiltros();
    }

    /**
     * Create an instance of {@link InsertaProductosXPedidoResponse }
     * 
     */
    public InsertaProductosXPedidoResponse createInsertaProductosXPedidoResponse() {
        return new InsertaProductosXPedidoResponse();
    }

    /**
     * Create an instance of {@link ConsultaPedidosXEstado }
     * 
     */
    public ConsultaPedidosXEstado createConsultaPedidosXEstado() {
        return new ConsultaPedidosXEstado();
    }

    /**
     * Create an instance of {@link CambiaEstadoPedidoResponse }
     * 
     */
    public CambiaEstadoPedidoResponse createCambiaEstadoPedidoResponse() {
        return new CambiaEstadoPedidoResponse();
    }

    /**
     * Create an instance of {@link ObtenerDatPrincPedidoXIdResponse }
     * 
     */
    public ObtenerDatPrincPedidoXIdResponse createObtenerDatPrincPedidoXIdResponse() {
        return new ObtenerDatPrincPedidoXIdResponse();
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
     * Create an instance of {@link PedidoEntity }
     * 
     */
    public PedidoEntity createPedidoEntity() {
        return new PedidoEntity();
    }

    /**
     * Create an instance of {@link ProductoGenEntity }
     * 
     */
    public ProductoGenEntity createProductoGenEntity() {
        return new ProductoGenEntity();
    }

    /**
     * Create an instance of {@link RespuestaEntity }
     * 
     */
    public RespuestaEntity createRespuestaEntity() {
        return new RespuestaEntity();
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
     * Create an instance of {@link PerfilEntity }
     * 
     */
    public PerfilEntity createPerfilEntity() {
        return new PerfilEntity();
    }

    /**
     * Create an instance of {@link RespuestaPedidoEntity }
     * 
     */
    public RespuestaPedidoEntity createRespuestaPedidoEntity() {
        return new RespuestaPedidoEntity();
    }

    /**
     * Create an instance of {@link PedidoProductoEntity }
     * 
     */
    public PedidoProductoEntity createPedidoProductoEntity() {
        return new PedidoProductoEntity();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeneraPdfCotizacionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pedido.servicio.codesoftware.com.co/", name = "generaPdfCotizacionResponse")
    public JAXBElement<GeneraPdfCotizacionResponse> createGeneraPdfCotizacionResponse(GeneraPdfCotizacionResponse value) {
        return new JAXBElement<GeneraPdfCotizacionResponse>(_GeneraPdfCotizacionResponse_QNAME, GeneraPdfCotizacionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertaPedidosProducto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pedido.servicio.codesoftware.com.co/", name = "insertaPedidosProducto")
    public JAXBElement<InsertaPedidosProducto> createInsertaPedidosProducto(InsertaPedidosProducto value) {
        return new JAXBElement<InsertaPedidosProducto>(_InsertaPedidosProducto_QNAME, InsertaPedidosProducto.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerRemisionesPorClienteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pedido.servicio.codesoftware.com.co/", name = "obtenerRemisionesPorClienteResponse")
    public JAXBElement<ObtenerRemisionesPorClienteResponse> createObtenerRemisionesPorClienteResponse(ObtenerRemisionesPorClienteResponse value) {
        return new JAXBElement<ObtenerRemisionesPorClienteResponse>(_ObtenerRemisionesPorClienteResponse_QNAME, ObtenerRemisionesPorClienteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultaPedidosXEstadoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pedido.servicio.codesoftware.com.co/", name = "consultaPedidosXEstadoResponse")
    public JAXBElement<ConsultaPedidosXEstadoResponse> createConsultaPedidosXEstadoResponse(ConsultaPedidosXEstadoResponse value) {
        return new JAXBElement<ConsultaPedidosXEstadoResponse>(_ConsultaPedidosXEstadoResponse_QNAME, ConsultaPedidosXEstadoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerRemisionesPorCliente }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pedido.servicio.codesoftware.com.co/", name = "obtenerRemisionesPorCliente")
    public JAXBElement<ObtenerRemisionesPorCliente> createObtenerRemisionesPorCliente(ObtenerRemisionesPorCliente value) {
        return new JAXBElement<ObtenerRemisionesPorCliente>(_ObtenerRemisionesPorCliente_QNAME, ObtenerRemisionesPorCliente.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerProductosPedido }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pedido.servicio.codesoftware.com.co/", name = "obtenerProductosPedido")
    public JAXBElement<ObtenerProductosPedido> createObtenerProductosPedido(ObtenerProductosPedido value) {
        return new JAXBElement<ObtenerProductosPedido>(_ObtenerProductosPedido_QNAME, ObtenerProductosPedido.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CambiaEstadoPedido }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pedido.servicio.codesoftware.com.co/", name = "cambiaEstadoPedido")
    public JAXBElement<CambiaEstadoPedido> createCambiaEstadoPedido(CambiaEstadoPedido value) {
        return new JAXBElement<CambiaEstadoPedido>(_CambiaEstadoPedido_QNAME, CambiaEstadoPedido.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerPedidoXId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pedido.servicio.codesoftware.com.co/", name = "obtenerPedidoXId")
    public JAXBElement<ObtenerPedidoXId> createObtenerPedidoXId(ObtenerPedidoXId value) {
        return new JAXBElement<ObtenerPedidoXId>(_ObtenerPedidoXId_QNAME, ObtenerPedidoXId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertaProductosXPedidoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pedido.servicio.codesoftware.com.co/", name = "insertaProductosXPedidoResponse")
    public JAXBElement<InsertaProductosXPedidoResponse> createInsertaProductosXPedidoResponse(InsertaProductosXPedidoResponse value) {
        return new JAXBElement<InsertaProductosXPedidoResponse>(_InsertaProductosXPedidoResponse_QNAME, InsertaProductosXPedidoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultaPedidosXFiltros }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pedido.servicio.codesoftware.com.co/", name = "consultaPedidosXFiltros")
    public JAXBElement<ConsultaPedidosXFiltros> createConsultaPedidosXFiltros(ConsultaPedidosXFiltros value) {
        return new JAXBElement<ConsultaPedidosXFiltros>(_ConsultaPedidosXFiltros_QNAME, ConsultaPedidosXFiltros.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultaPedidosXEstado }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pedido.servicio.codesoftware.com.co/", name = "consultaPedidosXEstado")
    public JAXBElement<ConsultaPedidosXEstado> createConsultaPedidosXEstado(ConsultaPedidosXEstado value) {
        return new JAXBElement<ConsultaPedidosXEstado>(_ConsultaPedidosXEstado_QNAME, ConsultaPedidosXEstado.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CambiaEstadoPedidoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pedido.servicio.codesoftware.com.co/", name = "cambiaEstadoPedidoResponse")
    public JAXBElement<CambiaEstadoPedidoResponse> createCambiaEstadoPedidoResponse(CambiaEstadoPedidoResponse value) {
        return new JAXBElement<CambiaEstadoPedidoResponse>(_CambiaEstadoPedidoResponse_QNAME, CambiaEstadoPedidoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerDatPrincPedidoXIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pedido.servicio.codesoftware.com.co/", name = "obtenerDatPrincPedidoXIdResponse")
    public JAXBElement<ObtenerDatPrincPedidoXIdResponse> createObtenerDatPrincPedidoXIdResponse(ObtenerDatPrincPedidoXIdResponse value) {
        return new JAXBElement<ObtenerDatPrincPedidoXIdResponse>(_ObtenerDatPrincPedidoXIdResponse_QNAME, ObtenerDatPrincPedidoXIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenerarRemisionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pedido.servicio.codesoftware.com.co/", name = "generarRemisionResponse")
    public JAXBElement<GenerarRemisionResponse> createGenerarRemisionResponse(GenerarRemisionResponse value) {
        return new JAXBElement<GenerarRemisionResponse>(_GenerarRemisionResponse_QNAME, GenerarRemisionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerDatPrincPedidoXId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pedido.servicio.codesoftware.com.co/", name = "obtenerDatPrincPedidoXId")
    public JAXBElement<ObtenerDatPrincPedidoXId> createObtenerDatPrincPedidoXId(ObtenerDatPrincPedidoXId value) {
        return new JAXBElement<ObtenerDatPrincPedidoXId>(_ObtenerDatPrincPedidoXId_QNAME, ObtenerDatPrincPedidoXId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EliminaPedidoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pedido.servicio.codesoftware.com.co/", name = "eliminaPedidoResponse")
    public JAXBElement<EliminaPedidoResponse> createEliminaPedidoResponse(EliminaPedidoResponse value) {
        return new JAXBElement<EliminaPedidoResponse>(_EliminaPedidoResponse_QNAME, EliminaPedidoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerPedidoXIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pedido.servicio.codesoftware.com.co/", name = "obtenerPedidoXIdResponse")
    public JAXBElement<ObtenerPedidoXIdResponse> createObtenerPedidoXIdResponse(ObtenerPedidoXIdResponse value) {
        return new JAXBElement<ObtenerPedidoXIdResponse>(_ObtenerPedidoXIdResponse_QNAME, ObtenerPedidoXIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertaProductosXPedido }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pedido.servicio.codesoftware.com.co/", name = "insertaProductosXPedido")
    public JAXBElement<InsertaProductosXPedido> createInsertaProductosXPedido(InsertaProductosXPedido value) {
        return new JAXBElement<InsertaProductosXPedido>(_InsertaProductosXPedido_QNAME, InsertaProductosXPedido.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscaCotizacionPorClienteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pedido.servicio.codesoftware.com.co/", name = "buscaCotizacionPorClienteResponse")
    public JAXBElement<BuscaCotizacionPorClienteResponse> createBuscaCotizacionPorClienteResponse(BuscaCotizacionPorClienteResponse value) {
        return new JAXBElement<BuscaCotizacionPorClienteResponse>(_BuscaCotizacionPorClienteResponse_QNAME, BuscaCotizacionPorClienteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeneraCodigoPedido }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pedido.servicio.codesoftware.com.co/", name = "generaCodigoPedido")
    public JAXBElement<GeneraCodigoPedido> createGeneraCodigoPedido(GeneraCodigoPedido value) {
        return new JAXBElement<GeneraCodigoPedido>(_GeneraCodigoPedido_QNAME, GeneraCodigoPedido.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeneraCodigoPedidoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pedido.servicio.codesoftware.com.co/", name = "generaCodigoPedidoResponse")
    public JAXBElement<GeneraCodigoPedidoResponse> createGeneraCodigoPedidoResponse(GeneraCodigoPedidoResponse value) {
        return new JAXBElement<GeneraCodigoPedidoResponse>(_GeneraCodigoPedidoResponse_QNAME, GeneraCodigoPedidoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EliminaPedido }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pedido.servicio.codesoftware.com.co/", name = "eliminaPedido")
    public JAXBElement<EliminaPedido> createEliminaPedido(EliminaPedido value) {
        return new JAXBElement<EliminaPedido>(_EliminaPedido_QNAME, EliminaPedido.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeneraPdfCotizacion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pedido.servicio.codesoftware.com.co/", name = "generaPdfCotizacion")
    public JAXBElement<GeneraPdfCotizacion> createGeneraPdfCotizacion(GeneraPdfCotizacion value) {
        return new JAXBElement<GeneraPdfCotizacion>(_GeneraPdfCotizacion_QNAME, GeneraPdfCotizacion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenerarRemision }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pedido.servicio.codesoftware.com.co/", name = "generarRemision")
    public JAXBElement<GenerarRemision> createGenerarRemision(GenerarRemision value) {
        return new JAXBElement<GenerarRemision>(_GenerarRemision_QNAME, GenerarRemision.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerProductosPedidoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pedido.servicio.codesoftware.com.co/", name = "obtenerProductosPedidoResponse")
    public JAXBElement<ObtenerProductosPedidoResponse> createObtenerProductosPedidoResponse(ObtenerProductosPedidoResponse value) {
        return new JAXBElement<ObtenerProductosPedidoResponse>(_ObtenerProductosPedidoResponse_QNAME, ObtenerProductosPedidoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertaPedidosProductoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pedido.servicio.codesoftware.com.co/", name = "insertaPedidosProductoResponse")
    public JAXBElement<InsertaPedidosProductoResponse> createInsertaPedidosProductoResponse(InsertaPedidosProductoResponse value) {
        return new JAXBElement<InsertaPedidosProductoResponse>(_InsertaPedidosProductoResponse_QNAME, InsertaPedidosProductoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultaPedidosXFiltrosResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pedido.servicio.codesoftware.com.co/", name = "consultaPedidosXFiltrosResponse")
    public JAXBElement<ConsultaPedidosXFiltrosResponse> createConsultaPedidosXFiltrosResponse(ConsultaPedidosXFiltrosResponse value) {
        return new JAXBElement<ConsultaPedidosXFiltrosResponse>(_ConsultaPedidosXFiltrosResponse_QNAME, ConsultaPedidosXFiltrosResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscaCotizacionPorCliente }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pedido.servicio.codesoftware.com.co/", name = "buscaCotizacionPorCliente")
    public JAXBElement<BuscaCotizacionPorCliente> createBuscaCotizacionPorCliente(BuscaCotizacionPorCliente value) {
        return new JAXBElement<BuscaCotizacionPorCliente>(_BuscaCotizacionPorCliente_QNAME, BuscaCotizacionPorCliente.class, null, value);
    }

}
