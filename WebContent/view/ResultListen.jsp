 <%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
  <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body> 


	 <c:forEach items="${resultlisten }" var="list"> 
		
					    <c:if test="${list.correctanswer == 'A'}">
					 
							<c:if test="${kq == 'A'}">
								<p>${list.num}. ${list.question}</p>
								<p>
								  <img alt="" src="Image/correct.png"> ${list.option1}
								</p>
								<p>
								  ${list.option2}
								</p>
								<p>
								  ${list.option3}
								</p>
								<p>
								  ${list.option4}
								</p>
							</c:if>
								
							<c:if test="${kq == 'B'}">
							
								<p>${list.num}. ${list.question}</p>
								<p>
								  <img alt="" src="Image/correct.png">${list.option1}
								</p>
								<p>
								  <img alt="" src="Image/incorrect.png">${list.option2}
								</p>
								<p>
								  ${list.option3}
								</p>
								<p>
								  ${list.option4}
							 </p>
							</c:if>
							
							<c:if test="${kq == 'C'}">
						
								<p>${list.num}. ${list.question}</p>
								<p>
								  <img alt="" src="Image/correct.png">${list.option1}
								</p>
								<p>
								  ${list.option2}
								</p>
								<p>
								  <img alt="" src="Image/incorrect.png">${list.option3}
								</p>
								<p>
								  ${list.option4}
								</p>
							</c:if>
							
							<c:if test="${kq == 'D'}">
						
								<p>${list.num}. ${list.question}</p>
								<p>
								  <img alt="" src="Image/correct.png">${list.option1}
								</p>
								<p>
								  ${list.option2}
								</p>
								<p>
								  ${list.option3}
								</p>
								<p>
								  <img alt="" src="Image/incorrect.png">${list.option4}
								</p>
							</c:if>
					
					</c:if>
					
					<c:if test="${list.correctanswer == 'B'}">
						
							<c:if test="${kq == 'A'}">
								<p>${list.num}. ${list.question}</p>
								  <img alt="" src="Image/incorrect.png">${list.option1}
								<br>
								  <img alt="" src="Image/correct.png"> ${list.option2}
								<br>
								  ${list.option3}
								<br>
								  ${list.option4}
								<br>
							</c:if>
								
							<c:if test="${kq == 'B'}">
								<p>${list.num}. ${list.question}</p>
								  ${list.option1}
								<br>
								  <img alt="" src="Image/correct.png">${list.option2}
								<br>
								  ${list.option3}
								<br>
								  ${list.option4}
								<br>
							</c:if>
							
							<c:if test="${kq == 'C'}">
								<p>${list.num}. ${list.question}</p>
								  ${list.option1}
								<br>
								  <img alt="" src="Image/correct.png">${list.option2}
								<br>
								  <img alt="" src="Image/incorrect.png">${list.option3}
								<br>
								  ${list.option4}
								<br>
							</c:if>
							
							<c:if test="${kq == 'D'}">
								<p>${list.num}. ${list.question}</p>
								  ${list.option1}
								<br>
								  <img alt="" src="Image/correct.png">${list.option2}
								<br>
								  ${list.option3}
								<br>
								  <img alt="" src="Image/incorrect.png">${list.option4}
								<br>
							</c:if>
					
					
					</c:if>
					<c:if test="${list.correctanswer == 'C'}">
						
							<c:if test="${kq == 'A'}">
								<p>${list.num}. ${list.question}</p>
								<p>
								  <img alt="" src="Image/incorrect.png">${list.option1}
								 </p>
								<p>
								   ${list.option2}
								   </p>
								<p>
								  <img alt="" src="Image/correct.png">${list.option3}
								  </p>
							   <p>
								  ${list.option4}
								</p>
							
							</c:if>
								
							<c:if test="${kq == 'B'}">
								<p>${list.num}. ${list.question}</p>
								  ${list.option1}
								<br>
								  <img alt="" src="Image/incorrect.png">${list.option2}
								<br>
								  <img alt="" src="Image/correct.png">${list.option3}
								<br>
								  ${list.option4}
								<br>
							</c:if>
							
							<c:if test="${kq== 'C'}">
								<p>${list.num}. ${list.question}</p>
								  ${list.option1}
								<br>
								  ${list.option2}
								<br>
								  <img alt="" src="Image/correct.png">${list.option3}
								<br>
								  ${list.option4}
								<br>
							</c:if>
							
							<c:if test="${kq == 'D'}">
								<p>${list.num}. ${list.question}</p>
								  ${list.option1}
								<br>
								  ${list.option2}
								<br>
								  <img alt="" src="Image/correct.png">${list.option3}
								<br>
								  <img alt="" src="Image/incorrect.png">${list.option4}
								<br>
							</c:if>
					
					
					</c:if>
					<c:if test="${list.correctanswer == 'D'}">
						
					
							<c:if test="${kq == 'A'}">
								<p>${list.num}. ${list.question}</p>
								  <img alt="" src="Image/incorrect.png">${list.option1}
								<br>
								  ${list.option2}
								<br>
								  ${list.option3}
								<br>
								  <img alt="" src="Image/correct.png">${list.option4}
								<br>
							</c:if>
								
							<c:if test="${kq == 'B'}">
								<p>${list.num}. ${list.question}</p>
								  ${list.option1}
								<br>
								  <img alt="" src="Image/incorrect.png">${list.option2}
								<br>
								  ${list.option3}
								<br>
								  <img alt="" src="Image/correct.png">${list.option4}
								<br>
							</c:if>
							
							<c:if test="${kq == 'C'}">
								<p>${list.num}. ${list.question}</p>
								  ${list.option1}
								<br>
								  ${list.option2}
								<br>
								  <img alt="" src="Image/incorrect.png">${list.option3}
								<br>
								  <img alt="" src="Image/correct.png">${list.option4}
								<br>
							</c:if>
							
							<c:if test="${kq == 'D'}">
								<p>${list.num}. ${list.question}</p>
								  ${list.option1}
								<br>
								  ${list.option2}
								<br>
								  ${list.option3}
								<br>
								  <img alt="" src="Image/correct.png">${list.option4}
								<br>
							</c:if>
				</c:if>
		</c:forEach>
</body>
</html>