<%@ page language="java" import="java.util.*" pageEncoding="GB2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>����־Ը�߷���ʱ�����ϵͳ</title>
    
  </head>
  
  <body>
  <img src="image/bg.png" width="100%" height="100%" style="position:absolute;top:0;left:0;z-index:-1">
    <center>
    <fieldset>
       <legend align="center">����־Ը�߷���ʱ�����ϵͳ</legend>
       <form name="queryForm" method="post" action="queryservlet2">
           <p align="center">ѧ��:<input type="text" name="xuehao">
           <input type="submit" value="��ѯ">
       </p>
       </form>
    </fieldset>
    </center>
  </body>
</html>
