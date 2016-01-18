package com.camel.mongodb.main;

import org.apache.camel.CamelContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {

    	ApplicationContext appContext = new ClassPathXmlApplicationContext(new String[] {"camel/camel-context-mongo.xml"});
    	CamelContext camelContext = appContext.getBean(CamelContext.class);

    	  try
    	  {
    	    camelContext.start();
    	    Thread.sleep(10000); 
    	  }
    	  catch (Exception e)
    	  {
    	    e.printStackTrace();
    	  }finally{
    		  
    	  }
		
	}

}
