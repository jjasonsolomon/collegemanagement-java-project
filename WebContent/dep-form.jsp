<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="header.html" %>
<%@ include file="footer.html" %>

<link rel="stylesheet" type="text/css" href="http://localhost:8081/Jas_College/style.css">
<title>Department</title>
<script type = "text/javascript">
function reset()
{
	
	dep.d_name="";
	dep.location="";
	dep.hod="";
	
	}
</script>
</head>
<body>
<div  class="box">
<center>
		<h1>DEPARTMENT</h1>
        <h2>
        
  <input type="submit" value="Register" onclick="window.location.href='new'"
  >
        <input type="submit" value="Display" onclick="window.location.href='list'" >
        	
        </h2>
	</center>
<div align="center">
		<c:if test="${dep != null}">
			<form action="update" method="post">
        </c:if>
        <c:if test="${dep == null}">
			<form action="insert" method="post">
        </c:if>
        
        
        <h2>
            		<c:if test="${dep!= null}">
            			Edit Member
            		</c:if>
            		<c:if test="${dep == null}">
            			Register
            		</c:if>
            	</h2>
    <form>
            <div class="inputBox">

        <input type="text" name="d_name" required="" value="<c:out value='${dep.d_name}' />"
                		/>
        <label>   Department Name:</label>

            </div>


            <div class="inputBox">

        <input type="text" name="location" required="" value="<c:out value='${dep.location}' />"
                		/>
        <label>   Location:</label>

    </div>

        <div class="inputBox">

        <input type="text" name="hod" required ="" value="<c:out value='${dep.hod}' />"
                		/>
        <label>   HOD Name:</label>

    </div>

        <input type="submit" value="Save">
        <input type="reset" value="Reset" onclick="javascript:reset()">

    </form>
</div>

</body>
</html>