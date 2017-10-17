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
public class Employe implements Serializable {
      @ManagedProperty(value = "#{param.idUser}")
    private int idUser;


    //public static final String PROP_SAMPLE_PROPERTY = "sampleProperty";
    private int iduser;
    private int age;
    private String nom;
    private String passowrd;
    private String prenom;
    private String username;

    public Employe(int iduser, int age, String nom, String passowrd, String prenom, String username) {
        this.iduser = iduser;
        this.age = age;
        this.nom = nom;
        this.passowrd = passowrd;
        this.prenom = prenom;
        this.username = username;
     
    }

    public int getAge() {
        return age;
    }

    public int getIdUser() {
        return idUser;
    }

    public int getIduser() {
        return iduser;
    }

    public String getNom() {
        return nom;
    }

    public String getPassowrd() {
        return passowrd;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getUsername() {
        return username;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setPassowrd(String passowrd) {
        this.passowrd = passowrd;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    

    
    public Employe() {
    }

   
  
    @ManagedProperty(value = "#{param.idProd}")
    private int idProd;

    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }

    public int getIdProd() {
        return idProd;
    }
    public ArrayList<Employe> getuEmploye(int idp) {
        return EmployeDAO.getuEmploye(idp);
    }

    public ArrayList<Employe> getall() {
        return EmployeDAO.getallEmploye();
    }

   public String insert(){
       boolean valid = EmployeDAO.insert(nom, prenom, passowrd, age, username);
		if (valid) {
						return "afficheEmplotye?faces-redirect=true&includeViewParams=true&message=ajout avec succéé !!";
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Incorrect Username and Passowrd",
							"Please enter correct username and Password"));
			return "ajouterEmplotye?faces-redirect=true&includeViewParams=true&message=username existe déja!";
		}
	
   }

    /*public void delete() {
        System.out.println("idProd="+ getIdProd());
        CommandeDAO.deletep(getIdProd());
    }*/

    
    
}
