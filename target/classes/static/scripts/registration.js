$(document).ready(function () {

    $('#goToLoginButton').click(function () {
        window.location.href = "login.html";
    });

    $('#signUpButton').click(function () {
        $.ajax({
            url: '/user/add',
            method: "POST",
            data: {
                "login": $('#login').val(),
                "password": $('#password').val(),
                "name": $('#name').val(),
                "email": $('#email').val()
            },
            success: function (data) {
                $('.popup-fade').fadeIn();
            },
            error: function (xhr, status, error) {
                alert(xhr.responseText);
            }
        });
    });

    $('#okButton').click(function () {
        $('.popup-fade').fadeOut();
        window.location.href = "login.html";
    });

});