package DAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import BEAN.Examination;
import BEAN.Examinationquestion;
import BEAN.Vocabularycontent;
import BEAN.Vocabularyguideline;

public class VocabularyDAO {
	
//hien thi danh sach tu vung
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
		 request.setAttribute("msgmanagevocabulary", "Không có chủ đề bài từ vựng trong danh sách");
		}
		 }	
		 catch (SQLException e) {
			 msgmanagevocabulary="Không có bài hướng dẫn nào trong danh sách";
			 request.setAttribute("msgdsdethi",msgmanagevocabulary );
			  
		}
		 return list;
	//dem so dong	 
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
	 // hien thi noi dung tu vung
	 public static  List<Vocabularycontent> DisplayContentVocabulary(HttpServletRequest request,Connection conn,int idvocabularyguideline )
	 {
		 List<Vocabularycontent> list =new ArrayList<Vocabularycontent>();
		 String sql="SELECT * FROM vocabularycontent where idvocabularyguideline= "+idvocabularyguideline;
		 String msgmanagevocabulary ; 
		 try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ResultSet rs=ptmt.executeQuery();
			if(rs.isBeforeFirst())
			{
				while(rs.next()) {
					
					Vocabularycontent vocabularycontent=new Vocabularycontent();
			      
					
					String vocabularycontentname =rs.getString("vocabularycontentname");
					String transcribe=rs.getString("transcribe");
					String image =rs.getString("image");
					String audiomp3=rs.getString("audiomp3");
					String audiogg =rs.getString("audiogg");
					String mean=rs.getString("mean");
					
					vocabularycontent.setVocabularycontentname(vocabularycontentname);
					vocabularycontent.setTranscribe(transcribe);
					vocabularycontent.setImage(image);
					vocabularycontent.setAudiomp3(audiomp3);
					vocabularycontent.setAudiogg(audiogg);
					vocabularycontent.setMean(mean);
					
				    list.add(vocabularycontent);
					
				}
			}
			else {
		 request.setAttribute("msgndcdtuvung", "Không có nội dung nào");
		}
		 }	
		 catch (SQLException e) {
			 msgmanagevocabulary="Không có bài hướng dẫn nào trong danh sách";
			 request.setAttribute("msgndcdtuvung",msgmanagevocabulary );
			  
		}
		 return list;
		 
		 }
	 // them chu de tu vung
	 public static boolean  addVocabularytopic( HttpServletRequest request,Connection conn ,Vocabularyguideline vocabularyguideline ) 
			 throws SQLException {
		   
	    	
			PreparedStatement ps = conn.prepareStatement("INSERT INTO vocabularyguideline (vocabularyname) VALUES (?)");
		   
			String vocabularyname=vocabularyguideline.getVocabularyname();
			
			
			ps.setString(1,vocabularyname);
		 
		   

		    boolean add = ps.executeUpdate() >0;
		    
		    
		    ps.close();
		 
		    return add;
}
	//Xuat id chu de tu vung
	 public static int Retrieveidvocabulary(HttpServletRequest request,Connection conn,Vocabularyguideline vocabularyguideline) {
		 int idvocabularyguideline =0;

			PreparedStatement ps=null;
			String sql="SELECT idvocabularyguideline FROM vocabularyguideline where vocabularyname='"+vocabularyguideline.getVocabularyname()+"'";
			
			try {
				ps=conn.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					 
					idvocabularyguideline=rs.getInt("idvocabularyguideline");
				}

			    ps.close();
			    rs.close();
			} catch (SQLException e) {
				request.setAttribute("msggrammarimage", e.getMessage());
			}
		
		    return  idvocabularyguideline;	
		 
	 }
	//  kiem tra noi dung chu de
	 public static void  addVocabularychecked( HttpServletRequest request,Connection conn ,int checkcontent,int idvocabularyguideline) throws SQLException {
		   
			PreparedStatement ps = conn.prepareStatement("UPDATE vocabularyguideline SET checkcontent=? where idvocabularyguideline="+idvocabularyguideline);
			   
			
			
			ps.setInt(1,checkcontent);
		 
		   

		   ps.executeUpdate();
		       
		    ps.close();	 
}
	 public static void  addTopicvocaimage( HttpServletRequest request,Connection conn ,String vocabularyimage,int idvocabularyguideline) throws SQLException {
		   
			PreparedStatement ps = conn.prepareStatement("UPDATE vocabularyguideline SET vocabularyimage=? where idvocabularyguideline="+idvocabularyguideline);
			   
			
			
			ps.setString(1,vocabularyimage);
		 
		   

		   ps.executeUpdate();
		       
		    ps.close();	 
}
	 //Upload file hinh vao chu de
	 public static String Uploadimagetopic(Connection conn,HttpServletRequest request, HttpServletResponse response,int idvocabularyguideline) throws ServletException, IOException  {
			String test="";
					
			ServletContext context =request.getServletContext();
			
			final String Address= context.getRealPath("/Image_AudioVocabulary/");
			
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
								
						
							 VocabularyDAO.addTopicvocaimage(request, conn, fileName, idvocabularyguideline);
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
	 // Ham them file vao chu de tu vung
	 public static String UploadVocabularyContent(Connection conn,HttpServletRequest request, HttpServletResponse response,int idvocabularyguideline) throws ServletException, IOException  {
			String test="";
					
			ServletContext context =request.getServletContext();
			
			final String Address= context.getRealPath("/FileVocabularyContent/");
			
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
								
						    try {
						    	 
						    	VocabularyDAO.ImportVocabularyExcel(request, response, conn, pathFile, idvocabularyguideline);
						    }
						    catch(NullPointerException e) {
						    	test= e.getMessage();
						    }
								
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
	 
	 //Them file Excel
	 public static void ImportVocabularyExcel(HttpServletRequest request,HttpServletResponse response, Connection conn,String Address,int idvocabularyguideline) throws ServletException, IOException
		{
			FileInputStream inp;
			try 
			{
				inp = new FileInputStream(Address);
				HSSFWorkbook wb = new HSSFWorkbook(new POIFSFileSystem(inp));
				Sheet sheet = wb.getSheetAt(0);

				for (int i=1; i<=sheet.getLastRowNum();i++)
				{
					Row row = sheet.getRow(i);
					
					
					int num = (int) row.getCell(0).getNumericCellValue();
					String vocabularycontentname = row.getCell(1).getStringCellValue();
					String transcribe = row.getCell(2).getStringCellValue();
				
					String image = row.getCell(3).getStringCellValue();
					String audiomp3 = row.getCell(4).getStringCellValue();
					String audiogg = row.getCell(5).getStringCellValue();
					String mean = row.getCell(6).getStringCellValue();
					
					
					
					Vocabularycontent ex =new Vocabularycontent();
				
					ex.setNum(num);
					ex.setVocabularycontentname(vocabularycontentname);
					ex.setTranscribe(transcribe);
					
				    ex.setImage(image);
				    ex.setAudiomp3(audiomp3);
				    ex.setAudiogg(audiogg);
				    ex.setMean(mean);
				    ex.setIdvocabularyguideline(idvocabularyguideline);
				   VocabularyDAO.InsertVocabularySQL(request, ex, conn);
				} 
				
				wb.close();
				
			} 
			catch (FileNotFoundException e) 
			{
				request.setAttribute("message",e.getMessage());
				
			}
			catch (IOException e) 
			{
				request.setAttribute("message",e.getMessage());
				
			}
			
			
		}
		
	 // Them tu vung vao sql
		public static void InsertVocabularySQL(HttpServletRequest request,Vocabularycontent ex, Connection conn)
		{
			
			String sql = "INSERT INTO  vocabularycontent (num,vocabularycontentname,transcribe,image,audiomp3," 
		      + "audiogg,mean,idvocabularyguideline) VALUES (?,?,?,?,?,?,?,?)";
			try 
			{
				PreparedStatement ptmt = conn.prepareStatement(sql);
				
				ptmt.setInt(1,ex.getNum());
				ptmt.setString(2,ex.getVocabularycontentname());
				ptmt.setString(3, ex.getTranscribe());
				
				ptmt.setString(4, ex.getImage());
				ptmt.setString(5, ex.getAudiomp3());
				ptmt.setString(6, ex.getAudiogg());
				ptmt.setString(7, ex.getMean());
				ptmt.setInt(8, ex.getIdvocabularyguideline());
				
				
				ptmt.executeUpdate();
				ptmt.close();
				
			} 
			catch (SQLException e) 
			{				
				request.setAttribute("message",e.getMessage());
			}
		}	
		 // Ham them hinh va audio
		 public static String Uploadimageaudio(Connection conn,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
				String test="";
						
				ServletContext context =request.getServletContext();
				
				final String Address= context.getRealPath("/Image_AudioVocabulary/");
				
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
		//Xoa tu vung trong vocabularyguideline
		 public static void deleteVocabularyguideline(Connection conn,int idvocabularyguideline) throws SQLException {
			 String sql="DELETE FROM vocabularyguideline WHERE idvocabularyguideline="+idvocabularyguideline;
			 PreparedStatement ptmt= conn.prepareStatement(sql);
				 ptmt.executeUpdate();
				 ptmt.close();
		 }
		//Xoa tu vung trong vocabularycontent
		 public static void deletevocabularycontent(Connection conn,int idvocabularyguideline) throws SQLException {
			 String sql="DELETE FROM vocabularycontent WHERE idvocabularyguideline="+idvocabularyguideline;
			 PreparedStatement ptmt= conn.prepareStatement(sql);
				 ptmt.executeUpdate();
				 ptmt.close();
		 }
}
