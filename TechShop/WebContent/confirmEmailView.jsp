<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<title>ConfirmEmail</title>
	<jsp:include page="scriptHeader.jsp"></jsp:include>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/iconic/css/material-design-iconic-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->


</head>
<body>


<script type="text/javascript">

	function checkCode(){
		
		var code="${sessionScope.code}";
		var codeInput=document.getElementById("code-input").value;

		if(code==codeInput)
		{
			return true;
		}
		
		else
		{
			window.alert("Mã Xác Thực Không Đúng.")
			return false;
		}
		
		
	}
</script>

<div class="wrap">

	<jsp:include page="header.jsp"></jsp:include>
	
	
	
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-t-85 p-b-20">
			
				<form  method="post" class="login100-form validate-form" action="${sessionScope.action }" onsubmit="return checkCode()" >
				<div style="text-align:center;"><p style="padding-bottom:50px;">verification code has been sent to email :${sessionScope.email }</p></div>
					<span class="login100-form-title p-b-70">
									Enter Code :
					</span>
					
					<div style="text-align:center;"><p>${requestScope.msg}</p></div>
		
					
					<div class="wrap-input100 validate-input m-t-85 m-b-35" >
						<input class="input100" type="text" name="code" id="code-input" required="required">
						<span class="focus-input100" data-placeholder="Code"></span>
					</div>
					<c:set var="checkEmail" scope="session" value="true"></c:set>
					<div class="container-login100-form-btn">
						<button class="login100-form-btn">
						<input type="submit" name="submit" value="">Ok
						</button>
					</div>

				</form>
				
			</div>
		</div>
	</div>
	
<div style="padding-bottom:150;"></div>
	<div id="dropDownSelect1"></div>
	
<!--===============================================================================================-->
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/daterangepicker/moment.min.js"></script>
	<script src="vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="js/main.js"></script>
<jsp:include page="footer.jsp"></jsp:include>
</div>
</body>
</html>