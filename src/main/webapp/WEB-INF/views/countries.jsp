<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@
        taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@
        taglib prefix="spring" uri="http://www.springframework.org/tags"
        %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Kraje</title>
    <link rel="stylesheet" href="<c:url value='/styles/default.css'/>">
</head>
<body>
<h1>Lista krajów</h1>

<table>
    <thead>
    <tr>
        <th>Skrót</th>
        <th>Nazwa</th>
        <th>Region</th>
        <th>Ackja</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="country" items="${countryList}" varStatus="row">
        <tr>
            <td>
                    ${country.countryId}
            </td>
            <td>
                    ${country.name}
            </td>

            <td>
                    ${country.region.name}
            </td>
            <td>
                <a href="<c:url value="/countries/delete/${country.countryId}"/>">Usuń</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>


<hr/>

<h3>Dodaj kraj:</h3>
<form:form action="" method="post" modelAttribute="country">
    Skrót
    <form:input type="text" path="countryId"/>
    <form:errors path="countryId"/><br/>
    Nazwa
    <form:input type="text" path="name"/>
    <form:errors path="name"/> <br/>
    Region
    <form:select path="region.id">
        <form:options items="${regionList}" itemLabel="name" itemValue="id"/>
    </form:select>
    <form:errors path="region.id"/>
    <p>
        <input type="submit" value="Dodaj kraj">
    </p>
</form:form>
<script src="<c:url value='/scripts/lib/prototype.js'/>"></script>
<script src="<c:url value='/scripts/lib/RowSelector.js'/>"></script>
<script src="<c:url value='/scripts/user.js'/>"></script>
</body>
</html>
