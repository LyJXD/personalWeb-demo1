<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Search Box</title>
    <style>
        body {
            margin: 0;
            padding: 0;
        }
        .container-search {
            position: relative;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        input {
            box-sizing: border-box;
        }
        input[type="text"] {
            border: none;
            outline: 4px solid #61a5c2;
            width: 240px;
            height: 36px;
            font-size: 18px;

            padding: 5px 100px 5px 16px;
        }
        input[type="submit"] {
            position: absolute;
            transform: translateX(-59px);
            height: 36px;
            width: 60px;
            border: none;
            outline: none;
            color: #fff;
            font-size: 5px;
            padding: 0 3px;
            letter-spacing: 2px;
            background: #61a5c2;
            cursor: pointer;
            transition: .3s;
        }
        input[type="submit"]:hover {
            background: #89c2d9;
            text-shadow: 0 0 4px #468faf;
        }
        input[type="submit"]:active {
            background: #2a6f97;
        }
    </style>
</head>
<body>
<div class="container-search">
    <form action="#">
        <input id="search-text" type="text" placeholder="Search">
        <input class="btn" type="submit" value="Submit">
    </form>
</div>
</body>
</html>