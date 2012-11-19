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
	//��ʼ������
	public void init() throws ServletException {
		database = new DataBase();
	}
	//����get���󷽷�
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
    //����post���󷽷�
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();       //��ȡ�û���ǰ�Ự
        String sno = "";                            
        String password = "";
        String page = null;

        if(request.getParameter("sno") != null)
            sno = request.getParameter("sno");  //��ȡ�û���
        if(request.getParameter("password") != null)
            password = request.getParameter("password");  //��ȡ����
        //�ж��û����������Ƿ�ƥ��
        boolean temp = false;
        //System.out.println(sno + ", " + password);
        Connection con = database.getConnection();
        temp = DBUtility.isValid(con, sno, password);
        Volunteer volunteertt = VolunteerDB.getVolunteer(con, sno);
        //�ر����ݿ�����
        database.closeConnection(con);

        if(temp){
        	Volunteer volunteer = null;
        	Connection con2 = database.getConnection();
        	volunteer = DBUtility.getVolunteer(con2, sno);
        	database.closeConnection(con2);
        	//���û���Ϣ����InfoItem�洢��session������
            session.setAttribute("infoitem",volunteer);
            session.setAttribute("volunteer",volunteertt);
            if (!volunteertt.getPermission().trim().equals("��ͨ־Ը��")) 
            {
            page = "index.html";
            }
            else 
            	{page = "index1.html";}
        } else
        	//�����֤ʧ�ܣ�����ʾ��֤ʧ��ҳ��
            page = "errorpage.jsp";
        //�ض�����Ӧ��ҳ��
        response.sendRedirect(page);
        return;
	}
}