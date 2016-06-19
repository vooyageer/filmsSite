<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp" %> 
<%@ page contentType="text/html; charset=UTF-8" %>

    <div class="container-wrapper">
		<div class="container">
			<div class="page-header">
				<h1>Modifikace herců</h1>
				
				
			</div>
			
			<table class="table table-striped table-hover">
				<thead>
					<tr class="bg-success">
						<th>Obrázek</th>
						<th>ID</th>
						<th>Jméno</th>
						<th>Popis</th>
						<th>Rok narození</th>
						<th>Pohlaví</th>
						<th>Země</th>
						<th></th>
					</tr>
				</thead>
				
				<c:forEach items="${actors}" var="actor">
					<tr>
						<td><img src="/film/resources/images/${actor.idActor }.png" onerror="this.src='/film/resources/images/noimage.png'" alt="image" style="width:100%"/></td>
						<td>${actor.idActor }</td>
						<td>${actor.name }</td>
						<td>${actor.description }</td>
						<td>${actor.born_year }</td>
						<td>${actor.gender }</td>
						<td>${actor.country }</td>
						<td>
							<a href="<spring:url value="/actorList/viewActor/${actor.idActor }"/>"/><span class="glyphicon glyphicon-info-sign"></span></a>
							<a href="<spring:url value="/admin/actorInventory/deleteActor/${actor.idActor }"/>"/><span class="glyphicon glyphicon-remove"></span></a>
							<a href="<spring:url value="/admin/actorInventory/editActor/${actor.idActor }"/>"/><span class="glyphicon glyphicon-pencil"></span></a>
						</td>
					</tr>
					</c:forEach>
			</table>
			
			<a href="<spring:url value="/admin/actorInventory/addActor"/>" class="btn btn-primary">Add actor</a>
		
<%@include file="/WEB-INF/views/template/footer.jsp" %>
		  