 # DataTx Apache Geode Kotlin REST API

This is an Spring Boot based app written in [Kotlin](https://kotlinlang.org/) that provides the following [Apache Geode](https://geode.apache.org/) features 
- POST region with region key and value to put data into a [region](https://geode.apache.org/docs/guide/basic_config/data_regions/chapter_overview.html)
- GET region name and key to read
- Query against Apache Geode Regions


*Latest Features*

- Uses pure PDX instances without dependencies on having Java Classes in CLASSPATH
- Queries PDX (select * from /region) or Core Java datatypes (select field1, field2 from /region)
- Supports region CRUD operations
- Authentication endpoint with configurable username/password
- Swagger test UI
- Uses [Spring Data Geode](https://spring.io/projects/spring-data-geode)

# Setup
## Building

Use the [gradle](https://gradle.org/install/) to build application.

    gradle clean build

## Configuration

When starting the application you must provide the ENVironment

- spring_data_gemfire_pool_locators=host1[port],host2[port]   (comma separated)
- spring_security_user_name=Authentication user
- spring_security_user_password=Authentication password
- spring_data_gemfire_name=**Client Name**


Example 
	
	export spring_data_gemfire_pool_locators=localhost[10334]
	export spring_security_user_name=app
	export spring_security_user_password=password
	export spring_data_gemfire_name=GEODE_REST_CLIENT
	export spring_data_gemfire_security_username=admin
    export spring_data_gemfire_security_password=admin

**Secured Apache Geode Authentication**

When connecting to a Apache Geode cluster with security enabled, set the following spring
properties. Note that is can be different then the spring_security_user_name/spring_security_user_password
properties.

    spring.data.gemfire.security.username=...
    spring.data.gemfire.security.password=...
    
    

## Cloud Foundry

The follow contains details for deploying the application of [Cloud Foundry](https://www.cloudfoundry.org/).
This version of the application has been testing on the 
implementation [VMware Tanzu Application Service for VMs](https://docs.pivotal.io/application-service).
s
### Create GemFire instance


```shell script
cf create-service p-cloudcache extra-small gemfire
```

Wait for the service installation to be completed.

### Setup service key

```shell script
cf create-service-key gemfire default
```

- Copy gfsh_login_string
- Execute Gfsh 

```shell script
gfsh
```

Execute login string


Get connect details
```shell
cf service-key gemfire default
```


```shell script
cf push -f ./manifest.yml -p build/libs/dataTx-geode-rest-kotlin-app-0.0.1-SNAPSHOT.jar
```
 

## Start App


This application is [Spring Boot](https://spring.io/projects/spring-boot).

Like all spring boot applicatons, it can be started 
using java -jar <path-to-jar>. 

Example

    java -jar build/libs/dataTx-geode-rest-kotlin-app-0.0.1-SNAPSHOT.jar 

## Security 

The application URL endpoints are secured using
[Spring Security](https://spring.io/projects/spring-security).

Using user/password in the properties **spring_security_user_name** and **spring_security_user_password**

# REST Region Service

The URL http://**root**/region prefix exposes a REST interface to preform READ/WRITE 
operations on a Apache Geode region.


## POST region

Put a  key/value entry into a given region.

**NOTE** The value is expected to be a JSON string


**Format** 

	http://<root>/region/<regionName>/<key>
	
	POST BODY
		<value>

*Example*

HTTP POST

http://**host**/region/Test/hello

RESPONSE

{ "name" : "world"}



## GET region

Get a region value based on a given key

**Format** 

	http://<root>/region/<regionName>/<key>
	
*Example*

HTTP GET

http://localhost:8080/region/Test/hello

RESPONSE

{ "name" : "world"}



# Query

Perform a Apache Geode
http://host:port/query 

* Note the select assumes the results of PdxInstances 

HTTP POST 

http://localhost:8080/query

    
    select * from /region 


Appending a number the limit the number of results returned. 

    http://host:port/query/limitNumber
	

HTTP POST 

http://localhost:8080/query/10

    
    select * from /region 