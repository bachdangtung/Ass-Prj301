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
        <link rel="stylesheet" href="../view/css/stylelogin.css">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="header">
            <div class="row">
                <div class="col-md-8">
                    <h1>
                        <span>FPT University Take Attendance</span>
                    </h1>
                </div>
                <div class="col-md-4">
                    <table>
                        <tbody>
                            <tr>
                                <td colspan="2" class="auto-style1"><strong>FAP mobile app (myFAP) is ready at</strong></td>
                            </tr>
                            <tr>
                                <td><a href="https://apps.apple.com/app/id1527723314">
                                        <img src="https://fap.fpt.edu.vn/images/app-store.svg"
                                             style="width: 120px; height: 40px" alt="apple store"></a></td>
                                <td><a href="https://play.google.com/store/apps/details?id=com.fuct">
                                        <img src="https://fap.fpt.edu.vn/images/play-store.svg"
                                             style="width: 120px; height: 40px" alt="google store"></a></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div class="table-report">
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
                            <td><input type="radio"
                                       <c:if test="${!a.status}">
                                           checked="checked"
                                       </c:if>
                                       name="status${a.student.id}" value="absent"/>Absent
                                <input type="radio"
                                       <c:if test="${a.status}">
                                           checked="checked"
                                       </c:if>
                                       name="status${a.student.id}" value="present"/>Present
                            </td>
                            <td><input type="text" value="${a.comment}" name="comment${a.student.id}"/></td>
                        </tr>
                    </c:forEach>
                </table>
                <input type="hidden" name="sessionid" value="${param.id}"/>
                <input type="submit" value="Save"/>
            </form>
        </div>
        <div class="rooter">
            <p> Mọi góp ý, thắc mắc xin liên hệ: Phòng dịch vụ sinh viên: Email: <span>dichvusinhvien@fe.edu.vn.</span> Điện
                thoại: <span class="PhoneNumber">(024)7308.13.13</span></p>
            <p> © Powered by <span>University</span> | <span>CMS</span> | <span>library</span> | <span>books24x7</span></p>
        </div> 
    </body>
</html>
