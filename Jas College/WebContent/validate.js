function validate()
{
    if(   document.getElementById("user").value == "admin"
       && document.getElementById("pass").value == "jarvis" )


    {
        alert( "validation succeeded" );
        location.href="dashboard.jsp";
    }
    else
    {
        alert( "validation failed" );
        location.href="login.jsp";
    }
}