var myApp = angular.module('myApp', []);

myApp.controller('mainController', function($scope) {
    
    $scope.name = "manu";
    $scope.occupation = "coder";
    
    $scope.getName = function() {
        return "Manu Mehrotra";
    }
    
    $scope.getName();
    
    console.log($scope);
    
});