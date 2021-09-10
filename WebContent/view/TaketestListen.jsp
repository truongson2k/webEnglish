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

  

  <script type="text/javascript">
				
		
 
				function Result()
				{
					var xhttp;
					var kq = document.myform.radio.value;
					var url =  "TaketestListen?kq="+kq+"&num="+<%=request.getAttribute("numberpage")%>+"&idlistenexercise="+<%=request.getAttribute("idlistenexercise")%>;
					
						
						
						if (window.XMLHttpRequest) 
						{          
						           xhttp = new XMLHttpRequest();
						} 
						
						
						xhttp.onreadystatechange = function()
						{
							if(xhttp.readyState == 4)
							{
								var data = xhttp.responseText;
								document.getElementById("result").innerHTML = data;
							}			
							
						}	
						xhttp.open("POST",url,true);
						xhttp.send();	
					
						
				}
				
				
		
		</script>


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
			
					<h3>
					Làm bài tập nghe  
				   </h3>

			</div>
		</div>
	

	  <!-- /. PAGE TITLE-->
	<div class="row">
		<div class="span9">
			<ul class="thumbnails">
			  <li class="span9">
			    <div class="thumnail">
			       <div id="paginationdemo" class="thumbnail">
			    	<form name="myform" id="result">
			    	
					    <c:forEach items="${listtestlisten }" var="list"> 
					    	<c:if test="${(list.imagename!=' ') && (list.audiomp3!=' ')}">
					    <p>
					        Câu ${list.num }. ${list.question }
					    </p>
					    <p>
					         
					          <img src="FileListen/${list.imagename }" alt='' width="250px" height="150px"/>
					    </p>
					    <p>
										<audio controls>
										    <source src="FileListen/${list.audiomp3 }" type="audio/mpeg">
										</audio>
						</p>
					    <p>
					    	<input type="radio" name="radio" value="A"/> 
					        ${list.option1 }
					    </p>
					    <p>
					  	   <input type="radio" name="radio" value="B"/> 
					       ${list.option2 }
					    </p>
					     <p>
					       <input type="radio" name="radio" value="C"/> 
					       ${list.option3 }
					    </p>
					     <p>	
					       <input type="radio" name="radio" value="D"/> 
					        ${list.option4 }
					    </p>
					    
					    </c:if>
					    <c:if test="${(list.imagename==' ') && (list.audiomp3!=' ')}">
					    <p>
					        Câu ${list.num }. ${list.question }
					    </p>
					   
					    <p>
										<audio controls>
										    <source src="FileListen/${list.audiomp3 }" type="audio/mpeg">
										</audio>
						</p>
					    <p>
					    	<input type="radio" name="radio" value="A"/> 
					        ${list.option1 }
					    </p>
					    <p>
					  	   <input type="radio" name="radio" value="B"/> 
					       ${list.option2 }
					    </p>
					     <p>
					       <input type="radio" name="radio" value="C"/> 
					       ${list.option3 }
					    </p>
					     <p>	
					       <input type="radio" name="radio" value="D"/> 
					        ${list.option4 }
					    </p>
					    
					    </c:if>
					    </c:forEach>
			    	</form>
			    	</div>
			    </div>
			  </li>
			</ul>	
		</div>
		
		
	</div>
	


<div class="row">
	<div class="span12">
		
				
					<c:if test="${numberpage==1}"> 
						<a href="#" class="btn btn-info disabled">Prev</a>
						<input type="button"  value="Đáp án" class="btn btn-info" onclick="Result()"/>
						<a href="TaketestListen?pageid=${numberpage}&idlistenexercise=<%=request.getAttribute("idlistenexercise")%>" class="btn btn-info ">làm lại</a>
						<a href="TaketestListen?pageid=${numberpage+1}&idlistenexercise=<%=request.getAttribute("idlistenexercise")%>" class="btn btn-info">Next</a>
					</c:if>
					
					
					<c:if test="${numberpage==maxpageid}"> 
					    <a href="TaketestListen?pageid=${numberpage-1}&idlistenexercise=<%=request.getAttribute("idlistenexercise")%>">Prev</a>
					    	<input type="button" value="Đáp án" class="btn btn-info" onclick="Result()"/>
					    	<a href="TaketestListen?pageid=${numberpage}&idlistenexercise=<%=request.getAttribute("idlistenexercise")%>" class="btn btn-info ">làm lại</a>
						<a href="#"class="btn btn-info disabled">Next</a>
						
					</c:if>
					<c:if test="${numberpage > 1 && numberpage < maxpageid}"> 
						  <a href="TaketestListen?pageid=${numberpage-1}&idlistenexercise=<%=request.getAttribute("idlistenexercise")%>" class="btn btn-info">Prev</a>
						    	<input type="button"  value="Đáp án" class="btn btn-info" onclick="Result()"/>
						    	<a href="TaketestListen?pageid=${numberpage}&idlistenexercise=<%=request.getAttribute("idlistenexercise")%>" class="btn btn-info ">làm lại</a>
					<a href="TaketestListen?pageid=${numberpage+1}&idlistenexercise=<%=request.getAttribute("idlistenexercise")%>" class="btn btn-info">Next</a>
					 
					 </c:if>
			
			
		
	</div>
</div>
</div>	
	<!--===============-->
	



		
<!--Footer
==========================-->

<jsp:include page="Footer.jsp"/>


<!--/.Footer-->

		<script type="text/javascript" src="template/Frontend/js/jquery-1.3.2.js"></script>
		<script src="template/Frontend/js/jquery.paginate.js" type="text/javascript"></script>
		
</body>
</html>
