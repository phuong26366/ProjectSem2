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
			<form action="" method="get" class="form-inline" role="form">
				<div class="row">
					<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
						<div class="form-group">
							<label for="">Chọn ngày bắt đầu :</label> <input type="date"
								name="start" class="form-control"
								placeholder="Nhập ngày bắt đầu ">
						</div>
					</div>
					<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
						<div class="form-group">
							<label for="">Chọn ngày kết thúc:</label> <input type="date"
								name="end" class="form-control"
								placeholder="Nhập ngày kết thúc ">
						</div>
						<button type="submit" class="btn btm-sm btn-primary">Thống Kê</button>
					</div>
				</div>



			</form>
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
					<c:forEach items="${pros }" var="p">
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