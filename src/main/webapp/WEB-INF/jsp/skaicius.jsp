<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Skaicius</title>
    <jsp:include page="header.jsp"/>
</head>
  <body class="container">
    <div class="table-responsive">
      <caption>Skaiciaus informacija</caption>
      <table class="table table-striped">
        <tr>
          <td><b>Id:</b></td>
          <td>${skaicius.id}</td>
        </tr>
        <tr>
          <td><b>Pirmas skaicius</b></td>
          <td>${skaicius.sk1}</td>
        </tr>
        <tr>
          <td><b>Zenklas</b></td>
          <td>${skaicius.zenklas}</td>
        </tr>
        <tr>
          <td><b>Antras skaicius</b></td>
          <td>${skaicius.sk2}</td>
        </tr>
        <tr>
          <td><b>Rezultatas</b></td>
          <td>${skaicius.rezultatas}</td>
        </tr>
      </table>
    </div>
    <br>
    <a type="button" href="/skaiciai" class="button">Atgal</a>
  </body>
</html>