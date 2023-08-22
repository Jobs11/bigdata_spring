<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <form method="post" action="../member/insert" name="insert">
        아이디: <input type="text" name="id">
        비밀번호: <input type="text" name="password">
        비밀번호 확인: <input type="text" name="password_con">
        이름: <input type="text" name="name">
        <button type="submit">전송</button>
    </form>
</body>
</html>