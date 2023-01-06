
</div>
<!-- /.content-wrapper -->


</div>
<!-- ./wrapper -->

<!-- jQuery 3 -->

<script src="${pageContext.request.contextPath}/css/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/css/js/jquery-ui.js"></script>
<script src="${pageContext.request.contextPath}/css/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/css/js/adminlte.min.js"></script>
<script src="${pageContext.request.contextPath}/css/js/dashboard.js"></script>
<script
	src="${pageContext.request.contextPath}/css/tinymce/tinymce.min.js"></script>
<script src="${pageContext.request.contextPath}/css/tinymce/config.js"></script>
<script src="${pageContext.request.contextPath}/css/js/function.js"></script>
<script>
	document.getElementById('${page}').style.backgroundColor = "CornflowerBlue";
	document.getElementById('${page}').style.color = "black";
</script>
<script>
	$('#upload').change(function(ev) {
		var input = $(this)[0];
		console.log(input);
		if (input.files && input.files[0]) {
			var reader = new FileReader();
			reader.onload = function(e) {
				$('#show_image').attr('src', e.target.result);
			};
			reader.readAsDataURL(input.files[0]);
		}
	})
</script>
<script>
	$(function() {
		var dtToday = new Date();
		var month = dtToday.getMonth() + 1;
		var day = dtToday.getDate();
		var year = dtToday.getFullYear();
		if (month < 10)
			month = '0' + month.toString();
		if (day < 10)
			day = '0' + day.toString();
		var maxDate = year + '-' + month + '-' + day;

		// or instead:
		// var maxDate = dtToday.toISOString().substr(0, 10);
		$('#txtDate').attr('min', maxDate);
	});
</script>
</body>
</html>
