$(".item").click(
    function() {
        $('#modal-overlay, #modal-content').fadeIn("slow");
    }
);

$('#return').click(
    function() {
        $('.createQuiz').fadeOut('slow');
        $('.editQuiz').fadeOut('slow');
        $('.createCategory').fadeOut('slow');
        $('.editCategory').fadeOut('slow');
        $('.editUser').fadeOut('slow');
        $('#modal-overlay, #modal-content').fadeOut("slow");
    }
);

//モーダルの表示内容
$('#createQuiz').click(
    function() {
        $('.createQuiz').css('display', 'block');
    }
);
$('#editQuiz').click(
    function() {
        $('.editQuiz').css('display', 'block');
    }
);
$('#createCategory').click(
    function() {
        $('.createCategory').css('display', 'block');
    }
);
$('#editCategory').click(
    function() {
        $('.editCategory').css('display', 'block');
    }
);
$('#editUser').click(
    function() {
        $('.editUser').css('display', 'block');
    }
);