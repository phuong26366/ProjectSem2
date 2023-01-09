<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../../layout/header.jsp"%>

<section class="content">
	<!-- Default box -->
	<div class="box">

		<div class="box-body">
			<div class="row">
				<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
					<img src="<c:url value="/resources/images/${s.image }"/>"
						width="300px"> <br> <br>
				</div>
				<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
					<h2 class="text-center">CÔNG TY CỔ PHẦN VIỆT ANH</h2>
					<h4 class="text-center">Thôn 3 - Lại Yên - Hoài Đức - Hà Nội</h4>
					<h4 class="text-center">Điện thoại : 0385201482 Website:
						abc.com.vn</h4>
					<h3 class="text-center">Phiếu Nhân SỰ</h3>
					<h4 class="text-center">Thông Tin Nhân Viên</h4>
				</div>
			</div>

			<h2>Thông Tin Cá Nhân :</h2>
			<br>
			<h4>Mã Nhân Viên : ${s.maNhanVien }</h4>
			<br>Họ và Tên : ${s.tenNhanVien }<br> <br>Số điện
			thoại : ${s.soDienThoai } <br> <br>Địa Chỉ : ${s.diaChi } <br>
			<br>Chức Vụ :
			<c:choose>
				<c:when test="${p.chucVu==true}">
					<span class="label label-success">Quản Lý</span>
				</c:when>
				<c:otherwise>
					<span class="label label-primary">Nhân Viên</span>
				</c:otherwise>
			</c:choose>


		</div>
		<!-- /.box-body -->

		<!-- /.box-footer-->
	</div>
	<!-- /.box -->
</section>
<%@ include file="../../layout/footer.jsp"%>