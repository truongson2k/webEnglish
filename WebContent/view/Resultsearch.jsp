 <%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tiếng Anh Mỗi Ngày</title>
<script type="text/javascript">
				
		
				
				function Search()
				{
					var xhttp;
					var name = document.myform.name.value;
					
					if (name != "")
					{
						var url = "SearchController?name="+name;
						
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

<div class="row">
	<div class="span6">
		<div class="page-header">
			<h3>
			  Kết quả tìm kiếm
			</h3>
</div>
	</div>
		</div>
		
<%
if(request.getAttribute("ketqua")!=null)
 {
%>
  <div class="row">
     <div class="span6">
			<div class="media">
			<%=request.getAttribute("ketqua") %>
			</div>
		</div>
</div>
<%
 }
else 
{
%>
<div class="row">
	<c:forEach items="${listsearch}" var="list">
		<div class="span6">
			<div class="media">
				 <a href="#" class="pull-left"><img src="Imageupload/${list.grammarimage }" class="media-object" alt='' width="128px" height="128px"/></a>
				    <div class="media-body">
					    <p>  ${list.grammarname }  </p>
					 	<a href="chitietnguphapforward?ma=${list.idgrammar }" class="btn" type="button">Xem bài hướng dẫn</a>
				    </div>
			</div>
			
		</div>
	</c:forEach>
	<%
 }

%>
</div>
</body>
</html>