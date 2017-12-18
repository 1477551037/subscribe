<!doctype html>
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0" />
		<meta name="keywords" content="" />
		<meta name="description" content="" />
		<link rel="stylesheet" href="/subscribe/css/amazeui.min.css">
		<link rel="stylesheet" href="/subscribe/css/wap.css">
		<title></title>
	</head>
	<body style="background:#ececec">
		<div class="pet_mian">
			<div class="pet_head">
				<header data-am-widget="header" class="am-header am-header-default pet_head_block">
					<div class="am-header-left am-header-nav ">
						<a href="#" onclick="javascript:history.back(-1);" class="iconfont pet_head_jt_ico">&#xe601;</a>
					</div>
					<div class="pet_news_list_tag_name">${userVO.nickName!""}</div>
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

							<a class="pet_more_list_block_line"> <i class="iconfont pet_nav_xinxianshi pet_more_list_block_line_ico">&#xe61e;</i>
								<div class="pet_more_list_block_line_font">新鲜事</div>
							</a>
							<a class="pet_more_list_block_line"> <i class="iconfont pet_nav_zhangzhishi pet_more_list_block_line_ico">&#xe607;</i>
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
                            <div class="pet_more_list_block_name_title">联系我WeChar：Lhl1477551037</div>
						</div>
					</div>

				</div>
			</div>

			<div class="pet_content pet_content_list">
				<div class="pet_grzx">

					<div class="pet_grzx_nr">
						<div class="pet_grzx_ico">
							<img src="${userVO.headImage!"/subscribe/img/qq1.png"}" alt="">
						</div>
						<div class="pet_grzx_name">${userVO.nickName!""}</div>
						<div class="pet_grzx_map">${userVO.region!""}</div>

						<#if userVO.followFlag == 1>
                            <h3 class="am-list-item-hd pet_list_one_bt" style="text-align: center"><a onclick="sendGet('/subscribe/subscribe/cancelFollow?fensId=${userVO.id}',this)" href="javascript:void(0);" class="">取消关注</a></h3>
						<#elseif userVO.followFlag == 2>
                            <h3 class="am-list-item-hd pet_list_one_bt" style="text-align: center"><a onclick="sendGet('/subscribe/subscribe/follow?fensId=${userVO.id}',this)" href="javascript:void(0);" class="">+&nbsp;关注</a></h3>
						<#else>
						</#if>

						<div class="pet_grzx_num" style="text-align: center">
						${userVO.description!""}
						</div>
						<div class="pet_grzx_num">
							<span>${userVO.userTotal!"0"}<i><a href="/subscribe/subscribe/followList?userId=${userVO.id}">关注</a></i></span>
							<span>${userVO.fensTotal!"0"}<i><a href="/subscribe/subscribe/fensList?userId=${userVO.id}">粉丝</a></i></span>
							<span>${userVO.articleTotal!"0"}<i><a href="javascript:void()">文章</a></i></span>
						</div>

					</div>

					<div class="pet_grzx_list">
						<div class="pet_content_main pet_article_like_delete">
							<div data-am-widget="list_news" class="am-list-news am-list-news-default am-no-layout">
								<div class="am-list-news-bd">
									<ul class="am-list">
										<!--缩略图在标题右边-->
										<#if userVO.article??>
										<#list userVO.article as article>
											<li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-right pet_list_one_block">

												<div class=" am-u-sm-8 am-list-main pet_list_one_nr">
													<h3 class="am-list-item-hd pet_list_one_bt"><a href="###" class="">${article.title}</a></h3>
													<div class="am-list-item-text pet_list_one_text">${article.description}</div>

												</div>
												<div class="am-u-sm-4 am-list-thumb">
													<a href="###" class="">
														<img src="${article.photo!"/subscribe/img/q1.jpg"}" class="pet_list_one_img" alt="" />
													</a>
												</div>
											</li>
										</#list>
										<#else >
                                            <li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-right pet_list_one_block">

                                                <div class=" am-u-sm-8 am-list-main pet_list_one_nr">
                                                    <div class="am-list-item-text pet_list_one_text">该用户还没有发表过文章</div>
                                                </div>
                                            </li>
										</#if>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<script src="/subscribe/js/jquery.min.js"></script>
		<script src="/subscribe/js/amazeui.min.js"></script>
		<script src="/subscribe/js/my.js"></script>

		<#--myScript index-->

		<#--myScript end-->

		<script>
			$(function() {

				// 动态计算新闻列表文字样式
				auto_resize();
				$(window).resize(function() {
					auto_resize();
				});
				$('.am-list-thumb img').load(function() {
					auto_resize();
				});
				$('.pet_article_like li:last-child').css('border', 'none');

				function auto_resize() {
					$('.pet_list_one_nr').height($('.pet_list_one_img').height());
					// alert($('.pet_list_one_nr').height());
				}
				$('.pet_article_user').on('click', function() {
					if($('.pet_article_user_info_tab').hasClass('pet_article_user_info_tab_show')) {
						$('.pet_article_user_info_tab').removeClass('pet_article_user_info_tab_show').addClass('pet_article_user_info_tab_cloes');
					} else {
						$('.pet_article_user_info_tab').removeClass('pet_article_user_info_tab_cloes').addClass('pet_article_user_info_tab_show');
					}
				});

				$('.pet_head_gd_ico').on('click', function() {
					$('.pet_more_list').addClass('pet_more_list_show');
				});
				$('.pet_more_close').on('click', function() {
					$('.pet_more_list').removeClass('pet_more_list_show');
				});
			});
		</script>
	</body>

</html>