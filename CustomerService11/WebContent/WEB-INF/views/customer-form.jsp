<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Save Customer</title>
    <!--
   < link type="text/css" 
    rel="stylesheet"
    href="${pageContext.request.contextPath}/resources/css/style.css">
    
   < link type="text/css" 
    rel="stylesheet"
    href="${pageContext.request.contextPath}/resources/css/add-custome-style.css">
    -->
 < link type="text/css" 
 rel="stylesheet"
 href="/style.css" />

< link type="text/css" 
rel="stylesheet"
href="add-customer-style.css" />

</head>
<body bgcolor="aqua">
	<div id="wrapper">
		<div id="header">
			<h2>CRM - CUSTOMER RELATIONSHIP MANAGER</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Customer</h3>

		<form:form action="saveCustomer" modelAttribute="customer" method="POST">

			<!-- Need to associate this data with customer id -->
			<form:hidden path="id" />

			<table border="2">
				<tbody>
					<tr>
						<td><label>First name:</label></td>
						<td><form:input path="firstName" /></td>
					</tr>
					<tr>
						<td><label>Last name:</label></td>
						<td><form:input path="LastName" /></td>
					</tr>
					<tr>
						<td><label>Email:</label></td>
						<td><form:input path="email" /></td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
				</tbody>
			</table>

		</form:form>

		<div style=""></div>

		<a href="${pageContext.request.contextPath}/customer/list">Back to
			List</a>
	</div>
</body>
</html>