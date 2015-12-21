<%-- 剥离出来的内容部分 --%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="shopencode" uri="http://www.licaime.com/brandstore/shopel"%>

<div class="none">
<input type="text" id="userId" name="userId" value="${userId}">
<input type="text" id="wenTiid" name="userId" value="${wenTi.id}">
</div>
<div class="container">
		<div class="left">
		<div class="zu-main-content-inner with-indention-votebar">
			<div class="zm-tag-editor zg-section">
				<div class="zm-tag-editor-labels zg-clear" style="display: inline-block;">
				<c:forEach var="biaoqian" items="${biaoqianList}" varStatus="index">
					<a data-tip="t$b$19551577" class="zm-item-tag" href="${_contextPath}/wenda-${biaoqian.id}-1.htm" target="blank">${biaoqian.biaoqianName}</a>
				</c:forEach>
				</div>
			</div>
			<div id="zh-question-title" data-editable="true" class="zm-editable-status-normal">
				<h2 class="zm-item-title zm-editable-content">${wenTi.wentiName}</h2>
			</div>
			<div id="zh-question-detail" class="zm-item-rich-text zm-editable-status-normal" data-resourceid="2931948" data-action="/question/detail">
				<div class="zm-editable-content">${wenTi.wentiDesc}</div>
			</div>

			<div class="zm-item-meta zm-item-comment-el clearfix" id="zh-question-meta-wrap">
				<div class="zm-meta-panel">
					<div id="bdshare" style="float: right;margin-top: 5px;" class="bdshare_t bds_tools get-codes-bdshare" data="{'text':'${wenTi.wentiName} ${_contextPath}/question-${wenTi.id}-2-1.htm（分享自 @理财么）','url':'${_contextPath}/question-${wenTi.id}-2-1.htm','pic':''}">
				        <a class="bds_qzone"></a>
				        <a class="bds_tsina"></a>
				        <a class="bds_tqq"></a>
				        <span class="bds_more"></span>
			    	</div>
				</div>
			<div class="panel-container">
				<div class="question-invite-panel" style="display: none;">
				</div>
				<div class="zm-comment-box" style="display: none;">
				</div>
			</div>
			</div>
			<div class="zh-answers-title clearfix">
				<div id="zh-answers-filter" class="answers-sorter">
					<span class="lbl">按投票排序</span>
					<a class="lbl" href="/question/26872413?sort=created">按时间排序</a>
					<i class="zg-icon zg-icon-double-arrow"></i>
				</div>
				<h3 data-num="468" id="zh-question-answer-num">${pingluncount}个回答</h3>
			</div>
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
					<!-- <div class="zm-item-vote-info " data-votecount="201">
						<span class="voters">
						<span class="user-block"><a data-tip="p$t$liu-elith" href="http://www.zhihu.com/people/liu-elith" class="zg-link" data-original_title="刘elith">刘elith</a>、</span><span class="user-block"><a data-tip="p$t$wang-shi-ming-2-99" href="http://www.zhihu.com/people/wang-shi-ming-2-99" class="zg-link" title="王实名">王实名</a>、</span><span class="user-block"><a data-tip="p$t$zhang-yue-yue-50-13" href="http://www.zhihu.com/people/zhang-yue-yue-50-13" class="zg-link" title="张跃跃">张跃跃</a></span>
						</span>
						<a href="javascript:;" class="more"> 等人赞同</a>
					</div> -->
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
					<a class="answer-date-link meta-item" style="color: #999;" target="_blank" href="${_contextPath}/answer-${product.id}-2.htm">发布于 <fmt:formatDate value="${product.createTime}" pattern="yyyy年MM月dd日 "/></a>
					</span>
					<!-- <a href="#" class="meta-item zu-autohide" name="share" style="margin-left: 5px;">
					<i class="z-icon-share"></i>分享</a> -->
					<span class="copyright zu-autohide"></span>
					</div>
				</div>
			</div>
				<c:if test="${wenTiFlag && index.index==0}">
					<div class="more-awesome"><span>更多回答</span></div>
				</c:if>
			</c:forEach>
			<c:if test="${wenTiFlag}">
			<div class="zh-answers-title">
				<h3><a href="${_contextPath}/question-${wenTi.id}-2-1.htm" class="zg-link-litblue">查看全部回答</a></h3>
			</div>
			</c:if>
			<c:if test="${!wenTiFlag}">
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
						<textarea wrap="virtual" id="editable" class="zm-editable-editor-field-element editable"  style="border: 0px;width: 577px;">写回答(最多2500字)…</textarea>
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
		
		
		<div class="right post-thumbnail">
		    <div class="zm-side-section" id="zh-topic-side-children-list">
				<div class="zm-side-section-inner child-topic">
				<h3 class="zm-topic-side-organize-title">话题
				</h3>
				<div class="clearfix">
					<c:forEach var="product" items="${biaoqianAllList}" varStatus="index">
						<a class="zm-item-tag" href="${_contextPath}/wenda-${product.id}-1.htm" data-tip="t$t$19550780" data-token="19550780" data-topicid="186">
						${product.biaoqianName}
						</a>
					</c:forEach>
				</div>
				<a class="zg-link-litblue zm-topic-side-title-link"  href="javascript:void();">共有 ${biaoqianCount}个话题</a>
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
		    </div>
		    <!-- 百度广告 -->
		    <div>
		   	<script type="text/javascript">
		   	var cpro_id="u2198866";
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
		    <!-- 百度统计 -->
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
	  			var wentiId=$("#wenTiid").val();
	  			var pinglun=$("#editable").val();
	  			var pinglunType=2;
	  			
	  			if(userId==''){
	  				alert("请您先登录再评论！");
	  				return false;
	  			}
	  			if(userId=='' ||wentiId=='' ||pinglun==''){
	  				return false;
	  			}
	  			if(pinglun.length>2500){
	  				return false;
	  			}
	  			//评论替换
	  			pinglun=pinglun.replace(/\n/g,"<br/>");
	  		//异步加评论
	  			$.ajax({
	  				url:_contextPath+"/pinglun.htm",
	  				type:"post",
	  				data:{wentiId:wentiId,pinglun:pinglun,pinglunType:pinglunType,userId:userId},
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
<!-- 加入百度分享 -->
	<!-- <script>window._bd_share_config={"common":{"bdSnsKey":{"tsina":"4149632123","tqq":"801527859"},"bdText":"","bdMini":"1","bdMiniList":["qzone","tsina","weixin","tqq","douban","sqq"],"bdPic":"","bdStyle":"0","bdSize":"24"},"slide":{"type":"slide","bdImg":"6","bdPos":"right","bdTop":"100"},"image":{"viewList":["qzone","tsina","tqq","renren","weixin"],"viewText":"分享到：","viewSize":"16"},"selectShare":{"bdContainerClass":null,"bdSelectMiniList":["qzone","tsina","tqq","renren","weixin"]}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script> -->