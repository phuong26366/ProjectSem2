<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
							<table class="table table-hover">
								<thead>
									<tr>
										<th>Tên Máy Bay</th>
										<th>Tên Chuyến Bay</th>
										<th>Ngày Bay</th>
										<th>Giờ Bay</th>
										<th>Điểm Đi</th>
										<th>Điểm Đến</th>
										<th>Trạng Thái</th>
										<th></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${pros}" var="pro">
										<tr>
											<td>${pro.maMayBay.tenMayBay}</td>
											<td>${pro.tenChuyenBay}</td>
											<td><fmt:formatDate pattern="dd-MM-yyyy"
													value="${pro.ngayBay}" /></td>
											<td>${pro.gioBay}</td>
											<td>${pro.diemDi}</td>
											<td>${pro.diemDen}</td>
											<td><a class="btn btn-small btn-success"
												href="${pageContext.request.contextPath}/box-plane/preUpdate?id=${pro.maChuyenBay}">Chọn</a>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->

</html>