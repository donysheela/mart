# mart

# Product Catalogue Service

It provides the following functionality by using Embedded H2 Database. 
1. GET /productCatalogueService/products – gives the list of all products 2. GET /productCatalogueService/search – gives the list of products for matching name, type 
3. GET /productCatalogueService/searchByType – gives the list of products for matching type 
4. POST /productCatalogueService/products – saves the given product 
5. DELETE /productCatalogueService/products/{id} – delete the given product

# Client API Gateway (ZUUL Proxy)

Any request from client will be re-directed to actual business through ZUUL Proxy. The following steps involved in redirecting to the actual business service url. 1. ZUUL contacts the “Config Server” to know the instances of the Service Discovery. 2. ZUUL will be provided the actual business service url by the Eureka. Here, Eureka will perform load balance using “Ribbon” before providing the actual url. 3. Finally, ZUUL will contact the actual business service url and redirect the response of the respective service to the requested client

# HYSTRIX
Can monitor all the requests to the business services by using the “Hystrix Turbine Stream”. This will give clear picture of all the requests information like how many got passed, how many got failed, how many still processing etc. for a specific period of time.

# Service Discovery – Eureka
This will maintain the all instances of business services, client API gateway and also all other instances o


# Config Server
This will have the list of all instances of eureka service discovery which will be maintained in any revision control system. Here, we used “github” so that we can dynamically change eureka server instance in case of any modification in the service discovery cluster. No need to re-start the cluster, dynamically cluster will get refreshed on modification in “githubf eureka service discovery in the cluster.

# Pricing Service

It provides the following functionality by using Embedded H2 Database. 

GET /pricingService/products/price/get 

The above method gives the price value for the given name and type of the product. This method first contact the “Product Catalogue Service” to get the “product id” for given name and type (This has been called using “load-balancer-client”). Then, get the price based on the “product id” attribute.
