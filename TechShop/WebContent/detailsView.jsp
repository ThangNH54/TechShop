<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ProductView</title>

	<jsp:include page="scriptHeader.jsp"></jsp:include>
	<style type="text/css">
	.li
	{
		display:block;
	}
	</style>
</head>
<body>
	<div class="wrap">
		<jsp:include page="header.jsp"></jsp:include>
			
			<div class="content">
	<div class="section group">
		<div class="cont span_2_of_3">
			<div class="single">
		      <h2><a href="index">Home</a></h2>
				<div class="grid-img1">
					<a href="${product.link }"><img src="${product.link }"></a> 
				</div>
				<div class="para">
					<h4>${product.name }</h4>
				<div class="cart-b">
					<button class="left rs">$${product.giaBan }</button>
				    <div class="btn right"><a href="details.html">Add to Cart</a></div>
				    <div class="clear"></div>
				 </div>
				 <h5>Khuyến Mại : ${product.khuyenMai }</h5>
				 <h5 style="margin-top:30px;">${product.soLuong } Sản Phẩm Trong Kho Hàng</h5>
				 <h6 style="margin-top:20px;">${product.moTa1 }</h6>
				 <h6 style="margin-top:20px;margin-bottom:50px;">${product.moTa2 }</h6>
			   	
			   	</div>
			   <div class="clear"></div>	
		   </div>
	   
	    
	</div>
	<div class="rsidebar span_1_of_3">
				<div class="sidebar">
				    <h2>Cart</h2>
				      <p class="left">No Products</p>
				      <button class="right">-</button>
				      <div class="clear"></div>
				      <p class="left">Shipping</p>
				      <button class="right">$32.58</button>
				      <div class="clear"></div>
				      <p class="left">Export</p>
				      <button class="right">$45.23</button>
				      <div class="clear"></div>
				      <p class="left">Import</p>
				      <button class="right">$23.58</button>
				      <div class="clear"></div>
				      <p class="left">Total</p>
				      <button class="right">$100.420</button>
				      <div class="clear"></div>
				     <div class="btn top"><a href="details.html">Add to Cart</a></div>
				</div>
				<div class="clear"></div>
				<div class="sidebar">
				       <h2>Danh Mục Sản Phẩm</h2>
				      <ul class="nav1" >
						   <li><a href="accessories?sp=Laptop">Laptop</a></li></br>
						   <li><a href="accessories?sp=PC">PC</a></li></br>
						   <li><a href="accessories?sp=Mobile">Mobile</a></li></br>
						   <li><a href="accessories?sp=Camera">Camera</a></li></br>
						   <li><a href="">Gamming Gear</a></li>
						</ul>
					</div>
				<div class="clear"></div>
				
	</div>
  </div>	
</div>	
			
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>