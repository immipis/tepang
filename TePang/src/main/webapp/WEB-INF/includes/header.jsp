<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Home</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
<link rel="icon" type="image/png" href="images/icons/favicon.png" />
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="fonts/iconic/css/material-design-iconic-font.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="fonts/linearicons-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/select2/select2.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="vendor/slick/slick.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/MagnificPopup/magnific-popup.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/perfect-scrollbar/perfect-scrollbar.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="css/util.css?after">
<link rel="stylesheet" type="text/css" href="css/main.css?after">
<!--===============================================================================================-->
</head>
<body class="animsition">
	<!-- Header -->
	<header>
		<!-- Header desktop -->
		<div class="container-menu-desktop">
		
			<!-- Topbar -->
			<div class="top-bar">
				<div class="content-topbar flex-sb-m h-full container">
					<div class="left-top-bar">안녕하세요</div>
					<div class="right-top-bar flex-w h-full">


                    <c:choose>
                    <c:when test="${not empty member_id }">
                      <a class="flex-c-m trans-04 p-lr-25" > ${member_id }</a>
                      <a class="flex-c-m trans-04 p-lr-25" href="myPage.do">마이 페이지</a>
                      <a class="flex-c-m trans-04 p-lr-25" href="tepanglogout.do">로그아웃</a>
                      <a href="./boardList.do" class="flex-c-m trans-04 p-lr-25" > Board </a>
                    </c:when>
                    <c:otherwise>

                      <a class="flex-c-m trans-04 p-lr-25" href="tepanglogin.do">로그인</a>
						<a href="tepnagsingupForm.do" class="flex-c-m trans-04 p-lr-25"> Sign Up </a> 

						<a href="./boardList.do" class="flex-c-m trans-04 p-lr-25"> Board </a>

                    </c:otherwise>
                    </c:choose>


					</div>
				</div>
			</div>

			<div class="wrap-menu-desktop">
				<nav class="limiter-menu-desktop container">

					<!-- Logo desktop -->
					<a href="mainList.do" class="logo"> <img src="images/icons/logo-03.png"
						alt="IMG-LOGO">
					</a>

					<!-- Menu desktop -->
					<div class="menu-desktop">
						<input class="mtext-107 cl2 plh2 p-r-15 search-input" type="text"
							name="search-product"></input>
						<div class="icon-header-item cl2 hov-cl1 trans-04 p-l-22 p-r-11">
							<i class="zmdi zmdi-search"></i>
						</div>
					</div>

					<!-- Icon header -->
					<div class="wrap-icon-header flex-w flex-r-m">
						<div
							class="icon-header-item cl2 hov-cl1 trans-04 p-l-22 p-r-11 icon-header-noti js-show-cart"
							data-notify="4">
							<i class="zmdi zmdi-shopping-cart"></i>
						</div>

						<a href="#"
							class="dis-block icon-header-item cl2 hov-cl1 trans-04 p-l-22 p-r-11 icon-header-noti"
							data-notify="9654"> <i class="zmdi zmdi-favorite-outline"></i>
						</a>
					</div>
				</nav>
			</div>
		</div>
	</header>