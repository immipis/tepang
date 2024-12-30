<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../includes/header.jsp"></jsp:include>

	<!-- Cart -->
	<div class="wrap-header-cart js-panel-cart">
		<div class="s-full js-hide-cart"></div>

		<div class="header-cart flex-col-l p-l-65 p-r-25">
			<div class="header-cart-title flex-w flex-sb-m p-b-8">
				<span class="mtext-103 cl2"> Your Cart </span>

				<div
					class="fs-35 lh-10 cl2 p-lr-5 pointer hov-cl1 trans-04 js-hide-cart">
					<i class="zmdi zmdi-close"></i>
				</div>
			</div>

			<div class="header-cart-content flex-w js-pscroll">
				<ul class="header-cart-wrapitem w-full">
					<c:forEach var="cart" items="${carts }">
						<li class="header-cart-item flex-w flex-t m-b-12">
							<div class="header-cart-item-img">
								<img src="images/${cart.productImg }" alt="IMG">
							</div>

							<div class="header-cart-item-txt p-t-8">
								<a href="#"
									class="header-cart-item-name m-b-18 hov-cl1 trans-04"> <c:out
										value="${cart.productName }" />
								</a> <span class="header-cart-item-info"> <c:out
										value="${cart.productNum }" /> x <c:out
										value="${cart.productPrice }" />
								</span>
							</div>
						</li>
					</c:forEach>
				</ul>

				<div class="w-full">
					<div class="header-cart-total w-full p-tb-40">Total: $75.00</div>

					<div class="header-cart-buttons flex-w w-full">
						<a href="shoping-cart.html"
							class="flex-c-m stext-101 cl0 size-107 bg3 bor2 hov-btn3 p-lr-15 trans-04 m-r-8 m-b-10">
							View Cart </a> <a href="shoping-cart.html"
							class="flex-c-m stext-101 cl0 size-107 bg3 bor2 hov-btn3 p-lr-15 trans-04 m-b-10">
							Check Out </a>
					</div>
				</div>
			</div>
		</div>
	</div>





	<!-- Shoping Cart -->
	<form action="cartList.do" class="bg0 p-t-75 p-b-85">
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
									<tr class="table_row" cnum = ${cart.cartNum }>
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
													class="btn-num-product-down cl8 hov-btn3 trans-04 flex-c-m btns">
													<i class="fs-16 zmdi zmdi-minus"></i>
												</div>

												<input class="mtext-104 cl3 txt-center num-product cnum"
													type="number" pnum=${cart.productNum } name="cnum"
													value="${cart.productNum }">

												<div
													class="btn-num-product-up cl8 hov-btn3 trans-04 flex-c-m btns">
													<i class="fs-16 zmdi zmdi-plus"  pname=${cart.productName }></i>
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
							class="flex-c-m stext-101 cl0 size-116 bg3 bor14 hov-btn3 p-lr-15 trans-04 pointer">
							결제</button>
					</div>
				</div>
			</div>
		</div>
	</form>




	<!-- Footer -->
	<footer class="bg3 p-t-75 p-b-32">
		<div class="container">
			<div class="row">
				<div class="col-sm-6 col-lg-3 p-b-50">
					<h4 class="stext-301 cl0 p-b-30">Categories</h4>

					<ul>
						<li class="p-b-10"><a href="#"
							class="stext-107 cl7 hov-cl1 trans-04"> Women </a></li>

						<li class="p-b-10"><a href="#"
							class="stext-107 cl7 hov-cl1 trans-04"> Men </a></li>

						<li class="p-b-10"><a href="#"
							class="stext-107 cl7 hov-cl1 trans-04"> Shoes </a></li>

						<li class="p-b-10"><a href="#"
							class="stext-107 cl7 hov-cl1 trans-04"> Watches </a></li>
					</ul>
				</div>

				<div class="col-sm-6 col-lg-3 p-b-50">
					<h4 class="stext-301 cl0 p-b-30">Help</h4>

					<ul>
						<li class="p-b-10"><a href="#"
							class="stext-107 cl7 hov-cl1 trans-04"> Track Order </a></li>

						<li class="p-b-10"><a href="#"
							class="stext-107 cl7 hov-cl1 trans-04"> Returns </a></li>

						<li class="p-b-10"><a href="#"
							class="stext-107 cl7 hov-cl1 trans-04"> Shipping </a></li>

						<li class="p-b-10"><a href="#"
							class="stext-107 cl7 hov-cl1 trans-04"> FAQs </a></li>
					</ul>
				</div>

				<div class="col-sm-6 col-lg-3 p-b-50">
					<h4 class="stext-301 cl0 p-b-30">GET IN TOUCH</h4>

					<p class="stext-107 cl7 size-201">Any questions? Let us know in
						store at 8th floor, 379 Hudson St, New York, NY 10018 or call us
						on (+1) 96 716 6879</p>

					<div class="p-t-27">
						<a href="#" class="fs-18 cl7 hov-cl1 trans-04 m-r-16"> <i
							class="fa fa-facebook"></i>
						</a> <a href="#" class="fs-18 cl7 hov-cl1 trans-04 m-r-16"> <i
							class="fa fa-instagram"></i>
						</a> <a href="#" class="fs-18 cl7 hov-cl1 trans-04 m-r-16"> <i
							class="fa fa-pinterest-p"></i>
						</a>
					</div>
				</div>

				<div class="col-sm-6 col-lg-3 p-b-50">
					<h4 class="stext-301 cl0 p-b-30">Newsletter</h4>

					<form>
						<div class="wrap-input1 w-full p-b-4">
							<input class="input1 bg-none plh1 stext-107 cl7" type="text"
								name="email" placeholder="email@example.com">
							<div class="focus-input1 trans-04"></div>
						</div>

						<div class="p-t-18">
							<button
								class="flex-c-m stext-101 cl0 size-103 bg1 bor1 hov-btn2 p-lr-15 trans-04">
								Subscribe</button>
						</div>
					</form>
				</div>
			</div>

			<div class="p-t-40">
				<div class="flex-c-m flex-w p-b-18">
					<a href="#" class="m-all-1"> <img
						src="images/icons/icon-pay-01.png" alt="ICON-PAY">
					</a> <a href="#" class="m-all-1"> <img
						src="images/icons/icon-pay-02.png" alt="ICON-PAY">
					</a> <a href="#" class="m-all-1"> <img
						src="images/icons/icon-pay-03.png" alt="ICON-PAY">
					</a> <a href="#" class="m-all-1"> <img
						src="images/icons/icon-pay-04.png" alt="ICON-PAY">
					</a> <a href="#" class="m-all-1"> <img
						src="images/icons/icon-pay-05.png" alt="ICON-PAY">
					</a>
				</div>

				<p class="stext-107 cl6 txt-center">
					<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
					Copyright &copy;
					<script>document.write(new Date().getFullYear());</script>
					All rights reserved | Made with <i class="fa fa-heart-o"
						aria-hidden="true"></i> by <a href="https://colorlib.com"
						target="_blank">Colorlib</a> &amp; distributed by <a
						href="https://themewagon.com" target="_blank">ThemeWagon</a>
					<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->

				</p>
			</div>
		</div>
	</footer>
	<!-- footer -->


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
    		
    		let price = e.target.closest('tr').children[2].innerText;
    		price = parseInt(price.replace('원', ''));
    		
     		e.target.closest('tr').children[4].innerText = price * (parseInt(currentQty)-1)+"원";				
     		totalSum();
			}
    		
    		
    	})
    })
    
    document.querySelectorAll('div.btn-num-product-up').forEach(icon => {
    	icon.addEventListener('click', e => {
    		let currentQty = e.target.closest('div.wrap-num-product').children[1].value;
    		
    		e.target.closest('div.wrap-num-product').children[1].value = currentQty;
    		
    		let price = e.target.closest('tr').children[2].innerText;
    		price = parseInt(price.replace('원', ''));
  
     		e.target.closest('tr').children[4].innerText = price * (parseInt(currentQty)+1)+"원";
    		
			totalSum();
			
			fetch('updateCart.do?pname='+ pname + '&pnum=' + pnum)
			.then(result => result.json())
	    	.then(result => {
	    		console.log(result)
	    		if(result.retCode == 'OK'){
	    		} else {
	    		}
	    	})
	    	.catch(err => console.log(err))
    	})
    })
    </script>
    <script>
    document.querySelectorAll('.btn-danger').forEach(item => {
    	item.addEventListener('click', e => {
			let cnum = e.target.parentElement.parentElement.getAttribute("cnum");
			fetch('removeCart.do?cnum='+ cnum)
	    	.then(result => result.json())
	    	.then(result => {
	    		console.log(result)
	    		if(result.retCode == 'OK'){
	    			alert("삭제완료.");
	    			document.querySelector('tr.table_row').remove();
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