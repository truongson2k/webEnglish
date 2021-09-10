package controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.Vocabularycontent;

import DAO.VocabularyDAO;
import DB.Database;


@WebServlet("/ContentVocabulary")
public class ContentVocabulary extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ContentVocabulary() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idvocabularyguidelinestr=request.getParameter("idvocabularyguideline");
		int idvocabularyguideline=Integer.parseInt(idvocabularyguidelinestr);
		Connection conn=Database.getConnection();
		 
		List<Vocabularycontent> list=VocabularyDAO.DisplayContentVocabulary(request, conn,idvocabularyguideline);
		request.setAttribute("contentvocabulary", list);
			
			RequestDispatcher rd=request.getRequestDispatcher("view/ContentVocabulary.jsp");
		     rd.forward(request,response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
