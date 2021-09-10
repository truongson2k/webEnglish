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
    #paral{
    padding-top:20px;
    }
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
				Danh sách đề thi toeic
			   </h3>
			   <p style="color:red">
			   <%=request.getAttribute("msgloidnlambai")!=null?request.getAttribute("msgloidnlambai"):" " %>
			   </p>
		</div>
		</div>
	</div>

  <!-- /. PAGE TITLE-->
    <% if(request.getAttribute("msgdsdethi")!=null)
      {
    %>
    <div class="row">
	
		<div class="span6">
			<div class="media">
				<p style="color:red">${msgdsdethi }</p>
				
			</div>
		</div>			

	</div>
    <%
      }
    else
    {
    %>
    
	<div class="row">
	<c:forEach items="${listexam}" var="list">
		<div class="span6">
			<div class="media">
				 <a href="#" class="pull-left"><img src="Image_AudioExam/${list.examinationimage }" class="media-object" alt='' width="128px" height="128px"/></a>
				<div class="media-body">
					
					<p>
					${list.examinationname }
					</p>
					<a href="Takeatesttoeic?idexamination=${list.idexamination }" class="btn" type="button">Làm bài thi</a>
 

				</div>
			</div>
		</div>			

</c:forEach>
	</div>
	<%
	}
	%>
</div>

<!--Pagination-->
			<div class="pagination" id="paral">
				<ul>
					<c:if test="${numberpage==1}"> 
						<li class="disabled"><a href="#">Prev</a></li>
						
						<li><a href="Displaylistexam?pageid=${numberpage+1}">Next</a></li>
					</c:if>
					
					<c:if test="${numberpage==maxpageid}"> 
					    <li><a href="Displaylistexam?pageid=${numberpage-1}">Prev</a></li>
					    
						<li class="disabled"><a href="#">Next</a></li>
						
					</c:if>
					<c:if test="${numberpage > 1 && numberpage < maxpageid}"> 
						    <li><a href="Displaylistexam?pageid=${numberpage-1}">Prev</a></li>
						    
						<li><a href="Displaylistexam?pageid=${numberpage+1}">Next</a></li>
					</c:if>
				</ul>
			</div>	

		<!--/.Pagination-->
		
<!--Footer
==========================-->

<jsp:include page="Footer.jsp"/>


<!--/.Footer-->

</body>
</html>
