<%@ page language="java" pageEncoding="GB2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>�����ɹ�</title>
  </head>  
  <body>
  <img src="image/bg.png" width="100%" height="100%" style="position:absolute;top:0;left:0;z-index:-1">
    <p>
	  �����ɹ���
    </p>
    <%session.invalidate();%>
    <a href ="html/main.html">��������</a>    
  </body>
</html>
