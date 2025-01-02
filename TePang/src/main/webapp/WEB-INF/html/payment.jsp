<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
<!-- Content page -->
<section class="bg0 p-t-104 p-b-116">
	<div class="container">
		<div class="flex-w flex-tr">
			<div
				class="size-210 bor10 p-lr-70 p-t-55 p-b-70 p-lr-15-lg w-full-md">
				<form action="tepnagsingup.do" method="post">
					<h4 class="mtext-105 cl2 txt-center p-b-30">주문정보</h4>

					<table class="table">

						<tr>
							<th>ID</th>
							<td><input
								class="size-121 bg1 bor1 hov-btn3 p-lr-15 pointer" name="id"
								type="text"></td>
						</tr>
						<tr>
							<th>Password</th>
							<td><input
								class="size-121 bg1 bor1 hov-btn3 p-lr-15 pointer" name="pw"
								type="text"></td>
						</tr>
						<tr>
							<th>Name</th>
							<td><input
								class="size-121 bg1 bor1 hov-btn3 p-lr-15 pointer" name="name"
								type="text"></td>
						</tr>
						<tr>
							<th>Phone</th>
							<td><input
								class="size-121 bg1 bor1 hov-btn3 p-lr-15 pointer" name="phone"
								type="text"></td>
						</tr>
						<tr>
							<th>Address</th>
							<td><input
								class="size-121 bg1 bor1 hov-btn3 p-lr-15 pointer" name="adr"
								type="text"></td>
						</tr>
						<tr>
							<th>BirthDay</th>
							<td><input
								class="size-121 bg1 bor1 hov-btn3 p-lr-15 pointer" name="bir"
								type="date"></td>
						</tr>
						<tr>
							<th>Gender</th>
							<td class="gender col-sm8"><input class="form-check-input"
								type="radio" name="gen" id="flexRadioDefault1" value="male">
								<label class="form-check-label" for="flexRadioDefault1">남</label>
							</td>
							<td class="gender col-sm8"><input class="form-check-input"
								type="radio" name="gen" id="flexRadioDefault2" value="female">
								<label class="form-check-label" for="flexRadioDefault2">여</label>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
</section>

<jsp:include page="../includes/footer.jsp"></jsp:include>