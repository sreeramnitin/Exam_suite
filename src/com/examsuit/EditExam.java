package com.examsuit;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Company;
import com.bean.Exam;
import com.bean.Question;
import com.data.Dao;

/**
 * Servlet implementation class EditExam
 */
@WebServlet("/editexam")
public class EditExam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditExam() {
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
		
				// TODO Auto-generated method stub
				HttpSession session = request.getSession();
				String ename = request.getParameter("ename");
				String duration = request.getParameter("duration");
				String schedule = request.getParameter("schedule");
				schedule = schedule+":00";
				String questions = request.getParameter("noofquestions");
				String minscore=request.getParameter("minscore");
				Company c = (Company)session.getAttribute("company");
				Exam exam = (Exam)session.getAttribute("exam");
				exam.setEname(ename);
				exam.setDuration(duration);
				exam.setComp(c.getName());
				exam.setNoofque(questions);
				exam.setSchedule(schedule);
				exam.setMinscore(minscore);
				exam.setQuestions(Dao.getQuestions(exam.getExamid()));
				
				//session.setAttribute("qno", 1);
			
				//System.out.println("Exam details:\n"+exam.getEname()+" "+exam.getComp()+" "+exam.getDuration()+" "+exam.getNoofque()+" "+exam.getSchedule());
				response.sendRedirect("editexam2.jsp");

	}

}
