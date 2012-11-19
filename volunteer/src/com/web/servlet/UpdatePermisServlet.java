package com.web.servlet;
import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;

import mypack.DataBase;

import com.dao.VolunteerDB;


public class UpdatePermisServlet extends HttpServlet
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
		//设置编码类型为"GB2312",这样url参数就能正常显示在jsp页面上
		request.setCharacterEncoding("GB2312");
		//获取学号
		String xuehao = request.getParameter("xuehao");
		String xinquanxian =request.getParameter("xinquanxian");
		
		//获取数据库连接
		Connection con = database.getConnection();
		//====================================	
		
		VolunteerDB.setUpdatePermission(con, xuehao, xinquanxian);
		//关闭数据库连接
		database.closeConnection(con);
		
		response.sendRedirect("/volunteer/VolunteerTeamInsertSuccess.jsp");
			
		return;
		
	}

}
