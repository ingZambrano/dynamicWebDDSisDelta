package mx.com.ddsis.controller;
import java.io.Serializable;



import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;

import mx.com.ddis.service.DispositivosService;
import mx.com.ddsis.model.CatMagnitudes;
import mx.com.ddsis.model.RegistroMedidas;

@ManagedBean(name = "mainController")
@ViewScoped
public class MainController implements Serializable {
	private static final long serialVersionUID = 1L;
	
    @ManagedProperty("#{dispositivosService}")
    private DispositivosService dispositivosService;    

    private List<CatMagnitudes> listMagnitudesMedidas;
    private List<RegistroMedidas> listRegistrosMedidas;
    
    @PostConstruct
    public void init() {
    	 this.actualizaMedicion();
    	
    }
    
    public void increment() {
    
        listMagnitudesMedidas = null;
        this.actualizaMedicion();
        RequestContext.getCurrentInstance().update("formMain:txt_count");
        RequestContext.getCurrentInstance().update("formMain:mag");
    }
    
    public void mostrarDetalle(int idMagnitud){

    	try {
			listRegistrosMedidas = dispositivosService.dameRegistroMedidasPorDisp("A0001", idMagnitud);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	RequestContext.getCurrentInstance().update("formMain:dlg1");
    	RequestContext.getCurrentInstance().execute("PF('dlg1').show();");
    }
    
    private void actualizaMedicion(){
    	
    	try {
			listMagnitudesMedidas = dispositivosService.dameMagnitudesPorDisp("A0001");		
			RegistroMedidas regMed = null;
			for(CatMagnitudes cM: listMagnitudesMedidas){
				regMed = dispositivosService.dameMedicionesPorUnidad("A0001",cM.getIdMagnitud());
				cM.setFhMedida(regMed.getFhSensada());
				cM.setNombreMagnitud(regMed.getNombreMagnitud());
				cM.setUnidadDeMedida(regMed.getUnidadMedida());
				cM.setValorMedido(regMed.getValorMagnitud());
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  	
    	
    }
    
    
    
	public List<RegistroMedidas> getListRegistrosMedidas() {
		return listRegistrosMedidas;
	}

	public void setListRegistrosMedidas(List<RegistroMedidas> listRegistrosMedidas) {
		this.listRegistrosMedidas = listRegistrosMedidas;
	}

	public List<CatMagnitudes> getListMagnitudesMedidas() {
		return listMagnitudesMedidas;
	}



	public void setListMagnitudesMedidas(List<CatMagnitudes> listMagnitudesMedidas) {
		this.listMagnitudesMedidas = listMagnitudesMedidas;
	}



	public void setDispositivosService(DispositivosService dispositivosService) {
		this.dispositivosService = dispositivosService;
	}


//	public List<CatDispositivos> getListCatDispositivos() {
//		return listCatDispositivos;
//	}
//
//
//	public void setListCatDispositivos(List<CatDispositivos> listCatDispositivos) {
//		this.listCatDispositivos = listCatDispositivos;
//	}
	
	
	
	
	
}