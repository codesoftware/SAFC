package co.com.codesoftware.logic;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import co.com.codesoftware.servicio.facturacion.FacturaEntity;
import co.com.codesoftware.utilities.Conversions;
import co.com.codesoftware.utilities.WSGeneralInterface;

public class ConsultaFacturaLogic implements WSGeneralInterface {
	/**
	 * Funcion con la cual obtengo las facturas registradas en el sistema
	 * 
	 * @param fechaIni
	 * @param fechaFin
	 * @return
	 */
	public List<FacturaEntity> consultaFacturasRangoFechas(Date fechaIni, Date fechaFin, Integer idFactura, String idCliente, String codExterno) {
		List<FacturaEntity> rta = null;
		try {
			Conversions cn = new Conversions();
			rta = conexionWSFacturacion().getPortFacturacion().obtenerFacturasConFiltros(cn.dateToXMLGC(fechaIni), cn.dateToXMLGC(fechaFin), idFactura, Integer.parseInt(idCliente), codExterno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rta;
	}

	/**
	 * Funcion con la cual busco una factura por su id
	 * 
	 * @param id
	 * @return
	 */
	public FacturaEntity consutlaFacturaXId(int id) {
		FacturaEntity rta = null;
		try {
			rta = conexionWSFacturacion().getPortFacturacion().obtenerFacturaXId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rta;
	}

	/**
	 * Metodo en el cual se consulta la existencia de caja por sede
	 * 
	 * @param sede
	 * @return
	 */
	public BigDecimal consultaCajaXSede(Integer sede) {
		BigDecimal rta = null;
		try {
			rta = conexionWSFacturacion().getPortFacturacion().obtenerValorCaja(sede);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rta;
	}

}
