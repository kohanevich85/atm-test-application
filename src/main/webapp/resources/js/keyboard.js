$(window).load(function () {
    var inputs = $('input[id^=input]');
    inputs.each(function(){
        $(this).prop( "disabled", true);
    });
    $('#ok').on('click', function(e) {
        e.preventDefault();
        inputs.each(function(){
            $(this).prop( "disabled", false);
        });
        $('#form').submit();
    });

    $('button[id^=keyboard]').each(function() {
        $(this).on('click', function() {
            keyboardInput($(this).text());
        });
    });

    var keyboardInput = function(digit) {
        var inputs = $('input[id^=input]');
        for (var i = 1; i <= inputs.length; i++) {
            var input = $('#input' + i);
            if (input.val().length < 4) {
                input.val(input.val() + digit);
                break;
            }
        }
    }
});
