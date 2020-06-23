<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="words" scope="request"
             type="java.util.Map<java.lang.String, java.util.Collection<com.alexmanwell.impvocabapp.model.Word>>"/>

<div class="row">
    <div class="col-lg">
        <c:forEach items="${words}" var="word">
            <h3 class="text-center">Word: ${word.key}</h3>
            <table class="table table-bordered col-12">
                <thead>
                <tr>
                    <th rowspan="2" scope="col">part of speech</th>
                    <th rowspan="2" scope="col">transcription</th>
                    <th colspan="2"></th>
                </tr>
                <tr>
                    <td scope="col">explanation</td>
                    <td scope="col">examples</td>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${word.value}" var="w">
                    <tr>
                        <td class="text-right">${w.partOfSpeech}</td>
                        <td class="text-center">${w.transcription}</td>
                        <td colspan="2">
                            <c:forEach items="${w.explanation}" var="expl">
                                <p class="text-left">${expl.explanation}</p>
                                <c:forEach items="${expl.examples}" var="example">
                                    <p class="text-right">${example.text}</p>
                                </c:forEach>
                            </c:forEach>
                        </td class="text-right">
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:forEach>
    </div>
</div>