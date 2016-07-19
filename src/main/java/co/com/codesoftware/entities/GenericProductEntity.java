package co.com.codesoftware.entities;

import java.io.Serializable;
import java.math.BigDecimal;

public class GenericProductEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	private String code;
	private int amount;
	private String name;
	private BigDecimal price;
	private BigDecimal priceIva;
	private BigDecimal totalPrice;
	private int id;
	private int type;
	private String routImage;
	private String categoria;
	private String subcategoria;
	private String marca;
	private String ubicacion;
	private String codigoPropio;
	private BigDecimal precioXUnidad;
	private BigDecimal precioXCien;
	private BigDecimal precioXMil;
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getRoutImage() {
		return routImage;
	}

	public void setRoutImage(String routImage) {
		this.routImage = routImage;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getSubcategoria() {
		return subcategoria;
	}

	public void setSubcategoria(String subcategoria) {
		this.subcategoria = subcategoria;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getCodigoPropio() {
		return codigoPropio;
	}

	public void setCodigoPropio(String codigoPropio) {
		this.codigoPropio = codigoPropio;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public BigDecimal getPriceIva() {
		return priceIva;
	}

	public void setPriceIva(BigDecimal priceIva) {
		this.priceIva = priceIva;
	}

	public BigDecimal getPrecioXUnidad() {
		return precioXUnidad;
	}

	public void setPrecioXUnidad(BigDecimal precioXUnidad) {
		this.precioXUnidad = precioXUnidad;
	}

	public BigDecimal getPrecioXCien() {
		return precioXCien;
	}

	public void setPrecioXCien(BigDecimal precioXCien) {
		this.precioXCien = precioXCien;
	}

	public BigDecimal getPrecioXMil() {
		return precioXMil;
	}

	public void setPrecioXMil(BigDecimal precioXMil) {
		this.precioXMil = precioXMil;
	}
	
	
	

}
