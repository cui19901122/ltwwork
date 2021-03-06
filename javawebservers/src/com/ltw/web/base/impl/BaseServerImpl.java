package com.ltw.web.base.impl;

import java.util.List;

import javax.jws.WebService;

import com.ltw.web.base.Base;
import com.ltw.web.base.interfaces.ServerInterface;
import com.ltw.web.tables.ClassUserCount;
import com.ltw.web.tables.Menu;
import com.ltw.web.tables.Role;
import com.ltw.web.tables.TableClassName;
import com.ltw.web.tables.Usersaddres;
import com.ltw.web.tables.UsersexCount;
import com.ltw.web.tables.Userstate;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@WebService(portName = "userdataservice/user", //
		serviceName = "BaseServerImpl", // 服务提供名
		targetNamespace = "http://mysql.fdb/wsdl", // 标题路径
		endpointInterface = "com.ltw.web.base.interfaces.ServerInterface"// 服务接口全路径
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

		// webservice发布的数据应该是各个平台和语言统一能够解析的数据格式:
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

		// webservice发布的数据应该是各个平台和语言统一能够解析的数据格式:
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
			return "登录成功";
		}
		return "登录失败";
	}

	
	/************安卓*********************/
	
	@Override
	public String queryMenuData()
	{
		// TODO Auto-generated method stub
		System.out.println("queryMenuData is start......");

		Base base = new Base();

		List<Menu> lists = base.queryMenuData();

		// alibaba的json
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
		// alibaba的json
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
		// alibaba的json
		String strJson = com.alibaba.fastjson.JSONArray.toJSONString(lists);

		System.out.println("strJson-->" + strJson);

		return strJson;
	}

	@Override
	public String querylistclass()
	{
		// TODO Auto-generated method stub
		System.out.println("querylistclass is start......");

		Base base = new Base();

		List<Menu> lists = base.querylistclass();
		// alibaba的json
		String strJson = com.alibaba.fastjson.JSONArray.toJSONString(lists);

		System.out.println("strJson-->" + strJson);

		return strJson;
	}

	@Override
	public String quaryUsersexcount1()
	{
		// TODO Auto-generated method stub
		System.out.println("quaryUsersexcount1 is start......");

		Base base = new Base();

		List<ClassUserCount> lists = base.quaryUsersexcount1();
		// alibaba的json
		String strJson = com.alibaba.fastjson.JSONArray.toJSONString(lists);

		System.out.println("strJson-->" + strJson);

		return strJson;
	}

	@Override
	public String quaryUsersexcount2()
	{
		// TODO Auto-generated method stub
		System.out.println("quaryUsersexcount2 is start......");

		Base base = new Base();

		List<ClassUserCount> lists = base.quaryUsersexcount2();
		// alibaba的json
		String strJson = com.alibaba.fastjson.JSONArray.toJSONString(lists);

		System.out.println("strJson-->" + strJson);

		return strJson;
	}

	@Override
	public String quaryUsersexcount3()
	{
		// TODO Auto-generated method stub
		System.out.println("quaryUsersexcount3 is start......");

		Base base = new Base();

		List<ClassUserCount> lists = base.quaryUsersexcount3();
		// alibaba的json
		String strJson = com.alibaba.fastjson.JSONArray.toJSONString(lists);

		System.out.println("strJson-->" + strJson);

		return strJson;
	}

	@Override
	public String quaryUsersexcount4()
	{
		// TODO Auto-generated method stub
		System.out.println("quaryUsersexcount4 is start......");

		Base base = new Base();

		List<ClassUserCount> lists = base.quaryUsersexcount4();
		// alibaba的json
		String strJson = com.alibaba.fastjson.JSONArray.toJSONString(lists);

		System.out.println("strJson-->" + strJson);

		return strJson;
	}

	@Override
	public String quaryUsersaddres1()
	{
		// TODO Auto-generated method stub
		System.out.println("quaryUsersaddres1 is start......");

		Base base = new Base();

		List<Usersaddres> lists = base.quaryUsersaddres1();
		// alibaba的json
		String strJson = com.alibaba.fastjson.JSONArray.toJSONString(lists);

		System.out.println("strJson-->" + strJson);

		return strJson;
	}

	@Override
	public String quaryUserstatecount()
	{
		// TODO Auto-generated method stub
		System.out.println("quaryUserstatecount is start......");

		Base base = new Base();

		List<Userstate> lists = base.quaryUserstatecount();
		// alibaba的json
		String strJson = com.alibaba.fastjson.JSONArray.toJSONString(lists);

		System.out.println("strJson-->" + strJson);

		return strJson;
	}

	@Override
	public String quaryUsersaddres2()
	{
		// TODO Auto-generated method stub
		System.out.println("quaryUsersaddres2 is start......");

		Base base = new Base();

		List<Usersaddres> lists = base.quaryUsersaddres2();
		// alibaba的json
		String strJson = com.alibaba.fastjson.JSONArray.toJSONString(lists);

		System.out.println("strJson-->" + strJson);

		return strJson;
	}

	@Override
	public String quaryUsersaddres3()
	{
		// TODO Auto-generated method stub
		System.out.println("quaryUsersaddres3 is start......");

		Base base = new Base();

		List<Usersaddres> lists = base.quaryUsersaddres3();
		// alibaba的json
		String strJson = com.alibaba.fastjson.JSONArray.toJSONString(lists);

		System.out.println("strJson-->" + strJson);

		return strJson;
	}

	@Override
	public String quaryUserstatecount1()
	{
		// TODO Auto-generated method stub
		System.out.println("quaryUserstatecount1 is start......");

		Base base = new Base();

		List<Userstate> lists = base.quaryUserstatecount1();
		// alibaba的json
		String strJson = com.alibaba.fastjson.JSONArray.toJSONString(lists);

		System.out.println("strJson-->" + strJson);

		return strJson;
	}

	@Override
	public String quaryUserstatecount2()
	{
		// TODO Auto-generated method stub
		System.out.println("quaryUserstatecount2 is start......");

		Base base = new Base();

		List<Userstate> lists = base.quaryUserstatecount2();
		// alibaba的json
		String strJson = com.alibaba.fastjson.JSONArray.toJSONString(lists);

		System.out.println("strJson-->" + strJson);

		return strJson;
	}
	
	
	

}
