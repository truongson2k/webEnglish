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

import DAO.GrammarDAO;
import DAO.ManageExamDAO;
import DAO.VocabularyDAO;
import DB.Database;

/**
 * Servlet implementation class DeleteExam
 */
@WebServlet("/DeleteExam")
public class DeleteExam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteExam() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn=Database.getConnection();
		String idexaminationstr=request.getParameter("idexamination");
		int idexamination = Integer.parseInt(idexaminationstr);
		
		try {
		    ManageExamDAO.deleteExamReSult(conn, idexamination);
			ManageExamDAO.deleteExamQuestipon(conn, idexamination);
			ManageExamDAO.deleteExam(conn, idexamination);
			
			RequestDispatcher rd= request.getRequestDispatcher("Listexam?pageid=1");
			rd.forward(request, response);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
