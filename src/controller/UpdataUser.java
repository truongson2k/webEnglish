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
import BEAN.Member;
import DAO.ManageExamDAO;
import DAO.ManageUserDAO;
import DB.Database;

/**
 * Servlet implementation class UpdataUser
 */
@WebServlet("/UpdataUser")
public class UpdataUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ManageUserDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdataUser() {
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
		
		try {
			String idmemberstr=request.getParameter("memberid");
			int idmember =Integer.parseInt(idmemberstr);
			String name = request.getParameter("name");
			String membername = request.getParameter("membername");
			String idcategorymemberstr=request.getParameter("categorymemberid");
			int idcategorymember =Integer.parseInt(idcategorymemberstr);
			
			Member member= new Member();
			member.setName(name);
			member.setMembername(membername);
			member.setCategorymemberid(idcategorymember);
			
			

			Connection conn= Database.getConnection();
			
			ManageUserDAO.adminUpdateUser(request, conn, member, idmember);
			RequestDispatcher rd=request.getRequestDispatcher("ListUserManage?pageid=1");
		     rd.forward(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
			   
	}

}
