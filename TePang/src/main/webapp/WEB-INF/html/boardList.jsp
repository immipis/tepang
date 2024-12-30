<%@page import="com.tepang.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <jsp:include page="../includes/header.jsp"></jsp:include>
    <style>
        .modal{
            display:none;
        }

		#container {
			width: 1000px;
			margin: 0 auto;
			padding-top: 180px;
		}
		#title {
			float: left;
		}
		h4 {
			padding-bottom: 30px;
		}
		
		p {
			font-size: 14px;
		}
		#list {
			padding-top: 160px;
		}
		button {
			float: right;
		}
		.pagination{
			margin-top: 40px;
			margin-bottom: 80px;
		}

		#writer{
		margin-bottom: 30px;
		font-size: 18px;
		font-weight: bold;
		}
	</style>
  </head> 
</html>


<!-- 헤더 -->
<head>

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


	<div id="container">

		<div id="title">
			<h4>Board</h4>
			<p>
				안녕하세요 테팡입니다.<br>상품에 대해 궁금한것이 있으면 문의주세요.
			</p>
		</div>
		
		<button type="button" class="btn btn-primary modalBtn" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="@mdo">문의하기</button>
	
		<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog modal-dialog-centered modal-lg">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel"><b>문의하기</b></h5>
		      </div>
		      <div class="modal-body">
		        <form action="./boardForm.do" method="post">
		          <div class="mb-3">
		            <input id="writer" type="text" readonly name="member_id" value="">
		            <select name="reply_type" class="form-control">
		              <option value="">선택하세요.</option>
		              <option value="notice">문의</option>
		            </select>
		          </div>
		          <div class="mb-3">
		            <label for="message-text" class="col-form-label">무엇이 궁금하신가요?</label>
		            <textarea class="form-control" id="message-text" name="reply_content"></textarea>
		          </div>
		          <div class="modal-footer">
		            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
		            <button type="submit" class="btn btn-primary">문의하기</button>
		          </div>
		        </form>
		      </div>
		    </div>
		  </div>
		</div>
				

		<!--<button id="QABtn" class="col-sm-2 btn btn-primary"><a href="./board.do"> 문의하기</a></button>  --> 
		
		<div id="list">
			<table class="table">
				<thead>
					<tr>
						<th>No</th>
						<th>Title</th>
						<th>Writer</th>
						<th>Date</th>
					</tr>
				</thead>
				<tbody>


					<c:forEach var="bvo" items="${list}">
					<tr>
						<td align="center">
						<a href="board.do?page=${paging.currentPage }
						  
						&reply_code=${bvo.replyCode}">${bvo.replyCode}</a>

						</td>
						<td><c:out value="${bvo.replyContent}" /></td>
						<td><c:out value="${bvo.memberId}" /></td>
						<td>${bvo.replyDate}</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			<!-- paging -->


			<!-- paging -->
			<nav aria-label="...">
				<ul class="pagination">

					<!-- 이전 10개 목록이 존재하면 Previous를 활성화.  -->

					<c:choose>
						<c:when test="${paging.prev }">
							<li class="page-item"><a class="page-link"
								href="boardList.do?keyword=${keyword ne null ? keyword : ''}&searchCondition=${searchCondition ne null ? searchCondition : ''}&page=${paging.startPage -1 }">Previous</a>
							</li>
						</c:when>
						<c:otherwise>
							<li class="page-item disabled"><span class="page-link">Previous</span>
							</li>
						</c:otherwise>
					</c:choose>



					<!--startPage 와 endPage의 값에 해당하는 링크를 반복적으로 생성  -->

					<c:forEach var="p" begin="${paging.startPage }"
						end="${paging.endPage }">
						<c:choose>
							<c:when test="${paging.currentPage == p }">
								<li class="page-item active" aria-current="page"><span
									class="page-link">${p }</span></li>
							</c:when>
							<c:otherwise>
								<li class="page-item"><a class="page-link"
									href="boardList.do?keyword=${keyword eq null ? '' : keyword }&searchCondition=${searchCondition eq null ? '' : searchCondition }&page=${p }">${p }</a>
								</li>
							</c:otherwise>
						</c:choose>
					</c:forEach>


					<!-- 이전 10개 목록이 존재하면 Previous를 활성화.  -->

					<c:choose>
						<c:when test="${paging.next }">
							<li class="page-item"><a class="page-link"
								href="boardList.do?keyword=${keyword ne null ? keyword : ''}&searchCondition=${!empty searchCondition ? '': searchCondition }&page=${paging.endPage +1}">Next</a></li>
						</c:when>
						<c:otherwise>
							<li class="page-item disabled"><span class="page-link">Next</span>
							</li>
						</c:otherwise>
					</c:choose>
				</ul>
			</nav>
		</div>
	</div>
	<script>
	let memberId = `${member_id}`; // 서버에서 값이 넘어오는 경우
	document.querySelector(".modalBtn").addEventListener('click',e=>{
		if (memberId) {
		    
		  } else {
		    alert('로그인 시 문의 가능합니다.');
		  }
	})
	
	
	</script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" 
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous">
	
	string replyType = $('replyType').text();
	
	</script>
</body>
<jsp:include page="../includes/footer.jsp"></jsp:include>

