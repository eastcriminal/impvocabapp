<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="words" scope="request"
             type="java.util.Map<com.alexmanwell.impvocabapp.model.Word, com.alexmanwell.impvocabapp.model.Word>"/>

<div class="row">
    <div class="col-lg">
        <table class="table table-bordered col-12">
            <thead>
            <tr>
                <th rowspan="2" scope="col">name</th>
                <th rowspan="2" scope="col">part of speech</th>
                <th rowspan="2" scope="col">transcription</th>
                <th colspan="2"></th>
                <th rowspan="2" scope="col">translate</th>
            </tr>
            <tr>
                <td scope="col">explanation</td>
                <td scope="col">examples</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${words}" var="word">

                <tr>
                    <td class="text-right">${word.key.name}</td>
                    <td class="text-right">${word.key.partOfSpeech}</td>
                    <td class="text-center">${word.key.transcription}</td>
                    <td colspan="2">
                        <c:forEach items="${word.key.explanation}" var="expl">
                            <p class="text-left">${expl.explanation}</p>
                            <c:forEach items="${expl.examples}" var="example">
                                <p class="text-right">${example.text}</p>
                            </c:forEach>
                        </c:forEach>
                    </td class="text-right">
                    <td class="text-right">${word.value.name}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>