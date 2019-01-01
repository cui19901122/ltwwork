package com.ltw.web.base.interfaces;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(targetNamespace="http://mysql.fdb/wsdl")
public interface ServerInterface
{

	@WebMethod
	public String queryTables();
	
	@WebMethod
	public String querySex(String Classname);
	
	@WebMethod
	public String quaryUserInfoll(String Username,String Userpwd);
	
	@WebMethod
	public String queryMenuData();
	
	@WebMethod
	public String quaryUsercount();
	
	@WebMethod
	public String quaryUsersexcount();
	
	@WebMethod
	public String querylistclass();
	
	@WebMethod
	public String quaryUsersexcount1();
	
	@WebMethod
	public String quaryUsersexcount2();
	
	@WebMethod
	public String quaryUsersexcount3();
	
	@WebMethod
	public String quaryUsersexcount4();
	
	@WebMethod
	public String quaryUsersaddres1();
	
	@WebMethod
	public String quaryUserstatecount();
	
	@WebMethod
	public String quaryUsersaddres2();
	
	@WebMethod
	public String quaryUsersaddres3();

	@WebMethod
	public String quaryUserstatecount1();
	
	@WebMethod
	public String quaryUserstatecount2();

}
