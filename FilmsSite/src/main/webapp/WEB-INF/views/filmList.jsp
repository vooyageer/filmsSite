<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp" %> 
<%@ page contentType="text/html; charset=UTF-8" %>

<meta http-equiv="Content-Type" content="text/html; charset=utf8" charset="utf8" >

    <div class="container-wrapper">
		<div class="container">
			<div class="page-header">
				<h1>Seznam filmů</h1>
				
			</div>
			
			<table class="table table-bordered table-hover">
				<thead>
					<tr class="bg-success">
						<th>Obrázek</th>
						
						<th>Jméno</th>
						<th>Popis</th>
						<th>Rok natočení</th>
						<th>země</th>
						
						<th></th>
					</tr>
				</thead>
				
				<c:forEach items="${films}" var="film">
					<tr>
						<td><img src="/film/resources/images/films/${film.idFilm}.png" onerror="this.src='/film/resources/images/noimage.png'" alt="image" style="width:100%"/></td>
						
						<td>${film.name }</td>
						<td>${film.description }</td>
						<td>${film.published_year }</td>
					
						<td>${film.country }</td>
						<td><a href="<spring:url value="/filmList/viewFilm/${film.idFilm}"/>"/><span class="glyphicon glyphicon-info-sign"></span></a></td>
					</tr>
					</c:forEach>
			</table>
			

			
			
		
<%@include file="/WEB-INF/views/template/footer.jsp" %>
		  