package com.journaldev.jsf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.journaldev.jsf.util.DataConnect;

public class LoginDAO {

	public static boolean validate(String user, String password) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement("Select * from admin where aname = ? and password = ?");
			ps.setString(1, user);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				//result found, means valid inputs
				return true;
			}
		} catch (SQLException ex) {
			System.out.println("Login error -->" + ex.getMessage());
			return false;
		} finally {
			DataConnect.close(con);
		}
		return false;
	}

    public static int getuserid(String user) 
    {
        Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement("Select * from admin where aname = ?");
			ps.setString(1, user);
	

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				//result found, means valid inputs
				return rs.getInt(1);
			}
		} catch (SQLException ex) {
			System.out.println("id user error -->" + ex.getMessage());
                }
            return 0;
                
		
    }

    public static String getUsername(int id) {
       
        Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement("Select * from user where id_user = ?");
			ps.setInt(1, id);
	

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				//result found, means valid inputs
				return rs.getString(7);
			}
		} catch (SQLException ex) {
			System.out.println("id user error -->" + ex.getMessage());
                }
            return "";
                
	 }
}