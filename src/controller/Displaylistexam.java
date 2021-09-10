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

import BEAN.Examination;
import BEAN.Grammarguideline;
import DAO.BaihdnguphapDAO;
import DAO.ExamDAO;
import DB.Database;

/**
 * Servlet implementation class Displaylistexam
 */
@WebServlet("/Displaylistexam")
public class Displaylistexam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Displaylistexam() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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
			
				List<Examination> list=ExamDAO.DisplayExamDAO(request, conn,pageid, count);
			int sumrow=ExamDAO.Countrow(conn);
			int maxpageid=0;
			if((sumrow/count)%2==0) {
				maxpageid=(sumrow/count);
			}
			else {
				maxpageid=(sumrow/count)+1;
			} 
			request.setAttribute("maxpageid",maxpageid);
			request.setAttribute("listexam", list);
			request.setAttribute("numberpage", Integer.parseInt(pageidstr));
			RequestDispatcher rd=request.getRequestDispatcher("view/Listexamtoeic.jsp?pageid=1");
		     rd.forward(request,response);
			} catch (SQLException e) {
				e.getMessage();
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
