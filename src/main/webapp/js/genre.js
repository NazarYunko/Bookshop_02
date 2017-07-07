loadGenres();

function checkField(elem) {
    if ($(elem).val().length == 1) {
        $(elem).css('background', 'white');
    }
}

$('#saveGenreBtn').click(function () {
    saveGenre();
});

function saveGenre() {
    var name = $('#genreName');
    var nameValue = name.val();

    if (nameValue == '') {
        name.css('background', 'rgba(151, 22, 28, 0.15)')
    }

    if (nameValue != '') {
        var genre = {
            name: nameValue
        };

        $.ajax({
            url: '/genre?' + $('input[name = csrf_name]').val() + '=' + $('input[name = csrf_value]').val(),
            type: 'POST',
            dataType: 'json',
            contentType: 'application/json; charset=UTF-8',
            data: JSON.stringify(genre),
            success: function (res) {
                if (res == false) {
                    $('#error').html('Genre already exist!');
                } else {
                    name.val('');
                    $('#error').html('');
                    loadGenres();
                }
            },
            error: function (error) {
                console.log(error)
            }
        });
    }
}

function updateGenre(genreId) {

    var genre = {
        id: 0,
        name: ''
    };

    $.ajax({
        url: '/genre?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        type: 'GET',
        success: function (res) {

            for (var i in res) {
                if (res[i].id == genreId) {
                    genre.id = res[i].id;
                    genre.name = res[i].name;
                }
            }

            $('#title').html('Update genre');
            $('#genreName').val(genre.name);
            window.scrollTo(0, 0);

            var newButton = document.createElement('button');
            newButton.id = 'updateGenreBtn';
            document.getElementById("saveGenreBtn").parentNode.removeChild(document.getElementById('saveGenreBtn'));
            document.getElementById("button").appendChild(newButton);
            document.getElementById('updateGenreBtn').innerHTML = "Update genre";
            document.getElementById('updateGenreBtn').classList.add('btn');
            document.getElementById('updateGenreBtn').classList.add('btn-default');
            document.getElementById('updateGenreBtn').classList.add('btn-md');
            document.getElementById('updateGenreBtn').addEventListener('click', function () {
                saveUpdates(genre.id);
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

function saveUpdates(genreId) {
    var name = $('#genreName');
    var nameValue = name.val();

    if (nameValue == '') {
        name.css('background', 'rgba(151, 22, 28, 0.15)')
    }

    if (nameValue != '') {
        var genreToTransfer = {
            id: genreId,
            name: nameValue
        };

        $.ajax({
            url: '/genre?' + $('input[name = csrf_name]').val() + "=" + $('input[name = csrf_value]').val(),
            type: 'PUT',
            dataType: 'json',
            contentType: 'application/json; charset=UTF-8',
            data: JSON.stringify(genreToTransfer),
            success: function (res) {
                if (res == false) {
                    $('#error').html('Genre already exist!');
                } else {
                    name.val('');
                    $('#error').html('');
                    loadGenres();

                    $('#title').html('Add genre');
                    $('#countryName').val('');

                    var newButton = document.createElement('button');
                    newButton.id = 'saveGenreBtn';
                    document.getElementById("updateGenreBtn").parentNode.removeChild(document.getElementById('updateGenreBtn'));
                    document.getElementById("button").appendChild(newButton);
                    document.getElementById('saveGenreBtn').innerHTML = 'Add genre';
                    document.getElementById('saveGenreBtn').classList.add('btn');
                    document.getElementById('saveGenreBtn').classList.add('btn-default');
                    document.getElementById('saveGenreBtn').classList.add('btn-md');
                    document.getElementById('saveGenreBtn').addEventListener('click', function () {
                        saveGenre()
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

function deleteGenre(genreId) {
    $.ajax({
        url: '/genre?' + $('input[name = csrf_name]').val() + '=' + $('input[name = csrf_value]').val(),
        type: 'DELETE',
        data: JSON.stringify(genreId),
        success: function (res) {
            loadGenres();
        },
        error: function (error) {
            console.log(error);
        }
    });
}

function loadGenres() {
    $.ajax({
        url: '/genre?' + $('input[name = csrf_name]').val() + "=" + $('input[name = csrf_value]').val(),
        type: 'GET',
        success: function (res) {
            parseResFromDB(res)
        },
        error: function (error) {
            console.log(error);
        }
    });
}

function parseResFromDB(res) {
    var genres = '';
    $('#result').html('');
    for (var i in res) {
        genres += '<tr><td class=' + "genre" + '>' + res[i].name + '</td><td><button class="btn btn-default updateButton" onclick="updateGenre(' + res[i].id + ')">Update</button></td><td><button class="btn btn-default deleteButton" onclick="deleteGenre(' + res[i].id + ')">Delete</button></td></tr>';
    }
    $('#result').html(genres);
}