package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ManageExamDAO;
import DB.Database;

@WebServlet("/Addexamquestions")
public class Addexamquestions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Addexamquestions() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String idexamination= request.getParameter("idexamination");
     	request.setAttribute("idexamination", idexamination);
	
	   RequestDispatcher rd=request.getRequestDispatcher("view/admin/Addexamquestions.jsp?idexamination="+idexamination);
	 rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn=Database.getConnection();
		String idexaminationstr=request.getParameter("idexamination");
		int idexamination =Integer.parseInt(idexaminationstr);
		
		String test=ManageExamDAO.UploadQuestionsexam(conn, request, response, idexamination);
	    if(test.equals("success")) {
	    	try {
				ManageExamDAO.addExamchecked(request, conn, 1, idexamination);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 RequestDispatcher rd=request.getRequestDispatcher("Listexam?pageid=1");
     rd.forward(request,response);
	 }
	 else {
		 request.setAttribute("msgexamquestion",test);
		 request.setAttribute("idexamination", idexamination);
			RequestDispatcher rd=request.getRequestDispatcher("view/admin/Addexamquestions.jsp?idexamination="+idexamination);
		     rd.forward(request,response);
	 }
	}

}
