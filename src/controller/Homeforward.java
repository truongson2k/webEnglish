package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import java.sql.*;
import java.util.*;

@WebServlet(name="Homeforward",urlPatterns="/homeforward")
public class Homeforward extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Homeforward() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    Connection conn= Database.getConnection();
//	 
//	List<slidebanner> list =HomeDAO.Displaysliderbanner(conn);
//	request.setAttribute("listslidebanner", list);
    RequestDispatcher rd=request.getRequestDispatcher("view/Home.jsp");
     rd.forward(request,response);
		 
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
		doGet(request, response);
	}
}


