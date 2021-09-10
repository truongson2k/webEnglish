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

import DAO.GrammarDAO;
import DB.Database;

@WebServlet("/Listgrammarmanage")
public class Listgrammarmanage extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Listgrammarmanage() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String pageidstr=request.getParameter("pageid");
			int pageid= Integer.parseInt(pageidstr);
			int count=4;
			if (pageid==1) {
				
			}
			else {
				pageid = pageid - 1;
				pageid = pageid * count + 1;
			}
			Connection conn=Database.getConnection();
			
			List<Grammarguideline> list1= GrammarDAO.DisplayGrammarDAO(request,conn,pageid, count);
			int sumrow=GrammarDAO.Countrow(conn);
			int maxpageid=0;
			if((sumrow/count)%2==0) {
				maxpageid=(sumrow/count);
			}
			else {
				maxpageid=(sumrow/count);
			} 
			request.setAttribute("maxpageid",maxpageid);
			request.setAttribute("listgrammarmanage", list1);
			request.setAttribute("numberpage", Integer.parseInt(pageidstr));
			RequestDispatcher rd=request.getRequestDispatcher("view/admin/Listgrammarmanage.jsp");
		     rd.forward(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	    
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
