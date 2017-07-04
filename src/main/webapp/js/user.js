function saveUser() {
    if ($('#login').val() != '' && $('#email').val() != '' && $('#password').val() != '') {
        var user = {
            login: $('#login').val(),
            email: $('#email').val(),
            password: $('#password').val()

        };
        $.ajax({
            url: '/findUsers?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
            type: 'GET',
            success: function (res) {

                var exist = false;
                for (var i in res) {
                    if (user.login == res[i].login) {
                        $('#error').html('Login already exist');
                        exist = true;
                    } else if (user.email == res[i].email) {
                        $('#error').html("Email already exist");
                        exist = true;
                    }
                }

                if (exist == false) {
                    save(user);
                }

            },
            error: function (error) {
                console.log(error);
            }
        });

    }
}

function save(user) {
    $.ajax({
        url: '/save?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        type: 'POST',
        dataType: 'json',
        contentType: 'application/json; charset=UTF-8',
        data: JSON.stringify(user),
        success: function (res) {
            console.log(res);
        },
        error: function (error) {
            console.log(error);
        }
    });
    document.location.href = 'http://localhost:8080';
}