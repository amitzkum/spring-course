Actuators
	- Exposes endpoints to monitor and manage your application
	- You easily get DevOps functionality out-of-the-box
	- Simply add the dependency to your POM file and you get REST endpoints for actuators automatically
	- Use this to expose all actuator endpoints
		- `management.endpoints.web.exposure.include=*`

Spring Boot apps are self contained, contains server included
	- Used TomCat server by default
	- Running spring boot apps from command lind
		- Package the app using: `mvnw package`
		- Run option 1: `java -jar jarFileName.jar`
		- Run option 2: `mvnw spring-boot:run`
	
