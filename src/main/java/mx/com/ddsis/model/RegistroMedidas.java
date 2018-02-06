package mx.com.ddsis.model;

import java.io.Serializable;
import java.util.Date;

public class RegistroMedidas implements Serializable{

	private static final long serialVersionUID = -7596674272978490135L;
	
	private String nombreDispositivo;
	private String nombreMagnitud;
	private Date fhRegistro;
	private Date fhSensada;
	private String valorMagnitud;
	private String unidadMedida;
	private int idMagnitud;
	private String fhSensadaString;
	
	
	public String getNombreDispositivo() {
		return nombreDispositivo;
	}
	public void setNombreDispositivo(String nombreDispositivo) {
		this.nombreDispositivo = nombreDispositivo;
	}
	public String getNombreMagnitud() {
		return nombreMagnitud;
	}
	public void setNombreMagnitud(String nombreMagnitud) {
		this.nombreMagnitud = nombreMagnitud;
	}
	public Date getFhRegistro() {
		return fhRegistro;
	}
	public void setFhRegistro(Date fhRegistro) {
		this.fhRegistro = fhRegistro;
	}
	public Date getFhSensada() {
		return fhSensada;
	}
	public void setFhSensada(Date fhSensada) {
		this.fhSensada = fhSensada;
	}
	public String getValorMagnitud() {
		return valorMagnitud;
	}
	public void setValorMagnitud(String valorMagnitud) {
		this.valorMagnitud = valorMagnitud;
	}
	public String getUnidadMedida() {
		return unidadMedida;
	}
	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}
	public int getIdMagnitud() {
		return idMagnitud;
	}
	public void setIdMagnitud(int idMagnitud) {
		this.idMagnitud = idMagnitud;
	}
	public String getFhSensadaString() {
		return fhSensadaString;
	}
	public void setFhSensadaString(String fhSensadaString) {
		this.fhSensadaString = fhSensadaString;
	}
	
	

}
