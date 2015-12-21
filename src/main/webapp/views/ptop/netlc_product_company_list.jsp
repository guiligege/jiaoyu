<%-- 剥离出来的新的首页 --%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="shopel" uri="/WEB-INF/pagetag.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link type="image/x-icon" href="${pageContext.request.contextPath}/ico/licaime.ico" rel="shortcut icon" />
		<title>理财机构_理财平台_p2p理财论坛_理财经验_理财么</title>
		<meta name="keywords" content="理财机构,理财平台,互联网理财平台,互联网理财,p2p投资理财平台,p2p网贷平台,p2p理财论坛" />
		<meta name="description" content="理财么-获得理财经验的自助理财网站，您可以了解理财机构，互联网金融相关问题的评价信息，最新回复，评论理财问题，提升理财技巧，学习理财方法,掌握理财机构，互联网金融最新动态等信息." />
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
		.tagclass{
			min-height: 30px;
			margin-left: 20px;
		}
		.companyimg{
			min-height: 50px;
			margin-left: 20px;
		}
		
		ic_2 {
width: 230px;
}
		.sprites {
background: url(../../img/netlc/sprites.png);
display: inline-block;
}
.starbg {
background-position: 0 -257px;
height: 16px;
width: 84px;
margin-top: 11px;
}
 .starbg .star {
width: 16px;
height: 16px;
background-position: 0 -240px;
}
.starbg .star5 {
width: 84px;
}
.starbg .star4 {
width: 67px;
}
.starbg .star3 {
width: 50px;
}
.starbg .star2 {
width: 33px;
}
.starbg .star1 {
width: 16px;
}
.outerstar{
margin-left: 65px;
}
.important_new{
color: #E86E00;
font-size: 17px;
font-weight: 500;
}
		</style>
	</head>
	<body>
		<jsp:include page="/views/commons/licai_header_content.jsp"></jsp:include> 
		<div style="padding-bottom: 65px;"></div>
		<jsp:include page="netlc_product_company_common_list.jsp"></jsp:include>
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