package com.state;

import java.util.HashMap;

public class Attendance {
	private static HashMap<String,HashMap<String,Boolean>> attend = new HashMap<String,HashMap<String,Boolean>>();
	public static boolean register(String examid,String email)
	{
		if(attend.containsKey(examid))
		{
			HashMap<String,Boolean> list = attend.get(examid);
			if(list.containsKey(email))
				return false;
			else
				{
					
					list.put(email,false);
					return true;
				}
		}
		else
		{
			HashMap<String,Boolean> list = new HashMap<String,Boolean>();
			list.put(email,false);
			attend.put(examid, list);
			return true;
		}
		

	}
	public static HashMap<String,Boolean> getList(String examid)
	{
		return attend.get(examid);
	}
	public static boolean getattd(String examid,String email)
	{
		try
		{
			return attend.get(examid).get(email);
		}
		catch(Exception e)
		{}
		return false;
	}
	public static boolean MarkAttendance(String examid,String email)
	{
		try
		{
			 attend.get(examid).put(email, true);
			 return true;
		}
		catch(Exception e)
		{}
		return false;
	}
	public static boolean UnMarkAttendance(String examid,String email)
	{
		try
		{
			 attend.get(examid).put(email, false);
			 return true;
		}
		catch(Exception e)
		{}
		return false;
	}
	
	public static boolean delete(String examid)
	{
		try
		{
			 attend.remove(examid);
			 return true;
		}
		catch(Exception e)
		{}
		return false;
	}
}
