package com.model;
import java.util.*;

public class Volunteer 
{
	private String sno = null;            //学号
	private String sname = null;          //姓名
	private String ssex = null;        //性别
	private String sgrade = null;        //年级
	private String dno = null;        //学院
	private int    vtime = 0;        //服务时间
	private String permission = null;        //权限
	private Vector activities = null;
	private String password = null;

	public Volunteer(String sno, String password,String sname, String ssex,String sgrade,String dno,int vtime,String permission)
	{
		this.sno = sno;
		this.password = password;
		this.sname = sname;
		this.ssex = ssex;
		this.sgrade = sgrade;
		this.dno = dno;
		this.vtime = vtime;
		this.permission = permission;
	}
	
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getPassword()
	{
		return this.password;
	}
	
	
	public void setSno(String sno)
	{
		this.sno = sno;
	}
	public String getSno()
	{
		return this.sno;
	}
	
	public void setSname(String sname)
	{
		this.sname = sname;
	}
	public String getSname()
	{
		return this.sname;
	}
	
	public void setSsex(String ssex)
	{
		this.ssex = ssex;
	}
	public String getSsex()
	{
		return this.ssex;
	}
	
	public void setSgrade(String sgrade)
	{
		this.sgrade = sgrade;
	}
	public String getSgrade()
	{
		return this.sgrade;
	}
	
	public void setDno(String dno)
	{
		this.dno = dno;
	}
	public String getDno()
	{
		return this.dno;
	}
	
	public void setVtime(int vtime)
	{
		this.vtime = vtime;
	}
	public int getVtime()
	{
		return this.vtime;
	}
	
	public void setPermission(String permission)
	{
		this.permission = permission;
	}
	public String getPermission()
	{
		return this.permission;
	}
	
	public void setActivities(Vector activities)
	{
		this.activities = activities;
	}
	public Vector getActivities()
	{
		return this.activities;
	}
}
