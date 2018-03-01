<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>论坛登录</title>
</head>
<body>
    <c:if test="${!empty error}">
        <c:out value="${error}" />
    </c:if>
    <form action="<c:url value='loginCheck.html'/>" method="post">
        用户名:
        <input type="text" name="userName">
        <br>
        密码:
        <input type="text" name="password">
        <br>
        <input type="submit" value="登录" />
        <input type="reset" value="重置">
        <br>
    </form>
</body>
</html>
