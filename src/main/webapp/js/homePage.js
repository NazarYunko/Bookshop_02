loadNewBooks();
function loadNewBooks() {
    $.ajax({
        url: '/findNewBooks?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        type: 'GET',
        success: function (res) {

            var i = 1;
            while (res[i - 1] != null) {
                $('#div' + i).append('<a href="/books/' + res[i - 1].id + '"><image src="' + res[i - 1].pathImage + '" class="img-rounded" width="250px" height="325px"></image></a>');
                i++;
            }

        },
        error: function (error) {
            console.log(error);
        }
    });
}