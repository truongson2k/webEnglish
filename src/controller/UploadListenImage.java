package controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ListenDAO;

import DB.Database;

/**
 * Servlet implementation class UploadListenImage
 */
@WebServlet("/UploadListenImage")
public class UploadListenImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadListenImage() {
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
		Connection conn=Database.getConnection();
		String idlistenexercisestr=request.getParameter("idlistenexercise");
		int idlistenexercise =Integer.parseInt(idlistenexercisestr);
		

		String test=ListenDAO.UploadListenImage(conn, request, response, idlistenexercise);
	 if(test.equals("success")) {
		 RequestDispatcher rd=request.getRequestDispatcher("ListListenManage?pageid=1");
     rd.forward(request,response);
	 }
	 else {
		 request.setAttribute("msglistenimage",test);
		 request.setAttribute("idlistenexercise", idlistenexercise);
			RequestDispatcher rd=request.getRequestDispatcher("view/admin/AddListenImage.jsp");
		     rd.forward(request,response);
	 }
	}

}
