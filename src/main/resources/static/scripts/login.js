$('#goToSignUpButton').click(function () {
    window.location.href = "templates/registration.html";
    }
)

$('#loginButton').click(function () {
        $.ajax({
            url: '/user/login',
            method: "POST",
            data: {"login": $('#login').val(), "password": $('#password').val()},
            success: function(result) {
                window.location.href = "index.html";
            },
            error: function(xhr, status, error) {
                alert(xhr.responseText);
            }
        })
    }
)