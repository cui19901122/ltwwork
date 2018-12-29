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
			//1.�������ʵ�url
			URL url=new URL("http://127.0.0.1:8100/userdataservice/user");
			
			//2. �������ʵ�����QName("����·��","�����ṩ��")
			QName qname=new QName("http://mysql.fdb/wsdl","BaseServerImpl");
			
			//3.��������Ķ���  url
			Service  service  = Service.create(url,qname);
			
			//4.�õ��������Ľӿڶ���
			ServerInterface server=service.getPort(ServerInterface.class);
			
			String result=server.queryTables();
			
			System.out.println("java�ͻ��˷��ʵĽ��Ϊ:"+result);
			
		}
		catch (MalformedURLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
