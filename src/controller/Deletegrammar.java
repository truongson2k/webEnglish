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
import DB.Database;


@WebServlet("/Deletegrammar")
public class Deletegrammar extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Deletegrammar() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn=Database.getConnection();
		String idgrammarstr=request.getParameter("idgrammar");
		int idgrammar = Integer.parseInt(idgrammarstr);
		
		try {
			GrammarDAO.deleteCmtGrammar(conn, idgrammar);
			GrammarDAO.deleteGrammar(conn, idgrammar);
			
			RequestDispatcher rd= request.getRequestDispatcher("Listgrammarmanage?pageid=1");
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
