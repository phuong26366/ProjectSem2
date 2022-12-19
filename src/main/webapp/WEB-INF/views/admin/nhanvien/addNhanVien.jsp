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
			<form action="" method="POST" role="form" enctype="multipart/form-data">
            <legend>Thêm Mới Nhân Viên</legend>
            <div class="row">
                <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                    <div class="form-group">
                        <label for="">Tên Nhân Viên :</label>
                        <input type="text" class="form-control" id="" placeholder="Input field">
                    </div>
                    <div class="form-group">
                        <label for="">Ảnh :</label>
                        <input type="file" class="form-control" id="" placeholder="Input field">
                    </div>
                    <div class="form-group">
                        <label for="">Số Điện Thoại:</label>
                        <input type="text" class="form-control" value="" id="" placeholder="Input field">
                    </div>
                    <div class="form-group">
                        <label for="">Địa Chỉ:</label>
                        <input type="text" class="form-control" id="" placeholder="Input field">
                    </div>
                    <label for="">Chức Vụ :</label>
                    <div class="radio">
                        <label>
                            <input type="radio" name="chucvu" value="0" checked>
                            Quản Lý
                        </label>
                    </div>
                    <div class="radio">
                        <label>
                            <input type="radio" name="chucvu" value="1">
                            Nhân Viên
                        </label>
                    </div>
                </div>
                <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                    <div class="form-group">
                        <label for="">Tài Khoản :</label>
                        <input type="text" class="form-control" id="" placeholder="Input field">
                    </div>
                    <div class="form-group">
                        <label for="">Mật Khẩu :</label>
                        <input type="text" class="form-control" id="" placeholder="Input field">
                    </div>
                    <div class="form-group">
                        <label for="">Ghi chú :</label>
                        <input type="t" class="form-control" id="" placeholder="Input field">
                    </div>
                    <label for="">Trang Thái :</label>
                    <div class="radio">
                        <label>
                            <input type="radio" name="status" value="0" checked>
                            Ẩn 
                        </label>
                    </div>
                    <div class="radio">
                        <label>
                            <input type="radio" name="status" value="1">
                           Hiện
                        </label>
                    </div>
                </div>
            </div>
            <button type="submit" class="btn btn-success">Thêm Mới</button>
        </form>

			
		</div>
	</div>
	<!-- /.box -->
</section>
<%@ include file="../../layout/footer.jsp"%>