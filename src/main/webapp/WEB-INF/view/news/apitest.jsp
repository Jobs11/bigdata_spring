<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<%@ include file="../include/sidebar.jsp" %>
    <c:forEach items="${news}" var="news">
        <h1><c:out value="${news.title}"/></h1>
        <p> <c:out value="${news.originallink}"/> </p>
        <img src="<c:out value="${news.link}"/>" />
        <p> <c:out value="${news.description}"/> </p>
        <p> <c:out value="${news.pubDate}"/> </p>

    </c:forEach>


</body>
</html>