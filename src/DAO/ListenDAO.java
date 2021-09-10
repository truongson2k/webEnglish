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

import BEAN.Examinationquestion;
import BEAN.Listenexercise;
import BEAN.Listenquestion;


public class ListenDAO {

	//Hien thi danh sach de thi
		 public static  List<Listenexercise> DisplayListenDAO(HttpServletRequest request,Connection conn,int start,int count)
		 {
			 List<Listenexercise> list =new ArrayList<Listenexercise>();
			 String sql="SELECT * FROM listenexercise LIMIT "+(start-1)+", "+count+"";
			 String msgmanagelisten ; 
			 try {
				PreparedStatement ptmt=conn.prepareStatement(sql);
				ResultSet rs=ptmt.executeQuery();
				if(rs.isBeforeFirst())
				{
					while(rs.next()) {
						
						Listenexercise listenexercise=new Listenexercise();
				        int idlistenexercise=rs.getInt("idlistenexercise");
						String listenexercisename =rs.getString("listenexercisename");
						String listenexerciseimage=rs.getString("listenexerciseimage");
					    int checklisten =rs.getInt("checklisten");
						
					    listenexercise.setIdlistenexercise(idlistenexercise);
					    listenexercise.setListenexercisename(listenexercisename);
					    listenexercise.setListenexerciseimage(listenexerciseimage);
					    listenexercise.setChecklisten(checklisten);
					  
					    list.add(listenexercise);
						
					}
				}
				else {
			 request.setAttribute("msgmanagelisten", "Không có bài hướng dẫn nào trong danh sách");
			}
			 }	
			 catch (SQLException e) {
				 msgmanagelisten="Không có bài hướng dẫn nào trong danh sách";
				 request.setAttribute("msgmanagelisten",msgmanagelisten );
				  
			}
			 return list;
			 
			 }
		 //dem so dong
		 public static int Countrow(Connection conn) throws SQLException {
				int count=0;
				String sql = "select count(*) from listenexercise";
				PreparedStatement ptmt= conn.prepareStatement(sql);
				ResultSet rs=ptmt.executeQuery();
				rs.next();
				count= rs.getInt(1);
				
				return count;
				
			}
		 //them ten tieu de
		 public static boolean  addListenName( HttpServletRequest request,Connection conn ,Listenexercise listenexercise ) 
				 throws SQLException {
			   
		    	
				PreparedStatement ps = conn.prepareStatement("INSERT INTO listenexercise (listenexercisename) VALUES (?)");
			   
				String listenexercisename=listenexercise.getListenexercisename();
				
				
				ps.setString(1,listenexercisename);
			 
			   

			    boolean add = ps.executeUpdate() >0;
			    
			    
			    ps.close();
			 
			    return add;
	}
		//Xuat id ten bai nghe
		 public static int Retrieveidlistenexercise(HttpServletRequest request,Connection conn,Listenexercise listenexercise) {
			 int idlistenexercise =0;

				PreparedStatement ps=null;
				String sql="SELECT idlistenexercise FROM listenexercise where listenexercisename='"+listenexercise.getListenexercisename()+"'";
				
				try {
					ps=conn.prepareStatement(sql);
					ResultSet rs=ps.executeQuery();
					while(rs.next()) {
						 
						idlistenexercise=rs.getInt("idlistenexercise");
					}

				    ps.close();
				    rs.close();
				} catch (SQLException e) {
					request.setAttribute("msglistenimage", e.getMessage());
				}
			
			    return  idlistenexercise;	
			 
		 }
		//  kiem tra noi dung bai nghe
		 public static void  addListenchecked( HttpServletRequest request,Connection conn ,int checklisten,int idlistenexercise) throws SQLException {
			   
				PreparedStatement ps = conn.prepareStatement("UPDATE listenexercise SET checklisten=? where idlistenexercise="+idlistenexercise);
				   
				
				
				ps.setInt(1,checklisten);
			 
			   

			   ps.executeUpdate();
			       
			    ps.close();	 
	}
		 //them ten anh vao sql
		 public static void  addListenimage( HttpServletRequest request,Connection conn ,String listenexerciseimage,int idlistenexercise) throws SQLException {
			   
				PreparedStatement ps = conn.prepareStatement("UPDATE listenexercise SET listenexerciseimage=? where idlistenexercise="+idlistenexercise);
				   
				
				
				ps.setString(1,listenexerciseimage);
			 
			   

			   ps.executeUpdate();
			       
			    ps.close();	 
	}
		 //Upload file hinh vao chu de
		 public static String UploadListenImage(Connection conn,HttpServletRequest request, HttpServletResponse response,int idlistenexercise) throws ServletException, IOException  {
				String test="";
						
				ServletContext context =request.getServletContext();
				
				final String Address= context.getRealPath("/FileListen/");
				
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
									
								 
								 ListenDAO.addListenimage(request, conn, fileName, idlistenexercise);
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
		 public static String UploadQuestionListen(Connection conn,HttpServletRequest request, HttpServletResponse response,int idlistenexercise) throws ServletException, IOException  {
				String test="";
						
				ServletContext context =request.getServletContext();
				
				final String Address= context.getRealPath("/FileExcelListen/");
				
				final int MaxMemorySize=1024*1024*3;
				 final int MaxRequestSize=1024*1024*5;
				 response.setContentType("text/html; charset=UTF-8");
				 boolean isMultipart = ServletFileUpload.isMultipartContent(request);
				 if(!isMultipart) {
					
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
							    	
							    	  ListenDAO.ImportListenExcel(request, response, conn, pathFile, idlistenexercise);
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
		 public static void ImportListenExcel(HttpServletRequest request,HttpServletResponse response, Connection conn,String Address,int idlistenexercise) throws ServletException, IOException
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
						String imagename = row.getCell(1).getStringCellValue();
					
						String audiomp3 = row.getCell(2).getStringCellValue();
					
						String question = row.getCell(3).getStringCellValue();
						String option1 = row.getCell(4).getStringCellValue();
						String option2 = row.getCell(5).getStringCellValue();
						String option3 = row.getCell(6).getStringCellValue();
						String option4 = row.getCell(7).getStringCellValue();
						String correctanswer = row.getCell(8).getStringCellValue();
						
						
						Listenquestion lq =new Listenquestion();
					   lq.setNum(num);
					   lq.setImagename(imagename);
					   lq.setAudiomp3(audiomp3);
					   lq.setQuestion(question);
					   lq.setOption1(option1);
					   lq.setOption2(option2);  
					   lq.setOption3(option3);
					   lq.setOption4(option4); 
					   lq.setCorrectanswer(correctanswer);
					   lq.setIdlistenexercise(idlistenexercise);
					  
					   ListenDAO.InsertListenSQL(request, lq, conn);
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
			public static void InsertListenSQL(HttpServletRequest request,Listenquestion lq, Connection conn)
			{
				String sql = "INSERT INTO  listenquestion (num,imagename,audiomp3,question," 
			      + "option1,option2,option3,option4,correctanswer,idlistenexercise) VALUES (?,?,?,?,?,?,?,?,?,?)";
				try 
				{
					PreparedStatement ptmt = conn.prepareStatement(sql);
					
					ptmt.setInt(1,lq.getNum());
					ptmt.setString(2, lq.getImagename());
					ptmt.setString(3, lq.getAudiomp3());
					ptmt.setString(4, lq.getQuestion());
					ptmt.setString(5, lq.getOption1());
					ptmt.setString(6, lq.getOption2());
					ptmt.setString(7, lq.getOption3());
					ptmt.setString(8, lq.getOption4());
					ptmt.setString(9, lq.getCorrectanswer());
					
					ptmt.setInt(10,lq.getIdlistenexercise());
					
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
					
					final String Address= context.getRealPath("/FileListen/");
					
					final int MaxMemorySize=1024*1024*3;
					 final int MaxRequestSize=1024*1024*5;
					 response.setContentType("text/html; charset=UTF-8");
					 boolean isMultipart = ServletFileUpload.isMultipartContent(request);
					 if(!isMultipart) {
						
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
		 
		 

		//Xoa phan nghe trong Listenexercise
		 public static void deleteListenexercise(Connection conn,int idlistenexercise) throws SQLException {
			 String sql="DELETE FROM listenexercise WHERE idlistenexercise="+idlistenexercise;
			 PreparedStatement ptmt= conn.prepareStatement(sql);
				 ptmt.executeUpdate();
				 ptmt.close();
		 }
		//Xoa phan nghe trong listenquestion
		 public static void deleteListenquestion(Connection conn,int idlistenexercise) throws SQLException {
			 String sql="DELETE FROM listenquestion WHERE idlistenexercise="+idlistenexercise;
			 PreparedStatement ptmt= conn.prepareStatement(sql);
				 ptmt.executeUpdate();
				 ptmt.close();
		 }
}
