# DOCTOR-PATIENT SUGGESTION SYSTEM

This is a Spring Boot application that provides a Doctor-Patient Suggestion System. The application uses Hibernate for database operations and provides RESTful APIs to manage doctors and patients, and to suggest doctors based on patient symptoms and location.

# PROJECT OVERVIEW 

The Doctor-Patient Suggestion System consists of the following features:
-> Add, retrieve, update, and delete doctors and patients.
-> Suggest doctors based on patient symptoms and location.
-> Handle edge cases where no doctors are available for a particular symptom or location.

# TECHNOLOGY USED

-> Spring Boot 3.x
-> Hibernate (JPA)
-> H2 Database
-> Postman (for testing APIs)

# SCREENSHOTS

![Screenshot (11)](https://github.com/harshit8756/Java_Assignment_Project/assets/113333121/dafd6175-f984-4c08-a512-8887a3f68ff2)
![Screenshot (14)](https://github.com/harshit8756/Java_Assignment_Project/assets/113333121/d4f96f85-8626-4f1b-8496-b6af9d242c58)
![Screenshot (12)](https://github.com/harshit8756/Java_Assignment_Project/assets/113333121/a7a4adb7-48e0-47e6-b8e9-3d6dbc85f503)
![Screenshot (13)](https://github.com/harshit8756/Java_Assignment_Project/assets/113333121/e48ef39d-c74e-4704-8964-5574c6110dfe)

# EXPLANATION OF ANNOTATIONS
@Entity
Marks a class as a JPA entity, which means it maps to a table in the database.

@Id
Marks a field as the primary key of the entity.

@GeneratedValue
Specifies how the primary key should be generated. Common strategies include IDENTITY, AUTO, SEQUENCE, and TABLE.

@Autowired
Allows Spring to resolve and inject collaborating beans into your bean.

@Service
Marks a class as a service provider, which holds the business logic.

@Repository
Indicates that the class is a repository, which encapsulates the storage, retrieval, and search behavior.

@RestController
Marks a class as a controller where every method returns a domain object instead of a view.

@RequestMapping
Used to map web requests onto specific handler classes and/or handler methods.

@PostMapping
Handles HTTP POST requests.

@GetMapping
Handles HTTP GET requests.

@PutMapping
Handles HTTP PUT requests.

@DeleteMapping
Handles HTTP DELETE requests.

@PathVariable
Indicates that a method parameter should be bound to a URI template variable.

@RequestBody
Indicates that a method parameter should be bound to the body of the web request.

@Valid
Indicates that the annotated parameter should be validated.

@SpringBootApplication
Marks the main class of a Spring Boot application. It combines @Configuration, @EnableAutoConfiguration, and @ComponentScan with their default attributes.

# CONCLUSION 
This Spring Boot project demonstrates a Doctor-Patient Suggestion System with RESTful APIs for managing doctors and patients and suggesting doctors based on patient symptoms and location. The project is set up with H2 Database for persistence and uses Hibernate for ORM. You can easily test the APIs using Postman with the provided examples.

# EXAMPLES 
Add a Doctor

URL: POST /api/doctors
Body:
json
Copy code
{
  "name": "Dr. John Doe",
  "speciality": "Orthopaedic",
  "city": "Delhi",
  "phone": "1234567890",
  "email": "johndoe@example.com"
}
Example:
bash
Copy code
curl -X POST http://localhost:8080/api/doctors -H "Content-Type: application/json" -d '{"name":"Dr. John Doe","speciality":"Orthopaedic","city":"Delhi","phone":"1234567890","email":"johndoe@example.com"}'
Retrieve All Doctors

URL: GET http://localhost:8080/api/doctors

Retrieve a Doctor by ID
URL: GET /api/doctors/{id}

Update a Doctor
URL: PUT /api/doctors/{id}
Body:
json
Copy code
{
  "name": "Dr. Jane Doe",
  "speciality": "Dermatology",
  "city": "Noida",
  "phone": "0987654321",
  "email": "janedoe@example.com"
}




 
