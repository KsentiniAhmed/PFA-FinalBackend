/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.journaldev.jsf.dao;

import com.journaldev.jsf.beans.Commande;
import com.journaldev.jsf.util.DataConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author ksentini
 */
@ManagedBean
@RequestScoped
public class CommandeDAO {
    @ManagedProperty(value = "#{param.idProd}")
    private int idProd;

    public int getIdProd() {
        return idProd;
    }

    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }
    
    

    public static ArrayList<Commande> getucommande(int id_user) {
        Connection con = null;
        PreparedStatement ps = null;
        ArrayList<Commande> list = new ArrayList<Commande>();
        try {
            con = DataConnect.getConnection();
            ps = con.prepareStatement("SELECT * FROM `image` where id_user= ? ");
            ps.setInt(1, id_user);


            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Commande(rs.getInt(1), rs.getString(2),rs.getInt(3),rs.getString(4)));

            }
            return list;

        } catch (SQLException ex) {
            System.out.println("get produit error -->" + ex.getMessage());
            return null;
        } finally {
            DataConnect.close(con);
        }
    }

    public static ArrayList<Commande> getallCommande() {
         Connection con = null;
        PreparedStatement ps = null;
        ArrayList<Commande> list = new ArrayList<Commande>();
        try {
            con = DataConnect.getConnection();
            ps = con.prepareStatement("SELECT * FROM `image` ");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Commande(rs.getInt(1), rs.getString(2),rs.getInt(3),rs.getString(4)));

            }
            return list;

        } catch (SQLException ex) {
            System.out.println("get produit error -->" + ex.getMessage());
            return null;
        } finally {
            DataConnect.close(con);
        }

           }

    public void delete() {
         Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DataConnect.getConnection();
            ps = con.prepareStatement("DELETE FROM `image` WHERE id_image= ?");
            ps.setInt(1,this.idProd);
            boolean rs = ps.execute();

            if (rs) {
                //result found, means valid inputs
                System.out.println("supression avec succées");

            }
        } catch (SQLException ex) {
            System.out.println(" error dans le retour de le suppression d'une commande -->" + ex.getMessage());

        } finally {
            DataConnect.close(con);
        }

    }
    
}
