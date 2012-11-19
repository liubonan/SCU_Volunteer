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
		String xueyuan = request.getParameter("xueyuan");
		System.out.println(xueyuan);
		//��ȡ���ݿ�����
		Connection con = database.getConnection();
				
		//Volunteer volunteer = VolunteerDB.getVolunteer(con, xueyuan);
		Department department = VolunteerDB.getDepartment(con, xueyuan);
		//�ر����ݿ�����
		database.closeConnection(con);
		
		if(department == null)
		
		{
			//��ת������ҳ��
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
