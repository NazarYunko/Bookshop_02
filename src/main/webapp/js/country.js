loadCountries();

function checkField(elem) {
    if ($(elem).val().length == 1) {
        $(elem).css('background', 'white');
    }
}

$('#saveCountryBtn').click(function () {
    saveCountry();
});

function saveCountry() {

    var name = $('#countryName');
    var nameValue = name.val();

    if (nameValue == '') {
        name.css('background', 'rgba(151, 22, 28, 0.15)')
    }

    if (nameValue != '') {
        var country = {
            name: nameValue
        };

        $.ajax({
            url: '/country?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
            type: 'POST',
            dataType: 'json',
            contentType: 'application/json; charset=UTF-8',
            data: JSON.stringify(country),
            success: function (res) {
                if (res == false) {
                    $('#error').html('Country already exist!');
                } else {
                    name.val('');
                    $('#error').html('');
                    loadCountries();
                }
            },
            error: function (error) {
                console.log(error);
            }
        })

    }
}

function updateCountry(countryId) {

    var country = {
        id: 0,
        name: ''
    };

    $.ajax({
        url: '/country?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        type: 'GET',
        success: function (res) {

            for (var i in res) {
                if (res[i].id == countryId) {
                    country.id = res[i].id;
                    country.name = res[i].name;
                }
            }

            $('#title').html('Update country');
            $('#countryName').val(country.name);
            window.scrollTo(0, 0);

            var newButton = document.createElement('button');
            newButton.id = 'updateCountryBtn';
            document.getElementById("saveCountryBtn").parentNode.removeChild(document.getElementById('saveCountryBtn'));
            document.getElementById("button").appendChild(newButton);
            document.getElementById('updateCountryBtn').innerHTML = "Update country";
            document.getElementById('updateCountryBtn').classList.add('btn');
            document.getElementById('updateCountryBtn').classList.add('btn-default');
            document.getElementById('updateCountryBtn').classList.add('btn-md');
            document.getElementById('updateCountryBtn').addEventListener('click', function () {
                saveUpdates(country.id);
            });

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

function saveUpdates(countryId) {
    var name = $('#countryName');
    var nameValue = name.val();

    if (nameValue == '') {
        name.css('background', 'rgba(151, 22, 28, 0.15)')
    }

    if (nameValue != '') {
        var countryToTransfer = {
            id: countryId,
            name: nameValue
        };

        $.ajax({
            url: '/country?' + $('input[name = csrf_name]').val() + "=" + $('input[name = csrf_value]').val(),
            type: 'PUT',
            dataType: 'json',
            contentType: 'application/json; charset=UTF-8',
            data: JSON.stringify(countryToTransfer),
            success: function (res) {
                if (res == false) {
                    $('#error').html('Country already exist!');
                } else {
                    name.val('');
                    $('#error').html('');
                    loadCountries();

                    $('#title').html('Add country');
                    $('#countryName').val('');

                    var newButton = document.createElement('button');
                    newButton.id = 'saveCountryBtn';
                    document.getElementById("updateCountryBtn").parentNode.removeChild(document.getElementById('updateCountryBtn'));
                    document.getElementById("button").appendChild(newButton);
                    document.getElementById('saveCountryBtn').innerHTML = 'Add country';
                    document.getElementById('saveCountryBtn').classList.add('btn');
                    document.getElementById('saveCountryBtn').classList.add('btn-default');
                    document.getElementById('saveCountryBtn').classList.add('btn-md');
                    document.getElementById('saveCountryBtn').addEventListener('click', function () {
                        saveCountry()
                    });

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

function deleteCountry(countryId) {
    $.ajax({
        url: '/country?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        type: 'DELETE',
        data: JSON.stringify(countryId),
        success: function (res) {
            loadCountries();
        },
        error: function (error) {
            console.log(error);
        }
    })
}

function loadCountries() {
    $.ajax({
        url: '/country?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        type: 'GET',
        success: function (res) {
            parseResFromDB(res);
        },
        error: function (error) {
            console.log(error);
        }
    });
}

function parseResFromDB(res) {
    var countries = '';
    $('#result').html('');
    for (var i in res) {
        countries += '<tr><td class=' + "country" + '>' + res[i].name + '</td><td><button class="btn btn-default updateButton" onclick="updateCountry(' + res[i].id + ')">Update</button></td><td><button class="btn btn-default deleteButton" onclick="deleteCountry(' + res[i].id + ')">Delete</button></td></tr>';
    }
    $('#result').html(countries);
}

