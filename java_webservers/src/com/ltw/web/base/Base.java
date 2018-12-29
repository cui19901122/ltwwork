package com.ltw.web.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ltw.file.FilePropertiesUtils;
import com.ltw.web.tables.ClassUserCount;
import com.ltw.web.tables.Menu;
import com.ltw.web.tables.Role;
import com.ltw.web.tables.TableClassName;
import com.ltw.web.tables.UsersexCount;

public class Base
{
	private Connection conn;
	
	static String  urlimg="";
	
	static
	{
		urlimg=FilePropertiesUtils.getImageUtilPath();
	}
	
	public Base()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/fdb", "root", "123456");
		
			System.out.println("conn-------->"+conn);
		}
		catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//查询表中数据方法
	public List queryTables()
	{
		System.out.println("Base is queryTables start.....");
		
		String sql="select * from t_role";
		
		List<Role> lists=new ArrayList<Role>();
		
		try
		{
			PreparedStatement pstmt=conn.prepareStatement(sql);
			
			ResultSet rs=pstmt.executeQuery();
			
			//遍历
			while(rs.next())
			{
				Role  role  = new Role();
				
				role.setRid(rs.getInt(1));
				
				role.setRname(rs.getString(2));
				
				lists.add(role);
			}
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(null!=conn)
			{
				try
				{
					conn.close();
				}
				catch (SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return lists;
	}
	
	
	//查询表中班级的男女数量
	public List querySex(String Classname)
	{
		System.out.println("Base is querySex start.....");
		
		String sql="SELECT COUNT(*),ssex  FROM t_stus RIGHT JOIN t_class ON t_stus.cid= t_class.cid  WHERE cname=? GROUP BY ssex";
		
		List<TableClassName> lists=new ArrayList<TableClassName>();
		
		try
		{
			PreparedStatement pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1,Classname);
			
			ResultSet rs=pstmt.executeQuery();

			//遍历
			while(rs.next())
			{
				TableClassName tcn=new TableClassName();
				
				tcn.setCount(rs.getInt(1));
				
				tcn.setSsex(rs.getString(2));
				
				lists.add(tcn);
			}
			
			//System.out.println("------->"+lists);
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(null!=conn)
			{
				try
				{
					conn.close();
				}
				catch (SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return lists;
	}
	
	//查询用户登录信息
	public int quaryUserInfoll(String Username,String Userpwd)
	{
		System.out.println("Base is quaryUserInfoll start.....");
		
		String sql="SELECT COUNT(*) FROM t_user WHERE uname=? AND upwd=?";
		
		int count=0;
		try
		{
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,Username);
			
			pstmt.setString(2,Userpwd);
		
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				count= rs.getInt(1);
			}
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
	
	//注册用户
	
	//取表数据
	public List<Menu> queryMenuData()
	{
		System.out.println("Base is queryMenuData start.....");
		
		String sql = "SELECT  * FROM  t_classes";

		List<Menu> listMenu = new ArrayList<Menu>();

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Menu menu = new Menu();
				menu.setCid(rs.getInt(1));
				menu.setCname(rs.getString(2));
				menu.setCurl(rs.getString(3));
				menu.setCimg(urlimg+rs.getString(4));
				listMenu.add(menu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (null != conn) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return  listMenu;

	}
	
	//报表方法
	//班级人数比例（饼图）
	public List quaryUsercount()
	{
		System.out.println("Base is quaryUsercount start.....");
		
		String sql="SELECT c.cname,COUNT(c.cname) FROM t_stu1 s INNER JOIN t_classes c ON s.scid=c.cid GROUP BY c.cname";
		
		List<ClassUserCount> cucdata=new ArrayList<ClassUserCount>();
		
		try
		{
			PreparedStatement  pstmt = conn.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				ClassUserCount cuc=new ClassUserCount();
				
				cuc.setClassname(rs.getString(1));
				
				cuc.setUsercount(rs.getInt(2));
				
				cucdata.add(cuc);
			}
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cucdata;
	}
	
	//java班级男女比例(柱状图)
	public List quaryUsersexcount()
	{
		System.out.println("Base is quaryUsersexcount start.....");
		
		String sql="SELECT s.ssex,COUNT(s.ssex) FROM t_stu1 s INNER JOIN t_classes c ON s.scid=c.cid WHERE cname='Java班' GROUP BY s.ssex";
		
		List<UsersexCount> cucdata=new ArrayList<UsersexCount>();
		
		try
		{
			PreparedStatement  pstmt = conn.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				UsersexCount cuc=new UsersexCount();
				
				cuc.setUsersex(rs.getString(1));
				
				cuc.setUsersexcount(rs.getInt(2));
				
				cucdata.add(cuc);
			}
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cucdata;
	}
	
	
}
