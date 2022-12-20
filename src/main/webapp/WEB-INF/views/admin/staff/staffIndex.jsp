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
			<form action="searchProducts" method="post" class="form-inline"
				role="form">
				<div class="form-group">
					<input oninput="searchByName(this)" id="content" type="text"
						name="key" class="form-control" placeholder="">
				</div>
				<button type="submit" class="btn btn-primary">
					<i class="fa fa-search" aria-hidden="true"></i>
				</button>
				<a href="${pageContext.request.contextPath}/staff/initInsert"
					class="btn btn-success btn-sm">Thêm Mới Nhân Viên</a>
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
						<th>Mã Nhân Viên</th>
						<th>Ảnh</th>
						<th>Tên Nhân Viên</th>
						<th>Số Điện Thoại</th>
						<th>Địa Chỉ</th>
						<th>Tài Khoản</th>
						<th>Mật Khẩu</th>
						<th>Chức Vụ</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${pros}" var="p">
						<tr>
							<td>${p.maNhanVien }</td>
							<td><img
								src="<c:url value="/resources/images/${p.image }"/>"
								width="60px"></td>
							<td>${p.tenNhanVien }</td>
							<td>${p.soDienThoai }</td>
							<td>${p.diaChi }</td>
							<td>${p.userName }</td>
							<td>${p.password }</td>
							<td><c:choose>
									<c:when test="${p.chucVu==true}">
										<span class="label label-success">Quản Lý</span>
									</c:when>
									<c:otherwise>
										<span class="label label-primary">Nhân Viên</span>
									</c:otherwise>
								</c:choose></td>
							<td><a
								href="${pageContext.request.contextPath}/staff/delete?id=${p.maNhanVien}"
								class="btn btn-danger btn-sm"
								onclick="return confirm('Bạn có muốn xóa không ?')">Xóa</a> <a
								href="${pageContext.request.contextPath}/staff/preUpdate?id=${p.maNhanVien}"
								class="btn btn-success btn-sm">Cập Nhật</a> <a
								href="${pageContext.request.contextPath}/staff/info?id=${p.maNhanVien}"
								class="btn btn-info btn-sm">Chi Tiết</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<!-- /.box-body -->
		<div class="box-footer text-center">
			<nav aria-label="Page navigation ">
				<ul class="pagination">
					<c:forEach begin="1" end="${Math.ceil(totalRecords/pageSize)}"
						var="i">
						<li class="page-item"><a class="page-link" id="${i}"
							href="${pageContext.request.contextPath}/staff?<c:if test="${name != ''}">name=${name}&</c:if>page=${i}">${i}</a>
						</li>
					</c:forEach>
				</ul>
			</nav>
		</div>
		<!-- /.box-footer-->
	</div>
	<!-- /.box -->
</section>
<%@ include file="../../layout/footer.jsp"%>