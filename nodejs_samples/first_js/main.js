/* Hello, World! program in node.js */
console.log("Hello, World!");

var http = require("http");
var moment = require('moment');
console.log(moment().format("ddd, hA"));

/*
http.createServer(function (request, response) {
   // Send the HTTP header 
   // HTTP Status: 200 : OK
   // Content Type: text/plain
   response.writeHead(200, {'Content-Type': 'text/plain'});
   
   // Send the response body as "Hello World"
   response.end('Hello World from http server\n');
}).listen(8081);

// Console will print the message
console.log('Server running at http://127.0.0.1:8081/');
*/