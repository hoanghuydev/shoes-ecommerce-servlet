<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="custom-navbar navbar navbar navbar-expand-md navbar-dark bg-dark" arial-label="Furni navigation bar">

    <div class="container">
        <a class="navbar-brand" href="index.html">Furni<span>.</span></a>

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarsFurni" aria-controls="navbarsFurni" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarsFurni">
            <ul class="custom-navbar-nav navbar-nav ms-auto mb-2 mb-md-0">
                <li class="nav-item active">
                    <a class="nav-link" href="/home">Home</a>
                </li>
                <li><a class="nav-link" href="shop.html">Shop</a></li>
                <li><a class="nav-link" href="about.html">About us</a></li>
                <li><a class="nav-link" href="services.html">Services</a></li>
                <li><a class="nav-link" href="blog.html">Blog</a></li>
                <li><a class="nav-link" href="contact.html">Contact us</a></li>
            </ul>
            <ul class="custom-navbar-cta navbar-nav mb-2 mb-md-0 ms-5">

                <li>
                        <div class="dropdown nav-link">
                            <div class="" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                                <img src="/template/web/images/user.svg">
                            </div>

                            <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                                <c:if test="${not empty USER_MODEL}">
                                    <li><a class="dropdown-item" href="#">${USER_MODEL.fullName}</a></li>
                                    <li><a class="dropdown-item" href="/sign-out">Sign out</a></li>

                                </c:if>
                                <c:if test="${empty USER_MODEL}">
                                    <li><a class="dropdown-item" href="/sign-in">Sign In</a></li>
                                    <li><a class="dropdown-item" href="/sign-up">Sign Up</a></li>
                                </c:if>
                            </ul>
                        </div>
                </li>
                <li><a class="nav-link" href="cart.html"><img src="/template/web/images/cart.svg"></a></li>
            </ul>
        </div>
    </div>

</nav>