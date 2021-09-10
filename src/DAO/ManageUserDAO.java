package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;



import BEAN.Examination;
import BEAN.Member;
import DB.Database;

public class ManageUserDAO {
	//Hien thi danh sach thanh vien
		 public static  List<Member> DisplayUserDAO(HttpServletRequest request,Connection conn,int start,int count)
		 {
			 List<Member> list =new ArrayList<Member>();
			 String sql="SELECT * FROM  member WHERE idcategorymember = 1 LIMIT "+(start-1)+", "+count+"";
			 String msgmanageuser ; 
			 try {
				PreparedStatement ptmt=conn.prepareStatement(sql);
				ResultSet rs=ptmt.executeQuery();
				if(rs.isBeforeFirst())
				{
					while(rs.next()) {
						
						Member member=new Member();
						
				        int memberid=rs.getInt("idmember");
				        String name = rs.getString("name");
				        String membername =  rs.getString("membername");
				    
				        
				        member.setMemberid(memberid);
				        member.setName(name);
				        member.setMembername(membername);
				          
					    list.add(member);
						
					}
				}
				else {
			 request.setAttribute("msgmanageuser", "Không có thành viên nào trong danh sách");
			}
			 }	
			 catch (SQLException e) {
				 msgmanageuser="Không có thành viên nào trong danh sách";
				 request.setAttribute("msgmanageexam",msgmanageuser );
		
			}
			 return list;
			 
			 }
		 //dem so dong
		 public static int Countrow(Connection conn) throws SQLException {
				int count=0;
				String sql = "select count(*) from member";
				PreparedStatement ptmt= conn.prepareStatement(sql);
				ResultSet rs=ptmt.executeQuery();
				rs.next();
				count= rs.getInt(1);
				
				return count;
				
			}
		 //Xoa bai kiem tra trong result
		 public static void deleteResult(Connection conn,int idmember) throws SQLException {
			 String sql="DELETE FROM result WHERE idmember="+idmember;
			 PreparedStatement ptmt= conn.prepareStatement(sql);
				 ptmt.executeUpdate();
				 ptmt.close();
		 }
		 //Xoa bai kiem tra trong member
		 public static void deleteMember(Connection conn,int idmember) throws SQLException {
			 String sql="DELETE FROM member WHERE idmember="+idmember;
			 PreparedStatement ptmt= conn.prepareStatement(sql);
				 ptmt.executeUpdate();
				 ptmt.close();
		 }
		 // hien thi thong tin nguoi dung
		 public static  List<Member> DisplayUpdataUserDAO(HttpServletRequest request,Connection conn,int idmember )
		 {
			 List<Member> list =new ArrayList<Member>();
			 String sql="SELECT * FROM  member WHERE idmember = "+ idmember ;
			 String msgmanageuser ; 
			 try {
				PreparedStatement ptmt=conn.prepareStatement(sql);
				ResultSet rs=ptmt.executeQuery();
				if(rs.isBeforeFirst())
				{
					while(rs.next()) {
						
						Member member=new Member();
						
				        int memberid=rs.getInt("idmember");
				        String name = rs.getString("name");
				        String membername =  rs.getString("membername");
				        String memberpass = rs.getString("memberpass");
				        int categorymemberid = rs.getInt("idcategorymember");
				        
				        member.setMemberid(memberid);
				        member.setName(name);
				        member.setMembername(membername);
				        member.setMemberpass(memberpass);
				        member.setCategorymemberid(categorymemberid); 
				        
					    list.add(member);
						
					}
				}
				else {
			 request.setAttribute("msgmanageuser", "Không có thành viên nào trong danh sách");
			}
			 }	
			 catch (SQLException e) {
				 msgmanageuser="Không có thành viên nào trong danh sách";
				 request.setAttribute("msgmanageexam",msgmanageuser );
		
			}
			 return list;
			 
			 }
		
		 public static boolean  adminUpdateUser( HttpServletRequest request,Connection conn ,Member member,int idmember) throws SQLException {
			   
		    	
				PreparedStatement ps = conn.prepareStatement("UPDATE member SET name = ?, membername = ? ,idcategorymember = ? WHERE idmember = "+idmember);
			   
				String name=member.getName();
				String membername= member.getMembername();
				int idcategorymember = member.getCategorymemberid();
				ps.setString(1,name);
				ps.setString(2,membername);
				ps.setInt(3, idcategorymember);
			 
			   

			    boolean add = ps.executeUpdate() >0;
			    
			    
			    ps.close();
			 
			    return add;
	        }
		 
		 public static boolean  userUpdateUser( HttpServletRequest request,Connection conn ,Member member,int idmember) throws SQLException {
			   
		    	
				PreparedStatement ps = conn.prepareStatement("UPDATE member SET name = ?, membername = ?,memberpass = ?  WHERE idmember = "+idmember);
			   
				String name=member.getName();
				String membername= member.getMembername();
				String memberpass = member.getMemberpass();
				
				ps.setString(1,name);
				ps.setString(2,membername);
				ps.setString(3,memberpass);
				
			    boolean add = ps.executeUpdate() >0;
			    
			    
			    ps.close();
			 
			    return add;
	        }
		 
		 public static String  authenticationmember( HttpServletRequest request,Connection conn,Member member,int idmember ) throws SQLException {
			   String test="fail";
		    	
				PreparedStatement ps = conn.prepareStatement("SELECT memberpass FROM member where idmember = "+idmember);
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					
					String memberpass=rs.getString("memberpass");
					if( member.getMemberpass().equals(memberpass)) {
					test="success";
					}
					
				}
	                      
			    ps.close();
			    rs.close();
			    return test;	
	}
}
