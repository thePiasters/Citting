document.addEventListener("DOMContentLoaded" , function () {

    console.log("Hello Im here");

    var div_snack = document.getElementById('snack');
    var div_drink = document.getElementById('drink');
    var drinkers= document.getElementsByClassName('drinkers');
    var snackers= document.getElementsByClassName('snackers');
    var confirm_food= document.getElementById('confirm_food');
   // var body=document.getElementsByTagName('body')[0];



    // document.getElementById(id).style.display = 'block';


    function showSnackers()
    {
        for( var i=0; i<snackers.length; i++)
        {
            snackers[i].style.display='block';
        }

    }
    function hideSnackers() {

        for( var i=0; i<snackers.length; i++)
        {
            snackers[i].style.display='none';
        }

    }
    div_snack.addEventListener('click', function (event) {


            div_snack.style.display = 'none';
            div_drink.style.display='none';

            showSnackers();

    });


    div_drink.addEventListener('click', function (event) {


        div_snack.style.display = 'none';
        div_drink.style.display='none';

        for( var i=0; i<drinkers.length; i++)
        {

            drinkers[i].style.display='block';
        }

    });

    confirm_food.addEventListener('click', function (event) {

        event.preventDefault();
        hideSnackers();

        $(location).attr('href', 'http://stackoverflow.com');




    });


});