<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Soạn thảo nội dung bài ngữ pháp</title>
<link rel="stylesheet" href="template/Backend/assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="template/Backend/assets/font-awesome/4.5.0/css/font-awesome.min.css" />

		
		<link rel="stylesheet" href="template/Backend/assets/css/colorbox.min.css" />

		
		<link rel="stylesheet" href="template/Backend/assets/css/fonts.googleapis.com.css" />

		
		<link rel="stylesheet" href="template/Backend/assets/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />

		
		<link rel="stylesheet" href="template/Backend/assets/css/ace-skins.min.css" />
		<link rel="stylesheet" href="template/Backend/assets/css/ace-rtl.min.css" />

		
		<script src="template/Backend/assets/js/ace-extra.min.js"></script>
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
							
							<li>
								<a href="#">Quản Lý Phần Hướng Dẫn</a>
							</li>
							<li class="active">Hướng Dẫn Ngữ Pháp</li>
						</ul><!-- /.breadcrumb -->

						
					</div>

<div class="page-content">

  
						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
							
								<div class="row">
								

									<div class="col-sm-7">
										<h4 class="header green">Soạn thảo nội dung bài ngữ pháp</h4>

										<div class="widget-box widget-color-blue">
											<div class="widget-header widget-header-small">  </div>

                      <form action="Grammarcontentcontroller?idgrammar=<%=request.getAttribute("idgrammar")%>" method="post">
											<div class="widget-body">
												<div class="widget-main no-padding">
													<textarea name="content" data-provide="markdown" data-iconlibrary="fa" rows="10" data-hidden-buttons="Image">
                                        </textarea>
												</div>

												<div class="widget-toolbox padding-4 clearfix">
													

													<div class="btn-group pull-right">
														<button class="btn btn-sm btn-purple" type="submit">
															<i class="ace-icon fa fa-floppy-o bigger-125"></i>
															Lưu
														</button>
													</div>
												</div>
											</div>
										</form>
										</div>
									</div>
								</div>

								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
						
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

		<!-- <![endif]-->

		<!--[if IE]>
<script src="assets/js/jquery-1.11.3.min.js"></script>
<![endif]-->
		<script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<script src="template/Backend/assets/js/bootstrap.min.js"></script>

		<!-- page specific plugin scripts -->
		<script src="template/Backend/assets/js/jquery-ui.custom.min.js"></script>
		<script src="template/Backend/assets/js/jquery.ui.touch-punch.min.js"></script>
		<script src="template/Backend/assets/js/markdown.min.js"></script>
		<script src="template/Backend/assets/js/bootstrap-markdown.min.js"></script>
		<script src="template/Backend/assets/js/jquery.hotkeys.index.min.js"></script>
		<script src="template/Backend/assets/js/bootstrap-wysiwyg.min.js"></script>
		<script src="template/Backend/assets/js/bootbox.js"></script>

		<!-- ace scripts -->
		<script src="template/Backend/assets/js/ace-elements.min.js"></script>
		<script src="template/Backend/assets/js/ace.min.js"></script>

		<!-- inline scripts related to this page -->
		<script type="text/javascript">
			jQuery(function($){
	
	$('textarea[data-provide="markdown"]').each(function(){
        var $this = $(this);

		if ($this.data('markdown')) {
		  $this.data('markdown').showEditor();
		}
		else $this.markdown()
		
		$this.parent().find('.btn').addClass('btn-white');
    })
	
	
	
	function showErrorAlert (reason, detail) {
		var msg='';
		if (reason==='unsupported-file-type') { msg = "Unsupported format " +detail; }
		else {
			//console.log("error uploading file", reason, detail);
		}
		$('<div class="alert"> <button type="button" class="close" data-dismiss="alert">&times;</button>'+ 
		 '<strong>File upload error</strong> '+msg+' </div>').prependTo('#alerts');
	}

	//$('#editor1').ace_wysiwyg();//this will create the default editor will all buttons

	//but we want to change a few buttons colors for the third style
	$('#editor1').ace_wysiwyg({
		toolbar:
		[
			'font',
			null,
			'fontSize',
			null,
			{name:'bold', className:'btn-info'},
			{name:'italic', className:'btn-info'},
			{name:'strikethrough', className:'btn-info'},
			{name:'underline', className:'btn-info'},
			null,
			{name:'insertunorderedlist', className:'btn-success'},
			{name:'insertorderedlist', className:'btn-success'},
			{name:'outdent', className:'btn-purple'},
			{name:'indent', className:'btn-purple'},
			null,
			{name:'justifyleft', className:'btn-primary'},
			{name:'justifycenter', className:'btn-primary'},
			{name:'justifyright', className:'btn-primary'},
			{name:'justifyfull', className:'btn-inverse'},
			null,
			{name:'createLink', className:'btn-pink'},
			{name:'unlink', className:'btn-pink'},
			null,
			{name:'insertImage', className:'btn-success'},
			null,
			'foreColor',
			null,
			{name:'undo', className:'btn-grey'},
			{name:'redo', className:'btn-grey'}
		],
		'wysiwyg': {
			fileUploadError: showErrorAlert
		}
	}).prev().addClass('wysiwyg-style2');

	


	$('#editor2').css({'height':'200px'}).ace_wysiwyg({
		toolbar_place: function(toolbar) {
			return $(this).closest('.widget-box')
			       .find('.widget-header').prepend(toolbar)
				   .find('.wysiwyg-toolbar').addClass('inline');
		},
		toolbar:
		[
			'bold',
			{name:'italic' , title:'Change Title!', icon: 'ace-icon fa fa-leaf'},
			'strikethrough',
			null,
			'insertunorderedlist',
			'insertorderedlist',
			null,
			'justifyleft',
			'justifycenter',
			'justifyright'
		],
		speech_button: false
	});
	
	


	$('[data-toggle="buttons"] .btn').on('click', function(e){
		var target = $(this).find('input[type=radio]');
		var which = parseInt(target.val());
		var toolbar = $('#editor1').prev().get(0);
		if(which >= 1 && which <= 4) {
			toolbar.className = toolbar.className.replace(/wysiwyg\-style(1|2)/g , '');
			if(which == 1) $(toolbar).addClass('wysiwyg-style1');
			else if(which == 2) $(toolbar).addClass('wysiwyg-style2');
			if(which == 4) {
				$(toolbar).find('.btn-group > .btn').addClass('btn-white btn-round');
			} else $(toolbar).find('.btn-group > .btn-white').removeClass('btn-white btn-round');
		}
	});
	if ( typeof jQuery.ui !== 'undefined' && ace.vars['webkit'] ) {
		
		var lastResizableImg = null;
		function destroyResizable() {
			if(lastResizableImg == null) return;
			lastResizableImg.resizable( "destroy" );
			lastResizableImg.removeData('resizable');
			lastResizableImg = null;
		}

		var enableImageResize = function() {
			$('.wysiwyg-editor')
			.on('mousedown', function(e) {
				var target = $(e.target);
				if( e.target instanceof HTMLImageElement ) {
					if( !target.data('resizable') ) {
						target.resizable({
							aspectRatio: e.target.width / e.target.height,
						});
						target.data('resizable', true);
						
						if( lastResizableImg != null ) {
							//disable previous resizable image
							lastResizableImg.resizable( "destroy" );
							lastResizableImg.removeData('resizable');
						}
						lastResizableImg = target;
					}
				}
			})
			.on('click', function(e) {
				if( lastResizableImg != null && !(e.target instanceof HTMLImageElement) ) {
					destroyResizable();
				}
			})
			.on('keydown', function() {
				destroyResizable();
			});
	    }

		enableImageResize();

		
	}


});
		</script>
</body>
</html>