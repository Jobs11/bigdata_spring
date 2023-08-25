<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<script>
    function validateForm() {
        var userId = document.forms["insert"]["userId"].value;
        var name = document.forms["insert"]["name"].value;
        var password = document.forms["insert"]["password"].value;
        var password_con = document.forms["insert"]["password_con"].value;

        if (userId === "" || name === "" || password === "" || password_con === "") {
            alert("모든 필드를 입력해주세요.");
            return false; // 폼 제출을 막음
        }
        // 나머지 유효성 검사 로직 (비밀번호 일치 등)
    }
</script>
<body>
<%--    <form method="post" action="../member/insert" name="insert">
        아이디: <input type="text" name="userId">
        비밀번호: <input type="text" name="password">
        비밀번호 확인: <input type="text" name="password_con">
        이름: <input type="text" name="name">
        <button type="submit">전송</button>
    </form>--%>



    <section class="vh-100" style="background-color: #eee;">
        <div class="container h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-lg-12 col-xl-11">
                    <div class="card text-black" style="border-radius: 25px;">
                        <div class="card-body p-md-5">
                            <div class="row justify-content-center">
                                <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">

                                    <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Sign up</p>

                                    <%-- message가 존재하는 경우에만 alert 메시지를 출력 --%>
<%--                                    <c:choose>--%>
<%--                                        <c:when test="${not empty message}">--%>
<%--                                            <script>--%>
<%--                                                alert("${message}");--%>
<%--                                            </script>--%>
<%--                                        </c:when>--%>
<%--                                        &lt;%&ndash; 메시지가 없는 경우 아무 것도 렌더링하지 않음 &ndash;%&gt;--%>
<%--                                        <c:otherwise></c:otherwise>--%>
<%--                                    </c:choose>--%>


                                    <form class="mx-1 mx-md-4" action = "/member/insert" name="insert" method="post"> <%--onsubmit="return validateForm()"> --%>


                                        <div class="d-flex flex-row align-items-center mb-4">
                                            <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                                            <div class="form-outline flex-fill mb-0">
                                                <input type="text" id="form3Example1c" class="form-control" name="userId"/>
                                                <label class="form-label" for="form3Example1c">Your Name</label>
                                            </div>
                                        </div>

                                        <div class="d-flex flex-row align-items-center mb-4">
                                            <i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
                                            <div class="form-outline flex-fill mb-0">
                                                <input type="text" id="form3Example3c" class="form-control" name="name"/>
                                                <label class="form-label" for="form3Example3c">Your Email</label>
                                            </div>
                                        </div>

                                        <div class="d-flex flex-row align-items-center mb-4">
                                            <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                                            <div class="form-outline flex-fill mb-0">
                                                <input type="password" id="form3Example4c" class="form-control" name="password"/>
                                                <label class="form-label" for="form3Example4c">Password</label>
                                            </div>
                                        </div>

                                        <div class="d-flex flex-row align-items-center mb-4">
                                            <i class="fas fa-key fa-lg me-3 fa-fw"></i>
                                            <div class="form-outline flex-fill mb-0">
                                                <input type="password" id="form3Example4cd" class="form-control" name="password_con"/>
                                                <label class="form-label" for="form3Example4cd">Repeat your password</label>
                                            </div>
                                        </div>


                                        <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                                            <button type="submit" class="btn btn-primary btn-lg">Register</button>
                                        </div>

                                    </form>

                                </div>
                                <div class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">

                                    <img src="/image/insert.png" class="img-fluid" alt="Sample image">

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>


</body>
</html>


