document.addEventListener("DOMContentLoaded" , function () {
    var visited = document.getElementById('toVisited');
    var wishList = document.getElementById('wishList');

    visited.addEventListener('click', function (event) {
        event.preventDefault();
        if (sessionStorage.getItem("login") == false) {
            window.location = "http://localhost:8080/start";
        }
    });

    wishList.addEventListener('click', function (event) {
        event.preventDefault();

        if (sessionStorage.getItem("login") == false) {
            window.location = "http://localhost:8080/start";
        }
    });
});