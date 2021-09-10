package controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ListenDAO;
import DAO.ManageExamDAO;
import DB.Database;

/**
 * Servlet implementation class AddListenAudioimage
 */
@WebServlet("/AddListenAudioimage")
public class AddListenAudioimage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public AddListenAudioimage() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn=Database.getConnection();
		
		String test=ListenDAO.Uploadimageaudio(conn, request, response);
	    if(test.equals("success")) {
	    	
		 RequestDispatcher rd=request.getRequestDispatcher("ListListenManage?pageid=1");
     rd.forward(request,response);
	 }
	 else {
		 request.setAttribute("msglistenquestion",test);
		
			RequestDispatcher rd=request.getRequestDispatcher("view/admin/ListListenManage.jsp");
		     rd.forward(request,response);
	 }
	}

}
