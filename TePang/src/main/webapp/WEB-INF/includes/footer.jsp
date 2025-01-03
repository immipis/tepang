<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Footer -->
	<footer class="bg3 p-t-75 p-b-32">
		<div class="container">
			<div class="row">
				<div class="col-sm-6 col-lg-3 p-b-50">
					<h4 class="stext-301 cl0 p-b-30">팀장 & 부팀장</h4>
					<ul>
						<li class="p-b-10"><a href="#"
							class="stext-107 cl7 hov-cl1 trans-04"> 조성민 </a></li>

						<li class="p-b-10"><a href="#"
							class="stext-107 cl7 hov-cl1 trans-04"> 박혜원 </a></li>
					</ul>
				</div>

				<div class="col-sm-6 col-lg-3 p-b-50">
					<h4 class="stext-301 cl0 p-b-30">팀원</h4>

					<ul>
						<li class="p-b-10"><a href="#"
							class="stext-107 cl7 hov-cl1 trans-04"> 김상연 </a></li>

						<li class="p-b-10"><a href="#"
							class="stext-107 cl7 hov-cl1 trans-04"> 도한준 </a></li>

						<li class="p-b-10"><a href="#"
							class="stext-107 cl7 hov-cl1 trans-04"> 이신영 </a></li>
						<li class="p-b-10"><a href="#"
							class="stext-107 cl7 hov-cl1 trans-04"> 박지희 </a></li>
					</ul>
				</div>

				<div class="col-sm-6 col-lg-3 p-b-50">
					<h4 class="stext-301 cl0 p-b-30">연락처</h4>

					<p class="stext-107 cl7 size-201">대구광역시 중구 중앙대로 403 (남일동 135-1, 5층) 
					태왕 아너스 타워 FAX 053-356-3939 전화번호 053-421-2460</p>

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
					<script>
						document.write(new Date().getFullYear());
					</script>
					All rights reserved | Made with <i class="fa fa-heart-o"
						aria-hidden="true"></i> by <a href="https://colorlib.com"
						target="_blank">Colorlib</a> &amp; distributed by <a
						href="https://themewagon.com" target="_blank">ThemeWagon</a>
					<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->

				</p>
			</div>
		</div>
	</footer>

<!-- Back to top -->
<div class="btn-back-to-top" id="myBtn">
	<span class="symbol-btn-back-to-top"> <i
		class="zmdi zmdi-chevron-up"></i>
	</span>
</div>
</body>
</html>
<script>

let id = "${member_id}";

    fetch('cartCount.do?id='+id)
    .then(result => result.json())
    .then(result => {
        document.querySelector('.cartnum').setAttribute('data-notify',result);
        
    })
    .catch(err => console.log(err))
</script>
<script>
    fetch('likeCount.do?id='+id)
    .then(result => result.json())
    .then(result => {
        document.querySelector('.likenum').setAttribute('data-notify',result);
        
    })
    .catch(err => console.log(err))
</script>

<script>
if (id == null || id == ""){
	
} else {
	    fetch('searchHistory.do?id='+id)
	      .then(result => result.json())
	      .then(result => {
	          result.forEach(item => {

	        	  let html =`
		        	  <a href='productList.do?searchText=\${item}'>\${item}</a>
		        	  `
	              document.querySelector('.searchHresult').insertAdjacentHTML('beforeend', html);

	          })
	      })
	      .catch(err => console.log(err))
	fetch('mainCart.do?id='+id)
	  .then(result => result.json())
	  .then(result => {
		  result.forEach(item => {
			  addCart(item);
		  })
	  })
	  .catch(err => console.log(err))
}

function addCart(item){
	let cartInfo = 
	`<li class="header-cart-item flex-w flex-t m-b-12">
		<div class="header-cart-item-img">
			<img src="images/\${item.productImg }" alt="IMG">
		</div>

		<div class="header-cart-item-txt p-t-8">
			<a href="#" class="header-cart-item-name m-b-18 hov-cl1 trans-04">
				\${item.productName } </a> <span class="header-cart-item-info"> \${item.productPrice }원 x \${item.productNum } = \${item.productPrice * item.productNum }원</span>
		</div>
	</li>`;
	
	document.getElementById('cartList')
			.insertAdjacentHTML('beforeend', cartInfo);
}
</script> 

<script>
let logId = "${logId }";
</script>
<script>
document.querySelector(".searchBtn").addEventListener('click', e => {
    let searchText = e.target.parentElement.parentElement.children[0].children[0].value;
    location.href='productList.do?searchText='+searchText+'&id='+id;
})
</script> 
<!--===============================================================================================-->
<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/bootstrap/js/popper.js"></script>
<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
<script src="js/main.js"></script>
<!--===============================================================================================-->