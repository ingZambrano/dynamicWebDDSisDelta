package mx.com.ddsis.controller;
import java.io.Serializable;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import mx.com.ddis.service.DispositivosService;
import mx.com.ddsis.model.Student;
@ManagedBean(name = "menuController")
@ViewScoped
public class MenuController implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<Student> students;
    @ManagedProperty("#{dispositivosService}")
    private DispositivosService dispositivosService;
    
    
    
    @PostConstruct
    public void init() {
    	students = dispositivosService.getStudents();
    	
    	
    }
	public List<Student> getStudents() {
		return students;
	}
	
	
	public void setDispositivosService(DispositivosService dispositivosService) {
		this.dispositivosService = dispositivosService;
	}
	
	
	
	
}