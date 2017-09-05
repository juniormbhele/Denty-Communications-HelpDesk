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
    <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css" integrity="sha384-" crossorigin="anonymous">
    <link href="css/style.css" rel="stylesheet" />
    <link href="css/bootstrap.css" rel="stylesheet" media="screen">
    <link href="css/bootstrap.min.css" rel="stylesheet" />
    <link href="css/fancybox/jquery.fancybox.css" rel="stylesheet">
    <link href="css/jscarousel.css" rel="stylesheet" />
    <link href="css/flexslider.css" rel="stylesheet" />
    <script language="JavaScript" type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.0/jquery-ui.min.js"></script>
    <script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
    <script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
    <script src="js/switch.js"></script>
    <link href='http://fonts.googleapis.com/css?family=Cookie' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="css/layouts/email.css">

</head>
<body>

<!-- start header -->
<header class="header-basic-light">
    <link rel="icon" href="about-img.png">
    <div class="header-limiter">

        <h1><a href="home.jsp">Denty Group<span>: Helpdesk</span></a></h1>

        <nav>
            <a href="home.jsp" class="selected">Home</a>
            <a href="#" >Tickets</a>
            <a href="#">About Us</a>
            <a href="#">Contact</a>
            <a href="index.jsp">Sign Out</a>
        </nav>
    </div>

</header>
<!-- end header -->

<!-- Weclome message -->

<section id="welcome">
    <div class="inner">
        <span class="icon major fa-cloud"></span>
        <h1>Hi, Welcome <strong>${userMessage}</strong>. </h1>
        <p>You can check tickets assigned to you </p>
        <ul class="actions">
            <li></li>
        </ul>
    </div>
</section>






<footer>

    <div id="login-page">
        <p class="copyright2">Designed by <a href="https://dentycommunications.co.za" target="_blank" title="Denty Communications">Denty Communications</a></p>
    </div>
</footer>

<!-- javascript
    ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/jquery.scrolly.min.js"></script>
<script src="assets/js/skel.min.js"></script>
<script src="assets/js/util.js"></script>
<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
<script src="assets/js/main.js"></script>

<script src="https://yui-s.yahooapis.com/3.18.1/build/yui/yui-min.js"></script>
<script>
    YUI().use('node-base', 'node-event-delegate', function (Y) {

        var menuButton = Y.one('.nav-menu-button'),
                nav        = Y.one('#nav');

        // Setting the active class name expands the menu vertically on small screens.
        menuButton.on('click', function (e) {
            nav.toggleClass('active');
        });

        // Your application code goes here...

    });
</script>


</body>
</html>
