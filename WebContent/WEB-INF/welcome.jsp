<%@page import="java.util.HashMap"%>
<%@page import="com.lz.form.UserForm"%>
<%@ page import="java.util.Map" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Dashboard</title>
<style>
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
}

header {
	background-color: #333;
	color: #fff;
	padding: 20px;
}

h1 {
	margin: 0;
}

nav {
	background-color: #666;
	color: #fff;
	padding: 10px;
}

nav ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
}

nav ul li {
	display: inline;
	margin-right: 10px;
}

section {
	padding: 20px;
}

.dashboard-grid {
	display: grid;
	grid-template-columns: repeat(1, 1fr);
	gap: 20px;
}

.card {
	background-color: #f5f5f5;
	padding: 10px;
	border-radius: 4px;
	box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.card h2 {
	margin-top: 0;
}

footer {
	background-color: #333;
	color: #fff;
	padding: 10px;
	text-align: center;
}

table {
	width: 100%;
	border-collapse: collapse;
}

th, td {
	padding: 8px;
	text-align: left;
	border-bottom: 1px solid #ddd;
}

tr:hover {
	background-color: #f5f5f5;
}
        table.custom-border {
            border: 1px solid #ff0000;
        }
        
        table.custom-border th, table.custom-border td {
            border-bottom: 1px solid #ff0000;
        }
</style>
</head>
<body>
	<header>
		<h1>Dashboard</h1>
	</header>

	<nav>
		<ul>
			<li><a href="#">123</a></li>
			<li><a href="#">Users</a></li>
			<li><a href="#">Products</a></li>
			<li><a href="#">Settings</a></li>
		</ul>
	</nav>

	<section>
		<div class="dashboard-grid">
			<div class="card">
				<h2>Card 1</h2>
				<table class="custom-border">
					<thead>
						<tr>
								<th>user_id</th>
								<th>username</th>
								<th>password</th>
								<th>email</th>
								<th>date</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<%
							Map map =new HashMap();
							map.put(01, "kaka");
							map.put(02, "hha");
							map.put(03, "james");
							map.put(04, "lucy");
							map.put(05, "tom");
							request.setAttribute("al", map);
							
							
							%>
							<c:forEach items="${al}" var="u">
							<td>${u.value}</td>
						 </c:forEach>
					
						</tr>

					</tbody>
				</table>
			</div>
		</div>
	</section>

	<footer> &copy; 2023 Dashboard. All rights reserved. </footer>

</body>
</html>