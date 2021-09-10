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
 * Servlet implementation class checkPass
 */
@WebServlet("/checkPass")
public class checkPass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkPass() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 RequestDispatcher rd=request.getRequestDispatcher("view/checkPass.jsp");
	     rd.forward(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		  String messageError ;
//         try {
//        	 Connection conn=Database.getConnection();
//        	 String idmemberstr=request.getParameter("memberid");
// 			 int idmember =Integer.parseInt(idmemberstr);
//    		 String memberpass = request.getParameter("memberpass");
//             Member member=new Member();
//           
//             member.setMemberpass(memberpass);
//			String  authentication = ManageUserDAO.authenticationmember(request, conn, member, idmember);
//			if(authentication=="success") {
//				RequestDispatcher rd=request.getRequestDispatcher("UserUpdateInfofw?memberid="+idmember);
//			     rd.forward(request,response);
//			}
//			else {
//				   messageError="Tên đăng nhập hoặc mật khẩu không đúng";
//				   request.setAttribute("messageError", messageError);
//				RequestDispatcher rd=request.getRequestDispatcher("view/checkPass.jsp");
//				rd.forward(request, response);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
