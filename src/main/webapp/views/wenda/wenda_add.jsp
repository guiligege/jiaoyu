<%-- 剥离出来的新的首页 --%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="shopel" uri="/WEB-INF/pagetag.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link type="image/x-icon" href="${pageContext.request.contextPath}/ico/licaime.ico" rel="shortcut icon">
		<title>提问- 理财么</title>
		<meta name="keywords" content="理财经验,理财知识,理财技巧,个人理财,理财入门" />
		<meta name="description" content="理财么是一个客观，中立的致力于帮助广大网友买到更安全的，更适合自己的理财产品的网站，值得您每天关注。我们每天会提供各大理财网站和银行优质的理财产品信息，另外还有大量网友踊跃参与理财经验的分享和评论。如果您有相关理财经验，也可通过我们与更多网友分享。" />
		<!-- 公共setting配置 -->
		<%@include file="/views/commons/config.jsp" %>
		<!--Javascript-->
		<jsp:include page="/views/commons/cssandscript.jsp"></jsp:include>
		<link rel="stylesheet" href="${domain_css}/css/licai/style.css?${version_css}" />
		
		<style>
		.row {
overflow: hidden;
margin-bottom: 20px;
}
.row.note-title label.field, .row.note-text label.field, .row.note-tags label.field {
font-size: 14px;
}
label {
font-family: Tahoma;
vertical-align: middle;
}
#note_title {
font-size: 14px;
}
#note_title, #note_text {
width: 582px;
margin-top: 5px;
padding: 3px;
border: 1px solid #ccc;
line-height: 1.62;
display: inherit;
}
.row.note-title label.field, .row.note-text label.field, .row.note-tags label.field {
font-size: 14px;
}
#form_note textarea {
font-size: 13px;
line-height: 1.62;
height: 200px;
resize: vertical;
font-family: Arial;
overflow: auto;
width: 582px;
margin-top: 5px;
padding: 3px;
border: 1px solid #ccc;
}
.douban-tag-editor {
margin-top: 5px;
}
div.tag input, .tag-editor, .tag-editor .placeholder, .tag-editor-mirror, .tag-console, .tag-panels {
font-size: 13px;
font-family: Helvetica,Arial,sans-serif;
}
.row.note-tags{
width: 588px;
}
.tag-editor {
padding: 6px;
border: 1px solid #ccc;
cursor: text;
}
.douban-tag-editor .placeholder {
border: 0;
}
.tag-editor .placeholder {
padding: 1px 13px 1px 9px;
color: #777;
line-height: 24px;
}
.tag-console {
color: #f00;
margin-top: 6px;
-webkit-transition: opacity 1s;
-moz-transition: opacity 1s;
transition: opacity 1s;
opacity: 0;
height: 0;
}
.tag-panels {
line-height: 28px;
position: relative;
}
.tag-panel dt {
color: #ccc;
float: left;
padding-right: .4em;
}
.tag-panels dl, .tag-panels dt, .tag-panels dd {
margin: 0;
padding: 0;
}
.tag-panel dd {
overflow: hidden;
}
a.tag {
color: #37a;
cursor: pointer;
margin-right: .8em;
white-space: nowrap;
display: inline-block;
line-height: 1.2;
}

.row.footer {
margin-top: 25px;
width: 588px;
position: relative;
zoom: 1;
}
.error-msg.board {
margin-bottom: 15px;
}
.error-msg {
color: red;
}
.lnk-flat, .lnk-confirm, .bn-flat {
display: -moz-inline-box;
display: inline-block;
border-width: 1px;
border-style: solid;
border-color: #bbb #bbb #999;
color: #444;
border-radius: 3px;
-moz-border-radius: 3px;
-webkit-border-radius: 3px;
overflow: hidden;
vertical-align: middle;
}
.lnk-flat, .lnk-confirm, .bn-flat input {
border: 0;
height: 25px;
padding: 0 14px;
color: #333;
background: transparent url(/f/shire/05e11739c2d942b85cfa521685bfb9ca028c9e42/pics/site/sp_all_2.png) repeat-x 0 -700px\9;
font-size: 12px;
margin: 0!important;
cursor: pointer;
-webkit-appearance: none;
border-radius: 2px;
-moz-border-radius: 2px;
-webkit-border-radius: 2px;
background-image: -moz-linear-gradient(-90deg,#fcfcfc 0,#e9e9e9 100%);
background-image: -webkit-gradient(linear,left top,left bottom,color-stop(0,#fcfcfc),color-stop(1,#e9e9e9));
}
.lnk-flat, .lnk-confirm, .bn-flat {
display: -moz-inline-box;
display: inline-block;
border-width: 1px;
border-style: solid;
border-color: #bbb #bbb #999;
color: #444;
border-radius: 3px;
-moz-border-radius: 3px;
-webkit-border-radius: 3px;
overflow: hidden;
vertical-align: middle;
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
input {
margin-right: 3px;
vertical-align: middle;
}
.row.footer .cancel-note {
position: absolute;
bottom: 0;
right: 0;
}

.container{
width: 1170px;
margin: 0 auto;
margin-left: 275px;
}
div.tag {
display: inline-block;
margin-right: .3em;
position: relative;
}
div.tag input, .tag-editor, .tag-editor .placeholder, .tag-editor-mirror, .tag-console, .tag-panels {
font-size: 13px;
font-family: Helvetica,Arial,sans-serif;
}
div.tag input {
margin: 0;
padding: 0;
border: 0;
color: #aaa;
background-color: #ebebeb;
padding: 1px 13px 1px 9px;
min-width: 1em;
line-height: 24px;
height: 24px;
vertical-align: middle;
}
div.tag a {
position: absolute;
top: -2px;
right: 2px;
cursor: pointer;
color: #aaa;
line-height: 1;
font-size: 16px;
}
		</style>
	</head>
	<body>
		<jsp:include page="/views/commons/licai_header_content.jsp"></jsp:include> 
		<div style="padding-bottom: 65px;"></div>
		<jsp:include page="wenda_common_add.jsp"></jsp:include>
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