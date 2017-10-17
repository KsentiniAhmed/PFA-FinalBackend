/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.journaldev.jsf.dao;

import com.journaldev.jsf.beans.Employe;
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
public class EmployeDAO {

    public static boolean insert(String nom, String prenom, String passowrd, int age, String username) {
        Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement("INSERT INTO `user`(`age`, `nom`, `password`, `prenom`, `username`) VALUES (?, ? ,? ,? ,?)");
			ps.setInt(1, age);
			ps.setString(2, nom);
			ps.setString(3, passowrd);
			ps.setString(4, prenom);
			ps.setString(5, username);

			int rs = ps.executeUpdate();

			if (rs!=0) {
				//result found, means valid inputs
				return true;
			}
		} catch (SQLException ex) {
			System.out.println("employer ajouter error -->" + ex.getMessage());
			return false;
		} finally {
			DataConnect.close(con);
		}
		return false;
    
    }
    
    @ManagedProperty(value = "#{param.idProd}")
    private int idProd;

    public int getIdProd() {
        return idProd;
    }

    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }
    
    

    public static ArrayList<Employe> getuEmploye(int id_user) {
        Connection con = null;
        PreparedStatement ps = null;
        ArrayList<Employe> list = new ArrayList<Employe>();
        try {
            con = DataConnect.getConnection();
            ps = con.prepareStatement("SELECT * FROM `user` where id_user= ? ");
            ps.setInt(1, id_user);


            ResultSet rs = ps.executeQuery();

            while (rs.next()) { 
                list.add(new Employe(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));

            }
            return list;

        } catch (SQLException ex) {
            System.out.println("get produit error -->" + ex.getMessage());
            return null;
        } finally {
            DataConnect.close(con);
        }
    }

    public static ArrayList<Employe> getallEmploye() {
         Connection con = null;
        PreparedStatement ps = null;
        ArrayList<Employe> list = new ArrayList<Employe>();
        try {
            con = DataConnect.getConnection();
            ps = con.prepareStatement("SELECT * FROM `user` ");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Employe(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(7)));

            }
            return list;

        } catch (SQLException ex) {
            System.out.println("get users error -->" + ex.getMessage());
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
            ps = con.prepareStatement("DELETE FROM `user` WHERE id_user= ?");
            ps.setInt(1,this.idProd);
            boolean rs = ps.execute();

            if (rs) {
                //result found, means valid inputs
                System.out.println("supression avec succées de l'employe");

            }
        } catch (SQLException ex) {
            System.out.println(" error dans le retour de le suppression d'un employe -->" + ex.getMessage());

        } finally {
            DataConnect.close(con);
        }

    }
    
}
