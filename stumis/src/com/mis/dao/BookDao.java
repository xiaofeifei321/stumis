package com.mis.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.mis.bean.Book;

public class BookDao extends DBOper {
	// 分页查询的实现
	public ArrayList<Book> getStudent(int flag, String parameter,
			int crrentPage) {// 分页查询
		String sql = "select id,isbn,bookName,author,price,publishPress from book order by id desc";
		if (flag > 0) {
			sql = "select * from book where " + parameter;
		}
		crrentPage = (crrentPage == 0 ? 0 : crrentPage - 1);
		sql += " limit " + crrentPage * 10 + ",10";// 默认每页显示
		ArrayList<Book> students = new ArrayList<Book>();
		ResultSet rs = executeQuery(sql, null);
		try {
			while (rs.next()) {
				Book s = new Book();
				s.setId(rs.getInt("id"));
				s.setIsbn(rs.getString("isbn"));
				s.setBookName(rs.getString("bookName"));
				s.setAuthor(rs.getString("author"));
				s.setPrice(rs.getInt("price"));
				s.setPublishPress(rs.getString("publishPress"));
				students.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students;
	}

	/**
	 * 得到查询的总条数
	 */
	public int getStudentCount(int flag, String parameter) {
		String sql = "select id,isbn,bookName,author,price,publishPress from book";
		if (flag > 0) {
			sql = "select * from book where " + parameter;
		}
		ResultSet rs = executeQuery(sql, null);
		try {
			rs.last();
			return rs.getRow();
			// 得到re最后一行的行号
		} catch (SQLException e) {
			return 0;
		}
	}

	public ArrayList<Book> getStudent(int flag, String parameter) {// 未分页查询
		String sql = "select id,isbn,bookName,author, price,publishPress from book order by id";
		if (flag > 0) {
			sql = "select * from book where " + parameter;
		}
		ArrayList<Book> students = new ArrayList<Book>();
		ResultSet rs = executeQuery(sql, null);
		try {
			while (rs.next()) {
				Book s = new Book();
				s.setId(rs.getInt("id"));
				s.setIsbn(rs.getString("isbn"));
				s.setBookName(rs.getString("bookName"));
				s.setAuthor(rs.getString("author"));
				s.setPrice(rs.getInt("price"));
				s.setPublishPress(rs.getString("publishPress"));
				students.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students;
	}

	public int addDelUp(String sql) {
		int num = 0;
		num = executeUpdate(sql, null);
		if (num != 0)
			return num;
		return 0;
	}
}
