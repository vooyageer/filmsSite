<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %> 
<%@ page contentType="text/html; charset=UTF-8" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf8" charset="utf8" >


    <div class="container-wrapper">
		<div class="container">
			<div class="page-header">
				<h1>Add Film</h1>
				
				<p class="lead">Fill the information about Film</p>
			</div>
			
			
			<form:form action="${pageContext.request.contextPath}/admin/filmInventory/addFilm" method="post" commandName="film" enctype="multipart/form-data">
  			<div class="form-group">
    			<label for="name">Name</label> <form:errors path="name" cssStyle="color: #ff0000" />
    			<form:input path="name" class="form-control" id="name" placeholder="Name" />
  			</div>
	

  			
  			  			
  			<div class="form-group">
    			<label for="born year">Published year</label> <form:errors path="published_year" cssStyle="color: #ff0000" />
    			<form:input path="published_year" class="form-control" id="published_year" placeholder="Published Year" />
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
  				<label class="control-label" for="filmImage">Nahrajte obrázek</label>
  				<form:input id="filmImage" path="filmImage" type="file" class="form:input-large" />
  			</div>
  		
  			<br></br>
  			<input type="submit" value="Submit" class="btn btn-default">
  			<a href="<c:url value="/admin/filmInventory" />" class="btn btn-default">Cancel</a>
  			

        
        
        
        
			</form:form>
			
			


		
<%@include file="/WEB-INF/views/template/footer.jsp" %>
		  