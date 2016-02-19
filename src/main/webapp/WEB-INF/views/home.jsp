<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Company management</title>
      
    </head>

<body>

<div class="header">
	<input type="text" id="searchKey"/>
	<button id="btnSearch">Search</button>
	<button id="btnAdd">New Company</button>
</div>


<div class="leftArea">
<ul id="companyList"></ul>
</div>

<form id="companyForm">
	
<div class="mainArea">

  
<label>Id:</label> <br/>
<input id="companyId" name="id" type="text" disabled /><br/>

<label>Name:</label><br/>
<input type="text" id="name" name="name" required><br/>

<label>Address:</label><br/>
<input type="text" id="address" name="address"/><br/>

<label>City:</label><br/>
<input type="text" id="city" name="city"/><br/>

<label>Country:</label><br/>
<input type="text" id="country" name="country"/><br/>

<label>Email:</label><br/>
<input type="text" id="email" name="email"/><br/>

<label>Phone:</label><br/>
<input type="text" id="phone" name="phone"/><br/>

<label>Owners:</label><br/>
<textarea id="owners" name="owners"></textarea><br/>

<button id="btnSave">Save</button>
<button id="btnDelete">Delete</button>

</div>

</form>

<script src="js/jquery-1.7.1.min.js" type="text/javascript"></script>

<script src="js/hello.js"></script>


</body>
</html>

