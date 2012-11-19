package com.model;
import java.util.*;

public class Activity 
{
	private String ano = null;
	private String aname = null;
	private String adate = null;
	private int atime = 0;
	
	public Activity(String ano,String aname,String adate,int atime)
	{
		this.ano = ano;
		this.aname = aname;
		this.adate = adate;
		this.atime = atime;
	}
	
	public void setAno(String ano)
	{
		this.ano = ano;
	}
	public String getAno()
	{
		return this.ano;
	}
	
	public void setAname(String aname)
	{
		this.aname = aname;
	}
	public String getAname()
	{
		return this.aname;
	}
	
	public void setAdate(String adate)
	{
		this.adate = adate;
	}
	public String getAdate()
	{
		return this.adate;
	}
	
	public void setAtime(int atime)
	{
		this.atime = atime;
	}
	public int getAtime()
	{
		return this.atime;
	}
	

}
 
