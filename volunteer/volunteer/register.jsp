<%@ page contentType="text/html; charset=GB2312" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>用户注册</title>
  </head>
  <body>
  <img src="image/bg.png" width="100%" height="100%" style="position:absolute;top:0;left:0;z-index:-1">
     <center>
     <fieldset>
     <legend align="center">填写注册信息</legend>
     <form name="registerForm" method="post" action="registerservlet">
		<TABLE align="center" border="0" cellpadding="2" cellspacing="2" width="400px" height="150px">
			<TR>
				<TD align="right" valign="middle" width="25%" height="10%">学号:</TD>
				<TD align="left" valign="middle" width="75%" height="10%">
						<INPUT type="text" name="sno" />
					</TD>	
			</TR>
			<TR>
				<TD align="right" valign="middle" width="25%" height="10%">姓名:</TD>
				<TD align="left" valign="middle" width="75%" height="10%">
						<INPUT type="text" name="sname" />
					</TD>
			</TR>
			<TR>
			    <TD align="right" valign="middle" width="25%" height="10%">密码:</TD>
				<TD align="left" valign="middle" width="75%" height="10%">
						<INPUT type="password" name="password" />
					</TD>	
		    </TR>
			<TR>
				<TD align="right" valign="middle" width="25%" height="10%">确认密码:</TD>
				<TD align="left" valign="middle" width="75%" height="10%">
						<INPUT type="password" name="password2" />
					</TD>	
			</TR>
			<TR>
				<TD align="right" valign="middle" width="25%" height="10%">性别:</TD>
				<TD align="left" valign="middle" width="75%" height="10%">
					<input type="radio" name="ssex" value="男" checked="true"/>男
				    <input type="radio" name="ssex" value="女"/>女
			    </TD>	
			</TR>
			<TR>
				<TD align="right" valign="middle" width="25%" height="10%">年级:</TD>
				<TD align="left" valign="middle" width="75%" height="10%">
						<INPUT type="text" name="sgrade" />
					</TD>	
			</TR>
			<TR>
				<TD align="right" valign="middle" width="25%" height="10%">学院:</TD>
				<TD align="left" valign="middle" width="75%" height="10%">
						<INPUT type="text" name="dno" />
					</TD>	
			</TR>
			<TR>
				<TD align="right" valign="middle" width="25%" height="10%">服务时间:</TD>
				<TD align="left" valign="middle" width="75%" height="10%">
						<INPUT type="text" name="vtime" />
					</TD>	
			</TR>
			<!--TR>
				<TD align="right" valign="middle" width="25%" height="10%">权限:</TD>
				<TD align="left" valign="middle" width="75%" height="10%">
						<INPUT type="text" name="permission" />
					</TD>	
			</TR-->
			<TR>
				<TD colspan="2" align="center" valign="middle">
					<INPUT type="Submit" name="submit" value="提交"/>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</TD>		
			</TR>
		</TABLE>
	   </form>
	   </fieldset>
	   </center>
	</body>
</html>