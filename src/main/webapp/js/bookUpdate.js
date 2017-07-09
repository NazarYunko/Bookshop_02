loadGenres();
loadPublishers();
loadAuthors();

//form validation
function checkField(elem) {
    if ($(elem).val().length == 1) {
        $(elem).css('background', 'white');
    }
}

//form validation
function inputCheckClick(elem) {
    $(elem).css('background', 'white');
}

$('#uploadFile').click(function () {
    $('#image').click();
});

$('#updateBookForm').submit(function (event) {
    event.preventDefault();


    var bookName = $('#bookName');
    var bookNameValue = bookName.val();

    var selectGenres = $('#genres');

    var bookDescription = $('#bookDescription');
    var bookDescriptionValue = bookDescription.val();

    var bookCountOfPages = $('#bookCountOfPages');
    var bookCountOfPageValue = bookCountOfPages.val();

    var selectAuthors = $('#authors');

    var bookDateOfPublication = $('#bookDateOfPublication');
    var bookDateOfPublicationValue = bookDateOfPublication.val();

    var selectPublishers = $('#publishers');

    var bookQuantity = $('#bookQuantity');
    var bookQuantityValue = bookQuantity.val();

    var bookPrice = $('#bookPrice');
    var bookPriceValue = bookPrice.val();

    var image = $('#image');
    var imageValue = image.val();

    if (bookNameValue == '') {
        bookName.css('background', 'rgba(151, 22, 28, 0.15)');
        window.scrollTo(0, 0);
    } else if (selectGenres.has('option').length == 0) {
        $('#genres').css('background', 'rgba(151, 22, 28, 0.15)');
        $('#error').html('Add genres');
        window.scrollTo(0, 0);
    } else if (bookDescriptionValue == '') {
        bookDescription.css('background', 'rgba(151, 22, 28, 0.15)');
        window.scrollTo(0, 0);
    } else if (bookCountOfPageValue == '') {
        bookCountOfPages.css('background', 'rgba(151, 22, 28, 0.15)');
        window.scrollTo(0, 0);
    } else if (selectAuthors.has('option').length == 0) {
        $('#authors').css('background', 'rgba(151, 22, 28, 0.15)');
        $('#error').html('Add authors');
    } else if (bookDateOfPublicationValue == '') {
        bookDateOfPublication.css('background', 'rgba(151, 22, 28, 0.15)');
    } else if (selectPublishers.has('option').length == 0) {
        $('#publishers').css('background', 'rgba(151, 22, 28, 0.15)');
        $('#error').html('Add publishers');
    } else if (bookQuantityValue == '') {
        bookQuantity.css('background', 'rgba(151, 22, 28, 0.15)');
    } else if (bookPriceValue == '') {
        bookPrice.css('background', 'rgba(151, 22, 28, 0.15)');
    } else {

        var book = {
            id: $('#bookId').val(),
            name: bookNameValue
        };

        $.ajax({
            url: '/findByIdAndName?' + $('input[name = csrf_name]').val() + "=" + $('input[name = csrf_value]').val(),
            type: 'POST',
            dataType: 'json',
            contentType: 'application/json; charset=UTF-8',
            data: JSON.stringify(book),
            success: function (res) {
                if (res == true) {
                    $('#updateBookForm').unbind('submit').submit();
                } else {
                    $('#error').html('Book already exist!');
                    window.scrollTo(0, 0);
                }
            },
            error: function (error) {
                console.log(error);
            }
        });
    }

});

function loadGenres() {
    $.ajax({
        url: '/genre?' + $('input[name = csrf_name]').val() + "=" + $('input[name = csrf_value]').val(),
        type: 'GET',
        success: function (res) {
            parseItemsFromDb(res, '#genres');
        },
        error: function (error) {
        }
    });
}

function loadAuthors() {
    $.ajax({
        url: '/getAuthors?' + $('input[name = csrf_name]').val() + "=" + $('input[name = csrf_value]').val(),
        type: 'GET',
        success: function (res) {
            parseItemsFromDb(res, '#authors');
        },
        error: function (error) {
        }
    });
}

function loadPublishers() {
    $.ajax({
        url: '/publisher?' + $('input[name = csrf_name]').val() + "=" + $('input[name = csrf_value]').val(),
        type: 'GET',
        success: function (res) {
            parseItemsFromDb(res, '#publishers');
        },
        error: function (error) {
        }
    });
}

function parseItemsFromDb(res, resultId) {
    var items = '';
    $(resultId).html('');
    for (var i in res) {
        if (res[i].lastName == null) {
            items += '<option value="' + res[i].id + '">' + res[i].name + '</option>';
        } else {
            items += '<option value="' + res[i].id + '">' + res[i].name + " " + res[i].lastName + '</option>';
        }
    }
    $(resultId).html(items);
}
