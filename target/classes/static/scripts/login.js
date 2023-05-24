$(document).ready(function () {

    $('#goToSignUpButton').click(function () {
            window.location.href = "registration.html";
    });

    $('#loginButton').click(function () {
        const login = $('#login').val();
        let password = $('#password').val();
            $.ajax({
                url: '/user/login',
                method: "POST",
                data: {
                    "login": login,
                    "password": password
                },
                success: function(result) {
                    console.log('Success:', result);
                    password = '';
                    $('#popupSuccess').fadeIn();
                },
                error: function(xhr, status, error) {
                    console.log("Error occurred: ", error);
                    password = '';
                    const errorMessage = xhr.responseText || "Something went wrong";
                    $('#popupFailure').find('p').text(errorMessage);
                    $('#popupFailure').fadeIn();
                }
            })
    });

    $('#okButton').click(function () {
        $('#popupSuccess').fadeOut();
        window.location.href = "index.html";
    });

    $('#okFailButton').click(function () {
        $('#popupFailure').fadeOut();
    });
});

