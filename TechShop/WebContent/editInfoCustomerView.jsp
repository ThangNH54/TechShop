<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<title>Edit Info</title>
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
<style type="text/css">
.upload-btn-wrapper {
  position: relative;
  overflow: hidden;
  display: inline-block;
}

.btn {
  width: 100px;
  height: 40px;
  border: 2px solid gray;
  color: gray;
  background-color: white;
  padding: 8px 20px;
  border-radius: 8px;
  font-size: 12px;
  font-weight: bold;

}

.upload-btn-wrapper input[type=file] {
  font-size: 100px;
  position: absolute;
  left: 0;
  top: 0;
  opacity: 0;
}
</style>
</head>
<body>
<div class="wrap">
	<jsp:include page="header.jsp"></jsp:include>
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-t-85 p-b-20" >
					<span style="text-align:center;margin-bottom:50px;">
						<h2 style="text-align:center;margin-bottom:50px;">Chỉnh Sửa Thông Tin</h2>
					</span>
					
					
					<span class="login100-form-avatar" style="">
						<img src="${sessionScope.account.urlAvatar }" alt="AVATAR" style="min-width:100%;min-height:100%;">
					</span>
					<div style="background-color:white;margin-top:30px; text-align:center; ">
						<form action="uploadFile" method="post" enctype="multipart/form-data">
							<c:set var="view" scope="session" value="uploadAvatar"></c:set>
							<c:set var="idFile" scope="session" value="${sessionScope.account.iD }"></c:set>
							
					
							<div class="upload-btn-wrapper">
							  <button class="btn">Chọn</button>
							  <input type="file" name="fileUpload" accept="image/x-png,image/gif,image/jpeg" name="fileUpload" style="height: 40px; width: 100px;" required="required">
							  
							  <input type="submit" value="Upload" style="margin-left:20px;height:40px;width:100px;background-color:#57b846; border-radius: 8px;color:White;">
							</div>
							
						</form>
					</div>
					
				
				<div class="msg" style="padding-top:40px;;text-align:center;"><span>${requestScope.msg}</span></div><!-- msg thong bao  -->
				<c:remove var="msg" scope="request"/>
				
				
				<form action="editInfoCustomer" method="post" class="login100-form validate-form">
					
					
					<div class="wrap-input100 validate-input m-t-85 m-b-35">
						<span style="margin-left:5px;font-size:18px;">UserName (not edit)</span>
						<input class="input100" type="text" name="userName" value="${sessionScope.account.userName }" readonly>
					</div>
					
					<div class="wrap-input100 validate-input m-b-50" data-validate="Enter Email">
						<span style="margin-left:5px;font-size:18px;">Email (not edit)</span>
						<input class="input100" type="text" name="email" value="${sessionScope.account.email }" readonly>
					</div>
					
					
					<div class="wrap-input100 validate-input m-b-50" data-validate="Enter firstName">
						<span style="margin-left:5px;font-size:18px;">FirstName</span>
						<input class="input100" type="text" name="firstName" value="${sessionScope.account.firstName }">
					</div>
					
					<div class="wrap-input100 validate-input m-b-50" data-validate="Enter lastName">
						<span style="margin-left:5px;font-size:18px;">LastName</span>
						<input class="input100" type="text" name="lastName" value="${sessionScope.account.lastName }">
					</div>
					
					<div class="wrap-input100 validate-input m-b-50" data-validate="Enter sex">
						<span style="margin-left:5px;font-size:18px;">Sex</span>
						<input class="input100" type="text" name="sex" value="${sessionScope.account.sex }">
					</div>
					
					<div class="wrap-input100 validate-input m-b-50" data-validate="Enter addr">
						<span style="margin-left:5px;font-size:18px;">Addr</span>
						<input class="input100" type="text" name="addr" value="${sessionScope.account.addr }">
					</div>
					
					<div class="wrap-input100 validate-input m-b-50" data-validate="Enter phone Number">
						<span style="margin-left:5px;font-size:18px;">Phone Number</span>
						<input class="input100" type="number" name="phoneNumber" value="${sessionScope.account.phone }">
					</div>
					
					<div class="wrap-input100 validate-input m-b-50" data-validate="Enter Password">
						<span style="margin-left:5px;font-size:18px;">Password</span>
						<input class="input100" type="password" name="password" value="${sessionScope.account.password }">
					</div>
					
					<div class="wrap-input100 validate-input m-b-50" data-validate="Enter Confirm Password">
						<span style="margin-left:5px;font-size:18px;">Confirm Password</span>
						<input class="input100" type="password" name="confirmPassword" value="${sessionScope.account.password }">
					</div>
					
					<div class="container-login100-form-btn">
						<button class="login100-form-btn">
						<input type="submit" name="submit" value="">Submit
						</button>
					</div>

				</form>
			</div>
		</div>
	</div>
	

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