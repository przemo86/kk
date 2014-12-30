<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><%@
	taglib prefix="form" uri="http://www.springframework.org/tags/form" %><%@
	taglib prefix="spring" uri="http://www.springframework.org/tags"
%><!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Users</title>
		<link rel="stylesheet" href="<c:url value='/styles/default.css'/>">
	</head>
	<body>
		<h1>Users</h1>

        <table>
            <thead><tr><th>Name</th><th>Country ID</th><th>Region</th></tr></thead>
            <tbody>
                <c:forEach var="sss" items="${userGrid}" varStatus="row">
                    <tr>
                        <td>
                            ${sss.name}
                        </td>
                        <td>
                            ${sss.countryId}
                        </td>
                        <td>
                            ${sss.region.name}
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

		<form:form action="" method="post" modelAttribute="country">
            Country ID <form:input type="text" path="countryId"/><br />
            <form:errors path="countryId" /><br />
            Country Name <form:input type="text" path="name"/><br />
            <form:errors path="name" />
			<p>
				<input type="submit" value="Update all enabled users">
			</p>
		</form:form>
		<script src="<c:url value='/scripts/lib/prototype.js'/>"></script>
		<script src="<c:url value='/scripts/lib/RowSelector.js'/>"></script>
		<script src="<c:url value='/scripts/user.js'/>"></script>
	</body>
</html>
