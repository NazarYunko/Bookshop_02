loadPublishers();

function checkField(elem) {
    if ($(elem).val().length == 1) {
        $(elem).css('background', 'white');
    }
}

$('#savePublisherBtn').click(function () {
    savePublisher();
});

function savePublisher() {

    var name = $('#publisherName');
    var nameValue = name.val();

    if (nameValue == '') {
        name.css('background', 'rgba(151, 22, 28, 0.15)');
    } else if (nameValue != '') {
        var publisher = {
            name: nameValue
        }

        $.ajax({
            url: '/publisher?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
            type: 'POST',
            dataType: 'json',
            contentType: 'application/json; charset=UTF-8',
            data: JSON.stringify(publisher),
            success: function (res) {
                if (res == false) {
                    $('#error').html('Publisher already exist!');
                } else {
                    name.val('');
                    $('#error').html('');
                    loadPublishers();
                }
            },
            error: function (error) {
                console.log(error);
            }
        })
    }
}

function updatePublisher(countryId) {

    var publisher = {
        id: 0,
        name: ''
    };

    $.ajax({
        url: '/publisher?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        type: 'GET',
        success: function (res) {

            for (var i in res) {
                if (res[i].id == countryId) {
                    publisher.id = res[i].id;
                    publisher.name = res[i].name;
                }
            }

            $('#title').html('Update publisher');
            $('#publisherName').val(publisher.name);
            window.scrollTo(0, 0);

            var newButton = document.createElement('button');
            newButton.id = 'updatePublisherBtn';
            document.getElementById("savePublisherBtn").parentNode.removeChild(document.getElementById('savePublisherBtn'));
            document.getElementById("button").appendChild(newButton);
            document.getElementById('updatePublisherBtn').innerHTML = "Update publisher";
            document.getElementById('updatePublisherBtn').classList.add('btn');
            document.getElementById('updatePublisherBtn').classList.add('btn-default');
            document.getElementById('updatePublisherBtn').classList.add('btn-md');
            document.getElementById('updatePublisherBtn').addEventListener('click', function () {
                saveUpdates(publisher.id);
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

function saveUpdates(publisherId) {
    var name = $('#publisherName');
    var nameValue = name.val();

    if (nameValue == '') {
        name.css('background', 'rgba(151, 22, 28, 0.15)')
    }

    if (nameValue != '') {
        var publisherToTransfer = {
            id: publisherId,
            name: nameValue
        };

        $.ajax({
            url: '/publisher?' + $('input[name = csrf_name]').val() + "=" + $('input[name = csrf_value]').val(),
            type: 'PUT',
            dataType: 'json',
            contentType: 'application/json; charset=UTF-8',
            data: JSON.stringify(publisherToTransfer),
            success: function (res) {
                if (res == false) {
                    $('#error').html('Publisher already exist!');
                } else {
                    name.val('');
                    $('#error').html('');
                    loadPublishers();

                    $('#title').html('Add publisher');
                    $('#publisherName').val('');

                    var newButton = document.createElement('button');
                    newButton.id = 'savePublisherBtn';
                    document.getElementById("updatePublisherBtn").parentNode.removeChild(document.getElementById('updatePublisherBtn'));
                    document.getElementById("button").appendChild(newButton);
                    document.getElementById('savePublisherBtn').innerHTML = 'Add publisher';
                    document.getElementById('savePublisherBtn').classList.add('btn');
                    document.getElementById('savePublisherBtn').classList.add('btn-default');
                    document.getElementById('savePublisherBtn').classList.add('btn-md');
                    document.getElementById('savePublisherBtn').addEventListener('click', function () {
                        savePublisher()
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

function deletePublisher(publisherId) {
    $.ajax({
        url: '/publisher?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        type: 'DELETE',
        data: JSON.stringify(publisherId),
        success: function (res) {
            loadPublishers();
        },
        error: function (error) {
            console.log(error);
        }
    })
}

function loadPublishers() {
    $.ajax({
        url: '/publisher?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
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
    var publishers = '';
    $('#result').html('');
    for (var i in res) {
        publishers += '<tr><td class=' + "publisher" + '>' + res[i].name + '</td><td><button class="btn btn-default updateButton" onclick="updatePublisher(' + res[i].id + ')">Update</button></td><td><button class="btn btn-default deleteButton" onclick="deletePublisher(' + res[i].id + ')">Delete</button></td></tr>';
    }
    $('#result').html(publishers);
}

