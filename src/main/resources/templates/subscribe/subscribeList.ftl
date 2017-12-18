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
                    <div class="pet_more_list_block_name_title">阅读 Read</div>
                    <a class="pet_more_list_block_line"> <i
                            class="iconfont pet_nav_xinxianshi pet_more_list_block_line_ico">&#xe61e;</i>
                        <div class="pet_more_list_block_line_font">新鲜事</div>
                    </a>
                    <a class="pet_more_list_block_line"> <i
                            class="iconfont pet_nav_zhangzhishi pet_more_list_block_line_ico">&#xe607;</i>
                        <div class="pet_more_list_block_line_font">趣闻</div>
                    </a>
                    <a class="pet_more_list_block_line">
                        <i class="iconfont pet_nav_kantuya pet_more_list_block_line_ico">&#xe62c;</i>
                        <div class="pet_more_list_block_line_font">阅读</div>
                    </a>
                    <a class="pet_more_list_block_line">
                        <i class="iconfont pet_nav_mengzhuanti pet_more_list_block_line_ico">&#xe622;</i>
                        <div class="pet_more_list_block_line_font">专题</div>
                    </a>
                    <a class="pet_more_list_block_line">
                        <i class="iconfont pet_nav_bk pet_more_list_block_line_ico">&#xe629;</i>
                        <div class="pet_more_list_block_line_font">订阅</div>
                    </a>
                    <a class="pet_more_list_block_line">
                        <i class="iconfont pet_nav_wd pet_more_list_block_line_ico">&#xe602;</i>
                        <div class="pet_more_list_block_line_font">专栏</div>
                    </a>
                    <div class="pet_more_list_block_name_title pet_more_list_block_line_height">服务 Service</div>
                    <a class="pet_more_list_block_line">
                        <i class="iconfont pet_nav_xinxianshi pet_more_list_block_line_ico">&#xe61e;</i>
                        <div class="pet_more_list_block_line_font">新鲜事</div>
                    </a>
                    <a class="pet_more_list_block_line">
                        <i class="iconfont pet_nav_zhangzhishi pet_more_list_block_line_ico">&#xe607;</i>
                        <div class="pet_more_list_block_line_font">趣闻</div>
                    </a>
                    <a class="pet_more_list_block_line">
                        <i class="iconfont pet_nav_kantuya pet_more_list_block_line_ico">&#xe62c;</i>
                        <div class="pet_more_list_block_line_font">阅读</div>
                    </a>
                    <a class="pet_more_list_block_line">
                        <i class="iconfont pet_nav_mengzhuanti pet_more_list_block_line_ico">&#xe622;</i>
                        <div class="pet_more_list_block_line_font">专题</div>
                    </a>
                    <a class="pet_more_list_block_line">
                        <i class="iconfont pet_nav_bk pet_more_list_block_line_ico">&#xe629;</i>
                        <div class="pet_more_list_block_line_font">订阅</div>
                    </a>
                    <a class="pet_more_list_block_line">
                        <i class="iconfont pet_nav_wd pet_more_list_block_line_ico">&#xe602;</i>
                        <div class="pet_more_list_block_line_font">专栏</div>
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
                            <li class="am-g am-list-item-desced pet_list_one_block" onclick="javascript:location.href='/subscribe/user/user_center?userId=${subscribeVo.userId}'">
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