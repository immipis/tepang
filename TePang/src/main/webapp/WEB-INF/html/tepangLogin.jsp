<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
	<!-- Title page -->
	<section class="bg-img1 txt-center p-lr-15 p-tb-92"
		style="background-image: url('images/bg-01.jpg');">
		<h2 class="ltext-105 cl0 txt-center">TEPANG Sign In</h2>
	</section>
	<!-- Content page -->
	<section class="bg0 p-t-104 p-b-116">
		<div class="container">
			<div class="flex-w flex-tr">
				<div class="size-210 bor10 p-lr-70 p-t-55 p-b-70 p-lr-15-lg w-full-md">
					<form action="tepanglogin.do" method="post">
						<h4 class="mtext-105 cl2 txt-center p-b-30">Login</h4>
						<table class="table">
						<tr>
							<th>ID</th>
							<td><input class=" cl0 size-121 bg1 bor1 hov-btn3 p-lr-15 trans-04 pointer" name="id" type="text" ></td>
						</tr>
						<tr>
							<th>Password</th>
							<td><input class=" cl0 size-121 bg1 bor1 hov-btn3 p-lr-15 trans-04 pointer" name="pw" type="password" ></td>
						</tr>
						<tr>
							<td colspan="2" align="center">
							<input type="submit" 
								class="flex-c-m stext-101 cl0 size-121 bg3 bor1 hov-btn3 p-lr-15 trans-04 pointer" value="Login"></td>
						</tr>
						<tr>
							<td colspan="2" align="center">
							<input type="submit" 
							class="flex-c-m stext-101 cl0 size-121 bg3 bor1 hov-btn3 p-lr-15 trans-04 pointer" value="signup"></td>
						</tr>
						</table>
					</form>
				</div>

				<div
					class="size-210 bor10 flex-w flex-col-m p-lr-93 p-tb-30 p-lr-15-lg w-full-md">
					<div class="flex-w w-full p-b-42">
						<span class="fs-18 cl5 txt-center size-211"> <span
							class="lnr lnr-map-marker"></span>
						</span>

						<div class="size-212 p-t-2">
							<span class="mtext-110 cl2"> Address </span>

							<p class="stext-115 cl6 size-213 p-t-18">Tepang Store 403,
								Jungang-daero, Jung-gu, Daegu, Republic of Korea</p>
						</div>
					</div>

					<div class="flex-w w-full p-b-42">
						<span class="fs-18 cl5 txt-center size-211"> <span
							class="lnr lnr-phone-handset"></span>
						</span>

						<div class="size-212 p-t-2">
							<span class="mtext-110 cl2"> tell </span>

							<p class="stext-115 cl1 size-213 p-t-18">053-421-2460</p>
						</div>
					</div>

					<div class="flex-w w-full">
						<span class="fs-18 cl5 txt-center size-211"> <span
							class="lnr lnr-envelope"></span>
						</span>

						<div class="size-212 p-t-2">
							<span class="mtext-110 cl2"> mail </span>

							<p class="stext-115 cl1 size-213 p-t-18">Tepang@master.com</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>


	<!-- Map -->
	<div class="map">
		<div class="size-303" id="google_map" data-map-x="35.8690730613163"
			data-map-y="128.593296913547" data-pin="images/icons/pin.png"
			data-scrollwhell="0" data-draggable="1" data-zoom="11"></div>
		<!-- ì¢í -->
	</div>



	<!-- Footer -->
	<jsp:include page="../includes/footer.jsp"></jsp:include>
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
	<script src="vendor/MagnificPopup/jquery.magnific-popup.min.js"></script>
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
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAKFWBqlKAGCeS1rMVoaNlwyayu0e0YRes"></script>
	<script src="js/map-custom.js"></script>
	<!--===============================================================================================-->

</body>
</html>