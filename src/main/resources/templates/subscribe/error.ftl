<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
    <title>操作错误</title>
</head>
<body>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="alert alert-dismissable alert-danger">
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                <h4>
                    出错啦!
                </h4> <strong>${message}!</strong><a href="#" class="alert-link">5s后自动跳转</a>
            </div>
        </div>
    </div>
</div>
</body>

<script>
setTimeout('location.href="${url}"',5000)

</script>
</html>