<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp" %> 
<%@ page contentType="text/html; charset=UTF-8" %>

    <div class="container-wrapper">
		<div class="container">
			<div class="page-header">
				<h1>Modifikace filmů</h1>
				
				
			</div>
			
			<table class="table table-striped table-hover">
				<thead>
					<tr class="bg-success">
						<th>Obrázek</th>
						<th>ID</th>
						<th>Jméno</th>
						<th>Popis</th>
						<th>Rok natočení</th>
						<th>Země</th>
						
						<th></th>
					</tr>
				</thead>
				
				<c:forEach items="${films}" var="film">
					<tr>
						<td><img src="/film/resources/images/films/${film.idFilm }.png" onerror="this.src='/film/resources/images/noimage.png'" alt="image" style="width:100%"/></td>
						<td>${film.idFilm }</td>
						<td>${film.name }</td>
						<td>${film.description }</td>
						<td>${film.published_year }</td>
						<td>${film.country }</td>
						
						<td>
							<a href="<spring:url value="/filmList/viewFilm/${film.idFilm }"/>"/><span class="glyphicon glyphicon-info-sign"></span></a>
							<a href="<spring:url value="/admin/filmInventory/deleteFilm/${film.idFilm }"/>"/><span class="glyphicon glyphicon-remove"></span></a>
							<a href="<spring:url value="/admin/filmInventory/editFilm/${film.idFilm }"/>"/><span class="glyphicon glyphicon-pencil"></span></a>
						</td>
					</tr>
					</c:forEach>
			</table>
			
			<a href="<spring:url value="/admin/filmInventory/addFilm"/>" class="btn btn-primary">Add film</a>
		
<%@include file="/WEB-INF/views/template/footer.jsp" %>
		  