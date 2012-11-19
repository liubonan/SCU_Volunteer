<%@ page language="java" import="java.util.*" pageEncoding="GB2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>青年志愿者时间银行系统</title>
    
  </head>
  
  <body>
  <img src="image/bg.png" width="100%" height="100%" style="position:absolute;top:0;left:0;z-index:-1">
    <center>
    <fieldset>
       <legend align="center">青年志愿者时间银行系统</legend>
       <form name="queryForm" method="post" action="insertservlet">
           活动编号:<input type="text" name="huodonbianhao">
           活动名称:<input type="text" name="huodongmingcheng">
           活动日期:<input type="text" name="huodongriqi">
           服务时长:<input type="text" name="fuwushichang">
           <br><br>
           参与志愿者学号（注意使用英文输入,多个志愿者以“;”分隔,以“.”结束）<br>
           <input type="text"  style="width:800;overflow:visible" name="canyurenyuan">
           <input type="submit" value="插入活动">
       </form>
    </fieldset>
    </center>
  </body>
</html>
