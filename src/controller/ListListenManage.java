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

import BEAN.Listenexercise;
import BEAN.Vocabularyguideline;
import DAO.ListenDAO;
import DAO.VocabularyDAO;
import DB.Database;

/**
 * Servlet implementation class ListListenManage
 */
@WebServlet("/ListListenManage")
public class ListListenManage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListListenManage() {
        super();
        // TODO Auto-generated constructor stub
    }

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
			
			List<Listenexercise> list=ListenDAO.DisplayListenDAO(request, conn, pageid, count);
			int sumrow=ListenDAO.Countrow(conn);
			int maxpageid=0;
			if((sumrow/count)%2==0) {
				maxpageid=(sumrow/count);
			}
			else {
				maxpageid=(sumrow/count)+1;
			} 
			request.setAttribute("maxpageid",maxpageid);
			request.setAttribute("listlisten", list);
			request.setAttribute("numberpage", Integer.parseInt(pageidstr));
			
			} catch (SQLException e) {
				e.getMessage();
			}
		RequestDispatcher rd=request.getRequestDispatcher("view/admin/ListListenManage.jsp?pageid=1");
		rd.forward(request, response);
	 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
