/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.journaldev.jsf.beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.journaldev.jsf.dao.LoginDAO;
import com.journaldev.jsf.beans.SessionUtils;
import com.journaldev.jsf.dao.AdminDAO;
import com.journaldev.jsf.dao.CommandeDAO;
import com.journaldev.jsf.dao.EmployeDAO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.Part;

/**
 *
 * @author ksentini
 */
@ManagedBean
@RequestScoped
public class Admin implements Serializable {
      @ManagedProperty(value = "#{param.idUser}")
    private int idUser;


    //public static final String PROP_SAMPLE_PROPERTY = "sampleProperty";
    private int aid;
    private String aname;
    private String passowrd;
    private String noma;
    private String prenoma;
    private String emaila;

    public void setEmaila(String emaila) {
        this.emaila = emaila;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public void setPrenoma(String prenoma) {
        this.prenoma = prenoma;
    }

    public void setPassowrd(String passowrd) {
        this.passowrd = passowrd;
    }

    public void setNoma(String noma) {
        this.noma = noma;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getNoma() {
        return noma;
    }
    

    public String getPrenoma() {
        return prenoma;
    }

    public String getPassowrd() {
        return passowrd;
    }

    public int getIdUser() {
        return idUser;
    }

    public String getEmaila() {
        return emaila;
    }

    public String getAname() {
        return aname;
    }

    public int getAid() {
        return aid;
    }

    public Admin(int aid, String aname, String passowrd, String noma, String prenoma, String emaila) {
        this.aid = aid;
        this.aname = aname;
        this.passowrd = passowrd;
        this.noma = noma;
        this.prenoma = prenoma;
        this.emaila = emaila;
    }

    public Admin() {
    }

    
   
  
    @ManagedProperty(value = "#{param.idProd}")
    private int idProd;

    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }

    public int getIdProd() {
        return idProd;
    }
    public ArrayList<Admin> getuEmploye(int idp) {
        return AdminDAO.getuAdmin(idp);
    }

    public ArrayList<Admin> getall() {
        return AdminDAO.getallAdmin();
    }

  
 public String insert(){
       boolean valid = AdminDAO.insert(noma, prenoma, passowrd, emaila, aname);
		if (valid) {
						return "admin?faces-redirect=true&includeViewParams=true&message=ajout avec succéé !!";
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Incorrect Username and Passowrd",
							"Please enter correct username and Password"));
			return "ajouteradmin?faces-redirect=true&includeViewParams=true&message=username existe déja!";
		}
	
   }
    
    
}
