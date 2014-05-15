package com.spark;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

public class SparkGETRoutes {

	public static void main(String[] args) {
		Spark.get(new Route("/") {
			@Override
			public Object handle(Request arg0, Response arg1) {
				return "Welcome - Home Page";
			}
		});
		
		Spark.get(new Route("/test") {
			@Override
			public Object handle(Request arg0, Response arg1) {
				return "Test Page";
			}
		});
		
		Spark.get(new Route("/echo/:thing") {
			@Override
			public Object handle(Request arg0, Response arg1) {
				return arg0.params(":thing");
			}
		});
	}

}
