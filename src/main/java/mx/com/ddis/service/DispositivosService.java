package mx.com.ddis.service;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import mx.com.ddsis.model.Student;
@ManagedBean(name = "dispositivosService")
@ApplicationScoped
public class DispositivosService implements Serializable {
	
	@ManagedProperty("#{conService}")
    private ConnService conservice;
	
	
	private static final long serialVersionUID = 1L;
	static List<Student> list = new ArrayList<Student>();
	static{
		for (int i= 1; i<=100; i++){
			list.add(new Student(i, "Student-"+i, "Location-"+i));
		}
	}
	public List<Student> getStudents(){		
		
		return list;
	}
	public void setConservice(ConnService conservice) {
		this.conservice = conservice;
	}
	
	
}
