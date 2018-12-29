package com.ltw.web.tables;

public class Menu
{

	public int getCid()
	{
		return cid;
	}

	public void setCid(int cid)
	{
		this.cid = cid;
	}

	public String getCname()
	{
		return cname;
	}

	public void setCname(String cname)
	{
		this.cname = cname;
	}

	public String getCurl()
	{
		return curl;
	}

	public void setCurl(String curl)
	{
		this.curl = curl;
	}

	public String getCimg()
	{
		return cimg;
	}

	public void setCimg(String cimg)
	{
		this.cimg = cimg;
	}

	private int cid;
	
	private String cname;
	
	private String curl;
	
	private String cimg;
}
