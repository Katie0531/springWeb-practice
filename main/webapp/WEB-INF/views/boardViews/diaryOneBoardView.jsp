<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>복약게시글</title>
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Font Awesome icons (free version)-->
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="${path}/resources/css/styles2.css" rel="stylesheet" />
        <script src="${path}/resources/js/scripts2.js"></script>
    </head>
    <body>
        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-light" id="mainNav">
            <div class="container px-4 px-lg-5">
                <a class="navbar-brand" href="mainBoard.do">Bbiyak</a>
            </div>
        </nav>
        <!-- Page Header-->
        <header class="masthead" style="background-image: url('assets/img/home-bg.jpg')">
            <div class="container position-relative px-4 px-lg-5">
                <div class="row gx-4 gx-lg-5 justify-content-center">
                    <div class="col-md-10 col-lg-8 col-xl-7">
                        <div class="site-heading">
                            <h1>나의 복약일지</h1>
                            <span class="subheading">복약 상황을 자세하게 기록해 보세요!</span>
                        </div>
                    </div>
                </div>
            </div>
        </header>
        <!-- Main Content-->
        <div class="container px-4 px-lg-5">
            <div class="row gx-4 gx-lg-5 justify-content-center">
                <div class="col-md-10 col-lg-8 col-xl-7">
                
                    <!-- Post preview-->
                    <div class="post-preview">
					<c:choose>
                <c:when test="${not empty dList}">
                    <c:set var="bbiyakdiary" value="${dList}">
                        <div class="post-preview">
                            <h4 class="post-title">${board.title}</h4>
                           <h5 class="post-subtitle">${board.content}</h5>
                       	   <p class="post-meta">${board.writer}</p>
                 		   <div class="d-flex justify-content-end mb-4"><a class="btn btn-primary text-uppercase" href="diaryModifyBoard.do">수정</a></div>
       					   <div class="d-flex justify-content-end mb-4"><a class="btn btn-primary text-uppercase" href="diaryDeleteBoard.do">삭제</a></div>             
                    	   <div class="d-flex justify-content-end mb-4"><a class="btn btn-primary text-uppercase" href="diaryBoard.do">목록</a></div>	
                        </div>
                        <hr class="my-4" /> <!-- Separator line -->
                    </c:set>
                </c:when>
                <c:otherwise>
                    <p>No data available</p>
                </c:otherwise>
            </c:choose>					</div>
					
                          
                </div>
            </div>
        </div>
        <!-- Footer-->
        <footer class="border-top">
            <div class="container px-4 px-lg-5">
                <div class="row gx-4 gx-lg-5 justify-content-center">
                    <div class="col-md-10 col-lg-8 col-xl-7">
                        
                        <div class="small text-center text-muted fst-italic">Copyright &copy; 김효진 2023</div>
                    </div>
                </div>
            </div>
        </footer>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
    </body>
</html>
