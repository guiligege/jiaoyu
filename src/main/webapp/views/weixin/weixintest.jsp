<%-- 剥离出来的新的首页 --%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="shopel" uri="/WEB-INF/pagetag.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link type="image/x-icon" href="${pageContext.request.contextPath}/ico/licaime.ico" rel="shortcut icon">
		<title>蔬食课堂｜莲子：安神志、治脾虚，家中必备养生食材（附4道食谱，有甜有咸有汤水） -- 素食星球 -- 传送门</title>
		<meta name="keywords" content="蔬食课堂｜莲子：安神志、治脾虚，家中必备养生食材（附4道食谱，有甜有咸有汤水）,素食星球,传送门" />
		<meta name="description" content="8月是荷花盛开的季节，莲子应季出产。前两周采访谢一源老师时，他介绍到莲子是家中需要常备的食材之一，营养丰" />
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
<jsp:include page="/views/html/1.jsp"></jsp:include>
<!-- footer -->
	<jsp:include page="/views/commons/weixin_footer.jsp"></jsp:include> 

</body>
<%-- <script language="javascript" src="${domain_css}/css/weixin/static/js/common.js"></script>
<script language="javascript" src="/static/js/reimg.js"></script>  --%>
<script type="text/javascript" src="${domain_js}/js/weixin/common.js?${version_js}"></script>
<script type="text/javascript" src="${domain_js}/js/weixin/reimg.js?${version_js}"></script>
</html>
