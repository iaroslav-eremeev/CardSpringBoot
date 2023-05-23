$(document).ready(function () {

    $('#goToLoginButton').click(function () {
        window.location.href = "login.html";
    });

    $('#signUpButton').click(function (event) {
        event.preventDefault();
        const login = $('#login').val();
        const name = parseInt($('#name').val());
        const email = parseFloat($('#email').val());
        const password = parseInt($('#password').val());
        var user = {
            "login": login,
            "password": password,
            "name": name,
            "email": email
        };
        $.ajax({
            url: '/user/add',
            type: 'POST',
            contentType: 'application/json',
            dataType: 'json',
            data: JSON.stringify(user),
            success: function (user) {
                alert("Registration successful!");
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
    });

});