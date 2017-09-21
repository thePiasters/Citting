<%--
  Created by IntelliJ IDEA.
  User: lordmordulec
  Date: 05.09.17
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Retrive password</title>
    <style>
        .wrapper
        {
            text-align: center;
            padding-top: 10%;
        }


        #answear
        {
            display: none;
        }
        #correct
        {
            display: none;
        }
        #wrong
        {
            display: none;
        }

    </style>
    <script>
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
    </script>
</head>
<body>
    <div class="wrapper">
            <form>

                ${user.question.content}
                <br>
                <span id="answear">${user.answear}</span>

                Answear:
                    <input name="testAnswear" id="test">
                    <input type="submit" id="confirm" value="confirm">
            </form>

            <div id="correct">
                Your password: <em> ${user.password} </em>
                <a href="http://localhost:8080/user/signIn"> Sign In</a>
            </div>

            <span id="wrong">Wrong answear try again </span>
    </div>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="<c:url value="/resources/js/passwordRm.js" />"></script>

</body>
</html>
