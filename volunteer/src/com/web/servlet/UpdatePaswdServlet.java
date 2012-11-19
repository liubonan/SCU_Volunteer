package com.web.servlet;
import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;

import mypack.DataBase;

import com.dao.VolunteerDB;


public class UpdatePaswdServlet extends HttpServlet
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
		String xuehao = request.getParameter("xuehao");
		String xinmima = request.getParameter("xinmima");
		String xinmima2 = request.getParameter("xinmima2");
		
		if(xinmima.equals(xinmima2))
		{
		//获取数据库连接
		Connection con = database.getConnection();
		//====================================	
		VolunteerDB.setUpdatePassword(con, xuehao, xinmima);
		//关闭数据库连接
		database.closeConnection(con);
		
		response.sendRedirect("/volunteer/VolunteerTeamInsertSuccess.jsp");
		}
		else
			response.sendRedirect("/volunteer/errorpage.jsp");
		return;
		
	}

}
