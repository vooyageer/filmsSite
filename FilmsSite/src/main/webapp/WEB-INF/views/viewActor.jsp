<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %> 
<spring:url value="/resources/images" var="images" />
<%@ page contentType="text/html; charset=UTF-8" %>

    <div class="container-wrapper">
		<div class="container">
			<div class="page-header">
				<h1>Detail herce | ${actor.name}</h1>
				
			</div>
			
			<div class="container">
				<div class="row">
					<div class="col-md-5">
					
    					<img src="/film/resources/images/${actor.idActor }.png" onerror="this.src='/film/resources/images/noimage.png'" alt="image" style="width:100%"/>
    				
						
					</div>
					
					
					
					<div class="col-md-5">
						
						<h3>${actor.name}</h3>
						<p> <strong>Popis</strong>: ${actor.description}</p>
						<p><strong>Rok narození</strong>: ${actor.born_year}</p>
						<p><strong>Pohlaví</strong>: ${actor.gender}</p>
						<p><strong>Původ</strong>: ${actor.country}</p>	
						<p>
						<strong>Filmy</strong>:
						    <c:forEach var="film" items="${filmActor.film}">
					          <p><a href="<c:url value="/filmList/viewFilm/${film.idFilm}"/>">${film.name}</a></p>
					        </c:forEach>
					        <c:if test="${vet.nrOfSpecialties == 0}">none</c:if>
					    </p>			
					</div>
				</div>
			</div>
		
<%@include file="/WEB-INF/views/template/footer.jsp" %>
		  