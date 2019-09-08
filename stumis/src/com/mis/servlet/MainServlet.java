package com.mis.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MainServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 将输入转换为中文
		request.setCharacterEncoding("GBK");
		// 设置输出为中文
		response.setContentType("text/html;charset=GBK");
		// 获取输出流
		PrintWriter out = response.getWriter();
		// 获取Session
		HttpSession session = request.getSession();
		// 从Session中提取用户名
		String username = (String) session.getAttribute("username");
		// 从Session中提取用户登录时间
		String logtime = (String) session.getAttribute("logtime");
		// 输出
		out.println("登录名：" + username + "&nbsp;&nbsp;|&nbsp;&nbsp;登录时间："
				+ logtime);
		out.println("欢迎" + username);
	}

}
