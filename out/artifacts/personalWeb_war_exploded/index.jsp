<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>hello</title>
</head>
<body>
<%
    String DBDRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    try {
        Class.forName(DBDRIVER);
        out.println("驱动加载成功");
    } catch (ClassNotFoundException e) {
        out.println("加载失败");
    }
%>
</body>
</html>
