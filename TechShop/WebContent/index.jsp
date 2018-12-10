<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>

	<jsp:include page="scriptHeader.jsp"></jsp:include>
</head>
<body>
	<div class="wrap">
		<jsp:include page="header.jsp"></jsp:include>
		
<div class="flexslider">
   	<div class="flex-viewport" style="overflow: hidden; position: relative;">
   		<ul class="slides" style="width: 100%; -webkit-transition: 0.6s; transition: 0.6s; -webkit-transform: translate3d(-5032px, 0, 0);">
   			<li class="clone" style="width: 100%; float: left; display: block;">
        		<img src="images/slider1.jpg" alt=""/>
    		</li>
       		<li style="width: 100%; float: left; display: block;" class="">
    	    	<img src="images/slider2.jpg" alt=""/>
    		</li>
    		<li class="" style="width:100%; float: left; display: block;">
    	    	<img src="images/slider3.jpg" alt=""/>
    		</li>
		</ul>
	</div>
</div>
<div class="content">
<div class="section group">
	<div class="col_1_of_3 span_1_of_3">
		<div class="grid-imgs">
			<a href="details.html"><img src="images/pic1.jpg" alt=""/></a> 
		</div>
		<h2>Lorem Ipsum is simply dummy text </h2>
		<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna.</p>
	</div>
	<div class="col_1_of_3 span_1_of_3">
		<div class="grid-imgs">
				<a href="details.html"><img src="images/pic2.jpg" alt=""/></a> 
		</div>
		<h2>Lorem Ipsum is simply dummy text </h2>
		<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna.</p>
	</div>
	<div class="col_1_of_3 span_1_of_3">
		<div class="grid-imgs">
				<a href="details.html"><img src="images/pic3.jpg" alt=""/></a> 
		</div>
		<h2>Lorem Ipsum is simply dummy text </h2>
		<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna.</p>
	</div>
</div>
<div class="text-h">
	<h2>Sản Phẩm Nổi Bật</h2>
</div>

		<%
			int i=0; 
			ArrayList ds=(ArrayList)request.getAttribute("productHot");
			int size=ds.size();
		%>
<div class="section group">

	<c:forEach var="sp" items="${ productHot}" varStatus="count">
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
	

	
</div>
</div>
	<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>