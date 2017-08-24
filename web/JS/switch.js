$(document).ready(function()
{
    $("#btnCreate").click(function()
    {

        $("#register").animate({ height: "toggle", opacity: "toggle" }, "slow");
        $('#login').hide();
    });


    $("#BtnSignIn").click(function()
    {

        $("#login").animate({ height: "toggle", opacity: "toggle" }, "slow");
        $('#register').hide();
    });


})

