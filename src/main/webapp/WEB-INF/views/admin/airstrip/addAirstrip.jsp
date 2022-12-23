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
			<h3 class="box-title">THÊM MỚI ĐƯỜNG BAY</h3>
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
			<div class="row">
				<form:form action="insert" method="post" modelAttribute="m">
					<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
						<div class="form-group">
							<label for="">Tên Đường Bay :</label>
							<form:input path="tenDuongBay" cssClass="form-control" />
							<br>
							<form:errors path="tenDuongBay" cssClass="erorr" />
						</div>
						<div class="form-group">
							<label for="">Vị Trí :</label>
							<form:input path="viTri" cssClass="form-control" />
							<br>
							<form:errors path="viTri" cssClass="erorr" />
						</div>
						<div class="form-group">
							<label for="">Trạng Thái:</label> <br>
							<form:radiobutton path="trangThai" value="true" />
							<span class="label label-success">Hoạt Động</span>
							<div></div>
							<form:radiobutton path="trangThai" value="false" />
							<span class="label label-success">Bảo Trì</span> <br>
							<form:errors path="trangThai" cssClass="erorr" />
						</div>
					</div>
					<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
						<div class="form-group">
							<label for="">Chiều Dài :</label>
							<form:input path="chieuDai" cssClass="form-control" />
							<br>
							<form:errors path="chieuDai" cssClass="erorr" />
						</div>
						<div class="form-group">
							<label for="">Chiều Rộng :</label>
							<form:input path="chieuRong" cssClass="form-control" />
							<br>
							<form:errors path="chieuRong" cssClass="erorr" />
						</div>
					</div>
			</div>

			<button type="submit" class="btn btn-success">Thêm Mới</button>
			</form:form>
		</div>
	</div>
	<!-- /.box -->
</section>
<%@ include file="../../layout/footer.jsp"%>