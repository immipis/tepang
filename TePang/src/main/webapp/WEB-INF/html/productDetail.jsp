<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../includes/header.jsp"></jsp:include>

		<!-- 상태창 -->
		<div class="container">
			<div class="bread-crumb flex-w p-l-25 p-r-15 p-t-30 p-lr-0-lg">
				<a href="mainList.do" class="stext-109 cl8 hov-cl1 trans-04">
					메인메뉴 <i class="fa fa-angle-right m-l-9 m-r-10" aria-hidden="true"></i>
				</a> <a href="productList.do" class="stext-109 cl8 hov-cl1 trans-04">
					${product.category } <i class="fa fa-angle-right m-l-9 m-r-10"
					aria-hidden="true"></i>
				</a> <span class="stext-109 cl4"> ${product.productName }<!-- Lightweight Jacket -->
				</span> 
			</div>
		</div>
		<!-- 상태창 끝 -->

		<!-- 상품상세 -->
		<section class="sec-product-detail bg0 p-t-65 p-b-60">
			<div class="container">
				<div class="row">
					<div class="col-md-6 col-lg-7 p-b-30">
						<div class="p-l-25 p-r-30 p-lr-0-lg">
							<div class="wrap-slick3 flex-sb flex-w">
								<div class="wrap-slick3-dots"></div>
								<div class="wrap-slick3-arrows flex-sb-m flex-w"></div>
								<div class="wrap-pic-w pos-relative">
									<img src="images/${product.productImg }" alt="IMG-PRODUCT">

									<a
										class="flex-c-m size-108 how-pos1 bor0 fs-16 cl10 bg0 hov-btn3 trans-04"
										href="images/${product.productImg }"> <i
										class="fa fa-expand"></i>
									</a>
								</div>
							</div>
						</div>
					</div>

					<div class="col-md-6 col-lg-5 p-b-30">
						<div class="p-r-50 p-t-5 p-lr-0-lg">
							<h4 class="mtext-105 cl2 js-name-detail p-b-14">
								상품이름: ${product.productName }
							</h4>

							<span class="mtext-106 cl2"><h3>상품가격: ${product.productPrice }</h3></span>
							
							<span class="mtext-106 cl2"><h3>상품설명: ${product.productDetail }</h3></span>
							<!-- 상품상세 끝 -->
							<!-- 상품수량(plus,minus), 장바구니, 바로결재 -->
							<div class="p-t-33">

								<div class="flex-w flex-r-m p-b-10">
									<div class="size-204 flex-w flex-m respon6-next">
										<div class="wrap-num-product flex-w m-r-20 m-tb-10">
											<div
												class="btn-num-product-down cl8 hov-btn3 trans-04 flex-c-m minusbtn">
												<i class="fs-16 zmdi zmdi-minus minusbtn"></i>
											</div>

											<input class="mtext-104 cl3 txt-center num-product"
												type="number" name="num-product" value="1">

											<div class="btn-num-product-up cl8 hov-btn3 trans-04 flex-c-m plusbtn">
												<i class="fs-16 zmdi zmdi-plus plusbtn"></i>
											</div>
										</div>
										<div pcode=${product.productCode } memid=${member_id  }>
										<button
											class="flex-c-m stext-101 cl0 size-101 bg1 bor1 hov-btn1 p-lr-15 trans-04 js-addcart-detail insertcart">
											장바구니</button>
											<button
											class="flex-c-m stext-101 cl0 size-101 bg1 bor1 hov-btn1 p-lr-15 trans-04 js-addcart-detail">
											바로결제</button>
											</div>
									</div>
								</div>
							</div>
							<!-- 상품수량, 장바구니, 바로결재 끝-->

							<!--  -->
							<div class="flex-w flex-m p-l-100 p-t-40 respon7">
								<div class="flex-m bor9 p-r-10 m-r-11">
									<a href="#"
										class="fs-14 cl3 hov-cl1 trans-04 lh-10 p-lr-5 p-tb-2 js-addwish-detail tooltip100"
										data-tooltip="Add to Wishlist"> <i
										class="zmdi zmdi-favorite"></i>
									</a>
								</div>

								<a href="#"
									class="fs-14 cl3 hov-cl1 trans-04 lh-10 p-lr-5 p-tb-2 m-r-8 tooltip100"
									data-tooltip="Facebook"> <i class="fa fa-facebook"></i>
								</a> <a href="#"
									class="fs-14 cl3 hov-cl1 trans-04 lh-10 p-lr-5 p-tb-2 m-r-8 tooltip100"
									data-tooltip="Twitter"> <i class="fa fa-twitter"></i>
								</a> <a href="#"
									class="fs-14 cl3 hov-cl1 trans-04 lh-10 p-lr-5 p-tb-2 m-r-8 tooltip100"
									data-tooltip="Google Plus"> <i class="fa fa-google-plus"></i>
								</a>
							</div>
						</div>
					</div>
				</div>

					<!-- 상품상세(DetailImg사진 가져오기) 리뷰 창 -->
				<div class="bor10 m-t-50 p-t-43 p-b-40">
					<div class="tab01">
						<!-- Nav tabs -->
						<ul class="nav nav-tabs" role="tablist">
							<li class="nav-item p-b-10"><a class="nav-link active"
								data-toggle="tab" href="#description" role="tab">상품상세</a></li>
							<li class="nav-item p-b-10"><a class="nav-link"
								data-toggle="tab" href="#reviews" role="tab">리뷰</a></li>
						</ul>

						<div class="tab-content p-t-43">
							<div class="tab-pane fade show active" id="description"
								role="tabpanel">
								<div class="how-pos2 p-lr-15-md">
									<p class="stext-102 cl6">
									<div class="item-slick3"
										data-thumb="images/${product.productImg }">
										<div class="wrap-pic-w pos-relative">
											<img src="images/${product.productImg }" alt="IMG-PRODUCT">
										</div>
									</div>

									<div class="item-slick3"
										data-thumb="images/${product.productImg }">
										<div class="wrap-pic-w pos-relative">
											<img src="images/${product.productImg }" alt="IMG-PRODUCT">

											<a
												class="flex-c-m size-108 how-pos1 bor0 fs-16 cl10 bg0 hov-btn3 trans-04"
												href="images/product-detail-03.jpg"> <i
												class="fa fa-expand"></i>
											</a>
										</div>
									</div>
								</div>
							</div>

							<!--리뷰작성 -->
							<div class="tab-pane fade" id="reviews" role="tabpanel">
								<div class="row">
									<div class="col-sm-10 col-md-8 col-lg-6 m-lr-auto">
										<div class="p-b-30 m-lr-15-sm">
											<!-- Review -->
											<div class="flex-w flex-t p-b-68">
												<div class="wrap-pic-s size-109 bor0 of-hidden m-r-18 m-t-6">
													<img src="images/avatar-01.jpg" alt="AVATAR">
												</div>

												<div class="size-207">
													<div class="flex-w flex-sb-m p-b-17">
														<span class="mtext-107 cl2 p-r-20"> ${boards.memberId } </span>

														<span class="fs-18 cl11"> <i class="zmdi zmdi-star"></i>
															<i class="zmdi zmdi-star"></i> <i class="zmdi zmdi-star"></i>
															<i class="zmdi zmdi-star"></i> <i
															class="zmdi zmdi-star-half"></i>
														</span>
													</div>

													<p class="stext-102 cl6">${boards.replyContent }</p>
												</div>
											</div>
											<!--리뷰작성 끝 -->

											<!-- 별점 -->
											<form class="w-full">
												<h5 class="mtext-108 cl2 p-b-7">"${product.productName}의 리뷰를 작성하세요"</h5>

												<div class="flex-w flex-m p-t-50 p-b-23">
													<span class="stext-102 cl3 m-r-16"> 별점 </span> <span
														class="wrap-rating fs-18 cl11 pointer"> <i
														class="item-rating pointer zmdi zmdi-star-outline"></i> <i
														class="item-rating pointer zmdi zmdi-star-outline"></i> <i
														class="item-rating pointer zmdi zmdi-star-outline"></i> <i
														class="item-rating pointer zmdi zmdi-star-outline"></i> <i
														class="item-rating pointer zmdi zmdi-star-outline"></i> <input
														class="dis-none" type="number" name="rating">
													</span>
												</div>

												<div class="row p-b-25">
													<div class="col-12 p-b-5">
														<label class="stext-102 cl3" for="review">리뷰작성</label>
														<textarea
															class="size-110 bor8 stext-102 cl2 p-lr-20 p-tb-10"
															id="review" name="review"></textarea>
													</div>

													<div class="col-sm-6 p-b-5">
														<label class="stext-102 cl3" for="name">이름</label> <input
															class="size-111 bor8 stext-102 cl2 p-lr-20" id="name"
															type="text" name="name">
													</div>

													<div class="col-sm-6 p-b-5">
														<label class="stext-102 cl3" for="email">이메일</label> <input
															class="size-111 bor8 stext-102 cl2 p-lr-20" id="email"
															type="text" name="email">
													</div>
												</div>

												<button
													class="flex-c-m stext-101 cl0 size-112 bg7 bor11 hov-btn3 p-lr-15 trans-04 m-b-10">
													리뷰등록</button>
											</form>
											<div class="reviews">123</div>
										</div>
									</div>
								</div>
							</div>
						</div>
				
					</div>
			</div>
				<!-- 상품상세(DetailImg사진 가져오기) 리뷰 창  끝-->
			</div>
		</section>
		<jsp:include page="../includes/footer.jsp"></jsp:include>
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
			$(".js-select2").each(function() {
				$(this).select2({
					minimumResultsForSearch : 20,
					dropdownParent : $(this).next('.dropDownSelect2')
				});
			})
		</script>
		<!--===============================================================================================-->
		<script src="vendor/daterangepicker/moment.min.js"></script>
		<script src="vendor/daterangepicker/daterangepicker.js"></script>
		<!--===============================================================================================-->
		<script src="vendor/slick/slick.min.js"></script>
		<script src="js/slick-custom.js"></script>
		<!--===============================================================================================-->
		<script src="vendor/parallax100/parallax100.js"></script>
		<script>
			$('.parallax100').parallax100();
		</script>
		<!--===============================================================================================-->
		<script src="vendor/MagnificPopup/jquery.magnific-popup.min.js"></script>
		<script>
			$('.gallery-lb').each(function() { // the containers for all your galleries
				$(this).magnificPopup({
					delegate : 'a', // the selector for gallery item
					type : 'image',
					gallery : {
						enabled : true
					},
					mainClass : 'mfp-fade'
				});
			});
		</script>
		<!--===============================================================================================-->
		<script src="vendor/isotope/isotope.pkgd.min.js"></script>
		<!--===============================================================================================-->
		<script src="vendor/sweetalert/sweetalert.min.js"></script>
		<script>
			$('.js-addwish-b2, .js-addwish-detail').on('click', function(e) {
				e.preventDefault();
			});

			$('.js-addwish-b2').each(
					function() {
						var nameProduct = $(this).parent().parent().find(
								'.js-name-b2').html();
						$(this).on(
								'click',
								function() {
									swal(nameProduct, "is added to wishlist !",
											"success");

									$(this).addClass('js-addedwish-b2');
									$(this).off('click');
								});
					});

			$('.js-addwish-detail').each(
					function() {
						var nameProduct = $(this).parent().parent().parent()
								.find('.js-name-detail').html();

						$(this).on(
								'click',
								function() {
									swal(nameProduct, "is added to wishlist !",
											"success");

									$(this).addClass('js-addedwish-detail');
									$(this).off('click');
								});
					});

			/*---------------------------------------------*/

			$('.js-addcart-detail').each(
					function() {
						var nameProduct = $(this).parent().parent().parent()
								.parent().find('.js-name-detail').html();
						$(this).on('click', function() {
							swal(nameProduct, "is added to cart !", "success");
						});
					});
		</script>
		<!--===============================================================================================-->
		<script src="vendor/perfect-scrollbar/perfect-scrollbar.min.js"></script>
		<script>
			$('.js-pscroll').each(function() {
				$(this).css('position', 'relative');
				$(this).css('overflow', 'hidden');
				var ps = new PerfectScrollbar(this, {
					wheelSpeed : 1,
					scrollingThreshold : 1000,
					wheelPropagation : false,
				});

				$(window).on('resize', function() {
					ps.update();
				})
			});
		</script>
		<!--===============================================================================================-->
		<script src="js/main.js"></script>
		<script>
	  fetch('review.do?pcode=${product.productCode}')
	  	.then(result => result.json())
	  	.then(result => {
	  		for(i=0; i < result.length; i++){	  
	  		document.querySelector(".reviews").insertAdjacentHTML("beforeend",
	  				`<h5 id="result">\${result[i].productCode}</h5>
			  		<p id="replyContent">\${result[i].replyContent}</p>`);
	  		//.innerHTML+=result[i] + replyContent;
	  		}
	  	})
	  	.catch(err => console.log(err));
	  

	  </script>
      <script>
      document.querySelector('.insertcart').addEventListener('click', e => {
    	  console.log(e.target.parentElement.parentElement.children[1].getAttribute('pcode'));
    	  
    	  let pnum = e.target.parentElement.parentElement.children[0].children[1].value;
    	  let memid = e.target.parentElement.parentElement.children[1].getAttribute('memid');
    	  let pcode = e.target.parentElement.parentElement.children[1].getAttribute('pcode');
    	  
    	  console.log(pnum,pcode,memid)
    	  
    	  fetch('insertCart.do?pcode='+ pcode +'&memid='+memid+'&pnum='+pnum)
    	  .then(result => result.json())
    	  .then(result => {
    		  console.log(result)
    	  })
    	  .catch(err => console.log(err))
      })
      </script>
      <script>
      document.querySelector('.plusbtn').addEventListener('click', e => {
    	    
    	    let currentQty = e.target.parentElement.children[1].value;
    	    
    		e.target.parentElement.children[1].value = currentQty;			
     		
    		e.target.parentElement.children[1].value = parseInt(currentQty)+1
    		
  			})
  			
  	  document.querySelector('.minusbtn').addEventListener('click', e => {
    	    
    	    let currentQty = e.target.parentElement.children[1].value;
    	    
    		e.target.parentElement.children[1].value = currentQty;			
     		if (currentQty > 1){
    		e.target.parentElement.children[1].value = parseInt(currentQty)-1     			
     		}
    		
  			})
      </script>

</body>
</html>