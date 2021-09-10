<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tiếng Anh Mỗi Ngày - Quản Lý</title>
       <link rel="stylesheet" href="template/Backend/assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="template/Backend/assets/font-awesome/4.5.0/css/font-awesome.min.css" />

		
		<link rel="stylesheet" href="template/Backend/assets/css/colorbox.min.css" />

		
		<link rel="stylesheet" href="template/Backend/assets/css/fonts.googleapis.com.css" />

		
		<link rel="stylesheet" href="template/Backend/assets/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />

		
		<link rel="stylesheet" href="template/Backend/assets/css/ace-skins.min.css" />
		<link rel="stylesheet" href="template/Backend/assets/css/ace-rtl.min.css" />

		
		<script src="template/Backend/assets/js/ace-extra.min.js"></script>

       <style type="text/css">
       .paddingtop-image
       {
       padding-top:85px;
       }
       </style>
		
	</head>

<body class="no-skin">
	
	<!-- Header -->
		<jsp:include page="Headeradmin.jsp"/>
<!--End Header -->

		<div class="main-container ace-save-state" id="main-container">
			<script type="text/javascript">
				try{ace.settings.loadState('main-container')}catch(e){}
			</script>
			
<!-- Begin Menu -->
		<jsp:include page="Menu.jsp"/>
<!-- End Menu -->

<!-- Begin Content -->
			<div class="main-content">
				<div class="main-content-inner">
					<div class="breadcrumbs ace-save-state" id="breadcrumbs">
						<ul class="breadcrumb">
							<li>
								<i class="ace-icon fa fa-home home-icon"></i>
								<a href="Adminforward">Trang Chủ</a>
							</li>
							
						</ul><!-- /.breadcrumb -->

						
					</div>

<div class="page-content">

   <div class="row">
	 <div class="col-xs-12">
	  
	  <center class="paddingtop-image">
	   <img width="500" height="250" alt="150x150" src="template/Backend/assets/images/homeadmin.png" /> 
	   </center> 
	    
	 </div>
 </div>
  </div>
				</div>
			</div><!-- /.main-content -->
<!-- End Content -->

<!-- Begin Footer -->
			<jsp:include page="Footeradmin.jsp"/>
<!-- End Footer -->

			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
			</a>
		</div><!-- /.main-container -->

		<script src="template/Backend/assets/js/jquery-2.1.4.min.js"></script>

		
		<script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='template/Backend/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<script src="template/Backend/assets/js/bootstrap.min.js"></script>

		
		<script src="template/Backend/assets/js/jquery.colorbox.min.js"></script>

		<!-- ace scripts -->
		<script src="template/Backend/assets/js/ace-elements.min.js"></script>
		<script src="template/Backend/assets/js/ace.min.js"></script>

		<!-- inline scripts related to this page -->
		<script type="text/javascript">
			jQuery(function($) {
	var $overflow = '';
	var colorbox_params = {
		rel: 'colorbox',
		reposition:true,
		scalePhotos:true,
		scrolling:false,
		previous:'<i class="ace-icon fa fa-arrow-left"></i>',
		next:'<i class="ace-icon fa fa-arrow-right"></i>',
		close:'&times;',
		current:'{current} of {total}',
		maxWidth:'100%',
		maxHeight:'100%',
		onOpen:function(){
			$overflow = document.body.style.overflow;
			document.body.style.overflow = 'hidden';
		},
		onClosed:function(){
			document.body.style.overflow = $overflow;
		},
		onComplete:function(){
			$.colorbox.resize();
		}
	};

	$('.ace-thumbnails [data-rel="colorbox"]').colorbox(colorbox_params);
	$("#cboxLoadingGraphic").html("<i class='ace-icon fa fa-spinner orange fa-spin'></i>");//let's add a custom loading icon
	
	
	$(document).one('ajaxloadstart.page', function(e) {
		$('#colorbox, #cboxOverlay').remove();
   });
})
		</script>
</body>
</html>