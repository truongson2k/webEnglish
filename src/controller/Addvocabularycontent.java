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
import DAO.VocabularyDAO;
import DB.Database;

/**
 * Servlet implementation class Addvocabularycontent
 */
@WebServlet("/Addvocabularycontent")
public class Addvocabularycontent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addvocabularycontent() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idvocabularyguideline= request.getParameter("idvocabularyguideline");
     	request.setAttribute("idvocabularyguideline", idvocabularyguideline);
	
	   RequestDispatcher rd=request.getRequestDispatcher("view/admin/Addvocabularycontent.jsp?idvocabularyguideline="+idvocabularyguideline);
	 rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn=Database.getConnection();
		String idvocabularyguidelinestr=request.getParameter("idvocabularyguideline");
		int idvocabularyguideline =Integer.parseInt(idvocabularyguidelinestr);
		
		
		String test=VocabularyDAO.UploadVocabularyContent(conn, request, response, idvocabularyguideline);
	    if(test.equals("success")) {
	    	try {
				
				VocabularyDAO.addVocabularychecked(request, conn, 1, idvocabularyguideline);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 RequestDispatcher rd=request.getRequestDispatcher("Displaylistvocabulary?pageid=1");
     rd.forward(request,response);
	 }
	 else {
		 request.setAttribute("msgvocacontent",test);
		 request.setAttribute("idvocabularyguideline", idvocabularyguideline);
			RequestDispatcher rd=request.getRequestDispatcher("view/admin/Addvocabularycontent.jsp?idvocabularyguideline="+idvocabularyguideline);
		     rd.forward(request,response);
	 }
	}


}
