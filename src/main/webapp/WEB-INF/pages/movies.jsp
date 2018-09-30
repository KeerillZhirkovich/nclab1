<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Movies</title>

    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
</head>
<body>
<a href="../../index.jsp">Back to main menu</a>

<br/>
<br/>

<h1>Movie List</h1>

<c:if test="${!empty listMovies}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Title</th>
            <th width="120">Year</th>
            <th width="120">Country</th>
            <th width="120">Director</th>
            <th width="120">Genre</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listMovies}" var="movie">
            <tr>
                <td>${movie.id}</td>
                <td><a href="/moviedata/${movie.id}" target="_blank">${movie.movieTitle}</a></td>
                <td>${movie.inceptionYear}</td>
                <td>${movie.country}</td>
                <td>${movie.director}</td>
                <td>${movie.genre}</td>
                <td><a href="<c:url value='/edit/${movie.id}'/>">Edit</a></td>
                <td><a href="<c:url value='/remove/${movie.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<h1>Add a movie</h1>

<c:url var="addAction" value="/movies/add"/>

<form:form action="${addAction}" commandName="movie">
    <table>
        <c:if test="${!empty movie.movieTitle}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="movieTitle">
                    <spring:message text="Title"/>
                </form:label>
            </td>
            <td>
                <form:input path="movieTitle"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="inceptionYear">
                    <spring:message text="Year"/>
                </form:label>
            </td>
            <td>
                <form:input path="inceptionYear"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="country">
                    <spring:message text="Country"/>
                </form:label>
            </td>
            <td>
                <form:input path="country"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="director">
                    <spring:message text="Director"/>
                </form:label>
            </td>
            <td>
                <form:input path="director"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="genre">
                    <spring:message text="Genre"/>
                </form:label>
            </td>
            <td>
                <form:input path="genre"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty movie.movieTitle}">
                    <input type="submit"
                           value="<spring:message text="Edit movie"/>"/>
                </c:if>
                <c:if test="${empty movie.movieTitle}">
                    <input type="submit"
                           value="<spring:message text="Add movie"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
