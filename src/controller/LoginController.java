package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.StyledEditorKit.BoldAction;

import BEAN.Member;
import DAO.LoginDAO;
import DB.Database;

import java.sql.*;
@WebServlet("/loginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginController() {
        super();
    }

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{
		 RequestDispatcher rd=request.getRequestDispatcher("view/Login.jsp");
	     rd.forward(request,response);
			 
     	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
           Connection conn=Database.getConnection();
           
           String membername = request.getParameter("membername");
           
           String memberpass = request.getParameter("memberpass");
           Member member=new Member();
           member.setMembername(membername);
           member.setMemberpass(memberpass);
   		   String messageError ;
   		
	   
          
           try {
				String name=LoginDAO.Exportnamemember(request, conn, member);
                int memberid=LoginDAO.Exportidmember(request, conn, member);
		    	String  authentication =LoginDAO.authenticationmember(request, conn, member);
			if(authentication=="success") {
				int authorization =LoginDAO.authorizationmember(request, conn, member);
				if(authorization==1)
				{
					HttpSession session =request.getSession(true);
					session.setAttribute("sessionuser",name);	
					session.setAttribute("sessionidmember",memberid);	
					RequestDispatcher rd=request.getRequestDispatcher("homeforward");
					rd.forward(request, response);
				}
				else {
					if(authorization==2) {
						HttpSession session =request.getSession(true);
						session.setAttribute("sessionadmin",name);			
						RequestDispatcher rd=request.getRequestDispatcher("Adminforward");
						rd.forward(request, response);
					}
				}
			}
			else {
				   messageError="Tên đăng nhập hoặc mật khẩu không đúng";
				   request.setAttribute("messageError", messageError);
				RequestDispatcher rd=request.getRequestDispatcher("view/Login.jsp");
				rd.forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}

