//ROUTES
weatherApp.config(["$routeProvider", function($routeProvider) {
    $routeProvider
        .when("/", {
              templateUrl: "pages/home.htm",
              controller: "homeController"
        })
        .when("/forecast", {
              templateUrl: "pages/forecast.htm",
              controller: "forecastController"
        })
        .when('/forecast/:days', {
              templateUrl: 'pages/forecast.htm',
              controller: 'forecastController'
        })
    
    
}]);

weatherApp.config(['$sceDelegateProvider', function($sceDelegateProvider) {
    $sceDelegateProvider.resourceUrlWhitelist([
        'self',
        'http://api.openweathermap.org/**'])
}]);