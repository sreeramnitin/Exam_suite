package com.examsuit;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Iterator;
import java.util.LinkedList;

import com.bean.Exam;
import com.bean.Question;
import com.bean.User;
import com.data.Dao;
import com.state.Attendance;

/**
 * Servlet implementation class StartTest
 */
@WebServlet(name = "starttest", urlPatterns = { "/starttest" })
public class StartTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StartTest() {
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
		HttpSession session  = request.getSession();
		User u = (User)session.getAttribute("user");
		Exam e = (Exam)session.getAttribute("exam");
		LinkedList<Question> lq = Dao.getQuestions(e.getExamid());
		e.setQuestions(lq);
		removeExtraQuestions(lq,e.getQuestions_per_exam());
		System.out.println("size:"+lq.size());
		Iterator<Question> ite = lq.iterator();
		String temp;
		int no1,no2;
		while(ite.hasNext())
		{
			Question q = ite.next();
	
			for(int i = 0 ;i < randgen(0,30);i++)
			{
				no1=randgen(0,4);
				no2=randgen(0,4);
				temp=q.options[no1];
				q.options[no1]=q.options[no2];
				q.options[no2]=temp;
				if (q.ans==no1)
					q.ans=no2;
				else if(q.ans==no2)
					q.ans=no1;
			}
		}
		
			response.sendRedirect("test2.jsp");
		
	}

	private void removeExtraQuestions(LinkedList<Question> lq,String no_of_que) {
		// TODO Auto-generated method stub
		int size = Integer.parseInt(no_of_que);
		while(lq.size()>size)
		{
			int rand = randgen(0,lq.size());
			lq.remove(rand);
		}
	}

	private int randgen(int min, int max) {
		// TODO Auto-generated method stub
		int rand = min + (int)(Math.random()*max);
		return rand;
	}

}
