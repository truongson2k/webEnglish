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

import DAO.ListenDAO;
import DAO.ManageExamDAO;
import DB.Database;

@WebServlet("/AddListenQuestion")
public class AddListenQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public AddListenQuestion() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idlistenexercise= request.getParameter("idlistenexercise");
     	request.setAttribute("idlistenexercise", idlistenexercise);
	
	   RequestDispatcher rd=request.getRequestDispatcher("view/admin/AddListenQuestion.jsp?idlistenexercise="+idlistenexercise);
	 rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn=Database.getConnection();
		String idlistenexercisestr=request.getParameter("idlistenexercise");
		int idlistenexercise =Integer.parseInt(idlistenexercisestr);
		
	
		String test=ListenDAO.UploadQuestionListen(conn, request, response, idlistenexercise);
		
	    if(test.equals("success")) {
	    	try {
				
				
				ListenDAO.addListenchecked(request, conn, 1, idlistenexercise);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 RequestDispatcher rd=request.getRequestDispatcher("ListListenManage?pageid=1");
     rd.forward(request,response);
	 }
	 else {
		 request.setAttribute("msglistenquestion",test);
		 request.setAttribute("idlistenexercise", idlistenexercise);
			RequestDispatcher rd=request.getRequestDispatcher("view/admin/AddListenQuestion.jsp?idlistenexercise="+idlistenexercise);
		     rd.forward(request,response);
	 }
	}

}
