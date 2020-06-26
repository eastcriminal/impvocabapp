'use strict';

$(".table tbody tr td").on("click", ".add-userWord-modal", function () {
    let addSign = $('div.addSign');
    addSign.after(
        '<div class="form-group col-sm-1" style="padding: 0 10px 0 0;">' +
        '<button class="btn btn-danger minus pull-right">&ndash;</button>' +
        '</div>'
    );
    addSign.attr('class', 'addSign form-group col-5');

    let id = $(this).data('word-id'),
        name = $(this).data('word-name'),
        explanation = $(this).data('word-explanation'),
        explanationId = $(this).data('word-explanation-id'),
        partOfSpeech = $(this).data('word-part-of-speech');

    console.log(id);
    console.log(name);
    console.log(explanation);
    console.log(explanationId);
    console.log(partOfSpeech);

    $('input[name=wordId]').val(id);
    $('input[name=wordName]').val(name);
    $('input[name=wordExplanation]').val(explanation);
    $('input[name=wordExplanationId]').val(explanationId);
    $('input[name=wordPartOfSpeech]').val(partOfSpeech.toLowerCase());

    $(".addExample").click(function () {
        $('.addLayer').before(
            '<div class="row addExampleLayer">' +
                        '<div class="form-group col-11">' +
                            '<input type="text" class="form-control" name="example" value="" placeholder="enter example"/>' +
                        '</div>' +
                        '<div class="form-group col-1" style="padding: 0 10px 0 0;">' +
                            '<button class="btn btn-danger minus pull-right">&ndash;</button>' +
                        '</div>' +
                   '</div>'
        );
    });

    $("button[data-dismiss=modal]").on("click", function () {
        let examples = $("#userWordForm").find("div.addExampleLayer");
        console.log(examples);
        for (let i = 0; i < examples.length; i++) {
            resetFieldValuesInUserWordForm();
        }
    });
});

$(document).on('click', '.close', function () {
    $(this).closest(".row").remove();
});

function resetFieldValuesInUserWordForm() {
    $("input[name=example]").val("");
    $("#userWordForm").find("div.addExampleLayer").remove();
    $(".addSign").find(".btn-danger .minus").remove();
    $(".col-11").attr("class", "addSign form-group col-6").remove();
    $(".col-1").remove();
}

$(document).on('click', '.minus', function () {
    $(this).closest(".row").remove();
});