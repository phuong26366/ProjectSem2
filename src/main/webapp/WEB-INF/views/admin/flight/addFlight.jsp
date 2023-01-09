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
			<h3 class="box-title">THÊM MỚI CHUYẾN BAY</h3>
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
			<form:form action="insert" modelAttribute="c" method="post">
				<div class="row">
					<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
						<div class="form-group">
							<label for="">Chọn Đường Bay :</label>
							<form:select path="maDuongBay.maDuongBay" cssClass="form-control">
								<form:options items="${d}" itemLabel="tenDuongBay"
									itemValue="maDuongBay" />
							</form:select>
							<br>
							<form:errors cssClass="erorr" path="maDuongBay" />
						</div>
						<div class="form-group">
							<label for="">Chọn May Bay :</label>
							<form:select path="maMayBay.maMayBay" cssClass="form-control">
								<form:options items="${m}" itemLabel="tenMayBay"
									itemValue="maMayBay" />
							</form:select>
							<br>
							<form:errors cssClass="erorr" path="maMayBay" />
						</div>
						<div class="form-group">
							<label for="">Tên Chuyến Bay:</label>
							<form:input type="text" path="tenChuyenBay"
								cssClass="form-control" />
							<br>
							<form:errors cssClass="erorr" path="tenChuyenBay" />
						</div>
						<div class="form-group">
							<label for="">Giờ Bay:</label>
							<form:input type="time" path="gioBay" cssClass="form-control" />
							<br>
							<form:errors cssClass="erorr" path="gioBay" />
						</div>
					</div>
					<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
						<div class="form-group">
							<label for="">Ngày Bay :</label>
							<form:input type="date" path="ngayBay" id="txtDate"
								cssClass="form-control" />
							<br>
							<form:errors cssClass="erorr" path="ngayBay" />
						</div>
						<div class="form-group">
							<label for="">Điểm Đi :</label>
							<form:input path="diemDi" cssClass="form-control" />
							<br>
							<form:errors cssClass="erorr" path="diemDi" />
						</div>
						<div class="form-group">
							<label for="">Điểm Đến :</label>
							<form:input path="diemDen" cssClass="form-control" />
							<br>
							<form:errors cssClass="erorr" path="diemDen" />
						</div>
						<label for="">Trạng Thái :</label>
						<form:errors cssClass="erorr" path="trangThai" />
						<div class="radio">
							<label><form:radiobutton path="trangThai" value="true" />
								<span class="label label-success">Sắp Bay</span> </label>
						</div>
						<div class="radio">
							<label><form:radiobutton path="trangThai" value="false" />
								<span class="label label-danger">Đã Bay</span> </label>
						</div>
					</div>
				</div>
				<button type="submit" class="btn btn-info">Thêm Mới</button>
			</form:form>
		</div>
	</div>
	<!-- /.box -->
</section>
<%@ include file="../../layout/footer.jsp"%>