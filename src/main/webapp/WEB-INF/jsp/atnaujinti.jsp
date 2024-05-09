<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@  taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
    <head>
            <title>Skaiciaus atnaujinimas</title>
            <jsp:include page="header.jsp"/>
    </head>
    <body>
            <form:form name="skaicius" action="/atnaujintiSkaiciu" method="post">
                <input type="hidden" name="id" value="${skaicius.id}"><p>
                Pirmas skaicius:<br>
                <input type="number" name="sk1" value="${skaicius.sk1}"><p>
                Zenklas:<br>
                <input type="text" name="zenklas" value="${skaicius.zenklas}"><p>
                Antras skaicius:<br>
                <input type="number" name="sk2" value="${skaicius.sk2}">
                Rezultatas:<br>
                <input type="number" name="rezultatas" value="${skaicius.rezultatas}"><p>
                <input type="submit" value="Atnaujinti">
            </form:form>
    </body>
</html>