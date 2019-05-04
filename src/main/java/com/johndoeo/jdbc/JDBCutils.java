package com.johndoeo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCutils {
	private static Properties properties = new Properties();
	private static Connection con;
	private static PreparedStatement psta;
	private static ResultSet rs;

	// 构造方法私有化
	private JDBCutils() {
	}

	static {
		try {
			properties.load(JDBCutils.class.getClassLoader()
					.getResourceAsStream("JDBCu-p.properties"));
			String className = properties.getProperty("className");
			Class.forName(className);// 加载驱动
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void getConnection() {
//		con = null;
		try {
			String url = properties.getProperty("url");
			// String url = "jdbc:mysql://localhost:3306/mysql0502";
			String user = properties.getProperty("user");
			// String user = "root";
			String password = properties.getProperty("password");
			// String password = "root";
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
//		return con;
	}

	/**
	 * 执行查询单条信息语句
	 * @param sql 要执行的SQL语句
	 * @param obj sql语句中的参数
	 * @return 返回ResultSet类型参数
	 */
	public static ResultSet executeQuerySql(String sql,Object[] obj){
		getConnection();
		try {
			psta = con.prepareStatement(sql);
			if(obj != null){
				for(int i = 0;i<obj.length;i++){
					psta.setObject(i+1, obj[i]);
				}
			}
			rs = psta.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 * 对数据库执行增删改
	 * @param sql 要执行的sql语句
	 * @param obj sql语句中的参数
	 * @return 返回boolean类型 true正常，false出现异常
	 */
	public static boolean executeUpdateSql(String sql,Object[] obj){
		getConnection();
		int r = 0;
		try {
			psta = con.prepareStatement(sql);
			if(obj != null){
				for(int i = 0;i<obj.length;i++){
					psta.setObject(i+1, obj[i]);
				}
			}
			r = psta.executeUpdate(); //返回操作的行数
		} catch (SQLException e) {
			e.printStackTrace();
//System.out.println("执行新增出错");
			return false;
		}
		return (r==0)?false:true;
	}

	/**
	 * 执行新增返回主键
	 * @param sql
	 * @param obj
	 * @return
	 */
	public static int executeUpdateReturnKeySql(String sql, Object[] obj) {
		getConnection();
		int r = 0;
		int userid = 0;
		try {
			psta = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			if(obj != null){
				for(int i = 0;i<obj.length;i++){
					psta.setObject(i+1, obj[i]);
				}
			}
			r = psta.executeUpdate(); //返回操作的行数
			rs = psta.getGeneratedKeys();
			if(rs.next()){
				userid = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
//System.out.println("执行新增出错");
			return r;
		}
		return userid;
	}

	/**
	 * 查询所有信息
	 * @param sql
	 * @return
	 */
//	public static List<LogMessage> executeAll(String sql){
//		getConnection();
//		List<LogMessage> objs = new ArrayList<LogMessage>();
//		int r = 0;
//		try {
//			psta = con.prepareStatement(sql);
//			rs = psta.executeQuery();
//			while (rs.next()){
//				int id = rs.getInt("id");
//				int userid = rs.getInt("id");
//				String cip = rs.getString("cip");
//				String logintime = rs.getString("logintime");
//				LogMessage logMessage = new LogMessage(id, userid, cip, logintime);
//				objs.add(logMessage);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
////System.out.println("执行新增出错");
//			return objs;
//		}
//		return objs;
//	}

	public static void closeAll() {
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(psta!=null){
			try {
				psta.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


}
