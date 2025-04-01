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
	

---


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
	
	
Component Scanning 
	- `import org.springframework.boot.autoconfigure.SpringBootApplication;` enables Auto Configuration, Component Scanning, and Additional Configuration. 
	- This is imported in the main Spring Boot App Java file.
	- `@EnableAutoConfiguration` - enables SBs auto-config support, `@ComponentScan` - enables component scanning in the current and sub-packages, `@Configuration` - registers extra beans with the `@Bean` annotation, or import other configuration classes
	- Component scanning by default scans only the package of the main Spring Boot App
		- For other packages if you want component scanning -> Explicitly specifiy the packages to scan in `@SpringBootApplication` annotation
		- e.g. 
			```java
			// ...
			@SpringBootApplication(
				scanBasePackages={
									"com.amitkr25.springcoredemo", 
									"com.amitkr25.demo", 
									"org.acme.cart"
								})
			public class SpringApplication {}
			// ...
			```

Setter Injection
	- inject dependencies by calling setter methods on your class
	- create a setter method in your class and add `@Autowired` annotation
	- NOTE: You can inject dependencies by calling ANY method in your class simply by using the `@Autowired` annotation


Field Injection -> not recommended by spring.io team
	- makes code harder to Unit Test
	- inject dependencies by setting field values directly on your class (even private fields)
		- accomplished by using Java Reflections

Qualifiers
	- If we have multiple implementations of an interface which one to inject?
	- Spring will give the following error

		```
		Parameter 0 of constructor in com.amitkr25.springcoredemo.rest.DemoController required a single bean, but 4 were found:
			- baseballCoach: defined in file [D:\dev\spring-course\code\springcoredemo\springcoredemo\target\classes\com\amitkr25\springcoredemo\common\BaseballCoach.class]
			- cricketCoach: defined in file [D:\dev\spring-course\code\springcoredemo\springcoredemo\target\classes\com\amitkr25\springcoredemo\common\CricketCoach.class]
			- tennisCoach: defined in file [D:\dev\spring-course\code\springcoredemo\springcoredemo\target\classes\com\amitkr25\springcoredemo\common\TennisCoach.class]
			- trackCoach: defined in file [D:\dev\spring-course\code\springcoredemo\springcoredemo\target\classes\com\amitkr25\springcoredemo\common\TrackCoach.class]
		```

	- using `@Qualifier("beanID")` beanId whould have the same name as the class except the first character lower case, so for CricketCoach class beanId will be cricketCoach
	- Use the qualifier where you are injecting, either setter or constructor injection

	- The qualifier should come before the argument
		- e.g.
		```java
		// using constructor injection
	    @Autowired
	    public DemoController(@Qualifier("baseballCoach") Coach coach) {
	        myCoach = coach;
	    }
		```

	- 	If you have multiple implementations then one of them can me marked default using the `@Primary` annotation. 
	- Qualifier annotation has higher precedence than Primary
	- prefer using Qualifier


Lazy Initialization `@Lazy`
	- instead of creating all beans upfront, initialize only when 
		- it is needed for dependency injection
		- explicitly requested
	- Instead of adding `@Lazy` to each class we could use a global lazy config
		- In applicatin.properties set `spring.main.lazy-initialization=true`


Bean Scopes `@Scope` annotation
	- Default scope is Singleton(Spring container creates only one instance of the bean, it is cached in memory, all refrences will point to same bean)
	- Explicitly specifying the bean to be singleton using `@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)`
	- Types of scopes
		1. singleton
		2. prototype - new bean instance for each injection request
		3. request - scoped to a http web request, only used for web apps
		4. session - scoped to a http web session, only used for web apps
		5. application - scoped to a web app ServletContext, used only for web apps 
		6. websocket - scoped for websocket, only used for web apps

Bean Lifecycle Methods(Hooks)
	- You can add custom code during bean's lifecycle
	- `@PostConstruct`
	- `@PreDestroy`
	- Special Note about Prototype Scope - Destroy Lifecycle Method
		- For "prototype" scoped beans, Spring does not call the destroy method. 
		- In contrast to the other scopes, Spring does not manage the complete lifecycle of a prototype bean: the container instantiates, configures, and otherwise assembles a prototype object, and hands it to the client, with no further record of that prototype instance.
		- Thus, although initialization lifecycle callback methods are called on all objects regardless of scope, in the case of prototypes, configured destruction lifecycle callbacks are not called. The client code must clean up prototype-scoped objects and release expensive resources that the prototype bean(s) are holding.

Configuring Beans with Java Code
	- Process
		1. Create `@Configuration` class
		2. Define `@Bean` method to configure the bean
		3. Inject the bean into our controller
	- Used of `@Bean` 
		- Make an existing third party class available to Spring Framework
		- You may not have access to source code of the third party class(only jar file)
			- To use that third party class, import the jar file, and use it as a spring bean


---


Hibernate
	- Framwork for persisting/saving Java objects in a DB
	- Benifits
		1. Handles low level sql
		2. Minimizes the amount of JDBC code you have to develop
		3. Provides ORM
	- ORM = mapping between a java class and a table
	- JPA = Jakarta Persistence API (aka Java Persistence API)
		- standard API for ORM
		- only a specification
		- defines a set of interfaces which are required to be implemented
	- MySql Account: springstudent@springstudent
	- In spring boot Hibernate is the default implementation for JPA
		- `EntityManager` is the main component for creating queries
		- `EntityManager` is from JPA

Entity Class
	- must be annotated with `@Entity`, must have a public or protected no-argument constructor (can have other constructors)
	- `@Table` annotation is optional too, if not provided, it has the same name as the class name, provide it for good coding practise
	- `@Column` is optional, if not provided it is the same name as the variable name, but good to write it, always write it
	- To get the primary key + auto increment feature, use the annotation, `@Id` followed by `@GeneratedValue(stratergy=GenerationType.IDENTITY)`
	- ID generation stratergies
		- GenerationType.AUTO
		- GenerationType.IDENTITY
		- GenerationType.SEQUENCE
		- GenerationType.TABLE
		- GenerationType.UUID
	- To create custom generation stratergy
		- create implementation of org.hibernate.id.IdentifierGenerator
		- Override the public method, public Serializable generate(...)
		

Saving Java Object with JPA
	- Flow: We need a **SudentDao** - responsible for interfacing with the database. DAO needs a JPA Entity Manager. Will have create(), getAll(), save() etc. functions defined to serve our purpose, **EntityManager** - Main component for saving and retrieving entities. Needs a Data Source for connecting to a database. DataSource contains connection information, DataSource
		- JPA Entity Manager and DataSource are automatically created by Spring Boot, base on information in application.properties files
		- We need to autowire/inject EntityManager into our Dao
	- StudentDAO <-> EntityManager <-> DataSource <-> Database
	- JPA Repository vs Entity Manager
		- EntityManager Use Cases
			1. Need low level control over DB Operations and write custom queries
			2. provide low level access to JPA and work directly with JPA entities
			3. Working with complex sql queries and stored procedure calls
			4. when you have complex requirements not easily handled by high-level abstractions
		- JPA Respository Use Cases
			1. Provides common CRUD operations out of the box, reducing amount of code you need to write
			2. Additional features like pagination and sorting
			3. generate queries based on method names
			4. Can also create custom queries using @Query 
		- Both can be used simultaneously in the same project
	- Working with DAO
		- Define DAO Iterface -> Define DAO Implementaion(Inject EntityManager) -> Update Main App
	- `@Transactional` annotation handles transaction management 
	- `@Repository` is a sub-annotation of the `@Component` annotation -> Use it on Dao Implementation class. Adds support for component scanning, and JDBC exception translation

Change the starting point of AUTO_INCREMENT
	- `ALTER TABLE student_tracker.student AUTO_INCREMENT=3000;`
	- Reset auto increment value to 1 
		`TRUNCATE student_tracker.student;` -> **will remove all data** and reset auto_increment to 1
	

Reading Value From DB
	- Flow: Update Dao Interface by adding a new method -> Implement the method in the Dao Implementation class 
	- No need for `@Transactional` since we are not updating/adding data to the database, we are just doing a query

Querying multiple values
	- using JPA Query Language'
	- All JPA query are based on Entity names and Entity fields(java objects) not the database table names and fields
	- JPA QL Named Params -> prefixed with a **:**
	- For strict JPAQL `SELECT` clause is required
		- e.g. `TypedQuery<Student> theQuery = entityManager.createQuery("SELECT s FROM Student s WHERE s.email LIKE 'google.com'", Student.class);`

Updating an Object
	- Flow: find the object using `entityManager.find()` -> use the setter method for updating -> Update using `entityManager.merge()`
	- To update last name for all students
		- e.g. `int rowsUpdated = entityManager.createQuery("UPDATE Student SET lastName='Tester'").executeUpdate();`