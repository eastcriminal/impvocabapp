<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="words" scope="request"
             type="java.util.Collection<com.alexmanwell.impvocabapp.model.Word>"/>
<html>
<head>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>

    <title>Print All Learning Words</title>
</head>
<body>
<main role="main" class="main container">
    <div class="row">
        <div class="col-lg">
            <h3 class="text-center">Words:</h3>
            <table class="table table-bordered col-12">
                <thead>
                <tr>
                    <th rowspan="2" scope="col">name</th>
                    <th rowspan="2" scope="col">transcription</th>
                    <th colspan="2"></th>
                    <th rowspan="2" scope="col">part of speech</th>
                </tr>
                <tr>
                    <td scope="col">explanation</td>
                    <td scope="col">examples</td>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${words}" var="word">
                    <tr>
                        <td scope="row" class="text-left">${word.name}</td>
                        <td class="text-center">${word.transcription}</td>
                        <td colspan="2">
                            <c:forEach items="${word.explanation}" var="expl">
                                <p class="text-left">${expl.explanation}</p>
                                <c:forEach items="${expl.examples}" var="example">
                                    <p class="text-right">${example.text}</p>
                                </c:forEach>
                            </c:forEach>
                        </td class="text-right">
                        <td class="text-right">${word.partOfSpeech}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</main>
</body>
</html>
