<%@ page contentType="text/html; charset=GB2312" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>�޸�����</title>
  </head>
  <body>
  <img src="image/bg.png" width="100%" height="100%" style="position:absolute;top:0;left:0;z-index:-1">
     <center>
     <fieldset>
     <legend align="center">��д��������Ϣ</legend>
     &nbsp;&nbsp;
     <form name="registerForm" method="post" action="updatepaswdservlet">
		<TABLE align="center" border="0" cellpadding="2" cellspacing="2" width="400px" height="150px">

			<TR>
			    <TD align="right" valign="middle" width="25%" height="10%">����ѧ��:</TD>
				<TD align="left" valign="middle" width="75%" height="10%">
						<INPUT type="text" name="xuehao" />
					</TD>	
		    </TR>
			<TR>
			    <TD align="right" valign="middle" width="25%" height="10%">����������:</TD>
				<TD align="left" valign="middle" width="75%" height="10%">
						<INPUT type="password" name="xinmima" />
					</TD>	
		    </TR>
			<TR>
				<TD align="right" valign="middle" width="25%" height="10%">ȷ������:</TD>
				<TD align="left" valign="middle" width="75%" height="10%">
						<INPUT type="password" name="xinmima2" />
					</TD>	
			</TR>
			<TR>
				<TD colspan="2" align="center" valign="middle">
					<INPUT type="Submit" name="submit" value="�ύ"/>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</TD>		
			</TR>
		</TABLE>
	   </form>
	   </fieldset>
	   </center>
	</body>
</html>