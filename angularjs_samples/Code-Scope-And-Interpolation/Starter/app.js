var myApp = angular.module('myApp', []);

myApp.controller('mainController', ['$scope', '$timeout', function($scope, tout) {
    
    $scope.name = "manu";
    
    tout(function(){
        $scope.name = 'Everyone';
    }, 3000);
    
    
}]);
