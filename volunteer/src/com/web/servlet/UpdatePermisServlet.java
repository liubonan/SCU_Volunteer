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
		//���ñ�������Ϊ"GB2312",����url��������������ʾ��jspҳ����
		request.setCharacterEncoding("GB2312");
		//��ȡѧ��
		String xuehao = request.getParameter("xuehao");
		String xinquanxian =request.getParameter("xinquanxian");
		
		//��ȡ���ݿ�����
		Connection con = database.getConnection();
		//====================================	
		
		VolunteerDB.setUpdatePermission(con, xuehao, xinquanxian);
		//�ر����ݿ�����
		database.closeConnection(con);
		
		response.sendRedirect("/volunteer/VolunteerTeamInsertSuccess.jsp");
			
		return;
		
	}

}
