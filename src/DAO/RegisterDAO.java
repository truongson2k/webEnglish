package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import BEAN.Member;
import DB.Database;

import java.sql.*;

public class RegisterDAO {
	
	 public static boolean  addUser( HttpServletRequest request,Connection conn ,Member member) throws SQLException {
	   
	    	
			PreparedStatement ps = conn.prepareStatement("INSERT INTO member (name, membername, memberpass,idcategorymember) VALUES (?,?, ?, ?)");
		   
			String name=member.getName();
			String membername=member.getMembername();
			String memberpass=member.getMemberpass();
			int categorymemberid=1;
			ps.setString(1,name);
		    ps.setString(2,membername);
		    ps.setString(3,memberpass);
		    ps.setInt(4,categorymemberid);

		    boolean add = ps.executeUpdate() >0;
		    
		    
		    ps.close();
		 
		    return add;
 	
		
		
 }

}
