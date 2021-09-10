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
import DAO.GrammarDAO;
import DAO.ManageExamDAO;
import DAO.ManageUserDAO;
import DB.Database;

/**
 * Servlet implementation class AddExamname
 */
@WebServlet("/AddExamname")
public class AddExamname extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddExamname() {
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
		if(request.getCharacterEncoding()==null) {
			request.setCharacterEncoding("UTF-8");
		}
		String examinationname = request.getParameter("examinationname");
		Examination examination = new Examination();
		examination.setExaminationname(examinationname);
		
		Connection conn= Database.getConnection();
		try {
			boolean kt = ManageExamDAO.addExamname(request, conn, examination);
		
			if(kt) {
				int idexamination = ManageExamDAO.Retrieveidexam(request, conn, examination);
				ManageExamDAO.addExamchecked(request, conn, 0, idexamination);
			    request.setAttribute("idexamination", idexamination);
				RequestDispatcher rd=request.getRequestDispatcher("view/admin/Addexamimage.jsp?idexamination="+idexamination);
			     rd.forward(request,response);
			}
			else {
				request.setAttribute("msgmanageexam", "Thêm không thành công");
				 RequestDispatcher rd=request.getRequestDispatcher("Listexam?pageid=1");
			     rd.forward(request,response);
			}
			conn.close();
		} catch (SQLException e) {
			request.setAttribute("msgmanageexam", e.getMessage());
			 RequestDispatcher rd=request.getRequestDispatcher("Listexam?pageid=1");
		     rd.forward(request,response);
		}
	}
	}


