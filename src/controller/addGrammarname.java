package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.Grammarguideline;
import DAO.GrammarDAO;
import DB.Database;


@WebServlet("/addGrammarname")
public class addGrammarname extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public addGrammarname() {
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
		String grammarname = request.getParameter("grammarname");
		Grammarguideline grammarguideline = new Grammarguideline();
		grammarguideline.setGrammarname(grammarname);
		
		Connection conn= Database.getConnection();
		try {
			boolean kt = GrammarDAO.addGrammarname(request, conn, grammarguideline);
			if(kt) {
				int idgrammar = GrammarDAO.Retrieveidgrammar(request, conn, grammarguideline);
			    request.setAttribute("idgrammar", idgrammar);
				RequestDispatcher rd=request.getRequestDispatcher("view/admin/addgrammarimage.jsp?idgrammar="+idgrammar);
			     rd.forward(request,response);
			}
			else {
				request.setAttribute("message", "Th�m kh�ng th�nh c�ng");
				 RequestDispatcher rd=request.getRequestDispatcher("Listgrammarmanage");
			     rd.forward(request,response);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
