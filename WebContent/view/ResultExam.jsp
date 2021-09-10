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
</head>
<body>
  <!--HEADER ROW-->
<jsp:include page="Header.jsp"/>
   
  <!-- /HEADER ROW -->

<div class="row">
	  <div class="span8">
	  <h2>Đáp án đúng</h2>
<div  class="thumbnail" style="height:400px">
	
		
<div class="reading_descoription" style="overflow: auto; height: 400px ">
			<c:forEach items = "${listcorrectanswer}" var = "listcorrectanswer">
			
			<c:if test="${(listcorrectanswer.imagequestion!=' ') && (listcorrectanswer.audiogg!=' ') && (listcorrectanswer.audiomp3!=' ')}">
							
								<p>${listcorrectanswer.num}. ${listcorrectanswer.question}</p>
								 <img src="Image_AudioExam/${listcorrectanswer.imagequestion }" alt='' width="250px" height="150px"/>
										<br/>
										<br/>
										<p>
										<audio controls>
										    <source src="Image_AudioExam/${listcorrectanswer.audiogg }" type="audio/ogg">
										    <source src="Image_AudioExam/${listcorrectanswer.audiomp3 }" type="audio/mpeg">
										</audio>
										</p>
								 <c:if test="${listcorrectanswer.correctanswer == 'A'}">
								 <p style="color:red"> Đáp án đúng A</p>
							   </c:if>
							    <c:if test="${listcorrectanswer.correctanswer == 'B'}">
								 <p style="color:red"> Đáp án đúng B</p>
							   </c:if>
							    <c:if test="${listcorrectanswer.correctanswer == 'C'}">
								 <p style="color:red">Đáp án đúng C</p>
							   </c:if>
							    <c:if test="${listcorrectanswer.correctanswer == 'D'}">
								 <p style="color:red"> Đáp án đúng D</p>
							   </c:if>
			</c:if>
			<c:if test="${(listcorrectanswer.imagequestion==' ') && (listcorrectanswer.audiogg!=' ') && (listcorrectanswer.audiomp3!=' ')}">
							
								<p>${listcorrectanswer.num}. ${listcorrectanswer.question}</p>
								
										<br/>
										<p>
										<audio controls>
										    <source src="Image_AudioExam/${listcorrectanswer.audiogg }" type="audio/ogg">
										    <source src="Image_AudioExam/${listcorrectanswer.audiomp3 }" type="audio/mpeg">
										</audio>
										</p>
								  <c:if test="${listcorrectanswer.correctanswer == 'A'}">
								 <p style="color:red"> Đáp án đúng A</p>
							   </c:if>
							    <c:if test="${listcorrectanswer.correctanswer == 'B'}">
								 <p style="color:red"> Đáp án đúng B</p>
							   </c:if>
							    <c:if test="${listcorrectanswer.correctanswer == 'C'}">
								 <p style="color:red">Đáp án đúng C</p>
							   </c:if>
							    <c:if test="${listcorrectanswer.correctanswer == 'D'}">
								 <p style="color:red"> Đáp án đúng D</p>
							   </c:if>
			</c:if>
			<c:if test="${(listcorrectanswer.imagequestion==' ') && (listcorrectanswer.audiogg==' ') && (listcorrectanswer.audiomp3==' ')}">
							
								<p>${listcorrectanswer.num}. ${listcorrectanswer.question}</p>
								
							 <c:if test="${listcorrectanswer.correctanswer == 'A'}">
									  
							
							 <c:set var="kq" value="${fn:replace(listcorrectanswer.paragrap,kitudb1,kituhtml1) }"/>
			                          	<c:out value="${kq }" escapeXml="false"/> 
						
								<img alt="" src="Image/correct.png">${listcorrectanswer.option1}
								<br>
								  ${listcorrectanswer.option2}
								<br>
								  ${listcorrectanswer.option3}
								<br>
								  ${listcorrectanswer.option4}
								<br>
							</c:if>
								
								  <c:if test="${listcorrectanswer.correctanswer == 'B'}">
							 <c:set var="kq" value="${fn:replace(listcorrectanswer.paragrap,kitudb1,kituhtml1) }"/>
			                          	<c:out value="${kq }" escapeXml="false"/> 
						
								  ${listcorrectanswer.option1}
								<br>
								  <img alt="" src="Image/correct.png">${listcorrectanswer.option2}
								<br>
								  ${listcorrectanswer.option3}
								<br>
								  ${listcorrectanswer.option4}
								<br>
							</c:if>
							
							
							
							<c:if test="${listcorrectanswer.correctanswer == 'C'}">
							
								 <c:set var="kq" value="${fn:replace(listcorrectanswer.paragrap,kitudb1,kituhtml1) }"/>
			                          	<c:out value="${kq }" escapeXml="false"/>  
						
								  ${listcorrectanswer.option1}
								<br>
								  ${listcorrectanswer.option2}
								<br>
								  <img alt="" src="Image/correct.png">${listcorrectanswer.option3}
								<br>
								  ${listcorrectanswer.option4}
								<br>
							</c:if>
							
							
				
						
					
							<c:if test="${listcorrectanswer.correctanswer == 'D'}">
						 <c:set var="kq" value="${fn:replace(listcorrectanswer.paragrap,kitudb1,kituhtml1) }"/>
			                          	<c:out value="${kq }" escapeXml="false"/> 
								  ${listcorrectanswer.option1}
								<br>
								  ${listcorrectanswer.option2}
								<br>
								  ${listcorrectanswer.option3}
								<br>
								  <img alt="" src="Image/correct.png">${listcorrectanswer.option4}
								<br>
							

			</c:if>			
							
			</c:if>					
						
					      
					
					
				
			</c:forEach>
		
	
		</div>

	  </div>
	 </div>
<div class="span3">
			  <h2>Câu trả lời của bạn</h2>
		<div  class="thumbnail" style="height:400px">	
			<div class="reading_descoription" style="overflow: auto; height: 400px ">
				<c:forEach items="${ listansweruser}" var="list">
					 <div class="span1">
						 ${list.num }
					 </div>
						 ${list.answer }
					 <br/>
				</c:forEach>
			</div>
		</div>
		<br/>
			<input type="button" class="btn btn-primary" value="Xem kết quả thi" data-toggle="modal" data-target="#myModal"/>	
			<a href="Displaylistexam?pageid=1"role="button" class="btn btn-primary">Làm lại bài thi </a> 
</div>

</div>
<!--Footer
==========================-->

<jsp:include page="Footer.jsp"/>


<!--/.Footer-->
 <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
	    
		      <!-- Modal content-->
		      <div class="modal-content">
		        <div class="modal-header">
		          <button type="button" class="close" data-dismiss="modal">&times;</button>
		          <h4 class="modal-title">Kết quả bài làm</h4>
		        </div>
		        	
				        <div class="modal-body">
				         	<c:forEach items="${resultexam1 }" var="lists">
					     	  <div class="media">
					     	   	<div class="media-body">
					     	   		<h4>Số câu trả lời đúng:${lists.correctanswernum } </h4>
					     	   	</div>
							 </div>	
						     	
							 	
							</c:forEach>
				         </div>
		        <br/>
		        <div class="modal-footer">
			        <button class="btn btn-default" type="button" data-dismiss="modal">
						Thoát
					</button>
		        </div>
		      </div>
	     
    </div>
</div>

</body>
</html>

				        							
						    