package com.web.servlet;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.dao.DBUtility;
import com.dao.VolunteerDB;
import com.model.Volunteer;

import mypack.DataBase;
   
public class LoginServlet extends HttpServlet {
	private DataBase database = null;
	//初始化函数
	public void init() throws ServletException {
		database = new DataBase();
	}
	//处理get请求方法
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
    //处理post请求方法
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();       //获取用户当前会话
        String sno = "";                            
        String password = "";
        String page = null;

        if(request.getParameter("sno") != null)
            sno = request.getParameter("sno");  //获取用户名
        if(request.getParameter("password") != null)
            password = request.getParameter("password");  //获取密码
        //判断用户名、密码是否匹配
        boolean temp = false;
        //System.out.println(sno + ", " + password);
        Connection con = database.getConnection();
        temp = DBUtility.isValid(con, sno, password);
        Volunteer volunteertt = VolunteerDB.getVolunteer(con, sno);
        //关闭数据库连接
        database.closeConnection(con);

        if(temp){
        	Volunteer volunteer = null;
        	Connection con2 = database.getConnection();
        	volunteer = DBUtility.getVolunteer(con2, sno);
        	database.closeConnection(con2);
        	//将用户信息对象InfoItem存储在session对象当中
            session.setAttribute("infoitem",volunteer);
            session.setAttribute("volunteer",volunteertt);
            if (!volunteertt.getPermission().trim().equals("普通志愿者")) 
            {
            page = "index.html";
            }
            else 
            	{page = "index1.html";}
        } else
        	//如果验证失败，则显示验证失败页面
            page = "errorpage.jsp";
        //重定向到相应的页面
        response.sendRedirect(page);
        return;
	}
}