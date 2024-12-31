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

.d-flex {
	margin-left: 100px;
}

.content {
	margin-left: 130px;
}

.notice {
	border: 1px solid black;
	padding: 30px;
	width: 800px;
	height: 250px;
}

.board {
	display: inline;
}

.pNotice {
	display: inline-block;
	float: right;
	margin-top: 20px;
	color: red;
}

.btn1 {
	margin-left: 20px;
	float: right;
}

.notice>ul>li {
	margin: 10px;
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
					<a class="list-group-item list-group-item-action list-group-item-light p-3" href="myPage.do">구매목록(디폴트)</a> 
				<a class="list-group-item list-group-item-action list-group-item-light p-3" href="myReply.do">내가 쓴 문의(링크)</a> 
						<a class="list-group-item list-group-item-action list-group-item-light p-3" href="myHeartList.do">찜 목록(링크)</a> 
						<a class="list-group-item list-group-item-action list-group-item-light p-3" href="myInfo.do">내 정보 수정</a> 
						<a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">보유쿠폰</a> 
						<a class="list-group-item list-group-item-action list-group-item-light p-3" href="myInfoDeletePage.do">회원탈퇴</a> 
			</div>
		</div>
		<div class="content">
			<h2>회원탈퇴</h2>
			<br>
			<p>
				<strong>${member_id} 님 ! </strong> 테팡 서비스에 불편한 점이 있으셨나요?<br>
			</p>
			<p>이용 불편 및 각종 문의 사항은 고객센터로 문의 주시면 성심 성의껏 답변 드리겠습니다.</p>
			<a href="boardList.do" class="board">1:1 문의로 바로가기</a><br>
			<br>
			<div class="notice">
				<ul>
					<li><h4>회원탈퇴 전, 유의사항을 확인해 주시기 바랍니다.</h4></li>
					<li>1) 회원탈퇴 시 회원전용 웹 서비스 이용이 불가합니다.</li>
					<li>2) 이미 결제가 완료된 건은 탈퇴로 취소되지 않습니다.</li>
					<li>3) 고객 정보 및 서비스 이용 기록은 개인정보 보호 처리 방침 기준에 따라 삭제됩니다.</li>
					<li>4) 회원 탈퇴 시 보유하고 계신 적립금은 회원 정보에 등록된 계좌로 3 ~ 7 영업일 이내에 자동
						이체됩니다.</li>
				</ul>
			</div>
			<p class="pNotice">
				탈퇴를 원하실 경우 오른쪽의 버튼을 클릭해 주세요. <input type="button" value="회원탈퇴"
					class="btn btn1">
			</p>
		</div>

	</div>

</div>

</body>
<script>
document.querySelector('.btn').addEventListener('click', e => {
	deleteInfo();
})

function deleteInfo(rno = 1){
let id = document.querySelector('.flex-c-m').value;

		fetch('infoDelete.do', {
			method : 'post',
			header : {
				'content-type' : 'application/x-www-form-urlencoded;charset=utf-8'
			},
			body : "member_id=" + id
		})
		.then(result => result.json())
		.then(result => {
				console.log(result);
			if(result.retCode == 'OK'){
				alert("탈퇴되었습니다. 안녕히 가십시오.")
			} else {
				alert("다시 시도해 주세요.")
			}
		})
		.catch(err => console.log(err))
	}
</script>
<jsp:include page="../includes/footer.jsp"></jsp:include>
</body>
</html>