<%@ page contentType="text/html; charset=GB2312" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>�޸�־Ը��Ȩ��</title>
  </head>
  <%! String permission[] = {"��ͨ־Ը��", "ϵͳ����Ա"};
  %>
  <body>
     <center>
     <fieldset>
     <legend align="center">�޸�־Ը��Ȩ��</legend>
     <form name="registerForm" method="post" action="updatepermisservlet">
		<TABLE align="center" border="0" cellpadding="2" cellspacing="2" width="400px" height="150px">
			<TR>
				<TD align="right" valign="middle" width="25%" height="10%">־Ը��ѧ��:</TD>
				<TD align="left" valign="middle" width="75%" height="10%">
						<INPUT type="text" name="xuehao" />
					</TD>	
			</TR>
			<TR>
				<TD align="right" valign="middle" width="25%" height="10%">�޸ĺ�Ȩ��:</TD>
				<TD align="left" valign="middle" width="75%" height="10%">
			 <select name="xinquanxian">
				       <%for(int i = 0; i <permission.length; i++){
				           if(i == 0){%>
				              <option value=<%=permission[i]%> selected>
				                  <%=permission[i]%>
				              </option>
				           <%}else{%>
				              <option value=<%=permission[i]%>>
				                  <%=permission[i]%>
				              </option>
				           <%}%>
				       <%}%> 
				    </select>   
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