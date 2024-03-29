<%-- 
    Document   : AdminPage
    Created on : Jun 5, 2022, 10:44:11 AM
    Author     : Trung Duong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>PAGE ADMIN</title>
        <link rel="stylesheet" href="css/style.css">
        <style>
            @import url('https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap');
        </style>
        <link rel="stylesheet" href="node_modules/bootstrap/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="fonts/themify-icons/themify-icons.css">
        <link rel="icon" href="./img/word-image-1047.jpg" type="image/x-icon">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
              integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
        <script src="node_modules/jquery/dist/jquery.slim.min.js"></script>
        <script src="node_modules/popper.js/dist/umd/popper.min.js"></script>
        <script src="node_modules/bootstrap/dist/js/bootstrap.min.js"></script>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    </head>

    <body>
        <c:set var="AdminName" value="${sessionScope.AdminName}}" />
        <c:if test="${AdminName == ''}">
            <h1>You Must Login To View This</h1>   
        </c:if>
        <c:if test="${AdminName != ''}">
            <!-- navbar -->
            <div class="navbar-top">
                <div class="navbar-header">
                    <!-- logo -->
                    <div class="col-sm-3 logo">
                        <a href="getAllAccount"><img src="./img/logo.png" height="80" alt=""></a>
                    </div>
                    <!-- name web -->
                    <div class="col-sm-6 d-flex align-items-center justify-content-center text-center name-website">
                        <a href="#">DRS - FPT University HCM</a>
                    </div>
                    <!-- welcome -->
                    <div class="col-sm-3 welcome d-flex align-items-center justify-content-end">
                        <div class="nav-item dropdown ">
                            <a class="nav-link dropdown-toggle d-flex align-items-center justify-content-end user-info"
                               href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown">
                                <img src="${sessionScope.Admin.picture}"
                                     class="rounded-circle" height="25">
                                <p class="user-name">${sessionScope.Admin.name}</p>
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                <li>
                                    <a class="dropdown-item" href="myprofile.jsp">My profile</a>
                                </li>
                                <li>
                                    <a class="dropdown-item" href="MainController?action=Logout">Logout</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>

                <!-- search -->
                <div class="seach-wapper">
                    <div class="search-left col-sm-8 order-md-first">

                    </div>
                    <div class="search col-sm-4 order-md-last">
                        <form action="MainController" method="POST" id="search-box">
                            <div class="row search-box-wrapper">
                                <input type="text" name="searchID" value="${requestScope.searchID}" id="search-text" class="col-10" placeholder="Search">
                                <button id="search-btn" type="submit" name="action" value="SearchByID" class="col-2"><i class="fas fa-search "></i></button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <c:set var="accounts" value="${requestScope.accounts}"></c:set>
            <c:if test="${empty accounts}">
                <h1>Account list is empty</h1>
            </c:if>
            <c:if test="${not empty accounts}">
                <!-- table -->
                <div class="table-all">
                    <div class="table-wapper col-sm-12">
                        <table class="table text-center">
                            <thead>
                                <tr>
                                    <th>STT</th>
                                    <th>Họ và Tên</th>
                                    <th>ID</th>
                                    <th>Phone</th>
                                    <th>Email</th>
                                    <th>Role</th>
                                    <th>Position</th>
                                    <th>Status</th>
                                    <th>Update button</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:set var="count" value="1"></c:set>
                                <c:forEach var="acc" items="${accounts}">
                                    <tr>
                                        <td>${count}</td>
                                        <td>${acc.userName}</td>
                                        <td>${acc.userID}</td>
                                        <td>${acc.phone}</td>
                                        <td>${acc.email}</td>
                                        <td>${acc.roleID}</td>
                                        <td>${acc.position}</td>
                                        <td>${acc.status == 1 ? "Acctive" : "InActive"}</td>
                                        <td>
                                            <form action="MainController" method="POST">
                                                <input value="${acc.userID}" name="userID" type="hidden"/>
                                                <input type="hidden" value="${acc.status}" name="status"/>
                                                <input type="hidden" value="${acc.email}" name="email" />
                                                <input type="hidden" value="UpdateAccountStatus" name="action"/>
                                                <c:if test="${acc.roleID != 'AD'}">
                                                    <input type="submit" value="${acc.status == 1 ? "Block" : "UnBlock"}" class="btn btn-danger"></input>
                                                </c:if>
                                                <c:if test="${acc.roleID == 'AD'}">
                                                    <input type="button" value="See Only" class="btn btn-success"></input>
                                                </c:if>
                                            </form>
                                        </td>
                                    </tr>
                                    <c:set var="count" value="${count + 1}"></c:set>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </c:if>

            <footer class="footer-distributed">
                <div class="footer-left">
                    <h3>Company<span>DRS</span></h3>
                    <p class="footer-company-name">Company DRS © 2022</p>
                </div>
                <div class="footer-center">
                    <div>
                        <i class="fa fa-map-marker"></i>
                        <p><span>Đại học FPT</span> KCN - TP.Thủ Đức - TP.HCM</p>
                    </div>
                    <div>
                        <i class="fa fa-phone"></i>
                        <p>3463452343</p>
                    </div>
                    <div>
                        <i class="fa fa-envelope"></i>
                        <p><a href="mailto:admin@gmail.com">admin@gmail.com</a></p>
                    </div>
                </div>
                <div class="footer-right">
                    <p class="footer-company-about">
                        <span>About the company</span>
                        The company specializes in providing and leasing IT equipment to businesses and companies in need.
                    </p>
                    <div class="footer-icons">
                        <a href="https://www.facebook.com/"><i class="ti-facebook"></i></a>
                        <a href="https://www.twitter.com/"><i class="ti-twitter"></i></a>
                        <a href="https://www.instagram.com/"><i class="ti-instagram"></i></a>
                        <a href="https://www.github.com/"><i class="ti-github"></i></a>
                    </div>
                </div>
            </footer>
        </c:if>
        <input type="hidden" value="${requestScope.MESSAGE}" id="MESSAGE"/>
        <script>
            var MESSAGE = document.getElementById("MESSAGE").value;
            if (MESSAGE !== "") {
                alert(MESSAGE);
            }
        </script>
    </body>
</html>
