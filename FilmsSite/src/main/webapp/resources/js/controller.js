var cartApp = angular.module ("cartApp", []);

cartApp.controller("cartCtrl", function($scope, $http){

    $scope.refreshCart = function(){
       $http.get('/rest/cart/' + $scope.idCart).success(function (data){
           $scope.cart = data;
       });
    };

    $scope.clearCart = function(){
        $http.delete('/rest/cart/' + $scope.idCart).success($scope.refreshCart($scope.idCart));
    };

    $scope.initCartId = function(idCart){
        $scope.idCart = idCart;
        $scope.refreshCart(idCart);
    };

    $scope.addToCart = function(idFilm){
        $http.put('/rest/cart/add/' + idFilm).success(function (){
            alert('Product successfully added to the cart!');
        });
    };

    $scope.removeFromCart = function(idFilm){
        $http.put('/rest/cart/remove/' + idFilm).success(function(data){
           $scope.refreshCart($http.get('/rest/cart/idCart'));
        });
    };

    $scope.calGrandTotal = function(){
        var grandTotal = 0;

        for (var i = 0; i < $scope.cart.cartItems.length; i++){
            grandTotal += $scope.cart.cartItems[i].totalPrice;
        }

        return grandTotal;
    }
});