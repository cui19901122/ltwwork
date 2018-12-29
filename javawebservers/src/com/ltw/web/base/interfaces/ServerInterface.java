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
}
