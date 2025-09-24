# ShopSetup Spring Boot Project

## 1. Project Overview
**ShopSetup** is a Spring Boot application that manages products in a shop.  
It demonstrates **CRUD operations** (Create, Read, Update, Delete) on products using a **layered architecture** with **Spring Boot, Spring Data JPA, Hibernate, and H2 database**.

Key features:
- Add, update, delete, and fetch products
- Uses **H2 database** for persistence
- RESTful APIs using **Spring MVC**
- Clean separation of layers: **Controller → Service → Repository**
- Hibernate ORM for mapping Java objects to database tables

---

## 2. How the Project Works (Flow)

### 🔹 Layered Architecture
The project follows the **typical Spring Boot layered architecture**:


1. **Controller Layer** (`@RestController`)
   - Handles **HTTP requests** from clients (like Postman or frontend apps).  
   - Maps URL endpoints using annotations like `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping`.  
   - Calls **Service layer** for business logic.

2. **Service Layer** (`@Service`)
   - Contains **business logic**.  
   - Processes data, performs validations, and interacts with the **Repository layer**.  
   - Makes the Controller cleaner and focused only on handling HTTP requests.

3. **Repository Layer** (`@Repository` / `JpaRepository`)
   - Responsible for **database access**.  
   - Provides methods like `save()`, `findAll()`, `findById()`, `deleteById()`.  
   - Uses **Spring Data JPA** to generate queries automatically.

---

### 🔹 Request Flow Example
**Adding a Product**:
1. Client sends POST request to `/products` with JSON data.
2. Controller receives request and calls `ProductService.addproduct()`.
3. Service calls `ProductRepo.save()`.
4. Hibernate maps the `Product` object to a database row in **H2**.
5. Product is stored and returned as JSON response.

---

## 3. Key Annotations

| Annotation | Layer | Purpose |
|------------|-------|---------|
| `@SpringBootApplication` | Main | Marks the entry point of the Spring Boot app |
| `@RestController` | Controller | Handles HTTP requests and responses |
| `@RequestMapping` / `@GetMapping` / `@PostMapping` / `@PutMapping` / `@DeleteMapping` | Controller | Maps HTTP methods and URLs |
| `@Service` | Service | Marks a class as a Service component |
| `@Repository` | Repository | Marks a class as a Repository (DAO layer) |
| `@Entity` | Model | Marks a class as a database entity |
| `@Id` | Model | Marks primary key field |
| `@GeneratedValue` | Model | Auto-generates primary key values |
| `@Autowired` | Any layer | Injects Spring-managed beans automatically |
| Lombok annotations (`@Data`, `@AllArgsConstructor`, `@NoArgsConstructor`) | Model | Generates getters, setters, constructors, `toString`, `equals`, etc. |

---

## 4. ORM (Object Relational Mapping)
- ORM is the process of **mapping Java objects to database tables**.  
- In this project, **Hibernate** is the ORM framework used.  
- It allows you to work with **Java objects** instead of writing raw SQL queries.

---

## 5. JPA (Java Persistence API)
- JPA is a **specification** for managing relational data in Java.  
- Provides:
  - **Entity management** (`@Entity`)  
  - **Repositories** (`JpaRepository`)  
  - Query methods like `findById()`, `save()`, `deleteById()`
- Hibernate is a **JPA implementation**.

---

## 6. Hibernate
- Hibernate is an **ORM framework** that implements JPA.  
- Features in this project:
  - Maps `Product` class to `PRODUCT` table in H2 database
  - Automatically generates SQL queries
  - Manages entity lifecycle
  - Supports auto-increment IDs using `@GeneratedValue`

---

## 7. H2 Database
- Lightweight, **in-memory or file-based database**.
- URL examples:
  - In-memory: `jdbc:h2:mem:shopdb` → resets on every restart
  - File-based: `jdbc:h2:file:./data/shopdb` → persists across restarts
- Spring Boot automatically creates tables based on `@Entity` classes.
- H2 console can be accessed at `/h2-console` for testing.

---
