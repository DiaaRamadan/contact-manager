<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title> New/Edit Contact</title>
</head>
<body>
<div class="text-center">
    <h1>New/Edit Contact</h1>
    <table style="margin: auto">
        <form:form method="post" action="save" modelAttribute="contact">
            <tr>
                <td>Name:</td>
                <td><form:input path="name"/></td>
                <td><form:errors path="name" cssClass="text-danger"/></td>
            </tr>

            <tr>
                <td>Email:</td>
                <td><form:input type="?email?" path="email"/></td>
                <td><form:errors path="email" cssClass="text-danger"/></td>

            </tr>

            <tr>
                <td>Address:</td>
                <td><form:input path="address"/></td>
                <td><form:errors path="address" cssClass="text-danger"/></td>
            </tr>

            <tr>
                <td>Phone:</td>
                <td><form:input path="phone"/></td>
                <td><form:errors path="phone" cssClass="text-danger"/></td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </form:form>
    </table>
</div>
</body>
</html>
