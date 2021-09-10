 <%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tiếng Anh Mỗi Ngày</title>
<!-- bootstrap & fontawesome -->
		<link rel="stylesheet" href="template/Backend/assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="template/Backend/assets/font-awesome/4.5.0/css/font-awesome.min.css" />

		<!-- text fonts -->
		<link rel="stylesheet" href="template/Backend/assets/css/fonts.googleapis.com.css" />

		<!-- ace styles -->
		<link rel="stylesheet" href="template/Backend/assets/css/ace.min.css" />

		
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
									<span class="red">English</span>
									<span class="white" id="id-text2">mỗi ngày</span>
								</h1>
															</div>

							<div class="space-6"></div>

							<div class="position-relative">
								<div id="login-box" class="login-box visible widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header blue lighter bigger">
											
												<i class="ace-icon fa fa-coffee green"></i>
												Please Enter Your Information
											</h4>

											<div class="space-6"></div>

											<form action="checkPass" method="post">
												<fieldset>
												<span style="color: red">${messageError}</span>
												
													

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" class="form-control" placeholder="Mật khẩu" name="memberpass"/>
															<i class="ace-icon fa fa-lock"></i>
														</span>
													</label>

													<div class="space"></div>

													<div class="clearfix">
														
														<button type="submit" class="width-35 pull-right btn btn-sm btn-primary">
															<i class="ace-icon fa fa-key"></i>
															<span class="bigger-110">Đăng nhập</span>
														</button>
													</div>

													<div class="space-4"></div>
												</fieldset>
											</form>

											

											<div class="space-6"></div>

											
										</div><!-- /.widget-main -->

										<div class="toolbar clearfix">
											<div>
												<a href="homeforward"  class="forgot-password-link">
													<i class="ace-icon fa fa-arrow-left"></i>
													Trở về trang chủ
												</a>
											</div>

											<div>
												<a href="Registerforward"  class="user-signup-link">
													Đăng ký
													<i class="ace-icon fa fa-arrow-right"></i>
												</a>
											</div>
										</div>
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

	
		
</body>
</html>