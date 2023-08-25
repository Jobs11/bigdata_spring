<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .table1{
            width: 70%; /* 원하는 너비로 조정 */
            height: 600px; /* 원하는 높이로 조정 */
            margin: 100px auto 0; /* 가운데 정렬 */
            padding: 20px;
            border: 3px solid rgba(73, 71, 71, 0.88);
            font-size: 14px;
            color: #030303;
        }

        .button1 {
            margin: 30px auto 0; /* 각 입력 요소 사이의 간격 조정 */
        }

    </style>
</head>
<body>
<%@ include file="../include/sidebar.jsp" %>
<div style="text-align: center;" class="table1">
    <h1>게시판 목록</h1>
    <table class="table table-striped" style="text-align: center; border: 1px solid #ffffff">
        <tr>
            <th style="background-color: #939191; text-align: center;">번호</th>
            <th style="background-color: #939191; text-align: center;">제목</th>
            <th style="background-color: #939191; text-align: center;">작성자</th>
            <th style="background-color: #939191; text-align: center;">등록일</th>
            <th style="background-color: #939191; text-align: center;">조회수</th>
        </tr>
        <c:forEach var="boardVO" items="${boardList}">
            <tr>
                <td>${boardVO.id}</td>
                <td style="text-align: left"><a href="BoardRead?id=${boardVO.id}">${boardVO.title}</a>
<%--                    <a href="../board/BoardRegister.jsp?id=${boardVO.id}">${boardVO.title}</a></td>--%>
                <td>${boardVO.userId}</td>
              <td><fmt:formatDate value="${boardVO.createDate}" pattern="yyyy-MM-dd"></fmt:formatDate> </td>
                <td>${boardVO.cnt}</td>
            </tr>
        </c:forEach>
    </table>
    <div style="text-align: right;" class="button1" >
    <a href="./BoardRegister" class="btn btn-primary"  >새글 등록</a>
<%--    <a href="./BoardDelete" class="btn btn-danger" >삭제</a>--%>
    </div>

</div>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="js/bootstrap.js"></script>
</body>
</html>