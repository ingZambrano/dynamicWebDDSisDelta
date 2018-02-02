package mx.com.ddsis.model;

import java.io.Serializable;

public class CatDispositivos implements Serializable {

	
	private static final long serialVersionUID = -5835919907597907305L;
	
	
	private String idDispositivo;
	private String nombreDispositivo;
	private String descDispositivo;
	
	
	public String getIdDispositivo() {
		return idDispositivo;
	}
	public void setIdDispositivo(String idDispositivo) {
		this.idDispositivo = idDispositivo;
	}
	public String getNombreDispositivo() {
		return nombreDispositivo;
	}
	public void setNombreDispositivo(String nombreDispositivo) {
		this.nombreDispositivo = nombreDispositivo;
	}
	public String getDescDispositivo() {
		return descDispositivo;
	}
	public void setDescDispositivo(String descDispositivo) {
		this.descDispositivo = descDispositivo;
	}
	
	
}
