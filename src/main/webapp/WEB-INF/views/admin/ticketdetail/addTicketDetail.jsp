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
			<h3 class="box-title">THÊM MỚI THÔNG TIN VÉ</h3>
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
			<form:form action="insert" method="post" modelAttribute="m">
				<div class="row">
					<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
						<div class="form-group">
						<form:input path="maThongTin" type="hidden" />
							<label for="">Chọn Mã Chuyến Bay :</label>
							<form:select path="maChuyenBay.maChuyenBay"
								cssClass="form-control">
								<form:options items="${chuyenBays}" itemLabel="maChuyenBay"
									itemValue="maChuyenBay" />
							</form:select>
						</div>
						<div class="form-group">
							<label for="">Loại Vé :</label>
							<form:input path="loaiVe" cssClass="form-control" />
							<br>
							<form:errors path="loaiVe" cssClass="erorr" />
						</div>
						<div class="form-group">
							<label for="">Giá Vé :</label>
							<form:input path="giaVe" cssClass="form-control" />
							<br>
							<form:errors path="giaVe" cssClass="erorr" />
						</div>
					</div>
					<button type="submit" class="btn btn-success">Thêm Mới</button>
				</div>

			</form:form>


		</div>
	</div>
	<!-- /.box -->
</section>
<%@ include file="../../layout/footer.jsp"%>