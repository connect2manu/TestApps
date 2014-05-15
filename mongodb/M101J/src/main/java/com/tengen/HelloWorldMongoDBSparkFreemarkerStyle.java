package com.tengen;

import java.io.StringWriter;
import java.net.UnknownHostException;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 *
 */
public class HelloWorldMongoDBSparkFreemarkerStyle{

	public static void main(String[] args) throws UnknownHostException {

		final Configuration conf = new Configuration();
		conf.setClassForTemplateLoading(HelloWorldMongoDBSparkFreemarkerStyle.class, "/");
		
		MongoClient client = new MongoClient(new ServerAddress("localhost", 27017));
		
		DB database = client.getDB("course"); // show dbs; use course
		final DBCollection collection = database.getCollection("hello"); // db.course.findOne()

		Spark.get(new Route("/") {
			@Override
			public Object handle(Request arg0, Response arg1) {
				StringWriter writer = new StringWriter();
				try {
					Template template = conf.getTemplate("hello.ftl");
					DBObject document = collection.findOne(); // db.course.findOne() => { "_id" : ObjectId("536af98b3249b6cde505b7f6"), "name" : "mongodb" }
					
					template.process(document, writer);
					
//					System.out.println(writer);
				} catch (Exception e) {
					halt(500);
					e.printStackTrace();
				}

				return writer;
			}
		});
		
	}

}
