<%-- 剥离出来的新的首页 --%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="shopel" uri="/WEB-INF/pagetag.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
  	<meta http-equiv="content-type" content="text/html; charset=utf-8">
  	<link type="image/x-icon" href="${pageContext.request.contextPath}/ico/licaime.ico" rel="icon" />
  	<!-- 公共setting配置 -->
  	
	<%@include file="/views/commons/config.jsp" %>
	<%@include file="/views/commons/cssandscript.jsp" %>
  	<link rel="stylesheet" type="text/css" href="${domain_css}/css/licai/detail/detail.css?${version_css}">
  	<script type="text/javascript" src="${domain_js}/js/licai/highcharts.js?${version_js}"></script>
  	<script type="text/javascript" src="${domain_js}/js/licai/modules/exporting.js?${version_js}"></script>
  	<script type="text/javascript">
  	function linkoutter(){
		var url=$("#outtertarget").attr("targeturl");
		//window.location.href=url;
		window.open(url);
	}
	</script>
  </head>
  <body>
  <jsp:include page="/views/commons/licai_header_content.jsp"></jsp:include> 
		<div style="padding-bottom: 65px;"></div>
        <div class="center">
          <div class="row-fluid">
            <div class="center-left" style="margin-top: 10px;">
              <div class="left-one">
              	<div id="bdshare" style="float: right;margin-top: 5px;" class="bdshare_t bds_tools get-codes-bdshare" data="{'text':'理财么-${lcProduct.companyName}-${lcProduct.title}}','url':'http://www.licaime.com/detail-${lcProduct.id}.htm','pic':'http://www.licaime.com/img/licai/licaime1.png'}">
			        <a class="bds_qzone"></a>
			        <a class="bds_tsina"></a>
			        <a class="bds_tqq"></a>
			        <!--<a class="bds_renren"></a> -->  
			        <span class="bds_more"></span>
			    </div>
                <div class="left-one-huang" style=" float: left; height: 30px; line-height: 30px; position: relative; text-indent: 22px; width: 87px; width:auto;padding-right: 12px;">
                  <%-- <i style="display: block; position: absolute; background: url(&quot;${_contextPath}/img/bankicon/${lcProduct.englishName}.png&quot;) no-repeat scroll 0px 0px / 20px auto transparent; width: 20px; height: 20px;"></i> --%>
                  <i style="background: url(&quot;${_contextPath}/img/bankicon/cmbchina.png&quot;) no-repeat scroll 0px 0px / 20px auto transparent; width: 20px; height: 20px; position: absolute; top: 50%; display: block; clear: both; margin-top: -9px;"></i>
                  	${lcProduct.companyName}
                </div>
                <div class="left-one-title">
                  <h2>${lcProduct.title}-${lcProduct.companyName}</h2>
                </div>
              </div>
              <hr class="dashed" style=" margin-bottom: 0;">
              <div class="left-five" style="padding-bottom:20px;">
                <div class="left-five-info1">
                      <div calss="info_wenzi" style="position: relative;">
                        <div class="span6">
                          <dl class="dl-horizontal">
                            <dt>发行机构：</dt>
                            <dd style="margin-left: 125px;">${lcProduct.companyName}</dd>
                            <dt>理财产品名称：</dt>
                            <dd style="margin-left: 125px;">
                            ${lcProduct.title}
                            </dd>
                            <dt>项目总金额：</dt>
                            <dd style="margin-left: 125px;"> ${lcProduct.totalMoney}
                            </dd>
                            <dt>代理或校验机构：</dt>
                            <dd style="margin-left: 125px;">${lcProduct.dailiCompany}</dd>
                            <dt>项目进度：</dt>
                            <dd style="margin-left: 125px;">${lcProduct.jindu}%</dd>
                            <dt>投资时间：</dt>
                            <dd style="margin-left: 125px;">${lcProduct.days}天</dd>
                          </dl>
                        </div>
                        <div class="span6">
                          <dl class="dl-horizontal">
                             <dt>年化利率：</dt>
                            <dd>${lcProduct.income}%</dd>
                            <dt>产品状态：</dt>
                            <dd>
                             <c:if test="${lcProduct.status==1}">
	                		 	在售
	                		 </c:if>
	                		 <c:if test="${lcProduct.status==0}">
	                		 	已售完
	                		 </c:if>
				            </dd>
                            <dt>起售日期：</dt>
                            <dd><fmt:formatDate value="${lcProduct.createTime}" pattern="yyyy年MM月dd日 "/></dd>
                            <dt>收益类型：</dt>
                            <dd>${lcProduct.incometype}</dd>
                            <dt>参考资料：</dt>
                           <dd><span class="important"><a target="_blank" id="outtertarget" targeturl="${lcProduct.linkurl}" href="javascript:linkoutter();">${lcProduct.title}</a></span></dd> 
                          </dl>
                        </div>
                      </div>
                    </div>
                    <div class="left-five-info2" style="clear: both;">
	                    <hr class="dashed"></hr>
	                    <h4>${lcProduct.companyName}-${lcProduct.title}-项目详细说明:</h4>
	                    <hr class="dashed"></hr>
	                    <div style="font-size:13px;">
	                    ${lcProduct.descrip}
	                    </div>
                    </div>
                    <div class="left-five-info2" style="clear: both;">
                      	<hr class="dashed"></hr>
                    	“理财么”是一个自助理财平台，是一个中立的，致力于帮助广大网友买到更适合自己的理财产品，每天为网友们提供各大银行和金融机构的理财产品,并附上相应机构理财产品说明书，保证数据的真实有效性。理财么网站理财资讯信息绝大部分来自银行和金融结构，经过金融数据搜索并整理展现给大家，这是也是一个大家帮助大家的社区，大家分享理财经验让大家更好的理财，更安全的理财，获得更多的收益。
                    </div>
                     <hr class="dashed"></hr>
                      <h4>${lcProduct.companyName}最新理财产品</h4>
		              <div >
		              <div class="investmentedList">
		                <div class="investments_area">
		                  <table>
		                    <thead>
		                      <tr>
		                        <th>机构</th>
		                        <th>名称</th>
		                        <th>投资总金额</th>
		                        <th>收益</th>
		                        <th>投资周期</th>
		                      </tr>
		                    </thead>
		                    <tbody>
		                   <c:forEach var="product" items="${newLcProductList}">
			                     <tr>
			                        <td><a href="${_contextPath}/netlc-${product.companyId}--1.htm">${product.companyName}</a></td>
			                        <td><a href="${_contextPath}/netdetail-${product.id}.htm">${product.title}</a></td>
			                        <td>
				                		${product.totalMoney}
			                        </td>
			                         <td>${product.income}%</td>
			                        <td>${product.days}天</td>
			                     </tr>
		                    </c:forEach>
		                    </tbody>
		                  </table>
		                  <div class="more" style="text-align: right;">
		                    <a href="${_contextPath}/netlc-${lcProduct.companyId}--1.htm">显示更多</a>
		                  </div>
		                </div>
		              </div>
		            </div>
                    </div>
                  </div>
            </div>
            <div class="center-right">
              <h3>风险评估</h3>
              <%-- <div class="grad-card">
                <dl class="dl-horizontal">
                  <dt>总评分数</dt>
                  <dd>${pingGu.total}分</dd>
                  <dt>产品收益</dt>
                  <dd>
                    <div class="progress" style="margin-bottom:8px;">
                      <div class="bar bar-success" style="width:${(pingGu.income * 16)/10}px;"></div>
                    </div>
                    <div class="rate-value">${pingGu.income}分</div>
                  </dd>
                  <dt>投资时间</dt>
                  <dd>
                    <div class="progress" style="margin-bottom:8px;">
                      <div class="bar bar-success" style="width:${(pingGu.days * 16)/10}px;"></div>
                    </div>
                    <div class="rate-value">${pingGu.days}分</div>
                  </dd>
                  <dt>收益类型</dt>
                  <dd>
                    <div class="progress" style="margin-bottom:8px;">
                      <div class="bar bar-success" style="width:${(pingGu.shouyi * 16)/10}px;"></div>
                    </div>
                    <div class="rate-value">${pingGu.shouyi}分</div>
                  </dd>
                  <dt>风险等级</dt>
                  <dd>
                    <div class="progress" style="margin-bottom:8px;">
                      <div class="bar bar-success" style="width:${(pingGu.fengxian * 16)/10}px;"></div>
                    </div>
                    <div class="rate-value">${pingGu.fengxian}分</div>
                  </dd>
                </dl>
              </div> --%>
              <p>
                <i class="sign icon" style="margin-top:2px"></i>理财么提醒您：理财有风险，投资需谨慎 
              </p>
              <hr></hr>
              <h3>其他在售理财产品</h3>
              <div class="investmentedList">
                <div class="investments_area">
                  <table>
                    <thead>
                      <tr>
                        <th style="width: 28px">机构</th>
                        <th>项目名称</th>
                        <th>收益</th>
                      </tr>
                    </thead>
                    <tbody>
                   <c:forEach var="product" items="${lcProductList}">
	                     <tr>
	                        <td><a href="${_contextPath}/netlc-${product.companyId}--1.htm">${product.companyName}</a></td>
	                        <td><a href="${_contextPath}/netdetail-${product.id}.htm">${product.title}</a></td>
	                        <td>${product.income}%</td>
	                     </tr>
                    </c:forEach>
                    </tbody>
                  </table>
                  <div class="more" style="text-align: right;">
                    <a href="">显示更多</a>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- 百度统计 -->
        <div class="none">
			<script type="text/javascript">
			var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
			document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3F19d3582fea421029f25811115d6cdf0e' type='text/javascript'%3E%3C/script%3E"));
			</script>
		</div>
		<!-- 百度广告开始 -->
		<jsp:include page="/views/commons/licai_footer.jsp"></jsp:include>
		<script type="text/javascript">
		    /*250*200 创建于 2014-07-29*/
		var cpro_id = "u1636408";
		</script>
		<script src="http://cpro.baidustatic.com/cpro/ui/f.js" type="text/javascript"></script>
		<!-- 百度广告开始 结束-->
  </body>
</html>