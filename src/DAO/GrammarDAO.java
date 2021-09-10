package DAO;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import BEAN.Grammarguideline;



public class GrammarDAO {
//	private Connection connection;
	 public static  List<Grammarguideline> DisplayGrammarDAO(HttpServletRequest request,Connection conn,int start,int count)
	 {
		 List<Grammarguideline> list =new ArrayList<Grammarguideline>();
		 String sql="SELECT * FROM grammar LIMIT "+(start-1)+", "+count+"";
		 String messageError ; 
		 try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ResultSet rs=ptmt.executeQuery();
			if(rs.isBeforeFirst())
			{
				while(rs.next()) {
					
					Grammarguideline gmgl=new Grammarguideline();
			        int idgrammar=rs.getInt("idgrammar");
					String grammarname =rs.getString("grammarname");
					String grammarimage=rs.getString("grammarimage");
					String content=rs.getString("content");
				

					
					gmgl.setIdgrammar(idgrammar);
					gmgl.setGrammarname(grammarname);
					gmgl.setGrammarimage(grammarimage);
					gmgl.setContent(content);
					list.add(gmgl);
					
				}
			}
			else {
				// messageError="Không có bài hướng dẫn nào trong danh sách";
				   request.setAttribute("messageError", "Không có bài hướng dẫn nào trong danh sách");
		}
		 }	
		 catch (SQLException e) {
			 messageError="Không có bài hướng dẫn nào trong danh sách";
			 request.setAttribute("messageError",messageError );
			  // request.setAttribute("messageError",e.getMessage());
		}
		 return list;
		 
		 }
	 //dem so dong
	 public static int Countrow(Connection conn) throws SQLException {
			int count=0;
			String sql = "select count(*) from grammar";
			PreparedStatement ptmt= conn.prepareStatement(sql);
			ResultSet rs=ptmt.executeQuery();
			rs.next();
			count= rs.getInt(1);
			
			return count;
			
		}
	 
	 //them ten  bai huong dan
	 public static boolean  addGrammarname( HttpServletRequest request,Connection conn ,Grammarguideline grammarguideline) throws SQLException {
		   
	    	
			PreparedStatement ps = conn.prepareStatement("INSERT INTO grammar (grammarname) VALUES (?)");
		   
			String grammarname=grammarguideline.getGrammarname();
			
			
			ps.setString(1,grammarname);
		 
		   

		    boolean add = ps.executeUpdate() >0;
		    
		    
		    ps.close();
		 
		    return add;
}
	 //Them hinh bai ngu phap
	 public static String Uploadimagegrammar(Connection conn,HttpServletRequest request, HttpServletResponse response,int idgrammar) throws ServletException, IOException  {
		String test="";
				
		ServletContext context =request.getServletContext();
		
		final String Address= context.getRealPath("/Imageupload/");
		
		final int MaxMemorySize=1024*1024*3;
		 final int MaxRequestSize=1024*1024*5;
		 response.setContentType("text/html; charset=UTF-8");
		 boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		 if(!isMultipart) {
			//out.println("not have enctypr: multipart/form-data");

		test="Thiếu multipart/form-data trong form ";
			 	
		 }
		 DiskFileItemFactory factory = new DiskFileItemFactory();
		 factory.setSizeThreshold(MaxMemorySize);
		 factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
		 
		 ServletFileUpload upload = new ServletFileUpload(factory);
		 upload.setSizeMax(MaxRequestSize);
		 
		 try {
			List<FileItem> items= upload.parseRequest(request);
			Iterator<FileItem> iter=items.iterator();
			while(iter.hasNext()) {
				FileItem item=iter.next();
				
				if (!item.isFormField()) {
					String fileName = item.getName();
					String pathFile = Address + File.separator + fileName;
					File uploadedFile = new File(pathFile);
					boolean kt = uploadedFile.exists();
					try {
						if(kt==true) {

						//	out.println(" Require: test file again");
						test="File đã tồn tại yêu cầu chọn file khác";
						}
						else {
							item.write(uploadedFile);
							
					GrammarDAO.addGrammarimage(request, conn, fileName, idgrammar);

						test="success";
						}
					}
					catch (Exception e) {
						

						test=e.getMessage();
					}
			}
				else {

					test="Thêm file thất bại";
					}
				}
		} catch (FileUploadException e) {

			test=e.getMessage();
		}
		 return test;
	 }

//Xuat id bai huong dan ngu phap
	 public static int Retrieveidgrammar(HttpServletRequest request,Connection conn,Grammarguideline grammarguideline) {
		   int idgrammar =0;

			PreparedStatement ps=null;
			String sql="SELECT idgrammar FROM grammar where grammarname='"+grammarguideline.getGrammarname()+"'";
			
			try {
				ps=conn.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					 
					idgrammar=rs.getInt("idgrammar");
				}

			    ps.close();
			    rs.close();
			} catch (SQLException e) {
				request.setAttribute("msggrammarimage", e.getMessage());
			}
		
		    return  idgrammar;	
		 
	 }
	 //Them ten hinh bai huong dan theo id cua bai
	 public static void  addGrammarimage( HttpServletRequest request,Connection conn ,String image,int idgrammar) throws SQLException {
		   
	    	
			PreparedStatement ps = conn.prepareStatement("UPDATE grammar SET grammarimage=? where idgrammar="+idgrammar);
		   
			
			
			ps.setString(1,image);
		 
		   

		   ps.executeUpdate();
		       
		    ps.close();	 
}
	//Thêm nội dug cho bai huong dan
	 public static boolean  addGrammarcontent( HttpServletRequest request,Connection conn ,Grammarguideline grammarguideline,int id) throws SQLException {
		   
	    	
			PreparedStatement ps = conn.prepareStatement("UPDATE grammar SET content=? where idgrammar="+id);
		   
			String grammarcontent=grammarguideline.getContent();
			
			
			ps.setString(1,grammarcontent);
		 
		   

		    boolean add = ps.executeUpdate() >0;
		    
		    
		    ps.close();
		
		    return add;
}
	 //Xoa bai huong dan
	 public static void deleteGrammar(Connection conn,int idgrammar) throws SQLException {
		 String sql="DELETE FROM grammar WHERE idgrammar="+idgrammar;
		 PreparedStatement ptmt= conn.prepareStatement(sql);
			 ptmt.executeUpdate();
			 ptmt.close();
	 }
	 //Xoa ma bai huong dan trong cmt
 public static void deleteCmtGrammar(Connection conn,int idgrammar) throws SQLException {
     String sql="DELETE FROM cmtgrammar WHERE idgrammar="+idgrammar;
	 PreparedStatement ptmt= conn.prepareStatement(sql);
		 ptmt.executeUpdate();
		 ptmt.close();
	 }
}

