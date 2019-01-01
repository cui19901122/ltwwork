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
import com.ltw.web.tables.Usersaddres;
import com.ltw.web.tables.UsersexCount;
import com.ltw.web.tables.Userstate;

public class Base
{
	private Connection conn;

	static String urlimg = "";

	static
	{
		urlimg = FilePropertiesUtils.getImageUtilPath();
	}

	public Base()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/fdb", "root", "123456");

			System.out.println("conn-------->" + conn);
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

	// 查询表中数据方法
	public List queryTables()
	{
		System.out.println("Base is queryTables start.....");

		String sql = "select * from t_role";

		List<Role> lists = new ArrayList<Role>();

		try
		{
			PreparedStatement pstmt = conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();

			// 遍历
			while (rs.next())
			{
				Role role = new Role();

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
			if (null != conn)
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

	// 查询表中班级的男女数量
	public List querySex(String Classname)
	{
		System.out.println("Base is querySex start.....");

		String sql = "SELECT COUNT(*),ssex  FROM t_stus RIGHT JOIN t_class ON t_stus.cid= t_class.cid  WHERE cname=? GROUP BY ssex";

		List<TableClassName> lists = new ArrayList<TableClassName>();

		try
		{
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, Classname);

			ResultSet rs = pstmt.executeQuery();

			// 遍历
			while (rs.next())
			{
				TableClassName tcn = new TableClassName();

				tcn.setCount(rs.getInt(1));

				tcn.setSsex(rs.getString(2));

				lists.add(tcn);
			}

			// System.out.println("------->"+lists);
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if (null != conn)
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

	/**************
	 * 安卓*********************?/
	 * 
	 * @param Username
	 * @param Userpwd
	 * @return
	 */

	// 查询用户登录信息
	public int quaryUserInfoll(String Username, String Userpwd)
	{
		System.out.println("Base is quaryUserInfoll start.....");

		String sql = "SELECT COUNT(*) FROM t_user WHERE uname=? AND upwd=?";

		int count = 0;
		try
		{
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, Username);

			pstmt.setString(2, Userpwd);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next())
			{
				count = rs.getInt(1);
			}
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return count;
	}

	// 注册用户

	// 取表数据 首页
	public List<Menu> queryMenuData()
	{
		System.out.println("Base is queryMenuData start.....");

		String sql = "SELECT * FROM t_indexlist";

		List<Menu> listMenu = new ArrayList<Menu>();

		try
		{
			PreparedStatement pstmt = conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next())
			{
				Menu menu = new Menu();
				menu.setLid(rs.getInt(1));
				menu.setLname(rs.getString(2));
				menu.setLurl(rs.getString(3));
				menu.setLimg(urlimg + rs.getString(4));
				listMenu.add(menu);
			}
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if (null != conn)
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

		return listMenu;

	}

	// 取表数据 编程语言分类
	public List<Menu> querylistclass()
	{
		System.out.println("Base is queryMenuData start.....");

		String sql = "SELECT * FROM t_listclass";

		List<Menu> listMenu = new ArrayList<Menu>();

		try
		{
			PreparedStatement pstmt = conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next())
			{
				Menu menu1 = new Menu();
				menu1.setLid(rs.getInt(1));
				menu1.setLname(rs.getString(2));
				listMenu.add(menu1);
			}
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if (null != conn)
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

		return listMenu;

	}

	// 报表方法
	// 班级人数比例（饼图）
	public List quaryUsercount()
	{
		System.out.println("Base is quaryUsercount start.....");

		String sql = "SELECT c.cname,COUNT(c.cname) FROM t_stu1 s INNER JOIN t_classes c ON s.scid=c.cid GROUP BY c.cname";

		List<ClassUserCount> cucdata = new ArrayList<ClassUserCount>();

		try
		{
			PreparedStatement pstmt = conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next())
			{
				ClassUserCount cuc = new ClassUserCount();

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

	// 男女比例
	public List quaryUsersexcount()
	{
		System.out.println("Base is quaryUsersexcount start.....");

		String sql = "SELECT ssex,COUNT(*) FROM t_stu1 GROUP BY ssex";

		List<UsersexCount> cucdata = new ArrayList<UsersexCount>();

		try
		{
			PreparedStatement pstmt = conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next())
			{
				UsersexCount cuc = new UsersexCount();

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

	// java班级男女比例(柱状图)
	public List quaryUsersexcount1()
	{
		System.out.println("Base is quaryUsersexcount1 start.....");

		String sql = "SELECT s.ssex,COUNT(s.ssex) FROM t_stu1 s INNER JOIN t_classes c ON s.scid=c.cid WHERE cname='Java班' GROUP BY s.ssex";

		List<UsersexCount> cucdata = new ArrayList<UsersexCount>();

		try
		{
			PreparedStatement pstmt = conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next())
			{
				UsersexCount cuc1 = new UsersexCount();

				cuc1.setUsersex(rs.getString(1));

				cuc1.setUsersexcount(rs.getInt(2));

				cucdata.add(cuc1);
			}
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cucdata;
	}

	// Phtyon班级男女比例(柱状图)
	public List quaryUsersexcount2()
	{
		System.out.println("Base is quaryUsersexcount2 start.....");

		String sql = "SELECT s.ssex,COUNT(s.ssex) FROM t_stu1 s INNER JOIN t_classes c ON s.scid=c.cid WHERE cname='Phtyon班' GROUP BY s.ssex";

		List<UsersexCount> cucdata = new ArrayList<UsersexCount>();

		try
		{
			PreparedStatement pstmt = conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next())
			{
				UsersexCount cuc2 = new UsersexCount();

				cuc2.setUsersex(rs.getString(1));

				cuc2.setUsersexcount(rs.getInt(2));

				cucdata.add(cuc2);
			}
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cucdata;
	}

	// Php班级男女比例(柱状图)
	public List quaryUsersexcount3()
	{
		System.out.println("Base is quaryUsersexcount3 start.....");

		String sql = "SELECT s.ssex,COUNT(s.ssex) FROM t_stu1 s INNER JOIN t_classes c ON s.scid=c.cid WHERE cname='Php班' GROUP BY s.ssex";

		List<UsersexCount> cucdata = new ArrayList<UsersexCount>();

		try
		{
			PreparedStatement pstmt = conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next())
			{
				UsersexCount cuc3 = new UsersexCount();

				cuc3.setUsersex(rs.getString(1));

				cuc3.setUsersexcount(rs.getInt(2));

				cucdata.add(cuc3);
			}
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cucdata;
	}

	// JS班级男女比例(柱状图)
	public List quaryUsersexcount4()
	{
		System.out.println("Base is quaryUsersexcount4 start.....");

		String sql = "SELECT s.ssex,COUNT(s.ssex) FROM t_stu1 s INNER JOIN t_classes c ON s.scid=c.cid WHERE cname='JS班' GROUP BY s.ssex";

		List<UsersexCount> cucdata = new ArrayList<UsersexCount>();

		try
		{
			PreparedStatement pstmt = conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next())
			{
				UsersexCount cuc4 = new UsersexCount();

				cuc4.setUsersex(rs.getString(1));

				cuc4.setUsersexcount(rs.getInt(2));

				cucdata.add(cuc4);
			}
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cucdata;
	}

	// 江苏省份的人数占总人数的比例（饼图）
	public List quaryUsersaddres1()
	{
		System.out.println("Base is quaryUsersaddres1 start.....");

		String sql = "SELECT FORMAT(COUNT(*)/(SELECT COUNT(*) FROM t_stu1) ,2)FROM t_stu1 WHERE saddress LIKE '江苏%'";

		List<Usersaddres> usdata = new ArrayList<Usersaddres>();

		try
		{
			PreparedStatement pstmt = conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next())
			{
				Usersaddres us1 = new Usersaddres();

				us1.setUseraddress(rs.getString(2));

				us1.setUseraddrescount(rs.getInt(1));

				usdata.add(us1);
			}
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return usdata;
	}

	
	// 学员身份占比（饼图）
		public List quaryUserstatecount()
		{
			System.out.println("Base is quaryUserstatecount start.....");

			String sql = "SELECT st.sname,FORMAT(COUNT(st.sname)/(SELECT COUNT(*) FROM t_stu1) ,2) FROM t_stu1 s RIGHT JOIN t_stustate st ON s.state=st.sid GROUP BY st.sname";

			List<Userstate> ussdata = new ArrayList<Userstate>();

			try
			{
				PreparedStatement pstmt = conn.prepareStatement(sql);

				ResultSet rs = pstmt.executeQuery();

				while (rs.next())
				{
					Userstate uss = new Userstate();

					uss.setUserstate(rs.getString(1));

					uss.setUserstatecount(rs.getInt(2));

					ussdata.add(uss);
				}
			}
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return ussdata;
		}
		
		//山东省份的学习人数占总学习人数的比例
		public List quaryUsersaddres2()
		{
			System.out.println("Base is quaryUsersaddres2 start.....");

			String sql = "SELECT FORMAT(COUNT(*)/(SELECT COUNT(*) FROM t_stu1) ,2)FROM t_stu1 WHERE saddress LIKE '山东%'";

			List<Usersaddres> usdata = new ArrayList<Usersaddres>();

			try
			{
				PreparedStatement pstmt = conn.prepareStatement(sql);

				ResultSet rs = pstmt.executeQuery();

				while (rs.next())
				{
					Usersaddres us2 = new Usersaddres();

					us2.setUseraddress(rs.getString(2));

					us2.setUseraddrescount(rs.getInt(1));

					usdata.add(us2);
				}
			}
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return usdata;
		}

		//四川省份的学习人数占总学习人数的比例
		public List quaryUsersaddres3()
		{
			System.out.println("Base is quaryUsersaddres3 start.....");

			String sql = "SELECT FORMAT(COUNT(*)/(SELECT COUNT(*) FROM t_stu1) ,2)FROM t_stu1 WHERE saddress LIKE '四川%'";

			List<Usersaddres> usdata = new ArrayList<Usersaddres>();

			try
			{
				PreparedStatement pstmt = conn.prepareStatement(sql);

				ResultSet rs = pstmt.executeQuery();

				while (rs.next())
				{
					Usersaddres us3 = new Usersaddres();

					us3.setUseraddress(rs.getString(2));

					us3.setUseraddrescount(rs.getInt(1));

					usdata.add(us3);
				}
			}
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return usdata;
		}

		
		//java班的学生身份比例
		public List quaryUserstatecount1()
		{
			System.out.println("Base is quaryUserstatecount1 start.....");

			String sql = "SELECT st.sname,COUNT(s.state) FROM t_stu1 s INNER JOIN t_stustate st ON st.sid=s.state "
					+ "AND s.scid=(SELECT c.cid FROM t_classes c WHERE c.cname='Java班' )GROUP BY s.state ";

			List<Userstate> ussdata = new ArrayList<Userstate>();

			try
			{
				PreparedStatement pstmt = conn.prepareStatement(sql);

				ResultSet rs = pstmt.executeQuery();

				while (rs.next())
				{
					Userstate uss1= new Userstate();

					uss1.setUserstate(rs.getString(1));

					uss1.setUserstatecount(rs.getInt(2));

					ussdata.add(uss1);
				}
			}
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return ussdata;
		}
		
		//Phtyon班的学生身份比例
		public List quaryUserstatecount2()
		{
			System.out.println("Base is quaryUserstatecount2 start.....");

			String sql = "SELECT st.sname,COUNT(s.state) FROM t_stu1 s INNER JOIN t_stustate st ON st.sid=s.state "
					+ "AND s.scid=(SELECT c.cid FROM t_classes c WHERE c.cname='Phtyon班' )GROUP BY s.state ";

			List<Userstate> ussdata = new ArrayList<Userstate>();

			try
			{
				PreparedStatement pstmt = conn.prepareStatement(sql);

				ResultSet rs = pstmt.executeQuery();

				while (rs.next())
				{
					Userstate uss2= new Userstate();

					uss2.setUserstate(rs.getString(1));

					uss2.setUserstatecount(rs.getInt(2));

					ussdata.add(uss2);
				}
			}
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return ussdata;
		}
}
