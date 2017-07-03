$('#signUp').click(function () {
    saveUser();
});

function saveUser() {
    var user = {
        login: $('#login').val(),
        email: $('#email').val(),
        password: $('#password').val()

    };
    $.ajax({
        url: '/signUp?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        type: 'POST',
        dataType: 'json',
        contentType: 'application/json; charset=UTF-8',
        data: JSON.stringify(user),
        success: function (res) {
            console.log(res);
            if (res == "Login already exist") {
                $('#error').val('Login already exist');
            } else if (res == "Email already exist") {
                $('#error').val("Email already exist");
            } else if (res == "200") {
                location.href = 'http://localhost:8080';
            }
        },
        error: function (error) {
            console.log(error.responseText)
            if (error.responseText == "Login already exist") {
                $('#error').val('Login already exist');
            } else if (error.responseText == "Email already exist") {
                $('#error').val("Email already exist");
            } else if (error.responseText == "200") {
                location.href = 'http://localhost:8080';
            }
        }
    })
}
