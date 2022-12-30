<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<title>Booking Form HTML Template</title>

<!-- Google font -->
<link href="https://fonts.googleapis.com/css?family=Lato:400,700"
	rel="stylesheet">

<!-- Bootstrap -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/cssUser/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/cssUser/css/style.css" />
<!-- Custom stlylesheet -->
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
		  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
		  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->

</head>

<body>
	<div id="booking" class="section">
		<div class="section-center">
			<div class="container">
				<div class="row">
					<div class="col-md-4">
						<div class="booking-cta">
							<h1>Book your flight today</h1>
							<p>Lorem ipsum dolor sit amet consectetur adipisicing elit.
								Cupiditate laboriosam numquam at</p>
						</div>
					</div>
					<div class="col-md-7 col-md-offset-1">
						<div class="booking-form">
							<c:choose>
								<c:when test="${empty success}">
									<div class="alert alert-success" style="display: none">
										<button type="button" class="close" data-dismiss="alert"
											aria-hidden="true">&times;</button>
									</div>
								</c:when>
								<c:otherwise>
									<div class="alert alert-success">
										<button type="button" class="close" data-dismiss="alert"
											aria-hidden="true">&times;</button>
										${success}
									</div>
								</c:otherwise>
							</c:choose>
							<form
								action="${pageContext.request.contextPath}/box-plane/search"
								method="post">
								<div class="row">
									<div class="col-md-4">
										<div class="form-group">
											<span class="form-label">Điểm Đi</span> <input
												class="form-control" type="text" name="diemDi"
												placeholder="Nhập điểm đến " required="required">
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group">
											<span class="form-label">Điểm Đến</span> <input
												class="form-control" type="text" name="diemDen"
												placeholder="Nhập điểm đến" required="required">
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group">
											<span class="form-label">Ngày Bay :</span> <input
												class="form-control" type="date" name="date" id="txtDate"
												required="required">
										</div>
									</div>
								</div>
								<div class="form-btn">
									<button class="submit-btn">Tìm kiếm</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="${pageContext.request.contextPath}/css/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/css/js/jquery-ui.js"></script>
	<script
		src="${pageContext.request.contextPath}/css/js/bootstrap.min.js"></script>
	<script>
		$(function() {
			var dtToday = new Date();

			var month = dtToday.getMonth() + 1;
			var day = dtToday.getDate();
			var year = dtToday.getFullYear();
			if (month < 10)
				month = '0' + month.toString();
			if (day < 10)
				day = '0' + day.toString();

			var maxDate = year + '-' + month + '-' + day;

			// or instead:
			// var maxDate = dtToday.toISOString().substr(0, 10);
			$('#txtDate').attr('min', maxDate);
		});
	</script>
</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->

</html>