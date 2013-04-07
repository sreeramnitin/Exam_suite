package com.examsuit;

import java.io.IOException;
import java.util.LinkedList;

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
 * Servlet implementation class AddExam2
 */
@WebServlet(name = "addexam2", urlPatterns = { "/addexam2" })
public class AddExam2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddExam2() {
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
		HttpSession session = request.getSession();
		Exam exam = (Exam)session.getAttribute("exam");
		Question que = new Question();
		que.question=request.getParameter("question");
		que.options[0]=request.getParameter("a");
		que.options[1]=request.getParameter("b");
		que.options[2]=request.getParameter("c");
		que.options[3]=request.getParameter("d");
		LinkedList<Question> l = exam.getQuestions();
		l.add(que);
		int qno = (Integer) session.getAttribute("qno");
		qno++;
		session.setAttribute("qno", qno);
		System.out.println(qno);
		System.out.println(request.getParameter("btn"));
		if(request.getParameter("btn").equals("Next"))
			response.sendRedirect("addexam2.jsp");
		if(request.getParameter("btn").equals("Add More"))
			response.sendRedirect("editexam_add.jsp");
		if(request.getParameter("btn").equals("Submit"))
		{
			Dao.insertExam(exam);
			response.sendRedirect("chome.jsp");
		}
		if(request.getParameter("btn").equals("Ok"))
		{
			response.sendRedirect("editexam2.jsp");
		}
	}

}
