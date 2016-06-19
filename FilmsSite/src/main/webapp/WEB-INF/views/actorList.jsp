<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp" %> 
<%@ page contentType="text/html; charset=UTF-8" %>

<meta http-equiv="Content-Type" content="text/html; charset=utf8" charset="utf8" >

    <div class="container-wrapper">
		<div class="container">
			<div class="page-header">
				<h1>Seznam herců</h1>
				
			</div>
			
			<table class="table table-bordered table-hover">
				<thead>
					<tr class="bg-success">
						<th>Obrázek</th>
						
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
						<td><img src="/film/resources/images/${actor.idActor}.png" onerror="this.src='/film/resources/images/noimage.png'" alt="image" style="width:100%"/></td>
						
						<td>${actor.name }</td>
						<td>${actor.description }</td>
						<td>${actor.born_year }</td>
						<td>${actor.gender }</td>
						<td>${actor.country }</td>
						<td><a href="<spring:url value="/actorList/viewActor/${actor.idActor}"/>"/><span class="glyphicon glyphicon-info-sign"></span></a></td>
					</tr>
					</c:forEach>
			</table>
			

			
			
		
<%@include file="/WEB-INF/views/template/footer.jsp" %>
		  