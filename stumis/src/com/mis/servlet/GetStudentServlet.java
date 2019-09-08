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
 * 主页面进去，点击进行删除和修改
 */
public class GetStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetStudentServlet() {
		super();
	}
	// 执行stulist.jsp传入的数据进行分页跳转，插入输入，查询数据，flag=3 分页跳转 flag=2插入 flag=1查询，flag=0
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("tets");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		ServletContext ctx = this.getServletContext();
		String server = ctx.getInitParameter("server");
		String dbname = ctx.getInitParameter("dbname");
		String user = ctx.getInitParameter("user");
		String pwd = ctx.getInitParameter("pwd");
		BookDao dao = new BookDao();
		String parameter = null;
		int flag=0;
		int page=0;//用户请求也，响应后即为当前页
		try{
			//获得标志位：flag=3 分页跳转   flag=2插入      flag=1查询，flag=0
			flag = Integer.parseInt(request.getParameter("flag"));
		}catch(Exception e){
			flag=0;
		}
		if (flag > 0) {
			if (flag == 3) {// 分页跳转页面
				try {
					try{
					page = Integer.parseInt(request.getParameter("page"));
					}catch(Exception e){
						page=0;
					}
					if(page<=0)page=0;
					String parame = request.getParameter("parame");
					int f=0;
					if(parame!=""&&parame!=null){f=1;}
					//获得连接
					dao.getConn(server, dbname, user, pwd);
					ArrayList<Book> books = dao.getStudent(f, parame, page);
					request.setAttribute("stuCount", dao.getStudentCount(f,parame));
					request.setAttribute("condition", parame);
					request.setAttribute("currentPage",page==0?1:page);
					request.setAttribute("books", books);
					request.getRequestDispatcher("stulist.jsp").forward(request, response);
					return;
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				parameter = "";
				//ISBN编号
				String stuid = request.getParameter("stuid");
				//书名
				String stuname = request.getParameter("stuname");
				//作者
				String stusex = request.getParameter("stusex");
				//价格
				String stuage = request.getParameter("stuage");
				//出版社
				String stumajor = request.getParameter("stumajor");
				
				if (flag == 2 && (!stuid.equals("学号"))) {
					String sql = "Insert into book(isbn,bookName,author,price,publishPress) values ('" + stuid + "','" + stuname
							+ "','" + stusex + "','" + stuage + "','" + stumajor + "');";
					try {
						flag = 0;
						dao.getConn(server, dbname, user, pwd);
						dao.addDelUp(sql);
						dao.getConn(server, dbname, user, pwd);
						ArrayList<Book> books = dao.getStudent(0, null,0);
						request.setAttribute("stuCount", dao.getStudentCount(0,null));
						request.setAttribute("books", books);
						request.setAttribute("currentPage",page==0?1:page);
						request.getRequestDispatcher("stulist.jsp").forward(request, response);
						return;
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else if (flag == 1) {
					//查询功能实现
					if (!stuid.equals("ISBN编码"))
						parameter += "isbn='" + stuid + "'";
					if (!stuname.equals("书名"))
						parameter += (parameter == "" ? "bookName='" + stuname + "'" : " and bookName='" + stuname + "'");
					if (!stusex.equals("作者"))
						parameter += (parameter == "" ? "author='" + stusex + "'" : " and author='" + stusex + "'");
					if (!stuage.equals("价格"))
						parameter += (parameter == "" ? "price='" + stuage + "'" : " and price='" + stuage + "'");
					if (!stumajor.equals("出版社"))
						parameter += (parameter == "" ? "publishPress='" + stumajor + "'" : " and publishPress='" + stumajor + "'");
					if (parameter == "") {
						flag = 0;
					}
					try {
						dao.getConn(server, dbname, user, pwd);
						if(request.getParameter("page")!=null){
							page=Integer.parseInt(request.getParameter("page"));
						}
						ArrayList<Book> books = dao.getStudent(flag, parameter,page);
						request.setAttribute("stuCount", dao.getStudentCount(flag,parameter));
						request.setAttribute("condition", parameter);
						request.setAttribute("currentPage",page==0?1:page);
						request.setAttribute("books", books);
						request.getRequestDispatcher("stulist.jsp").forward(request, response);
						return;
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}

		}
		try {
			dao.getConn(server, dbname, user, pwd);
			ArrayList<Book> books = dao.getStudent(0, null,0);
			//多少条记录
			request.setAttribute("stubooksCount", dao.getStudentCount(0,null));
			request.setAttribute("books", books);
			
			request.setAttribute("currentPage",page==0?1:page);
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
