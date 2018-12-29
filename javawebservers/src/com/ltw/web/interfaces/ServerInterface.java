package com.ltw.web.interfaces;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(targetNamespace="http://mysql.fdb/wsdl")
public interface ServerInterface
{

	@WebMethod
	public String queryTables();
	
	@WebMethod
	public String querySex(String Classname);
	
}
