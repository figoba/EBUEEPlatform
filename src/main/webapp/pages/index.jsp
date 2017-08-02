<html>
<head>
    <script src="./js/jquery.js"></script>
</head>
<body>
<h2>Hello World!</h2>
This is My first MVC demo
<script>

    loadArticle(3);
    function loadArticle(id) {
        $.ajax({
            url: "/user/Test" ,
            type: "GET",

            success: function (data) {alert(data);
            },
            error: function () {
                alert(data);
                $("#divError").show().html("文章不存在！");
            }
        });
    }
</script>
</body>
</html>
