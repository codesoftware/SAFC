
package co.com.codesoftware.servicio.pedido;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para consultaPedidosXEstadoResponse complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="consultaPedidosXEstadoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PedidoEntity" type="{http://pedido.servicio.codesoftware.com.co/}pedidoEntity" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultaPedidosXEstadoResponse", propOrder = {
    "pedidoEntity"
})
public class ConsultaPedidosXEstadoResponse {

    @XmlElement(name = "PedidoEntity")
    protected List<PedidoEntity> pedidoEntity;

    /**
     * Gets the value of the pedidoEntity property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pedidoEntity property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPedidoEntity().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PedidoEntity }
     * 
     * 
     */
    public List<PedidoEntity> getPedidoEntity() {
        if (pedidoEntity == null) {
            pedidoEntity = new ArrayList<PedidoEntity>();
        }
        return this.pedidoEntity;
    }

}
