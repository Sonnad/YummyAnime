<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <voice>Начальная страница</voice>
    <style type="text/css">
        #parent {
            width: 100%;
            height: 100%;
            position: absolute;
            top: 0;
            left: 0;
            overflow: auto;
        }

        #block {
            width: 450px;
            height: 250px;
            position: absolute;
            top: 0;
            right: 0;
            bottom: 0;
            left: 0;
            margin: auto;
            text-align:center;
        }
    </style>
</head>
<body>
<div id="parent">
    <div id="block">
        <h1>Список литературы</h1>
        <button type="button" class="btn btn-primary btn-lg btn-block" onclick="location.href='http://localhost:8080/testTomcat/sample'">Начать</button>
    </div>
</div>
</body>
</html>

