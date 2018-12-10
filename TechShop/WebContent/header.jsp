<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<div class="header">
		<div class="logo">
				<a href="index.html"><img src="images/logo.png" alt=""  title="logo"/></a>
		</div>
		<div class="nav-right">
			<ul class="nav">
				<li class="active"><a href="index">Home</a></li>
				<li class="login"><a href="loginView">Acount ${sessionScope.account.userName}</a></li>
				<li><a href="contact.html">Contact</a></li>
				<li><a href="service.html">ShoppingCart</a></li>
			</ul>
		</div>
		<div class="clear"></div>
	</div>
	
	
	<div class="menu-bg">
	<ul class="menu">
		<li><a href="accessories?sp=mt">Máy Tính</a>
			<ul>
				<li><a href="accessories?sp=Laptop" >LapTop</a></li>
				<li><a href="accessories?sp=PC">PC</a></li>
			</ul>
		</li>
		
		<li><a href="accessories?sp=Mobile">Điện Thoại</a>
			<ul>
				<li><a href="accessories?sp=Mobile&hangSx=Apple" >Apple</a></li>
				<li><a href="accessories?sp=Mobile&hangSx=Samsung">Samsung</a></li>
				<li><a href="accessories?sp=Mobile&hangSx=Xiaomi">Xiaomi</a></li>
				<li><a href="accessories?sp=Mobile&hangSx=Oppo">Oppo</a></li>
			</ul>
		</li>
		
		
		<li><a href="">Thiết Bị Khác</a>
			<ul>
				<li><a href="accessories?sp=Camera">Camera</a></li>
			</ul>
		</li>
		
	</ul> 
	<div class="search">
	    <form>
	    	<input type="text" value="">
	    	<input type="submit" value="">
	    </form>
	</div>
	<div class="clear"></div>
</div>