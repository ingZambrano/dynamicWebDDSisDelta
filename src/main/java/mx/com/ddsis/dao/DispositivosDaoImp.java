package mx.com.ddsis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.apache.log4j.Logger;

import mx.com.ddis.service.ConnService;
import mx.com.ddsis.model.CatDispositivos;
import mx.com.ddsis.model.CatMagnitudes;
import mx.com.ddsis.model.RegistroMedidas;

@ManagedBean(name = "dispositivosDao")
@ApplicationScoped
public class DispositivosDaoImp implements DispositivosDao {
	
	private final static Logger logger = Logger.getLogger(DispositivosDaoImp.class);
	
	@ManagedProperty("#{conService}")
    private ConnService conservice;

	@Override
	public List<CatDispositivos> dameDispositivos() throws SQLException {
		
		
		StringBuilder sbSql = new StringBuilder();
		sbSql.append("select ID_DISPOSITIVO, NOMBRE_DISPOSITIVO, DESC_DISPOSITIVO ");
		sbSql.append("from delta.CAT_DISPOSITIVOS ");
		List<CatDispositivos> ret = new ArrayList<CatDispositivos>();
		CatDispositivos catDispositivos;
		Connection conn=null;
		PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
        	conn = conservice.dameConexion();
            pstmt = conn.prepareStatement(sbSql.toString());
            
            rs = pstmt.executeQuery();
            while (rs.next()) {
                catDispositivos = new CatDispositivos();
                catDispositivos.setIdDispositivo(rs.getString("ID_DISPOSITIVO"));
                catDispositivos.setNombreDispositivo(rs.getString("NOMBRE_DISPOSITIVO"));
                catDispositivos.setDescDispositivo(rs.getString("DESC_DISPOSITIVO"));
                ret.add(catDispositivos);
            }

        } catch (SQLException e) {
        	e.printStackTrace();
            logger.error(e.getMessage(), e);
        } finally {
            conservice.closeConnection(conn, pstmt, rs, null);
        }
		
		return ret;
	}

	

	@Override
	public List<CatMagnitudes> dameMagnitudesPorDisp(String idDispositivo) throws SQLException {
		StringBuilder sbSql = new StringBuilder();
		sbSql.append("select distinct(mag.NOMBRE_MAGNITUD), mag.ID_MAGNITUD ");
		sbSql.append("from delta.registro_medida med, delta.cat_dispositivos disp, delta.cat_magnitud mag ");
		sbSql.append("where disp.ID_DISPOSITIVO = ? ");
		sbSql.append("and med.ID_DISPOSITIVO = disp.ID_DISPOSITIVO ");
		sbSql.append("and mag.ID_MAGNITUD = med.ID_MAGNITUD ");
		List<CatMagnitudes> ret = new ArrayList<CatMagnitudes>();	
		CatMagnitudes cMag;
		Connection conn=null;
		PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
        	conn = conservice.dameConexion();
            pstmt = conn.prepareStatement(sbSql.toString());
            pstmt.setString(1, idDispositivo);
            
            rs = pstmt.executeQuery();
            while (rs.next()) {
                cMag = new CatMagnitudes();
                cMag.setNombreMagnitud(rs.getString("NOMBRE_MAGNITUD"));
                cMag.setIdMagnitud(rs.getInt("ID_MAGNITUD"));
                ret.add(cMag);
            }

        } catch (SQLException e) {
        	e.printStackTrace();
            logger.error(e.getMessage(), e);
        } finally {
            conservice.closeConnection(conn, pstmt, rs, null);
        }
		
		return ret;
	}
	



	@Override
	public List<RegistroMedidas> dameRegistroMedidasPorDispUnidad(String idDispositivo, int idMagnitud)
			throws SQLException {
		StringBuilder sbSql = new StringBuilder();
		sbSql.append("select disp.NOMBRE_DISPOSITIVO, mag.NOMBRE_MAGNITUD, ");
		sbSql.append("med.FH_REGISTRO, med.FH_SENSADA, med.VALOR_MAGNITUD, mag.UNIDAD_MEDIDA, mag.ID_MAGNITUD ");
		sbSql.append("from delta.registro_medida med, delta.cat_dispositivos disp, delta.cat_magnitud mag ");
		sbSql.append("where disp.ID_DISPOSITIVO = ? ");
		sbSql.append("and med.ID_DISPOSITIVO = disp.ID_DISPOSITIVO ");
		sbSql.append("and mag.ID_MAGNITUD = med.ID_MAGNITUD ");
		sbSql.append("and mag.ID_MAGNITUD = ? ");
		sbSql.append("order by med.FH_SENSADA desc ");
		List<RegistroMedidas> ret = new ArrayList<RegistroMedidas>();	
		RegistroMedidas regMed;
		Connection conn=null;
		PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
        	conn = conservice.dameConexion();
            pstmt = conn.prepareStatement(sbSql.toString());
            pstmt.setString(1, idDispositivo);
            pstmt.setInt(2, idMagnitud);
            
            rs = pstmt.executeQuery();
            while (rs.next()) {

            	
                regMed = new RegistroMedidas();
                regMed.setNombreDispositivo(rs.getString("NOMBRE_DISPOSITIVO"));
                regMed.setNombreMagnitud(rs.getString("NOMBRE_MAGNITUD"));
                regMed.setFhRegistro(rs.getTimestamp("FH_REGISTRO"));
                regMed.setFhSensada(this.sumarRestarHorasFecha(rs.getTimestamp("FH_SENSADA"),-6));
                regMed.setValorMagnitud(rs.getString("VALOR_MAGNITUD"));
                regMed.setUnidadMedida(rs.getString("UNIDAD_MEDIDA"));
                regMed.setIdMagnitud(rs.getInt("ID_MAGNITUD"));
                ret.add(regMed);
            }

        } catch (SQLException e) {
        	e.printStackTrace();
            logger.error(e.getMessage(), e);
        } finally {
            conservice.closeConnection(conn, pstmt, rs, null);
        }
		
		return ret;

	}

	
	@Override
	public RegistroMedidas dameMedicionesPorUnidad(String idDispositivo,
			int idMagnitud) throws SQLException {
		StringBuilder sbSql = new StringBuilder();
		sbSql.append("select disp.NOMBRE_DISPOSITIVO, mag.NOMBRE_MAGNITUD, ");
		sbSql.append("med.FH_REGISTRO, med.FH_SENSADA, med.VALOR_MAGNITUD, mag.UNIDAD_MEDIDA, mag.ID_MAGNITUD ");
		sbSql.append("from delta.registro_medida med, delta.cat_dispositivos disp, delta.cat_magnitud mag ");
		sbSql.append("where disp.ID_DISPOSITIVO = ? ");
		sbSql.append("and med.ID_DISPOSITIVO = disp.ID_DISPOSITIVO ");
		sbSql.append("and mag.ID_MAGNITUD = med.ID_MAGNITUD ");
		sbSql.append("and mag.ID_MAGNITUD = ? ");
		sbSql.append("order by med.FH_SENSADA desc limit 1 ");
		RegistroMedidas ret = null;	
		
		Connection conn=null;
		PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
        	conn = conservice.dameConexion();
            pstmt = conn.prepareStatement(sbSql.toString());
            pstmt.setString(1, idDispositivo);
            pstmt.setInt(2, idMagnitud);
            
            rs = pstmt.executeQuery();
            while (rs.next()) {            	
                ret = new RegistroMedidas();
                ret.setNombreDispositivo(rs.getString("NOMBRE_DISPOSITIVO"));
                ret.setNombreMagnitud(rs.getString("NOMBRE_MAGNITUD"));
                ret.setFhRegistro(rs.getTimestamp("FH_REGISTRO"));
                ret.setFhSensada(this.sumarRestarHorasFecha(rs.getTimestamp("FH_SENSADA"),-6));
                ret.setValorMagnitud(rs.getString("VALOR_MAGNITUD"));
                ret.setUnidadMedida(rs.getString("UNIDAD_MEDIDA"));
                ret.setIdMagnitud(rs.getInt("ID_MAGNITUD"));
             
            }

        } catch (SQLException e) {
        	e.printStackTrace();
            logger.error(e.getMessage(), e);
        } finally {
            conservice.closeConnection(conn, pstmt, rs, null);
        }
		
		return ret;

	}
	
	private Date sumarRestarHorasFecha(Date fecha, int horas){				 
			
		      Calendar calendar = Calendar.getInstance();			
		      calendar.setTime(fecha); // Configuramos la fecha que se recibe			
		      calendar.add(Calendar.HOUR, horas);  // numero de horas a añadir, o restar en caso de horas<0	
		      return calendar.getTime(); // Devuelve el objeto Date con las nuevas horas añadidas		
		 
		
		 }
	
	public void setConservice(ConnService conservice) {
		this.conservice = conservice;
	}



	

}
