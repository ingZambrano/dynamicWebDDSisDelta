package mx.com.ddsis.controller;


import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ApplicationScoped
@ManagedBean
public class ThemeBean {

    public String getApplicationTheme() {
        return "aristo";
    }

}
