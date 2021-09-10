 <%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
  <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Tiếng Anh Mỗi Ngày</title>
  

	
	<link href="template/Frontend/css/bootstrap.css" rel="stylesheet">
    <link href="template/Frontend/css/bootstrap-responsive.css" rel="stylesheet">
    <link href="template/Frontend/css/style.css" rel="stylesheet"> 

  

  


    <!-- SCRIPT 
    ============================================================-->  
  
     <script src="template/Frontend/js/jquery1.js"></script>
    <script src="template/Frontend/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="Jqueryphantrang/css/style.css" media="screen"/>
     <style type="text/css">
      .demo{
                width:580px;
                padding:10px;
                margin:10px auto;
                border: 1px solid #fff;
                background-color:#f7f7f7;
            }
           
		.pagedemo{
				border: 1px solid #CCC;
				width:310px;
				margin:2px;
                padding:50px 10px;
                text-align:center;
				background-color:white;	
			}
   
    .khoangcach{
    padding-top:100px
    }
    </style>
  <script src="Countdown/countdown.js"></script>
   <script type="text/javascript">
   function auto_submit(){
	 document.form.submit();  
   }
function auto_submit1(){
	   setTimeout("auto_submit()",600000);
   }
   </script>
</head>

<body onLoad="auto_submit1();">


  <!--HEADER ROW-->
<jsp:include page="Header.jsp"/>
   
  <!-- /HEADER ROW -->




<div class="container">
	  <!--PAGE TITLE-->

		<div class="row">
			<div class="span12">
			
					<h1>
					Đề thi
				</h1>
			<script>

function doneHandler(result) {
	
	
	
	var h = result.getHours();
	var m = result.getMinutes();
	var s = result.getSeconds();
	
	var UTC = result.toString();
	
	var output = UTC + "\n";
	
	output += "h: " + h + "\n";
	output += "m: " + m + "\n";
	output += "s: " + s + "\n";
	
	
}

var myCountdownTest = new Countdown({
								 	time: 600,
									width	: 300, 
									height	: 50,
									onComplete : doneHandler
									});



</script>
<!-- END COUNTDOWN -->
			
	
			</div>
		</div>
	
	
	  <!-- /. PAGE TITLE-->
	<div class="row">
		<div class="span8">
				<div id="paginationdemo" class="thumbnail">
					<div class="reading_descoription" style="overflow: auto; height: 400px ">
						<div id="p1" class="_current" style="">
						    <h2  class="khoangcach">Bắt đầu bài kiểm tra</h2>
						</div>
						<c:forEach items="${listexam1}" var ="list">
							
							<c:if test="${(list.imagequestion==' ') && (list.audiogg!=' ') && (list.audiomp3!=' ')}">
								<div id="p${list.num+1}" style="display:none;">
									<p><strong>Câu ${list.num}</strong></p>
										
										<br/>
										<br/>
										<p>
										<audio controls>
										    <source src="Image_AudioExam/${list.audiomp3 }" type="audio/mpeg">
										</audio>
										</p>
										
										<p>${list.question}</p>
										<p>${list.option1}</p>
										<p>${list.option2}</p>
										<p>${list.option3}</p>
										<p>${list.option4}</p>
								</div>
							</c:if>
							<c:if test="${(list.imagequestion==' ') && (list.audiogg==' ') && (list.audiomp3==' ')}">
								<div id="p${list.num+1}" style="display:none;">
										<p><strong>Câu ${list.num}</strong></p>
										<p>
										<c:set var="kq" value="${fn:replace(list.paragrap,kitudb1,kituhtml1) }"/>
			                          	<c:out value="${kq }" escapeXml="false"/>
										
										</p>
									
										<p>${list.question}</p>
										<p>${list.option1}</p>
										<p>${list.option2}</p>
										<p>${list.option3}</p>
										<p>${list.option4}</p>
								</div>
							</c:if>
							<c:if test="${(list.imagequestion!=' ') && (list.audiogg!=' ') && (list.audiomp3!=' ')}">
								<div id="p${list.num+1}" style="display:none;">
										<p><strong>Câu ${list.num}</strong></p>
										<img src="Image_AudioExam/${list.imagequestion }" alt='' width="250px" height="150px"/>
										<br/>
										<br/>
										<p>
										<audio controls>
										   
										    <source src="Image_AudioExam/${list.audiomp3 }" type="audio/mpeg">
										</audio>
										</p>
										
										<p>${list.question}</p>
										<p>${list.option1}</p>
										<p>${list.option2}</p>
										<p>${list.option3}</p>
										<p>${list.option4}</p>
								</div>
							</c:if>
						</c:forEach>
						
					</div>
				</div>	
			</br>
				<div id="demo5">  
				            
	          </div>
		</div>
		
		<form name="form" action="Takeatesttoeic?idexamination=${idexamination }&memberid=${memberid}" method="post">	
	    <div class="span4">
				<div class="thumbnail">
					<div class="reading_descoription" style="overflow: auto; height: 400px ">
					<c:forEach items = "${listexam1}" var = "list">
							&nbsp;&nbsp;
							<div class="span1">
							${list.num }
							</div>
							A &nbsp;  <input type="radio" name="ans[${list.num}]" value="A"> 
							&nbsp;&nbsp;&nbsp;&nbsp;
							B &nbsp;  <input type="radio" name="ans[${list.num}]" value="B">
							&nbsp;&nbsp;&nbsp;&nbsp;
						    C &nbsp; <input type="radio" name="ans[${list.num}]" value="C"> 
							&nbsp;&nbsp;&nbsp;&nbsp;
							D &nbsp; <input type="radio" name="ans[${list.num}]" value="D"> 
						    &nbsp;&nbsp;&nbsp;&nbsp;
							<br/>
		</c:forEach>	
					</div>	
				</div>
				<br/>
			<input type="submit" class="btn btn-primary" value="Nộp bài" />	
		</div>
		</form>	
	</div>
</div>


	<!--===============-->
	



		
<!--Footer
==========================-->

<jsp:include page="Footer.jsp"/>


<!--/.Footer-->

		<script type="text/javascript" src="template/Frontend/js/jquery-1.3.2.js"></script>
		<script src="template/Frontend/js/jquery.paginate.js" type="text/javascript"></script>
		<script type="text/javascript">
		
			$(function() 
			{
				$("#demo5").paginate({
					count 		: 11,
					start 		: 1,
					display     : 5,
					border					: true,
					border_color			: '#fff',
					text_color  			: '#fff',
					background_color    	: 'black',	
					border_hover_color		: '#ccc',
					text_hover_color  		: '#000',
					background_hover_color	: '#fff', 
					images					: false,
					mouse					: 'press',
					onChange     			: function(page){
												$('._current','#paginationdemo').removeClass('_current').hide();
												$('#p'+page).addClass('_current').show();
											  }
				});
			});
		</script>
</body>
</html>
