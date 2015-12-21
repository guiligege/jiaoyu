<%-- 剥离出来的新的首页 --%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="shopel" uri="/WEB-INF/pagetag.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link type="image/x-icon" href="${pageContext.request.contextPath}/ico/licaime.ico" rel="shortcut icon">
		<title>${weiXinArticle.title}--${weiXinHao.name}--${weiXinHao.name}微信公众号 -- 微精选</title>
		<meta name="keywords" content="${weiXinHao.name},${weiXinHao.name}微信公众号，${weiXinHao.name}微信" />
		<meta name="description" content="${weiXinArticle.description}-${weiXinHao.name}" />
		<!-- 公共setting配置 -->
		<%@include file="/views/commons/config.jsp" %>
		<!--Javascript-->
		<jsp:include page="/views/commons/cssandscript.jsp"></jsp:include>
		<link href="${domain_css}/css/weixin/inspector.css" rel="stylesheet" type="text/css">
		<link href="${domain_css}/css/weixin/main.css" rel="stylesheet" type="text/css">
		<link href="${domain_css}/css/weixin/base.css" rel="stylesheet" type="text/css">
		<link rel="stylesheet" type="text/css" href="${domain_css}/css/weixin/article_improve.css"/>
		<link media="screen and (min-width:1023px)" rel="stylesheet" type="text/css" href="${domain_css}/css/weixin/article_pc.css"/>
		<style>ol,ul{list-style-position:inside;}</style>
	</head>
<body>
<jsp:include page="/views/commons/weixin_header_content.jsp"></jsp:include>

<div class="home_page contents content">
<div class="row">
<div class="main e_col main_col" style="width: 625px;">

<div class="rich_media" id="js_article">

<%-- <jsp:include page="/views/html/${weiXinHao.weixin_id}/${titlehash}.jsp"></jsp:include> --%>
<jsp:include page="/views/html/weixin/detail/${weiXinHao.weixin_id}/${titlehash}.jsp"></jsp:include>
<%-- <c:import url="http://www.licaime.com/weixinspider/detail/qqygpy/929671237.jsp" var="thisPage"/>
<c:out value="${thisPage}"/>
 --%>
</div>
</div>
<div class="side e_col side_col w2" style="margin-top: 10px;">
<!-- <div class="row section section_top" style="margin-bottom: 5px">
<a style="padding: 6px" class="download-ios" href="https://itunes.apple.com/cn/app/chuan-song-men-wei-xin-gong/id969898148?ls=1&amp;mt=8" target="_blank">传送门 for iOS 下载</a>
</div> -->
<div class="section">
<div id="ld_E6G600_286">
<h3>关于 ${weiXinArticle.hao_name}</h3>
<div class="inline_editor_content">
<span class="inline_editor_value">
<div class="inline">
<span>${weiXinHao.description }</span>
</div>
</span>
</div>
</div>
</div>
<div class="section">
<div id="ld_E6G600_286">
<h3>${weiXinArticle.hao_name} 微信二维码</h3>
<div class="inline_editor_content">
<span class="inline_editor_value">
<div class="inline">
<!-- <img width="210px" height="210px" src="http://q.chuansong.me/thepoemforyou.jpg" alt="为你读诗 微信二维码"> -->
<img width="260px" height="260px" src="${_contextPath}/weixin/ma/${weiXinHao.ma}.jpg" alt="${weiXinHao.name }微信二维码">
</div>
</span>
</div>
</div>
</div>
<div class="section share_question ">
<h3>分享这篇文章</h3>
<div class="row share_icons_row">
<div class="share fr">
<a class="weixin" href="javascript:;" data-id="weixin" title="分享到微信"></a>
<a class="tsina" href="javascript:;" data-id="tsina" title="分享到新浪微博"></a>
<a class="qzone" href="javascript:;" data-id="qzone" title="分享到QQ空间"></a>
<a class="tqq" href="javascript:;" data-id="tqq" title="分享到腾讯微博"></a>
<a class="douban" href="javascript:;" data-id="douban" title="分享到豆瓣"></a>
<a class="twitter" href="javascript:;" data-id="twitter" title="分享到Twitter"></a>
</div>
</div>
</div>
</div>
</div>
</div>

<!-- footer -->
<jsp:include page="/views/commons/weixin_footer.jsp"></jsp:include> 

</body>
<%-- <script language="javascript" src="${domain_css}/css/weixin/static/js/common.js"></script>
<script language="javascript" src="/static/js/reimg.js"></script>  --%>
</html>
