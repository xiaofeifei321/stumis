<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.lang.Math"%>
<%@ page import="com.mis.bean.Book"%>
<%@ page import="com.mis.dao.DBOper"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书管理系统</title>

<script src="js_jquery/stulist.js" charset="UTF-8"></script>
<link rel="stylesheet" href="css/stulist.css">
</head>
<body>
	<c:if test="${username==null }">
		<jsp:forward page="index.html"></jsp:forward>
	</c:if>
	<c:if test="${books==null}">
		<jsp:forward page="getBook"></jsp:forward>
	</c:if>

	<table border="0" align="center" cellspacing="0" class="list_table"
		id="senfe" style='width: 90%'>
		<thead>
			<tr>
				<td colspan='7'>
					<form method="POST" name="form" action="getBook">
						<input type="hidden" name="flag" value="1"> <input
							type="text" name="stuid" value="ISBN编码"
							onclick="if(this.value == 'ISBN编码')this.value ='';"
							onBlur="if(this.value == ' '||this.value == '')this.value ='ISBN编码';">
						<input type="text" name="stuname" value="书名"
							onclick="if(this.value == '书名')this.value ='';"
							onBlur="if(this.value == ' '||this.value == '')this.value ='书名';">
						<input type="text" name="stusex" value="作者"
							onclick="if(this.value == '作者')this.value ='';"
							onBlur="if(this.value == ' '||this.value == '')this.value ='作者';">
						<input type="text" name="stuage" value="价格"
							onclick="if(this.value == '价格')this.value ='';"
							onBlur="if(this.value == ' '||this.value == '')this.value =价格';">
						<input type="text" name="stumajor" value="出版社"
							onclick="if(this.value == '出版社')this.value ='';"
							onBlur="if(this.value == ' '||this.value == '')this.value ='出版社';">
						<input type="radio" name="selAdd" checked onclick="selop()">
						<input type="submit" value="查询" id="selcon"> 
						<input type="radio" name="selAdd" onclick="selop()">
						<input type="submit" disabled value="增加" id="addcon" onclick="setPar()">
					</form>
				</td>
			</tr>
			<tr>
				<th>ISBN编码</th>
				<th>书名</th>
				<th>作者</th>
				<th>价格</th>
				<th>出版社</th>
				<th>删除</th>
				<th>修改</th>
			</tr>
		</thead>
		<tbody>
			<form method="post" name="DelUp" action="getStudent_extend">
				<c:forEach var="Book" items="${books}">
					<tr align="center">
						<td>${Book.isbn}</td>
						<td>${Book.bookName }</td>
						<td>${Book.author }</td>
						<td>${Book.price }</td>
						<td align="left">${Book.publishPress }</td>
						<td><input type="submit" name=${Book.id } value="删除"
							onclick="del(this)"></td>
						<td><input type="button" name=${Book.id } value="修改"
							onclick="updata(this)"></td>
					</tr>
				</c:forEach>
				
					<div id="updateDiv">
					<input type="hidden" name="ud" readOnly  >
					书名：<input type="text" name="ud_bookName">
					作者：<input type="text" name="ud_author">
					价格：<input type="text" name="ud_price">
					出版社：<input type="text" name="ud_publishPress">
					
					<input type="submit" value="更新">
					<span id="cancelUpdate" onclick="cancelupdate()">取消</span>
					</div>
					
				<input type="hidden" name="flag_delUp">
				 <input type="hidden" name="parameter_del">
			</form>
		</tbody>
	</table>
</body>
</html>