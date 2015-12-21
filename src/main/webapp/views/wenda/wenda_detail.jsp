<%-- 剥离出来的新的首页 --%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="shopel" uri="/WEB-INF/pagetag.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link type="image/x-icon" href="${pageContext.request.contextPath}/ico/licaime.ico" rel="shortcut icon">
		<title>${wenTi.wentiName}- 理财么</title>
		<!-- 公共setting配置 -->
		<%@include file="/views/commons/config.jsp" %>
		<!--Javascript-->
		<jsp:include page="/views/commons/cssandscript.jsp"></jsp:include>
		<link rel="stylesheet" href="${domain_css}/css/licai/style.css?${version_css}" />
		
		<style>
		.zm-tag-editor {
margin: 0 0 5px;
}
.zg-section {
display: block;
}
.zg-clear {
height: 1%;
}
.zg-clear:before, .zg-clear:after {
content: "\0020";
display: block;
height: 0;
visibility: hidden;
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
}
a {
text-decoration: none;
}
div[contentEditable], input, textarea, button, a:link {
-webkit-tap-highlight-color: rgba(225,225,225,.5);
}
.zu-edit-button {
color: #999;
display: inline-block;
font-size: 11px;
-webkit-text-size-adjust: none;
font-weight: 400;
padding: 0 5px 0 2px;
margin: 0 0 0 2px;
}
#zh-question-title {
margin: 0 0 5px;
}
#zh-question-title>.zm-item-title {
font-size: 18px;
}
#zh-question-title>.zm-item-title {
display: inline-block;
margin: 0;
}
.zu-edit-button {
color: #999;
display: inline-block;
font-size: 11px;
-webkit-text-size-adjust: none;
font-weight: 400;
padding: 0 5px 0 2px;
margin: 0 0 0 2px;
}
h1, h2, h3, h4, h5 {
font-weight: 700;
font-size: 14px;
outline: 0;
margin: 0;
}
h2 {
display: block;
font-size: 1.5em;
-webkit-margin-before: 0.83em;
-webkit-margin-after: 0.83em;
-webkit-margin-start: 0px;
-webkit-margin-end: 0px;
font-weight: bold;
}
body, input, textarea, select, button {
line-height: 1.7;
font-size: 13px;
padding: 0;
margin: 0;
color: #222;
word-wrap: break-word;
}
div {
display: block;
}
.zu-main-content-inner {
margin: 0 60px 0 0;
}
#zh-question-meta-wrap {
margin-bottom: 10px;
}
.zm-item-meta {
position: relative;
margin-bottom: 5px;
color: #999;
}
.zm-item-meta .zm-meta-panel {
background: transparent;
}
.zm-meta-panel {
padding: 5px 0;
margin-bottom: -5px;
background: transparent;
}
.zm-item-meta {
position: relative;
margin-bottom: 5px;
color: #999;
}
.zm-meta-panel>a, .zm-meta-panel>span {
color: #999;
display: inline-block;
vertical-align: middle;
}
div[contentEditable], input, textarea, button, a:link {
-webkit-tap-highlight-color: rgba(225,225,225,.5);
}
.goog-inline-block {
display: inline-block;
position: relative;
}
.zg-right {
float: right;
}
.meta-item+.meta-item {
margin-left: 7px;
}
.zm-meta-panel>a, .zm-meta-panel>span {
color: #999;
display: inline-block;
vertical-align: middle;
}
.zh-answers-title {
position: relative;
padding: 10px 0;
line-height: 24px;
border-top: 1px solid #EEE;
}
.clearfix:before, .clearfix:after {
display: table;
content: "";
}
.clearfix:after {
clear: both;
}
.clearfix:before, .clearfix:after {
display: table;
content: "";
}
.answers-sorter {
overflow: hidden;
height: 24px;
position: absolute;
right: -9px;
background: #fff;
}
.zh-answers-title {
position: relative;
padding: 10px 0;
line-height: 24px;
border-top: 1px solid #EEE;
}
.zh-answers-title h3 {
margin: 0;
display: inline;
}

.answers-sorter .lbl, .answers-sorter a.lbl {
padding: 0 19px 0 7px;
text-decoration: none;
display: block;
color: #999;
}
.answers-sorter .lbl, .answers-sorter a.lbl {
padding: 0 19px 0 7px;
text-decoration: none;
display: block;
color: #999;
}
.answers-sorter .zg-icon-double-arrow {
position: absolute;
top: 4px;
right: 3px;
}
.zg-icon-double-arrow {
background-position: -191px -229px;
width: 14px;
height: 14px;
}
#zh-question-collapsed-wrap, #zh-question-answer-wrap {
border-bottom: 1px solid #EEE;
}
#zh-question-collapsed-wrap>.zm-item-answer, #zh-question-answer-wrap>.zm-item-answer {
padding: 10px 0 5px;
}

.zu-main-content-inner.with-indention-votebar .zm-item-answer {
margin-left: 0;
}
.with-indention-votebar{
margin-left: 150px;
margin-right: 120px;
}
.zm-item-answer, .zm-item {
position: relative;
padding: 0;
outline: 0;
}
.zg-anchor-hidden {
top: -48px;
position: relative;
display: block;
width: 0;
font: 0/0 a;
}
a {
text-decoration: none;
}
.zm-item-expanded .zm-votebar, .zh-question-answer-wrapper .zm-votebar, .zh-question-answer-wrapper .zm-item-vote-info, .zm-item-expanded .zm-item-vote-info, .zm-item-expanded .zm-item-meta, .zm-item-expanded a.collapse, .zm-item-expanded .full-content {
display: block;
}
.zm-votebar {
display: block;
float: left;
margin-left: -48px;
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
.zm-votebar .up {
height: 44px;
}
.zm-votebar .up .vote-arrow {
background-position: 0 -229px;
}
.zm-votebar .up .vote-arrow {
border-top-width: 0;
border-bottom-color: #698ebf;
border-top-style: solid;
}
.zm-votebar .vote-arrow {
width: 0;
height: 0;
border: 6px solid transparent;
font-size: 0;
_border-style: dashed;
background-image: none;
}
i, em {
font-style: italic;
}
.zm-votebar .label {
display: block;
text-indent: -9999px;
}
.zm-votebar .count {
position: absolute;
top: 18px;
left: 0;
width: 100%;
}
span.count {
display: block;
color: #698ebf;
height: 27px;
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
.zm-votebar .down .vote-arrow {
background-position: -21px -229px;
}
.zm-votebar .down .vote-arrow {
border-bottom-width: 0;
border-top-color: #698ebf;
}
.zm-votebar .vote-arrow {
width: 0;
height: 0;
border: 6px solid transparent;
font-size: 0;
_border-style: dashed;
background-image: none;
}
.zm-votebar .label {
display: block;
text-indent: -9999px;
}
.zm-item-answer .answer-head {
min-height: 25px;
}
.zm-item-vote-info {
margin: 3px 0;
font-size: .9em;
color: #999;
}
.zm-item-answer-author-info a.collapse {
margin-left: 10px;
}
.zm-item-answer a.collapse {
display: none;
}
.meta-item {
color: #999;
}
.zg-right {
float: right;
}
.zm-item-answer-author-wrap {
margin: 0 0 1px;
font-size: 13px;
}
.zm-item-vote-info .voters {
display: inline;
}
.zm-item-vote-info {
margin: 3px 0;
font-size: .9em;
color: #999;
}
.zm-item-vote-info .voters span {
display: inline-block;

}
.zm-item-vote-info a {
color: inherit;
font-size: inherit;
}
.zg-link {
cursor: pointer;
text-decoration: none;
}
.zm-item-meta {
position: relative;
margin-bottom: 5px;
color: #999;
}
.zm-item-meta .zm-meta-panel {
background: transparent;
}
.zm-meta-panel {
padding: 5px 0;
margin-bottom: -5px;

}
.zm-meta-panel>a, .zm-meta-panel>span {
color: #999;
display: inline-block;
vertical-align: middle;
}
.meta-item+.meta-item {
margin-left: 7px;
}
.zm-meta-panel>a, .zm-meta-panel>span {
color: #999;
display: inline-block;
vertical-align: middle;
}
.answer-date-link{
color: #999;
}
h3 {
font-size: 18px;
line-height: 1.7;
color: #414141;
}
#zh-question-collapsed-wrap, #zh-question-answer-wrap {
border-bottom: 1px solid #EEE;
}
#zh-question-answer-wrap .zm-item-answer, .zm-item-answer+.zm-item-answer, .zm-item+.zm-item {
border-top: 1px solid #eee;
}
.zm-item-answer {
border-top: 1px solid #eee;
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
h1, h2, h3, h4, h5 {
font-weight: 700;
font-size: 14px;
outline: 0;
margin: 0;
}
.more-awesome {
color: #999;
font-size: 14px;
text-align: center;
border-bottom: 1px solid #eee;
margin-bottom: 15px;
margin-top: 15px;
}
.zh-answers-title {
position: relative;
padding: 10px 0;
line-height: 24px;
border-top: 1px solid #EEE;
}
.zh-answers-title h3 {
margin: 0;
display: inline;
}
.zh-answers-title h3 a {
font-size: 13px;
}
.zg-link-litblue, .zg-link-litblue-normal {
color: #698ebf;
font-weight: 400;
}

.submitbtn {
padding: 5px 16px;
height: 27px;
cursor: pointer;
-moz-border-radius: 3px;
-webkit-border-radius: 3px;
border-radius: 3px;
color: #fff;
background-color: #0e78e7;
border: 1px solid #528641;
}

.zh-answer-form {
margin-bottom: 10px;
}
.zm-editable-editor-wrap {
margin: 8px 0 5px;
position: relative;
}
.zu-answer-form-title {
font-weight: 700;
}
a {
color: #259;
text-decoration: none;
}
.zm-editable-editor-outer {
position: relative;
background: #FFF;
}
.zm-editable-editor-field-wrap {
position: relative;
padding: 8px 10px;
border: 1px solid #ccc;
border-radius: 0 0 3px 3px;
box-shadow: 0 0 4px 0 rgba(0,0,0,.1) inset;
-webkit-transition: min-height .25s ease-out;
background: #fff;
}
.editable {
min-height: 88px;
background: #fff;
font-size: 13px;
cursor: text;
}
.modal-dialog, div[contentEditable] {
outline: 0;
-moz-outline: 0;
}
.zm-command {
padding: 10px 0;
text-align: right;
}
.zh-question-answer-form-wrap .submit-button {
margin-left: 1em;
}
.zg-btn-blue {
background: #1472CF;
background-color: #1575d5;
background-image: -moz-linear-gradient(top,#1d7fe2,#0865c2);
background-image: -ms-linear-gradient(top,#1d7fe2,#0865c2);
background-image: -webkit-gradient(linear,0 0,0 100%,from(#1d7fe2),to(#0865c2));
background-image: -webkit-linear-gradient(top,#1d7fe2,#0865c2);
background-image: -o-linear-gradient(top,#1d7fe2,#0865c2);
background-image: linear-gradient(top,#1d7fe2,#0865c2);
background-repeat: repeat-x;
filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#1d7fe2', endColorstr='#0865c2', GradientType=0);
text-shadow: 0 -1px 0 rgba(0,0,0,.5);
border: 1px solid #0D6EB8;
color: #fff!important;
box-shadow: 0 1px 0 rgba(255,255,255,.2) inset,0 1px 0 rgba(0,0,0,.2);
}
.zg-btn-blue, .zg-btn-green, .zg-btn-red, .zg-btn-white, .zg-btn-disabled {
font-size: 14px;
line-height: 1.7;
text-decoration: none!important;
vertical-align: middle;
display: inline-block;
_display: inline!important;
text-align: center;
padding: 4px 10px;
cursor: pointer;
border-radius: 3px;
white-space: nowrap;
-webkit-box-sizing: border-box;
-moz-box-sizing: border-box;
-ms-box-sizing: border-box;
box-sizing: border-box;
}
.error-msg.board {
margin-bottom: 15px;
}
.error-msg {
color: red;
}

	</style>
	</head>
	<body>
		<jsp:include page="/views/commons/licai_header_content.jsp"></jsp:include> 
		<div style="padding-bottom: 65px;"></div>
		<jsp:include page="wenda_common_detail.jsp"></jsp:include>
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