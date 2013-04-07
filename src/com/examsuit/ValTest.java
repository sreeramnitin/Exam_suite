package com.examsuit;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Exam;
import com.bean.Question;
import com.bean.User;
import com.data.Dao;

/**
 * Servlet implementation class ValTest
 */
@WebServlet(name = "val_test", urlPatterns = { "/val_test" })
public class ValTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		User u = (User)session.getAttribute("user");
		Exam exam = (Exam)session.getAttribute("exam");
		LinkedList<Question> questions = exam.getQuestions();
		Iterator<Question> ite = questions.iterator();
		int score=0;
		int i = 0;
		String ans;
		while(ite.hasNext())
		{
			i++;
			Question q = ite.next();
			 ans = request.getParameter("q"+i);
			 if(ans==null)
				 continue;
			 if(q.ans==Integer.parseInt(ans))
			 {
				 score++;
			 }
		}
		Dao.setResult(exam.getExamid(),u.getEmail(), score);
		exam.setScore(""+score);
		response.sendRedirect("scorecard.jsp");
	}

}
