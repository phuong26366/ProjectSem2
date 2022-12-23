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
			<h3 class="box-title">THÊM MỚI MÁY BAY</h3>
			<div class="box-tools pull-right">
				<button type="button" class="btn btn-box-tool"
					data-widget="collapse" data-toggle="tooltip" title="Collapse">
					<i class="fa fa-minus"></i>
				</button>
				<button type="button" class="btn btn-box-tool" data-widget="remove"
					data-toggle="tooltip" title="Remove">
					<i class="fa fa-times"></i>
				</button>
			</div>
		</div>
		<div class="box-body">
			<form:form action="update" modelAttribute="m" method="post">
				<div class="row">
					<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
						<div class="form-group">
							<form:input path="maMayBay" type="hidden" />
							<label for="">Tên Máy Bay :</label>
							<form:input path="tenMayBay" cssClass="form-control" />
							<br>
							<form:errors path="tenMayBay" cssClass="erorr" />
						</div>
						<div class="form-group">
							<label for="">Hãng Sản Xuất :</label>
							<form:input path="hangSanXuat" cssClass="form-control" />
							<br>
							<form:errors path="hangSanXuat" cssClass="erorr" />
						</div>
						<div class="form-group">
							<label for="">Kích Thước :</label> <
							<form:input path="kichThuoc" cssClass="form-control" />
							<br>
							<form:errors path="kichThuoc" cssClass="erorr" />
						</div>
						<div class="form-group">
							<label for="">Trạng Thái:</label>
							<form:radiobutton path="trangThai" value="true" />
							<span class="label label-success">Hoạt Động</span>
							<form:radiobutton path="trangThai" value="false" />
							<span class="label label-success">Bảo Trì</span> <br>
							<form:errors path="trangThai" cssClass="erorr" />
						</div>
					</div>
					<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
						<div class="form-group">
							<label for="">Số Ghế Loại 1 :</label>
							<form:input path="soGheL1" cssClass="form-control" />
							<br>
							<form:errors path="soGheL1" cssClass="erorr" />
						</div>
						<div class="form-group">
							<label for="">Số Ghế Loại 2 :</label>
							<form:input path="soGheL2" cssClass="form-control" />
							<br>
							<form:errors path="soGheL2" cssClass="erorr" />
						</div>
						<div class="form-group">
							<label for="">Tổng Ghế :</label>
							<form:input path="tongGhe" cssClass="form-control" />
							<br>
							<form:errors path="tongGhe" cssClass="erorr" />
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