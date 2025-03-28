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
	
Inversion of Control
	- IoC = approach of outsourcing the construction and management of objects
	- Spring Container is the Object Factory which returns an object based on a configuration
	- Primary functions of Spring Continer
		1. Create and Manage Objects (Using IoC)
		2. Inject Object dependencies (Dependency Injection)
	- Configuring Spring Container
		1. XML Config (old way)
		2. Java Annotations 
		3. Java Source Code
		
Dependency Injection
	- The client delegates to another object the responsibility of providing its dependencies
	- Car Factory Example: You(client) ask Car Factory(Spring Container) to give you a new car, now its Factory's duty to assemble the car and its various parts ahead of time, so it can return you a car when asked. 
	- Injection Types(two recommended)
		- Constructor Injection -> when you have required dependencies
		- Setter Injection -> when you have optional dependencies
	- Spring Autowiring -> used by Spring for DI
	- @Component annotation marks a class as a candidate for DI. It marks the class as a Spring Bean
		- Spring Bean is a regular Java Class managed by Spring
	- NOTE: if you only have one constructor in a class then @Autowired on constructor is optional
	
	
		