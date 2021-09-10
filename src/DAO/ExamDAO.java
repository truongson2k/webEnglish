package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import BEAN.Examination;
import BEAN.Examinationquestion;

import BEAN.Result;

public class ExamDAO {
	 public static  List<Examination> DisplayExamDAO(HttpServletRequest request,Connection conn,int start,int count)
	 {
		 List<Examination> list =new ArrayList<Examination>();
		 String sql="SELECT * FROM examination LIMIT "+(start-1)+", "+count+"";
		 String msgmanageexam ; 
		 try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ResultSet rs=ptmt.executeQuery();
			if(rs.isBeforeFirst())
			{
				while(rs.next()) {
					
					Examination examination=new Examination();
			        int idexamination=rs.getInt("idexamination");
					String examinationname =rs.getString("examinationname");
					String examinationimage=rs.getString("examinationimage");
				    int checked =rs.getInt("checked");
					
					examination.setIdexamination(idexamination);
					examination.setExaminationname(examinationname);
				    examination.setExaminationimage(examinationimage);
				    examination.setChecked(checked);
				    list.add(examination);
					
				}
			}
			else {
		 request.setAttribute("msgdsdethi", "Không có bài hướng dẫn nào trong danh sách");
		}
		 }	
		 catch (SQLException e) {
			 msgmanageexam="Không có bài hướng dẫn nào trong danh sách";
			 request.setAttribute("msgdsdethi",msgmanageexam );
			  // request.setAttribute("messageError",e.getMessage());
		}
		 return list;
		 
	 }
	 //dem so dong
	 public static int Countrow(Connection conn) throws SQLException {
			int count=0;
			String sql = "select count(*) from examination";
			PreparedStatement ptmt= conn.prepareStatement(sql);
			ResultSet rs=ptmt.executeQuery();
			rs.next();
			count= rs.getInt(1);
			
			return count;
			
		}
	 //Hien thi cau hoi de thi
	 public static  List<Examinationquestion> DisplayQuestionExam(Connection conn,int idexamination)
	 {
		 List<Examinationquestion> list =new ArrayList<Examinationquestion>();
		 String sql="SELECT * FROM Examinationquestion where idexamination="+idexamination;
		
		 try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ResultSet rs=ptmt.executeQuery();
			
		while(rs.next()) {	
				
					Examinationquestion ex =new Examinationquestion();
					int idexaminationquestion=rs.getInt("idexaminationquestion");
					int num = rs.getInt("num");
					String imagequestion = rs.getString("imagequestion");
					String audiogg = rs.getString("audiogg");
					String audiomp3 = rs.getString("audiomp3");
					String paragrap =rs.getString("paragrap");
					String question = rs.getString("question");
					String option1 = rs.getString("option1");
					String option2 = rs.getString("option2");
					String option3 =rs.getString("option3");
					String option4 = rs.getString("option4");
					String correctanswer =rs.getString("correctanswer");
					
					ex.setIdexaminationquestion(idexaminationquestion);
				    ex.setNum(num);
				    ex.setImagequestion(imagequestion);
				    ex.setAudiogg(audiogg);
				    ex.setAudiomp3(audiomp3);
				    ex.setParagrap(paragrap);
				    ex.setQuestion(question);
				    ex.setOption1(option1);
				    ex.setOption2(option2);
				    ex.setOption3(option3);
				    ex.setOption4(option4);
				    ex.setCorrectanswer(correctanswer);
				    ex.setIdexamination(idexamination);
					
				    list.add(ex);
				}
			
		
		}
		 
		 catch (SQLException e) {
			e.printStackTrace();
		}
		 return list;
		 
	 }
	 //Xuat dap an dung cua bai thi
	 public static  List<Examinationquestion>  ResultQuestionExam(Connection conn,int idexamination)
	 {
		 List<Examinationquestion> list =new ArrayList<Examinationquestion>();
		 String sql="SELECT * FROM Examinationquestion where idexamination="+idexamination;
		
		 try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ResultSet rs=ptmt.executeQuery();
			
		while(rs.next()) {	
				
					Examinationquestion ex =new Examinationquestion();
					int idexaminationquestion=rs.getInt("idexaminationquestion");
					int num = rs.getInt("num");
					String imagequestion = rs.getString("imagequestion");
					String audiogg = rs.getString("audiogg");
					String audiomp3 = rs.getString("audiomp3");
					String paragrap =rs.getString("paragrap");
					String question = rs.getString("question");
					String option1 = rs.getString("option1");
					String option2 = rs.getString("option2");
					String option3 =rs.getString("option3");
					String option4 = rs.getString("option4");
					String correctanswer =rs.getString("correctanswer");
					
					ex.setIdexaminationquestion(idexaminationquestion);
				    ex.setNum(num);
				    ex.setImagequestion(imagequestion);
				    ex.setAudiogg(audiogg);
				    ex.setAudiomp3(audiomp3);
				    ex.setParagrap(paragrap);
				    ex.setQuestion(question);
				    ex.setOption1(option1);
				    ex.setOption2(option2);
				    ex.setOption3(option3);
				    ex.setOption4(option4);
				    ex.setCorrectanswer(correctanswer);
				    ex.setIdexamination(idexamination);
					
				    list.add(ex);
				}
			
		
		}
		 
		 catch (SQLException e) {
			e.printStackTrace();
		}
		 return list;
		
	 }
	 //Dem so cau hoi mot de thi
	 public static int CountQuestionExam(Connection conn,int idexamination)  {
			int count=0;
			String sql = "select count(*) from Examinationquestion where idexamination="+idexamination;
			PreparedStatement ptmt;
			try {
				ptmt = conn.prepareStatement(sql);
				ResultSet rs=ptmt.executeQuery();
				rs.next();
				count= rs.getInt(1);
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return count;
		}
	
	 //Luu ket  ket qua thi
	 public static void SaveResult(Connection conn,Result result) {

			PreparedStatement ps;
			try {
				ps = conn.prepareStatement("INSERT INTO result (correctanswernum, incorrectanswernum, time,idexamination,idmember) VALUES (?,?, ?,?, ?)");
				 int correctanswernum=result.getCorrectanswernum();
				   int incorrectanswernum=result.getIncorrectanswernum();
				   String time=result.getTime();
				   int idexamination=result.getIdexamination();
				   int idmember=result.getIdmember();
				   
				   ps.setInt(1, correctanswernum);
				   ps.setInt(2, incorrectanswernum);
				   ps.setString(3, time);
				   ps.setInt(4, idexamination);
				   ps.setInt(5, idmember);
					
				    ps.executeUpdate();
				    
				    ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		 
		  
	
	 }
	 //Xuat dap an dung cua mot cau hoi
	 public static String Resultoneexam(Connection conn,int idexamination,int num ) {
		 String result="";
		 List<Examinationquestion> list =new ArrayList<Examinationquestion>();
		 String sql="SELECT correctanswer FROM examinationquestion where idexamination="+idexamination+" and num="+num;
		
		 try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ResultSet rs=ptmt.executeQuery();
			
		while(rs.next()) {	
			result =rs.getString(1);
				}
			
		
		}
		 
		 catch (SQLException e) {
			e.printStackTrace();
		}
		 
		return result;
		 
	 }
	 //Xuat ket qua thi cua thanh vien
	 public static List<Result> DisplayResultExam(Connection conn,String time,int idexamination,int memberid)  {
			List<Result> list = new ArrayList<Result>();
			
			String sql = "select * from result where time='"+time+"' and  idexamination="+idexamination+" and idmember="+memberid;
			PreparedStatement ptmt;
			try {
				ptmt = conn.prepareStatement(sql);
				ResultSet rs=ptmt.executeQuery();
				
				while(rs.next()) {
					int correctanswernum= rs.getInt("correctanswernum");
					 int incorrectanswernum=rs.getInt("incorrectanswernum");
					 Result result= new Result();
					 result.setCorrectanswernum(correctanswernum);
					 result.setIncorrectanswernum(incorrectanswernum);
					 list.add(result);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return list;
		}
	
}
