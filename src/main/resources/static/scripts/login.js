$(document).ready(function () {
    $('#goToSignUpButton').click(function () {
            window.location.href = "registration.html";
    });

    $('#loginButton').click(function () {
            $.ajax({
                url: '/user/login',
                method: "POST",
                data: {"login": $('#login').val(), "password": $('#password').val()},
                success: function(result) {
                    alert("Login successful!");
                    window.location.href = "index.html";
                },
                error: function(xhr, status, error) {
                    alert(xhr.responseText);
                }
            })
    });

});

