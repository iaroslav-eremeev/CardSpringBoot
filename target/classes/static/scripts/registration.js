$(document).ready(function () {

    $('#goToLoginButton').click(function () {
        window.location.href = "login.html";
    });

    $('#signUpButton').click(function (event) {
        event.preventDefault();
        const login = $('#login').val();
        const name = $('#name').val();
        const email = $('#email').val();
        const password = $('#password').val();
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
                $('.popup-fade').fadeIn();
            },
            error: function (xhr, status, error) {
                console.log("Error occurred: ", error);
                alert(xhr.responseText);
            }
        });
    });

    $('#okButton').click(function () {
        $('.popup-fade').fadeOut();
        window.location.href = "login.html";
    })

});