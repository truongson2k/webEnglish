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

<!--  
<script>
  window.fbAsyncInit = function() {
    FB.init({
      appId      : '3515958651821570',
      cookie     : true,
      xfbml      : true,
      version    : 'v9.0'
    });
      
    FB.AppEvents.logPageView();   
      
  };

  (function(d, s, id){
     var js, fjs = d.getElementsByTagName(s)[0];
     if (d.getElementById(id)) {return;}
     js = d.createElement(s); js.id = id;
     js.src = "https://connect.facebook.net/en_US/sdk.js";
     fjs.parentNode.insertBefore(js, fjs);
   }(document, 'script', 'facebook-jssdk'));
</script>
  -->  
<div id="fb-root"></div>
<script async defer crossorigin="anonymous" src="https://connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v9.0&appId=3515958651821570&autoLogAppEvents=1" nonce="J9TGUmZq"></script>
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
		<c:set var="kq1" value="${fn:replace(grammarname,kitudb1,kituhtml1) }"/>
				<c:set var="kq2" value="${fn:replace(kq1,kitudb2,kituhtml2) }"/>
				<c:set var="kq3" value="${fn:replace(kq2,kitudb3,kituhtml3) }"/>  
			<h2>	<c:out value="${kq3 }" escapeXml="false"/> </h2>
		</div>
		</div>
	</div>

  <!-- /. PAGE TITLE-->
<div class="row">

	
		<div class="span9">
		
			<div class="blog-post">
				
					<p>
	
				<c:set var="kq1" value="${fn:replace(grammarcontent,kitudb1,kituhtml1) }"/>
				<c:set var="kq2" value="${fn:replace(kq1,kitudb2,kituhtml2) }"/>
				<c:set var="kq3" value="${fn:replace(kq2,kitudb3,kituhtml3) }"/>  
				<c:out value="${kq3 }" escapeXml="false"/>
				<!--	<c:set var="kq1" value="<strong>${grammarcontent }</strong>"/>
				<c:out value="${kq1 }" escapeXml="false"/>-->
					</p>			
			</div>
	</div>
	
	<div class="span3">
			<div class="side-bar">
<div class="fb-page" data-href="https://www.facebook.com/TiengAnhOnlineMoiNgay" data-tabs="" data-width="" data-height="" data-small-header="false" data-adapt-container-width="true" data-hide-cover="false" data-show-facepile="true">
<blockquote cite="https://www.facebook.com/TiengAnhOnlineMoiNgay" class="fb-xfbml-parse-ignore"><a href="https://www.facebook.com/TiengAnhOnlineMoiNgay">Tiếng Anh Online</a></blockquote></div>
				<h3>Các bài viết liên quan</h3>
				<ul class="nav nav-list">
					<li><a href="chitietnguphapforward?ma=35">Thì hiện tại đơn</a></li>
					<li><a href="chitietnguphapforward?ma=36">Thì hiện tại tiếp diễn</a></li>
					<li><a href="chitietnguphapforward?ma=39">Thì quá khứ đơn</a></li>
					<li><a href="chitietnguphapforward?ma=40">Thì quá khứ tiếp diễn</a></li>
					<li><a href="chitietnguphapforward?ma=43">Thì tương lai đơn</a></li>
				</ul>

			</div>


			

			


		</div>
	
</div>
	


	<!--===============-->
	<div>
	<h3>Bình luận</h3>
	<div class="fb-comments" data-href="http://localhost/8080/" data-width="480" data-numposts="5"></div>
	
	<!--   <textarea  class="input-xxlarge"  rows="10"  placeholder="Your Message"></textarea>
	<div>
	<a class="btn btn-primary" href="blog-details.html">Đăng bình luận</a>		
	</div> 
	-->
	 </div>			 
</div>


		
<!--Footer
==========================-->

<jsp:include page="Footer.jsp"/>


<!--/.Footer-->
<div id="fb-root"></div>
<script async defer crossorigin="anonymous" src="https://connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v9.0&appId=3515958651821570&autoLogAppEvents=1" nonce="qNRb11Ek"></script>
</body>
</html>
