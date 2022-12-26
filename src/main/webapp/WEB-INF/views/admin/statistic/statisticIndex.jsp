<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../../layout/header.jsp"%>

<section class="content">
	<!-- Default box -->
	<div class="box">
		<div class="box-header with-border">
			<h3 class="box-title"></h3>
		</div>
		<div class="box-body">
			<div class="row">

				<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
					<h2 class="text-center">Hàng Không Việt Nam Ariline</h2>
					<h4 class="text-center">Địa chỉ : 200 Nguyễn Sơn - Bồ Đề -
						Long Biên - Hà Nội</h4>
					<h4 class="text-center">WebSite : http://www.google.com</h4>
					<h4 class="text-center">Điện Thoại : 083224324 /</h4>
				</div>
				<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
					<p class="text-right">Seri: 902318238</p>
					<p class="text-right">Ký Hiệu : VAL/988</p>
					<p class="text-right">Số XB : 2023</p>
					<p class="text-right">Mã DN : 01000231</p>
				</div>
			</div>
			<br> <br> <br>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Mã Hóa Đơn</th>
						<th>Tên Chuyến Bay</th>
						<th>Ngày Lập</th>
						<th>Tiền Thanh Toán</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach  items="${pros }" var="p" >
						<tr>
							<td>${p.maHoaDon }</td>
							<td>${p.maChuyenBays.tenChuyenBay }</td>
							<td><fmt:formatDate pattern="dd-MM-yyyy" value="${p.tGlap }" />
							</td>
							<td><fmt:formatNumber value="${p.maThongTin.giaVe }" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<br> <br>

			<div class="row">
				<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6"></div>
				<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6 ">
					<table class="text-right" border="1">
						<tr>
							<th>Tổng Doanh Thu :</th>
							<th><fmt:formatNumber value="${tt }" /> VNĐ</th>
						</tr>
					</table>
				</div>
			</div>
		</div>
		<!-- /.box-body -->

		<!-- /.box-footer-->
	</div>
	<!-- /.box -->
</section>
<%@ include file="../../layout/footer.jsp"%>