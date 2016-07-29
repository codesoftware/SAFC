package co.com.codesoftware.logic;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.xml.datatype.XMLGregorianCalendar;

import co.com.codesoftware.entities.DataBillEntity;
import co.com.codesoftware.entities.DataProductEntity;
import co.com.codesoftware.entities.DatosSessionEntity;
import co.com.codesoftware.entities.GenericProductEntity;
import co.com.codesoftware.servicio.facturacion.ClienteEntity;
import co.com.codesoftware.servicio.facturacion.FacturaEntity;
import co.com.codesoftware.servicio.facturacion.FacturacionGenEntity;
import co.com.codesoftware.servicio.facturacion.RespuestaFacturacion;
import co.com.codesoftware.servicio.facturacion.TemporalProdTable;
import co.com.codesoftware.servicio.facturacion.TemporalRecTable;
import co.com.codesoftware.servicio.producto.PrecioProductoEntity;
import co.com.codesoftware.utilities.WSGeneralInterface;

public class FacturacionLogic implements WSGeneralInterface {
	
	private List<TemporalProdTable> products;
	private List<TemporalRecTable> receta;
	private String factID;

	public String getFactID() {
		return factID;
	}

	public void setFactID(String factID) {
		this.factID = factID;
	}

	public List<TemporalProdTable> getProducts() {
		return products;
	}

	public void setProducts(List<TemporalProdTable> products) {
		this.products = products;
	}

	public List<TemporalRecTable> getReceta() {
		return receta;
	}

	public void setReceta(List<TemporalRecTable> receta) {
		this.receta = receta;
	}

	/**
	 * Funcion que hace la multiplicacion del precio del producto por la
	 * cantidad
	 * 
	 * @param price
	 * @param amount
	 * @return
	 */

	public String updatePrice(String price, int amount) {
		String result = "";
		if (price != null) {
			Double total = Double.parseDouble(price) * amount;
			result = String.valueOf(total);
		} else {
			result = null;
		}
		return result;
	}

	/**
	 * Funcion que hace la multiplicacion del precio del producto por la
	 * cantidad
	 * 
	 * @param price
	 * @param amount
	 * @return
	 */
	public BigDecimal updatePrice(BigDecimal price, int amount) {
		BigDecimal result = new BigDecimal(0);
		if (price != null) {
			result = null;
			result = new BigDecimal(amount);
			result = result.multiply(price);
		}
		return result;
	}

	public boolean validateCantidad(int cantidad) {
		if (cantidad > 0)
			return true;
		else
			return false;
	}
	/**
	 * Funcion con la cual se valida si el codigo cumple con los formatos que tiene la aplicacion
	 * @param codigo
	 * @return
	 */
	public boolean validateCodigo(String codigo) {
		try {
			if (codigo != null) {
				if ((codigo.startsWith("1-") || codigo.startsWith("3-")) && codigo != null && codigo != "")
					return true;
				else
					return false;
			}else{
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Funcion que genera toda la logica para facturar
	 * 
	 * @param list
	 * @return
	 */

	public String facturar(List<GenericProductEntity> list, ClienteEntity cliente, String path,
			DatosSessionEntity session, String type, String cambio, String pago, String domicilio) {
		String rta = "";
		FacturacionGenEntity fact = new FacturacionGenEntity();
		RespuestaFacturacion res = null;
		recorreLista(list);
		try {
			fact.setIdSede(session.getDataUser().getSede().getId());
			fact.setIdTius(session.getDataUser().getId());
			fact.setIdCliente(cliente.getId());
			fact.setProductos(this.products);
			fact.setRecetas(this.receta);
			//res = conexionWSPrinSaf().getPortSafPrinc().facturar(fact);
			res = conexionWSFacturacion().getPortFacturacion().facturar(fact);
			if ("error".equalsIgnoreCase(res.getRespuesta())) {
				rta = res.getTrazaExcepcion();
			} else {
				FacturaEntity result = null;
				result = getDataFact(res.getIdFacturacion());
				factID = res.getIdFacturacion();
				if ("1".equalsIgnoreCase(type)) {
					String valPdf = generarPdfXIdFact(Integer.parseInt(res.getIdFacturacion()));

					System.out.println(valPdf);
					if ("ERROR ABIRENDO PDF".equalsIgnoreCase(valPdf)) {
						rta = valPdf;
					}
					rta = "OK";
				} else {
					openBox();
					rta = "OK";
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rta;
	}

	/**
	 * Funcion que genera toda la logica para facturar
	 * 
	 * @param list
	 * @return
	 */

	public String facturarAvanzada(List<GenericProductEntity> list, ClienteEntity cliente, String path,
			DatosSessionEntity session, String type, String cambio, String pago, String domicilio, 
			Integer idPedido,String reteFuente, String tipoPago, String idVoucher,BigDecimal pagoEfectivo) {
		String rta = "";
		FacturacionGenEntity fact = new FacturacionGenEntity();
		RespuestaFacturacion res = new RespuestaFacturacion();
		recorreLista(list);
		try {
			fact.setReteFuente(reteFuente);
			fact.setIdSede(session.getDataUser().getSede().getId());
			fact.setIdTius(session.getDataUser().getId());
			fact.setIdCliente(cliente.getId());
			fact.setProductos(this.products);
			fact.setRecetas(this.receta);
			if (idPedido == null) {
				idPedido = 0;
			}
			fact.setIdPedido(idPedido);
			fact.setTipoPago(tipoPago);
			fact.setIdVoucher(idVoucher);
			fact.setPagoTarjeta(pagoEfectivo);
			res = conexionWSFacturacion().getPortFacturacion().facturarAvanzada(fact);
			if ("error".equalsIgnoreCase(res.getRespuesta())) {
				rta = "ERROR:"+res.getTrazaExcepcion();
			} else {
				FacturaEntity result = new FacturaEntity();
				result = getDataFact(res.getIdFacturacion());
				factID = res.getIdFacturacion();
				if ("1".equalsIgnoreCase(type)) {
					String valPdf = generarPdfXIdFact(Integer.parseInt(res.getIdFacturacion()));

					System.out.println(valPdf);
					if ("ERROR ABIRENDO PDF".equalsIgnoreCase(valPdf)) {
						rta = valPdf;
					}
					rta = "OK";
				} else {
					openBox();
					rta = ""+res.getIdFacturacion();
				}
			}

		} catch (Exception e) {
			rta = "ERROR:";
			e.printStackTrace();
		}
		return rta;
	}

	/**
	 * Funcion que abre la caja monedera
	 */

	public void openBox() {
		try {
			String cmd = "/home/mexicaprichos/abrir.sh"; // Comando de apagado
															// en linux
			Runtime.getRuntime().exec(cmd);
			System.out.println("prueba");
		} catch (IOException ioe) {
			System.out.println(ioe);
		}
	}

	public FacturaEntity getDataFact(String idFactura) {
		FacturaEntity table = null;
		try {
			table = conexionWSFacturacion().getPortFacturacion().obtenerFacturaXId(Integer.parseInt(idFactura));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return table;
	}

	/**
	 * Funcion que recorre el listado de productos y recetas y dependendiendo
	 * del codigo lo setea
	 * 
	 * @param list
	 * @return
	 */
	public boolean recorreLista(List<GenericProductEntity> list) {
		for (GenericProductEntity productoGen : list) {
			if (productoGen.getCode().startsWith("1-")) {
				TemporalProdTable objAux = addProduct(productoGen);
				if (this.products == null) {
					this.products = new ArrayList<TemporalProdTable>();
				}
				this.products.add(objAux);
			}
			if (productoGen.getCode().startsWith("3-")) {
				TemporalRecTable objAux = addReceta(productoGen);
				if (this.receta == null) {
					this.receta = new ArrayList<TemporalRecTable>();
				}
				this.receta.add(objAux);
			}
		}
		return true;
	}

	/**
	 * Funcion que setea el objeto si es un producto lo que viene en la lista
	 * 
	 * @param product
	 * @return
	 */
	public TemporalProdTable addProduct(GenericProductEntity product) {
		TemporalProdTable prodTable = new TemporalProdTable();
		try {
			prodTable.setCantidad(product.getAmount());
			prodTable.setDescuento(0);
			prodTable.setIdDska(product.getId());
			prodTable.setId(null);
			prodTable.setPrecio(product.getPrice());
		} catch (Exception e) {	
			e.printStackTrace();
		}
		
		return prodTable;
	}

	/**
	 * Funcion que setea la receta en el nuevo objeto
	 * 
	 * @param product
	 * @return
	 */

	public TemporalRecTable addReceta(GenericProductEntity product) {
		TemporalRecTable prodTable = new TemporalRecTable();
		// Falta descripcion de recetas
		prodTable.setCantidad(product.getAmount());
		prodTable.setDescuento(0);
		prodTable.setIdReceta(product.getId());
		return prodTable;
	}

//	/**
//	 * Funcion que crea PDF
//	 * 
//	 * @param path
//	 * @param factura
//	 * @param cliente
//	 * @param session
//	 * @param cambio
//	 * @param pago
//	 * @param domicilio
//	 * @return
//	 */
//	public String createPDF(String path, FacturaEntity factura, ClienteEntity cliente, DatosSessionEntity session,
//			String cambio, String pago, String domicilio) {
//		Rectangle rec = new Rectangle(2.0F, 8.0F);
//		Document document = new Document();
//		path += "factura.pdf";
//		Locale locale = new Locale("es", "CO");
//		NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
//		try {
//
//			PdfWriter.getInstance(document, new FileOutputStream(path));
//			document.open();
//			DataBillEntity bill = new DataBillEntity();
//			bill = setDataGenericBill(session);
//			Paragraph para = new Paragraph(bill.getNombreEmpresa(), FontFactory.getFont("Arial", 18f));
//			para.setAlignment(Element.ALIGN_CENTER);
//			document.add(para);
//			para = new Paragraph(new Paragraph("NIT:" + bill.getNit(), FontFactory.getFont("Arial", 14f)));
//			para.setAlignment(Element.ALIGN_CENTER);
//			document.add(para);
//			para = new Paragraph("DIRECCIÓN:" + bill.getDireccion() + ". TELS:" + bill.getTelefonos(),
//					FontFactory.getFont("Arial", 14f));
//			para.setAlignment(Element.ALIGN_CENTER);
//			document.add(para);
//			para = new Paragraph("RESOLUCIÓN DE FACTURACIÓN NO:" + bill.getResolucion(),
//					FontFactory.getFont("Arial", 14f));
//			para.setAlignment(Element.ALIGN_CENTER);
//			document.add(para);
//			para = new Paragraph(bill.getCiudad(), FontFactory.getFont("Arial", 14f));
//			para.setAlignment(Element.ALIGN_CENTER);
//			document.add(para);
//			para = new Paragraph(
//					"****************************************************************************************************************");
//			para.setAlignment(Element.ALIGN_CENTER);
//			document.add(para);
//			para = new Paragraph("FACTURA No " + factura.getId(), FontFactory.getFont("Arial", 14f));
//			para.setAlignment(Element.ALIGN_CENTER);
//			document.add(para);
//			para = new Paragraph(
//					"Producto                                    cantidad                valor unitario               valor total                ",
//					FontFactory.getFont("Arial", 14f));
//			para.setAlignment(Element.ALIGN_CENTER);
//			document.add(para);
//
//			ArrayList<DataProductEntity> product = new ArrayList<DataProductEntity>();
//			product = setDataProduct(factura);
//			for (int i = 0; i < product.size(); i++) {
//
//				para = new Paragraph(product.get(i).getNombreProducto() + product.get(i).getCantidad()
//						+ product.get(i).getValorUnitario() + product.get(i).getValorTotal());
//				para.setAlignment(Element.ALIGN_CENTER);
//				document.add(para);
//			}
//			para = new Paragraph("                                                                         TOTAL:"
//					+ nf.format(factura.getValor()), FontFactory.getFont("Arial", 18f));
//			para.setAlignment(Element.ALIGN_CENTER);
//			document.add(para);
//			para = new Paragraph("                                                                         Efectivo:"
//					+ nf.format(Double.parseDouble(pago)), FontFactory.getFont("Arial", 18f));
//			para.setAlignment(Element.ALIGN_CENTER);
//			document.add(para);
//			para = new Paragraph("                                                                         Cambio:"
//					+ nf.format(Double.parseDouble(cambio)), FontFactory.getFont("Arial", 18f));
//			para.setAlignment(Element.ALIGN_CENTER);
//			document.add(para);
//			para = new Paragraph(
//					"-----------------------------------------------------------------------------------------------------------------------------");
//			para.setAlignment(Element.ALIGN_CENTER);
//			document.add(para);
//			if ("Checked".equalsIgnoreCase(domicilio)) {
//				para = new Paragraph("Domicilio", FontFactory.getFont("Arial", 14f));
//				para.setAlignment(Element.ALIGN_CENTER);
//				document.add(para);
//				para = new Paragraph("Cliente : " + cliente.getApellido() + " " + cliente.getNombre() + "--Direccion:"
//						+ cliente.getDireccion() + "--Telefono:" + cliente.getTelefono());
//				para.setAlignment(Element.ALIGN_CENTER);
//				document.add(para);
//			} else {
//				para = new Paragraph("Cliente : " + cliente.getApellido() + " " + cliente.getNombre());
//				para.setAlignment(Element.ALIGN_CENTER);
//				document.add(para);
//			}
//			Date date = toDate(factura.getFecha());
//			SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
//			para = new Paragraph("Usted Fue atendido por  : " + session.getDataUser().getPersona().getApellido()
//					+ " " + session.getDataUser().getPersona().getNombre() + ".   Fecha:" + dt1.format(date));
//			para.setAlignment(Element.ALIGN_CENTER);
//			document.add(para);
//			para = new Paragraph(new Paragraph("GRACIAS POR SU COMPRA"));
//			para.setAlignment(Element.ALIGN_CENTER);
//			document.add(para);
//			para = new Paragraph(
//					"****************************************************************************************************************");
//			para.setAlignment(Element.ALIGN_CENTER);
//			document.add(para);
//			document.close();
//			System.out.println(path);
//			if (!openPDF(path)) {
//				path = "ERROR ABIRENDO PDF";
//			}
//			return path;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return "error";
//		}
//
//	}

	public boolean print(String path) {
		try {
			FileInputStream inputStream = null;
			try {
				inputStream = new FileInputStream(path);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			if (inputStream == null) {
				return false;
			}
			DocFlavor docFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;
			Doc document = new SimpleDoc(inputStream, docFormat, null);

			PrintRequestAttributeSet attributeSet = new HashPrintRequestAttributeSet();

			PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();

			if (defaultPrintService != null) {
				DocPrintJob printJob = defaultPrintService.createPrintJob();
				try {
					printJob.print(document, attributeSet);

				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				System.err.println("No existen impresoras instaladas");
			}

			inputStream.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public String validaDatos(List<GenericProductEntity> list, ClienteEntity cliente, String domicilio) {
		String rta = "OK";
		try {
			if (list == null || list.size() <= 0) {
				rta = "No puede facturar si no añade algún producto";
			} else if (cliente.getId() == null) {
				rta = "Debe añadir por lo menos un cliente";
			} else if ("Checked".equalsIgnoreCase(domicilio)) {
				if (cliente.getCedula().isEmpty()) {
					rta = "Para domicilios, es necesario insertar el cliente.";
				} else if ("".equalsIgnoreCase(cliente.getDireccion()) || cliente.getDireccion() == null) {
					rta = "El cliente debe tener la dirección para poder realizar el domicilio.";
				}
			}
		} catch (Exception e) {
			rta = "ERROR " + e;

		}
		return rta;

	}

	/**
	 * Metodo que abre el PDF
	 * 
	 * @param path
	 * @return
	 */
	public boolean openPDF(String path) {
		File pdfFile = new File(path);
		boolean result = false;
		try {
			if (pdfFile.exists()) {

				if (Desktop.isDesktopSupported()) {
					Desktop.getDesktop().open(pdfFile);
					result = true;
				} else {
					System.out.println("Awt Desktop is not supported!");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * Funcion que setea los datos del objeto a un objeto generico para la
	 * factura
	 * 
	 * @param session
	 * @return
	 */
	public DataBillEntity setDataGenericBill(DatosSessionEntity session) {
		DataBillEntity result = new DataBillEntity();
		for (int i = 0; i < session.getDataCompany().size(); i++) {
			if ("NOMBREEMPRESA".equalsIgnoreCase(session.getDataCompany().get(i).getClave())) {
				result.setNombreEmpresa(session.getDataCompany().get(i).getValor());
			}
			if ("NIT".equalsIgnoreCase(session.getDataCompany().get(i).getClave())) {
				result.setNit(session.getDataCompany().get(i).getValor());
			}
			if ("DIRECCION".equalsIgnoreCase(session.getDataCompany().get(i).getClave())) {
				result.setDireccion(session.getDataCompany().get(i).getValor());
			}
			if ("TELEFONOS".equalsIgnoreCase(session.getDataCompany().get(i).getClave())) {
				result.setTelefonos(session.getDataCompany().get(i).getValor());
			}
			if ("CIUDAD".equalsIgnoreCase(session.getDataCompany().get(i).getClave())) {
				result.setCiudad(session.getDataCompany().get(i).getValor());
			}
			if ("RESOLUCION".equalsIgnoreCase(session.getDataCompany().get(i).getClave())) {
				result.setResolucion(session.getDataCompany().get(i).getValor());
			}

		}
		result.setFacturador(session.getDataUser().getPersona().getApellido() + "  "
				+ session.getDataUser().getPersona().getNombre());
		return result;
	}

	public ArrayList<DataProductEntity> setDataProduct(FacturaEntity factura) {
		Locale locale = new Locale("es", "CO");
		NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
		ArrayList<DataProductEntity> result = new ArrayList<DataProductEntity>();
		// recetas
//		for (int i = 0; i < factura.getDetalleRecetas().size(); i++) {
//			DataProductEntity obj = new DataProductEntity();
//			String nameProduct = factura.getDetalleRecetas().get(i).getReceta().getNombre()
//					.concat("                                                  ");
//			obj.setNombreProducto(nameProduct.substring(0, 30));
//			String cantidad = "   " + factura.getDetalleRecetas().get(i).getCantidad()
//					+ "                                                                  ";
//			obj.setCantidad(cantidad.substring(0, 30));
//			String valorUnitario = nf.format(factura.getDetalleRecetas().get(i).getVlrVentaUni())
//					+ "                                                      ";
//			obj.setValorUnitario(valorUnitario.substring(0, 26));
//			String valorTotal = ""
//					+ nf.format(new BigDecimal(factura.getDetalleRecetas().get(i).getCantidad())
//							.multiply(factura.getDetalleRecetas().get(i).getVlrVentaUni()))
//					+ "                                        ";
//			obj.setValorTotal(valorTotal.substring(0, 30));
//			result.add(obj);
//		}
		// Productos
		for (int i = 0; i < factura.getDetalleProductos().size(); i++) {
			DataProductEntity obj = new DataProductEntity();
			String nameProduct = factura.getDetalleProductos().get(i).getProducto().getNombre()
					.concat("                                                  ");
			obj.setNombreProducto(nameProduct.substring(0, 30));
			String cantidad = "   " + factura.getDetalleProductos().get(i).getCantidad()
					+ "                                                                  ";
			obj.setCantidad(cantidad.substring(0, 30));
			String valorUnitario = nf.format(factura.getDetalleProductos().get(i).getValorUnidad())
					+ "                                                      ";
			obj.setValorUnitario(valorUnitario.substring(0, 26));
			String valorTotal = ""
					+ nf.format(new BigDecimal(factura.getDetalleProductos().get(i).getCantidad())
							.multiply(factura.getDetalleProductos().get(i).getValorUnidad()))
					+ "                                        ";
			obj.setValorTotal(valorTotal.substring(0, 30));
			result.add(obj);
		}
		return result;
	}
	
	public static Date toDate(XMLGregorianCalendar calendar) {
		if (calendar == null) {
			return null;
		}
		return calendar.toGregorianCalendar().getTime();
	}

	/**
	 * Funcion en la cual creo el pdf de la factura para mostrarlo en el sistema
	 * 
	 * @param id
	 * @return
	 */
	public String generarPdfXIdFact(Integer id) {
		String rta = "";
		try {
			String imagen = conexionWSFacturacion().getPortFacturacion().obtenerImagenXIdFactura("" + id);
			ExternalContext tmpEC;
			tmpEC = FacesContext.getCurrentInstance().getExternalContext();
			String realPath = tmpEC.getRealPath("/resources/images/facturas/");
			CodificaBase64 codifica64 = new CodificaBase64();
			codifica64.setDocumento(imagen);
			boolean valida = codifica64.decodificaBase64(realPath, "factura_" + id + ".pdf");
			if (valida) {
				//System.out.println("Codifico la imagen: " + realPath + "factura_" + id + ".pdf");
				rta = "Ok";
			}
		} catch (Exception e) {
			e.printStackTrace();
			rta = "Error";
		}
		return rta;
	}
	
	/**
	 * Funcion que consulta la factura por ID
	 * @param factura
	 * @return
	 */
	public FacturaEntity consultaFacturaXID(Integer factura){
		try {
			return conexionWSFacturacion().getPortFacturacion().obtenerFacturaXId(factura);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public PrecioProductoEntity consultaProductoXCodigo(String codigo,Integer sede){
		PrecioProductoEntity rta = new PrecioProductoEntity();
		try {
			rta =conexionWSProd().getPortProd().obtenerProductoXCodigo(codigo, sede);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rta;
	}

}
