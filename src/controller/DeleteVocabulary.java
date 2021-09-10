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
 * Servlet implementation class DeleteVocabulary
 */
@WebServlet("/DeleteVocabulary")
public class DeleteVocabulary extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DeleteVocabulary() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn=Database.getConnection();
		String idvocabularyguidelinestr=request.getParameter("idvocabularyguideline");
		int idvocabularyguideline = Integer.parseInt(idvocabularyguidelinestr);
		
		try {
			VocabularyDAO.deletevocabularycontent(conn, idvocabularyguideline);
			VocabularyDAO.deleteVocabularyguideline(conn, idvocabularyguideline);
		
			RequestDispatcher rd= request.getRequestDispatcher("Displaylistvocabulary?pageid=1");
			rd.forward(request, response);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
