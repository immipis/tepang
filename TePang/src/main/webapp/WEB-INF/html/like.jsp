<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../includes/header.jsp"></jsp:include>

<div class="col-lg-10 col-xl-7 m-lr-auto m-b-50">
									<div class="m-l-25 m-r--38 m-lr-0-xl">
										<div class="wrap-table-shopping-cart">
											<table class="table-shopping-cart">
												<h4 class="mtext-105 cl2 txt-center p-b-30">찜 목록</h4>
												<tr class="table_head">
													<th class="column-1">상품명</th>
													<th class="column-2"></th>
													<th class="column-3">가격</th>
													<th class="column-4"></th>
													<th class="column-5"></th>

												</tr>
												<c:forEach var="cart" items="${carts }">
													<tr data-cnum=${cart.cartNum } class="table_row number"
														cnum=${cart.cartNum }  memid=${cart.memberId }>
														<td class="column-1">
															<div class="how-itemcart1">
																<img src="images/${cart.productImg }" alt="IMG">
															</div>
														</td>
														<td class="column-2"><c:out
																value="${cart.productName }" /></td>
														<td class="column-3 cprice"><c:out
																value="${cart.productPrice }원" /></td>
														<td class="column-4">
														 <button onclick="location.href='productDetail.do?pcode=${cart.productCode }'"><i class="fa-solid fa-cart-shopping">상품보러가기</i></button>
														</td>
														<td class="column-5">
													     <button class="removelike"><h3><i class="fa-solid fa-x"></i></h3></button>														
														</td>
													</tr>
												</c:forEach>

											</table>
											
										</div>

									</div>
								</div>

<jsp:include page="../includes/footer.jsp"></jsp:include>
<script>
// 삭제
document.querySelectorAll('.removelike').forEach(item => {
	item.addEventListener('click', e => {
		console.log(e.target.parentElement.parentElement.parentElement.parentElement.getAttribute("cnum"));
		
		let cnum = e.target.parentElement.parentElement.parentElement.parentElement.getAttribute("cnum")
		fetch('removeLike.do?cnum='+ cnum)
    	.then(result => result.json())
    	.then(result => {
    		console.log(result)
    		if(result.retCode == 'OK'){
    			alert("삭제완료.");
    			document.querySelector('tr[data-cnum="' + cnum + '"]').remove();
    		} else {
    			alert("삭제가 안됨.");
    		}
    	})
    	.catch(err => console.log(err))
	})
})
</script>