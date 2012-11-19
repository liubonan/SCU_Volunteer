package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.model.Volunteer;

public class DBUtility {
    //�ж��û����������Ƿ���ȷ
	public static boolean isValid(Connection con, String sno, String password){
	    PreparedStatement prepStmt = null;
	    ResultSet rs = null;                //�洢��ѯ���
	    String selectStatement = "select sno from volunteer" +
	                                " where sno=? and password=?";
	    boolean temp = false;
	    try{
	       prepStmt = con.prepareStatement(selectStatement);
	       prepStmt.setString(1, sno);
	       prepStmt.setString(2, password);
	       rs = prepStmt.executeQuery();     //��ѯ���ݿⲢ���ؽ����¼��
	       if (rs.next())                    //���ݿ��ﺬ�д��û�����������򷵻�true
	          temp = true;
	       else
	          temp = false;                  //���򷵻�false,�û��������벻ƥ��
	       rs.close();
	       prepStmt.close();
	    }catch(Exception e){
	       e.printStackTrace();
	    }
	    return temp;                         //������֤���
	}
	//�����û��������ݿ��л�ȡ�û���ע����Ϣ
	public static Volunteer getVolunteer(Connection con, String sno){
		PreparedStatement prepStmt = null;
	    ResultSet rs = null;                 //�����¼����
	    Volunteer infoitem = null;
	    String queryString = "select sno,sname,ssex,sgrade,dno," +
	    		                    "vtime,permission from volunteer where sno=?";
	    try{
	       prepStmt = con.prepareStatement(queryString);
	       prepStmt.setString(1, sno);
	       rs = prepStmt.executeQuery();     //��ѯ���ݿⲢ���ؽ����¼����
	       if(rs.next()) {                   //���ݿ��ﺬ�д��û�����������򷵻�InfoItem����
	    	   infoitem = new Volunteer(rs.getString("sno"),
	    			                    rs.getString("password"),
	    			                   rs.getString("sname"),
	    			                   rs.getString("ssex"),
	    			                   rs.getString("sgrade"),
	    			                   rs.getString("dno"),
	    			                   rs.getInt("vtime"),
	    			                   rs.getString("permission")
	    			                   );
	       } else {                         //���򷵻�null
	           infoitem = null;
	       }
	       rs.close();
	       prepStmt.close();
	    }catch(Exception e){
	       e.printStackTrace();
	    }
	    return infoitem;       
	}
	//�����ݿ�������û�ע����Ϣ
	public static boolean addVolunteer(Connection con, String sno, 
			                   String sname, String password,
			                   String ssex, String sgrade, 
			                   String dno, int vtime, String permission){
		PreparedStatement prepStmt = null;
		String insertString = 
			   "insert into volunteer(sno,sname,password,ssex,sgrade," +
		                          "dno,vtime,permission)values(?,?,?,?,?,?,?,?)";
		try{
		    prepStmt = con.prepareStatement(insertString);
		    prepStmt.setString(1, sno);
		    prepStmt.setString(2, sname);
		    prepStmt.setString(3, password);
		    prepStmt.setString(4, ssex);
		    prepStmt.setString(5, sgrade);
		    prepStmt.setString(6, dno);
		    prepStmt.setInt(7, vtime);
		    prepStmt.setString(8, permission);
		    prepStmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	//�ж������Ĳ����Ƿ���nullֵ�����ǿ��ַ���
	public static boolean hasValue(String str){
		return (str!=null)&&(!str.equals(""));
	}
}