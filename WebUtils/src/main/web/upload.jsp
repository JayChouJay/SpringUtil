<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>小模板</title>
    <script type="text/javascript">
        window.onload = function () {
            alert(111);
        }
    </script>
</head>
<body>
<hr>
<form action="/upload" method="post" enctype="multipart/form-data">
    <label>请选择文件：</label>
    <input type="file" name="testFile" value=""><br>
    <input type="text" name="testFile1" value="123"><br>
    <input type="text" name="testFile1" value="456"><br>
    <input type="submit" value="提交">
</form>
<a href="/main.html">点我呀</a>
</body>
</html>