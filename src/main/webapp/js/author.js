function loadCities(countryId) {
    $.ajax({
        url: '/findByCountry?' + $('input[name = csrf_name]') + "=" + $('input[name = csrf_value]'),
        type: 'GET',
        dataType: 'json',
        contentType: 'application/json; charset=UTF-8',
        data: JSON.stringify(countryId),
        success: function (res) {
            parseItemsFromDb(res, '#cities');
        },
        error: function (error) {
            console.log(error);
        }
    });
}

loadCountries();
function loadCountries() {
    $.ajax({
        url: '/country?' + $('input[name = csrf_name]') + "=" + $('input[name = csrf_value]'),
        type: 'GET',
        success: function (res) {
            parseItemsFromDb(res, '#countries');
            var select = document.getElementById('countries');
            var selected = select.options[select.selectedIndex];
            loadCities(selected.getAttribute('value') );
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
