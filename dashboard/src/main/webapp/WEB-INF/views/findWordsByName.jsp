<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <jsp:include page="../views/fragments/immutableHead.jsp" flush="true"/>

    <title>Find Unknown Words By Name</title>
</head>
<body>
<main role="main" class="main container">
    <div class="row">
        <div class="col-lg">
            <h3 class="text-center">Find unknown word:</h3>
            <form class="align-content-center" action="${pageContext.request.contextPath}/findWordsByName"
                  id="findWordsByName" method="post">
                <div class="row">
                    <div class="col-4"></div>
                    <div class="form-group col-4">
                        <input class="form-control" type="text" name="name" value="" placeholder="enter word"/>
                    </div>
                    <div class="col-4">
                        <button type="submit" form="findWordsByName" class="btn btn-primary">search</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</main>
</body>
</html>
