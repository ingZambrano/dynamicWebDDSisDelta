package mx.com.ddsis.dao;

import java.util.List;

import javax.faces.bean.ManagedProperty;

import mx.com.ddis.service.ConnService;
import mx.com.ddsis.model.CatDispositivos;

public class DispositivosDaoImp implements DispositivosDao {
	
	@ManagedProperty("#{conService}")
    private ConnService conservice;

	@Override
	public List<CatDispositivos> dameDispositivos() {
		
		
		
		return null;
	}

	public void setConservice(ConnService conservice) {
		this.conservice = conservice;
	}
	
	

}
