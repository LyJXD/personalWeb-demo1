<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile</title>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
          rel="stylesheet">
    <link rel="stylesheet" href="styles/profile.css">
</head>
<body>
<jsp:include page="header.jsp"/>
<section class="home">
    <div class="container">
        <div class="leftSide">
            <div class="profile">
                <img src="images/img_info.png" alt="personal pic">
                <h2>李宇杰<br><span>YOLO</span></h2>
            </div>

            <div class="contactInfo">
                <h3 class="title">联系方式</h3>
                <ul>
                    <li>
                    <span class="material-icons">
                        call
                        </span>
                        <span class="text">131 5742 1825</span>
                    </li>
                    <li>
                    <span class="material-icons">
                        email
                        </span>
                        <span class="text">xiaotskawaii@gmail.com</span>
                    </li>

                    <li>
                    <span class="material-icons">
                        location_on
                        </span>
                        <span class="text">浙江省杭州市钱塘区</span>
                    </li>
                </ul>
            </div>

            <div class="contactInfo education">
                <h3 class="title">教育经历</h3>
                <ul>

                    <li>
                        <h5>2021-2025</h5>
                        <h4>中国计量大学</h4>
                        <span class="text">计算机专业本科</span>
                    </li>

                </ul>
            </div>
        </div>

        <div class="rightSide">
            <div class="about">
                <h2 class="title2">个人介绍</h2>
                <p>你好，我叫李宇杰，一名计算机科学与技术专业的学生。</p>
            </div>

            <div class="about skills">
                <h2 class="title2">专业技能</h2>
                <div class="box">
                    <h4>HTML</h4>
                    <div class="percent">
                        <div style="width:70%"></div>
                    </div>

                </div>

                <div class="box">
                    <h4>PYTHON</h4>
                    <div class="percent">
                        <div style="width:80%"></div>
                    </div>

                </div>

                <div class="box">
                    <h4>Java</h4>
                    <div class="percent">
                        <div style="width:70%"></div>
                    </div>

                </div>

                <div class="box">
                    <h4>C++</h4>
                    <div class="percent">
                        <div style="width:75%"></div>
                    </div>

                </div>
            </div>

            <div class="about interest">
                <h2 class="title2">兴趣爱好</h2>
                <ul>
                    <li>
                        <span>
                            rhythm
                            </span>
                        音游
                    </li>
                    <li>
                        <span>
                            code
                            </span>
                        编程
                    </li>
                    <li>
                        <span>
                            dance
                            </span>
                        街舞
                    </li>
                    <li>
                </ul>
            </div>
        </div>
    </div>
</section>
<jsp:include page="footer.jsp"/>
</body>
</html>
