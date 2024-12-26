<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
#container {
	width: 1500px;
	margin: 0 auto;
	padding-top: 180px;
	height: 800px;
}
.content{
	margin-left: 70px;
}
table {
    width: 280px;
    height: 550px;
    margin: auto;      
}
.email {
    width: 127px;
    height: 32px;
    font-size: 15px;
    border: 0;
    border-color: lightgray;
    border-radius: 15px;
    outline: none;
    padding-left: 10px;
    background-color: rgb(233,233,233);
}
.text {
    width: 250px;
    height: 32px;
    font-size: 15px;
    border: 0;
    border-radius: 15px;
    outline: none;
    padding-left: 10px;
    background-color: rgb(233,233,233);
}
select {
    width: 100px;
    height: 32px;
    font-size: 15px;
    border: 1;
    border-color: lightgray;
    border-radius: 15px;
    outline: none;
    padding-left: 10px;
}
.btn {
    width: 262px;
    height: 32px;
    font-size: 15px;
    border: 0;
    border-radius: 15px;
    outline: none;
    padding-left: 10px;
    background-color: rgb(164, 199, 255);
}
.btn:active {
    width: 262px;
    height: 32px;
    font-size: 15px;
    border: 0;
    border-radius: 15px;
    outline: none;
    padding-left: 10px;
    background-color: rgb(61, 135, 255);
}
.d-flex {
	margin-left: 100px;
}
</style>
<script>
</script>
<jsp:include page="../includes/header.jsp"></jsp:include> 
	<div id=container>
			<div class="d-flex" id="wrapper">
				<!-- Sidebar-->
				<div class="border-end bg-white" id="sidebar-wrapper">

					<div class="list-group list-group-flush">
						<a class="list-group-item list-group-item-action list-group-item-light p-3" href="#">구매목록(디폴트)</a> 
						<a class="list-group-item list-group-item-action list-group-item-light p-3" href="myreview.do">내가 쓴 문의(링크)</a> 
						<a class="list-group-item list-group-item-action list-group-item-light p-3" href="myheartlist.do">찜 목록(링크)</a> 
						<a class="list-group-item list-group-item-action list-group-item-light p-3" href="myinfo">내 정보 수정</a> 
						<a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">보유쿠폰</a> 
						<a class="list-group-item list-group-item-action list-group-item-light p-3" href="myinfoDelete.do">회원탈퇴</a> 
					</div>
				</div>
				<div class="content">
	<form action="#" method="post">
		<table>
			<tr>
				<td><h2>정보 수정</h2></td>
			</tr>
			<tr>
				<td>아이디</td>
			</tr>
			<tr>
				<td><input type="text" class="text" readonly value="${mem.memberId}"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
			</tr>
			<tr>
				<td><input type="password" class="text"></td>
			</tr>
			<tr>
				<td>비밀번호 확인</td>
			</tr>
			<tr>
				<td><input type="password" class="text"></td>
			</tr>
			<tr>
				<td>이름</td>
			</tr>
			<tr>
				<td><input type="text" class="text" readonly value="${mem.memberName}"></td>
			</tr>
			<tr>
				<td>주소</td>
			</tr>
			<tr>
				<td><input type="text" class="text" value="${mem.memberAdr}"></td>
			</tr>
			<tr>
				<td>관심사</td>
			</tr>
			<tr>
				<td><input type="text" class="text" value="${mem.memberFv}"></td>
			</tr>
			<tr>
				<td><input type="submit" value="수정하기" class="btn"
					onclick="alert('개인정보가 수정되었습니다.')"></td>
			</tr>
		</table>
		</form>
				</div>
			</div>
			</div>
</body>
<jsp:include page="../includes/footer.jsp"></jsp:include>
</body>
</html>