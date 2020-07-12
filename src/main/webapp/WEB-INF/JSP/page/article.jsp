<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<script src="https://apis.google.com/js/platform.js" async defer></script>


<div class="article thumbnail">
	<c:set var="category" value="${CATEGORY_MAP[article.idCategory] }" />
	<a href="${article.articleLink }"><img src="${article.logo }" alt="${article.title }" /></a>
	<div class="data">
		<h3>
			<a href="${article.articleLink }">${article.title }</a>
		</h3>
		<ul class="vertical large-horizontal menu">
			<li><i class="fi-folder"></i><a href="/news${category.url}">${category.name }</a></li>
			<li><i class="fi-comments"></i> <fmt:formatNumber value="${article.comments }" /> comments</li>
			<li><i class="fi-clock"></i> <fmt:formatDate value="${article.created }" dateStyle="FULL" timeStyle="SHORT" type="both" /></li>
			<li><i class="fi-eye"></i>Hits: <fmt:formatNumber value="${article.views }" /></li>
		</ul>
		<hr />
		<div class="desc">${article.content }</div>
		<div class="row columns social">
			<img src="http://placehold.it/32x32?text=f" alt="social" />
			<img src="http://placehold.it/32x32?text=t" alt="social" />
			<img src="http://placehold.it/32x32?text=g" alt="social" />
			<img src="http://placehold.it/32x32?text=f" alt="social" />
			<img src="http://placehold.it/32x32?text=t" alt="social" />
			<img src="http://placehold.it/32x32?text=g" alt="social" />
		</div>
		<br>
		<div class="comments">
			<jsp:include page="../fragment/new-comment.jsp" />
			<div id="comments-list-container" data-comments-count="${article.comments }" data-id-article="${article.id }">
				<jsp:include page="../fragment/comments.jsp" />				
			</div>
			<div id="comments-load-more-ctrl" class="row column text-center">
				<a href="javascript:moreComments();" class="button hollow expanded load-more-btn" ${article.comments >  fn:length(comments) ? '' : 'style="display:none"' }>Load More</a>
				<img src="/static/img/loading.gif" alt="Loading..." class="loading-indicator" />
			</div>
		</div>
	</div>
</div>
