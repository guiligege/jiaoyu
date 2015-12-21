<%-- 剥离出来的内容部分 --%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="shopencode" uri="http://www.licaime.com/brandstore/shopel"%>
<div class="container">
		<div class="left">
			<div class="well">
				<ul class="nav nav-pills">
                    <li class="disabled">
                       <a href="${_contextPath}/netlc.htm">所有P2P理财产品</a>
                    </li>
                </ul>
				<ul class="nav nav-pills" style="margin-left: 80px; position: relative;">
                    <li class="disabled" style="position: absolute; left: -80px;">
                        <a href="#">发行机构</a>
                    </li>
                    <li class=""><a href="${_contextPath}/netlc.htm">全部</a></li>
                    <c:forEach items="${netLcCompanyList }" var="lcProductYinHang">
                    	<li class="${pageParam.id eq lcProductYinHang.id ?'active':''}"><a href="${_contextPath}/netlc-${lcProductYinHang.id}-${pageParam.status}-1.htm">${lcProductYinHang.companyName}</a></li>
                    </c:forEach>
                </ul>
            </div>
			<c:forEach var="product" items="${bList}" varStatus="index">
				<div style="position: relative;" class="project-summary wall">
				            <div class="row-fluid">
				        <div class="span8 ">
				            <div style="min-height: 75px;">
				                <h4 style="margin-bottom:10px; line-height:18px;padding-top:5px;">
				                <i style="display: block; position: absolute; background: url(&quot;${pageContext.request.contextPath}/img/bankicon/cmbchina.png&quot;) no-repeat scroll 0px 0px / 20px auto transparent; width: 20px; height: 20px;"></i>
				                    <a href="${_contextPath}/netdetail-${product.id}.htm" style="display: block; text-indent: 20px;margin-left: 5px;">
				                    	${product.title}
				                    </a>
				                </h4>
				                <p class="project-tags">
				                		 <span class="label label-success">
					                		 <c:if test="${product.status==1}">
					                		 	在售
					                		 </c:if>
					                		 <c:if test="${product.status==0}">
					                		 	已售完
					                		 </c:if>
				                		 </span>
				                    <span class="tag">
				                        <i class="icon-retweet"></i>
				                      <a href="${_contextPath}/netlc-${product.companyId}--1.htm">${product.companyName}</a>
				                    </span>
									<span class="tag">
			                            <i class="icon-certificate"></i>
			                            	互联网理财
			                        </span>
									<span class="tag"><i class="icon-time"></i>定时标</span>
				                </p>
				            </div>
				            <div class="row-fluid">
				                <div class="span12">
				                    <div style="margin-right: 10px;margin-left:20px;" class="pull-left">
										<a href="${_contextPath}/netdetail-${product.id}.htm" target="_blank" class="btn btn-large btn-details">查看详情</a>                    
									</div>
				                    <div class="pull-left">
				                            <div class="project-progress">
				                                    <div class="progress progress-striped active">
				                                        <div style="width: ${product.jindu}%;" class="bar"></div>
				                                    </div>
				                            </div>
				                                <p class="project-progress-desc">项目进度：${product.jindu}%<span class="important">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;开始时间：</span> <fmt:formatDate value="${product.createTime}" type="both" pattern="yyyy-MM-dd"/></p>
				                    </div>
				                </div>
				            </div>
				        </div>
				        <div class="span4">
				            <ul class="project-summary-items">
					                <li><span class="title">项目总金额</span>
					                 <c:if test="${product.totalMoney==0}">
					                 	<span  class="important">
					                     <a href="${_contextPath}/netdetail-${product.id}.htm" >
					                    	点击查看
					                     </a>
					                    </span>
					                 </c:if>
					                 <c:if test="${product.totalMoney!=0}">
					                 	${product.totalMoney}
						               	元
						             </c:if>
					               	</li>
				                <li>
				                    <span class="title">年化收益</span>
				                    <c:if test="${product.income==0}">
				                    <span class="important">
				                     <a href="${_contextPath}/netdetail-${product.id}.htm" >
				                    	点击查看
				                     </a>
				                    </span>
				                    </c:if>
				                    <c:if test="${product.income!=0}">
				                    <span class="important data-tips">
				                    	${product.income}%
				                            <i class="icon-info-sign icon-gray"></i>
				                    </span>
				                    </c:if>
				                </li>
				                <li>
				                    <span class="title">投资期限</span>
				                    <span class="data-tips">
				                        ${product.days}
				                        <i class="icon-info-sign icon-gray"></i>
				                    </span>
				                </li>
				                <li><span class="title">代理公司</span>${product.dailiCompany}</li>
				            </ul>
				        </div>
				    </div>
				</div>
			</c:forEach>
		    <jsp:include page="/views/commons/page.jsp"></jsp:include>
		</div>
		<div class="right post-thumbnail">
			<section>
		        <a class="more" href="#">更多</a>
		        <h3>媒体报道</h3>
		        <ul>
	                <li><a target="_blank" href="http://www.gzmama.com/thread-3443921-1-1.html">十年理财经验调研各大银行理财产品利率</a></li>
	                <li><a target="_blank" href="http://www.yinhang123.net/wangdian/licaichanpin/2014/0623/25422.html">6月23日宝宝军团收益排名</a></li>
		        </ul>
		    </section>
		    <hr>
		    <div>
		    <!-- 百度广告 -->
		    <script type="text/javascript">
			    /*300*250 创建于 2014-07-29*/
			    var cpro_id = "u1636420";
			</script>
			<script src="http://cpro.baidustatic.com/cpro/ui/c.js" type="text/javascript"></script>
		    </div>
		    
		    <div>
		    <!-- tanx广告 -->
		    <script type="text/javascript">
			     document.write('<a style="display:none!important" id="tanx-a-mm_48124372_7062997_23960588"></a>');
			     tanx_s = document.createElement("script");
			     tanx_s.type = "text/javascript";
			     tanx_s.charset = "gbk";
			     tanx_s.id = "tanx-s-mm_48124372_7062997_23960588";
			     tanx_s.async = true;
			     tanx_s.src = "http://p.tanx.com/ex?i=mm_48124372_7062997_23960588";
			     tanx_h = document.getElementsByTagName("head")[0];
			     if(tanx_h)tanx_h.insertBefore(tanx_s,tanx_h.firstChild);
			</script> 
			<!-- sogou -->
		    </div>
		    <!-- 淘宝组件 -->
		    <div>
		    <!-- 百度广告 -->
		    <script type="text/javascript">
			    /*300*250 创建于 2014-07-29*/
			    var cpro_id = "u1636443";
			</script>
			<script src="http://cpro.baidustatic.com/cpro/ui/c.js" type="text/javascript"></script>
		    </div>
		</div>
	</div>
<!-- 加入百度分享 -->
	<script>window._bd_share_config={"common":{"bdSnsKey":{"tsina":"4149632123","tqq":"801527859"},"bdText":"","bdMini":"1","bdMiniList":["qzone","tsina","weixin","tqq","douban","sqq"],"bdPic":"","bdStyle":"0","bdSize":"24"},"slide":{"type":"slide","bdImg":"6","bdPos":"right","bdTop":"100"},"image":{"viewList":["qzone","tsina","tqq","renren","weixin"],"viewText":"分享到：","viewSize":"16"},"selectShare":{"bdContainerClass":null,"bdSelectMiniList":["qzone","tsina","tqq","renren","weixin"]}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script>