<%@ page import="java.util.*" %>
<%@ page import="mw.culture.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Culture</title>
    <link rel="stylesheet" href="styles/culture.css">
</head>
<body>
<jsp:include page="header.jsp"/>
<%
    cultureServers culture = new cultureServers();
    ArrayList<home_culture> list;
    try {
        list = culture.getCultures();
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
%>
<section class="home">
    <div class="container">
        <div class="leftSide">
            <jsp:include page="search.jsp"/>
            <div class="cultureList">
                <h3 class="title">菜名</h3>
                <%for (int i = 0; i < list.size(); i++) {%>
                <ul>
                    <li>
                        <span class="text" id="cultureList"><%=list.get(i).getId()%> --- <%=list.get(i).getName()%></span>
                    </li>
                    <%}%>
                </ul>
            </div>
        </div>

        <div class="rightSide">
            <div id="cultureName">

            </div>

            <div id="cultureImg">

            </div>

            <div id="cultureInheritor">

            </div>

            <div id="cultureDescription">

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
            url: "${pageContext.request.contextPath}/CultureServlet",	//上传URL
            type: "get", //请求方式
            data: {"id": id}, //需要上传的数据
            dataType: "json", //设置接受到的响应数据的格式
            success: function (data) {	//请求成功
                console.log(data);
                $("#cultureName").empty();
                $("#cultureImg").empty();
                $("#cultureInheritor").empty();
                $("#cultureDescription").empty();

                $("#cultureName").append(data.name);
                $("#cultureImg").append('<img class="image" src="' + data.image + '"  alt=""/>');
                $("#cultureInheritor").append("相关传承人："+data.inheritor);
                $("#cultureDescription").append(data.description);
            },
            error: function () {
                alert("出错啦...");
            }  //表示如果请求响应出现错误，会执行的回调函数
        });
    })
</script>
</html>
