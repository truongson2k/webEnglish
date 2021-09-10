 <%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quản Lý Thành Viên</title>
 <link rel="stylesheet" href="template/Backend/assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="template/Backend/assets/font-awesome/4.5.0/css/font-awesome.min.css" />

		
		<link rel="stylesheet" href="template/Backend/assets/css/colorbox.min.css" />

		
		<link rel="stylesheet" href="template/Backend/assets/css/fonts.googleapis.com.css" />

		
		<link rel="stylesheet" href="template/Backend/assets/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />

		
		<link rel="stylesheet" href="template/Backend/assets/css/ace-skins.min.css" />
		<link rel="stylesheet" href="template/Backend/assets/css/ace-rtl.min.css" />

		
		<script src="template/Backend/assets/js/ace-extra.min.js"></script>
       
       <script src="template/Backend/assets/js/jquery-3.1.1.min.js">
	</script>
	<script>
	    $(document)
	            .ready(
	                    function() {
	                        //add more file components if Add is clicked
	                        $('#addFile')
	                                .click(
	                                        function() {
	                                            var fileIndex = $('#fileTable tr')
	                                                    .children().length - 1;
	                                            $('#fileTable')
	                                                    .append(
	                                                            '<tr><td>'
	                                                                    + '   <input type="file" name="files['+ fileIndex +']" />'
	                                                                    + '</td></tr>');
	                                        });
	 
	                    });
	</script>
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
								<a href="#">Danh Sách Thành Viên </a>
							</li>
							
						</ul><!-- /.breadcrumb -->

						
					</div>

<div class="page-content">
	<c:if test="${msgmanageuser!=''}">
		<h4 class="pink">
			<i class="ace-icon fa fa-hand-o-right icon-animated-hand-pointer blue"></i>
			<a  class="green" data-toggle="modal">${msgmanageuser }</a>
		</h4>
	</c:if>

 <div class="row">
	 <div class="col-xs-12">
	  	<div class="row">
			<div class="col-xs-12">
				<table id="simple-table" class="table  table-bordered table-hover">
					<thead>
						<tr>
							<th class="center">
									ID
						   </th>	
						   <th class="center">
								Tên hiển thị
						   </th>
						   <th class="center">
								UserName
					       </th>
			            	<th class="center">
								Xóa 
					        </th>
					        <th class="center">
				   				Sửa
					        </th>
								<!--  
							<th class="center">
					         check nội dung
							</th>
							    -->
						</tr>
					</thead>
					
					<tbody>		
                          <c:forEach items="${listuser}" var="listuser">
										<tr>
											<td class="center">
												<c:out value="${listuser.memberid}" />	
											</td>
											<td class="center">
										 		<c:out value="${listuser.name}" />		
											</td>
											<td class="center">
												<c:out value="${listuser.membername }" />		
											</td>
											<td class="center">
												<a class="red" href="DeleteUser?memberid=${listuser.memberid}">
													<i class="ace-icon fa fa-trash-o bigger-130"></i>
												</a>
											</td>
											<td class="center">
												<a class="green" href="UpdateUserfw?memberid=${listuser.memberid}">
													<i class="ace-icon fa fa-check-square-o"></i>
												</a>
											</td>
										</tr>
								</c:forEach>
					</tbody>
													
				</table>
		</div>
</div>
												
																									
<div class="row">
	<div class="col-xs-12">
		<div>
			<ul class="pagination">										
               <c:if test="${numberpage==1}"> 
			 		<li class="disabled"><a href="#">Prev</a></li>
					<li><a href="ListUserManage?pageid=${numberpage+1}">Next</a></li>
			   </c:if>
	
				<c:if test="${numberpage==maxpageid}"> 
					    <li><a href="ListUserManage?pageid=${numberpage-1}">Prev</a></li>   
						<li class="disabled"><a href="#">Next</a></li>	
				</c:if>
				
				<c:if test="${numberpage > 1 && numberpage < maxpageid}"> 
						<li><a href="ListUserManage?pageid=${numberpage-1}">Prev</a></li> 
						<li><a href="ListUserManage?pageid=${numberpage+1}">Next</a></li>
				</c:if>
			 </ul>
        </div>
	</div>
</div>



	
	 </div>
</div>
 </div>
</div>
</div>
			<!-- /.main-content -->
			
				<!-- Modal-Begin -->
			
 
		
			<!--End Modal -->	
					
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

		<script src="template/Backend/assets/js/jquery.dataTables.min.js"></script>
		<script src="template/Backend/assets/js/jquery.dataTables.bootstrap.min.js"></script>
		<script src="template/Backend/assets/js/dataTables.buttons.min.js"></script>
		<script src="template/Backend/assets/js/buttons.flash.min.js"></script>
		<script src="template/Backend/assets/js/buttons.html5.min.js"></script>
		<script src="template/Backend/assets/js/buttons.print.min.js"></script>
		<script src="template/Backend/assets/js/buttons.colVis.min.js"></script>
		<script src="template/Backend/assets/js/dataTables.select.min.js"></script>

		<!-- ace scripts -->
		<script src="template/Backend/assets/js/ace-elements.min.js"></script>
		<script src="template/Backend/assets/js/ace.min.js"></script>

		<!-- inline scripts related to this page -->
		<script type="text/javascript">
			jQuery(function($) {
				//initiate dataTables plugin
				var myTable = 
				$('#dynamic-table')
				//.wrap("<div class='dataTables_borderWrap' />")   //if you are applying horizontal scrolling (sScrollX)
				.DataTable( {
					bAutoWidth: false,
					"aoColumns": [
					  { "bSortable": false },
					  null, null,null, null, null,
					  { "bSortable": false }
					],
					"aaSorting": [],
					select: {
						style: 'multi'
					}
			    } );
			
				
				
				$.fn.dataTable.Buttons.defaults.dom.container.className = 'dt-buttons btn-overlap btn-group btn-overlap';
				
				
				myTable.buttons().container().appendTo( $('.tableTools-container') );
				
				//style the message box
				var defaultCopyAction = myTable.button(1).action();
				myTable.button(1).action(function (e, dt, button, config) {
					defaultCopyAction(e, dt, button, config);
					$('.dt-button-info').addClass('gritter-item-wrapper gritter-info gritter-center white');
				});
				
				
				var defaultColvisAction = myTable.button(0).action();
				myTable.button(0).action(function (e, dt, button, config) {
					
					defaultColvisAction(e, dt, button, config);
					
					
					if($('.dt-button-collection > .dropdown-menu').length == 0) {
						$('.dt-button-collection')
						.wrapInner('<ul class="dropdown-menu dropdown-light dropdown-caret dropdown-caret" />')
						.find('a').attr('href', '#').wrap("<li />")
					}
					$('.dt-button-collection').appendTo('.tableTools-container .dt-buttons')
				});
			
				////
			
				setTimeout(function() {
					$($('.tableTools-container')).find('a.dt-button').each(function() {
						var div = $(this).find(' > div').first();
						if(div.length == 1) div.tooltip({container: 'body', title: div.parent().text()});
						else $(this).tooltip({container: 'body', title: $(this).text()});
					});
				}, 500);
				
				
				
				
				

				$('th input[type=checkbox], td input[type=checkbox]').prop('checked', false);
				
				//select/deselect all rows according to table header checkbox
				$('#dynamic-table > thead > tr > th input[type=checkbox], #dynamic-table_wrapper input[type=checkbox]').eq(0).on('click', function(){
					var th_checked = this.checked;//checkbox inside "TH" table header
					
					$('#dynamic-table').find('tbody > tr').each(function(){
						var row = this;
						if(th_checked) myTable.row(row).select();
						else  myTable.row(row).deselect();
					});
				});
				
				//select/deselect a row when the checkbox is checked/unchecked
				$('#dynamic-table').on('click', 'td input[type=checkbox]' , function(){
					var row = $(this).closest('tr').get(0);
					if(this.checked) myTable.row(row).deselect();
					else myTable.row(row).select();
				});
			
			
			
				$(document).on('click', '#dynamic-table .dropdown-toggle', function(e) {
					e.stopImmediatePropagation();
					e.stopPropagation();
					e.preventDefault();
				});
				
				var active_class = 'active';
				$('#simple-table > thead > tr > th input[type=checkbox]').eq(0).on('click', function(){
					var th_checked = this.checked;//checkbox inside "TH" table header
					
					$(this).closest('table').find('tbody > tr').each(function(){
						var row = this;
						if(th_checked) $(row).addClass(active_class).find('input[type=checkbox]').eq(0).prop('checked', true);
						else $(row).removeClass(active_class).find('input[type=checkbox]').eq(0).prop('checked', false);
					});
				});
				
				//select/deselect a row when the checkbox is checked/unchecked
				$('#simple-table').on('click', 'td input[type=checkbox]' , function(){
					var $row = $(this).closest('tr');
					if($row.is('.detail-row ')) return;
					if(this.checked) $row.addClass(active_class);
					else $row.removeClass(active_class);
				});
				$('[data-rel="tooltip"]').tooltip({placement: tooltip_placement});
				
				//tooltip placement on right or left
				function tooltip_placement(context, source) {
					var $source = $(source);
					var $parent = $source.closest('table')
					var off1 = $parent.offset();
					var w1 = $parent.width();
			
					var off2 = $source.offset();
					//var w2 = $source.width();
			
					if( parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2) ) return 'right';
					return 'left';
				}

				$('.show-details-btn').on('click', function(e) {
					e.preventDefault();
					$(this).closest('tr').next().toggleClass('open');
					$(this).find(ace.vars['.icon']).toggleClass('fa-angle-double-down').toggleClass('fa-angle-double-up');
				});

			})
		</script>
</body>
</html>