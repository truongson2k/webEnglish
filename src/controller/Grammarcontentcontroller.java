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

import BEAN.Grammarguideline;
import DAO.GrammarDAO;
import DB.Database;


@WebServlet("/Grammarcontentcontroller")
public class Grammarcontentcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Grammarcontentcontroller() {
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
		Connection conn=Database.getConnection();
		String content=request.getParameter("content");
		String idgrammarstr =request.getParameter("idgrammar");
		int idgrammar = Integer.parseInt(idgrammarstr);
		
		Grammarguideline grammarguideline = new Grammarguideline();
		grammarguideline.setContent(content);
		boolean kt;
		try {
			kt = GrammarDAO.addGrammarcontent(request, conn, grammarguideline,idgrammar);
			if(kt)
			{
				RequestDispatcher rd=request.getRequestDispatcher("Listgrammarmanage?pageid=1");
			     rd.forward(request,response);
			}
			else {
				request.setAttribute("msggrammarcontent","Thêm nội dung không thành công");
				request.setAttribute("idgrammar", idgrammar);
				RequestDispatcher rd=request.getRequestDispatcher("view/admin/Addgrammarcontent.jsp");
			     rd.forward(request,response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		}

}
