<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="../../layout/header.jsp"%>
<style>
.erorr {
	color: red;
}
</style>
<section class="content">
	<!-- Default box -->
	<div class="box">
		<div class="box-header with-border"></div>
		<div class="box-body">

			<form:form action="insert" method="post" modelAttribute="m">
				<div class="row">
					<div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
						<h4>Nhập Thông Tin Khách Hàng</h4>
						<div class="row">
							<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
								<div class="form-group">
									<label for="">Tên Khách Hàng :</label>
									<form:input type="text" path="tenKhachHang"
										cssClass="form-control" />
									<br>
									<form:errors cssClass="erorr" path="tenKhachHang" />
								</div>
							</div>
							<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
								<div class="form-group">
									<label for="">Số Điện Thoại :</label>
									<form:input type="text" path="soDienThoai"
										cssClass="form-control" />
									<br>
									<form:errors cssClass="erorr" path="soDienThoai" />
								</div>
							</div>
							<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
								<div class="form-group">
									<label for="">Địa Chỉ :</label>
									<form:input type="text" path="diaChi" cssClass="form-control" />
									<br>
									<form:errors cssClass="erorr" path="diaChi" />
								</div>
							</div>
							<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
								<div class="form-group">
									<label for="">Căn Cước Công Dân :</label>
									<form:input type="text" path="cmnd" cssClass="form-control" />
									<br>
									<form:errors cssClass="erorr" path="cmnd" />
								</div>
							</div>
						</div>
						<h4>Nhập Thông Tin Vé Cần Mua</h4>

						<div class="row">
							<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
								<div class="form-group">
									<label for="">Chọn Mã Chuyến Bay:</label> <input type="text"
										class="form-control" id="" placeholder="Input field">
								</div>
							</div>

						</div>

						<div class="row">
							<h4>Thông Tin Chuyến Bay Lựa Chọn :</h4>
							<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
								<div class="form-group">
									<label for="">Mã Đường Bay :</label> <input type="text"
										class="form-control" id="" placeholder="Input field">
								</div>
								<div class="form-group">
									<label for="">Mã Máy Bay :</label> <input type="text"
										class="form-control" id="" placeholder="Input field">
								</div>
								<div class="form-group">
									<label for="">Giờ Bay :</label> <input type="text"
										class="form-control" id="" placeholder="Input field">
								</div>
							</div>
							<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
								<div class="form-group">
									<label for="">Ngày Đi :</label> <input type="text"
										class="form-control" id="" placeholder="Input field">
								</div>
								<div class="form-group">
									<label for="">Ngày Đến :</label> <input type="text"
										class="form-control" id="" placeholder="Input field">
								</div>
							</div>
							<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
								<div class="form-group">
									<label for="">Điểm Đi :</label> <input type="text"
										class="form-control" id="" placeholder="Input field">
								</div>
								<div class="form-group">
									<label for="">Điểm Đến :</label> <input type="text"
										class="form-control" id="" placeholder="Input field">
								</div>
								<div class="form-group">
									<label for="">Ghi Chú :</label> <input type="text"
										class="form-control" id="" placeholder="Input field">
								</div>
							</div>
						</div>
						<div class="row">
							<h4>Thông Tin Vé Chuyến Bay :</h4>
							<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
								<div class="form-group">
									<label for="">Loại Vé :</label> <input type="text"
										class="form-control" id="" placeholder="Input field">
								</div>
							</div>
							<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
								<div class="form-group">
									<label for="">Giá Vé :</label> <input type="text"
										class="form-control" id="" placeholder="Input field">
								</div>
							</div>

						</div>

					</div>


					<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
						<br>
						<h4>Thông tin vé chọn</h4>
						<br>

						<div class="row">
							<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
								<label for="">Điểm Đi :</label>
							</div>
							<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">Hà Nội</div>

						</div>
						<div class="row">
							<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
								<label for="">Điểm Đến :</label>
							</div>
							<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">Sài Gòn</div>
						</div>
						<div class="row">
							<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
								<label for="">Loại Vé: </label>
							</div>
							<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">Loại Vé 2
							</div>
						</div>
						<div class="row">
							<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
								<label for="">Giá Vé: </label>
							</div>
							<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">450000</div>
						</div>
						<div class="row">
							<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
								<label for="">Thành Tiền: </label>
							</div>
							<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">450000</div>
						</div>
						<br>

					</div>
				</div>
				<button type="submit" class="btn btn-primary text-center">Hoàn
					Thành Đặt Vé</button>
			</form:form>

		</div>
	</div>

	<!-- /.box-body -->

	<!-- /.box-footer-->
	</div>
	<!-- /.box -->
</section>
<%@ include file="../../layout/footer.jsp"%>