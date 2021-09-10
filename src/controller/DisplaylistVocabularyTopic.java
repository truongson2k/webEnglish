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
import BEAN.Vocabularyguideline;
import DAO.BaihdtuvungDAO;
import DAO.ExamDAO;
import DB.Database;


@WebServlet("/DisplaylistVocabularyTopic")
public class DisplaylistVocabularyTopic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public DisplaylistVocabularyTopic() {
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
			
				List<Vocabularyguideline> list=BaihdtuvungDAO.DisplayVocabularyDAO(request, conn, pageid, count);
			int sumrow=BaihdtuvungDAO.Countrow(conn);
			int maxpageid=0;
			if((sumrow/count)%2==0) {
				maxpageid=(sumrow/count);
			}
			else {
				maxpageid=(sumrow/count)+1;
			} 
			request.setAttribute("maxpageid",maxpageid);
			request.setAttribute("listvocatopic", list);
			request.setAttribute("numberpage", Integer.parseInt(pageidstr));
			
			} catch (SQLException e) {
				request.setAttribute("msgdstudung", e.getMessage());
			}
		RequestDispatcher rd=request.getRequestDispatcher("view/Listtopicvocabulary.jsp?pageid=1");
	     rd.forward(request,response);
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
}
}