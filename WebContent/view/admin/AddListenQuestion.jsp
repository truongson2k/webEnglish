<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm câu hỏi bài nghe</title>
<!-- bootstrap & fontawesome -->
		<link rel="stylesheet" href="template/Backend/assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="template/Backend/assets/font-awesome/4.5.0/css/font-awesome.min.css" />

		<!-- text fonts -->
		<link rel="stylesheet" href="template/Backend/assets/css/fonts.googleapis.com.css" />

		<!-- ace styles -->
		<link rel="stylesheet" href="template/Backend/assets/css/ace.min.css" />

		<!--[if lte IE 9]>
			<link rel="stylesheet" href="assets/css/ace-part2.min.css" />
		<![endif]-->
		<link rel="stylesheet" href="template/Backend/assets/css/ace-rtl.min.css" />

</head>
<body class="login-layout">

<div class="main-container">
			<div class="main-content">
				<div class="row">
					<div class="col-sm-10 col-sm-offset-1">
						<div class="login-container">
							<div class="center">
								<h1>
									<i class="ace-icon fa fa-leaf green"></i>
									<span class="red">Ace</span>
									<span class="white" id="id-text2">Application</span>
								</h1>
								<h4 class="blue" id="id-company-text">&copy; Company Name</h4>
							</div>

							<div class="space-6"></div>

							<div class="position-relative">
								<div id="login-box" class="login-box visible widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header blue lighter bigger">
												<i class="ace-icon fa fa-coffee green"></i>
												Thêm câu hỏi bài nghe
											</h4>

											<div class="space-6"></div>

										<form action="AddListenQuestion?idlistenexercise=<%=request.getAttribute("idlistenexercise") %>" method="post" enctype="multipart/form-data">
												<fieldset>
												<span style="color: red">${messageError}</span>
												  <label class="block clearfix">
												  <%=request.getAttribute("msglistenquestion")!=null?request.getAttribute("msglistenquestion"):""%>
												  </label>
													<label class="block clearfix">
														Thêm file:<input type="file" name="file" class="btn btn-white btn-warning btn-bold">
													</label>

													

													<div class="space"></div>

													<div class="clearfix">
														
														<button type="submit" class="width-70 pull-right btn btn-sm btn-primary">
															<i class="ace-icon fa fa-key"></i>
															<span class="bigger-110">Thêm câu hỏi bài nghe</span>
														</button>
													</div>

													<div class="space-4"></div>
												</fieldset>
											</form>

											

											<div class="space-6"></div>

											
										</div><!-- /.widget-main -->

										
									</div><!-- /.widget-body -->
								</div><!-- /.login-box -->

							

							</div><!-- /.position-relative -->

							
						</div>
					</div><!-- /.col -->
				</div><!-- /.row -->
			</div><!-- /.main-content -->
		</div><!-- /.main-container -->


<script src="template/Backend/assets/js/jquery-2.1.4.min.js"></script>

		<script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='template/Backend/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>

	
		<script type="text/javascript">
			jQuery(function($) {
			 $(document).on('click', '.toolbar a[data-target]', function(e) {
				e.preventDefault();
				var target = $(this).data('target');
				$('.widget-box.visible').removeClass('visible');//hide others
				$(target).addClass('visible');//show target
			 });
			});
			
			
		</script>
</body>
</html>