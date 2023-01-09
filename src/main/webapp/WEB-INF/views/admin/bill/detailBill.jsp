<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="../../layout/header.jsp"%>
<section class="content">
	<div class="box">
		<div class="box-body">
			<h1 class="text-center">HÓA ĐƠN VÉ MÁY BAY</h1>
			<br>
			<div class="row">

				<div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
					<h4 class="text-left">Hàng Không Việt Nam Ariline</h4>
					<h4 class="text-left">Địa chỉ : 200 Nguyễn Sơn - Bồ Đề - Long
						Biên - Hà Nội</h4>
					<h4 class="text-left">WebSite : http://www.google.com</h4>
					<h4 class="text-left">Điện Thoại : 083224324</h4>
				</div>

				<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
					<h4>Tên Khách Hàng : ${b.maKhachHang.tenKhachHang }</h4>
					<h4>Số Điện Thoại : ${b.maKhachHang.soDienThoai}</h4>
					<h4>CCCD : ${b.maKhachHang.cmnd}</h4>
					<h4>Địa Chỉ : ${b.maKhachHang.diaChi}</h4>
				</div>
			</div>
			<br>
			<h3>Bảng chi tiết vé :</h3>
			<br>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Mã Hóa Đơn</th>
						<th>Tên Chuyến Bay</th>
						<th>Mã Khách Hàng</th>
						<th>loại Vé</th>
						<th>Giá Vé</th>
						<th>Ngày Lập</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${b.maHoaDon}</td>
						<td>${b.maChuyenBays.tenChuyenBay}</td>
						<td>${b.maKhachHang.maKhachHang}</td>
						<td><c:choose>
								<c:when test="${b.maThongTin.loaiVe==true}">
									<span class="label label-success">Thương Gia</span>
								</c:when>
								<c:otherwise>
									<span class="label label-primary">Thường</span>
								</c:otherwise>
							</c:choose></td>
						<td>${b.maThongTin.giaVe}</td>
						<td><fmt:formatDate pattern="dd-MM-yyyy HH:mm:ss"
								value="${b.tGlap }" /></td>
					</tr>
				</tbody>
			</table>
			<br>
			
		</div>
	</div>
</section>

<%@ include file="../../layout/footer.jsp"%>