package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.model.Volunteer;

public class DBUtility {
    //判断用户名、密码是否正确
	public static boolean isValid(Connection con, String sno, String password){
	    PreparedStatement prepStmt = null;
	    ResultSet rs = null;                //存储查询结果
	    String selectStatement = "select sno from volunteer" +
	                                " where sno=? and password=?";
	    boolean temp = false;
	    try{
	       prepStmt = con.prepareStatement(selectStatement);
	       prepStmt.setString(1, sno);
	       prepStmt.setString(2, password);
	       rs = prepStmt.executeQuery();     //查询数据库并返回结果记录集
	       if (rs.next())                    //数据库里含有此用户名、密码对则返回true
	          temp = true;
	       else
	          temp = false;                  //否则返回false,用户名、密码不匹配
	       rs.close();
	       prepStmt.close();
	    }catch(Exception e){
	       e.printStackTrace();
	    }
	    return temp;                         //返回验证结果
	}
	//根据用户名从数据库中获取用户的注册信息
	public static Volunteer getVolunteer(Connection con, String sno){
		PreparedStatement prepStmt = null;
	    ResultSet rs = null;                 //结果记录集合
	    Volunteer infoitem = null;
	    String queryString = "select sno,sname,ssex,sgrade,dno," +
	    		                    "vtime,permission from volunteer where sno=?";
	    try{
	       prepStmt = con.prepareStatement(queryString);
	       prepStmt.setString(1, sno);
	       rs = prepStmt.executeQuery();     //查询数据库并返回结果记录集合
	       if(rs.next()) {                   //数据库里含有此用户名、密码对则返回InfoItem对象
	    	   infoitem = new Volunteer(rs.getString("sno"),
	    			                    rs.getString("password"),
	    			                   rs.getString("sname"),
	    			                   rs.getString("ssex"),
	    			                   rs.getString("sgrade"),
	    			                   rs.getString("dno"),
	    			                   rs.getInt("vtime"),
	    			                   rs.getString("permission")
	    			                   );
	       } else {                         //否则返回null
	           infoitem = null;
	       }
	       rs.close();
	       prepStmt.close();
	    }catch(Exception e){
	       e.printStackTrace();
	    }
	    return infoitem;       
	}
	//往数据库中添加用户注册信息
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
	//判断所给的参数是否是null值或者是空字符串
	public static boolean hasValue(String str){
		return (str!=null)&&(!str.equals(""));
	}
}