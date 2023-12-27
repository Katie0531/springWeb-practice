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
        <title>diaryModify</title>
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
	        <header class="masthead" style="background-image: url('assets/img/contact-bg.jpg')">
	            <div class="container position-relative px-4 px-lg-5">
	                <div class="row gx-4 gx-lg-5 justify-content-center">
	                    <div class="col-md-10 col-lg-8 col-xl-7">
	                        <div class="page-heading">
	                            <h2>게시글 수정하기</h2>

	                        </div>
	                    </div>
	                </div>
	            </div>
	        </header>
        <!-- Main Content-->
        <main class="mb-4">
            <div class="container px-4 px-lg-5">
                <div class="row gx-4 gx-lg-5 justify-content-center">
                    <div class="col-md-10 col-lg-8 col-xl-7">
                    <form action="diaryModifyProcBoard.do?seq=${bbiyakdiary.seq}" method="post">
                        <div class="my-5">
                                <div class="form-floating">
                                	<input type="hidden" name="seq" value="${bbiyakdiary.seq}">
                                    <input class="form-control" name="title" type="text" value="${bbiyakdiary.title}" placeholder="제목을 입력하세요" data-sb-validations="required" />
                                    <label for="name">제목</label>
                                    <div class="invalid-feedback" data-sb-feedback="name:required">필수 항목입니다.</div>
                                </div>
                                <div class="form-floating">
                                    <p class="form-control" name="writer" type="text" value="${bbiyakdiary.writer}" data-sb-validations="required" />
                                    <label for="name">작성자</label>
                                    <div class="invalid-feedback" data-sb-feedback="name:required">필수 항목입니다.</div>
                                </div>
                                </div>
                                <div class="form-floating">
                                    <input class="form-control" name="contnet" type="text" value="${bbiyakdiary.content}" placeholder="내용을 입력하세요" style="height: 12rem" data-sb-validations="required"/>
                                    <label for="message">내용</label>
                                    <div class="invalid-feedback" data-sb-feedback="name:required">필수 항목입니다.</div>
                                </div>
                                <br />
                                <!-- Submit success message-->
                                <!---->
                                <!-- This is what your users will see when the form-->
                                <!-- has successfully submitted-->
                                <div class="d-none" id="submitSuccessMessage">
                                    <div class="text-center mb-3">
                                        <div class="fw-bolder">게시글을 수정했어요!</div>
                                        <br />
                                        <a href="https://startbootstrap.com/solution/contact-forms">https://startbootstrap.com/solution/contact-forms</a>
                                    </div>
                                </div>
                                <!-- Submit Button-->
                                <input type="submit" value="수정" onclick="location.href='diaryBoard.do'">

                            </form>
                        </div>
                    </div>
                </div>
        </main>
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
        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
        <!-- * *                               SB Forms JS                               * *-->
        <!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
        <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
    </body>
</html>
