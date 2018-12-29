package com.ltw.web.base.impl;

import java.util.List;

import javax.jws.WebService;

import com.ltw.web.base.Base;
import com.ltw.web.base.interfaces.ServerInterface;
import com.ltw.web.tables.ClassUserCount;
import com.ltw.web.tables.Menu;
import com.ltw.web.tables.Role;
import com.ltw.web.tables.TableClassName;
import com.ltw.web.tables.UsersexCount;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@WebService(portName = "userdataservice/user", //
		serviceName = "BaseServerImpl", // �����ṩ��
		targetNamespace = "http://mysql.fdb/wsdl", // ����·��
		endpointInterface = "com.ltw.web.base.interfaces.ServerInterface"// ����ӿ�ȫ·��
)
public class BaseServerImpl implements ServerInterface
{

	@Override
	public String queryTables()
	{
		// TODO Auto-generated method stub

		System.out.println("queryTables is start......");

		Base base = new Base();

		List<Role> lists = base.queryTables();

		System.out.println("---->" + lists.size());

		// webservice����������Ӧ���Ǹ���ƽ̨������ͳһ�ܹ����������ݸ�ʽ:
		JSONArray array = new JSONArray();

		for (Role role : lists)
		{
			JSONObject obj = new JSONObject();

			obj.put("id", role.getRid());

			obj.put("rname", role.getRname());

			array.add(obj);

		}

		System.out.println("JSON-->" + array.toString());

		return array.toString();
	}

	@Override
	public String querySex(String Classname)
	{
		// TODO Auto-generated method stub
		System.out.println("querySex is start......");

		Base base = new Base();

		List<TableClassName> lists = base.querySex(Classname);

		System.out.println("---->" + lists.size());

		// webservice����������Ӧ���Ǹ���ƽ̨������ͳһ�ܹ����������ݸ�ʽ:
		JSONArray arrays= new JSONArray();

		for (TableClassName tcn : lists)
		{
			JSONObject obj = new JSONObject();

			obj.put("ssex", tcn.getSsex());
			
			obj.put("count", tcn.getCount());

			arrays.add(obj);

		}

		System.out.println("JSON-->" + arrays.toString());

		return arrays.toString();
	}

	@Override
	public String quaryUserInfoll(String Username, String Userpwd)
	{
		// TODO Auto-generated method stub
		System.out.println("quaryUserInfoll is start......");
		
		Base base = new Base();
		
		int count=base.quaryUserInfoll(Username, Userpwd);
		
		if(count>0)
		{
			return "��¼�ɹ�";
		}
		return "��¼ʧ��";
	}

	@Override
	public String queryMenuData()
	{
		// TODO Auto-generated method stub
		System.out.println("queryMenuData is start......");

		Base base = new Base();

		List<Menu> lists = base.queryMenuData();

		// alibaba��json
		String strJson = com.alibaba.fastjson.JSONArray.toJSONString(lists);

		System.out.println("strJson-->" + strJson);

		return strJson;
	}

	@Override
	public String quaryUsercount()
	{
		// TODO Auto-generated method stub
		System.out.println("quaryUsercount is start......");

		Base base = new Base();

		List<ClassUserCount> lists = base.quaryUsercount();
		// alibaba��json
		String strJson = com.alibaba.fastjson.JSONArray.toJSONString(lists);

		System.out.println("strJson-->" + strJson);

		return strJson;
	}

	@Override
	public String quaryUsersexcount()
	{
		// TODO Auto-generated method stub
		System.out.println("quaryUsersexcount is start......");

		Base base = new Base();

		List<UsersexCount> lists = base.quaryUsersexcount();
		// alibaba��json
		String strJson = com.alibaba.fastjson.JSONArray.toJSONString(lists);

		System.out.println("strJson-->" + strJson);

		return strJson;
	}
	
	
	

}
