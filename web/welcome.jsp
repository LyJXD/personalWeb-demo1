<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome</title>
    <link rel="stylesheet" href="styles/welcome.css">
</head>
<body>
<!-- 创建封装容器 -->
<div class="container" id="container">

    <!-- 注册页面 -->
    <div class="form-container sign-up-container">
        <form action="${pageContext.request.contextPath}/RegisterServlet" method="post">
            <h1>sign up</h1>
            <!-- 公共组件 -->
            <input type="text" name="username" placeholder="userName...">
            <input type="password" name="password" placeholder="Password...">
            <input type="email" name="email" id="email" placeholder="Email...">
            <button>register</button>
        </form>
    </div>
    ..


    1
    <!-- 登录页面 -->
    <div class="form-container sign-in-container">
        <form action="${pageContext.request.contextPath}/LoginServlet" method="post">
            <h1>sign in</h1>
            <input type="text" name="username" placeholder="userName...">
            <input type="password" name="password" placeholder="Password...">
            <button>login</button>
        </form>
    </div>

    <!-- 覆盖容器 -->
    <div class="overlay-container">
        <div class="overlay">

            <!-- 覆盖左边 -->
            <div class="overlay-penal overlay-left-container">
                <h1>welcome back!</h1>
                <p>
                    To keep connected with us please log in with your personal info
                </p>
                <button class="ghost" id="signIn">login</button>
            </div>

            <!-- 覆盖右边 -->
            <div class="overlay-penal overlay-right-container">
                <h1>Hello Friend!</h1>
                <p>
                    Enter your personal details and start journey with us
                </p>
                <button class="ghost" id="signUp">register</button>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    const container = document.getElementById('container');
    const signUpButton = document.getElementById('signUp');
    const signInButton = document.getElementById('signIn');

    signUpButton.onclick = function () {
        container.classList.add('penal-right-active');
    }

    signInButton.onclick = function () {
        container.classList.remove('penal-right-active');
    }
</script>
</body>
</html>
