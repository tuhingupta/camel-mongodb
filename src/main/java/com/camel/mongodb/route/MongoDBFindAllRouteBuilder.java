package com.camel.mongodb.route;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class MongoDBFindAllRouteBuilder extends RouteBuilder{
	
	@Override
	public void configure() throws Exception {

		from("timer://foo?repeatCount=1")
	    .to("mongodb:myDb?database=test&collection=customers&operation=findAll")
	    .process(new Processor() {
                    public void process(Exchange exchange) throws Exception {
                        System.out.println("Find All:  " + exchange.getIn().toString());
                    }
                })
	   ;
	}

}
