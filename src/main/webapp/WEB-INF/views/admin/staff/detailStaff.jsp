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
						width="300px"> <br>
					<br>	
				</div>
				<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
					<h2 class="text-center">CÔNG TY CỔ PHẦN ABC</h2>
					<h4 class="text-center">58 Lê Quang Đạo - Nam Từ Niêm - Hà Nôi
					</h4>
					<h4 class="text-center">Điện thoại : 091231231233 Website:
						abc.com.vn</h4>
					<h3 class="text-center">PHIẾU NHÂN SỰ</h3>
					<h4 class="text-center">NHÂN VIÊN BÁN VÉ</h4>
				</div>
			</div>

			<h2>Thông Tin Cá Nhân :</h2><br>
			<h4 >Mã Nhân Viên : ${s.maNhanVien }</h4> 
			<br> Họ và Tên : ${s.tenNhanVien }<br>
			<br> Số điện thoại : ${s.soDienThoai } <br>
			<br>Địa Chỉ : ${s.diaChi } <br>
			<br>Chức Vụ : ${s.chucVu }


		</div>
		<!-- /.box-body -->

		<!-- /.box-footer-->
	</div>
	<!-- /.box -->
</section>
<%@ include file="../../layout/footer.jsp"%>