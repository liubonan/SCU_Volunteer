<%@ page language="java" import="java.util.*" pageEncoding="GB2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>����־Ը��ʱ������ϵͳ</title>
    
  </head>
  
  <body>
  <img src="image/bg.png" width="100%" height="100%" style="position:absolute;top:0;left:0;z-index:-1">
    <center>
    <fieldset>
       <legend align="center">����־Ը��ʱ������ϵͳ</legend>
       <form name="queryForm" method="post" action="insertservlet">
           ����:<input type="text" name="huodonbianhao">
           �����:<input type="text" name="huodongmingcheng">
           �����:<input type="text" name="huodongriqi">
           ����ʱ��:<input type="text" name="fuwushichang">
           <br><br>
           ����־Ը��ѧ�ţ�ע��ʹ��Ӣ������,���־Ը���ԡ�;���ָ�,�ԡ�.��������<br>
           <input type="text"  style="width:800;overflow:visible" name="canyurenyuan">
           <input type="submit" value="����">
       </form>
    </fieldset>
    </center>
  </body>
</html>
