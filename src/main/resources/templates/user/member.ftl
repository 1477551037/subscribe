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
					<div class="pet_news_list_tag_name">${userDTO.nickName!""}</div>
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
				<div class="pet_grzx">

					<div class="pet_grzx_nr">
						<div class="pet_grzx_ico">
							<img src="${userDTO.headImage!"/subscribe/img/qq1.png"}" alt="">
						</div>
						<div class="pet_grzx_name">${userDTO.nickName!""}</div>
						<div class="pet_grzx_map">${userDTO.region!""}</div>

						<#if followFlag == 1>
                            <h3 class="am-list-item-hd pet_list_one_bt" style="text-align: center"><a onclick="sendGet('/subscribe/subscribe/cancelFollow?fensId=${userDTO.id}',this)" href="javascript:void(0);" class="">取消关注</a></h3>
						<#elseif followFlag == 2>
                            <h3 class="am-list-item-hd pet_list_one_bt" style="text-align: center"><a onclick="sendGet('/subscribe/subscribe/follow?fensId=${userDTO.id}',this)" href="javascript:void(0);" class="">+&nbsp;关注</a></h3>
						<#else>
						</#if>

						<div class="pet_grzx_num" style="text-align: center">
						${userDTO.description!""}
						</div>
						<div class="pet_grzx_num">
							<span>${userTotal!"0"}<i><a href="/subscribe/subscribe/followList?userId=${userDTO.id}">关注</a></i></span>
							<span>${fensTotal!"0"}<i><a href="/subscribe/subscribe/fensList?userId=${userDTO.id}">粉丝</a></i></span>
							<span>34<i>文章</i></span>
						</div>

					</div>

					<div class="pet_grzx_list">
						<div class="pet_content_main pet_article_like_delete">
							<div data-am-widget="list_news" class="am-list-news am-list-news-default am-no-layout">
								<div class="am-list-news-bd">
									<ul class="am-list">
										<!--缩略图在标题右边-->
										<li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-right pet_list_one_block">

											<div class=" am-u-sm-8 am-list-main pet_list_one_nr">
												<h3 class="am-list-item-hd pet_list_one_bt"><a href="###" class="">十一长假哪也不去，宅在家里看电影！</a></h3>
												<div class="am-list-item-text pet_list_one_text">每逢长假，总有那么一群人选择远离人山人海，静静地呆在家，坐在电脑电视前。长时间的工作学习让他们感觉很疲惫，对什么都提不起劲，打开电脑却不知道干什么好…</div>

											</div>
											<div class="am-u-sm-4 am-list-thumb">
												<a href="###" class="">
													<img src="/subscribe/img/q1.jpg" class="pet_list_one_img" alt="" />
												</a>
											</div>
										</li>
										<li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-right pet_list_one_block">

											<div class=" am-u-sm-8 am-list-main pet_list_one_nr">
												<h3 class="am-list-item-hd pet_list_one_bt"><a href="###" class="">不是说好做彼此的天使吗？连最后一口汉堡也不给我</a></h3>
												<div class="am-list-item-text pet_list_one_text">国外网友waxiestapple在论坛Reddit贴出爱犬照片，指出“我的狗狗好像瘦了点”“因为我刚刚把最后一口汉堡吃掉”，只见这只哈士奇一脸惨遭背叛的样子，对主人露出相当不可思议的表情。</div>

											</div>
											<div class="am-u-sm-4 am-list-thumb pet_video_info">
												<div class="pet_video_info_tag"><i class="iconfont">&#xe62d;</i>03:50</div>
												<a href="###" class="">
													<img src="/subscribe/img/q4.jpg" class="pet_list_one_img" alt="我很囧，你保重....晒晒旅行中的那些囧！" />
												</a>
											</div>
										</li>
										<li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-right pet_list_one_block">

											<div class=" am-u-sm-8 am-list-main pet_list_one_nr">
												<h3 class="am-list-item-hd pet_list_one_bt"><a href="###" class="">怦然心动！澳洲大眼宝宝逆天睫毛萌翻全球！</a></h3>
												<div class="am-list-item-text pet_list_one_text">来自澳大利亚布里斯班的十个月大的萌宝Egypt拥有一双修长的睫毛、清澈的眼眸，可爱的模样让她在社交网站上爆红。</div>

											</div>
											<div class="am-u-sm-4 am-list-thumb">
												<a href="###" class="">
													<img src="/subscribe/img/q5.jpg" class="pet_list_one_img" alt="我很囧，你保重....晒晒旅行中的那些囧！" />
												</a>
											</div>
										</li>

										<li class="am-g am-list-item-desced pet_list_one_block">

											<div class=" am-list-main">
												<h3 class="am-list-item-hd pet_list_one_bt"><a href="###" class="">浣熊孤儿掉到树下，被一家人收养之后……</a></h3>
												<ul data-am-widget="gallery" class="am-gallery am-avg-sm-3
  am-avg-md-3 am-avg-lg-3 am-gallery-default pet_list_one_list">
													<li>
														<div class="am-gallery-item">
															<a href="###" class="">
																<img src="/subscribe/img/qq1.jpg" alt="某天 也许会相遇 相遇在这个好地方" />
															</a>
														</div>
													</li>
													<li>
														<div class="am-gallery-item">
															<a href="###" class="">
																<img src="/subscribe/img/qq2.jpg" alt="不要太担心 只因为我相信" />
															</a>
														</div>
													</li>
													<li>
														<div class="am-gallery-item">
															<a href="###" class="">
																<img src="/subscribe/img/qq3.jpg" alt="终会走过这条遥远的道路" />
															</a>
														</div>
													</li>
									</ul>
									<div class="am-list-item-text pet_list_two_text">巴哈马拿骚的居民Rosie Kemp发现一个刚出生的浣熊，掉在了树下。因为找不到小浣熊的妈妈了，Rosie和她的女儿Laura Young决定收养这只小东西，并给她取名“小南瓜”。</div>
									</div>
									</li>
									<li class="am-g am-list-item-desced pet_list_one_block" style="border-bottom:none">
										<div class=" am-list-main">
											<h3 class="am-list-item-hd pet_list_one_bt"><a href="###" class="">“你的旅行，是什么颜色？” 晒照片，换北欧梦幻极光之旅！</a></h3>

											<div class="am-list-item-text pet_list_two_text">狗狗会天天的跟着我们生活在一起，它们的一切都会影响着主人，尤其是狗狗身上散发的味道，会无时无刻的对主人有影响，如果狗狗身体有异味，主人就会用过于香喷喷的洗漱品帮狗狗洗澡，这样不仅对狗狗身体有伤害，还会容易患上皮肤病，其实，我们知道一些小技巧，就会改善狗狗身上存在的味道。</div>

										</div>
									</li>
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
		<<script>
            $.notification({
                title: "通知",
                text: "点击头像即可修改资料",
                media: "<img src='${headImage!""}'>",
            });
		</script>
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