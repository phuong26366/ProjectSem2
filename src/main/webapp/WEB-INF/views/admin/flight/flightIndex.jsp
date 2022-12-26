<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="../../layout/header.jsp"%>
<section class="content">
	<div class="box">
		<div class="box-header with-border">
			<h3 class="box-title"></h3>
			<form action="" method="get" class="form-inline" role="form">
				<div class="form-group">
					<input oninput="searchByName(this)" id="content" type="text"
						name="name" class="form-control" placeholder="Tìm kiếm ...">
				</div>
				<button type="submit" class="btn btn-primary">
					<i class="fa fa-search" aria-hidden="true"></i>
				</button>
				<a href="${pageContext.request.contextPath}/flight/initInsert"
					class="btn btn-info">Thêm mới</a>
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
						<th>Mã Chuyến Bay</th>
						<th>Tên Máy Bay</th>
						<th>Tên Chuyến Bay</th>
						<th>Ngày Bay</th>
						<th>Giờ Bay</th>
						<th>Điểm Đi</th>
						<th>Điểm Đến</th>
						<th>Trạng Thái</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${pros}" var="pro">
						<tr>
							<td>${pro.maChuyenBay}</td>
							<td>${pro.maMayBay.tenMayBay}</td>
							<td>${pro.tenChuyenBay}</td>
							<td><fmt:formatDate pattern="dd-MM-yyyy"
									value="${pro.ngayBay}" /></td>
							<td>${pro.gioBay}</td>
							<td>${pro.diemDi}</td>
							<td>${pro.diemDen}</td>
							<td><c:choose>
									<c:when test="${pro.trangThai==true}">
										<span class="label label-success">Sắp Bay</span>
									</c:when>
									<c:otherwise>
										<span class="label label-danger">Đã Bay</span>
									</c:otherwise>
								</c:choose></td>
							<td><a class="btn btn-small btn-success"
								href="${pageContext.request.contextPath}/flight/preUpdate?id=${pro.maChuyenBay}">Cập
									Nhật</a> <a class="btn btn-small btn-danger"
								href="${pageContext.request.contextPath}/flight/delete?id=${pro.maChuyenBay}"
								onclick="return confirm('Bạn có muốn xóa không ?')">Xóa</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<!-- /.box-body -->
		<!-- /.box-footer-->
		<div class="box-footer text-center">
			<nav aria-label="Page navigation ">
				<ul class="pagination">
					<c:forEach begin="1" end="${Math.ceil(totalRecords/pageSize)}"
						var="i">
						<li class="page-item"><a class="page-link" id="${i}"
							href="${pageContext.request.contextPath}/flight?<c:if test="${name != ''}">name=${name}&</c:if>page=${i}">${i}</a>
						</li>
					</c:forEach>
				</ul>
			</nav>
		</div>
	</div>
</section>

<%@ include file="../../layout/footer.jsp"%>