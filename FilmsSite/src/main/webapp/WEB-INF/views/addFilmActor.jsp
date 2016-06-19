<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %> 
<%@ page contentType="text/html; charset=UTF-8" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf8" charset="utf8" >


    <div class="container-wrapper">
		<div class="container">
			<div class="page-header">
				<h1>Add Actor</h1>
				
				<p class="lead">Fill the information about Actor</p>
			</div>
			
			
			<form:form action="${pageContext.request.contextPath}/admin/filmActorInventory/addFilmActor" method="post" commandName="filmActor">
  			
  			
  			<div class="form-group">
		        <label class="col-sm-2 control-label">Filmy:</label>
		        <div class="col-sm-10">
		            <form:select path="film" class="form-control" >
		        		<form:options items="${filmsall}" itemLabel="name" itemValue="idFilm" />
		        	</form:select>
		        </div>
		    </div>
		    
		    <div class="form-group">
		        <label class="col-sm-2 control-label">Herci:</label>
		        <div class="col-sm-10">
		            <form:select path="actor" class="form-control" >
		        		<form:options items="${actorsall}" itemLabel="name" itemValue="idActor" />
		        	</form:select>
		        </div>
		    </div>
  		
  			<br></br>
  			
  			
  			<input type="submit" value="Submit" class="btn btn-default">
  			<a href="<c:url value="/admin/filmActorInventory" />" class="btn btn-default">Cancel</a>
  			
  			


			  
			  
        

        
        
        
        
			</form:form>
			
			


		
<%@include file="/WEB-INF/views/template/footer.jsp" %>
		  