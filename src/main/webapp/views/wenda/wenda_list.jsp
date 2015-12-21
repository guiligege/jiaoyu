<%-- 剥离出来的新的首页 --%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="shopel" uri="/WEB-INF/pagetag.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link type="image/x-icon" href="${pageContext.request.contextPath}/ico/licaime.ico" rel="shortcut icon">
		<title>理财经验_${biaoqian}_理财么</title>
		<meta name="keywords" content="${seoInfo}" />
		<meta name="description" content="理财么-获得理财经验的自助理财网站，您可以增长${biaoqian}相关的经验，您可以了解${biaoqian}相关问题的最新回复，评论理财问题，提升理财技巧，学习理财方法,${biaoqian}理财方法等信息." />
		<!-- 公共setting配置 -->
		<%@include file="/views/commons/config.jsp" %>
		<!--Javascript-->
		<jsp:include page="/views/commons/cssandscript.jsp"></jsp:include>
		<link rel="stylesheet" href="${domain_css}/css/licai/style.css?${version_css}" />
		
		<style>
		.feed-item {
padding: 10px 0;
position: relative;
margin-left: 0;
outline: 0;
}

.topic-pages .zu-top-feed-list .feed-item h2, .topic-feed-page .zu-top-feed-list .feed-item h2, .topic-top-page .zu-top-feed-list .feed-item h2, .topic-quesiton-page .zu-top-feed-list .feed-item h2 {
margin-bottom: 2px;
}
a:hover {
text-decoration: underline;
}

.feed-item .entry-body {
position: relative;
}
.feed-item .entry-body, .feed-item .zm-item-answer {
margin-top: 3px;
}
.entry-body .zm-item-vote, .zm-item-answer .zm-item-vote, .zm-item-feed .zm-item-vote, .zm-item-answer .zm-item-answer-summary {
display: block;
}
.feed-item .zm-item-vote {
margin-top: -1px;
}
.zm-item-vote {
display: none;
position: absolute;
left: -48px;
}
.zm-item-vote-count {
display: block;
color: #698ebf;
height: 24px;
line-height: 24px;
width: 38px;
border-radius: 3px;
border: 0;
cursor: pointer;
background: #eff6fa;
font-weight: 700;
font-weight: 500;
text-align: center;
text-decoration: none;
overflow: hidden;
-webkit-text-size-adjust: none;
}
.feed-item .zm-votebar {
display: none;
margin-top: -1px;
}
.zm-votebar {
float: left;
margin-left: -48px;
}
.zm-votebar .up {
height: 44px;
}
.zm-votebar .up, .zm-votebar .down {
display: block;
color: #698ebf;
height: 24px;
line-height: 24px;
width: 38px;
border-radius: 3px;
border: 0;
cursor: pointer;
background: #eff6fa;
font-weight: 700;
font-weight: 500;
position: relative;
}
.zm-votebar .down {
margin: 5px 0 0;
}
.zm-votebar .up .vote-arrow {
border-top-width: 0;
border-bottom-color: #698ebf;
border-top-style: solid;
background-position: 0 -229px;
}
.zm-votebar .vote-arrow {
width: 0;
height: 0;
border: 6px solid transparent;
font-size: 0;
_border-style: dashed;
background-image: none;
}

.feed-item .zm-item-vote-info, .feed-item .zm-item-answer-author-info {
margin-bottom: 2px;
}
.zm-item-answer-author-info a.collapse {
margin-left: 10px;
color: #999;
}
.meta-item {
color: #999;
}
.feed-item .comment i, .feed-item .collect i, .feed-item .share i, .feed-item .collapse i, .feed-item .follow i {
margin-right: 5px;
}
i[class^=z-icon-], i[class*=" z-icon-"] {
display: inline-block;
line-height: 10px;
vertical-align: 0;

background-repeat: no-repeat;
margin-right: 5px;
}
.z-icon-fold {
width: 8px;
height: 9px;
background-position: -135px -22px;
}
.hidden {
display: none;
}
body, input, textarea, select, button {
line-height: 1.7;
font-size: 13px;
padding: 0;
margin: 0;
color: #222;
word-wrap: break-word;
}
div[contentEditable], input, textarea, button, a:link {
-webkit-tap-highlight-color: rgba(225,225,225,.5);
}

.zh-summary {
-webkit-tap-highlight-color: rgba(225,225,225,.5);
position: relative;
cursor: pointer;
}
html.no-touch .zh-summary:hover a.toggle-expand {
text-decoration: none;
background-color: #eff6fa;
}
a.toggle-expand {
display: inline-block;
padding: 0 3px;
border-radius: 2px;
font-size: .9em;
color: #259;
}
.topic-pages .zm-topic-list-container .feed-item .entry-body, .topic-feed-page .zm-topic-list-container .feed-item .entry-body, .topic-top-page .zm-topic-list-container .feed-item .entry-body, .topic-quesiton-page .zm-topic-list-container .feed-item .entry-body {
margin-left: 48px;
}
h1, h2, h3, h4, h5 {
font-weight: 700;
font-size: 14px;
outline: 0;
margin: 0;
}
.entry-body .zm-item-answer-author-wrap {
margin: 0;
font-size: 13px;
line-height: 1.7;
}
textarea {
border: 0;
border: 0;
-moz-outline: 0;
outline: 0;
overflow: auto;
resize: none;
-webkit-appearance: none;
}
.topic-pages .zu-top-feed-list .feed-item .feed-meta, .topic-feed-page .zu-top-feed-list .feed-item .feed-meta, .topic-top-page .zu-top-feed-list .feed-item .feed-meta, .topic-quesiton-page .zu-top-feed-list .feed-item .feed-meta {
margin-left: 48px;
}
.navigable{
margin-left: 100px;
margin-right: 100px;
}
.feed-item .zm-item-meta {
margin-bottom: 0;
}
.zm-item-meta {
position: relative;
margin-bottom: 5px;
color: #999;
}
.zm-meta-panel {
padding: 5px 0;
margin-bottom: -5px;
}
.zm-item-meta .zm-meta-panel {
background: transparent;
}

.zm-meta-panel .zg-follow {
color: #999;
}
html.no-touch .zm-profile-answer-page .zm-item:hover .zu-autohide, html.no-touch .feed-item:hover .zu-autohide {
visibility: visible;
}
.meta-item+.meta-item {
margin-left: 7px;
}

.zm-item-meta .zm-meta-panel a.collapse {
visibility: visible;
}
.feed-item .collapse {
float: right;
}
.zm-meta-panel>a, .zm-meta-panel>span {
color: #999;
display: inline-block;
vertical-align: middle;
}
.feed-item{
border-top: 1px solid #EEE;
}
.question_link{
color: #259;
}
.zm-side-section {
margin-bottom: 15px;
position: relative;
}
.zm-side-section+.zm-side-section>.zm-side-section-inner {
padding: 15px 0 0;
border-top: 1px solid #eee;
}
.zm-side-section-inner h3 {
margin-bottom: 10px;
}
div[contentEditable], input, textarea, button, a:link {
-webkit-tap-highlight-color: rgba(225,225,225,.5);
}
.zm-item-tag, .zm-tag-editor-edit-item {
background: #eff6fa;
padding: 1px 10px 0;
border-radius: 30px;
text-decoration: none;
margin: 0 5px 5px 0;
display: inline-block;
float: left;
white-space: nowrap;
color: #259;
}
.zm-topic-side-title-link {
margin-left: 5px;
font-weight: 400;
display: inline-block;
}
.zg-link-litblue {
font-size: 12px;
color: #698ebf;
}
.guanggao{
border-top: 1px solid #EEE;
padding-top: 10px;
}
.answer-date-link-wrap{
display: inline-block;
}
 .active > a,  .active > a:hover,  .active > a:focus {
background-color: #0088CC;
color: #FFFFFF;
}
.border{
margin-top: 5px;
border-top: 1px solid #EEE;
}
		</style>
	</head>
	<body>
		<jsp:include page="/views/commons/licai_header_content.jsp"></jsp:include> 
		<div style="padding-bottom: 65px;"></div>
		<jsp:include page="wenda_common_list.jsp"></jsp:include>
		<jsp:include page="/views/commons/licai_footer.jsp"></jsp:include>
		<div class="none">
			<script type="text/javascript">
			var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
			document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3F19d3582fea421029f25811115d6cdf0e' type='text/javascript'%3E%3C/script%3E"));
			</script>
		</div>
		<!-- 百度广告开始 -->
		<!-- 百度广告结束-->
	</body>
	
</html>