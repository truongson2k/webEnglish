 <%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tiếng Anh Mỗi Ngày</title>
<!-- Bootstrap -->
    <link href="template/Frontend/css/bootstrap.css" rel="stylesheet">
    <link href="template/Frontend/css/bootstrap-responsive.css" rel="stylesheet">
    <link href="template/Frontend/css/style.css" rel="stylesheet"> 
    <!--Font-->
    <link href='template/Frontend/font/font.css' rel='stylesheet' >
    <!-- SCRIPT -->  
    <script src="template/Frontend/js/jquery1.js"></script>
    <script src="template/Frontend/js/bootstrap.min.js"></script>
    <style>
    #size{
    padding-top:20px;
    padding-bottom:10px;
    }
    .exam {
        padding-top:600px;
        padding-left:50px;
    
    }
    </style>
     
     <script type="text/javascript">
 	
		function Search()
		{
			var xhttp;
			var grammarname = document.myform.grammarname.value;
			
			if (grammarname != "")
			{
				var url = "SearchController?grammarname="+grammarname;
				
				if (window.XMLHttpRequest) 
				{          
				           xhttp = new XMLHttpRequest();
				} 
				else
				{        
					xhttp = new ActiveXObject("Microsoft.XMLHTTP");
				}
				
				xhttp.onreadystatechange = function()
				{
					if(xhttp.readyState == 4)
					{
						var data = xhttp.responseText;
						document.getElementById("searchresult").innerHTML = data;
					}			
					
				}	
				xhttp.open("POST",url,true);
				xhttp.send();	
			}
			else 
			{
				document.getElementById("searchresult").innerHTML = "";
			}
						
				
		}
		
     </script> 
</head>
<body>
 <!-- BEGIN HEADER ROW -->
 <jsp:include page="Header.jsp"/>
  <!-- END HEADER ROW -->
<!--BEGIN SEARCH -->
<div class="container" id="searchresult">
	<div class="row">
		<div class="span6">
			<div id="size">
				<form name="myform" >
					<input type="text" class="form-control" placeholder="Tìm kiếm" style="width:500px" name="grammarname" onkeyup="Search()">
				</form>
			</div>
		</div>
	</div>
</div>
<!-- END SEARCH  -->

  


  <div class="container">

  <!--Carousel
  ==================================================-->

  <div id="myCarousel" class="carousel slide">
    <div class="carousel-inner">

      <div class="active item">
        <div class="container">
          <div class="row">
            
              <div class="span6">

                <div class="carousel-caption">
                      <h1>Học Thông Minh</h1>
                      <p class="lead">Tiếng Anh Mỗi Ngày tin rằng mỗi người đều có những tiềm năng vô hạn để trở nên giỏi giang. Vấn đề là họ không áp dụng đúng phương pháp để việc học hiệu quả hơn. Vì vậy mong muốn giúp cho những người gặp khó khăn trong việc học hành nói chung và học Tiếng Anh nói riêng được tiếp cận các phương pháp, kinh nghiệm học tiếng Anh thông minh để trở nên giỏi thực sự.</p>
                       <a class="btn btn-large btn-primary" href="RegisterController">Đăng ký</a>
                </div>

              </div>

                <div class="span6"> <img src="template/Frontend/Image/slide2.jpg"></div>

          </div>
        </div>
       



      </div>

      <div class="item">
       
        <div class="container">
          <div class="row">
            
              <div class="span6">

                <div class="carousel-caption">
                      <h1>Tiếng Anh Vững Vàng</h1>
                      <p class="lead">Mỗi ngày một kiến thức mới,ôn tập nhũng gì đã học,nâng cao kiến thức tiếng Anh mỗi ngày.Tự tin giao tiếp tiếng Anh trong đời sống và công việc</p>
                      <a class="btn btn-large btn-primary" href="RegisterController">Đăng ký</a>
                </div>

              </div>

                <div class="span6"> <img src="template/Frontend/Image/slide1.jpg"></div>

          </div>
        </div>

      </div>





    </div>
       <!-- Carousel nav -->
      <a class="carousel-control left " href="#myCarousel" data-slide="prev"><i class="icon-chevron-left"></i></a>
      <a class="carousel-control right" href="#myCarousel" data-slide="next"><i class="icon-chevron-right"></i></a>
        <!-- /.Carousel nav -->

  </div>
    <!-- /Carousel -->

<!-- Feature 
  ==============================================-->


  <div class="row feature-box">
      <div class="span12 cnt-title">
       <h1>Chúng tôi cung cấp cho các bạn các bài học thông minh </h1> 
       
        <span>(--Học Thật - Thi Thật--)</span>        
      </div>

      <div class="span4">
        <a href="Dshdnguphapforward?pageid=1"><img src="template/Frontend/Image/nguphap.PNG" width="246" height="278"></a>
        <h2>Hướng dẫn phần ngữ pháp</h2>
        <p>
             Cung cấp cách học cấu trúc ngữ pháp thông minh 
        </p>

        <a href="Dshdnguphapforward?pageid=1">Chi tiết &rarr;</a>

      </div>
       
      
       <div class="span4">
         <a href="DisplaylistVocabularyTopic?pageid=1"><img src="template/Frontend/Image/tuvung.PNG" width="246" height="278"></a>
        <h2>Hướng dẫn phần từ vựng </h2>
        <p>
             Cung cấp cách học từ vựng thông minh 
        </p>

        <a href="DisplaylistVocabularyTopic?pageid=1">Chi tiết &rarr;</a>

      </div>
      
       <div class="span4">
        <a href="DisplayListListen?pageid=1"><img src="template/Frontend/Image/nghe.PNG" width="246" height="278"></a> 
        <h2>Hướng dẫn phần nghe</h2>
        <p>
             Luyện nghe thông minh 
        </p>

        <a href="DisplayListListen?pageid=1">Chi tiết &rarr;</a>
<br>
      </div>
      <br>
      <div class="exam"> 
  
       <a href="Displaylistexam?pageid=1"> <img src="template/Frontend/Image/baitap.jpg" width="246" height="278"></a>
        <h2>Đề thi thử</h2>
        <p>
            Các bài thi sát với đề thi thật
        </p>
          <a href="Displaylistexam?pageid=1">Chi tiết &rarr;</a>
     
      </div>
  </div>


<!-- /.Feature -->

  <div class="hr-divider"></div>

<!-- Row View -->


    <div class="row">
        <div class="span6"><img src="template/Frontend/img/responsive.png"></div>

        <div class="span6">
       
          <h1>Học Mọi Lúc,Mọi Nơi</h1>
            <p>Chỉ cần kết nối mạng ,bạn có thể học với chúng tôi một cách dễ dàng.</p>
             
        </div>
    </div>

   
</div>


<!-- /.Row View -->



<!--Footer
==========================-->


<jsp:include page="Footer.jsp"/>

<!--/.Footer-->


</body>
</html>