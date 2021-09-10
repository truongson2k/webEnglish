package controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BEAN.Answeruser;
import BEAN.Examinationquestion;
import BEAN.Result;
import DAO.ExamDAO;
import DB.Database;

@WebServlet("/Takeatesttoeic")
public class Takeatesttoeic extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Takeatesttoeic() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn=Database.getConnection();
		String idexaminationstr = request.getParameter("idexamination");
		int idexamination = Integer.parseInt(idexaminationstr);
		
	   
		HttpSession session = request.getSession(true);
		if(session.getAttribute("sessionuser")!=null)
	
		{ 
			int memberid=(int) session.getAttribute("sessionidmember");
			request.setAttribute("kitudb1","\n");
			request.setAttribute("kituhtml1","<br/>");
			request.setAttribute("idexamination",idexamination);
			request.setAttribute("memberid",memberid);
			
			List<Examinationquestion> list=ExamDAO.DisplayQuestionExam(conn, idexamination);
			request.setAttribute("listexam1",list );
			RequestDispatcher rd=request.getRequestDispatcher("view/Takeatesttoeic.jsp");
		     rd.forward(request,response);
		}
		else 
		{
			request.setAttribute("msgloidnlambai","Đăng nhập trước khi làm bài thi");
			RequestDispatcher rd=request.getRequestDispatcher("Displaylistexam?pageid=1");
		     rd.forward(request,response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = Database.getConnection();
		String idexaminationstr = request.getParameter("idexamination");
		int idexamination = Integer.parseInt(idexaminationstr);
		String idmemberstr = request.getParameter("memberid");
		int memberid = Integer.parseInt(idmemberstr);
		
		int countrow =ExamDAO.CountQuestionExam(conn, idexamination);
		
		List<Examinationquestion> listcorrectanswer = ExamDAO.ResultQuestionExam(conn, idexamination);
		
		List<Answeruser> listansweruser = new ArrayList<Answeruser>();
		int socaudung=0;
		for (int i =1; i<= countrow; i++)
		{
			String answer = request.getParameter("ans["+i+"]");
			
			if (answer != null)
			{
				//Luu dan an user
				Answeruser au = new Answeruser();
				
				au.setNum(i);
				au.setAnswer(answer);
				
				listansweruser.add(au);
				String result=ExamDAO.Resultoneexam(conn, idexamination, i);
				
				if(answer.equals(result)) {
					socaudung++;
				}
			}
			else
			{
              Answeruser au = new Answeruser();
				
				au.setNum(i);
				au.setAnswer("Chưa hoàn thành");
				
				listansweruser.add(au);
			
			}
				
			
		}
		Date date =new Date();
		int socausai=countrow-socaudung;
		Result result= new Result();
		result.setCorrectanswernum(socaudung);
		result.setIncorrectanswernum(socausai);
		result.setTime(date.toString());
		result.setIdexamination(idexamination);
		result.setIdmember(memberid);
		
		request.setAttribute("kitudb1","\n");
		request.setAttribute("kituhtml1","<br/>");
		request.setAttribute("listcorrectanswer", listcorrectanswer);
		request.setAttribute("listansweruser", listansweruser);
		
		ExamDAO.SaveResult(conn, result);
		
		List<Result> lists = ExamDAO.DisplayResultExam(conn, date.toString(), idexamination, memberid);
		request.setAttribute("resultexam1", lists);
		
		RequestDispatcher rd = request.getRequestDispatcher("view/ResultExam.jsp");
		rd.forward(request,response);
		
		}	
		
	
		

	}


