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

import BEAN.Member;
import DAO.ManageUserDAO;
import DB.Database;

/**
 * Servlet implementation class InformationUserfw
 */
@WebServlet("/InformationUserfw")
public class InformationUserfw extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InformationUserfw() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idmemberstr=request.getParameter("memberid");
		int idmember =Integer.parseInt(idmemberstr);
		
			Connection conn=Database.getConnection();
			
           List<Member> listuser = ManageUserDAO.DisplayUpdataUserDAO(request, conn, idmember);
		
		   request.setAttribute("listuser", listuser);
		
		
	     RequestDispatcher rd=request.getRequestDispatcher("view/ImformationUsers.jsp?memberid="+idmember);
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
