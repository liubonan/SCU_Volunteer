package com.web.servlet;
import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;

import mypack.DataBase;

import com.dao.VolunteerDB;


public class InsertServlet extends HttpServlet
{
	private DataBase database = null;
	//��ʼ������
	public void init() throws ServletException 
	{
		database = new DataBase();
	}
    //����get���󷽷�
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		doPost(request, response);
	}

	//����post����
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		//��ȡ�û���ǰ�Ự
		HttpSession session = request.getSession();
		//��ȡѧ��
		String huodongbianhao = request.getParameter("huodonbianhao");
		String huodongmingcheng = request.getParameter("huodongmingcheng");
		String huodongriqi = request.getParameter("huodongriqi");
		String fuwushichang = request.getParameter("fuwushichang");
		String canyurenyuan = request.getParameter("canyurenyuan");
		
		//��ȡ���ݿ�����
		Connection con = database.getConnection();
		//====================================	
		//Volunteer volunteer = VolunteerDB.getVolunteer(con, xuehao);
		VolunteerDB.setActivity(con, huodongbianhao, huodongmingcheng, huodongriqi, fuwushichang, canyurenyuan);
		//�ر����ݿ�����
		database.closeConnection(con);
		
		response.sendRedirect("/volunteer/VolunteerTeamInsertSuccess.jsp");
			
		return;
		
	}

}
