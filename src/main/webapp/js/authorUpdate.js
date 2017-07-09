loadUpdateAuthorImageAndSelects();

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

//update author form validation
$('#updateAuthorForm').submit(function (event) {

    event.preventDefault();

    var authorName = $('#authorName');
    var authorNameValue = authorName.val();

    var authorLastName = $('#authorLastName');
    var authorLastNameValue = authorLastName.val();

    var authorBiography = $('#authorBiography');
    var authorBiographyValue = authorBiography.val();

    var authorDateOfBirth = $('#authorDateOfBirth');
    var authorDateOfBirthValue = authorDateOfBirth.val();

    var selectCountries = $('#countries');

    var image = $('#image');
    var imageValue = image.val();

    var selectCities = $('#cities');

    if (authorNameValue == '') {
        authorName.css('background', 'rgba(151, 22, 28, 0.15)');
        window.scrollTo(0, 0);
    } else if (authorLastNameValue == '') {
        authorLastName.css('background', 'rgba(151, 22, 28, 0.15)');
        window.scrollTo(0, 0);
    } else if (authorBiographyValue == '') {
        authorBiography.css('background', 'rgba(151, 22, 28, 0.15)');
        window.scrollTo(0, 0);
    } else if (authorDateOfBirthValue == '') {
        authorDateOfBirth.css('background', 'rgba(151, 22, 28, 0.15)');
        window.scrollTo(0, 0);
    } else if (selectCountries.has('option').length == 0) {
        $('#countries').css('background', 'rgba(151, 22, 28, 0.15)');
        $('#error').html('Add countries!');
    } else if (selectCities.has('option').length == 0) {
        $('#countries').css('background', 'rgba(151, 22, 28, 0.15)');
        $('#error').html('Add cities to country!');
    } else {
        var authorSend = {
            id: $('#authorId').val(),
            name: $('#authorName').val(),
            lastName: $('#authorLastName').val()
        };

        $.ajax({
            url: '/updateAuthorValidation?' + $('input[name = csrf_name]').val() + "=" + $('input[name = csrf_value]').val(),
            type: 'POST',
            dataType: 'json',
            contentType: 'application/json; charset=UTF-8',
            data: JSON.stringify(authorSend),
            success: function (res) {
                if (res == true) {
                    $('#updateAuthorForm').unbind('submit').submit();
                } else {
                    window.scrollTo(0, 0);
                    $('#error').html('Author already exist!');
                }
            },
            error: function (error) {
                console.log(error);
            }
        });
    }

});

//load authorUpdateForm selects and Image
function loadUpdateAuthorImageAndSelects() {
    var authorSend = {
        name: $('#authorName').val(),
        lastName: $('#authorLastName').val()
    };

    $.ajax({
        url: '/getAuthorByNameAndLastName?' + $('input[name = csrf_name]').val() + "=" + $('input[name = csrf_value]').val(),
        type: 'POST',
        dataType: 'json',
        contentType: 'application/json; charset=UTF-8',
        data: JSON.stringify(authorSend),
        success: function (res) {
            loadCountries(res.city.country, res.city);
        },
        error: function (error) {
            console.log(error);
        }
    });

}

//load for selects
$('#countries').change(function () {
    var select = document.getElementById('countries');
    var selected = select.options[select.selectedIndex];
    loadCities(Number(selected.getAttribute('value')));
});

//load cities by country
function loadCities(countryId, city) {
    $.ajax({
        url: '/findByCountry?' + $('input[name = csrf_name]').val() + "=" + $('input[name = csrf_value]').val(),
        type: 'POST',
        dataType: 'json',
        contentType: 'application/json; charset=UTF-8',
        data: JSON.stringify(countryId),
        success: function (res) {
            if (city != null) {
                parseItemsFromDb(res, city.id, 'cities');
            } else {
                parseItemsFromDbOnChange(res, 'cities');
            }
        },
        error: function (error) {
            console.log(error);
        }
    });
}

function loadCountries(country, city) {
    $.ajax({
        url: '/country?' + $('input[name = csrf_name]') + "=" + $('input[name = csrf_value]'),
        type: 'GET',
        success: function (res) {
            parseItemsFromDb(res, country.id, 'countries');
            if (res.length > 0) {
                var select = document.getElementById('countries');
                var selected = select.options[select.selectedIndex];
                loadCities(country.id, city);
            }
        },
        error: function (error) {
            console.log(error)
        }
    });
}

//parse on load page
function parseItemsFromDb(res, itemIdToFound, idToSet) {
    var items = '';
    $('#' + idToSet).html('');
    for (var i in res) {
        items += '<option value="' + res[i].id + '">' + res[i].name + '</option>';
    }
    $('#' + idToSet).html(items);

    var itemsSelect = document.getElementById(idToSet);

    for (var i = 0; i < res.length; i++) {
        if (res[i].id == itemIdToFound) {
            itemsSelect.selectedIndex = i;
            break;
        }
    }
}


//if country select change do this
function parseItemsFromDbOnChange(res, resultIdName) {
    var items = '';
    $('#' + resultIdName).html('');
    for (var i in res) {
        items += '<option value="' + res[i].id + '">' + res[i].name + '</option>';
    }
    $('#' + resultIdName).html(items);
}