<%@ page language="java" import="java.util.*" pageEncoding="GB2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>青年志愿者服务时间管理系统</title>
    
  </head>
  
  <body>
  <img src="image/bg.png" width="100%" height="100%" style="position:absolute;top:0;left:0;z-index:-1">
    <center>
    <fieldset>
       <legend align="center">青年志愿者服务时间管理系统</legend>
       <form name="queryForm" method="post" action="queryservlet2">
           <p align="center">学号:<input type="text" name="xuehao">
           <input type="submit" value="查询">
       </p>
       </form>
    </fieldset>
    </center>
  </body>
</html>
