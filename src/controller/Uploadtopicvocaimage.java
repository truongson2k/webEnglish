package controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ManageExamDAO;
import DAO.VocabularyDAO;
import DB.Database;

/**
 * Servlet implementation class Uploadtopicvocaimage
 */
@WebServlet("/Uploadtopicvocaimage")
public class Uploadtopicvocaimage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Uploadtopicvocaimage() {
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
			String idvocabularyguidelinestr=request.getParameter("idvocabularyguideline");
			int idvocabularyguideline =Integer.parseInt(idvocabularyguidelinestr);
			
			String test=VocabularyDAO.Uploadimagetopic(conn, request, response, idvocabularyguideline);
		 if(test.equals("success")) {
			 RequestDispatcher rd=request.getRequestDispatcher("Displaylistvocabulary?pageid=1");
	     rd.forward(request,response);
		 }
		 else {
			 request.setAttribute("msgthemchude",test);
			 request.setAttribute("idvocabularyguideline", idvocabularyguideline);
				RequestDispatcher rd=request.getRequestDispatcher("view/admin/Addtopicvocaimage.jsp");
			     rd.forward(request,response);
		 }
		}
	
}
