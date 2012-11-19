package com.web.servlet;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.dao.DBUtility;
import com.model.Volunteer;

import mypack.DataBase;

public class RegisterServlet extends HttpServlet 
{
	private DataBase database = null;
	//初始化函数
	public void init() throws ServletException 
	{
		database = new DataBase();
	}

	//处理get方法
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		doPost(request, response);
	}

    	//处理post方法
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		Volunteer infoitem = null;
		int vtime = 0;
		String permission = "普通志愿者";

		//设置编码类型为"GB2312",这样url参数就能正常显示在jsp页面上
		request.setCharacterEncoding("GB2312");

		String sno = request.getParameter("sno");   //获取用户名
		String sname = request.getParameter("sname");   //昵称
		String password = request.getParameter("password");   //密码
		String password2 = request.getParameter("password2"); //确认密码
		String ssex = request.getParameter("ssex");       //性别
		String sgrade = request.getParameter("sgrade");     //星座
		String dno = request.getParameter("dno");     //血型
		vtime = Integer.parseInt(request.getParameter("vtime"));       //邮箱
		//permission = request.getParameter("permission");  //年龄
		
		//创建用户信息对象并存储在数据库中
		infoitem = new Volunteer(sno, password,sname, ssex, sgrade, dno, vtime, permission);
		Connection con = database.getConnection();
	    	DBUtility.addVolunteer(con, sno, sname, password, ssex, 
				               sgrade, dno, vtime, permission);
		database.closeConnection(con);
		
		//将用户信息存储在用户当前会话对象中
		session.setAttribute("infoitem", infoitem);
		//跳转到用户信息显示页面
		response.sendRedirect("index.html");
		return;
	}
}