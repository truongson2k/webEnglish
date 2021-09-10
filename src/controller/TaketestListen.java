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
import BEAN.Listenquestion;
import DAO.ListenDAO;
import DAO.TestListenDAO;
import DB.Database;


@WebServlet("/TaketestListen")
public class TaketestListen extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public TaketestListen() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String idlistenexercisestr=request.getParameter("idlistenexercise");
			int idlistenexercise= Integer.parseInt(idlistenexercisestr);
			
			String pageidstr=request.getParameter("pageid");
			int pageid= Integer.parseInt(pageidstr);
			int count=1;
			if (pageid==1) {
				
			}
			else {
				pageid = pageid - 1;
				pageid = pageid * count + 1;
			}
			Connection conn=Database.getConnection();
			
			List<Listenquestion> list=TestListenDAO.DisplayTestListenDAO(request, conn, pageid, count, idlistenexercise);
			int sumrow=TestListenDAO.Countrow(conn, idlistenexercise);
			int maxpageid=0;
			if((sumrow/count)%2==0) {
				maxpageid=(sumrow/count);
			}
			else {
				maxpageid=(sumrow/count)+1;
			} 
			request.setAttribute("maxpageid",maxpageid);
			request.setAttribute("idlistenexercise", idlistenexercise);
			request.setAttribute("listtestlisten", list);
			request.setAttribute("numberpage", Integer.parseInt(pageidstr));
			
			} catch (SQLException e) {
				request.setAttribute("msglisten", e.getMessage());
			}
		RequestDispatcher rd= request.getRequestDispatcher("view/TaketestListen.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String kq =request.getParameter("kq");
	Connection conn=Database.getConnection();
		
		String idlistenexercisestr=request.getParameter("idlistenexercise");
		int idlistenexercise= Integer.parseInt(idlistenexercisestr);
		
		String numstr=request.getParameter("num");
		int num= Integer.parseInt(numstr);
		if(kq=="") {
			request.setAttribute("msgtestlisten","Chọn câu trả lời trước khi xem đáp án");
			RequestDispatcher rd= request.getRequestDispatcher("view/tbnghe.jsp");
			rd.forward(request, response);
			
		}
		else {
		

			List<Listenquestion> list =TestListenDAO.ResultTestListenDAO(request, conn, idlistenexercise, num);
			request.setAttribute("resultlisten",list);
			request.setAttribute("kq", kq);
			RequestDispatcher rd= request.getRequestDispatcher("view/ResultListen.jsp");
			rd.forward(request, response);

		}
		
		
	}

}
