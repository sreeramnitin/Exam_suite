package com.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;
import java.util.LinkedList;

import com.bean.Company;
import com.bean.Exam;
import com.bean.Question;
import com.bean.User;

public class Dao {
	public static User getUserDetails(String semail)
	{
		Connection con = Conn.getConnection(); 
		Statement stmt;
		
		try
		 {
			String query = "select * from participants where email='"+semail+"'" ;
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
		    User u = new User();
			if(rs.next()) 
			{
				u.setEmail(semail);
				u.setName(rs.getString("firstname"));
				u.setLname(rs.getString("lastname"));
				u.setCollege(rs.getString("college"));
				u.setAddress(rs.getString("address"));
				u.setCity(rs.getString("city"));
				u.setState(rs.getString("state"));
				u.setCountry(rs.getString("country"));
				u.setP10(rs.getString("10p"));
				u.setP12(rs.getString("12p"));
				u.setBranch(rs.getString("branch"));
				u.setCourse(rs.getString("course"));
				u.setUgp(rs.getString("ugp"));
			}
			return u;
		 }
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	public static LinkedList<Exam> getCScore(String examid)
	{
		Connection con = Conn.getConnection(); 
		Statement stmt;
		
		try
		 {
			String query = "select * from results where examid='"+examid+"'and score is not null" ;
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			//String ids[] = new String[rs.getRow()];
			LinkedList<Exam> le=new LinkedList<Exam>(); 
			while(rs.next()) 
			{
				Exam exam = new Exam();
				exam.setExamid(rs.getString("examid"));
				exam.setScore(rs.getString("score"));
				exam.setSemail(rs.getString("student"));
				le.add(exam);
				System.out.print("s");
			}
			rs.close();
			Iterator<Exam> iter = le.iterator(); 
			while(iter.hasNext())
			{
				Exam exam = iter.next();
				query = "SELECT * FROM participants  where email='"+exam.getSemail()+"'";
				ResultSet rs2 = stmt.executeQuery(query);
				if(rs2.next())
				{
						exam.setStudent(rs2.getString("firstname")+" "+rs2.getString("lastname"));
				}
			}
			iter = le.iterator();
			while(iter.hasNext())
			{
				Exam exam = iter.next();
				query = "select * from exam where examid='"+exam.getExamid()+"'";
				ResultSet rs2 = stmt.executeQuery(query);
				if(rs2.next())
				{
						exam.setComp(rs2.getString("comp"));
						exam.setSchedule(rs2.getString("schedule"));
						exam.setDuration(rs2.getString("duration"));
						exam.setEname(rs2.getString("ename"));
						exam.setQuestions_per_exam(rs2.getString("questions_per_exam"));
						exam.setMinscore(rs2.getString("minscore"));
				}
		
				
			}	

			return le;
		 }
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	public static LinkedList<Exam> getScore(String student)
	{
		Connection con = Conn.getConnection(); 
		Statement stmt;
		
		try
		 {
			String query = "select * from results where student='"+student+"'and score is not null" ;
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			//String ids[] = new String[rs.getRow()];
			LinkedList<Exam> le=new LinkedList<Exam>(); 
			while(rs.next()) 
			{
				Exam exam = new Exam();
				exam.setExamid(rs.getString("examid"));
				exam.setScore(rs.getString("score"));
				le.add(exam);
				System.out.print("s");
			}
			rs.close();
			Iterator<Exam> iter = le.iterator(); 
			while(iter.hasNext())
			{
				Exam exam = iter.next();
				query = "select * from exam where examid='"+exam.getExamid()+"'";
				ResultSet rs2 = stmt.executeQuery(query);
				if(rs2.next())
				{
						exam.setComp(rs2.getString("comp"));
						exam.setSchedule(rs2.getString("schedule"));
						exam.setDuration(rs2.getString("duration"));
						exam.setEname(rs2.getString("ename"));
						exam.setQuestions_per_exam(rs2.getString("questions_per_exam"));
						exam.setMinscore(rs2.getString("minscore"));
				}
		
				
			}	

			return le;
		 }
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	public static boolean registerExam(String examid,String student)
	{
		Connection con = Conn.getConnection(); 
		Statement stmt;
		
		try
		 {
			String query = "select * from results where examid='"+examid+"' and student='"+student+"'";
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next())
			{
				return false;
			}
			else
			{
				query = "insert into results (examid,student) values('"+examid+"','"+student+"')";
				stmt.execute(query);
				return true;
			}

		 }
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	public static boolean deleteExam(String examid)
	{
		Connection con = Conn.getConnection(); 
		Statement stmt;
		
		try
		 {
			String query = "delete from exam where examid='"+examid+"'";
			stmt = con.createStatement();
		    stmt.execute(query);
			return true;
		 }
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	public static LinkedList<Question> getQuestions(String examid)
	{
		Connection con = Conn.getConnection(); 
		Statement stmt;
		LinkedList<Question> lq = new LinkedList<Question>();
		try
		 {
			String query = "select * from questions where examid='"+examid+"'";
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next())
			{
				Question q = new Question();
				q.qid = rs.getString("id");
				q.question = rs.getString("question");
				q.options[0] = rs.getString("a");
				q.options[1] = rs.getString("b");
				q.options[2] = rs.getString("c");
				q.options[3]= rs.getString("d");
				q.ans = 0;
				lq.add(q);
			}
			return lq;

		 }
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	public static Exam getMyExams(String student,String examid)
	{
		Connection con = Conn.getConnection(); 
		Statement stmt;
		
		try
		 {
			String query = "select * from results where student='"+student+"' and examid='"+examid+"'and score is null" ;
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			if (!rs.next()) 
				return null;
			Exam exam = new Exam();
			exam.setExamid(examid);
			query = "select * from exam where examid='"+examid+"'";
			ResultSet rs2 = stmt.executeQuery(query);
			while(rs2.next())
			{
					exam.setExamid(rs2.getString("examid"));
					exam.setComp(rs2.getString("comp"));
					exam.setSchedule(rs2.getString("schedule"));
					exam.setDuration(rs2.getString("duration"));
					exam.setEname(rs2.getString("ename"));
					exam.setQuestions_per_exam(rs2.getString("questions_per_exam"));
					exam.setMinscore(rs2.getString("minscore"));
			}
		
			
			return exam;
		 }
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	public static Exam getMyExams(String examid)
	{
		Connection con = Conn.getConnection(); 
		Statement stmt;
		
		try
		 {  
			stmt = con.createStatement();
			String query;
			Exam exam = new Exam();
			query = "select * from exam where examid='"+examid+"'";
			ResultSet rs2 = stmt.executeQuery(query);
			while(rs2.next())
			{
					exam.setExamid(rs2.getString("examid"));
					exam.setComp(rs2.getString("comp"));
					exam.setSchedule(rs2.getString("schedule"));
					exam.setDuration(rs2.getString("duration"));
					exam.setEname(rs2.getString("ename"));
					exam.setQuestions_per_exam(rs2.getString("questions_per_exam"));
					exam.setMinscore(rs2.getString("minscore"));
			}
		
			
			return exam;
		 }
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
    public static LinkedList<Exam> getRegisteredExams(String student)
		{
			Connection con = Conn.getConnection(); 
			Statement stmt;
			
			try
			 {
				String query = "select * from results where student='"+student+"' and score is null" ;
				stmt = con.createStatement();
				LinkedList<Exam> l = new LinkedList<Exam>();
				ResultSet rs = stmt.executeQuery(query);
				String eids[];
				int rows = 0 ;
				if (rs.last()) {
				     rows = rs.getRow();
				    // Move to beginning
				    rs.beforeFirst();
				}
				eids = new String[rows];
				int i=0;
				while(rs.next())
				{
					eids[i]=rs.getString(1);
					i++;
				}
				for(i=0;i<rows;i++)	
				{
					Exam exam = new Exam();
					query = "select ename,comp,schedule,examid from exam where examid='"+eids[i]+"'";
					ResultSet rs2 = stmt.executeQuery(query);
					while(rs2.next())
					{
						exam.setEname(rs2.getString(1));
						exam.setComp(rs2.getString(2));
						exam.setSchedule(rs2.getString(3));
						exam.setExamid(rs2.getString(4));
					}
					l.add(exam);
				}
				return l;
			 }
			catch(Exception e)
			{
				e.printStackTrace();
				return null;
			}
		}
	public static LinkedList<Exam> getExamList(String cname)
	{
		Connection con = Conn.getConnection(); 
		Statement stmt;
		LinkedList<Exam> le = new LinkedList<Exam>();
		try
		 {
			String query = "select e.examid,e.ename,e.schedule,e.duration,count(*) from exam e,questions q where e.examid=q.examid and e.comp='"+cname+"' group by e.examid";
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next())
			{
				Exam e = new Exam();
				e.setExamid(rs.getString(1));
				e.setEname(rs.getString(2));
				e.setSchedule(rs.getString(3));
				e.setDuration(rs.getString(4));
				e.setNoofque(rs.getString(5));
				le.add(e);
			}
			return le;
		 }
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	public static LinkedList<String> getSearch(String key)
	{
		Connection con = Conn.getConnection(); 
		Statement stmt;
		LinkedList<String> le = new LinkedList<String>();
		try
		 {
			String query = "select name from company where name LIKE '%"+key+"%';";
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next())
			{
				le.add(rs.getString(1));
			}
			return le;
		 }
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	public static Company getCompanyDetails(String key)
	{
		Connection con = Conn.getConnection(); 
		Statement stmt;
		
		try
		 {
			String query = "select name,des from company where name LIKE '"+key+"'";
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			
				Company c = new Company();
				c.setName(rs.getString(1));
				c.setDes(rs.getString(2));
				LinkedList<Exam> l = getExamList(c.getName());
				c.setExams(l);
			
			return c;
		 }
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	public static boolean register(String email,String pass,String fname,String lname,String college,String address,String city,String state,String country,String p10,String p12,String course,String branch,String ugp)
	{
		Connection con = Conn.getConnection(); 
		Statement stmt;
		try
		 {
			String query = "insert into participants values('"+email+"','"+pass+"','"+fname+"','"+lname+"','"+college+"','"+address+"','"+city+"','"+state+"','"+country+"','"+p10+"','"+p12+"','"+course+"','"+branch+"','"+ugp+"')";
			stmt = con.createStatement();
			stmt.execute(query);
			return true;
		 }
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	public static boolean insertExam(Exam exam)
	{
		Connection con = Conn.getConnection(); 
		Statement stmt;
		
		//if(exam.==null||duration==null||schedule==null||company==null||questions==null)
		//	return false;
		try
		 {
			String query;
			if(exam.getExamid()!=null)
				query = "insert into exam (examid,ename,duration,schedule,comp,questions_per_exam,minscore) values('"+exam.getExamid()+"','"+exam.getEname()+"','"+exam.getDuration()+"','"+exam.getSchedule()+"','"+exam.getComp()+"','"+exam.getNoofque()+"','"+exam.getMinscore()+"')";
			else
				query = "insert into exam (ename,duration,schedule,comp,questions_per_exam,minscore) values('"+exam.getEname()+"','"+exam.getDuration()+"','"+exam.getSchedule()+"','"+exam.getComp()+"','"+exam.getNoofque()+"','"+exam.getMinscore()+"')";
			
				
			stmt = con.createStatement();
			stmt.execute(query);
			ResultSet rs = stmt.executeQuery("select examid from exam where ename='"+exam.getEname()+"'");
			rs.next();
			String examid=rs.getString(1);
			Iterator<Question> i = exam.getQuestions().iterator();
			PreparedStatement ps = con.prepareStatement("insert into questions(question,a,b,c,d,examid,id) values(?,?,?,?,?,?,?)");
			Question q;
			while(i.hasNext())
			{
				q = i.next();
				ps.setString(1,q.question);
				ps.setString(2,q.options[0]);
				ps.setString(3,q.options[1]);
				ps.setString(4,q.options[2]);
				ps.setString(5,q.options[3]);
				ps.setString(6,examid);
				ps.setString(7, q.qid);
				ps.execute();
			}
			return true;
		 }
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	public static boolean setResult(String examid,String student,int score)
	{
		Connection con = Conn.getConnection(); 
		Statement stmt;
		
		try
		 {
			String query = "update results set score="+score+" where examid='"+examid+"' and student='"+student+"'";
			stmt = con.createStatement();
			stmt.execute(query);
			return true;
		 }
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	public static boolean updateProfile(String email, String password,
			String firstname, String lastname, String college,
			String address, String city, String state,
			String country) 
	{
		Connection con = Conn.getConnection(); 
		Statement stmt;
		try
		 {
			String query = "update participants set ";
			System.out.println("password:"+password+".");
			if(!password.equals(""))
			{
			 query += "password='"+password+"',";
			}
			query += "firstname='"+firstname+"',lastname='"+lastname+"',college='"+college+"',address='"+address+"',city='"+city+"',state='"+state+"',country='"+country+"' where email='"+email+"'";
			stmt = con.createStatement();
			stmt.execute(query);
			return true;
		 }
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	public static boolean updateCProfile(Company c) {
		// TODO Auto-generated method stub
		Connection con = Conn.getConnection(); 
		Statement stmt;
		try
		 {
			String query = "update company set ";
			query += "des='"+c.getDes()+"'";
			stmt = con.createStatement();
			stmt.execute(query);
			return true;
		 }
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
}
