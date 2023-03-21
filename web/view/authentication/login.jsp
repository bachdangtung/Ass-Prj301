<%-- 
    Document   : login
    Created on : Mar 17, 2023, 8:57:30 PM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../view/css/stylelogin.css">
        <title>JSP Page</title>
    </head>
    <body>
        <div class ="tung">
            <div class="header">
                <div class="row">
                    <div class="col-md-8">
                        <h1>
                            <span>FPT University Academic Portal</span>
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
            ${sessionScope.filtermess}
            <div class="login-main">
                <form method="post" action="login">
                    <div>
                        Username: <input type="text" name="username" required="" value="${param.username}">
                    </div>
                    <div>
                        Password :  <input type="password" name="password" required="" value="${param.password}">
                    </div>
                    <button>Login</button>
                    ${requestScope.message}
                </form>  
                <table>
                    <tbody>
                        <tr>
                            <td>
                                <p style="text-align: center">
                                    © Powered by <a href="http://fpt.edu.vn" target="_blank">FPT
                                        University</a>&nbsp;|&nbsp;
                                    <a href="http://cms.fpt.edu.vn/" target="_blank">CMS</a>&nbsp;|&nbsp; <a
                                        href="http://library.fpt.edu.vn"
                                        target="_blank">library</a>&nbsp;|&nbsp; <a
                                        href="http://library.books24x7.com" target="_blank">books24x7</a>                                              
                                </p>
                            </td>
                        </tr>
                    </tbody>
                </table>  
            </div>                                        
        </div>
    </body>
</html>
