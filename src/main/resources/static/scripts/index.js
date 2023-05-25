$(document).ready(function() {
    showCookies();
    function showCookies(){
        $("#div1").append("<p>userId: " + getCookie("userId")
            + ", user role: " + getCookie("role") + "</p>");
    }

    function getCookie(name) {
        const value = `; ${document.cookie}`;
        const parts = value.split(`; ${name}=`);
        if (parts.length === 2) return parts.pop().split(";").shift();
    }
}