package com.ltw.web.client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.ltw.web.base.interfaces.ServerInterface;

public class WebClient
{

	public static void main(String[] args)
	{
		
		try
		{
			//1.构建访问的url
			URL url=new URL("http://127.0.0.1:8100/userdataservice/user");
			
			//2. 构建访问的名称QName("标题路径","服务提供名")
			QName qname=new QName("http://mysql.fdb/wsdl","BaseServerImpl");
			
			//3.创建服务的对象  url
			Service  service  = Service.create(url,qname);
			
			//4.得到服务对象的接口对象
			ServerInterface server=service.getPort(ServerInterface.class);
			
			String result=server.queryTables();
			
			System.out.println("java客户端访问的结果为:"+result);
			
		}
		catch (MalformedURLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
