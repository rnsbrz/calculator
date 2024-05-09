<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
<head>
    <title>Skaiciai</title>
    <jsp:include page="header.jsp"/>
</head>
<body class="container">
    <div class="table-responsive">
        <table class="table table-striped">
            <tr>
                <th>Pirmas skaicius</th>
                <th>Zenklas</th>
                <th>Antras skaicius</th>
                <th>Rezultatas</th>
                <th>Veiksmas</th>
            </tr>

            <c:forEach var="skaicius" items="${skaiciai}">
                <c:url var="atnaujinti" value="/atnaujinti">
                    <c:param name="id" value="${skaicius.id}"/>
                </c:url>

                <c:url var="trinti" value="/trinti">
                    <c:param name="id" value="${skaicius.id}"/>
                </c:url>

                <c:url var="rodyti" value="/rodyti">
                    <c:param name="id" value="${skaicius.id}"/>
                </c:url>

                <tr>
                    <td>${skaicius.sk1}</td>
                    <td>${skaicius.zenklas}</td>
                    <td>${skaicius.sk2}</td>
                    <td>${skaicius.rezultatas}</td>

                    <td>
                        <a href="${atnaujinti}">Keisti</a>
                        | <a href="${trinti}"
                             onclick="if (!(confirm('Ar tikrai norite istrinti si irasa?))) return false">Trinti</a>
                        | <a href="${rodyti}">Rodyti</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>