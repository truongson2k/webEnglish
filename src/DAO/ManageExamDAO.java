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




public class ManageExamDAO {
	//Hien thi danh sach de thi
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
		 request.setAttribute("msgmanageexam", "Không có bài hướng dẫn nào trong danh sách");
		}
		 }	
		 catch (SQLException e) {
			 msgmanageexam="Không có bài hướng dẫn nào trong danh sách";
			 request.setAttribute("msgmanageexam",msgmanageexam );
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
	 
	 //them ten de thi
	 public static boolean  addExamname( HttpServletRequest request,Connection conn ,Examination examination) throws SQLException {
		   
	    	
			PreparedStatement ps = conn.prepareStatement("INSERT INTO examination (examinationname) VALUES (?)");
		   
			String examinationname=examination.getExaminationname();
			
			
			ps.setString(1,examinationname);
		 
		   

		    boolean add = ps.executeUpdate() >0;
		    
		    
		    ps.close();
		 
		    return add;
        }
	//Xuat id de thi
		 public static int Retrieveidexam(HttpServletRequest request,Connection conn,Examination examination) {
			 int idexamination =0;

				PreparedStatement ps=null;
				String sql="SELECT idexamination FROM examination where examinationname='"+examination.getExaminationname()+"'";
				
				try {
					ps=conn.prepareStatement(sql);
					ResultSet rs=ps.executeQuery();
					while(rs.next()) {
						 
						idexamination=rs.getInt("idexamination");
					}

				    ps.close();
				    rs.close();
				} catch (SQLException e) {
					request.setAttribute("msggrammarimage", e.getMessage());
				}
			
			    return  idexamination;	
			 
		 }
		//Them hinh de thi
		 public static void  addExamimage( HttpServletRequest request,Connection conn ,String examimage,int idexamination) throws SQLException {
			   
				PreparedStatement ps = conn.prepareStatement("UPDATE examination SET examinationimage=? where idexamination="+idexamination);
				   
				
				
				ps.setString(1,examimage);
			 
			   

			   ps.executeUpdate();
			       
			    ps.close();	 
	}
		 //Upload file hinh
		 public static String Uploadimageexam(Connection conn,HttpServletRequest request, HttpServletResponse response,int idexamination) throws ServletException, IOException  {
				String test="";
						
				ServletContext context =request.getServletContext();
				
				final String Address= context.getRealPath("/Image_AudioExam/");
				
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
									
							
                           ManageExamDAO.addExamimage(request, conn, fileName, idexamination);
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
		 // Ham them file vao de thi
		 public static String UploadQuestionsexam(Connection conn,HttpServletRequest request, HttpServletResponse response,int idexamination) throws ServletException, IOException  {
				String test="";
						
				ServletContext context =request.getServletContext();
				
				final String Address= context.getRealPath("/FileExcelExam/");
				
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
							    	  ManageExamDAO.ImportExamExcel(request, response, conn, pathFile, idexamination);
							    }
							    catch(NullPointerException e) {
							    	test= e.getMessage();
							    }
									 // ManageExamDAO.ImportExamExcel(request, response, conn, pathFile, idexamination);
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
		 public static void ImportExamExcel(HttpServletRequest request,HttpServletResponse response, Connection conn,String Address,int idexamination) throws ServletException, IOException
			{
				FileInputStream inp;
				try 
				{
					inp = new FileInputStream(Address);
					HSSFWorkbook wb = new HSSFWorkbook(new POIFSFileSystem(inp));
					//HSSFWorkbook wb = new HSSFWorkbook(new POIFSFileSystem(inp));
					Sheet sheet = wb.getSheetAt(0);
					
					
					
					for (int i=1; i<=sheet.getLastRowNum();i++)
					{
						Row row = sheet.getRow(i);
						
						int num = (int) row.getCell(0).getNumericCellValue();
						String imagequestion = row.getCell(1).getStringCellValue();
						String audiogg = row.getCell(2).getStringCellValue();
						String audiomp3 = row.getCell(3).getStringCellValue();
						String paragrap = row.getCell(4).getStringCellValue();
						String question = row.getCell(5).getStringCellValue();
						String option1 = row.getCell(6).getStringCellValue();
						String option2 = row.getCell(7).getStringCellValue();
						String option3 = row.getCell(8).getStringCellValue();
						String option4 = row.getCell(9).getStringCellValue();
						String correctanswer = row.getCell(10).getStringCellValue();
						
						
						Examinationquestion ex =new Examinationquestion();
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
					    
					    ManageExamDAO.InsertExamSQL(request, ex, conn);
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
			
		 // Them cau hoi vao sql
			public static void InsertExamSQL(HttpServletRequest request,Examinationquestion ex, Connection conn)
			{
				String sql = "INSERT INTO  examinationquestion (num,imagequestion,audiogg,audiomp3,paragrap,question," 
			      + "option1,option2,option3,option4,correctanswer,idexamination) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
				try 
				{
					PreparedStatement ptmt = conn.prepareStatement(sql);
					
					ptmt.setInt(1,ex.getNum());
					ptmt.setString(2,ex.getImagequestion());
					ptmt.setString(3, ex.getAudiogg());
					ptmt.setString(4, ex.getAudiomp3());
					ptmt.setString(5, ex.getParagrap());
					ptmt.setString(6, ex.getQuestion());
					ptmt.setString(7, ex.getOption1());
					ptmt.setString(8, ex.getOption2());
					ptmt.setString(9, ex.getOption3());
					ptmt.setString(10, ex.getOption4());
					ptmt.setString(11, ex.getCorrectanswer());
					ptmt.setInt(12,ex.getIdexamination());
					
					ptmt.executeUpdate();
					ptmt.close();
					
				} 
				catch (SQLException e) 
				{				
					request.setAttribute("message",e.getMessage());
				}
			}	
			//  kiem tra them noi dung
			 public static void  addExamchecked( HttpServletRequest request,Connection conn ,int checked,int idexamination) 
					 throws SQLException {
				   
					PreparedStatement ps = conn.prepareStatement("UPDATE examination SET checked=? where idexamination="+idexamination);
					   
					
					
					ps.setInt(1,checked);
				 
				   

				   ps.executeUpdate();
				       
				    ps.close();	 
		}
			 // Ham them hinh va audio
			 public static String Uploadimageaudio(Connection conn,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
					String test="";
							
					ServletContext context =request.getServletContext();
					
					final String Address= context.getRealPath("/Image_AudioExam/");
					
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
			 //Xoa bai kiem tra trong examination
			 public static void deleteExam(Connection conn,int idexamination) throws SQLException {
				 String sql="DELETE FROM examination WHERE idexamination="+idexamination;
				 PreparedStatement ptmt= conn.prepareStatement(sql);
					 ptmt.executeUpdate();
					 ptmt.close();
			 }
			 //Xoa bai kiem tra trong examinationQuestion
			 public static void deleteExamQuestipon(Connection conn,int idexamination) throws SQLException {
				 String sql="DELETE FROM examinationquestion WHERE idexamination="+idexamination;
				 PreparedStatement ptmt= conn.prepareStatement(sql);
					 ptmt.executeUpdate();
					 ptmt.close();
			 }
			 //Xoa bai kiem tra trong Réult
			 public static void deleteExamReSult(Connection conn,int idexamination) throws SQLException {
				 String sql="DELETE FROM result WHERE idexamination="+idexamination;
				 PreparedStatement ptmt= conn.prepareStatement(sql);
					 ptmt.executeUpdate();
					 ptmt.close();
			 }
}
