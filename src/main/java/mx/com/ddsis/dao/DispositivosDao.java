package mx.com.ddsis.dao;

import java.sql.SQLException;
import java.util.List;

import mx.com.ddsis.model.CatDispositivos;
import mx.com.ddsis.model.CatMagnitudes;
import mx.com.ddsis.model.RegistroMedidas;

public interface DispositivosDao {
	
	public List<CatDispositivos> dameDispositivos()  throws SQLException;
	public List<CatMagnitudes> dameMagnitudesPorDisp(String idDispositivo)  throws SQLException;
	public List<RegistroMedidas> dameRegistroMedidasPorDispUnidad(String idDispositivo, int idMagnitud)  throws SQLException;
	public RegistroMedidas dameMedicionesPorUnidad(String idDispositivo, int idMagnitud) throws SQLException;
	
}
