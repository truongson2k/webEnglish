 <%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Tiếng Anh Mỗi Ngày</title>
  

	
	<link href="template/Frontend/css/bootstrap.css" rel="stylesheet">
    <link href="template/Frontend/css/bootstrap-responsive.css" rel="stylesheet">
    <link href="template/Frontend/css/style.css" rel="stylesheet"> 

  <link rel="apple-touch-icon-precomposed" sizes="144x144" href="template/Frontend/img/apple-touch-icon-144-precomposed.png">
  <link rel="apple-touch-icon-precomposed" sizes="114x114" href="template/Frontend/img/apple-touch-icon-114-precomposed.png">
  <link rel="apple-touch-icon-precomposed" sizes="72x72" href="template/Frontend/img/apple-touch-icon-72-precomposed.png">
  <link rel="apple-touch-icon-precomposed" href="template/Frontend/img/apple-touch-icon-57-precomposed.png">
  <link rel="shortcut icon" href="template/Frontend/img/favicon.png">
  


    <!-- SCRIPT 
    ============================================================-->  
  
     <script src="template/Frontend/js/jquery1.js"></script>
    <script src="template/Frontend/js/bootstrap.min.js"></script>
     <style type="text/css">
    
    .tuvung{width: 100%; padding:10px 0 10px 0; border-bottom: 1px solid #EEEEEE; height: 220px; color: #444;}
    .tuvung:hover{background: #eee;}
    </style>
   
</head>

<body>


  <!--HEADER ROW-->
<jsp:include page="Header.jsp"/>
   
  <!-- /HEADER ROW -->




<div class="container">
	  <!--PAGE TITLE-->

	<div class="row">
		<div class="span12">
		<div class="page-header">
				<h3>
				Danh sách từ vựng
			   </h3>
			   
		</div>
		</div>
	</div>

  <!-- /. PAGE TITLE-->
    <% if(request.getAttribute("msgndcdtuvung")!=null)
      {
    %>
    <div class="row">
	
		<div class="span6">
			<div class="media">
				<p style="color:red">${msgndcdtuvung }</p>
				
			</div>
		</div>			

	</div>
    <%
      }
    else
    {
    %>
    
	<div class="row">
	<c:forEach items="${contentvocabulary}" var="list">
		<div class="tuvung">
			<div class="media">
				 <a href="#" class="pull-left"><img src="Image_AudioVocabulary/${list.image }" class="media-object" alt='' width="200px" height="150px"/></a>
				<div class="media-body">
					
					<p style="color:red">
					${list.vocabularycontentname }
					</p>
					<p style="color:#2E2EFE">
					${list.transcribe }
					</p>
					<p>
					${list.mean }
					</p>
					<audio controls>
										    
							 <source src="Image_AudioVocabulary/${list.audiomp3 }" type="audio/mpeg">
							 
				   </audio>
				</div>
			</div>
		</div>			

</c:forEach>
	</div>
	<%
	}
	%>
</div>


		
<!--Footer
==========================-->

<jsp:include page="Footer.jsp"/>


<!--/.Footer-->

</body>
</html>
