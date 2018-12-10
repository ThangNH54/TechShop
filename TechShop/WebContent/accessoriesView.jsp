<%@page import="com.thang.techshop.model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="tags" uri="tags" %>
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

	<br>
	<div class="wrap">
		<jsp:include page="header.jsp"></jsp:include>
		
		
		<div class="content">
	<div class="section group">
		<div class="cont span_2_of_3">
			<div class="single">
				   <h2><a href="index">Home&nbsp;></a></h2>
				   <div class="clear"></div>	
			   <div class="text-h">
					<p class="left">Danh Sách Các Sản Phẩm</p>
					<p class="right"></p>
					<div class="clear"></div>
			    </div>
			</div>
	<div class="text-h1 top">
	<%int i=0; ArrayList<Product> ds= (ArrayList<Product>)session.getAttribute("product"); int size=ds.size();%>
		<h2><%=size %> Sản Phẩm Trong Danh Mục</h2>
	
	</div>
<p class="left sort">Sắp Xếp Theo Gía:</p>
<div class="drp-dwn">
	<form action="sortProduct">
		<select  name="sortBy" >
			<option value="1" selected="selected">Tăng Dần </option>
			<option value="2">Giảm Dần</option>
		</select>
		<button style="  margin-left:10px;"><input type="submit" value="OK"></button>
	
	</form>
</div>
	 	
	
	<br><br><br><br><br><br><br><br>
<!-- hien thi ds san pham -->
	<!-- hien thi ds san pham -->
	
	<c:forEach var="sp" items="${ product}" varStatus="count">
		<%if(i%4==0){%>
		<div class="section group">
		<%} %>
		<div class="col_1_of_5 span_1_of_5" style="height:200px;">
			<div class="grid-img">
					<a href="details?sp=${sp.iD }"><img src="${sp.link }" alt="" style="witdh:100%;height: 70px;"/></a> 
			</div>
			<p style="white-space: pre;">${sp.name }</p>
			<p>Khuyến Mại : ${sp.khuyenMai }</p>
			
			<button class="left">${sp.giaBan }$ </button>
			<div class="btn right"><a href="details?sp=${sp.iD }">view</a></div>
			<%if(i%4==3||(i==size-1)){ %></div><%} i++; %>
		</div>

	
	</c:forEach>
	
<!-- hien thi ds san pham -->
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