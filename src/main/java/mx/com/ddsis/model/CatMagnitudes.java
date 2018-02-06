package mx.com.ddsis.model;

import java.io.Serializable;
import java.util.Date;

public class CatMagnitudes implements Serializable{

	private static final long serialVersionUID = -2416960854937417112L;
	
	private String nombreMagnitud;
	private int idMagnitud;
	private Date fhMedida;
	private String valorMedido;
	private String unidadDeMedida;
	private String fhMedidaString;
	
	
	public int getIdMagnitud() {
		return idMagnitud;
	}
	public void setIdMagnitud(int idMagnitud) {
		this.idMagnitud = idMagnitud;
	}
	public String getNombreMagnitud() {
		return nombreMagnitud;
	}
	public void setNombreMagnitud(String nombreMagnitud) {
		this.nombreMagnitud = nombreMagnitud;
	}
	public Date getFhMedida() {
		return fhMedida;
	}
	public void setFhMedida(Date fhMedida) {
		this.fhMedida = fhMedida;
	}
	public String getValorMedido() {
		return valorMedido;
	}
	public void setValorMedido(String valorMedido) {
		this.valorMedido = valorMedido;
	}
	public String getUnidadDeMedida() {
		return unidadDeMedida;
	}
	public void setUnidadDeMedida(String unidadDeMedida) {
		this.unidadDeMedida = unidadDeMedida;
	}
	public String getFhMedidaString() {
		return fhMedidaString;
	}
	public void setFhMedidaString(String fhMedidaString) {
		this.fhMedidaString = fhMedidaString;
	}
	
	
	
}
