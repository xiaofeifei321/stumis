package com.mis.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBOper {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	/**
	 * 获得数据库连接
	 * 
	 * @param server
	 * @param dbname
	 * @param user
	 * @param pwd
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public Connection getConn(String server, String dbname, String user,
			String pwd) throws ClassNotFoundException, SQLException,
			InstantiationException, IllegalAccessException {
		String DRIVER = "com.mysql.jdbc.Driver";
		String URL = "jdbc:mysql://" + server + ":3306/" + dbname + "?user="
				+ user + "&password=" + pwd
				+ "&useUnicode=true&characterEncoding=utf8";
		Class.forName(DRIVER).newInstance();
		conn = DriverManager.getConnection(URL);
		return conn;
	}

	/**
	 * 关闭所有连接
	 */
	public void closeAll() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 执行查询语句
	 * 
	 * @param preparedSql
	 * @param param
	 * @return
	 */
	public ResultSet executeQuery(String preparedSql, String[] param) {
		try {
			pstmt = conn.prepareStatement(preparedSql);
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					pstmt.setString(i + 1, param[i]);
				}
			}
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 * 执行更新的数据
	 */
	public int executeUpdate(String preparedSql, String[] param) {
		int num = 0;
		try {
			pstmt = conn.prepareStatement(preparedSql);
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					pstmt.setString(i + 1, param[i]);
				}
			}
			num = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

}