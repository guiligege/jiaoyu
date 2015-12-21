<%-- 剥离出来的内容部分 --%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="shopencode" uri="http://www.licaime.com/brandstore/shopel"%>
<div class="container">
			<h2>提问</h2>
			<div style="padding-top:20px;"></div>
			<div class="grid-16-8 clearfix">
		        <div class="article">
				<form id="form_note">
					<div style="display:none;"><input type="hidden" id="userId" name=""userId"" value="${userId }"></div>
				    <div class="row note-title">
				        <label class="field" for="note_title">题目:</label>
				        <div>
				            <input tabindex="1" id="note_title" name="note_title" type="text" value="" autofocus="" maxlength=50>
				        </div>
				    </div>
				    <div class="row note-text">
				        <label class="field" for="note_text">正文:</label>
				        <textarea tabindex="2" id="note_text" name="note_text"  maxlength="300"></textarea>
				    </div>
				    <div class="row note-tags">
				            <label class="field" for="author_tags_clone">标签:</label>
				    	<div class="douban-tag-editor">
				    		<div data-reactid=".0">
						    	<div class="tag-editor" data-reactid=".0.0">
							    	<div class="placeholder" data-reactid=".0.0.0">
							    		请选择下面的标签，给标题添加标签。
							    	</div>
						    	</div>
						    	<div class="tag-console" data-reactid=".0.1">
						    	</div>
						    	<div class="tag-panels" data-reactid=".0.2">
						    		<span class="tag-panel-toggle" data-reactid=".0.2.0">展开全部</span>
						    		<dl class="tag-panel preview" data-reactid=".0.2.2">
						    			<dt data-reactid=".0.2.2.0">标签：</dt>
						    			<dd data-reactid=".0.2.2.1">
						    				<c:forEach var="product" items="${biaoqianAllList}" varStatus="index">
						    					<a class="tag" data-reactid="${product.id}">${product.biaoqianName}</a>
						    				</c:forEach>
						    			</dd>
						    		</dl>
						    	</div>
						    	<input id="author_tags" type="hidden" name="author_tags" value="" data-reactid=".0.3">
					    	</div>
				    	</div>
				    </div>
				    <div class="row footer">
				        <div class="error-msg board">
				        </div>
				        <span class="bn-flat">
				            <input tabindex="9" id="preview_note" value="预览" type="button" class="bn-flat">
				        </span>
				        &nbsp;
				        <input tabindex="10" id="publish_note" value="发表" type="submit" class="submitbtn" name="note_submit">
				        <span class="bn-flat cancel-note">
				            <input tabindex="11" id="cancel_note" value="取消" type="submit" class="bn-flat" name="cancel_note">
				        </span>
				    </div>
				</form>
				<div id="preview"></div>
	        </div>
		</div>
	</div>
	<script type="text/javascript">
		$(function () {
	  	//查看全部
	  		$(".tag").click(function(){
	  			$(".placeholder").hide();
	  			var myvalue=$(this).html();
	  			var myattr=$(this).attr("data-reactid");
	  			$(".tag-editor").append("<div class='tag' ><input class='myattr' type='hidden' value='"+myattr+"'  style='width: 26px;'><input type='text' value='"+myvalue+"'  style='width: 26px;'><a class='biaoqian'>×</a></div>");
	  			$("#author_tags").val($("#author_tags").val()+myattr+",");
	  			//添加点击事件
	  			$(".biaoqian").click(function(){
	  				var flag=false;
	  				var myattr=$(this).siblings(".myattr").val()+",";
	  				//移除元素，并清空关联
	  				$(this).parent().remove();
	  				$("#author_tags").val($("#author_tags").val().replace(myattr,""));
	  				//如果是最后一个关闭
	  				if($(".biaoqian").length==0){
	  					$(".placeholder").show();
	  				}
	  			});
	  		});
	  	
	  	//提交问题
	  		$("#publish_note").click(function(){
	  			var userId=$("#userId").val();
	  			var title=$("#note_title").val();
	  			var desc=$("#note_text").val();
	  			var biaoqian=$("#author_tags").val();
	  			if(userId==''){
	  				$(".error-msg").html("提问请先登录!").show();
	  				return false;
	  			}
	  			if(title==''){
	  				$(".error-msg").html("问题不能为空!").show();
	  				return false;
	  			}
	  			if(title.length>50){
	  				$(".error-msg").html("问题长度不能大于50字!").show();
	  				return false;
	  			}
	  			if(desc==''){
	  				//$(".error-msg").html("问题描述不能为空!").show();
	  				//return false;
	  			}
	  			if(desc.length>300){
	  				$(".error-msg").html("问题描述不能大于300个字!").show();
	  				return false;
	  			}
	  			if(biaoqian==''){
	  				$(".error-msg").html("请选择标签，给标题添加标签!").show();
	  				return false;
	  			}
	  			if(biaoqian.split(",").length>6){
	  				$(".error-msg").html("一个问题最多5个标签!").show();
	  				return false;
	  			}
	  			//提交问题
	  			
	  		//异步减赞
	  			$.ajax({
	  				url:_contextPath+"/ask.htm",
	  				type:"post",
	  				data:{title:title,desc:desc,biaoqians:biaoqian,userId:userId},
	  				dataType:"json",
	  				async:false,
	  				success:function(data){
	  					if(data.code=='0'){
	  						//减少赞
	  						window.location = "/wenda.htm";
	  					}else{
	  					}
	  				},
	  				error:function(data){
	  				}
	  			});
	  			
	  			return false;
	  		});
	  	});
	</script>
<!-- 加入百度分享 -->
	<!-- <script>window._bd_share_config={"common":{"bdSnsKey":{"tsina":"4149632123","tqq":"801527859"},"bdText":"","bdMini":"1","bdMiniList":["qzone","tsina","weixin","tqq","douban","sqq"],"bdPic":"","bdStyle":"0","bdSize":"24"},"slide":{"type":"slide","bdImg":"6","bdPos":"right","bdTop":"100"},"image":{"viewList":["qzone","tsina","tqq","renren","weixin"],"viewText":"分享到：","viewSize":"16"},"selectShare":{"bdContainerClass":null,"bdSelectMiniList":["qzone","tsina","tqq","renren","weixin"]}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script> -->