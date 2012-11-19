package com.web.servlet;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

import mypack.DataBase;

import com.dao.VolunteerDB;
import com.model.Department;
import com.model.Volunteer;

public class QueryServlet3 extends HttpServlet 
{
	private DataBase database = null;
	//初始化函数
	public void init() throws ServletException 
	{
		database = new DataBase();
	}
    //处理get请求方法
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		doPost(request, response);
	}

	//处理post方法
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		//获取用户当前会话
		HttpSession session = request.getSession();
		//获取学号
		String xueyuan = request.getParameter("xueyuan");
		System.out.println(xueyuan);
		//获取数据库连接
		Connection con = database.getConnection();
				
		//Volunteer volunteer = VolunteerDB.getVolunteer(con, xueyuan);
		Department department = VolunteerDB.getDepartment(con, xueyuan);
		//关闭数据库连接
		database.closeConnection(con);
		
		if(department == null)
		
		{
			//跳转到出错页面
			response.sendRedirect("/volunteer/errorpage.jsp");
			return;
		}
		else
		{
						
			session.setAttribute("department", department);
			
						
			response.sendRedirect("/volunteer/VolunteerTeamShow.jsp");
			
			return;
		}
	}
}
