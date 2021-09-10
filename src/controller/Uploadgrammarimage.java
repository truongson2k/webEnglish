package controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.GrammarDAO;
import DB.Database;

/**
 * Servlet implementation class Uploadgrammarimage
 */
@WebServlet("/Uploadgrammarimage")
public class Uploadgrammarimage extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Uploadgrammarimage() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn=Database.getConnection();
		String idgrammarstr=request.getParameter("idgrammar");
		int idgrammar =Integer.parseInt(idgrammarstr);
		String test=GrammarDAO.Uploadimagegrammar(conn,request, response,idgrammar);
	 if(test.equals("success")) {
		 RequestDispatcher rd=request.getRequestDispatcher("Listgrammarmanage?pageid=1");
     rd.forward(request,response);
	 }
	 else {
		 request.setAttribute("msggrammarimage",test);
		 request.setAttribute("idgrammar", idgrammar);
			RequestDispatcher rd=request.getRequestDispatcher("view/admin/addgrammarimage.jsp");
		     rd.forward(request,response);
	 }
	}

}
