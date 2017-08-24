<%--
  Created by IntelliJ IDEA.
  User: Sphiwe.Mbhele
  Date: 2017/08/17
  Time: 2:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DG : Help Desk</title>

    <!-- css -->
    <link href="CSS/style.css" rel="stylesheet" />
    <link href="CSS/bootstrap.min.css" rel="stylesheet" />
    <link href="CSS/fancybox/jquery.fancybox.css" rel="stylesheet">
    <link href="CSS/jcarousel.css" rel="stylesheet" />
    <link href="CSS/flexslider.css" rel="stylesheet" />
    <script language="JavaScript" type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.0/jquery-ui.min.js"></script>
    <script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
    <script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
    <script src="JS/switch.js"></script>
    <link href='http://fonts.googleapis.com/css?family=Cookie' rel='stylesheet' type='text/css'>

</head>
<body>

<!-- start header -->
<header class="header-basic-light">
    <link rel="icon" href="about-img.png">
    <div class="header-limiter">

        <h1><a href="index.jsp">Denty Group<span>: Helpdesk</span></a></h1>

        <nav>
            <a href="index.jsp" class="selected">Home</a>
            <a href="#" >Tickets</a>
            <a href="#">About Us</a>
            <a href="#">Contact</a>
        </nav>
    </div>

</header>
<!-- end header -->

<!-- Weclome message -->
<div></div>
<div class="welcomeMessage">${userMessage}</div>

<!-- Weclome message -->

<!-- login page -->
<div class="login-page">
    <div class="form">
        <form class="register-form" id="register" action="signUp" method="post">
            <h1>Register</h1>
            <input type="email" placeholder="email address" required="true"/>
            <input type="text" placeholder="Serial No" required="true"/>
            <input type="text" placeholder="username" required="true"/>
            <input type="password" placeholder="password" required="true"/>


            <button type="submit">create</button>
            <p class="message" id="BtnSignIn">Already registered? <a >Sign In</a></p>

        </form>
        <form class="login-form" action="login" method="post" id="login">
            <h1>Login</h1>
            <input name="username" type="text" placeholder="username" required="true"/>
            <input name="password" type="password" placeholder="password" required="true"/>
            <p class="forgot"><a href="forgotPassword.jsp">Forgot Password?</a></p>
            <button type="submit" id="BtnLogin">login</button>

            <p class="message">Not registered? <a href="#" id="btnCreate">Create an account</a></p>

            <div></div>
            <div></div>
            <div></div>
            <div class="error">${errorMessage}</div>

        </form>
    </div>
    <p class="copyright2">Designed by <a href="https://dentycommunications.co.za" target="_blank" title="Denty Communications">Denty Communications</a></p>
</div>

<footer>

    <div id="sub-footer">
        <div class="container">
            <div class="row">
                <div class="col-lg-6">
                    <div class="copyright">
                        <p>

                        </p>
                        <!--
                           Denty Group
                        -->
                    </div>
                </div>

            </div>
        </div>
    </div>
</footer>

<!-- javascript
    ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->



</body>
</html>
