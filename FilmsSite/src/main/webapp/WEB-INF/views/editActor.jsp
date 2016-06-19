<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %> 
<%@ page contentType="text/html; charset=UTF-8" %>


    <div class="container-wrapper">
		<div class="container">
			<div class="page-header">
				<h1>Edit Actor</h1>
				
				<p class="lead">Fill the information about Actor</p>
			</div>
			
			
			<form:form action="${pageContext.request.contextPath}/admin/actorInventory/editActor/" method="post" commandName="actor" enctype="multipart/form-data">
  			
  			<form:hidden path="idActor" value="${actor.idActor}"/>
  			
  			<div class="form-group">
    			<label for="name">Name</label>
    			<form:input path="name" class="form-control" id="name" placeholder="Name" value="${actor.name }"/>
  			</div>
	
  			<div class="form-group">
    			<label for="gender">Gender:</label>
    			<label class="checkbox-inline"><form:radiobutton path="gender" id="gender" value="muž" />Muž</label>
    			<label class="checkbox-inline"><form:radiobutton path="gender" id="gender" value="žena" />Žena</label>
  			</div>
  			
  			  			
  			<div class="form-group">
    			<label for="born year">Born year</label>
    			<form:input path="born_year" class="form-control" id="born_year" placeholder="Born Year" value="${actor.born_year }"/>
  			</div>
  			
  			  			
  			<div class="form-group">
    			<label for="description">Description</label>
    			<form:textarea path="description" class="form-control" id="description" placeholder="Description" value="${actor.description }"/>
  			</div>
  			
  			<div class="form-group">
    			<label for="country">Country</label>
    			<form:input path="country" class="form-control" id="country" placeholder="Country" value="${actor.country }"/>
  			</div>
  			
  			<div class="form-group">
  				<label class="control-label" for="actorImage">Nahrajte obrázek</label>
  				<form:input id="actorImage" path="actorImage" type="file" class="form:input-large" />
  			</div>
  		
  			<br></br>
  			<input type="submit" value="Submit" class="btn btn-default">
  			<a href="<c:url value="/admin/actorInventory" />" class="btn btn-default">Cancel</a>
			</form:form>
			
			


		
<%@include file="/WEB-INF/views/template/footer.jsp" %>
		  