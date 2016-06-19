<%@include file="/WEB-INF/views/template/header.jsp" %> 
<%@ page contentType="text/html; charset=UTF-8" %>



<div class="container-wrapper">
    <div class="container">
        <div id="login-box">
            <h1>Přihlašte se...</h1>

            <c:if test="${not empty msg}">
                <div class="msg" style="color: #00ff00;">${msg}</div>
            </c:if>


            <form name="loginForm" action="<c:url value="/j_spring_security_check" />" method="post">

                <c:if test="${not empty error}">
                    <div class="error" style="color: #ff0000;">${error}</div>
                </c:if>

                <div class="form-group">
                    <label for="username">User: </label>
                    <input type="text" id="username" name="username" class="form-control" />
                </div>
                <div class="form-group">
                    <label for="password">Passwrod:</label>
                    <input type="password" id="password" name="password" class="form-control" />
                </div>
                <input type="submit" value="Submit" class="btn btn-default">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            </form>






<%@include file="/WEB-INF/views/template/footer.jsp" %>