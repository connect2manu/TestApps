package com.spark;

import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import com.tengen.HelloWorldFreemarkerStyle;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class SparkPOSTRoutesFormHandling {

	public static void main(String[] args) {
		final Configuration conf = new Configuration();
		conf.setClassForTemplateLoading(HelloWorldFreemarkerStyle.class, "/");

		Spark.get(new Route("/") {
			@Override
			public Object handle(Request arg0, Response arg1) {
				StringWriter writer = new StringWriter();
				try {
					Template template = conf.getTemplate("fruitPicker.ftl");
					
					Map<String, Object> fuitsMap = new HashMap<String, Object>();
					fuitsMap.put("fruits", Arrays.asList("apple", "orange", "mango", "kiwi"));
					
					template.process(fuitsMap, writer);
					
//					System.out.println(writer);
				} catch (Exception e) {
					halt(500);
					e.printStackTrace();
				}

				return writer;
			}
		});
		
		Spark.post(new Route("/favorite_fruit") {
			@Override
			public Object handle(final Request req, final Response res) {
				final String fruit = req.queryParams("favFruit");
				if(fruit == null) {
					return "Please select your favorite fruit!";
				} else {
					return "Your favorite fruit is = "+fruit;
				}
			}
		});
	}

}
