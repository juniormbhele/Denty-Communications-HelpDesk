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
    <link rel="stylesheet" href="CSS/layouts/email.css">

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

<!-- Email like response -->





<div id="layout" class="content pure-g">

    <div id="main" class="pure-u-1">
        <div class="email-content">
            <div class="email-content-header pure-g">
                <div class="pure-u-1-2">
                    <h1 class="email-content-title">Hello from Midrand  </h1>
                    <p class="email-content-subtitle">
                        From <a>Junior Denty</a> at <span>3:56pm, April 3, 2017</span>
                    </p>
                </div>

                <div class="email-content-controls pure-u-1-2">
                    <button class="secondary-button pure-button">Reply</button>
                    <button class="secondary-button pure-button">Forward</button>
                    <button class="secondary-button pure-button">Move to</button>
                </div>
            </div>

            <div class="email-content-body">
                <p>
                    Good day
                </p>
                <p>
                    I hope this email finds you in a good mood, Will you please help me out with my PC?
                </p>
                <p>
                   My number is 079 236 0784
                </p>
                <p>
                   I'm hoping to hear from you soon.
                </p>
                <p>
                    Regards,<br>
                    Junior
                </p>
            </div>
        </div>
    </div>
</div>






<!-- End of Email like -->



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
