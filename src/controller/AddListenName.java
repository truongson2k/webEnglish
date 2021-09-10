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
import BEAN.Listenexercise;
import DAO.ListenDAO;
import DAO.ManageExamDAO;
import DB.Database;


@WebServlet("/AddListenName")
public class AddListenName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddListenName() {
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

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		if(request.getCharacterEncoding()==null) {
			request.setCharacterEncoding("UTF-8");
		}
		String listenexercisename = request.getParameter("listenexercisename");
		Listenexercise listenexercise = new Listenexercise();
		listenexercise.setListenexercisename(listenexercisename);
		
		Connection conn= Database.getConnection();
		try {
			
			boolean kt = ListenDAO.addListenName(request, conn, listenexercise);
			
			if(kt) {
				
				int idlistenexercise = ListenDAO.Retrieveidlistenexercise(request, conn, listenexercise);
				
				
			ListenDAO.addListenchecked(request, conn, 0, idlistenexercise);
				
			    request.setAttribute("idlistenexercise", idlistenexercise);
				RequestDispatcher rd=request.getRequestDispatcher("view/admin/AddListenImage.jsp?idlistenexercise="+idlistenexercise);
			     rd.forward(request,response);
			}
			else {
				request.setAttribute("msgmanagelisten", "Thêm không thành công");
				 RequestDispatcher rd=request.getRequestDispatcher("ListListenManage?pageid=1");
			     rd.forward(request,response);
			}
			conn.close();
		} catch (SQLException e) {
			request.setAttribute("msgmanagelisten", e.getMessage());
			 RequestDispatcher rd=request.getRequestDispatcher("ListListenManage?pageid=1");
		     rd.forward(request,response);
		}
	}
	}


