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
                    <th scope="col">name</th>
                    <th scope="col">transcription</th>
                    <th scope="col">explanation</th>
                    <th scope="col">examples</th>
                    <th scope="col">part of speech</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${words}" var="word">
                    <tr>
                        <th scope="row" class="text-left">${word.name}</th>
                        <td class="text-center">${word.transcription}</td>
                        <td class="text-right">${word.explanation.explanation}</td>
                        <td class="text-right">
                            <c:forEach items="${word.explanation.examples}" var="example">
                                ${example}
                            </c:forEach>
                        </td>
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
