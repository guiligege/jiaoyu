<%-- 剥离出来的新的首页 --%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="shopel" uri="/WEB-INF/pagetag.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
  	<meta http-equiv="content-type" content="text/html; charset=utf-8">
  	<link type="image/x-icon" href="${pageContext.request.contextPath}/ico/licaime.ico" rel="icon" />
  	<title>理财机构_${title}_理财么</title>
	<meta name="keywords" content="${seoInfo}" />
	<meta name="description" content="理财么-获得理财经验的自助理财网站，您可以了解${netLcCompany.companyName}相关问题的评价信息，最新回复，评论理财问题，提升理财技巧，学习理财方法,掌握${netLcCompany.companyName}最新动态等信息." />
	<%@include file="/views/commons/config.jsp" %>
	<%@include file="/views/commons/cssandscript.jsp" %>
  	<link rel="stylesheet" type="text/css" href="${domain_css}/css/licai/detail/detail.css?${version_css}">
  	<%-- <link rel="stylesheet" href="${domain_css}/css/licai/style.css?${version_css}" /> --%>
  	<script type="text/javascript" src="${domain_js}/js/licai/highcharts.js?${version_js}"></script>
  	<script type="text/javascript" src="${domain_js}/js/licai/modules/exporting.js?${version_js}"></script>
  	<script type="text/javascript">
  	function linkoutter(){
		var url=$("#outtertarget").attr("targeturl");
		//window.location.href=url;
		window.open(url);
	}
  	$(function () {
  		
  	//hover事件
  	  	$('.tab_meun li:first-Child').addClass("on");
  		$('.tab_meun li').hover(function(){
  			var index=$('.tab_meun li').index(this);
  			$(this).addClass('on').siblings().removeClass('on');		
  			$('.tab_content > div').eq(index).show().siblings().hide();		
  			});
  		$('.tab_meun2 li:first-Child').addClass("on");
  		$('.tab_meun2 li').click(function(){
  			var index=$('.tab_meun2 li').index(this);
  			$(this).addClass('on').siblings().removeClass('on');		
  			$('.tab_content2 > div').eq(index).show().siblings().hide();		
  			});
  	});
  	
	</script>
	<style>
	
	.details_box2 {
clear: both;
border: 1px solid #ccd3e4;
border-top: 2px solid #0088CC;
background: #fafbfc;
}
table {
border-collapse: collapse;
}
.details_box2 .info_tab .t1 {
width: 250px;
}
.info_tab tr td.t1 {
width: 175px;
text-align: center;
}
.info_tab tr td {
height: 188px;
}
.details_box2 a {
text-decoration: underline;
}
img {
border: none;
vertical-align: middle;
}
a {
font-family: "微软雅黑";
text-decoration: none;
color: #666;
font-size: 12px;
cursor: pointer;
}
.details_box2 .details_right {
float: left;
width: 600px;
}
.details_box2 .details_right h1 {
height: 31px;
font-size: 24px;
font-weight: bold;
color: #333;
padding: 15px 0 8px 0;
position: relative;
}
.details_box2 .details_right h1 .star_wp {
position: absolute;
top: 10px;
left: 300px;
color: #ccc;
font-size: 12px;
font-weight: normal;
font-family: "宋体";
}
.details_box2 .item li {
padding-left: 0;
}
.item li {
min-height: 39px;
line-height: 39px;
border-bottom: 1px solid #f2f2f2;
padding-left: 32px;
}
.item span.ic_1 {
width: 130px;
color: #0088CC;
}
.item span {
float: left;
min-height: 39px;
line-height: 39px;
font-family: 宋体;
}
.details_box2 .item span.ic_2 {
width: 230px;
}
.item span {
float: left;
min-height: 39px;
line-height: 39px;
font-family: 宋体;
}
.details_box .starbg, .infobox .starbg, .rank_p2p_1 .starbg, .search_list .starbg {
background-position: 0 -257px;
height: 16px;
width: 84px;
margin-top: 11px;
}
.fn_left {
float: left;
}
.sprites {
background: url(../../img/netlc/sprites.png);
display: inline-block;
}
.details_box .star, .infobox .star, .rank_p2p_1 .star, .starbg .star {
width: 16px;
height: 16px;
background-position: 0 -240px;
}
.details_box .star4, .infobox .star4, .rank_p2p_1 .star4, .starbg .star4 {
width: 67px;
}
.details_box .star3, .infobox .star3, .rank_p2p_1 .star3, .starbg .star3 {
width: 50px;
}
.details_box .star2, .infobox .star2, .rank_p2p_1 .star2, .starbg .star2 {
width: 33px;
}
.details_box .star1, .infobox .star1, .rank_p2p_1 .star1, .starbg .star1 {
width: 16px;
}
.details_box .star5, .infobox .star5, .rank_p2p_1 .star5, .starbg .star5 {
width: 84px;
}

.item {
width: 100%;
}
.item span.ic_1 {
width: 130px;
color: #0088CC;
}
.item span {
float: left;
min-height: 39px;
line-height: 39px;
font-family: 宋体;
}
.details_box2 .item span.ic_2 {
width: 230px;
}
.details_box2 a {
text-decoration: underline;
}
.details_box2 .item span.ic_1 {
width: 70px;
}
.details_box2 .item li {
padding-left: 0;
}

.details_box2 .item span.ic_1 {
width: 70px;
}
.item li:last-child {
border-bottom: 1px solid #fff;
}
.status_y {
display: inline-block;
width: 58px;
height: 20px;
line-height: 20px;
text-align: center;
color: #fff;
background: #0088CC;
margin-top: 10px;
}
em, i, b {
font-style: normal;
}


.infobox {
width: 390px;
}
.infobox, .infobox2 a {
color: #333;
}
.infobox, .infobox2 {
border: 1px solid #ccd3e4;
border-top: 0;
color: #333;
}
.info_tab tr th h4, .details_box h4 {
position: relative;
height: 36px;
line-height: 36px;
text-indent: 30px;
font-size: 18px;
color: #0088CC;
font-weight: bold;
background: #fafbfc;
text-align: left;
border-top: 1px solid #ccd3e4;
border-bottom: 1px solid #ccd3e4;
}
.info_tab tr td.t1 {
width: 175px;
text-align: center;
}
.info_tab tr td.t2 {
vertical-align: top;
font-size: 18px;
color: #333;
padding: 12px 10px 0 0;
}
.item li {
min-height: 39px;
line-height: 39px;
border-bottom: 1px solid #f2f2f2;
padding-left: 32px;
}
.important_pro li {
min-height: 49px;
line-height: 49px;
}
.item span.ic_1 {
width: 130px;
color: #0088CC;
}
.important_pro span {
min-height: 49px;
line-height: 49px;
font-family: 宋体;
}
.important_pro span.ic_2 {
width: 260px;
font-size: 18px;
font-family: 微软雅黑;
}
.important_pro .prompt {
margin-top: 16px;
}
.prompt {
width: 15px;
height: 15px;
display: inline-block;
float: left;
margin: 12px 0 0 7px;
cursor: pointer;
background-position: 0 -32px;
position: relative;
}
.prompt .tip_b {
border: 1px solid #ccc;
position: absolute;
top: 20px;
left: -126px;
line-height: 22px;
padding: 10px;
width: 240px;
display: none;
background: #fff;
z-index: 99;
}
.prompt .tip_b i {
width: 15px;
height: 15px;
position: absolute;
top: -7px;
left: 48%;
z-index: 150;
background-position: -30px -32px;
}
.yellow {
color: #FF6600;
}
.info_tab tr td.t_03 {
font-size: 18px;
color: #333;
vertical-align: top;
padding: 10px 10px 0 25px;
}

.fn_right {
float: right;
}
.fn_left {
float: left;
}
element.style {
}
table th {
border-top: 1px solid #DDDDDD;
line-height: 20px;
/* padding: 10px; */
text-align: left;
font-size: 12px;
}
table th, table tr:first-child {
border-top: none;
}
table td, table tr:first-child {
border-top: none;
}

		.mt10 {
margin-top: 10px;
}
.clearfix {
zoom: 1;
}
.tab-nav {
border: 1px solid #ccd3e4;
border-top: 2px solid #0088CC;
height: 36px;
line-height: 36px;
background: #f2f5f8;
}
.tab-nav ul {
position: relative;
height: 38px;
float: left;
top: -2px;
margin-bottom: -2px;
font-size: 14px;
color: #333333;
font-weight: bold;
}
.tab-nav ul li {
height: 38px;
line-height: 38px;
float: left;
border-top: 2px solid #0088CC;
text-align: center;
cursor: pointer;
}
.tab-nav2 ul li span {
padding: 0 20px;
color: #0088CC;
font-size: 18px;
}
.tab-nav ul li span {
border-right: 1px solid #ccd3e4;
height: 37px;
display: block;
float: left;
padding: 0 20px;
}
.tab_content02 {
border: 1px solid #ccd3e4;
border-top: 0;
}
.clearfix:after {
display: block;
visibility: hidden;
content: '.';
height: 0;
clear: both;
}
.item {
width: 100%;
}
.item span.ic_1 {
width: 130px;
color: #0088CC;
}
.item span {
float: left;
min-height: 39px;
line-height: 39px;
font-family: 宋体;
}
.item span.ic_2 {
width: 200px;
}
.hide {
display: none;
}
.tab_content02 .con {
line-height: 22px;
padding: 8px 30px 8px 32px;
font-family: 宋体;
}
.item span.ic_1 {
width: 130px;
color: #0088CC;
}
.infobox3 {
width: 100%;
overflow: hidden;
}
.tab-nav ul li.on {
border-top: 2px solid #f60;
}
.tab-nav2 ul li span {
padding: 0 20px;
color: #0088CC;
font-size: 18px;
}
.infobox3 .con {
font-size: 16px;
color: #333;
line-height: 30px;
border: 1px solid #ccd3e4;
border-top: 0;
padding: 10px 30px;
}

.left-one-title {
margin-left: 10px;
}

.title {
height: 28px;
line-height: 28px;
border: 1px solid #ccd3e4;
border-top: 2px solid #0055aa;
background: #f2f5f8;
text-indent: 20px;
font-size: 14px;
color: #0055aa;
font-weight: bold;
position: relative;
}
.new_comment_right .mc {
height: auto;
padding: 15px 20px 20px 20px;
border: 1px solid #ccd3e4;
border-top: 0;
overflow: hidden;
}
.new_comment_right .mc .rate {
width: 100%;
float: none;
text-align: center;
height: 47px;
}
.new_comment_right .mc p {
color: #999;
font-size: 14px;
font-family: 宋体;
line-height: 22px;
border-bottom: 1px solid #f2f2f2;
padding: 13px 0 13px 0;
margin-bottom: 15px;
}
.new_comment_right .mc p i {
color: #0055aa;
padding-right: 5px;
text-decoration: underline;
float: left;
margin-right: 15px;
cursor: pointer;
}
.new_comment_right p .btn {
width: auto;
padding: 0 12px;
height: 22px;
cursor: pointer;
font-family: '宋体';
font-size: 13px;
color: #000;
background-color:azure;
}
.new_comment_right .mc .percent {
float: none;
width: 100%;
border-right: 0;
}
.new_comment .mc .percent dl {
overflow: hidden;
padding: 5px 0;
line-height: 16px;
}
.new_comment_right .mc .percent dl dt {
width: 110px;
float: left;
font-family: "宋体";
font-size: 14px;
color: #666;
}
.new_comment .mc .percent dl dd {
width: 110px;
height: 16px;
background: #ccc;
float: left;
}
.new_comment .mc .percent dl dt span {
color: #999;
padding-left: 5px;
}

.new_comment .mc .percent dl dd div {
height: 16px;
background: #ff6600;
overflow: hidden;
}
.new_comment_right .mc .rate strong {
float: left;
}
.new_comment .mc .rate strong {
font-size: 36px;
color: #FF6600;
}
.new_comment .mc .rate span {
font-family: 宋体;
font-size: 14px;
color: #999;
}
.new_comment_right .mc .rate span {
display: inline-block;
float: left;
padding: 16px 0 0 18px;
line-height: 20px;
}

.dianpingfen h3{
position: relative;
height: 36px;
line-height: 36px;
text-indent: 30px;
font-size: 18px;
color: #0055aa;
font-weight: bold;
background: #fafbfc;
text-align: left;
border-top: 1px solid #ccd3e4;
border-bottom: 1px solid #ccd3e4;
}
.left-one-title h3{
height: 36px;
line-height: 36px;
text-indent: 30px;
font-size: 18px;
color: #0055aa;
font-weight: bold;
background: #fafbfc;
text-align: left;
border-top: 1px solid #ccd3e4;
border-bottom: 1px solid #ccd3e4;
}

.new_comment_right p .btn {
width: auto;
padding: 0 12px;
height: 22px;
cursor: pointer;
font-family: '宋体';
font-size: 13px;
color: #000;
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

.pagination-centered {
text-align: center;
}
.pagination ul {
border-radius: 4px;
box-shadow: 0 1px 2px rgba(0, 0, 0, 0.05);
display: inline-block;
margin-bottom: 0;
margin-left: 0;
}
.pagination ul > li {
display: inline;
}
.pagination ul > li:first-child > a, .pagination ul > li:first-child > span {
border-bottom-left-radius: 4px;
border-left-width: 1px;
border-top-left-radius: 4px;
}
.pagination ul > .active > a, .pagination ul > .active > span {
color: #999999;
cursor: default;
}
.pagination ul > li > a, .pagination ul > li > span {
-moz-border-bottom-colors: none;
-moz-border-left-colors: none;
-moz-border-right-colors: none;
-moz-border-top-colors: none;
background-color: #FFFFFF;
border-color: #DDDDDD;
border-image: none;
border-style: solid;
border-width: 1px 1px 1px 0;
float: left;
line-height: 20px;
padding: 4px 12px;
text-decoration: none;
}

	</style>
  </head>
  <body>
  <jsp:include page="/views/commons/licai_header_content.jsp"></jsp:include> 
		<div style="padding-bottom: 65px;"></div>
		<div class="none">
		<input type="text" id="userId" name="userId" value="${userId}">
		<input type="text" id="companyid" name="companyid" value="${netLcCompany.id}">
		</div>
        <div class="center">
          <div class="row-fluid">
            <div class="center-left" >
              <div class="left-one">
              	<div id="bdshare" style="float: right;margin-top: 5px;" class="bdshare_t bds_tools get-codes-bdshare" data="{'text':'理财么','url':'http://www.licaime.com/detail-1.htm','pic':'http://www.licaime.com/img/licai/licaime1.png'}">
			        <a class="bds_qzone"></a>
			        <a class="bds_tsina"></a>
			        <a class="bds_tqq"></a>
			        <!--<a class="bds_renren"></a> -->  
			        <span class="bds_more"></span>
			    </div>
                <div class="left-one-title">
                  <h3>互联网理财》${netLcCompany.companyName}</h3>
                </div>
              </div>
              <div class="left-five" style="padding-bottom:20px;">
            	<div class="clear"></div>        
	            <div class="details_box details_box2">
				<table width="100%" border="0" class="info_tab">				
				  <tbody><tr>
					<td class="t1"><a href="${netLcCompany.siteurl} " target="_blank" rel="nofollow"><img src="${fn:replace(netLcCompany.sitelogo, 'http://www.76676.com/uploadfile/p2plogo', 'http://www.licaime.com/p2p')}" alt="${netLcCompany.companyName}logo" title="${netLcCompany.companyName}官方网站"></a></td>
					<td>
						<div class="details_right">
							<h1>${netLcCompany.companyName}
							<ul class="item star_wp">
									<li style="border: none;">
										<span class="ic_1">人气</span>
										<span class="ic_2">
										<i class="fn_left sprites starbg">
										<c:if test="${netLcCompany.renQi !=null}">
										<b class="sprites star star${netLcCompany.renQi}"></b>
										</c:if>
										</i>
										</span>
									</li>
							</ul>
							</h1>
							<ul class="item">
								<li>
									<span class="ic_1">官网网址</span>
									<span class="ic_2"><a href="${netLcCompany.siteurl}" target="_blank" rel="nofollow">${netLcCompany.siteurl}</a></span>
									<span class="ic_1">运营公司</span>
									<span class="ic_2" title="${netLcCompany.runCompany}">
									<c:if test="${fn:length(netLcCompany.runCompany)>18}">
									${fn:substring(netLcCompany.runCompany, 0, 16)}..
									</c:if>
									<c:if test="${fn:length(netLcCompany.runCompany)<=18}">
									${netLcCompany.runCompany}
									</c:if>
									</span>
								</li>
								<li>
									<span class="ic_1">公司地址</span>
									<span class="ic_2" title="${netLcCompany.companyAddress}">
									<c:if test="${fn:length(netLcCompany.companyAddress)>18}">
									${fn:substring(netLcCompany.companyAddress, 0, 17)}..
									</c:if>
									<c:if test="${fn:length(netLcCompany.companyAddress)<=18}">
									${netLcCompany.companyAddress}
									</c:if>
									</span>
									<span class="ic_1">法人代表</span>
									<span class="ic_2">${netLcCompany.faRen}</span>
								</li>
								<li>
									<span class="ic_1">注册资金</span>
									<span class="ic_2">${netLcCompany.registerMoney}</span>
								</li>
								<li>								
									<span class="ic_1">邮件地址</span>
									<span class="ic_2">${netLcCompany.email}</span>
									<span class="ic_1">客服电话</span>
									<span class="ic_2">${netLcCompany.dianHua}</span>
								</li>
								<li style="border: none;">								
									<span class="ic_1">运营状态</span>
									<span class="ic_2">
										<i class="status_y">${netLcCompany.runState}</i>
									</span>
									<span class="ic_1">更新时间</span>
									<span class="ic_2"><fmt:formatDate value="${netLcCompany.updateTime}" pattern="yyyy年MM月dd日 "/></span>
								</li>
							</ul>
						</div>
					</td>
				  </tr>			
				</tbody></table>
			</div>
			<div class="clear"></div>
			<div class="infobox fn_left mt10">
				<table width="100%" border="0" class="info_tab">			
				  <tbody><tr>
					<th colspan="2" style="padding: 0px;"><h4>${netLcCompany.companyName}优点提示&nbsp;&nbsp;&nbsp;<img src="../../img/netlc/good.png" alt="${netLcCompany.companyName}优点"></h4></th>
				  </tr>			
				  <tr>
					<td class="t1"><img src="../../img/netlc/u460_normal.png" alt="${netLcCompany.companyName}优点"></td>
					<td class="t2">
						${netLcCompany.companyYoudian}
					</td>
				  </tr>			
				</tbody></table>
				<div class="details_box">
					<h4>${netLcCompany.companyName}重要信息</h4>
					<ul class="item important_pro" style="margin-bottom: 19px;">
						<li>
							<span class="ic_1">融资总量</span>
							<span class="ic_2">
								<i class="fn_left">${netLcCompany.jiaoyi}</i>
	                        </span>
						</li>
						<li>
							<span class="ic_1">利率范围</span>
							<span class="ic_2 yellow"><b>${netLcCompany.lilv}</b></span>
						</li>
						<li>
							<span class="ic_1">融资信息</span>
							<span class="ic_2">
							<c:if test="${netLcCompany.rongzi==1}">A轮</c:if>
							<c:if test="${netLcCompany.rongzi==0}">未融资</c:if>
							<c:if test="${netLcCompany.rongzi==2}">B轮</c:if>
							<c:if test="${netLcCompany.rongzi==3}">C轮</c:if>
							<c:if test="${netLcCompany.rongzi==4}">D轮</c:if>
							</span>
						</li>
						<li>
							<span class="ic_1">平台背景</span>
							<span class="ic_2">
							<c:if test="${netLcCompany.beijing==0}">民营</c:if>
							<c:if test="${netLcCompany.beijing==1}">国资</c:if>
							<c:if test="${netLcCompany.beijing==2}">银行</c:if>
							<c:if test="${netLcCompany.beijing==3}">上市公司</c:if>
							</span>
						</li>
					</ul>
				</div>	
			</div>
		
			<div class="infobox fn_right mt10">
				<table width="100%" border="0" class="info_tab">			
				  <tbody><tr>
					<th colspan="2" style="padding: 0px;"><h4>${netLcCompany.companyName}缺点提示&nbsp;&nbsp;&nbsp;<img src="../../img/netlc/bad.png" alt="${netLcCompany.companyName}缺点"></h4></th>
				  </tr>			
				  <tr>
					<td class="t1"><img src="../../img/netlc/u140_normal.png" alt="${netLcCompany.companyName}缺点"></td>
					<td class="t2">
					${netLcCompany.companyQuedian}
					</td>
				  </tr>			
				</tbody></table>
				<table width="100%" border="0" class="info_tab">			
				  <tbody><tr>
					<th colspan="2" style="padding: 0px;"><h4>${netLcCompany.companyName}逾期处理</h4></th>
				  </tr>			
				  <tr>
					<td colspan="2" class="t_03" style="border-top:0px;" title="${netLcCompany.yuqichuli}">
					${netLcCompany.yuqichuli}
					</td>
				  </tr>			
				</tbody></table>	
			</div>
			<div class="clear"></div>
			<hr class="dashed"></hr>
            <div class="left-five-info2" style="clear: both;">
            	“理财么”是一个自助理财平台，是一个中立的，致力于帮助广大网友买到更适合自己的理财产品，每天为网友们提供各大银行和金融机构的理财产品,并附上相应机构理财产品说明书，保证数据的真实有效性。理财么网站理财资讯信息绝大部分来自银行和金融结构，经过金融数据搜索并整理展现给大家，这是也是一个大家帮助大家的社区，大家分享理财经验让大家更好的理财，更安全的理财，获得更多的收益。
            </div>
            <c:if test="${companyFlag}">
            <hr class="dashed"></hr>
	        <div class="clearfix tab_meun tab-nav tab-nav2 mt10">
				<ul>
					<li class="on"><span>标的信息</span></li>
					<li class=""><span>安全保障</span></li>
					<li class=""><span>费用信息</span></li>
					<li class=""><span>债权转让</span></li>
					<li class=""><span>融资信息</span></li>
					<li class=""><span>其他信息</span></li>
					<li class=""><span>平台介绍</span></li>
				</ul>
			 </div>
			<div class="tab_content tab_content02 clearfix">
			<div class="" style="display: block;">
				<ul class="item">
					<li>
						<span class="ic_1">回款方式</span>
						<span class="ic_2" title="${netLcCompany.huikuanway}">${netLcCompany.huikuanway}</span>
						<span class="ic_1">标的类型</span>
						<span class="ic_2" title="${netLcCompany.touzitype}">${netLcCompany.touzitype}</span>
					</li>
					<li>
						<span class="ic_1">产品系列</span>
						<span class="ic_2" title="${netLcCompany.chanping}">
						<c:if test="${fn:length(netLcCompany.chanping)>16}">
						${fn:substring(netLcCompany.chanping, 0, 15)}..
						</c:if>
						<c:if test="${fn:length(netLcCompany.chanping)<=16}">
						${netLcCompany.chanping}
						</c:if>
						</span>
						<span class="ic_1">投资起点</span>
						<span class="ic_2">${netLcCompany.touziqidian}</span>
					</li>
					<li>
						<span class="ic_1">标的期限</span>
						<span class="ic_2">${netLcCompany.touzishijian}</span>
						<span class="ic_1">标的规模</span>
						<span class="ic_2">${netLcCompany.touziguimo}</span>
					</li>
					<li>
						<span class="ic_1">起息时间</span>
						<span class="ic_2">
							<i class="fn_left">${netLcCompany.qixishijian}</i>
						</span>
						<span class="ic_1">变现速度</span>
						<span class="ic_2">
							<i class="fn_left">${netLcCompany.bianxiansudu}</i>
						</span>
					</li>
				</ul>
			</div>
			<!--标的信息 end-->
			<div class="hide" style="display: none;">
				<ul class="item box_open">
					<li>
						<span class="ic_1">担保公司</span>
						<span class="ic_2" title="${netLcCompany.danbaoCompany}">${netLcCompany.danbaoCompany}</span>
						<span class="ic_1">风险保证金</span>
						<span class="ic_2">${netLcCompany.fengxianjin}</span>
					</li>
					<li>
						<span class="ic_1">自有风控团队</span>
						<span class="ic_2">${netLcCompany.fengkong}</span>
						<span class="ic_1">抵押物</span>
						<span class="ic_2">${netLcCompany.diya}</span>
					</li>
				</ul>
			</div>
			<!--安全保障 end-->
			<div class="hide" style="display: none;">
				<ul class="item box_open">
					<li>
						<span class="ic_1">充值费</span>
						<span class="ic_2">
							<i class="fn_left">${netLcCompany.chongzhifei}</i>
                            						</span>
						<span class="ic_1">提现费</span>
						<span class="ic_2">
							<i class="fn_left">${netLcCompany.tixianfei}</i>
                            						</span>
					</li>
					<li>
						<span class="ic_1">其他费用</span>
						<span class="ic_2">
							<i class="fn_left">${netLcCompany.qitafei}</i>
                            						</span>
					</li>
				</ul>
			</div>
			<!--费用信息 end-->
			<div class="hide" style="display: none;">
				<ul class="item box_open">
					<li>
						<span class="ic_1">转让功能</span>
						<span class="ic_2">${netLcCompany.zhuanrang}</span>
					</li>
					<li>
						<span class="ic_1">转让手续费</span>
						<span class="ic_2">
							<i class="fn_left">${netLcCompany.zhuanrangfei}</i>
						</span>
					</li>
				</ul>
			</div>
			<!--债权转让 end-->
			<div class="hide con" style="display: none;">
			${netLcCompany.rongziinfo}
			</div>
			<!--融资信息 end-->
			<div class="hide" style="display: none;">
				<ul class="item box_open">
					<li>
						<span class="ic_1">支付平台</span>
						<span class="">${netLcCompany.zhifuway}</span>
						
					</li>
					<li>
						<span class="ic_1">电子签章</span>
						<span class="ic_2">${netLcCompany.dianziqian}</span>
					</li>
				</ul>
			</div>
			<!--其他信息 end-->
			<div class="hide con" style="display: none;">
				${netLcCompany.companyInfo}
			</div>
			<!--平台介绍 end-->
			</div>
			<div class="infobox3 mt10">
				<div class="clearfix tab_meun tab-nav tab-nav2">
					<ul>
						<li class="on"><span>重要事件汇总</span></li>
						<li class=""><span>创始团队详情</span></li>
					</ul>
				</div>
				<div class="tab_content clearfix">
					<div class="con" style="display: block;">
					${netLcCompany.companyHistory}
					</div>
					<div class="con hide" style="display: none;">
					${netLcCompany.companytuandui}
					</div>
				</div>			
			</div>
            </c:if>
            <hr class="dashed"></hr>
            <h4>${netLcCompany.companyName}最新评论</h4>
            <!-- 评论 -->
            <div>
            <c:forEach var="product" items="${pingLunList}" varStatus="index">
			<div tabindex="-1" class="zm-item-answer " itemprop="topAnswer" itemscope="" itemtype="http://schema.org/Answer" data-aid="9284127" data-atoken="34740627" data-collapsed="0" data-created="1418005401" data-deleted="0" data-helpful="1" data-isowner="0">
				<a class="zg-anchor-hidden" name="answer-9284127"></a>
				<div class="zm-votebar">
					<input type="hidden" class="pinglunid" name="pinglunid" value="${product.id}">
					<button class="up" aria-pressed="false" title="赞同">
					<i class="icon vote-arrow"></i>
					<span class="label">赞同</span>
					<span class="count">${product.zan}</span>
					</button>
					<button class="down" aria-pressed="false" title="反对，不会显示你的姓名">
					<i class="icon vote-arrow"></i>
					<span class="label">反对，不会显示你的姓名</span>
					</button>
				</div>
				<div class="answer-head">
					<div class="zm-item-answer-author-info">
						<a href="javascript:;" name="collapse" class="collapse meta-item zg-right"><i class="z-icon-fold"></i>收起</a>
						<h3 class="zm-item-answer-author-wrap">${product.userName}</h3>
					</div>
				</div>
				<div class="zm-item-rich-text" data-resourceid="2931948" data-action="/answer/content">
					<div class=" zm-editable-content clearfix">
						${product.pinglun}
					</div>
				</div>
				<a class="zg-anchor-hidden ac" name="9284127-comment"></a>
				<div class="zm-item-meta zm-item-comment-el answer-actions clearfix">
					<div class="zm-meta-panel">
					<span class="answer-date-link-wrap">
					<a class="answer-date-link meta-item" style="color: #999;" target="_blank" href="${_contextPath}/companyPinglun-${product.id}.htm">发布于 <fmt:formatDate value="${product.createTime}" pattern="yyyy年MM月dd日 "/></a>
					</span>
					<span class="copyright zu-autohide"></span>
					</div>
				</div>
			</div>
			</c:forEach>
            </div>
            <c:if test="${!companyFlag}">
			<div class="zh-answers-title">
				<h3><a href="${_contextPath}/companydetail-${netLcCompany.id}.htm" class="zg-link-litblue">查看全部回答</a></h3>
			</div>
			</c:if>
			<c:if test="${companyFlag}">
				<jsp:include page="/views/commons/page.jsp"></jsp:include>
			</c:if>
			<!-- 评论 -->
			<div class="zm-editable-editor-wrap" style="">
				<div class="zh-answer-form clearfix">
					<div>
						<div class="zu-answer-form-title">
							<a href="javascript:void();" data-tip="p$b$xiao-zheng-dong" data-original_title="${userName}">${ userName}</a>
							<span>，挺牛</span>
						</div>
					</div>
				</div>
				<div class="zm-editable-editor-outer">
					<div class="zm-editable-editor-field-wrap">
						<textarea wrap="virtual" id="editable" class="zm-editable-editor-field-element editable"  style="border: 0px;width: 780px;">写回答(最多2500字)…</textarea>
					</div>
				</div>
				<div class="error-msg board">
				</div>
				<div class="zm-command clearfix">
					<span class="">
						<a class="submit-button zg-btn-blue" name="save" href="javascript:;">发布回答</a>
					</span>
				</div>
			</div>
          </div>
        </div>
     </div>
           <div class="center-right">
            <div class="dianpingfen"><h3>用户点评评级</h3></div>
            <div class="new_comment new_comment_right">
			<div class="title">${netLcCompany.companyName}口碑</div>
				<div class="mc">
					<div class="rate">
						<strong>46%</strong>
						<span>好评度</span>			
					</div>
					<p><i>52条评论</i><input type="button" class="btn" value="我也要点评"></p>
					<!-- <div class="percent">
						<dl>
							<dt>好评<span>（21%）</span></dt>
							<dd><div style="width:21%"></div></dd>
						</dl>
						<dl>
							<dt>中评<span>（50%）</span></dt>
							<dd><div style="width:50%"></div></dd>
						</dl>
						<dl>
							<dt>差评<span>（29%）</span></dt>
							<dd><div style="width:29%"></div></dd>
						</dl>
					</div>	 -->			
				</div>
			</div>
              <p>
                <i class="sign icon" style="margin-top:2px"></i>理财么提醒您：理财有风险，投资需谨慎 
              </p>
              <hr></hr>
           <div class="new_comment new_comment_right">
				<div class="title">${netLcCompany.companyName}最新理财产品</div>
				<div class="mc">
				</div>
			</div>
			
			<!-- 百度广告 -->
	   <div>
		<script type="text/javascript">
		    /*300*250 创建于 2014-07-29*/
		    var cpro_id = "u1636420";
		</script>
		<script src="http://cpro.baidustatic.com/cpro/ui/c.js" type="text/javascript"></script>
	    </div>
	    
	    <div>
	   <script type="text/javascript">
		var cpro_id="u2201364";
		(window["cproStyleApi"] = window["cproStyleApi"] || {})[cpro_id]={at:"3",rsi0:"300",rsi1:"250",pat:"6",tn:"baiduCustNativeAD",rss1:"#FFFFFF",conBW:"1",adp:"1",ptt:"0",titFF:"%E5%BE%AE%E8%BD%AF%E9%9B%85%E9%BB%91",titFS:"14",rss2:"#000000",titSU:"0",ptbg:"90",piw:"0",pih:"0",ptp:"0"}
		</script>
		<script src="http://cpro.baidustatic.com/cpro/ui/c.js" type="text/javascript"></script>
	    </div>
	    <div>
	    <script type="text/javascript">
		    /*300*250 创建于 2014-07-29*/
		    var cpro_id = "u1636443";
		</script>
		<script src="http://cpro.baidustatic.com/cpro/ui/c.js" type="text/javascript"></script>
	    </div> 
	    
           </div>
          </div>
        <!-- 百度统计 -->
       <!--  <div class="none">
			<script type="text/javascript">
			var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
			document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3F19d3582fea421029f25811115d6cdf0e' type='text/javascript'%3E%3C/script%3E"));
			</script>
		</div> -->
		<!-- 百度广告开始 -->
		<jsp:include page="/views/commons/licai_footer.jsp"></jsp:include>
		<!-- 百度广告开始 结束-->
		
		<script type="text/javascript">
		$(function () {
			$('.up').click(function(){
	  			var pinglunid=$(this).siblings(".pinglunid").val();
	  			var userId=$("#userId").val();
	  			if(userId==""){
	  				alert("请您先登录！");
	  				return false;
	  			}
	  			var obj=$(this);
	  			//异步加赞
	  			$.ajax({
	  				url:_contextPath+"/dianZan.htm",
	  				type:"get",
	  				data:{pinglunId:pinglunid,userId:userId},
	  				dataType:"json",
	  				async:false,
	  				success:function(data){
	  					if(data.code=='0'){
	  						//增加赞
	  			  			var count=obj.find(".count").html();
	  			  			obj.find(".count").html(parseInt(count)+1);
	  					}else{
	  						alert("您已经评论过哦！");
	  					}
	  				},
	  				error:function(data){
	  				}
	  			});
	  		});
	  		$('.down').click(function(){
	  			var pinglunid=$(this).siblings(".pinglunid").val();
	  			var userId=$("#userId").val();
	  			if(userId==""){
	  				alert("请您先登录！");
	  				return false;
	  			}
	  			var obj=$(this);
	  			//异步减赞
	  			$.ajax({
	  				url:_contextPath+"/xiaZan.htm",
	  				type:"get",
	  				data:{pinglunId:pinglunid,userId:userId},
	  				dataType:"json",
	  				async:false,
	  				success:function(data){
	  					if(data.code=='0'){
	  						//减少赞
	  			  			var count=obj.prev().find(".count").html();
	  			  			obj.prev().find(".count").html(parseInt(count)-1);
	  					}else{
	  						alert("您没有评论过哦！");
	  					}
	  				},
	  				error:function(data){
	  				}
	  			});
	  		});
	  		//移除提示文本
	  		$("#editable").focus(function(){
	  			$("#editable").val("");
	  			$(".error-msg").html("");
	  		});
			//提交评论
	  		$(".submit-button").click(function(){
	  			var userId=$("#userId").val();
	  			var companyId=$("#companyid").val();
	  			var pinglun=$("#editable").val();
	  			var pinglunType=0;
	  			var xingji=3;
	  			if(userId==''){
	  				alert("请您先登录再评论！");
	  				return false;
	  			}
	  			if(userId=='' ||companyId=='' ||pinglun==''){
	  				return false;
	  			}
	  			if(pinglun.length>2800){
	  				return false;
	  			}
	  			//评论替换
	  			pinglun=pinglun.replace(/\n/g,"<br/>");
	  		//异步加评论
	  			$.ajax({
	  				url:_contextPath+"/pinglun.htm",
	  				type:"post",
	  				data:{wentiId:companyId,pinglun:pinglun,pinglunType:pinglunType,userId:userId,xingji:xingji},
	  				dataType:"json",
	  				async:false,
	  				success:function(data){
	  					if(data.code=='0'){
	  						window.location.reload();
	  					}else{
	  						$(".error-msg").html(data.msg);
	  					}
	  				},
	  				error:function(data){
	  				}
	  			});
	  		});
			
		});
		
		</script>
  </body>
</html>