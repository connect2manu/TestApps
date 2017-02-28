var myApp = angular.module('myApp', []);

myApp.controller('mainController', ['$scope', '$filter', function($scope, $filter) {
    
    $scope.handle = '';
    
    var lowercaseHandle = function {
        return $filter('lowercase')($scope.handle);
    }
    
    
}]);
