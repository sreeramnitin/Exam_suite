package com.examsuit;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Company;
import com.bean.Exam;


/**
 * Servlet implementation class Addexam
 */
@WebServlet(name = "addexam", urlPatterns = { "/addexam" })
public class AddExam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddExam() {
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
		String ename = request.getParameter("ename");
		String duration = request.getParameter("duration");
		String schedule = request.getParameter("schedule");
		schedule = schedule+":00";
		String questions = request.getParameter("noofquestions");
		String minscore=request.getParameter("minscore");
		Company c = (Company)session.getAttribute("company");
		Exam exam = new  Exam();
		exam.setEname(ename);
		exam.setDuration(duration);
		exam.setComp(c.getName());
		exam.setNoofque(questions);
		exam.setSchedule(schedule);
		exam.setMinscore(minscore);
		session.setAttribute("qno", 1);
		session.setAttribute("exam",exam);
		System.out.println("Exam details:\n"+exam.getEname()+" "+exam.getComp()+" "+exam.getDuration()+" "+exam.getNoofque()+" "+exam.getSchedule());
		response.sendRedirect("addexam2.jsp");
		/*if(Dao.insertExam(ename,duration,schedule,c.getName(),questions))
		{
			session.setAttribute("error","");
			session.setAttribute("exam",exam);
			response.sendRedirect("addexam2.jsp");
		}
		else
		{
			session.setAttribute("error","cannot add exam");
			response.sendRedirect("addexam.jsp");
		}*/
	}

}
