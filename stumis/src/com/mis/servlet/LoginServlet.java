package com.mis.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mis.dao.DBOper;
/**
 * 用户登录处理的servlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// 获取表单用户名
		String username = request.getParameter("username");
		// 获取表单用户密码
		String userpass = request.getParameter("password");
          //Servlet启动，会初始化一个ServletContent，被所有的servlet共享
		ServletContext ctx = this.getServletContext();
//		 通过ServletContext获得web.xml中设置的初始化参数
		String server = ctx.getInitParameter("server");// 获取服务器地址
		String dbname = ctx.getInitParameter("dbname");// 获取数据库名
		String user = ctx.getInitParameter("user");// 获取数据库用户名
		String pwd = ctx.getInitParameter("pwd");// 获取数据库密码
		String sql="";
		DBOper db = new DBOper();
		try {
			// 连接数据库
			db.getConn(server,dbname,user,pwd);
			// 查询userdetail表中符合要求的记录
			if(sql=="")
				sql = "SELECT username,userpass FROM user WHERE username=? AND userpass=?";
			// 执行查询，username和userpass放入数组中作为参数
			ResultSet rs = db.executeQuery(sql, new String[] { username,
					userpass });
			// 合法的用户
			if (rs != null && rs.next()) {
				// 获取Session
				HttpSession session = request.getSession();
				// 将用户名保存到Session中
				session.setAttribute("username", username);
				// 获取用户登录时间，并保存到Session中
				SimpleDateFormat dateFormat = new SimpleDateFormat(
						"yyyy-MM-dd hh:mm:ss");
				String logtime = dateFormat.format(new Date());
				session.setAttribute("logtime", logtime);
				response.sendRedirect(request.getContextPath()+"/stulist.jsp?flag=0");
			} else { // 不合法的用户
				out.println("登录失败!");
				out.println("<br><a href='index.html'>重新登录</a>");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void init() throws ServletException {
	}
}