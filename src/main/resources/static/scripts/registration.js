$(document).ready(function () {

    $('#goToLoginButton').click(function () {
        window.location.href = "login.html";
    });

    $('#signUpButton').click(function () {
        const login = $('#login').val();
        const name = $('#name').val();
        const email = $('#email').val();
        let password = $('#password').val();
        $.ajax({
            url: '/user/add',
            type: 'POST',
            data: {
                "login": login,
                "password": password,
                "name": name,
                "email": email
            },
            success: function (user) {
                password = '';
                $('#popupSuccess').fadeIn();
            },
            error: function (xhr, status, error) {
                password = '';
                console.log("Error occurred: ", error);
                const errorMessage = xhr.responseText || "Something went wrong";
                $('#popupFailure').find('p').text(errorMessage);
                $('#popupFailure').fadeIn();
            }
        });
    });

    $('#okButton').click(function () {
        $('#popupSuccess').fadeOut();
        window.location.href = "login.html";
    });

    $('#okFailButton').click(function () {
        $('#popupFailure').fadeOut();
    });

});