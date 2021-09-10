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

import BEAN.Member;
import DAO.ManageUserDAO;
import DB.Database;

/**
 * Servlet implementation class UserUpdateInfo
 */
@WebServlet("/UserUpdateInfo")
public class UserUpdateInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdateInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		
		try {
			String idmemberstr=request.getParameter("memberid");
			int idmember =Integer.parseInt(idmemberstr);
			String name = request.getParameter("name");
			String membername = request.getParameter("membername");
			String memberpass = request.getParameter("memberpass");
			
			Member member= new Member();
			member.setName(name);
			member.setMembername(membername);
			member.setMemberpass(memberpass);
			

			Connection conn= Database.getConnection();
			
			ManageUserDAO.userUpdateUser(request, conn, member, idmember);
			RequestDispatcher rd=request.getRequestDispatcher("InformationUserfw?memberid="+idmember);
		     rd.forward(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
