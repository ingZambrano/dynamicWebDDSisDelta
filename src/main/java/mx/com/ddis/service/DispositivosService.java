package mx.com.ddis.service;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;


import mx.com.ddsis.dao.DispositivosDao;
import mx.com.ddsis.model.CatDispositivos;
import mx.com.ddsis.model.CatMagnitudes;
import mx.com.ddsis.model.RegistroMedidas;

@ManagedBean(name = "dispositivosService")
@ApplicationScoped
public class DispositivosService implements Serializable {
	
	@ManagedProperty("#{dispositivosDao}")
    private DispositivosDao dispositivosDao;
	
	
	private static final long serialVersionUID = 1L;
	
	public List<CatDispositivos> dameDispositivos() throws SQLException{
		
		return dispositivosDao.dameDispositivos();
		
	}

	public List<CatMagnitudes> dameMagnitudesPorDisp(String idDispositivo) throws SQLException{
		return dispositivosDao.dameMagnitudesPorDisp(idDispositivo);
	}
	
	public List<RegistroMedidas> dameRegistroMedidasPorDisp(String idDispositivo, int idMagnitud)  throws SQLException{
		return dispositivosDao.dameRegistroMedidasPorDispUnidad(idDispositivo, idMagnitud);
	}
	public RegistroMedidas dameMedicionesPorUnidad(String idDispositivo, int idMagnitud) throws SQLException{
		return dispositivosDao.dameMedicionesPorUnidad(idDispositivo, idMagnitud);
	}
	
	
	public void setDispositivosDao(DispositivosDao dispositivosDao) {
		this.dispositivosDao = dispositivosDao;
	}
	
	
	
	
	
	
	
}
