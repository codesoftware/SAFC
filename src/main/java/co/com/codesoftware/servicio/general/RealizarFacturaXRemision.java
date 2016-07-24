
package co.com.codesoftware.servicio.general;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para realizarFacturaXRemision complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="realizarFacturaXRemision">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idRemision" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idTius" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idRsfa" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="diasPlazo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "realizarFacturaXRemision", propOrder = {
    "idRemision",
    "idTius",
    "idRsfa",
    "diasPlazo"
})
public class RealizarFacturaXRemision {

    protected int idRemision;
    protected int idTius;
    protected int idRsfa;
    protected int diasPlazo;

    /**
     * Obtiene el valor de la propiedad idRemision.
     * 
     */
    public int getIdRemision() {
        return idRemision;
    }

    /**
     * Define el valor de la propiedad idRemision.
     * 
     */
    public void setIdRemision(int value) {
        this.idRemision = value;
    }

    /**
     * Obtiene el valor de la propiedad idTius.
     * 
     */
    public int getIdTius() {
        return idTius;
    }

    /**
     * Define el valor de la propiedad idTius.
     * 
     */
    public void setIdTius(int value) {
        this.idTius = value;
    }

    /**
     * Obtiene el valor de la propiedad idRsfa.
     * 
     */
    public int getIdRsfa() {
        return idRsfa;
    }

    /**
     * Define el valor de la propiedad idRsfa.
     * 
     */
    public void setIdRsfa(int value) {
        this.idRsfa = value;
    }

    /**
     * Obtiene el valor de la propiedad diasPlazo.
     * 
     */
    public int getDiasPlazo() {
        return diasPlazo;
    }

    /**
     * Define el valor de la propiedad diasPlazo.
     * 
     */
    public void setDiasPlazo(int value) {
        this.diasPlazo = value;
    }

}
