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
						<a class="list-group-item list-group-item-action list-group-item-light p-3" href="myPage.do">구매목록</a> 
					<a class="list-group-item list-group-item-action list-group-item-light p-3" href="myReply.do">내가 쓴 문의</a> 
						<a class="list-group-item list-group-item-action list-group-item-light p-3" href="myReview.do">내가 쓴 리뷰</a> 
						<a class="list-group-item list-group-item-action list-group-item-light p-3" href="myHeartList.do">찜 목록(미완)</a> 
						<a class="list-group-item list-group-item-action list-group-item-light p-3" href="myInfo.do">내 정보 수정</a> 
						<a class="list-group-item list-group-item-action list-group-item-light p-3" href="myInfoDeletePage.do">회원탈퇴</a> 
					</div>
				</div>
				<div class="content">
	<form>
		<table>
		
			<tr>
				<td><h2>정보 수정</h2></td>
			</tr>
			<tr>
				<td>아이디 (수정불가)</td>
			</tr>
			<tr>
				<td><input type="text" class="text" readonly value="${mem.memberId}"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
			</tr>
			<tr>
				<td><input type="password" id="mempass" class="text"></td>
			</tr>
			<tr>
				<td>비밀번호 확인</td>
			</tr>
			<tr>
				<td><input type="password" id="passcheck" class="text"></td>
			</tr>
			<tr>
				<td>이름 (수정불가)</td>
			</tr>
			<tr>
				<td><input type="text" class="text" readonly value="${mem.memberName}"></td>
			</tr>
			<tr>
				<td>주소</td>
			</tr>
			<tr>
				<td><input type="text" class="text" id="memadr" value="${mem.memberAdr}"></td>
			</tr>
			<tr>
				<td>관심사</td>
			</tr>
			<tr>
				<td><input type="text" class="text" id="memfv" value="${mem.memberFv}"></td>
			</tr>
			<tr>
				<td><input type="button" value="저장하기" class="btn"></td>
			</tr>
		</table>
		</form>
				</div>
			</div>
			</div>
</body>
<script>

document.querySelector('.btn').addEventListener('click', e => {
	infoUpdate();
})


function infoUpdate(rno = 1){
	
let pw = document.querySelector('#mempass').value;
let adr = document.querySelector('#memadr').value;
let fv = document.querySelector('#memfv').value;

	fetch('myinfoUpdate.do', {
			method : 'post',
			headers : {
				'content-type' : 'application/x-www-form-urlencoded;charset=utf-8'
			},
			body : "member_pw=" + pw +"&member_adr=" + adr + "&member_fv=" + fv // key=value 
		})
		.then(result => result.json())
		.then(result => {
			console.log(result);
			if(result.retCode == 'OK'){
				// 수정 후 나올 페이지 
				alert("수정되었습니다.")	
			} else {
				// 수정 실패하면 나올 페이지 
				alert("다시 시도해 주세요.")
			}
			
			document.querySelector('#mempass').value = ''; // 수정 완료된 후 초기화
			document.querySelector('#passcheck').value = '';
			
		})
		.catch(err => console.log(err))
}
</script>
<jsp:include page="../includes/footer.jsp"></jsp:include>
</body>
</html>