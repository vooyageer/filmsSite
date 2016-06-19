<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %> 
<%@ page contentType="text/html; charset=UTF-8" %>

    <!-- Carousel
    ================================================== -->
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
      <!-- Indicators -->
      <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
      </ol>
      <div class="carousel-inner" role="listbox">
        <div class="item active">
          <img class="first-slide home-image" src="/film/resources/images/back1.jpg" alt="First slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>Vítejte na Film & Store</h1>
              <p>Prohlídněte si databázi fílmů, herců, režisérů, scénárístů a hudebních skladatelů.</p>
              
            </div>
          </div>
        </div>
        <div class="item">
          <img class="second-slide home-image" src="/film/resources/images/back2.jpg" alt="Second slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>Nakupujte u nás!</h1>
              <p>Nejlepší ceny dvd filmů do vaši sbírky.</p>    
            </div>
          </div>
        </div>
        <div class="item">
          <img class="third-slide home-image" src="/film/resources/images/back3.jpg" alt="Third slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>Novinky ze světa kinematografie!</h1>
              <p>Přečtěte si nové zajímavé články publikované zde na webu.</p>
            </div>
          </div>
        </div>
      </div>
      <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>
    </div><!-- /.carousel -->


    <!-- Marketing messaging and featurettes
    ================================================== -->
    <!-- Wrap the rest of the page in another container to center all the content. -->

    <div class="container marketing">

      <!-- Three columns of text below the carousel -->
      <div class="row">
        <div class="col-lg-4">
          <img class="img-circle" src="/film/resources/images/${actor1.idActor}.png" alt="Generic placeholder image" width="140" height="140">
          <h2>${actor1.name}</h2>
          <p>${actor1.description}</p>
                    <p><a class="btn btn-default" href="<c:url value="/actorList/viewActor/${actor1.idActor}"/>">Bližší informace &raquo;</a></p>
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
          <img class="img-circle" src="/film/resources/images/${actor2.idActor}.png" alt="Generic placeholder image" width="140" height="140">
          <h2>${actor2.name}</h2>
          <p>${actor2.description}</p>
                    <p><a class="btn btn-default" href="<c:url value="/actorList/viewActor/${actor2.idActor}"/>">Bližší informace &raquo;</a></p>
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
          <img class="img-circle" src="/film/resources/images/${actor3.idActor}.png" alt="Generic placeholder image" width="140" height="140">
          <h2>${actor3.name}</h2>
           <p>${actor3.description}</p>
          <p><a class="btn btn-default" href="<c:url value="/actorList/viewActor/${actor3.idActor}"/>">Bližší informace &raquo;</a></p>
        </div><!-- /.col-lg-4 -->
      </div><!-- /.row -->


     


      <%@include file="/WEB-INF/views/template/footer.jsp" %>