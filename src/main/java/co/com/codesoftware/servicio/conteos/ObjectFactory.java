
package co.com.codesoftware.servicio.conteos;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the co.com.codesoftware.servicio.conteos package. 
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

    private final static QName _InsertaProductoConteo_QNAME = new QName("http://conteos.servicio.codesoftware.com.co/", "insertaProductoConteo");
    private final static QName _ObtenerConteoEstadoResponse_QNAME = new QName("http://conteos.servicio.codesoftware.com.co/", "obtenerConteoEstadoResponse");
    private final static QName _ObtenerProdConteoResponse_QNAME = new QName("http://conteos.servicio.codesoftware.com.co/", "obtenerProdConteoResponse");
    private final static QName _ObtenerProductosConteoResponse_QNAME = new QName("http://conteos.servicio.codesoftware.com.co/", "obtenerProductosConteoResponse");
    private final static QName _ObtenerConteoEstado_QNAME = new QName("http://conteos.servicio.codesoftware.com.co/", "obtenerConteoEstado");
    private final static QName _ObtenerProdConteo_QNAME = new QName("http://conteos.servicio.codesoftware.com.co/", "obtenerProdConteo");
    private final static QName _ObtenerProductosConteo_QNAME = new QName("http://conteos.servicio.codesoftware.com.co/", "obtenerProductosConteo");
    private final static QName _InsertaProductoConteoResponse_QNAME = new QName("http://conteos.servicio.codesoftware.com.co/", "insertaProductoConteoResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: co.com.codesoftware.servicio.conteos
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ObtenerConteoEstado }
     * 
     */
    public ObtenerConteoEstado createObtenerConteoEstado() {
        return new ObtenerConteoEstado();
    }

    /**
     * Create an instance of {@link ObtenerProdConteo }
     * 
     */
    public ObtenerProdConteo createObtenerProdConteo() {
        return new ObtenerProdConteo();
    }

    /**
     * Create an instance of {@link ObtenerProductosConteoResponse }
     * 
     */
    public ObtenerProductosConteoResponse createObtenerProductosConteoResponse() {
        return new ObtenerProductosConteoResponse();
    }

    /**
     * Create an instance of {@link ObtenerProductosConteo }
     * 
     */
    public ObtenerProductosConteo createObtenerProductosConteo() {
        return new ObtenerProductosConteo();
    }

    /**
     * Create an instance of {@link InsertaProductoConteoResponse }
     * 
     */
    public InsertaProductoConteoResponse createInsertaProductoConteoResponse() {
        return new InsertaProductoConteoResponse();
    }

    /**
     * Create an instance of {@link InsertaProductoConteo }
     * 
     */
    public InsertaProductoConteo createInsertaProductoConteo() {
        return new InsertaProductoConteo();
    }

    /**
     * Create an instance of {@link ObtenerConteoEstadoResponse }
     * 
     */
    public ObtenerConteoEstadoResponse createObtenerConteoEstadoResponse() {
        return new ObtenerConteoEstadoResponse();
    }

    /**
     * Create an instance of {@link ObtenerProdConteoResponse }
     * 
     */
    public ObtenerProdConteoResponse createObtenerProdConteoResponse() {
        return new ObtenerProdConteoResponse();
    }

    /**
     * Create an instance of {@link ConteoEntity }
     * 
     */
    public ConteoEntity createConteoEntity() {
        return new ConteoEntity();
    }

    /**
     * Create an instance of {@link ProductoEntity }
     * 
     */
    public ProductoEntity createProductoEntity() {
        return new ProductoEntity();
    }

    /**
     * Create an instance of {@link SubCuentaEntity }
     * 
     */
    public SubCuentaEntity createSubCuentaEntity() {
        return new SubCuentaEntity();
    }

    /**
     * Create an instance of {@link RespuestaEntity }
     * 
     */
    public RespuestaEntity createRespuestaEntity() {
        return new RespuestaEntity();
    }

    /**
     * Create an instance of {@link ProductoConteoEntity }
     * 
     */
    public ProductoConteoEntity createProductoConteoEntity() {
        return new ProductoConteoEntity();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertaProductoConteo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://conteos.servicio.codesoftware.com.co/", name = "insertaProductoConteo")
    public JAXBElement<InsertaProductoConteo> createInsertaProductoConteo(InsertaProductoConteo value) {
        return new JAXBElement<InsertaProductoConteo>(_InsertaProductoConteo_QNAME, InsertaProductoConteo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerConteoEstadoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://conteos.servicio.codesoftware.com.co/", name = "obtenerConteoEstadoResponse")
    public JAXBElement<ObtenerConteoEstadoResponse> createObtenerConteoEstadoResponse(ObtenerConteoEstadoResponse value) {
        return new JAXBElement<ObtenerConteoEstadoResponse>(_ObtenerConteoEstadoResponse_QNAME, ObtenerConteoEstadoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerProdConteoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://conteos.servicio.codesoftware.com.co/", name = "obtenerProdConteoResponse")
    public JAXBElement<ObtenerProdConteoResponse> createObtenerProdConteoResponse(ObtenerProdConteoResponse value) {
        return new JAXBElement<ObtenerProdConteoResponse>(_ObtenerProdConteoResponse_QNAME, ObtenerProdConteoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerProductosConteoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://conteos.servicio.codesoftware.com.co/", name = "obtenerProductosConteoResponse")
    public JAXBElement<ObtenerProductosConteoResponse> createObtenerProductosConteoResponse(ObtenerProductosConteoResponse value) {
        return new JAXBElement<ObtenerProductosConteoResponse>(_ObtenerProductosConteoResponse_QNAME, ObtenerProductosConteoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerConteoEstado }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://conteos.servicio.codesoftware.com.co/", name = "obtenerConteoEstado")
    public JAXBElement<ObtenerConteoEstado> createObtenerConteoEstado(ObtenerConteoEstado value) {
        return new JAXBElement<ObtenerConteoEstado>(_ObtenerConteoEstado_QNAME, ObtenerConteoEstado.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerProdConteo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://conteos.servicio.codesoftware.com.co/", name = "obtenerProdConteo")
    public JAXBElement<ObtenerProdConteo> createObtenerProdConteo(ObtenerProdConteo value) {
        return new JAXBElement<ObtenerProdConteo>(_ObtenerProdConteo_QNAME, ObtenerProdConteo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerProductosConteo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://conteos.servicio.codesoftware.com.co/", name = "obtenerProductosConteo")
    public JAXBElement<ObtenerProductosConteo> createObtenerProductosConteo(ObtenerProductosConteo value) {
        return new JAXBElement<ObtenerProductosConteo>(_ObtenerProductosConteo_QNAME, ObtenerProductosConteo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertaProductoConteoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://conteos.servicio.codesoftware.com.co/", name = "insertaProductoConteoResponse")
    public JAXBElement<InsertaProductoConteoResponse> createInsertaProductoConteoResponse(InsertaProductoConteoResponse value) {
        return new JAXBElement<InsertaProductoConteoResponse>(_InsertaProductoConteoResponse_QNAME, InsertaProductoConteoResponse.class, null, value);
    }

}
