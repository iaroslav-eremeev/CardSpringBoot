$('#goToLoginButton').click(function () {
        $(location).attr('href', "http://localhost:8080/CardSpringBoot/login.html");
    }
)

$('#signUpButton').click(function () {
        $.ajax({
            url: 'registration',
            method: "POST",
            data: {"login" : $('#login').val(),
                "password" : $('#password').val(),
                "name" : $('#name').val(),},
            success: [function (data) {
                $('.popup-fade').fadeIn();
            }],
            error: [function (xhr, status, error) {
                alert(xhr.responseText);
            }]
        })
    }
)

$('#okButton').click(function () {
    $('.popup-fade').fadeOut();
    window.location.href = "templates/login.html";
})