<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div style="text-align: center;">
    <h1>게시판 목록</h1>
    <c:forEach items="${boardList}" var="board">
    <p><c:out value="${board.id}"/>
    <p><c:out value="${board.title}"/>
    <p><c:out value="${board.userId}"/>
    <p><c:out value="${board.content}"/>
    <p><c:out value="${board.createDate}"/>
        </c:forEach>
        <%--    <table style="width: 700px; margin: auto">--%>
        <%--        <tr>--%>
        <%--            <th style="width: 10%">번호</th>--%>
        <%--            <th style="width: 50%">제목</th>--%>
        <%--            <th style="width: 15%">작성자</th>--%>
        <%--            <th style="width: 15%">등록일</th>--%>
        <%--            <th style="width: 10%">조회수</th>--%>
        <%--        </tr>--%>
        <%--        <c:forEach var="boardVO" items="${boardList}">--%>
        <%--            <tr>--%>
        <%--                <td>${boardVO.Id}</td>--%>
        <%--                <td style="text-align: left"><a href="getBoardVO?Id=${boardVO.Id}">${boardVO.title}</a></td>--%>
        <%--                <td>${boardVO.writer}</td>--%>
        <%--                <td><fmt:formatDate value="${boardVO.createDate}" pattern="yyyy-MM-dd"></fmt:formatDate> </td>--%>
        <%--                <td>${boardVO.cnt}</td>--%>
        <%--            </tr>--%>
        <%--        </c:forEach>--%>
        <%--    </table>--%>
        <a href="insertBoard">새글 등록</a>
</div>
</body>
</html>