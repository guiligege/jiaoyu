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
                       <a href="${_contextPath}/netlc/company.htm">所有P2P理财公司</a>
                    </li>
                </ul>
				<ul class="nav nav-pills" style="margin-left: 80px; position: relative;">
                    <li class="disabled" style="position: absolute; left: -80px;">
                        <a href="#">平台背景</a>
                    </li>
                    <li class=""><a href="${_contextPath}/company--${pageParam.renqi}-${pageParam.rongzi}-1.htm">全部</a></li>
                    <li class="${pageParam.beijing==2 ?'active':''}"><a href="${_contextPath}/company-2-${pageParam.renqi}-${pageParam.rongzi}-1.htm">银行</a></li>
                    <li class="${pageParam.beijing==3 ?'active':''}"><a href="${_contextPath}/company-3-${pageParam.renqi}-${pageParam.rongzi}-1.htm">上市公司</a></li>
                    <li class="${pageParam.beijing==0 ?'active':''}"><a href="${_contextPath}/company-0-${pageParam.renqi}-${pageParam.rongzi}-1.htm">民营</a></li>
                    <li class="${pageParam.beijing==1 ?'active':''}"><a href="${_contextPath}/company-1-${pageParam.renqi}-${pageParam.rongzi}-1.htm">国资</a></li>
                </ul>
                <ul class="nav nav-pills" style="margin-left: 80px; position: relative;">
                    <li class="disabled" style="position: absolute; left: -80px;">
                        <a href="#">平台人气</a>
                    </li>
                    <li class=""><a href="${_contextPath}/company-${pageParam.beijing}--${pageParam.rongzi}-1.htm">全部</a></li>
                    <li class="${pageParam.renqi==5 ?'active':''}"><a href="${_contextPath}/company-${pageParam.beijing}-5-${pageParam.rongzi}-1.htm">五星级</a></li>
                    <li class="${pageParam.renqi==4 ?'active':''}"><a href="${_contextPath}/company-${pageParam.beijing}-4-${pageParam.rongzi}-1.htm">四星级</a></li>
                    <li class="${pageParam.renqi==3 ?'active':''}"><a href="${_contextPath}/company-${pageParam.beijing}-3-${pageParam.rongzi}-1.htm">三星级</a></li>
                    <li class="${pageParam.renqi==2 ?'active':''}"><a href="${_contextPath}/company-${pageParam.beijing}-2-${pageParam.rongzi}-1.htm">二星级</a></li>
                    <li class="${pageParam.renqi==1 ?'active':''}"><a href="${_contextPath}/company-${pageParam.beijing}-1-${pageParam.rongzi}-1.htm">一星级</a></li>
                    <li class="${pageParam.renqi==0 ?'active':''}"><a href="${_contextPath}/company-${pageParam.beijing}-0-${pageParam.rongzi}-1.htm">无星级</a></li>
                </ul>
                <ul class="nav nav-pills" style="margin-left: 80px; position: relative;">
                    <li class="disabled" style="position: absolute; left: -80px;">
                        <a href="#">融资状况</a>
                    </li>
                    <li class=""><a href="/company-${pageParam.beijing}-${pageParam.renqi}--1.htm">全部</a></li>
                    <li class="${pageParam.rongzi==0 ?'active':''}"><a href="${_contextPath}/company-${pageParam.beijing}-${pageParam.renqi}-0-1.htm">无</a></li>
                    <li class="${pageParam.rongzi==1 ?'active':''}"><a href="${_contextPath}/company-${pageParam.beijing}-${pageParam.renqi}-1-1.htm">A轮</a></li>
                    <li class="${pageParam.rongzi==2 ?'active':''}"><a href="${_contextPath}/company-${pageParam.beijing}-${pageParam.renqi}-2-1.htm">B轮</a></li>
                    <li class="${pageParam.rongzi==3 ?'active':''}"><a href="${_contextPath}/company-${pageParam.beijing}-${pageParam.renqi}-3-1.htm">C轮</a></li>
                    <li class="${pageParam.rongzi==4 ?'active':''}"><a href="${_contextPath}/company-${pageParam.beijing}-${pageParam.renqi}-4-1.htm">D轮</a></li>
                </ul>
            </div>
            <c:forEach var="product" items="${bList}" varStatus="index">
				<div style="position: relative;" class="project-summary wall">
				            <div class="row-fluid">
				        <div class="span8 ">
				        <div class="companyimg" style="margin-bottom: 10px;">
				        <%-- <i style="display: block; position: absolute; background: url(&quot;${pageContext.request.contextPath}/img/bankicon/cmbchina.png&quot;) no-repeat scroll 0px 0px / 20px auto transparent; width: 20px; height: 20px;"></i> --%>
				        <a href="${_contextPath}/companydetail-${product.id}.htm" target="_blank"> 
				        	<img src="${fn:replace(product.sitelogo, 'http://www.76676.com/uploadfile/p2plogo', 'http://www.licaime.com/p2p')}" title="${product.companyName}" alt="${product.companyName}" style="width: 145px;height: 50px;"/>
				        </a>
				        <span class="outerstar">
				        	<span>人气：</span>
					        <span class="ic_2">
						        <i class="fn_left sprites starbg">
							        <b class="sprites star star${product.renQi}"></b>
						        </i>
					        </span>
				        </span>
				        </div>
				            <div class="tagclass">
				                <p class="project-tags">
				                		 <span class="label label-success">
					                		 ${product.runState}
				                		 </span>
									<span class="tag">
			                            <i class="icon-certificate"></i>
			                            	<c:if test="${product.rongzi==1}">
			                            	A轮融资
			                            	</c:if>
			                            	<c:if test="${product.rongzi==2}">
			                            	B轮融资
			                            	</c:if>
			                            	<c:if test="${product.rongzi==3}">
			                            	C轮融资
			                            	</c:if>
			                            	<c:if test="${product.rongzi==4}">
			                            	D轮融资
			                            	</c:if>
			                            	<c:if test="${product.rongzi==0}">
			                            	暂未融资
			                            	</c:if>
			                        </span>
									<span class="tag">
										<i class="icon-time"></i>
										<c:if test="${product.beijing==1}">
			                            	国有企业
			                            	</c:if>
			                            	<c:if test="${product.beijing==2}">
			                            	银行
			                            	</c:if>
			                            	<c:if test="${product.beijing==3}">
			                            	上市公司
			                            	</c:if>
			                            	<c:if test="${product.beijing==0}">
			                            	民营企业
			                            	</c:if>
									</span>
				                </p>
				            </div>
				            <div class="row-fluid">
				                <div class="span12">
				                    <div style="margin-right: 10px;margin-left:20px;" class="pull-left">
										<a href="${_contextPath}/companydetail-${product.id}.htm" target="_blank" class="btn btn-large btn-details">查看详情</a>                    
									</div>
				                    <div class="pull-left">
				                        <p class="project-progress-desc"><span class="important">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注册资金：</span>
				                        <%-- <c:if test="${fn:contains(product.registerMoney,'不明')}">
				                        		不明
				                        </c:if> --%>
				                        <c:choose>
									       <c:when test="${fn:contains(product.registerMoney,'不明')}">
									       		不明
									       </c:when>
									       <c:otherwise>
									       ${product.registerMoney}
									       </c:otherwise>
										</c:choose>
				                        
				                        </p>
				                    </div>
				                </div>
				            </div>
				        </div>
				        <div class="span4">
				            <ul class="project-summary-items">
				            <li><span class="title">网站名称</span>
					                 	<a href="${_contextPath}/companydetail-${product.id}.htm" target="blank"> ${product.companyName}</a>
					               	</li>
					                <li><span class="title">交易额</span>
					                 	${product.jiaoyi}
					               	</li>
				                <li>
				                    <span class="title">利率范围</span>
				                    <span class="important_new data-tips">
				                    	${product.lilv}
				                            <i class="icon-info-sign icon-gray"></i>
				                    </span>
				                </li>
				                <li>
				                    <span class="title">法人代表</span>
				                    <span class="data-tips">
				                      		  ${product.faRen}
				                        <i class="icon-info-sign icon-gray"></i>
				                    </span>
				                </li>
				                <li><span class="title">运营公司</span><span title="${product.runCompany}" style="font-size: 12px;">${product.runCompany}</span></li>
				            </ul>
				        </div>
				    </div>
				</div>
			</c:forEach>
		    <jsp:include page="/views/commons/page.jsp"></jsp:include>
		</div>
		<div class="right post-thumbnail">
		    <div>
		    <!-- 百度广告 -->
		    <script type="text/javascript">
			    /*300*250 创建于 2014-07-29*/
			    var cpro_id = "u1636420";
			</script>
			<script src="http://cpro.baidustatic.com/cpro/ui/c.js" type="text/javascript"></script>
		    </div>
		    
		    <div>
			  	<script type="text/javascript">
				var cpro_id="u2201373";
				(window["cproStyleApi"] = window["cproStyleApi"] || {})[cpro_id]={at:"3",rsi0:"300",rsi1:"250",pat:"6",tn:"baiduCustNativeAD",rss1:"#FFFFFF",conBW:"1",adp:"1",ptt:"0",titFF:"%E5%BE%AE%E8%BD%AF%E9%9B%85%E9%BB%91",titFS:"14",rss2:"#000000",titSU:"0",ptbg:"90",piw:"0",pih:"0",ptp:"0"}
				</script>
				<script src="http://cpro.baidustatic.com/cpro/ui/c.js" type="text/javascript"></script>
		    </div>
		    <div>
		    <!-- 百度广告 -->
		    <script type="text/javascript">
			    /*300*250 创建于 2014-07-29*/
			    var cpro_id = "u1636443";
			</script>
			<script src="http://cpro.baidustatic.com/cpro/ui/c.js" type="text/javascript"></script>
		    </div>
		     <!-- 理财经验 -->
		    <hr>
			<section>
		        <a class="more" href="${_contextPath}/wenda.htm">更多</a>
		        <h3>理财经验</h3>
		        <ul>
		        <c:forEach var="product" items="${wenTiList}" varStatus="index">
	                <li><a target="_blank" href="${_contextPath}/question-${product.id}-2-1.htm">${product.wentiName}</a></li>
		        </c:forEach>
		        </ul>
		    </section>
		</div>
	</div>
<!-- 加入百度分享 -->
	<script>window._bd_share_config={"common":{"bdSnsKey":{"tsina":"4149632123","tqq":"801527859"},"bdText":"","bdMini":"1","bdMiniList":["qzone","tsina","weixin","tqq","douban","sqq"],"bdPic":"","bdStyle":"0","bdSize":"24"},"slide":{"type":"slide","bdImg":"6","bdPos":"right","bdTop":"100"},"image":{"viewList":["qzone","tsina","tqq","renren","weixin"],"viewText":"分享到：","viewSize":"16"},"selectShare":{"bdContainerClass":null,"bdSelectMiniList":["qzone","tsina","tqq","renren","weixin"]}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script>