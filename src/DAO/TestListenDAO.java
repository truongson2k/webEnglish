package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


import BEAN.Listenquestion;

public class TestListenDAO {

	
	//Hien thi danh sach cau hoi
	 public static  List<Listenquestion> DisplayTestListenDAO(HttpServletRequest request,Connection conn,int start,int count,int idlistenexercise)
	 {
		 List<Listenquestion> list =new ArrayList<Listenquestion>();
		 String sql="SELECT * FROM listenquestion where idlistenexercise= "+idlistenexercise+" LIMIT "+(start-1)+", "+count+"";
		 String msglisten ; 
		 try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ResultSet rs=ptmt.executeQuery();
			if(rs.isBeforeFirst())
			{
				while(rs.next()) {
					
					Listenquestion listenquestion=new Listenquestion();
			       
					int num = rs.getInt("num");
					 String imagename =rs.getString("imagename");
					 String audiomp3=rs.getString("audiomp3");
					 String question=rs.getString("question");
					 String option1=rs.getString("option1");
					 String option2=rs.getString("option2");
					 String option3=rs.getString("option3");
					 String option4=rs.getString("option4");
			        
			         listenquestion.setNum(num);
			         listenquestion.setImagename(imagename);
			         listenquestion.setAudiomp3(audiomp3);
			         listenquestion.setQuestion(question);
			         listenquestion.setOption1(option1);
			         listenquestion.setOption2(option2);
			         listenquestion.setOption3(option3);
			         listenquestion.setOption4(option4);
			      
			        
			       
				 list.add(listenquestion);
					
				}
			}
			
		
		 }	
		 catch (SQLException e) {
			 msglisten="Không có bài hướng dẫn nào trong danh sách";
			 request.setAttribute("msglisten",msglisten );
			  
		}
		 return list;
		 
		 }
	 //dem so dong
	 public static int Countrow(Connection conn,int idlistenexercise) throws SQLException {
			int count=0;
			String sql = "select count(*) from Listenquestion  where idlistenexercise= "+idlistenexercise;
			PreparedStatement ptmt= conn.prepareStatement(sql);
			ResultSet rs=ptmt.executeQuery();
			rs.next();
			count= rs.getInt(1);
			
			return count;
			
		}
	//Xuat dap an dung
		 public static  List<Listenquestion> ResultTestListenDAO(HttpServletRequest request,Connection conn,int idlistenexercise,int num)
		 {
			 List<Listenquestion> list =new ArrayList<Listenquestion>();
			 String sql="SELECT * FROM listenquestion where idlistenexercise = "+idlistenexercise+" AND num = "+num;
			 String msglisten ; 
			 try {
				PreparedStatement ptmt=conn.prepareStatement(sql);
				ResultSet rs=ptmt.executeQuery();
				if(rs.isBeforeFirst())
				{
					while(rs.next()) {
						
						Listenquestion listenquestion=new Listenquestion();
				       
						 int num1 = rs.getInt("num");
						 String imagename =rs.getString("imagename");
						 String audiomp3=rs.getString("audiomp3");
						 String question=rs.getString("question");
						 String option1=rs.getString("option1");
						 String option2=rs.getString("option2");
						 String option3=rs.getString("option3");
						 String option4=rs.getString("option4");
				         String correctanswer=rs.getString("correctanswer");
				         
				         listenquestion.setNum(num1);
				         listenquestion.setImagename(imagename);
				         listenquestion.setAudiomp3(audiomp3);
				         listenquestion.setQuestion(question);
				         listenquestion.setOption1(option1);
				         listenquestion.setOption2(option2);
				         listenquestion.setOption3(option3);
				         listenquestion.setOption4(option4);
				         listenquestion.setCorrectanswer(correctanswer);
				        
				       
					 list.add(listenquestion);
						
					}
				}
				
			
			 }	
			 catch (SQLException e) {
				 msglisten="Không có bài hướng dẫn nào trong danh sách";
				 request.setAttribute("msglisten",msglisten );
				  
			}
			 return list;
			 
			 }
}
