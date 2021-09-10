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

/**
 * Servlet implementation class Addexamaudioimage
 */
@WebServlet("/Addexamaudioimage")
public class Addexamaudioimage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addexamaudioimage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn=Database.getConnection();
		
		
		String test=ManageExamDAO.Uploadimageaudio(conn, request, response);
	    if(test.equals("success")) {
	    	
		 RequestDispatcher rd=request.getRequestDispatcher("Listexam?pageid=1");
     rd.forward(request,response);
	 }
	 else {
		 request.setAttribute("msgexamquestion",test);
		
			RequestDispatcher rd=request.getRequestDispatcher("view/admin/ManageExam.jsp");
		     rd.forward(request,response);
	 }
	}
	}


