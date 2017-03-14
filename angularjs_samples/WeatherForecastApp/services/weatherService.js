weatherApp.service('weatherService', ["$resource", "$sce", function($resource, $sce) {

//    trustSrc = function(src) {
//        return $sce.trustAsResourceUrl(src);
//    };
    
    this.getWeather = function(city, days) {
        var weatherAPI = $resource(
            "http://api.openweathermap.org/data/2.5/forecast/daily", 
            //{ callback: "JSON_CALLBACK" }, 
            { get: { method: "JSONP" }}
        );

        var weatherResult = weatherAPI.get({ 
            q: city, 
            cnt: days, 
            appid: '6b0496f110b4e72a897053e2cca8fd23' 
        });

        return weatherResult;
    };

}])