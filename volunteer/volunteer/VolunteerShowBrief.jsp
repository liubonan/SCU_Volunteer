<%@ page language="java" import="mypack.*" import="com.model.*" import="com.dao.*" import="com.web.servlet.*"  pageEncoding="GB2312"%>
<%@ page import="com.model.Volunteer" %>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:useBean id="volunteer" type="com.model.Volunteer" scope="session"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>����־Ը�߷���ʱ�����ϵͳ</title>
  </head>
  
  <body>
  <img src="image/bg.png" width="100%" height="100%" style="position:absolute;top:0;left:0;z-index:-1">
<fieldset>
<legend align=center>����־Ը�߷���ʱ�����ϵͳ</legend><br><br><br>
<table border=1 width=70% align=center>
<tr align=center>
  <td><font color=#0000FF>ѧ��</font></td>
  <td><font color=#0000FF>����</font></td>
  <td><font color=#0000FF>�Ա�</font></td>
  <td><font color=#0000FF>�꼶</font></td>
  <td><font color=#0000FF>ѧԺ</font></td>
  <td><font color=#0000FF>������ʱ��</font></td>
  <td><font color=#0000FF>Ȩ��</font></td>
  
</tr>
<tr align=center>
  <td><%=volunteer.getSno()%></td>
  <td><%=volunteer.getSname()%></td>
  <td><%=volunteer.getSsex()%></td>
  <td><%=volunteer.getSgrade()%></td>
  <td><%=volunteer.getDno()%></td>
  <td><%=volunteer.getVtime()%></td>
  <td><%=volunteer.getPermission()%></td>
  
</tr>
</table>
<br>
<br>
<br>

<table border=1 width=70% align=center>
<tr align=center>
  <td><font color=#0000FF>����</font></td>
  <td><font color=#0000FF>�����</font></td>
  <td><font color=#0000FF>�����</font></td>
  <td><font color=#0000FF>�����ʱ��</font></td>
</tr>
<%
	for(int i = 0;i < volunteer.getActivities().size();i++)
	{
		Activity activity = (Activity)(volunteer.getActivities().get(i));
%>
<tr align=center>
  <td><%=activity.getAno()%></font></td>
  <td><%=activity.getAname()%></font></td>
  <td><%=activity.getAdate()%></font></td>
  <td><%=activity.getAtime()%></font></td>
</tr>
<%}%>
</table>
<br><br><br>
</fieldset>
</body>
</html>
