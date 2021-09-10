<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
ol,ul {
    list-style: none;
    display:inline;
    color: green;
}
nav {
    background-color:#0B2F3A;
    height: 75px;
    padding-left:450px;
   
}
nav li {

    float: left;
    
    width: 120px;
    height: 75px;
    text-align: center;
 
    line-height: 75px;
}
nav a:hover{
    color: red;
}
nav a {
    text-decoration: none;
    color: white;
     text-align: center;
}

</style>
</head>
<body>
<%
  if(session.getAttribute("sessionuser")==null)
  {
%>
<div id="header-row">
    <div class="container">
      <div class="row">
              <!--LOGO-->
              <div class="span3"><a class="brand" href="homeforward"><img src="template/Frontend/Image/logo.png"/></a></div>
              <!-- /LOGO -->
              
            <!-- MAIN NAVIGATION -->  
              <div class="span9">
                <div class="navbar  pull-right">
                  <div class="navbar-inner">
                    <a data-target=".navbar-responsive-collapse" data-toggle="collapse" class="btn btn-navbar"><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></a>
                    <div class="nav-collapse collapse navbar-responsive-collapse">
                    <ul class="nav">
                      
                        <li><a href="loginController">Đăng nhập</a></li>
                         <li><a href="RegisterController">Đăng ký</a></li>
                        
                    </ul>
                  </div>

                  </div>
                </div>
              </div>
            <!-- MAIN NAVIGATION -->  
      </div>
    </div>
    <br/>
  <!--Begin Menu -->   
    <nav>
      <ul>
          <li><a href="homeforward">Trang Chủ</a></li>
          <li><a href="Dshdnguphapforward?pageid=1">Ngữ Pháp</a></li>
          <li><a href="DisplaylistVocabularyTopic?pageid=1">Từ Vựng</a></li>
          <li> <a href="DisplayListListen?pageid=1">Bài tập nghe</a></li>
          <li><a href="Displaylistexam?pageid=1">Đề Thi</a></li>
       
        
      </ul>
  </nav>
    <!--End Menu --> 
  </div>
  <%
  }
  else
  {
  %>
  <div id="header-row">
    <div class="container">
      <div class="row">
              <!--LOGO-->
              <div class="span3"><a class="brand" href="homeforward"><img src="template/Frontend/Image/logo.png" /></a></div>
              <!-- /LOGO -->

            <!-- MAIN NAVIGATION -->  
              <div class="span9">
                <div class="navbar  pull-right">
                  <div class="navbar-inner">
                    <a data-target=".navbar-responsive-collapse" data-toggle="collapse" class="btn btn-navbar"><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></a>
                    <div class="nav-collapse collapse navbar-responsive-collapse">
                    <ul class="nav">
                        <li class="light-blue dropdown-modal">
							<a data-toggle="dropdown" href="#" class="dropdown-toggle">
								
								<span class="user-info">
									
									Wellcome: ${sessionuser}
								</span>

								<i class="ace-icon fa fa-caret-down"></i>
							</a>

							<ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">

								<li class="divider"></li>

								<li>
									<a href="InformationUserfw?memberid=${sessionidmember}">
										<i class="ace-icon fa fa-power-off"></i>
										Thông tin cá nhân
									</a>
								</li>
							</ul>
						</li>
                       
                        <li><a href="Logoutcontroller">Đăng xuất</a></li>
                        
                    </ul>
                  </div>

                  </div>
                </div>
              </div>
            <!-- MAIN NAVIGATION -->  
      </div>
    </div>
    <br/>
 <!--Begin Menu -->
     <nav>
      <ul>
          <li><a href="homeforward">Trang Chủ</a></li>
          <li><a href="Dshdnguphapforward?pageid=1">Ngữ Pháp</a></li>
          <li><a href="DisplaylistVocabularyTopic?pageid=1">Từ Vựng</a></li>
          <li> <a href="DisplayListListen?pageid=1">Bài tập nghe</a></li>
          <li><a href="Displaylistexam?pageid=1">Đề Thi</a></li>
        
      </ul>
  </nav>
  <!--End Menu --> 
  </div>
  <%
  }
  %>
</body>
</html>