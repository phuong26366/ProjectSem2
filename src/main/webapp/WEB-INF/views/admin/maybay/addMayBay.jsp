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
			 <form action="" method="POST" role="form">
            <div class="row">

                <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                    <div class="form-group">
                        <label for="">Tên Máy Bay :</label>
                        <input type="text" class="form-control" id="" placeholder="Input field">
                    </div>
                    <div class="form-group">
                        <label for="">Hãng Sản Xuất :</label>
                        <input type="text" class="form-control" id="" placeholder="Input field">
                    </div>
                    <div class="form-group">
                        <label for="">Kích Thước :</label>
                        <input type="text" class="form-control" id="" placeholder="Input field">
                    </div>
                </div>
                <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                    <div class="form-group">
                        <label for="">Số Ghế Loại 1 :</label>
                        <input type="text" class="form-control" id="" placeholder="Input field">
                    </div>
                    <div class="form-group">
                        <label for="">Số Ghế Loại 2 :</label>
                        <input type="text" class="form-control" id="" placeholder="Input field">
                    </div>
                    <div class="form-group">
                        <label for="">Tổng Ghế :</label>
                        <input type="text" class="form-control" id="" placeholder="Input field">
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