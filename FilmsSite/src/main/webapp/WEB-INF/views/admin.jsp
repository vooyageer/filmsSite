


<%@include file="/WEB-INF/views/template/header.jsp" %> 
<%@ page contentType="text/html; charset=UTF-8" %>

    <div class="container-wrapper">
		<div class="container">
			<div class="page-header">
				<h1>Stránka administrátora</h1>
				
			</div>
			
			<c:if test="${pageContext.request.userPrincipal.name != null}">
            <h2>
                Vítejte: ${pageContext.request.userPrincipal.name} |
                <a href="<c:url value="/j_spring_security_logout"/>">Odhlásit se</a>
            </h2>

        </c:if>
			
			<h3>
			<a href="<c:url value="/admin/actorInventory" />">Správa herců</a>
			</h3>
			
			
			<p>Zde můžete zkontrolovat a upravovat Herce!</p>
			
			
			<h3>
			<a href="<c:url value="/admin/filmInventory" />">Správa filmů</a>
			</h3>
			
			
			<p>Zde můžete zkontrolovat a upravovat Filmy!</p>
			
			<h3>
			<a href="<c:url value="/admin/filmActorInventory" />">Správa tabulek</a>
			</h3>
			
			
			<p>Zde můžete zkontrolovat a upravovat Filmy!</p>
		
<%@include file="/WEB-INF/views/template/footer.jsp" %>
		  