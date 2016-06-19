<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %> 
<%@ page contentType="text/html; charset=UTF-8" %>


<div class="container-wrapper">
	<div class="container">
		<section>
			<div class = "jumbotron">
				<div class="container">
					<h1>Košík</h1>
					
					<p>Vybrané položky ve vašem košíku</p>
				</div>
			</div>
		</section>
		
		<section class="container" ng-app="cartApp">
		<div ng-controller = "cartCtrl" ng-init="initCartId($(idCart))">
			<div>
				<a class="btn btn-danger pull-left"><span class="glyphicon glyphicon-remove-sign"></span>Vyprázdnit košík</a>	
			</div>
			
			<table class="table table-hover">
				<tr>
					<th>Film</th>
					<th>Cena za položku</th>
					<th>množství</th>
					<th>Cena</th>
					<th></th>
				</tr>
				<tr ng-repeat = "item in cart.cartItems">
					<td>{{item.film.name}}</td>
					<td>{{item.film.prize}}</td>
					<td>{{item.quantity}}</td>
					<td>{{item.totalPrize}}</td>	
					<td><a href="" class="label label-danger" ng-click="removeFromCart(item.film.idFilm)"><span class="glyphicon glyphicon-remove" ></span>remove</a></td>	
				</tr>
				<tr>
					<th></th>
					<th></th>
					<th>Grand Total</th>
					<th>{{cart.grandTotal}}</th>
					<th></th>
				</tr>
			</table>
		
		<a href="<spring:url value="/filmList"/>"  class="btn btn-default">Continue shopping</a>
		</div>
		</section>
		
		
	</div>
</div>





<%@include file="/WEB-INF/views/template/footer.jsp" %>