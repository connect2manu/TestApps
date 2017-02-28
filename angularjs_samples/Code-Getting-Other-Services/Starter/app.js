var myApp = angular.module('myApp', []);

myApp.controller('mainController', function($scope, $log, $filter) {
    
    console.log($log);
    
    $log.log("Hello");
    $log.info("info");
    $log.warn("warning");
    
    
    $scope.name = "Manu";
    $scope.formattedname = $filter('uppercase')($scope.name);
    $log.log($scope.name);
    $log.log($scope.formattedname);

});


var things = [1, 
              'string', 
              function hello(){
                  alert("hello");
              }
             ];
things[2]();
console.log(things);