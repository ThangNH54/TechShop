<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="footer">
	<div class="section group" >
		<div class="col_1_of_4 span_1_of_4" style="">
			<h2>Sản Phẩm</h2>
			<ul class="nav1" >
				<li><a href="accessories?sp=Laptop">Laptop</a></li></br>
				<li><a href="accessories?sp=PC">PC</a></li></br>
				<li><a href="accessories?sp=Mobile">Mobile</a></li></br>
				<li><a href="accessories?sp=Camera">Camera</a></li></br>
				<li><a href="">Gamming Gear</a></li>
			</ul>
		</div>
		<div class="col_1_of_4 span_1_of_4" style="">
			<h2>Thông Tin</h2>
			<ul class="nav1">
				<li><a>Được Xây dựng bằng servlet , jsp, Mysql và dựa theo template cung cấp bởi W3layouts</a></li>
				<li><a>Website Phục vụ học tập.</a></li>
				<li><a>Xây dựng bởi ThangNH</a></li>
			</ul>
		</div>
		<div class="col_1_of_4 span_1_of_4" >
			<h2>Theo Dõi</h2>
			<ul class="nav">
				<li><a href="https://www.facebook.com/nguyenthang541997"><img src="images/facebook.png" title="facebook" alt=""/></a></li>
				<li><a href="https://twitter.com/NguynTh63929378"><img src="images/twitter.png" title="twitter" alt=""/></a></li>
				<li><a href="https://www.instagram.com/thangtick/"><img src="images/rss.png" title="rss" alt=""/></a></li>
			</ul>
		</div>
		<div class="col_1_of_4 span_1_of_4" >
			<h2>Liên Hệ</h2>
			<ul class="nav">
				<li><a>Phone  : ${initParam["Phone"] }</a></li>
				<li><a>Địa Chỉ: ${initParam["Addr"] }</a></li>
				<li><a href="mailto:${initParam['mailshop'] }">Email: <a href="mailto:${initParam['mailshop'] }"><span>${initParam["mailshop"] }</span></a></a></li>
			</ul>
		</div>
	</div>
</div>
<div class="footer1">
		<p class="w3-link">© 2013 Extro-Electronics. All Rights Reserved | Desig by <a href="http://w3layouts.com/" target="_blank"> W3Layouts</a></p>
	</div>