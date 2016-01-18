# camel-mongodb Project
====================

This project uses Camel with Mongodb. 
It connects to Mongo DB running in a docker container over port 27017 and queries data.

## Mongo DB:
```
$ db
test

$ show dbs
local  0.000GB
test   0.000GB

$ db 
test

$ show collections
customers

$ db.customers.find().pretty();
{
	"_id" : ObjectId("569d417122a7ebef10c280af"),
	"name" : "Cust1",
	"address" : "addr1",
	"city" : "city1",
	"zip" : "00001"
}
{
	"_id" : ObjectId("569d418322a7ebef10c280b0"),
	"name" : "Cust2",
	"address" : "addr2",
	"city" : "city2",
	"zip" : "00002"
}
```

## Main.java:

This program prints the data in collection customers

## MongoDBFindAllRouteBuilder.java:

This has the route to findAll from Mongo DB collection
		
		from("timer://foo?repeatCount=1")
	    .to("mongodb:myDb?database=test&collection=customers&operation=findAll")
	    .process(new Processor() {
                    public void process(Exchange exchange) throws Exception {
                        System.out.println("Find All:  " + exchange.getIn().toString());
                    }
                })
	   ;
