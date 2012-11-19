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
    <title>青年志愿者服务时间管理系统</title>
  </head>
  
  <body>
  <img src="image/bg.png" width="100%" height="100%" style="position:absolute;top:0;left:0;z-index:-1">
<fieldset>
<legend align=center>青年志愿者服务时间管理系统</legend>



<br><br><br>
<table border=1 width=70% align=center>
<tr align=center>
  <td><font color=#0000FF>学号</font></td>
  <td><font color=#0000FF>姓名</font></td>
  <td><font color=#0000FF>性别</font></td>
  <td><font color=#0000FF>年级</font></td>
  <td><font color=#0000FF>活动服务时间</font></td>
  <td><font color=#0000FF>权限</font></td>
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
