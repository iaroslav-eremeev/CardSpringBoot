$(document).ready(function () {

    $('#goToLoginButton').click(function () {
        window.location.href = "login.html";
    });

    $('#signUpButton').click(function (event) {
        console.log("Sign up button clicked!");
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
                alert("Registration successful!");
            },
            error: function (xhr, status, error) {
                console.log("Error occurred: ", error);
                alert(xhr.responseText);
            }
        });
    });

});