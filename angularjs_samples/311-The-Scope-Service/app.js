var myApp = angular.module('myApp', []);

myApp.controller('mainController', function($scope) {
    
    //console.log($scope);
    
});

var searchPeople = function(firstname, lastname, age) {
    return "Manu Mehrotra";
}

console.log(searchPeople);
console.log(searchPeople(1,2,3));

var searchPeopleFuncStr = searchPeople.toString();
console.log(searchPeopleFuncStr);

console.log(angular.injector().annotate(searchPeople));