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
	//��ʼ������
	public void init() throws ServletException 
	{
		database = new DataBase();
	}

	//����get����
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		doPost(request, response);
	}

    	//����post����
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		Volunteer infoitem = null;
		int vtime = 0;
		String permission = "��ͨ־Ը��";

		//���ñ�������Ϊ"GB2312",����url��������������ʾ��jspҳ����
		request.setCharacterEncoding("GB2312");

		String sno = request.getParameter("sno");   //��ȡ�û���
		String sname = request.getParameter("sname");   //�ǳ�
		String password = request.getParameter("password");   //����
		String password2 = request.getParameter("password2"); //ȷ������
		String ssex = request.getParameter("ssex");       //�Ա�
		String sgrade = request.getParameter("sgrade");     //����
		String dno = request.getParameter("dno");     //Ѫ��
		vtime = Integer.parseInt(request.getParameter("vtime"));       //����
		//permission = request.getParameter("permission");  //����
		
		//�����û���Ϣ���󲢴洢�����ݿ���
		infoitem = new Volunteer(sno, password,sname, ssex, sgrade, dno, vtime, permission);
		Connection con = database.getConnection();
	    	DBUtility.addVolunteer(con, sno, sname, password, ssex, 
				               sgrade, dno, vtime, permission);
		database.closeConnection(con);
		
		//���û���Ϣ�洢���û���ǰ�Ự������
		session.setAttribute("infoitem", infoitem);
		//��ת���û���Ϣ��ʾҳ��
		response.sendRedirect("index.html");
		return;
	}
}