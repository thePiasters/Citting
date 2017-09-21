<%--
  Created by IntelliJ IDEA.
  User: lordmordulec
  Date: 06.09.17
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Generated Place</title>
    <style>

        .wrapper {
            text-align: center;
            font-size: 200%;
            padding-top: 5%;
        }
        

        #confirmHistory
        {
            display: none;
        }
        #confirmWhishList
        {
            display: none;
        }
    </style>
    <script>
        document.addEventListener("DOMContentLoaded" , function () {

            var history = document.getElementById('history');
            var wishList = document.getElementById('wishList');

            var confirmHistory= document.getElementById('confirmHistory');
            var confirmWhishList=document.getElementById('confirmWhishList');

            var cancelh=document.getElementById("cancelh");
            var cancelw=document.getElementById("cancelw");

            var toHistory=document.getElementById("toHistory");
            var towishList=document.getElementById("towishList");




            history.addEventListener('click', function (event) {
                event.preventDefault();
                confirmWhishList.style.display = 'none';
                confirmHistory.style.display = 'block';
            });

            wishList.addEventListener('click', function(event) {
                event.preventDefault();
                confirmWhishList.style.display = 'block';
                confirmHistory.style.display = 'none';

            });

            cancelh.addEventListener('click',function(event)
            {
                event.preventDefault();
                confirmHistory.style.display = 'none';
                confirmWhishList.style.display = 'none';
            });
            cancelw.addEventListener('click',function(event)
            {
                event.preventDefault();
                confirmHistory.style.display = 'none';
                confirmWhishList.style.display = 'none';
            });



            toHistory.addEventListener('click',function(event)
            {
                event.preventDefault();
                window.location='http://localhost:8080/addedToHistory';
            });

            towishList.addEventListener('click',function(event)
            {
                event.preventDefault();
                window.location='http://localhost:8080/addedToWishList';
            });





        });



    </script>



</head>
<body>
<div class="wrapper">

        ${generatedPlace.name}
            <br>
        ${generatedPlace.description}
            <br>
        ${generatedPlace.address}
            <br>
            ${generatedPlace.rate}

            <c:forEach items="${userPlaceList}" var="userPlace">
                <c:if test="${ not empty userPlace.opinion}">
                    ${userPlace.user.login}
                    Opinion:
                    <br>
                    ${userPlace.opinion}
                </c:if>



                <br>
            </c:forEach>

            <c:if test="${isLogged}">


                <input type="submit" id='history' value="I am going there !">


                    <div id="confirmHistory">

                        Do you want to add ${generatedPlace.name} to your visited places ?
                        <input type="submit" id='toHistory' value="Add to Visited Places">
                        <input type="submit" id='cancelw' value="cancel">
                    </div>




                <input type="submit" id='wishList' value="Add to whish List">
            <a href="http://localhost:8080/rate/${userPlace.id}"> Rate or write an opinion</a>

            <div id="confirmWhishList">

                Do you want to add ${generatedPlace.name} to your whish list ?

                <input type="submit" id='towishList' value="Add to whish List">
                <input type="submit" id='cancelh' value="cancel">
            </div>
        </div>



        </c:if>

        <c:if test="${!isLogged}" >
            <a href="http://localhost:8080/user/signIn"><em>Sign In</em></a> or <a href="http://localhost:8080/user/signUp"><em> Sign Up</em></a>
        </c:if>
</body>

</html>
