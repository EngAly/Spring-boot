### What is JWT used for?
* JSON Web tokens(JWT) is a standard for representing claims securely between two parties. It is quite secure because the JWT can be signed using a secret or public/private key.

### Spring Boot Security + JWT ''Hello World'' Example
* Learn how to secure your Spring Boot apps using a JSON Web Token.
* In this tutorial, we will be developing a Spring Boot application that makes use of JWT authentication for securing an exposed REST API. In this example, we will be making use of hard-coded user values for user authentication.
* Develop a Spring Boot application that exposes a simple REST GET API with mapping /hello.
* Configure Spring Security for JWT. Expose REST POST API with mapping/authenticate using which User will get a valid JSON Web Token.
### DataFlow when user request /hello EndPoint API
![alt text](https://www.javainuse.com/62-12-min.JPG "get token dataflow")


### Steps
* Create a Controller class for exposing a GET REST API (/hello EndPoint).   
* Create the bootstrap class with the SpringBoot annotation (Scratch Point)
* testing Go to localhost:8080/hello (it already open)

## Spring Security and JWT Configuration
* Generating JWT: Expose a POST API with mapping /authenticate. On passing the correct username and password, it will generate a JSON Web Token (JWT).
* Validating JWT: If a user tries to access the GET API with mapping /hello, it will allow access only if a request has a valid JSON Web Token (JWT).
* Generating JWT ![alt text](https://www.javainuse.com/62-2-min.JPG "JWT Flow")
* Validating JWT ![alt text](https://www.javainuse.com/62-3-min.JPG "Validating JWT")
* Add the Spring Security and JWT dependencies
### JWT Configuration Methods
* JwtTokenUtil => The JwtTokenUtil is responsible for performing JWT operations like creation and validation. It makes use of the io.jsonwebtoken.Jwts for achieving this.
### Controllers
* JwtAuthenticationController => Expose a POST API /authenticate using the JwtAuthenticationController. The POST API gets the username and password in the body. Using the Spring Authentication Manager, we authenticate the username and password. If the credentials are valid, a JWT token is created using the JWTTokenUtil and is provided to the client.
### Models
* JwtRequest => This class is required for storing the username and password we received from the client.
* JwtResponse => This class is required for creating a response containing the JWT to be returned to the user.
### Filters
* JwtRequestFilter => The JwtRequestFilter extends the Spring Web Filter OncePerRequestFilter class. For any incoming request, this Filter class gets executed. It checks if the request has a valid JWT token. If it has a valid JWT Token, then it sets the authentication in context to specify that the current user is authenticated.
### Configure Spring Security
* WebSecurityConfig => This class extends the WebSecurityConfigurerAdapter. This is a convenience class that allows customization to both WebSecurity and HttpSecurity.
### Testing 
* Then, start the Spring Boot application.
* Generate a JSON Web Token Create a POST request with URL localhost:8080/authenticate. The body should have a valid username and password. In our case, the username is javainuse and the password is password. 
* Validate the JSON Web Token Try accessing the URL localhost:8080/hello using the above-generated token in the header as follows:
    => key (Authorization)  value (Bearer token)
    
### Reference https://dzone.com/articles/spring-boot-security-json-web-tokenjwt-hello-world












