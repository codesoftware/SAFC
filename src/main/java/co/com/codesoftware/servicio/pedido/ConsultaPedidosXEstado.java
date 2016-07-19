
package co.com.codesoftware.servicio.pedido;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para consultaPedidosXEstado complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="consultaPedidosXEstado">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="pedi_estado" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultaPedidosXEstado", propOrder = {
    "pediEstado"
})
public class ConsultaPedidosXEstado {

    @XmlElement(name = "pedi_estado", required = true)
    protected String pediEstado;

    /**
     * Obtiene el valor de la propiedad pediEstado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPediEstado() {
        return pediEstado;
    }

    /**
     * Define el valor de la propiedad pediEstado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPediEstado(String value) {
        this.pediEstado = value;
    }

}
