<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
<style>
div.row th {
	width: 150px;
}

td.ordertext {
	width: 300px;
}
</style>
<!-- Content page -->
<section class="bg0 p-t-104 p-b-116">
	<div class="container">
		<div class="row">
			<div class="col-lg-10 col-xl-7 m-lr-auto m-b-50">
					<h4 class="mtext-105 cl2 txt-center p-b-30">주문정보</h4>
					<table class="table">
						<tr>
							<th>받는 분 이름</th>
							<td class="ordertext"><input type="text"
								class="form-control" aria-label="Username"
								aria-describedby="basic-addon1" name="name"></td>
						</tr>
						<tr>
							<th>주소</th>
							<td><input type="text" class="form-control"
								aria-label="Username" aria-describedby="basic-addon1"
								name="adr"></td>
						</tr>
						<tr>
							<th>전화번호</th>
							<td class="ordertext"><input type="text"
								class="form-control" aria-label="Username"
								aria-describedby="basic-addon1" name="phone"></td>
						</tr>
						<tr>
							<th>배송요청사항</th>
							<td><input class="form-check-input" type="radio"
								name="request" id="flexRadioDefault1" value="문앞에 놔둬 주세요">
								<label class="form-check-label" for="flexRadioDefault1">문앞에
									놔둬 주세요</label> <input class="form-check-input" type="radio"
								name="request" id="flexRadioDefault2" value="경비실에 맡겨주세요">
								<label class="form-check-label" for="flexRadioDefault2">경비실에
									맡겨주세요</label> <input class="form-check-input" type="radio"
								name="request" id="flexRadioDefault3" value="택배함에 넣어주세요">
								<label class="form-check-label" for="flexRadioDefault3">택배함에
									넣어주세요</label> <input class="form-check-input" type="radio"
								name="request" id="flexRadioDefault4" value="직접 받겠습니다(부재 시 문 앞)">
								<label class="form-check-label" for="flexRadioDefault4">직접
									받겠습니다(부재 시 문 앞)</label></td>
						</tr>
						<div>
							<div>
								<div class="col-lg-10 col-xl-7 m-lr-auto m-b-50">
									<div class="m-l-25 m-r--38 m-lr-0-xl">
										<div class="wrap-table-shopping-cart">
											<table class="table-shopping-cart">
												<h4 class="mtext-105 cl2 txt-center p-b-30">상품정보</h4>
												<tr class="table_head">
													<th class="column-1">상품명</th>
													<th class="column-2"></th>
													<th class="column-3">가격</th>
													<th class="column-4">수량</th>
													<th class="column-5">총액</th>

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
														<td class="column-4"><input
															class="mtext-104 cl3 txt-center num-product cnum"
															type="number" name="cnum" value="${cart.productNum }"
															readonly></td>
														<td class="column-5"><c:out
																value="${cart.productPrice*cart.productNum }원" /></td>
													</tr>
												</c:forEach>

											</table>
											<div class="size-208">
												<span class="mtext-101 cl2"> Total: <span
													class="totalsum"></span></span>
											</div>
											<div>
												<button
													class="flex-c-m stext-101 cl0 size-101 bg1 bor1 hov-btn1 p-lr-15 trans-04 js-addcart-detail insertorder">결제</button>
											</div>
										</div>

									</div>
								</div>
					</table>
			</div>

		</div>
	</div>
</section>

<jsp:include page="../includes/footer.jsp"></jsp:include>

<script>
    let sum = 0;
    document.querySelectorAll('tr.table_row')
      .forEach(item => {
    	  console.log(item);
        let price = item.children[4].innerText;
        price = parseInt(price.replace("원", ""));
        sum += price;
      })
    document.querySelector('.totalsum').innerText = sum + " 원";
    
document.querySelector('.insertorder').addEventListener('click', e => {
	
	let name = document.querySelector('input[name="name"]').value;
    let adr = document.querySelector('input[name="adr"]').value;
    let phone = document.querySelector('input[name="phone"]').value;
    let request = document.querySelector('input[name="request"]:checked')?.value;
    let memid = e.target.parentElement.parentElement.children[4].children[0].children[1].getAttribute('memid');
	let osum = sum;
    let cnum = e.target.parentElement.parentElement.children[4].children[0].children[1].getAttribute('cnum');
		fetch('cartPayment.do?osum='+osum+'&name='+name+'&adr='+adr+'&phone='+phone+'&request='+request+'&cnum='+cnum+'&memid='+memid)
		.then(result => result.json())
		.then(result => {
			console.log(result);
			if(result.reCode == "OK") {
  	        alert('결제 완료!');				
			} else {				
  	        alert('결제 실패!');				
			}
		})
		.catch(err => {
			console.log(err);
	    })
    });

	

</script>
<script>
	let logId = "${logId }";
</script>