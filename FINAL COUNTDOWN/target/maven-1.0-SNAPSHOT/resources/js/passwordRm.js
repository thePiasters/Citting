document.addEventListener("DOMContentLoaded" , function () {

    console.log("hello!");

    var confirm = document.getElementById('confirm');

    confirm.addEventListener('click',function (event)
    {
        event.preventDefault();

        var test = document.getElementById('test');
        var answear = document.getElementById('answear');
        var correct= document.getElementById("correct");
        var wrong = document.getElementById("wrong");

        sessionStorage.setItem("testAnswear", test.value);
        sessionStorage.setItem("answear", answear.innerText);

        if(test.value==answear.innerText)
        {
            wrong.style.display='none';
            correct.style.display='block';
        }
        else
        {
            wrong.style.display='block';
        }


    });


});