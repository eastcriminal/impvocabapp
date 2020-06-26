<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="modal fade" id="addUserWordModal" tabindex="-1" role="dialog"
     aria-labelledby="#addUserWordModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h3 class="modal-title" id="addUserWordModalLabel">Add word in the dictionary</h3>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form id="userWordForm" action="${pageContext.request.contextPath}/addUserWord"
                      modelAttribute="userWordForm"
                      method="POST">
                    <div class="row">
                        <input type="text" name="wordId" value="" hidden/>
                        <input type="text" name="wordExplanationId" value="" hidden/>
                        <div class="form-group col-6">
                            <input type="text" class="form-control" name="wordName" value="" disabled/>
                        </div>
                        <div class="form-group col-6">
                            <input type="text" class="form-control" name="wordPartOfSpeech" value="" disabled/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-12">
                            <input type="text" class="form-control" name="wordExplanation" value="" disabled/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-12">
                            <input type="text" class="form-control" name="example" value="" placeholder="enter example"/>
                        </div>
                    </div>

                    <div class="row addLayer">
                        <div class="col-4 align-self-end">
                            <button type="button" class="btn btn-success addExample">
                                add example
                            </button>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary close-button" data-dismiss="modal">Close
                </button>
                <button type="submit" form="userWordForm" class="btn btn-primary">Add word
                </button>
            </div>
        </div>
    </div>
</div>