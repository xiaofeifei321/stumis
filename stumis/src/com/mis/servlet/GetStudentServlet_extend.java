package com.mis.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mis.bean.Book;
import com.mis.dao.BookDao;
/**
 * 获取全部数据
 * @author root
 */
public class GetStudentServlet_extend extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetStudentServlet_extend() {
		super();
	}

	// 执行stulist.jsp传入的数据进行删除和修改数据，flag=1 删除 flag=2修改
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		ServletContext ctx = this.getServletContext();
		String server = ctx.getInitParameter("server");
		String dbname = ctx.getInitParameter("dbname");
		String user = ctx.getInitParameter("user");
		String pwd = ctx.getInitParameter("pwd");
		BookDao dao = new BookDao();
		String sql = null;
		int flag = 0;
		try {
			flag = Integer.parseInt(request.getParameter("flag_delUp"));
		} catch (Exception e) {
			flag = 0;
		}
		String stuid = request.getParameter("ud");
		String stuname = request.getParameter("ud_bookName");
		String stusex = request.getParameter("ud_author");
		String stuage = request.getParameter("ud_price");
		String stumajor = request.getParameter("ud_publishPress");
		String del_stuid = request.getParameter("parameter_del");
		if (flag == 1) {// 执行删除
			try {
				flag = 0;//初始化
				sql = "Delete from book where id='" + del_stuid + "';";
				dao.getConn(server, dbname, user, pwd);
				dao.addDelUp(sql);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (flag == 2) {// 执行修改
			flag = 0;
			sql = "update book set bookName='" + stuname + "',author='" + stusex + "',price='" + stuage + "',publishPress='"
					+ stumajor + "' where id='" + stuid + "';";
			try {
				dao.getConn(server, dbname, user, pwd);
				dao.addDelUp(sql);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
			dao.getConn(server, dbname, user, pwd);
			ArrayList<Book> students = dao.getStudent(0, null, 0);
			request.setAttribute("stuCount", dao.getStudentCount(0, null));
			request.setAttribute("students", students);
			request.setAttribute("currentPage", 1);//默认用户打开的分页第一页
			request.getRequestDispatcher("stulist.jsp").forward(request, response);
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
