<%@ page language="java" import="mypack.*" import="com.model.*" import="com.dao.*" import="com.web.servlet.*"  pageEncoding="GB2312"%>
<%@ page import="com.model.Volunteer" %><%@ page import="com.model.Department" %>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:useBean id="department" type="com.model.Department" scope="session"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>����־Ը�߷���ʱ�����ϵͳ</title>
  </head>
  
  <body>
  <img src="image/bg.png" width="100%" height="100%" style="position:absolute;top:0;left:0;z-index:-1">
<fieldset>
<legend align=center>����־Ը�߷���ʱ�����ϵͳ</legend>



<br><br><br>
<table border=1 width=70% align=center>
<tr align=center>
  <td><font color=#0000FF>ѧ��</font></td>
  <td><font color=#0000FF>����</font></td>
  <td><font color=#0000FF>�Ա�</font></td>
  <td><font color=#0000FF>�꼶</font></td>
  <td><font color=#0000FF>�����ʱ��</font></td>
  <td><font color=#0000FF>Ȩ��</font></td>
</tr>
<%
	for(int i = 0;i < department.getVolunteers().size();i++)
	{
		Volunteer volunt = (Volunteer)(department.getVolunteers().get(i));
%>
<tr align=center>
  <td><%=volunt.getSno()%></td>
  <td><%=volunt.getSname()%></td>
  <td><%=volunt.getSsex()%></td>
  <td><%=volunt.getSgrade()%></td>
  <td><%=volunt.getVtime()%></td>
  <td><%=volunt.getPermission()%></td>
</tr>
<%}%>
</table>
<br><br><br>
</fieldset>
</body>
</html>
