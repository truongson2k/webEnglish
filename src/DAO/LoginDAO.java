package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import BEAN.Member;

public class LoginDAO {
	 public static String  authenticationmember( HttpServletRequest request,Connection conn,Member member ) throws SQLException {
		   String test="fail";
	    	
			PreparedStatement ps = conn.prepareStatement("SELECT membername,memberpass FROM member");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				String membername=rs.getString("membername");
				String memberpass=rs.getString("memberpass");
				if(member.getMembername().equals(membername) && member.getMemberpass().equals(memberpass)) {
				test="success";
				}
				
			}
                      
		    ps.close();
		    rs.close();
		    return test;	
}
	 public static int  authorizationmember( HttpServletRequest request,Connection conn,Member member )  {
		   
		
			PreparedStatement ps=null;
			String sql="SELECT idcategorymember FROM member where membername='"+member.getMembername()+"' AND memberpass='"+member.getMemberpass()+"'";
			 int idcategorymember=0;
			try {
				ps=conn.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					 
					idcategorymember=rs.getInt("idcategorymember");
				}

			    ps.close();
			    rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		    return  idcategorymember;	
}

	 
	 public static String Exportnamemember(HttpServletRequest request,Connection conn,Member member ) throws SQLException {
		 String name="";
			PreparedStatement ps = conn.prepareStatement("SELECT name FROM MEMBER where membername='"+member.getMembername()+"' AND memberpass='"+member.getMemberpass()+"'");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				 
				name=rs.getString("name");
			} 

		    ps.close();
		    rs.close();
		    return  name;	
		 
	 }
	 public static int Exportidmember(HttpServletRequest request,Connection conn,Member member) throws SQLException {
		    int memberid=0;
			PreparedStatement ps = conn.prepareStatement("SELECT idmember FROM MEMBER where membername='"+member.getMembername()+"' AND memberpass='"+member.getMemberpass()+"'");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				 
			memberid=rs.getInt("idmember");
			} 

		    ps.close();
		    rs.close();
		    return  memberid;	
		 
	 }
	 
}
