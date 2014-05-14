package com.tengen;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class HelloWorldFreemarkerStyle {

	public static void main(String[] args) {
		
		Configuration conf = new Configuration();
		conf.setClassForTemplateLoading(HelloWorldFreemarkerStyle.class, "/");
		
		try {
			Template template = conf.getTemplate("hello.ftl");
			StringWriter writer = new StringWriter();
			Map<String, Object> helloMap = new HashMap<String, Object>();
			helloMap.put("name", "Freemarker");
			
			template.process(helloMap, writer);
			
			System.out.println(writer);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
