<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="styles/header.css" type="text/css">
    <title>Title</title>
</head>
<body>
<header>
    <img src="images/logo.png" class="logo" alt="">
    <div class="header_menuBtn"></div>
    <div class="header_navigation">
        <div class="header_navigation-items">
            <a href="home.jsp">Home</a>
            <a href="profile.jsp">Profile</a>
            <a href="food.jsp">Food</a>
            <a href="attractions.jsp">Attractions</a>
            <a href="culture.jsp">Culture</a>
        </div>
    </div>
</header>
<script type="text/javascript">
    // responsive navigation menu
    const header_menuBtn = document.querySelector(".header_menuBtn");
    const header_navigation = document.querySelector(".header_navigation");

    header_menuBtn.addEventListener("click", () => {
        header_menuBtn.classList.toggle("active")
        header_navigation.classList.toggle("active")
    });
</script>
</body>
</html>
