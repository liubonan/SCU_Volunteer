package com.web.servlet;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

import mypack.DataBase;

import com.dao.VolunteerDB;
import com.model.Volunteer;

public class QueryServlet2 extends HttpServlet 
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
		
		//��ȡ���ݿ�����
		Connection con = database.getConnection();
				
		Volunteer volunteer = VolunteerDB.getVolunteer(con, xuehao);
		
		//�ر����ݿ�����
		database.closeConnection(con);
		
		if(volunteer == null)
		
		{
			//��ת������ҳ��
			response.sendRedirect("/volunteer/errorpage.jsp");
			return;
		}
		else
		{
						
			session.setAttribute("volunteer", volunteer);
						
			response.sendRedirect("/volunteer/VolunteerShow.jsp");
			
			return;
		}
	}
}
