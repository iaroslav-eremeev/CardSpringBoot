$('#goToSignUpButton').click(function () {
        $(location).attr('href', "http://localhost:8080/CardSpringBoot/registration.html");
    }
)

$('#loginButton').click(function () {
        $.ajax({
            url: '/user/login',
            method: "POST",
            data: {"login": $('#login').val(), "password": $('#password').val()},
            success: function(result) {
                $(location).attr('href', "http://localhost:8080/CardSpringBoot/index.html");
            },
            error: function(xhr, status, error) {
                alert(xhr.responseText);
            }
        })
    }
)