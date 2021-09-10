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

import BEAN.Examination;
import BEAN.Grammarguideline;
import BEAN.Vocabularyguideline;
import DAO.GrammarDAO;
import DAO.ManageExamDAO;
import DAO.VocabularyDAO;
import DB.Database;

@WebServlet("/AddVocabularytopic")
public class AddVocabularytopic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AddVocabularytopic() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getCharacterEncoding()==null) {
			request.setCharacterEncoding("UTF-8");
		}
		String vocabularyname = request.getParameter("vocabularyname");
		Vocabularyguideline vocabularyguideline = new Vocabularyguideline();
		vocabularyguideline.setVocabularyname(vocabularyname);
		
		Connection conn= Database.getConnection();
		try {
			boolean kt =VocabularyDAO.addVocabularytopic(request, conn, vocabularyguideline);
			if(kt) {
				int idvocabularyguideline =VocabularyDAO.Retrieveidvocabulary(request, conn, vocabularyguideline);
			
				VocabularyDAO.addVocabularychecked(request, conn, 0, idvocabularyguideline);
			    request.setAttribute("idvocabularyguideline", idvocabularyguideline);
				RequestDispatcher rd=request.getRequestDispatcher("view/admin/Addtopicvocaimage.jsp?idvocabularyguideline="+idvocabularyguideline);
			    rd.forward(request,response);
			}
			else {
				request.setAttribute("msgmanageexam", "Thêm không thành công");
				 RequestDispatcher rd=request.getRequestDispatcher("Displaylistvocabulary?pageid=1");
			     rd.forward(request,response);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

