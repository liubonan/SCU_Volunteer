<%@ page contentType="text/html; charset=GB2312" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>�û�ע��</title>
  </head>
  <body>
  <img src="image/bg.png" width="100%" height="100%" style="position:absolute;top:0;left:0;z-index:-1">
     <center>
     <fieldset>
     <legend align="center">��дע����Ϣ</legend>
     <form name="registerForm" method="post" action="registerservlet">
		<TABLE align="center" border="0" cellpadding="2" cellspacing="2" width="400px" height="150px">
			<TR>
				<TD align="right" valign="middle" width="25%" height="10%">ѧ��:</TD>
				<TD align="left" valign="middle" width="75%" height="10%">
						<INPUT type="text" name="sno" />
					</TD>	
			</TR>
			<TR>
				<TD align="right" valign="middle" width="25%" height="10%">����:</TD>
				<TD align="left" valign="middle" width="75%" height="10%">
						<INPUT type="text" name="sname" />
					</TD>
			</TR>
			<TR>
			    <TD align="right" valign="middle" width="25%" height="10%">����:</TD>
				<TD align="left" valign="middle" width="75%" height="10%">
						<INPUT type="password" name="password" />
					</TD>	
		    </TR>
			<TR>
				<TD align="right" valign="middle" width="25%" height="10%">ȷ������:</TD>
				<TD align="left" valign="middle" width="75%" height="10%">
						<INPUT type="password" name="password2" />
					</TD>	
			</TR>
			<TR>
				<TD align="right" valign="middle" width="25%" height="10%">�Ա�:</TD>
				<TD align="left" valign="middle" width="75%" height="10%">
					<input type="radio" name="ssex" value="��" checked="true"/>��
				    <input type="radio" name="ssex" value="Ů"/>Ů
			    </TD>	
			</TR>
			<TR>
				<TD align="right" valign="middle" width="25%" height="10%">�꼶:</TD>
				<TD align="left" valign="middle" width="75%" height="10%">
						<INPUT type="text" name="sgrade" />
					</TD>	
			</TR>
			<TR>
				<TD align="right" valign="middle" width="25%" height="10%">ѧԺ:</TD>
				<TD align="left" valign="middle" width="75%" height="10%">
						<INPUT type="text" name="dno" />
					</TD>	
			</TR>
			<TR>
				<TD align="right" valign="middle" width="25%" height="10%">����ʱ��:</TD>
				<TD align="left" valign="middle" width="75%" height="10%">
						<INPUT type="text" name="vtime" />
					</TD>	
			</TR>
			<!--TR>
				<TD align="right" valign="middle" width="25%" height="10%">Ȩ��:</TD>
				<TD align="left" valign="middle" width="75%" height="10%">
						<INPUT type="text" name="permission" />
					</TD>	
			</TR-->
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