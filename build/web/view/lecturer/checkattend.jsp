<%-- 
    Document   : att
    Created on : Mar 15, 2023, 2:02:41 AM
    Author     : Asus
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../view/css/styletimetable.css">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="header">
            <div class="header-info"><h1>FPT University Take Attendance</h1></div>

            <div class="header-img">
                <img src="../view/img/fpt-university-logo.png" alt="Image description"/>
            </div>
        </div>
        <form action="takeattend" method="POST">
            <table border="1px">
                <tr>
                    <td>Seq</td>
                    <td>Id</td>
                    <td>Name</td>
                    <td>Absent/Present</td>
                    <td>Comment</td>
                </tr>
                <c:forEach items="${requestScope.atts}" var="a" varStatus="loop">
                    <tr>
                        <td>${loop.index}</td>
                        <td>${a.student.id}
                            <input type="hidden" name="sid" value="${a.student.id}" />
                            <input type="hidden" name="aid${a.student.id}" value="${a.id}" />
                        </td>
                        <td>${a.student.name}</td>
                        <td>
                            <c:if test="${!a.status}">Absent</c:if>
                            <c:if test="${a.status}">Attend</c:if>
                            </td>
                            <td><input type="text" value="${a.comment}" name="comment${a.student.id}" readonly=""/></td>
                    </tr>
                </c:forEach>
            </table>
        </form>
    </body>
</html>
