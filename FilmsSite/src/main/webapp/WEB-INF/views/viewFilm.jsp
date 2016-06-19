<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %> 
<spring:url value="/resources/images" var="images" />
<%@ page contentType="text/html; charset=UTF-8" %>

    <div class="container-wrapper">
		<div class="container">
			<div class="page-header">
				<h1>Detail filmu | ${film.name}</h1>
				
			</div>
			
			<div class="container" ng-app="cartapp">
				<div class="row">
					<div class="col-md-5">
					
    					<img src="/film/resources/images/films/${film.idFilm }.png" onerror="this.src='/film/resources/images/noimage.png'" alt="image" style="width:100%"/>
    				
						
					</div>
					
					
					
					<div class="col-md-5">
						
						<h3>${film.name}</h3>
						<p> <strong>Popis</strong>: ${film.description}</p>
						<p><strong>Rok natočení</strong>: ${film.published_year}</p>
						<p><strong>Země</strong>: ${film.country}</p>
							
						<p>
						<strong>Herci</strong>:
						    <c:forEach var="actor" items="${filmActor.film}">
					          <p><a href="<c:url value="/actorList/viewActor/${actor.idActor}"/>">${film.name}</a></p>
					        </c:forEach>
					        <c:if test="${vet.nrOfSpecialties == 0}">none</c:if>
					    </p>
					    
					    <br>
					    
					    <c:set var="role" scope="page" value="${param.role}" />
					    <c:set var="url" scope="page" value="$/filmList" />
					    <c:if test="${role='admin'}" >
					    	<c:set var="url" scope="page" value="/admin/filmInventory" />
					    </c:if>
					    
					    <p ng-controller="cartCtrl">
					    	<a href="<c:url value="${url }"/>" class="btn btn-default">Back</a>
					   		<a href="#" class="btn btn-warning btn-large ng-click="addToCart("${film.idFIlm }")"><span class="glyphicon glyphicon-shopping-cart"></span>Order now</a>
					    <a href="<spring:url value="/cart"/>" class="btn btn-default"><span class="glyphicon glyphicon-hand-right"></span>View Cart</a>
					    </p>
					    
					    			
					</div>
				</div>
			</div>
	
	
<script src="<c:url value="/film/resources/js/controller.js"	/>"	></script>
<%@include file="/WEB-INF/views/template/footer.jsp" %>
		  