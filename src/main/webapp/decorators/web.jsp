<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="author" content="Untree.co">
    <link rel="shortcut icon" href="<c:url value="https://www.nike.com/favicon.ico"/> ">

    <meta name="description" content="" />
    <meta name="keywords" content="bootstrap, bootstrap4" />

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/toastify-js/src/toastify.min.css">
    <link href="<c:url value="/template/web/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/template/web/css/tiny-slider.css"/>" rel="stylesheet">
    <link href="<c:url value="/template/web/css/custom.css"/>" rel="stylesheet">
    <link href="<c:url value="/template/web/css/style.css"/>" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <title><dec:title default="Nai Shoes & Sneakers"/></title>
</head>

<body>

<!-- Start Header/Navigation -->
<%@ include file="/common/web/header.jsp" %>
<!-- End Header/Navigation -->
<dec:body/>
<!-- Start Footer Section -->
<%@ include file="/common/web/footer.jsp" %>
<!-- End Footer Section -->
<script src="<c:url value="/template/web/js/bootstrap.bundle.min.js"/>"></script>
<script src="<c:url value="/template/web/js/tiny-slider.js"/>"></script>
<script src="<c:url value="/template/web/js/custom.js"/>"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/toastify-js"></script>
<c:if test="${not empty toast && not empty message}">
    <script>
        window.addEventListener("DOMContentLoaded",function (){
            Toastify({
                text: '${message}',
                duration: 3000,
                className: "bg-${toast}",
                close: true,
                gravity: "top", // `top` or `bottom`
                position: "right",
            }).showToast();
        })
    </script>

</c:if>
</body>

</html>

