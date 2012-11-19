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
		String xuehao = request.getParameter("xuehao");
		String xinmima = request.getParameter("xinmima");
		String xinmima2 = request.getParameter("xinmima2");
		
		if(xinmima.equals(xinmima2))
		{
		//��ȡ���ݿ�����
		Connection con = database.getConnection();
		//====================================	
		VolunteerDB.setUpdatePassword(con, xuehao, xinmima);
		//�ر����ݿ�����
		database.closeConnection(con);
		
		response.sendRedirect("/volunteer/VolunteerTeamInsertSuccess.jsp");
		}
		else
			response.sendRedirect("/volunteer/errorpage.jsp");
		return;
		
	}

}
