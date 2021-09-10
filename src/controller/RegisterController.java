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
import DAO.RegisterDAO;
import DB.Database;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 RequestDispatcher rd=request.getRequestDispatcher("view/Register.jsp");
	     rd.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getCharacterEncoding()==null) {
			request.setCharacterEncoding("UTF-8");
		}
		Connection conn= Database.getConnection();
		String name=request.getParameter("name");
		String membername=request.getParameter("membername");
		String memberpass=request.getParameter("memberpass");
		
		Member member=new Member();
		 member.setName(name);
		 member.setMembername(membername);
		 member.setMemberpass(memberpass);
			String msgregister ;

		try {
			boolean test=RegisterDAO.addUser(request, conn, member);
			if(test) {
				msgregister="Đăng ký thành công";
				request.setAttribute("msgregister",msgregister );
				RequestDispatcher rd=request.getRequestDispatcher("Registerforward");
			     rd.forward(request,response);
			}
			else {
				msgregister="Đăng ký không  thành công";
				request.setAttribute("msgregister", msgregister);
				RequestDispatcher rd=request.getRequestDispatcher("Registerforward");
			     rd.forward(request,response);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
