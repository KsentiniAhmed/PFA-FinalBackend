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
public class Commande implements Serializable {

    //public static final String PROP_SAMPLE_PROPERTY = "sampleProperty";
    private int id_image;
    private String date;
    private int id_user;
    private String url;

    public Commande() {
    }

    public Commande(int id_image, String date, int id_user, String url) {
        this.id_image = id_image;
        this.date = date;
        this.id_user = id_user;
        this.url = url;
    }

    public String getDate() {
        return date;
    }

    public int getIdUser() {
        return idUser;
    }

    public int getId_image() {
        return id_image;
    }

    public int getId_user() {
        return id_user;
    }

    public String getUrl() {
        return url;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setId_image(int id_image) {
        this.id_image = id_image;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    
    
   
    @ManagedProperty(value = "#{param.idUser}")
    private int idUser;

    @ManagedProperty(value = "#{param.idProd}")
    private int idProd;

    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }

    public int getIdProd() {
        return idProd;
    }
    public ArrayList<Commande> getuCommande(int idp) {
        return CommandeDAO.getucommande(idp);
    }

    public ArrayList<Commande> getallCommande() {
        return CommandeDAO.getallCommande();
    }

  

    /*public void delete() {
        System.out.println("idProd="+ getIdProd());
        CommandeDAO.deletep(getIdProd());
    }*/

    
    
}
