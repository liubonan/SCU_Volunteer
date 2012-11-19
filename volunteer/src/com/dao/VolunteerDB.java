package com.dao;

import java.sql.*;
import java.util.*;

import com.model.Activity;
import com.model.Department;
import com.model.Volunteer;
public class VolunteerDB 
{
	public static Volunteer getVolunteer(Connection con, String sno)
	{
		PreparedStatement prepStmt = null;
	    ResultSet rs = null;
	    Volunteer volunteer = null;
	    Activity activity = null;
	    Vector activities = new Vector();
	  	    
	    String queryString ="select * from volunteer,department where sno = ? and volunteer.dno = department.dno;";
	    try
	    {
	    	prepStmt = con.prepareStatement(queryString);
	    	prepStmt.setString(1, sno);
	    	rs = prepStmt.executeQuery();
	    	 
	    	while(rs.next())
	    	{	             
	    		volunteer = new Volunteer(sno,
	    				                  rs.getString("password"),
	    				                  rs.getString("sname"),
	    				                  rs.getString("ssex"),
	    				                  rs.getString("sgrade"),
	    				                  rs.getString("dname"),
	    				                  rs.getInt("vtime"),
	    				                  rs.getString("permission")	    				                  
	    				                  );
	    	}
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	    
	    
	    //===========================================================
	    queryString = "select sa.ano,aname,adate,atime from sa,activity where sno = ? and sa.ano = activity.ano";
	    
	    try
	    {
	    	prepStmt = con.prepareStatement(queryString);
	    	prepStmt.setString(1, sno);
	    	rs = prepStmt.executeQuery();
	    	while(rs.next())
	    	{
	    	    activity = new Activity(rs.getString("ano"),
	    								rs.getString("aname"),
	    								rs.getString("adate"),
	    								rs.getInt("atime"));
	    		activities.add(activity);
	    	}
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	    
	    if(volunteer != null)
	    	volunteer.setActivities(activities);
	    
		return volunteer;
	}

	public static void setActivity(Connection con, String ano,String aname,String adate,String atime,String canyurenyuan)
	{
		PreparedStatement prepStmt = null;
	    ResultSet rs = null;
	    
	  	int atimeint = Integer.parseInt(atime);
	    String queryString ="insert into activity(ano,aname,adate,atime) values (?,?,'"+adate.trim()+"',?)";
	    try
	    {
	    	
	    	prepStmt = con.prepareStatement(queryString);
	    	prepStmt.setString(1, ano.trim());
	    	prepStmt.setString(2, aname);
	    	//prepStmt.setString(3, adate);
	    	prepStmt.setInt(3, atimeint);
	    		    	
	    	prepStmt.executeUpdate();
	    	 
	    	
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	    
	    char c = ';';
	    int k = 0;
	    String temp;
	    while(c != '.')
	    {
	    	
	    	temp = canyurenyuan.substring(k, 10);
	    	
	    	k = k + 10;
	    	
	    	c = canyurenyuan.toCharArray()[k];
	    	
	    	k ++;
	    	
	    	queryString ="insert into sa(sno,ano) values (?,?)";
	    	
	    	try
		    {		    	
		    	prepStmt = con.prepareStatement(queryString);
		    	prepStmt.setString(1, temp);
		    	prepStmt.setString(2, ano);
	            prepStmt.executeUpdate();		    	
		    }
		    catch(Exception e)
		    {
		    	e.printStackTrace();
		    }
		    queryString ="update volunteer set vtime = vtime + ? where sno = ?";
	    	try
		    {		    	
		    	prepStmt = con.prepareStatement(queryString);
		    	prepStmt.setInt(1, Integer.valueOf(atime).intValue());
		    	prepStmt.setString(2, temp);
	            prepStmt.executeUpdate();		    	
		    }
		    catch(Exception e)
		    {
		    	e.printStackTrace();
		    }
	    }
	    //===========================================================
	    	    
		return ;
	}
	//修改权限
	public static void setUpdatePermission(Connection con, String sno, String permission)
	{
		PreparedStatement prepStmt = null;
	    
	    String queryString ="update volunteer set permission = ? where sno = ?";
	    try
	    {
	    	
	    	prepStmt = con.prepareStatement(queryString);
	    	prepStmt.setString(1, permission);
	    	prepStmt.setString(2, sno);
	    		    	
	    	prepStmt.executeUpdate();
	    }
		    catch(Exception e)
		    {
		    	e.printStackTrace();
		    }
		    
		    
		    //===========================================================
		    	    
			return ;
	    
	}
	//修改密码
	public static void setUpdatePassword(Connection con, String sno, String password)
	{
		PreparedStatement prepStmt = null;
	    
	    String queryString ="update volunteer set password = ? where sno = ?";
	    try
	    {
	    	
	    	prepStmt = con.prepareStatement(queryString);
	    	prepStmt.setString(1, password);
	    	prepStmt.setString(2, sno);
	    		    	
	    	prepStmt.executeUpdate();
	    }
		    catch(Exception e)
		    {
		    	e.printStackTrace();
		    }
		    
		    
		    //===========================================================
		    	    
			return ;
	    
	}

	public static Department getDepartment(Connection con, String dname)
	{
		PreparedStatement prepStmt = null;
	    ResultSet rs = null;
	    Volunteer volunteer = null;
	    Department department = new Department();
	    Vector volunteers = new Vector();
	  	    
	    String queryString ="select sno,password,sname,ssex,sgrade,vtime,permission,department.dno,dname from volunteer,department where department.dno = ? and volunteer.dno = department.dno;";
	    
	    
	    
	    try
	    {
	    	prepStmt = con.prepareStatement(queryString);
	    	prepStmt.setString(1, dname);
	    	rs = prepStmt.executeQuery();
	    	while(rs.next())
	    	{
	    		volunteer = new Volunteer(rs.getString("sno"),
	    								rs.getString("password"),
	    								rs.getString("sname"),
	    								rs.getString("ssex"),
	    								rs.getString("sgrade"),
	    								rs.getString("dno"),
	    								rs.getInt("vtime"),
	    								rs.getString("permission"));
	    		volunteers.add(volunteer);
	    	}
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	    
	    
	    department.setVolunteers(volunteers);
	    
		return department;
	}



}
