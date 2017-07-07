//sign in validation
$('#form').submit(function (event) {
    event.preventDefault();

    var userName = $('#userName');
    var userNameValue = userName.val();

    var pass = $('#password');
    var passValue = pass.val();

    if (userNameValue == '') {
        userName.css('background', 'rgba(151, 22, 28, 0.15)');
    } else if (passValue == '') {
        pass.css('background', 'rgba(151, 22, 28, 0.15)');
    } else {
        $('#form').unbind('submit').submit();
    }
});

function checkField(elem) {
    if ($(elem).val().length == 1) {
        $(elem).css('background', 'white');
    }
}

//sign up
function saveUser() {

    var login = $('#login');
    var loginValue = login.val();

    var email = $('#email');
    var emailValue = email.val();

    var pass = $('#password');
    var passValue = pass.val();

    if (loginValue == '') {
        login.css('background', 'rgba(151, 22, 28, 0.15)');
    } else if (emailValue == '') {
        email.css('background', 'rgba(151, 22, 28, 0.15)');
    } else if (passValue == '') {
        pass.css('background', 'rgba(151, 22, 28, 0.15)');
    }

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