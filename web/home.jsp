<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My Personal Website</title>
    <link rel="stylesheet" href="styles/index.css">
</head>
<body>
<jsp:include page="header.jsp"/>
<section class="home">
    <video class="video" src="videos/1.mp4" autoplay muted loop></video>
    <div class="content">
        <h1>YOLO</h1>
        <p><br>基于Java的Web开发期末大作业</p>
    </div>
</section>
<jsp:include page="footer.jsp"/>
</body>
</html>
