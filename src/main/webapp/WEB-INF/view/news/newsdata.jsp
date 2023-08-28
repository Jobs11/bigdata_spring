<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Shop Homepage - Start Bootstrap Template</title>
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
    <link href="css/styles1.css" rel="stylesheet" />
    <title>Title</title>
</head>
<body>
<%@ include file="../include/sidebar.jsp" %>
<!-- Header-->
<header class="bg-dark py-5">
    <div class="container px-4 px-lg-5 my-5">
        <div class="text-center text-white">
            <h1 class="display-4 fw-bolder">뉴스 검색!</h1>
            <p class="lead fw-normal text-white-50 mb-0">Collecting News Search Data</p>
            <p class="lead fw-normal text-white-50 mb-0">"${search}" 검색 결과</p>
            <form method="get" action="../news/newsdata">
                <div class="row">
                    <div class="col">
                        <input class="form-control form-control-lg" id="emailAddressBelow" name="search" type="text" placeholder="뉴스 검색 데이터 수집" />
                    </div>
                    <div class="col-auto"><button class="btn btn-primary btn-lg" id="submitButton" type="submit">검색</button></div>
                </div>
            </form>
        </div>
    </div>
</header>
<!-- Section-->
<section class="py-5">
    <div class="container px-4 px-lg-5 mt-5">
        <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
            <c:forEach items="${news}" var="news">

                <div class="col mb-5">
                    <div class="card h-100">
                        <!-- Product image-->
                        <img class="card-img-top" src="${not empty news.imgurl ? news.imgurl : "/image/news.png"}" alt="..." />
                        <!-- Product details-->
                        <div class="card-body p-4">
                            <div class="text-center">
                                <!-- Product name-->
                                <h5 class="fw-bolder"><c:out value="${news.title}"/></h5>
                                <!-- Product price-->
                                <p> <c:out value="${news.description}"/> </p>
                                <p> <c:out value="${news.newspaper}"/> </p>
                                <p> <c:out value="${news.pubDate}"/> </p>
                            </div>
                        </div>
                        <!-- Product actions-->
                        <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                            <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="<c:out value="${news.link}"/>">보러 가기</a></div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>

        <div class="pull-right">
            <ul class="pagination justify-content-center">
                <c:if test="${paging > 1 }">
                    <li class="page-item previous"><a  class="page-link" href="../news/newsdata?search=${search}&p=${paging-1}">이전</a></li>
                </c:if>

                    <li class="page-item"><a class="page-link" href="#">${paging}</a></li>
                <c:if test="${paging > 0}">
                    <li class="page-item Next"><a class="page-link" href="../news/newsdata?search=${search}&p=${paging+1}">다음</a></li>
                </c:if>
            </ul>
        </div>
    </div>
</section>
<!-- Footer-->
<footer class="py-5 bg-dark">
    <div class="container"><p class="m-0 text-center text-white">펄스농</p></div>
</footer>
<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script src="js/scripts.js"></script>




</body>
</html>