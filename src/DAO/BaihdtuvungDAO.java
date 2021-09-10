package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.mysql.cj.xdevapi.JsonString;

import BEAN.Vocabularyguideline;

public class BaihdtuvungDAO {
	public static  List<Vocabularyguideline> DisplayVocabularyDAO(HttpServletRequest request,Connection conn,int start,int count)
	 {
		 List<Vocabularyguideline> list =new ArrayList<Vocabularyguideline>();
		 String sql="SELECT * FROM vocabularyguideline LIMIT "+(start-1)+", "+count+"";
		 String msgmanagevocabulary ; 
		 try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ResultSet rs=ptmt.executeQuery();
			if(rs.isBeforeFirst())
			{
				while(rs.next()) {
					
					Vocabularyguideline vocabularyguideline=new Vocabularyguideline();
			        int idvocabularyguideline=rs.getInt("idvocabularyguideline");
					String vocabularyname =rs.getString("vocabularyname");
					String vocabularyimage=rs.getString("vocabularyimage");
				    int checkcontent =rs.getInt("checkcontent");
				    
				    vocabularyguideline.setIdvocabularyguideline(idvocabularyguideline);
				    vocabularyguideline.setVocabularyname(vocabularyname);
				    vocabularyguideline.setVocabularyimage(vocabularyimage);
				    vocabularyguideline.setCheckcontent(checkcontent);
				    
				    list.add(vocabularyguideline);
					
				}
			}
			else {
		 request.setAttribute("msgdstudung", "Không có chủ đề bài từ vựng trong danh sách");
		}
		 }	
		 catch (SQLException e) {
			 msgmanagevocabulary="Không có bài hướng dẫn nào trong danh sách";
			 request.setAttribute("msgdstudung",msgmanagevocabulary );
			  
		}
		 return list;
		 
	 }
	 public static int Countrow(Connection conn) throws SQLException {
			int count=0;
			String sql = "select count(*) from vocabularyguideline";
			PreparedStatement ptmt= conn.prepareStatement(sql);
			ResultSet rs=ptmt.executeQuery();
			rs.next();
			count= rs.getInt(1);
			
			return count;
			
		}
}
