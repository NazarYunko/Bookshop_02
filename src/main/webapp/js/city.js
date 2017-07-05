//make update and save
function checkField(elem) {
    if ($(elem).val().length == 1) {
        $(elem).css('background', 'white');
    }
}

$('#saveCityBtn').click(function () {
    saveCity();
});

function saveCity() {

    var name = $('#cityName');
    var nameValue = name.val();

    if (nameValue == '') {
        name.css('background', 'rgba(151, 22, 28, 0.1)')
    }

    if (nameValue != '') {

        var select = document.getElementById('countries');
        var selected = select.options[select.selectedIndex];

        var city = {
            name: nameValue,
            country: {
                id: selected.getAttribute('value'),
                name: selected.innerHTML
            }
        };

        $.ajax({
            url: '/city?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
            type: 'POST',
            dataType: 'json',
            contentType: 'application/json; charset=UTF-8',
            data: JSON.stringify(city),
            success: function (res) {
                if (res == false) {
                    $('#error').html('City already exist!');
                } else {
                    name.val('');
                    $('#error').html('');
                    loadCities();
                }
            },
            error: function (error) {
                console.log(error);
            }
        })

    }
}


function updateCity(cityId) {

    var city = {
        id: 0,
        name: '',
        country: {
            id: 0,
            name: ''
        }
    };

    $.ajax({
        url: '/city?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        type: 'GET',
        success: function (res) {

            for (var i in res) {
                if (res[i].id == cityId) {
                    city.id = res[i].id;
                    city.name = res[i].name;
                    city.country.id = res[i].country.id;
                    city.country.name = res[i].country.name;
                }
            }

            $('#title').html('Update city');
            $('#cityName').val(city.name);
            window.scrollTo(0, 0);

            var newButton = document.createElement('button');
            newButton.id = 'updateCityBtn';
            document.getElementById("saveCityBtn").parentNode.removeChild(document.getElementById('saveCityBtn'));
            document.getElementById("button").appendChild(newButton);
            document.getElementById('updateCityBtn').innerHTML = "Update city";
            document.getElementById('updateCityBtn').classList.add('btn');
            document.getElementById('updateCityBtn').classList.add('btn-default');
            document.getElementById('updateCityBtn').classList.add('btn-md');
            document.getElementById('updateCityBtn').addEventListener('click', function () {
                saveUpdates(city.id);
            });


            var select = document.getElementById('countries');
            var options = select.options;

            var i = 0;
            while (options[i] != null) {
                if (options[i].getAttribute('value') == city.country.id) {
                    select.selectedIndex = i;
                    break;
                }
                i++;
            }


            var updateButtons = document.getElementsByClassName('updateButton');
            var deleteButtons = document.getElementsByClassName('deleteButton');
            for (var i in updateButtons) {
                updateButtons[i].disabled = true;
                deleteButtons[i].disabled = true;
            }

        },
        error: function (error) {
            console.log(error);
        }
    });

}

function saveUpdates(cityId) {
    var name = $('#cityName');
    var nameValue = name.val();

    var select = document.getElementById('countries');
    var selected = select.options[select.selectedIndex];

    if (nameValue == '') {
        name.css('background', 'rgba(151, 22, 28, 0.1)')
    }

    if (nameValue != '') {
        var cityToTransfer = {
            id: cityId,
            name: nameValue,
            country: {
                id: selected.getAttribute('value'),
                name: selected.innerHTML
            }
        };

        $.ajax({
            url: '/city?' + $('input[name = csrf_name]').val() + "=" + $('input[name = csrf_value]').val(),
            type: 'PUT',
            dataType: 'json',
            contentType: 'application/json; charset=UTF-8',
            data: JSON.stringify(cityToTransfer),
            success: function (res) {
                if (res == false) {
                    $('#error').html('City already exist!');
                } else {
                    name.val('');
                    $('#error').html('');
                    loadCities();

                    $('#title').html('Add city');
                    $('#countryName').val('');

                    var newButton = document.createElement('button');
                    newButton.id = 'saveCityBtn';
                    document.getElementById("updateCityBtn").parentNode.removeChild(document.getElementById('updateCityBtn'));
                    document.getElementById("button").appendChild(newButton);
                    document.getElementById('saveCityBtn').innerHTML = 'Add city';
                    document.getElementById('saveCityBtn').classList.add('btn');
                    document.getElementById('saveCityBtn').classList.add('btn-default');
                    document.getElementById('saveCityBtn').classList.add('btn-md');
                    document.getElementById('saveCityBtn').addEventListener('click', function () {
                        saveCity()
                    });

                    var select = document.getElementById('countries');
                    select.selectedIndex = 0;

                    var updateButtons = document.getElementsByClassName('updateButton');
                    var deleteButtons = document.getElementsByClassName('deleteButton');
                    for (var i in updateButtons) {
                        updateButtons[i].disabled = false;
                        deleteButtons[i].disabled = false;
                    }
                }
            }
            ,
            error: function (error) {
                console.log(error);
            }
        })
        ;
    }
}


function deleteCity(cityId) {
    $.ajax({
        url: '/city?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        type: 'DELETE',
        data: JSON.stringify(cityId),
        success: function (res) {
            loadCities();
        },
        error: function (error) {
            console.log(error);
        }
    })
}

loadCities();
function loadCities() {

    $.ajax({
        url: '/city?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        type: 'GET',
        success: function (res) {
            parseCitiesFromDB(res);
        },
        error: function (error) {
            console.log(error);
        }
    });
}

function parseCitiesFromDB(res) {
    var cities = '';
    $('#result').html('');
    for (var i in res) {
        cities += '<tr><td class=' + "city" + '>' + res[i].name + '</td><td class=' + "country" + '>' + res[i].country.name + '</td><td><button class="btn btn-default updateButton" onclick="updateCity(' + res[i].id + ')">Update</button></td><td><button class="btn btn-default deleteButton" onclick="deleteCity(' + res[i].id + ')">Delete</button></td></tr>';
    }
    $('#result').html(cities);
}


loadCountries();
function loadCountries() {
    $.ajax({
        url: '/country?' + $('input[name = csrf_name]').val() + "=" + $('#input[name = csrf_value]').val(),
        type: 'GET',
        success: function (res) {
            parseCountriesFromDb(res);
        },
        error: function (error) {
            console.log(error);
        }
    });
}

function parseCountriesFromDb(res) {
    var countries = '';
    $('#countries').html('');
    for (var i in res) {
        countries += '<option value="' + res[i].id + '">' + res[i].name + '</option>';
    }
    $('#countries').html(countries);
}