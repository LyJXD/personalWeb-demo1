<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!"%>
</h1>
<br/>
<p id="pp" onmouseover="change()" onmousedown="fun()">click me</p>
<p id="ppp"></p>
</body>
<script src="js/jquery-3.6.0.js"></script>
<script>
    function change() {
        document.getElementById('pp').style.color = "red";
    }

    function fun() {
        document.getElementById('pp').style.color = "black";
        console.log("i will begin");
        $.ajax({
            url: "${pageContext.request.contextPath}/Servlet2",
            dataType: "text",
            data: {
                data: "this is a data"
            },
            success: function (data) {
                console.log(data);
                $("#ppp").text(data);
            },
            error: function () {
                $("#ppp").text("error");
            }
        })
        console.log("i am over");
    }

</script>

</html>

