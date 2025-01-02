<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../includes/header.jsp"></jsp:include>

	<!-- Shoping Cart -->
	<form action="payment.do?id=${logId }" class="bg0 p-t-75 p-b-85">
		<div class="container">
			<div class="row">
				<div class="col-lg-10 col-xl-7 m-lr-auto m-b-50">
					<div class="m-l-25 m-r--38 m-lr-0-xl">
						<div class="wrap-table-shopping-cart">
							<table class="table-shopping-cart">
								<tr class="table_head">
									<th class="column-1">상품명</th>
									<th class="column-2"></th>
									<th class="column-3">가격</th>
									<th class="column-4">수량</th>
									<th class="column-5">총액</th>
									<th class="column-6"></th>
								</tr>
								<c:forEach var="cart" items="${carts }">
									<tr data-cnum=${cart.cartNum } class="table_row" cnum = ${cart.cartNum }>
										<td class="column-1">
											<div class="how-itemcart1">
												<img src="images/${cart.productImg }" alt="IMG">
											</div>
										</td>
										<td class="column-2"><c:out value="${cart.productName }" /></td>
										<td class="column-3 cprice"><c:out
												value="${cart.productPrice }원" /></td>
										<td class="column-4">
											<div class="wrap-num-product flex-w m-l-auto m-r-0">
												<div
													class="btn-num-product-down cl8 hov-btn3 trans-04 flex-c-m btns" memid=${cart.memberId } pnum=${cart.productNum } pcode=${cart.productCode }>
													<i class="fs-16 zmdi zmdi-minus"></i>
												</div>

												<input class="mtext-104 cl3 txt-center num-product cnum"
													type="number" name="cnum"
													value="${cart.productNum }">

												<div
													class="btn-num-product-up cl8 hov-btn3 trans-04 flex-c-m btns" memid=${cart.memberId } pnum=${cart.productNum } pcode=${cart.productCode }>
													<i class="fs-16 zmdi zmdi-plus"></i>
												</div>
											</div>
										</td>
										<td class="column-5"><c:out
												value="${cart.productPrice*cart.productNum }원" /></td>
												<td class="column-6"><input type="button" class="btn btn-danger" value="X"></td>
									   </tr>
								</c:forEach>
							</table>
						</div>

					</div>
				</div>


				<div class="total col-sm-10 col-lg-7 col-xl-5 m-lr-auto m-b-50">
					<div
						class="bor10 p-lr-40 p-t-30 p-b-40 m-l-63 m-r-40 m-lr-0-xl p-lr-15-sm">
						<h4 class="mtext-109 cl2 p-b-30">Cart Totals</h4>

						<div class="flex-w flex-t bor12 p-b-13">
							<div class="size-208">

								<span class="stext-110 cl2"></span>

							</div>

							<div class="size-209">
								<span class="mtext-110 cl2"> <!-- 총액넣는곳 -->
								</span>
							</div>
						</div>

						<div class="flex-w flex-t p-t-27 p-b-33">
							<div class="size-208">
								<span class="mtext-101 cl2"> Total: <span
									class="totalsum"></span></span>
							</div>

							<div class="size-209 p-t-1">
								<span class="mtext-110 cl2"> </span>
							</div>
						</div>
							<button
								class="cartbtn flex-c-m stext-101 cl0 size-107 bg3 bor2 hov-btn3 p-lr-15 trans-04 m-r-8 m-b-10">구매하러가기
							</button>						
					</div>
				</div>
			</div>
		</div>
	</form>

<jsp:include page="../includes/footer.jsp"></jsp:include>

	<!-- Back to top -->
	<div class="btn-back-to-top" id="myBtn">
		<span class="symbol-btn-back-to-top"> <i
			class="zmdi zmdi-chevron-up"></i>
		</span>
	</div>
	<script>
    document.querySelectorAll('div.btn-num-product-down').forEach(icon => {
    	icon.addEventListener('click', e => {
    		let currentQty = e.target.closest('div.wrap-num-product').children[1].value;
			if(currentQty > 0){
    		e.target.closest('div.wrap-num-product').children[1].value = currentQty;
    		e.target.closest('div.wrap-num-product').children[1].value = parseInt(currentQty)-1;
    		
    		let price = e.target.closest('tr').children[2].innerText;
    		price = parseInt(price.replace('원', ''));
    		
     		e.target.closest('tr').children[4].innerText = price * (parseInt(currentQty)-1)+"원";				
     		totalSum();
			}
			let pnum = parseInt(e.target.closest('div.wrap-num-product').children[1].value);
			let memid = e.target.closest('div.btns').getAttribute('memid');
			let pcode = e.target.closest('div.btns').getAttribute('pcode');
			
			fetch('updateCart.do?pcode='+ pcode + '&pnum=' + pnum + '&memid=' + memid)
			.then(result => result.json())
	    	.then(result => {
	    		console.log(result)

	    	})
	    	.catch(err => console.log(err))
    		
    	})
    })
    
    document.querySelectorAll('div.btn-num-product-up').forEach(icon => {
    	icon.addEventListener('click', e => {
    		let currentQty = e.target.closest('div.wrap-num-product').children[1].value;
    		
    		e.target.closest('div.wrap-num-product').children[1].value = currentQty;
    		
    		e.target.closest('div.wrap-num-product').children[1].value = parseInt(currentQty)+1;
    		
    		let price = e.target.closest('tr').children[2].innerText;
    		price = parseInt(price.replace('원', ''));
  
     		e.target.closest('tr').children[4].innerText = price * (parseInt(currentQty)+1)+"원";
    		
			totalSum();
			
			
			let pnum = parseInt(e.target.closest('div.wrap-num-product').children[1].value);
			let memid = e.target.closest('div.btns').getAttribute('memid');
			let pcode = e.target.closest('div.btns').getAttribute('pcode');
			
			fetch('updateCart.do?pcode='+ pcode + '&pnum=' + pnum + '&memid=' + memid)
			.then(result => result.json())
	    	.then(result => {
	    		console.log(result)

	    	})
	    	.catch(err => console.log(err))
    	})
    })
    </script>
    <script>
    // 삭제
    document.querySelectorAll('.btn-danger').forEach(item => {
    	item.addEventListener('click', e => {
			let cnum = e.target.parentElement.parentElement.getAttribute("cnum");
			fetch('removeCart.do?cnum='+ cnum)
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
    <script>
    function totalSum() {
        let sum = 0;
        document.querySelectorAll('tr.table_row')
          .forEach(item => {
            let price = item.children[4].innerText;
            price = parseInt(price.replace("원", ""));
            sum += price;
          })
        document.querySelector('.totalsum').innerText = sum + " 원";
      }
      totalSum();
    </script>

	<!--===============================================================================================-->
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/animsition/js/animsition.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
	<script>
		$(".js-select2").each(function(){
			$(this).select2({
				minimumResultsForSearch: 20,
				dropdownParent: $(this).next('.dropDownSelect2')
			});
		})
	</script>
	<!--===============================================================================================-->
	<script src="vendor/MagnificPopup/jquery.magnific-popup.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/perfect-scrollbar/perfect-scrollbar.min.js"></script>
	<script>
		$('.js-pscroll').each(function(){
			$(this).css('position','relative');
			$(this).css('overflow','hidden');
			var ps = new PerfectScrollbar(this, {
				wheelSpeed: 1,
				scrollingThreshold: 1000,
				wheelPropagation: false,
			});

			$(window).on('resize', function(){
				ps.update();
			})
		});
	</script>
	<script>
	let logId = "${logId }"; // 작성자.
    </script>
	<!--===============================================================================================-->
	<script src="js/main.js"></script>

</body>
</html>