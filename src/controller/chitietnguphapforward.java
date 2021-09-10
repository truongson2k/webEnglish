package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.Grammarguideline;
import DAO.BaihdnguphapDAO;
import DB.Database;



@WebServlet("/chitietnguphapforward")
public class chitietnguphapforward extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public chitietnguphapforward() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mastr=request.getParameter("ma");
		int ma=Integer.parseInt(mastr);
		Connection conn=Database.getConnection();
		String content;
		String name;
		try {
			content = BaihdnguphapDAO.Displaygrammarcontent(conn, ma);
			name= BaihdnguphapDAO.Displaygrammarname(conn, ma);
			request.setAttribute("ma", ma);
			request.setAttribute("grammarcontent", content);
			request.setAttribute("grammarname", name);
			request.setAttribute("kitudb1", "\n");
			request.setAttribute("kituhtml1","<br/>");
			request.setAttribute("kitudb2", "**");
			request.setAttribute("kituhtml2","<br>");
			request.setAttribute("kitudb3", "<b> ");
		    request.setAttribute("kituhtml3","</b>");
			
			
			RequestDispatcher rd=request.getRequestDispatcher("view/chitietnguphap.jsp");
		     rd.forward(request,response);
		
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
