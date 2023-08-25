<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .register {
            width: 70%; /* 원하는 너비로 조정 */
            height: 600px; /* 원하는 높이로 조정 */
            margin: 100px auto 0; /* 가운데 정렬 */
            padding: 20px;
            border: 3px solid rgba(73, 71, 71, 0.88);
            font-size: 14px;
            color: #030303;
        }

        .form-group {
            margin: 30px auto 0; /* 각 입력 요소 사이의 간격 조정 */
        }

    </style>
</head>
<body>
<%@ include file="../include/sidebar.jsp" %>
<div class="register">
    <h1>새로운 게시물</h1>
    <form action="../board/BoardRegister" method="post">
        <div class="form-group">
            <label for="title">게시글 제목</label>
            <input type="hidden" name="id" value="${boardRead.id}" readonly>
            <input type="text" class="form-control" id="title" name="title" value="${boardRead.title}" readonly>
        </div>
        <div class="form-group">
            <label for="userId">작성자</label>
            <input type="text" class="form-control" id="userId" name="userId" value="${boardRead.userId}" readonly>
        </div>
        <div class="form-group">
            <label for="content">게시글 내용</label>
            <input type="text" class="form-control" row="7" id="content" name="content" value="${boardRead.content}" readonly>
        </div>

            <a href="./BoardUpdate?id=${boardRead.id}" class="btn btn-primary"  >수정</a>
            <a href="./BoardDelete?id=${boardRead.id}" class="btn btn-danger" >삭제</a>

    </form>
</div>
</body>
<%--<body>--%>
<%--<%@ include file="../include/sidebar.jsp" %>--%>
<%--<div class="register">--%>
<%--    <input type="hidden" name="id" value="${boardRead.id}" readonly>--%>
<%--    <input type="text" name="userId" value="${boardRead.userId}" readonly>--%>
<%--    <input type="text" name="title" value="${boardRead.title}" readonly>--%>
<%--    <input type="text" name="content" value="${boardRead.content}" readonly>--%>

<%--    <a href="./BoardUpdate?id=${boardRead.id}">수정 하기</a>--%>
<%--    <a href="./BoardDelete?id=${boardRead.id}">삭제 하기</a>--%>
<%--    <button type="submit">전송</button>--%>
<%--    <button type="reset">초기화</button>--%>


<%--</div>--%>
</body>
</html>