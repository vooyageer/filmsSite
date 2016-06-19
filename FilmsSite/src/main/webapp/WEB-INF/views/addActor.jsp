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
			
			
			<form:form action="${pageContext.request.contextPath}/admin/actorInventory/addActor" method="post" commandName="actor" enctype="multipart/form-data">
  			<div class="form-group">
    			<label for="name">Name</label> <form:errors path="name" cssStyle="color: #ff0000" />
    			<form:input path="name" class="form-control" id="name" placeholder="Name" />
  			</div>
	
  			<div class="form-group">
    			<label for="gender">Gender:</label>
    			<label class="checkbox-inline"><form:radiobutton path="gender" id="gender" value="muz" />Muž</label>
    			<label class="checkbox-inline"><form:radiobutton path="gender" id="gender" value="zena" />Žena</label>
  			</div>
  			
  			  			
  			<div class="form-group">
    			<label for="born year">Born year</label> <form:errors path="born_year" cssStyle="color: #ff0000" />
    			<form:input path="born_year" class="form-control" id="born_year" placeholder="Born Year" />
  			</div>
  			
  			  			
  			<div class="form-group">
    			<label for="description">Description</label>
    			<form:textarea path="description" class="form-control" id="description" placeholder="Description" />
  			</div>
  			
  			<div class="form-group">
    			<label for="country">Country</label>
    			<form:input path="country" class="form-control" id="country" placeholder="Country" />
  			</div>
  			

  			
  			<div class="form-group">
  				<label class="control-label" for="actorImage">Nahrajte obrázek</label>
  				<form:input id="actorImage" path="actorImage" type="file" class="form:input-large" />
  			</div>
  			
  			<div class="form-group">
		        <label class="col-sm-2 control-label">Filmy:</label>
		        <div class="col-sm-10">
		            <form:select path="filmActor" class="form-control" >
		        		<form:options items="${filmsall}" itemLabel="name" itemValue="idFilm" />
		        	</form:select>
		        </div>
		    </div>
  		
  			<br></br>
  			<input type="submit" value="Submit" class="btn btn-default">
  			<a href="<c:url value="/admin/actorInventory" />" class="btn btn-default">Cancel</a>
  			
  			


			  
			  
        

        
        
        
        
			</form:form>
			
			


		
<%@include file="/WEB-INF/views/template/footer.jsp" %>
		  