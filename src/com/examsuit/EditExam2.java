package com.examsuit;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Exam;
import com.bean.Question;
import com.data.Dao;

/**
 * Servlet implementation class EditExam2
 */
@WebServlet(name = "editexam2", urlPatterns = { "/editexam2" })
public class EditExam2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditExam2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("btn").equals("Next"))
		{
			HttpSession session = request.getSession();
			Exam e = (Exam)session.getAttribute("exam");
			if(Integer.parseInt(e.getQuestions_per_exam())>=e.getQuestions().size())
			{
				response.sendRedirect("editexam2.jsp");
				return;
			}
			if(Dao.deleteExam(e.getExamid())&&Dao.insertExam(e))
			{
				response.sendRedirect("chome.jsp");
			}
			else
			{
				response.sendError(404);
			}
			
		}
		
		
		
		else if(request.getParameter("btn").equals("Edit"))
		{
			String qid = request.getParameter("qid");
			response.sendRedirect("editexam_edit.jsp?qid="+qid);
		}
		
		
		else if(request.getParameter("btn").equals("Add More"))
		{
			response.sendRedirect("editexam_add.jsp");
		}
		
		
		else if(request.getParameter("btn").equals("Delete"))
		{
			HttpSession session = request.getSession();
			Exam e = (Exam)session.getAttribute("exam");
			if(Integer.parseInt(e.getQuestions_per_exam())>=e.getQuestions().size())
			{
				response.sendRedirect("editexam2.jsp");
				return;
			}
			Iterator<Question> ite= e.getQuestions().iterator();
			while(ite.hasNext())
			{
				Question q = ite.next();
				if(q.qid.equals(request.getParameter("qid")))
				{
					ite.remove();
					response.sendRedirect("editexam2.jsp");
					return;
				}
			}
		}
		else
		{
			response.sendError(404);
		}
		
	}

}
