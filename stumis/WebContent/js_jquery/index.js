function loginClick() {
		//登录用户信息判断
		var user = document.getElementById("username").value;
		//
		var pass = document.getElementById("password").value;
		if (user == null || user == "") {
			alert("请填写用户名");
			document.getElementById("username").focus();
		} else if (pass == null || pass == "") {
			alert("请填写密码");
			document.getElementById("password").focus();
		} else
			document.Regsiter.submit();
	}
	function res() {
		document.getElementById("username").value = "";
		document.getElementById("password").value = "";
	}