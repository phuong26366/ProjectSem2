<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="../../layout/header.jsp"%>
<style>
.erorr {
	color: red;
}
</style>
<section class="content">
	<!-- Default box -->
	<div class="box">
		<div class="box-header with-border">
			<h3 class="box-title">
				CẬP NHẬT NHÂN VIÊN
				<h3>
					<div class="box-tools pull-right">
						<button type="button" class="btn btn-box-tool"
							data-widget="collapse" data-toggle="tooltip" title="Collapse">
							<i class="fa fa-minus"></i>
						</button>
						<button type="button" class="btn btn-box-tool"
							data-widget="remove" data-toggle="tooltip" title="Remove">
							<i class="fa fa-times"></i>
						</button>
					</div>
		</div>
		<div class="box-body">
			<form:form action="update" method="post" modelAttribute="m"
				enctype="multipart/form-data">
				<div class="row">
					<div class="col-xs-7 col-sm-7 col-md-7 col-lg-7">
						<form:input path="maNhanVien" type="hidden" />
						<div class="form-group">
							<label for="">Tên Nhân Viên :</label>
							<form:input path="tenNhanVien" cssClass="form-control" />
							<br>
							<form:errors path="tenNhanVien" cssClass="erorr" />
						</div>
						<div class="form-group">
							<label for="">Ảnh :</label> <input type="file"
								class="form-control" name="upload" id="upload"
								required="required" placeholder="Ảnh sản phẩm "> <img
								src="" id="show_image" alt="" style="width: 300px">
						</div>
						<div class="form-group">
							<label for=""> Chức Vụ : </label>
							<div class="radio">
								<label> <form:radiobutton path="chucVu" value="true"
										checked="checked" /> <span class="label label-success">Quản
										Lý</span>
								</label>
							</div>
							<div class="radio">
								<label> <form:radiobutton path="chucVu" value="false" /><span
									class="label label-success">Nhân Viên</span>
								</label>
							</div>
							<form:errors path="chucVu" cssClass="erorr" />
						</div>
					</div>
					<div class="col-xs-5 col-sm-5 col-md-5 col-lg-5">
						<div class="form-group">
							<label for="">Địa Chỉ :</label>
							<form:input path="diaChi" cssClass="form-control" />
							<br>
							<form:errors path="diaChi" cssClass="erorr" />
						</div>
						<div class="form-group">
							<label for="">Số Điện Thoại</label>
							<form:input path="soDienThoai" cssClass="form-control" />
							<br>
							<form:errors path="soDienThoai" cssClass="erorr" />
						</div>
						<div class="form-group">
							<label for="">Tài Khoản </label>
							<form:input path="userName" cssClass="form-control" />
							<br>
							<form:errors path="userName" cssClass="erorr" />
						</div>
						<div class="form-group">
							<label for="">Mật Khẩu </label>
							<form:input path="password" cssClass="form-control" />
							<br>
							<form:errors path="password" cssClass="erorr" />
						</div>
					</div>
				</div>
				<button type="submit" class="btn btn-success">Cập Nhật</button>
			</form:form>
		</div>
	</div>
	<!-- /.box -->
</section>
<%@ include file="../../layout/footer.jsp"%>