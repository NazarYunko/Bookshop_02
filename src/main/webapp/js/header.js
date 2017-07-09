function checkField(elem) {
    if ($(elem).val().length == 1) {
        $(elem).css('background', 'white');
    }
}

$('#searchForm').submit(function (event) {
    event.preventDefault();
    var search = $('#search');
    var searchValue = search.val();

    if (searchValue == '') {
        search.css('background', 'rgba(151, 22, 28, 0.15)')
    } else {
        $('#searchForm').unbind('submit').submit();
    }
});
