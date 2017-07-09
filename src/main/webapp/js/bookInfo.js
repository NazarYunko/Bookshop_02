checkQuantity();

function checkQuantity() {
    if($('#quantity').html() == 0) {
        document.getElementById('quantity').disabled = true;
    }
}