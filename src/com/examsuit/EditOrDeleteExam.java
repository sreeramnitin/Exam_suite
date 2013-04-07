package com.examsuit;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.data.Dao;

/**
 * Servlet implementation class EditOrDeleteExam
 */
@WebServlet(name = "editordeleteexam", urlPatterns = { "/editordeleteexam" })
public class EditOrDeleteExam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditOrDeleteExam() {
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
		if(request.getParameter("btn").equals("Edit Exam"))
		{
			response.sendRedirect("editexam.jsp?examid="+request.getParameter("examid"));
		}
		else if(request.getParameter("btn").equals("Delete Exam"))
				{
					if(Dao.deleteExam(request.getParameter("examid")))
						response.sendRedirect("chome.jsp");
					else
						response.sendError(404);
				}
	}

}
