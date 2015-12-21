<%-- 剥离出来的新的首页 --%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="shopel" uri="/WEB-INF/pagetag.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link type="image/x-icon" href="${pageContext.request.contextPath}/ico/licaime.ico" rel="shortcut icon" />
		<title>理财么-自助理财平台，发现，分享好的理财产品，分享理财经验，让财富增长从理财开始。</title>
		<title>理财么-自助理财-优质的理财产品</title>
		<meta name="keywords" content="理财么,自助理财,理财产品,理财产品排行榜,p2p理财产品排行,互联网理财产品排行榜" />
		<meta name="description" content="理财么-自助理财,理财产品列表页,我们为你提供尽可能准确的理财产品信息。" />
		<!-- 公共setting配置 -->
		<%@include file="/views/commons/config.jsp" %>
		<!--Javascript-->
		<jsp:include page="/views/commons/cssandscript.jsp"></jsp:include>
		<link rel="stylesheet" href="${domain_css}/css/licai/style.css?${version_css}" />
		<style>
		.project-summary-items li .title{
			display: inline-block;
			width: 77px;
		}
		.important {
			color: #E86E00;
			font-size: 17px;
			font-weight: 500;
			margin-left: 25px;
		}
		</style>
	</head>
	<body>
		<jsp:include page="/views/commons/licai_header_content.jsp"></jsp:include> 
		<div style="padding-bottom: 65px;"></div>
		<jsp:include page="netlc_product_common_list.jsp"></jsp:include>
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