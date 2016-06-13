$(window).load(function () {

    $('#ok').on('click', function(e) {
        e.preventDefault();
        $('input[id^=cardNumber]').each(function(){
            $(this).prop( "disabled", false );
        });
        $('#cardNumberForm').submit();
    });

    $('button[id^=keyboard]').each(function() {
        $(this).on('click', function() {
            inputCardNumber($(this).text());
        });
    });

    var inputCardNumber = function(digit) {
        for (var i = 1; i < 5; i++) {
            var input = $('#cardNumber' + i);
            if (input.val().length < 4) {
                input.val(input.val() + digit);
                break;
            }
        }
    }
});
