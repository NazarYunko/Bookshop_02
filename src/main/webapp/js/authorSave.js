
//load selects only on updateAuthor.jsp
loadCountries();

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

//save form validation
$('#saveAuthorForm').submit(function (event) {
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
        $('#cities').css('background', 'rgba(151, 22, 28, 0.15)');
        $('#error').html('Add cities to country!');
    } else if (imageValue == '') {
        image.css('background', 'rgba(151, 22, 28, 0.15)');
    } else {
        $.ajax({
            url: '/getAuthors?' + $('input[name = csrf_name]').val() + "=" + $('input[name = csrf_value]').val(),
            type: 'GET',
            success: function (res) {
                var valid = true;
                for (var i in res) {
                    if (res[i].name == authorNameValue && res[i].lastName == authorLastNameValue) {
                        valid = false;
                    }
                }
                if (valid) {
                    $('#saveAuthorForm').unbind('submit').submit();
                } else {
                    $('#error').html('Author already exist!');
                    window.scrollTo(0, 0);
                }
            },
            error: function (error) {
                console.log(error);
            }
        });
    }

});


//load for selects
$('#countries').change(function () {
    var select = document.getElementById('countries');
    var selected = select.options[select.selectedIndex];
    loadCities(selected.getAttribute('value'));
});

//load cities by country
function loadCities(countryId) {
    $.ajax({
        url: '/findByCountry?' + $('input[name = csrf_name]').val() + "=" + $('input[name = csrf_value]').val(),
        type: 'POST',
        dataType: 'json',
        contentType: 'application/json; charset=UTF-8',
        data: countryId,
        success: function (res) {
            parseItemsFromDb(res, '#cities');
        },
        error: function (error) {
            console.log(error);
        }
    });
}

function loadCountries() {
    $.ajax({
        url: '/country?' + $('input[name = csrf_name]') + "=" + $('input[name = csrf_value]'),
        type: 'GET',
        success: function (res) {
            parseItemsFromDb(res, '#countries');
            if (res.length > 0) {
                var select = document.getElementById('countries');
                var selected = select.options[select.selectedIndex];
                loadCities(selected.getAttribute('value'));
            }
        },
        error: function (error) {
            console.log(error)
        }
    });
}

function parseItemsFromDb(res, resultId) {
    var items = '';
    $(resultId).html('');
    for (var i in res) {
        items += '<option value="' + res[i].id + '">' + res[i].name + '</option>';
    }
    $(resultId).html(items);
}
