<%-- 剥离出来的尾部 --%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>


</style>
<%--page start--%>
<!-- <div class="w-page"> -->
<div class="pagination pagination-centered">
	<c:if test="${pager==null }">
	没有记录
	</c:if>
	<c:if test="${pager!=null}">
	<%-- <span>第${pager.currentPage}页/共${pager.totalPages}页</span> --%>
	<c:if test="${pager.currentPage==1}">
	</c:if>
	 <ul style="padding-top: 2px;">
	<!-- page开始位置 -->
    <c:if test="${pager.currentPage!=1}">
		<li><a href="http://weixin.licaime.com/${urlParam}1.htm">首页</a></li>
		<li><a href="http://weixin.licaime.com/${urlParam}${pager.currentPage-1}.htm">上一页</a></li>
	</c:if>
	<c:if test="${pager.currentPage>=pager.pageindexsize}">
		<li><a href="http://weixin.licaime.com/${urlParam}1.htm">1</a></li>
		<li><a href="javascript:void(0);">...</a></li>
	</c:if>
	<!-- 中间page的数字 -->
    <c:forEach var="page" items="${pager.results}" varStatus="index">
    	<c:choose>
    		<c:when test="${page<=0 || page>pager.totalPages}">
    		</c:when>
    		<c:when test="${page==pager.currentPage}">
    			<%-- <a class="cur" href="javascrip:void(0);">${page}</a> --%>
    			 <li class="active"><a href="javascript:void(0);">${page}</a></li>
    		</c:when>
    		<c:otherwise>
    			<%-- <a href="http://weixin.licaime.com/${urlParam}${page}.htm">${page}</a> --%>
    			 <li><a href="http://weixin.licaime.com/${urlParam}${page}.htm">${page}</a></li>
    		</c:otherwise>
    	</c:choose>
    </c:forEach>
    <c:if test="${pager.currentPage==pager.totalPages || pager.totalPages==0}">
	</c:if>
    <c:if test="${pager.currentPage<=pager.totalPages-pager.pageindexsize+1}">
		<%-- ....<a href="http://weixin.licaime.com/${urlParam}${pager.totalPages}.htm">${pager.totalPages}</a> --%>
		<li><a href="javascript:void(0);">...</a></li>
		<li><a href="http://weixin.licaime.com/${urlParam}${pager.totalPages}.htm">${pager.totalPages}</a></li> 
	</c:if>
    <c:if test="${pager.currentPage!=pager.totalPages && pager.totalPages!=0}">
	    <%-- <a href="http://weixin.licaime.com/${urlParam}${pager.currentPage+1}.htm">下一页</a>
	    <a href="http://weixin.licaime.com/${urlParam}${pager.totalPages}.htm">末页</a> --%>
	    <li><a href="http://weixin.licaime.com/${urlParam}${pager.currentPage+1}.htm">下一页</a></li>
	     <li><a href="http://weixin.licaime.com/${urlParam}${pager.totalPages}.htm">末页</a></li>
    </c:if>
    </c:if>
</div>
<%--page end--%>