<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>농작물 게시판</title>
</head>
<body>
<%@ include file="../include/sidebar.jsp" %>
<div class='tableauPlaceholder' id='viz1692334755775' style='position: relative'>
    <noscript>
        <a href='#'>
            <img alt='대시보드 1' src='https:&#47;&#47;public.tableau.com&#47;static&#47;images&#47;te&#47;test2_16923347377480&#47;1&#47;1_rss.png'
                 style='border: none'/>
        </a>
    </noscript>
<body>
<div style="text-align: center;">
    <h1>게시판 목록</h1>
    <table style="width: 700px; margin: auto">
        <tr>
            <th style="width: 10%">번호</th>
            <th style="width: 50%">제목</th>
            <th style="width: 15%">작성자</th>
            <th style="width: 15%">등록일</th>
            <th style="width: 10%">조회수</th>
        </tr>
        <c:forEach var="boardVO" items="${boardList}">
            <tr>
                <td>${boardVO.id}</td>
                <td style="text-align: left"><a href="getBoardVO?Id=${boardVO.id}">${boardVO.title}</a></td>
                <td>${boardVO.userId}</td>
                <td><fmt:formatDate value="${boardVO.createDate}" pattern="yyyy-MM-dd"></fmt:formatDate> </td>
                <td>${boardVO.cnt}</td>
            </tr>
        </c:forEach>
    </table>
    <a href="insertBoard">새글 등록</a>
</div>
</body>
</html>