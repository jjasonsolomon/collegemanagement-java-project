<!doctype html>
<html>

<head>
    <meta charset="utf-8">
    <title>
Login
    </title>
<link rel="stylesheet" href="http://localhost:8081/Jas_College/style.css">
<script type="text/javascript" src="http://localhost:8081/Jas_College/validate.js"></script>
</head>
<body>
    <div class="box">

        <h2>Login</h2>
        <form  action="home.jsp">
            <div class="inputBox">
                <input type="text" name=""   required ="" id="user">
                <label> User Name</label>
        
            </div>


            <div class="inputBox">
                    <input type="password" name=""   required ="" id="pass">
                    <label> Password</label>
            
                </div>

                <input type="submit" name=""value="Submit" onclick="javascript:validate()">
    </form>
    </div>
</body>
</html>