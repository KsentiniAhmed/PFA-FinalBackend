/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.journaldev.jsf.dao;

import com.journaldev.jsf.beans.Admin;
import com.journaldev.jsf.beans.Commande;
import com.journaldev.jsf.util.DataConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ksentini
 */
public class AdminDAO {


    public static ArrayList<Admin> getuAdmin(int aid) {
       Connection con = null;
        PreparedStatement ps = null;
        ArrayList<Admin> list = new ArrayList<Admin>();
        try {
            con = DataConnect.getConnection();
            ps = con.prepareStatement("SELECT * FROM `admin` where aid= ? ");
            ps.setInt(1, aid);


            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Admin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));

            }
            return list;

        } catch (SQLException ex) {
            System.out.println("get un admin error -->" + ex.getMessage());
            return null;
        } finally {
            DataConnect.close(con);
        }
    }

    public static ArrayList<Admin> getallAdmin() {
         Connection con = null;
        PreparedStatement ps = null;
        ArrayList<Admin> list = new ArrayList<Admin>();
        try {
            con = DataConnect.getConnection();
            ps = con.prepareStatement("SELECT * FROM `admin` ");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Admin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));

            }
            return list;

        } catch (SQLException ex) {
            System.out.println("get admin error -->" + ex.getMessage());
            return null;
        } finally {
            DataConnect.close(con);
        }
    }

    public static boolean insert(String noma, String prenoma, String password, String emaila, String aname) {
        Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement("INSERT INTO `admin`( `aname`, `password`, `noma`, `prenoma`, `emaila`) VALUES (?, ? ,? ,? ,?)");
			ps.setString(1, aname);
			ps.setString(2, password);
			ps.setString(3, noma);
			ps.setString(4, prenoma);
			ps.setString(5, emaila);

			int rs = ps.executeUpdate();

			if (rs!=0) {
				//result found, means valid inputs
				return true;
			}
		} catch (SQLException ex) {
			System.out.println("admin ajouter error -->" + ex.getMessage());
			return false;
		} finally {
			DataConnect.close(con);
		}
		return false;
    
    }
}
