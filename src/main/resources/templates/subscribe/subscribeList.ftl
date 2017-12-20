<!doctype html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"/>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <link rel="stylesheet" href="/subscribe/css/amazeui.min.css">
    <link rel="stylesheet" href="/subscribe/css/wap.css">
    <title></title>
</head>

<body style="background:#ececec">
<div class="pet_mian">
    <div class="pet_head">
        <header data-am-widget="header" class="am-header am-header-default pet_head_block">
            <div class="am-header-left am-header-nav ">
                <a href="#left-link" onclick="javascript:history.back(-1);" class="iconfont pet_head_jt_ico">&#xe601;</a>
            </div>

            <div class="am-header-right am-header-nav">
                <a href="javascript:;" class="iconfont pet_head_gd_ico">&#xe600;</a>
            </div>
        </header>
    </div>

    <div class="pet_more_list">
        <div class="pet_more_list_block">
            <div class="iconfont pet_more_close">×</div>
            <div class="pet_more_list_block">
                <div class="pet_more_list_block_name">
                    <div class="pet_more_list_block_name_title">联系我WeChat：Lhl1477551037</div>
                    <a class="pet_more_list_block_line" href="http://xinlovezhang.top:8080/ftl/auth"> <i
                            class="iconfont pet_nav_xinxianshi pet_more_list_block_line_ico">&#xe61e;</i>
                        <div class="pet_more_list_block_line_font">首页</div>
                    </a>

                </div>
            </div>

        </div>
    </div>

    <div class="pet_content pet_content_list">
        <div class="pet_article_like">
            <div class="pet_content_main pet_article_like_delete">
                <div data-am-widget="list_news" class="am-list-news am-list-news-default am-no-layout">
                    <div class="am-list-news-bd">
                        <ul class="am-list">

                        <#--index-->
                            <#list subscribeList as subscribeVo>
                            <li class="am-g am-list-item-desced pet_list_one_block" onclick="javascript:location.href='/subscribe/user/center?userId=${subscribeVo.userId}'">
                                <div class="pet_list_one_info">
                                    <div class="pet_list_one_info_l">
                                        <div class="pet_list_one_info_ico"><img src="${subscribeVo.headImage!"img/a5.png"}" alt=""></div>
                                        <div class="pet_list_one_info_name">${subscribeVo.nickName}</div>
                                    </div>
                                    <div class="pet_list_one_info_r">
                                        <div class="pet_list_tag pet_list_tag_mzt">${subscribeVo.region!""}</div>
                                    </div>
                                </div>
                                <div class=" am-list-main">
                                    <div class="am-list-item-text pet_list_two_text">
                                        ${subscribeVo.description!"还没有个人自我介绍"}
                                    </div>
                                </div>
                            </li>
                            </#list>
                        <#--end-->

                        </ul>
                    </div>

                </div>

            </div>

        </div>

    </div>
</div>
<script src="js/jquery.min.js"></script>
<script src="js/amazeui.min.js"></script>

</body>

</html>