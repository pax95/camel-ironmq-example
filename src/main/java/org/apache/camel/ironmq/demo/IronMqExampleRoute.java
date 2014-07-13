package org.apache.camel.ironmq.demo;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.properties.PropertiesComponent;

public class IronMqExampleRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		PropertiesComponent pc = new PropertiesComponent();
		pc.setLocation("classpath:ironmq.properties");
		getContext().addComponent("properties", pc);
		from("file://src/test/input").routeId("ironmq-producer-route").to(
				"ironmq://examplequeue?projectId={{projectid}}&token={{token}}&preserveHeaders=true");

		from("ironmq://examplequeue?projectId={{projectid}}&token={{token}}&maxMessagesPerPoll=50&preserveHeaders=true")
				.routeId("ironmq-subscriber-route").to("file://src/test/output");
	}

}
