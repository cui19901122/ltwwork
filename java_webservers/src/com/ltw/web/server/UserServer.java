package com.ltw.web.server;

import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;

import com.ltw.web.base.impl.BaseServerImpl;

//ʹ��webserviceͳһ�������ݷ��ʽӿ��м��
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class UserServer
{
	public static void main(String[] args)
	{
		System.out.println("UserServer is start........");
		
		//
		Endpoint.publish("http://127.0.0.1:8100/userdataservice/user",new BaseServerImpl());
		
		System.out.println("UserServer �ɹ�����");
	}
}
