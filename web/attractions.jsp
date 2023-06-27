<%@ page import="mw.attraction.attractionServers" %>
<%@ page import="mw.attraction.home_attraction" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Attractions</title>
    <link rel="stylesheet" href="styles/attractions.css">
</head>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Culture</title>
    <link rel="stylesheet" href="styles/culture.css">
</head>
<body>
<jsp:include page="header.jsp"/>
<%
    attractionServers culture = new attractionServers();
    ArrayList<home_attraction> list;
    try {
        list = culture.getAttractions();
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
%>
<section class="home">
    <div class="container">
        <div class="leftSide">
            <jsp:include page="search.jsp"/>
            <div class="attractionList">
                <h3 class="title">菜名</h3>
                <%for (int i = 0; i < list.size(); i++) {%>
                <ul>
                    <li>
                        <span class="text" id="attractionList"><%=list.get(i).getId()%> --- <%=list.get(i).getName()%></span>
                    </li>
                    <%}%>
                </ul>
            </div>
        </div>

        <div class="rightSide">
            <div id="attractionName">

            </div>

            <div id="attractionImg">

            </div>

            <div id="attractionAddress">

            </div>

            <div id="attractionDescription">

            </div>
        </div>
    </div>
</section>
<jsp:include page="footer.jsp"/>
</body>
<script src="js/jquery-3.6.0.js"></script>
<script type="text/javascript">
    $(".btn").click(function () {
        const id = $("#search-text").val();

        $.ajax({
            url: "${pageContext.request.contextPath}/AttractionServlet",	//上传URL
            type: "get", //请求方式
            data: {"id": id}, //需要上传的数据
            dataType: "json", //设置接受到的响应数据的格式
            success: function (data) {	//请求成功
                console.log(data);
                $("#attractionName").empty();
                $("#attractionImg").empty();
                $("#attractionAddress").empty();
                $("#attractionDescription").empty();

                $("#attractionName").append(data.name);
                $("#attractionImg").append('<img class="image" src="' + data.image + '"  alt=""/>');
                $("#attractionAddress").append("景点地址："+data.inheritor);
                $("#attractionDescription").append(data.description);
            },
            error: function () {
                alert("出错啦...");
            }  //表示如果请求响应出现错误，会执行的回调函数
        });
    })
</script>
</html>
