<%-- 
    Document   : timetable.jsp
    Created on : Mar 18, 2023, 6:42:18 PM
    Author     : Asus
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="header">
            <div class="header-info"><h1>FPT University Attendance Taking</h1></div>

            <div class="header-img">
                <img src="../view/img/fpt-university-logo.png" alt="Image description"/>
            </div>
        </div
        <div class="studentnput">
            <input type="hidden" name="student" value="${sessionScope.user.id}">
        </div>
        <table border="1px">
            <tr>
                <td></td>
                <c:forEach items="${requestScope.dates}" var="d">
                    <td>${d}<br/><fmt:formatDate value="${d}" pattern="EEEE"/>
            </td>
        </c:forEach>
    </tr>
    <c:forEach items="${requestScope.slots}" var="st">
        <tr>
            <td>${st.id}</td>
            <c:forEach items="${requestScope.dates}" var="d">
                <td>
                   <c:forEach items="${requestScope.s.groups}" var="g">
                        <c:forEach items="${g.sessions}" var="ses">
                            <c:if test="${ses.date eq d and ses.slot.id eq st.id}">
                                ${g.name}(${g.course.name}) <br/>
                                ${ses.lecturer.name}-${ses.room.name} <br/>
                                <c:if test="${ses.status eq 1}">
                                    Attend
                                </c:if>
                                <c:if test="${ses.status eq 0}">
                                    Absent
                                </c:if>
                            </c:if>
                        </c:forEach>
                    </c:forEach>
                </td>
            </c:forEach>
        </tr>
    </c:forEach>
</table>

</body>
</html>
