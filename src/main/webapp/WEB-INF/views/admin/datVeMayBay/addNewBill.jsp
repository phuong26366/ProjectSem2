<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<title>Booking Form HTML Template</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/cssUser/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/cssUser/css/style.css" />
<style>
.erorr {
	color: red;
}
</style>
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

							<form:form action="insert" modelAttribute="m" method="post">
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<span class="form-label">Tên Khách Hàng </span>
											<form:input type="text" path="tenKhachHang"
												cssClass="form-control" />
											<br>
											<form:errors cssClass="erorr" path="tenKhachHang" />
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<span class="form-label">Số Điện Thoại </span>
											<form:input type="text" path="soDienThoai"
												cssClass="form-control" />
											<br>
											<form:errors cssClass="erorr" path="soDienThoai" />
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<span class="form-label">Địa Chỉ</span>
											<form:input type="text" path="diaChi" cssClass="form-control" />
											<br>
											<form:errors cssClass="erorr" path="diaChi" />
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<span class="form-label">Căn Cước Công Dân </span>
											<form:input type="text" path="cmnd" cssClass="form-control" />
											<br>
											<form:errors cssClass="erorr" path="cmnd" />
										</div>
									</div>
								</div>
								<h4>Thông Tin Chuyến Bay Lựa Chọn :</h4>
								<div class="row">
									<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
										<input name="id" value="${c.maChuyenBay}" type="hidden">
										<div class="form-group">
											<label for="">Tên Chuyến Bay :</label>
											<h4>${c.tenChuyenBay}</h4>
										</div>
										<div class="form-group">
											<label for="">Tên Máy Bay :</label>
											<h4>${c.maMayBay.tenMayBay}</h4>
										</div>
										<div class="form-group">
											<label for="">Giờ Bay :</label>
											<h4>${c.gioBay}</h4>
										</div>
									</div>
									<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
										<div class="form-group">
											<label for="">Điểm Đi :</label>
											<h4>${c.diemDi}</h4>
										</div>
										<div class="form-group">
											<label for="">Điểm Đến :</label>
											<h4>${c.diemDen}</h4>
										</div>
										<div class="form-group">
											<label for="">Ngày Bay :</label>
											<h4>
												<fmt:formatDate pattern="dd-MM-yyyy" value="${c.ngayBay}" />
											</h4>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<span class="form-label">Loại Vé</span> <select
												name="maThongTin" class="form-control">
												<c:forEach items="${list}" var="l">
													<option value="${l.maThongTin }"><c:choose>
															<c:when test="${l.loaiVe==true}">
																<span class="label label-success">Thương Gia</span> : <fmt:formatNumber
																	value="${l.giaVe } " /> VNĐ															
															</c:when>
															<c:otherwise>
																<span class="label label-primary">Thường</span>: <fmt:formatNumber
																	value="${l.giaVe } " /> VNĐ																
															</c:otherwise>
														</c:choose></option>
												</c:forEach>
											</select>
										</div>
									</div>
								</div>
								<div class="form-btn">
									<button class="submit-btn">Đặt Vé</button>
								</div>
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->

</html>