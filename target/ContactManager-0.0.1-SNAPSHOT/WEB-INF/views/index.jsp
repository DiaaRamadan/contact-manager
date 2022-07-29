<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>Contact Manager Application</title>
</head>
<body>
<div class="text-center">
    <h1>Contact Manager Application</h1>
    <h3><a href="new">New Contact</a></h3>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">No</th>
            <th scope="col">Name</th>
            <th scope="col">Email</th>
            <th scope="col">Address</th>
            <th scope="col">Phone</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${contacts}" var="contact" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${contact.name}</td>
                <td>${contact.email}</td>
                <td>${contact.address}</td>
                <td>${contact.phone}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>