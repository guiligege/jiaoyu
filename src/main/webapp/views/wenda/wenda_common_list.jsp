<%-- 剥离出来的内容部分 --%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="shopencode" uri="http://www.licaime.com/brandstore/shopel"%>
<div class="container">
		<div class="left">
			<div class="zu-top-feed-list navigable" id="zh-topic-top-page-list">
				
				<c:forEach var="product" items="${wenTiPingLunList}" varStatus="index">
					<div class="feed-item feed-item-hook folding" itemprop="question" itemscope="" itemtype="http://schema.org/Question" data-score="1">
						<div class="feed-main">
							<div class="content">
								<h2><a class="question_link" target="_blank" href="${_contextPath}/question-${product.wenTi.id}-2-1.htm">${product.wenTi.wentiName}</a></h2>
								<div  style="margin-left: 48px;" class="entry-body " data-aid="14658936" data-atoken="48152465" data-collapsed="False" data-created="1431917178" data-deleted="0" data-isowner="0" data-helpful="1" data-score="0">
								
								<c:choose>
									<c:when test="${product.pingLun.pinglun==null}">
										<div class="zm-item-answer-detail">
											<div class="zh-summary summary clearfix ">
											<c:if test="${product.wenTi.wentiTip!=null }">
												${fn:substring(product.wenTi.wentiTip, 0, 120)}
										    </c:if>
											</div>
										</div>
									</c:when>
									<c:otherwise>   
									   <div class="zm-item-vote">
									<a name="expand" class="zm-item-vote-count" href="javascript:;" data-votecount="${product.pingLun.zan}">${product.pingLun.zan}</a>
									</div>
									<div class="zm-item-answer-detail">
									<div class="zm-item-answer-author-info">
									<a href="javascript:;" name="collapse" class="collapse meta-item zg-right hidden"><i class="z-icon-fold"></i>收起</a>
									<h3 class="zm-item-answer-author-wrap">${product.pingLun.userName}</h3>
									</div>
									<div class="zm-item-rich-text" data-resourceid="4293206" data-action="/answer/content">
									<div class="zm-editable-content hidden">
										${product.pingLun.pinglun}
										<span class="answer-date-link-wrap">
										<a class="answer-date-link last_updated meta-item" target="_blank" href="${_contextPath}/answer-${product.pingLun.id}-2.htm">编辑于  <fmt:formatDate value="${product.pingLun.createTime}" pattern="yyyy年MM月dd日 "/></a>
										</span>
										<div id="bdshare" style="float: right;margin-top: 5px;" class="bdshare_t bds_tools get-codes-bdshare" data="{'text':'${wenTi.wentiName} ${_contextPath}/question-${wenTi.id}-2-1.htm（分享自 @理财么）','url':'${_contextPath}/question-${wenTi.id}-2-1.htm','pic':''}">
									        <a class="bds_qzone"></a>
									        <a class="bds_tsina"></a>
									        <a class="bds_tqq"></a>
									        <span class="bds_more"></span>
								    	</div>
									</div>
									<div class="zh-summary summary clearfix ">
									 	${fn:substring(product.pingLun.pinglun, 0, 120)}...
											<!-- 沿着这个主题，说说我自己的故事吧。也浅谈我的财富观。2011年，博士毕业，和妻子，同时在一所二线城市大学工作。收入就不说了，全国统一市场价。两家基本生活条件，都属于三线小城市的富裕家庭。我父母，文革期间招工，进的企业。国有企业双职工，父母年轻… -->
											<a href="javascript:void();" class="toggle-expand">显示全部</a>
									</div>
									</div>
									</div>
								  	</c:otherwise>
								</c:choose>
								<c:if test="${product.pingLun!=null}">
									
								</c:if>
								</div>
								<div class="zm-item-meta feed-meta" style="margin-left:48px;">
									<div class="zm-item-meta zm-item-comment-el answer-actions clearfix">
										<!-- <div class="zm-meta-panel">
											<a data-follow="q:link" class="follow-link zg-follow meta-item" href="javascript:;" id="sfb-4293206"><i class="z-icon-follow"></i>关注问题</a>
											<a href="#" class="meta-item zu-autohide" name="share">
											<i class="z-icon-share"></i>分享</a>
										</div> -->
									</div>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
			<jsp:include page="/views/commons/page.jsp"></jsp:include>
		</div>
		
		
		<div class="right post-thumbnail">
		    <div class="zm-side-section" id="zh-topic-side-children-list">
				<div class="zm-side-section-inner child-topic">
				<h3 class="zm-topic-side-organize-title">话题
				</h3>
				<div class="clearfix">
					<c:forEach var="product" items="${biaoqianList}" varStatus="index">
					<c:if test="${product.biaoqianName eq oneBiaoQian}">
					<span class="active">
					</c:if>
					<c:if test="${product.biaoqianName ne oneBiaoQian}">
					<span >
					</c:if>
						<a class="zm-item-tag" href="${_contextPath}/wenda-${product.id}-1.htm" data-tip="t$t$19550780" data-token="19550780" data-topicid="186">
						${product.biaoqianName}
						</a>
					</span>
					</c:forEach>
				</div>
				<a class="zg-link-litblue zm-topic-side-title-link"  href="javascript:void();">共有 ${biaoqianCount}个话题</a>
				</div>
			</div>
		   <!-- 百度广告 -->
		   <div>
		    <script type="text/javascript">
			    var cpro_id = "u1636420";
			</script>
			<script src="http://cpro.baidustatic.com/cpro/ui/c.js" type="text/javascript"></script>
		    </div>
		    <div>
		    <script type="text/javascript">
			    var cpro_id = "u1636420";
			</script>
			<script src="http://cpro.baidustatic.com/cpro/ui/c.js" type="text/javascript"></script>
		    </div>
		    <div>
		    </div>
		    <div>
		     <script type="text/javascript">
			    var cpro_id = "u1636443";
			</script>
			<script src="http://cpro.baidustatic.com/cpro/ui/c.js" type="text/javascript"></script>
		    </div> 
	        <div class="none">
				<script type="text/javascript">
				var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
				document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3F19d3582fea421029f25811115d6cdf0e' type='text/javascript'%3E%3C/script%3E"));
				</script>
			</div>
		</div>
		
	</div>
	<script type="text/javascript">
		$(function () {
	  	//查看全部
	  		$('.toggle-expand').click(function(){
	  			$(this).parent().hide();
	  			$(this).parent().parent().find(".zm-editable-content").show();
	  			$(this).parent().parent().siblings(".zm-item-answer-author-info").find(".collapse").show();
	  		});
	  		$('.zg-right').click(function(){
	  			$(this).parent().siblings(".zm-item-rich-text").find(".zh-summary").show();
	  			$(this).parent().siblings(".zm-item-rich-text").find(".zm-editable-content").hide();
	  			$(this).parent().siblings(".zm-item-rich-text").find(".toggle-expand").show();
	  			$(this).hide();
	  		});
	  	
	  	});
	</script>
<!-- 加入百度分享 -->
	<!-- <script>window._bd_share_config={"common":{"bdSnsKey":{"tsina":"4149632123","tqq":"801527859"},"bdText":"","bdMini":"1","bdMiniList":["qzone","tsina","weixin","tqq","douban","sqq"],"bdPic":"","bdStyle":"0","bdSize":"24"},"slide":{"type":"slide","bdImg":"6","bdPos":"right","bdTop":"100"},"image":{"viewList":["qzone","tsina","tqq","renren","weixin"],"viewText":"分享到：","viewSize":"16"},"selectShare":{"bdContainerClass":null,"bdSelectMiniList":["qzone","tsina","tqq","renren","weixin"]}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script> -->