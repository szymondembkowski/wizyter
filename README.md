# Medical Appointment Management System

A RESTful API application that allows **patients to book appointments** with doctors and **doctors to manage their schedules**. Built with **Spring Boot 3**, this backend system supports HTTP requests for performing various operations and can be easily tested using tools like **Postman**.

---

## 🔧 Technologies Used

### Backend
- **Java** – core programming language
- **Spring Boot 3** – backend framework
- **Hibernate / JPA** – ORM for database interaction
- **MySQL** – relational database
- **REST API** – HTTP-based communication
- **Git** – version control

---

## 📡 API Endpoints

The API provides **CRUD operations** for the following resources: `Patients`, `Doctors`, `Appointments`, and `Specialties`.

### 🧍 Patients (`/api/patients`)
- `GET /api/patients` – Returns all patients  
- `POST /api/patients` – Creates a new patient  
- `GET /api/patients/{id}` – Returns details of a patient by ID  
- `PUT /api/patients/{id}` – Updates patient data  
- `DELETE /api/patients/{id}` – Deletes a patient  

### 👨‍⚕️ Doctors (`/api/doctors`)
- `GET /api/doctors` – Returns all doctors  
- `POST /api/doctors` – Creates a new doctor  
- `GET /api/doctors/{id}` – Returns doctor details by ID  
- `PUT /api/doctors/{id}` – Updates doctor data  
- `DELETE /api/doctors/{id}` – Deletes a doctor  

### 📅 Appointments (`/api/appointments`)
- `GET /api/appointments` – Returns all appointments  
- `POST /api/appointments` – Creates a new appointment  

### 🩺 Specialties (`/api/specialties`)
- `GET /api/specialties` – Returns all specialties  
- `POST /api/specialties` – Creates a new specialty  
- `GET /api/specialties/{id}` – Returns details of a specialty  
- `PUT /api/specialties/{id}` – Updates a specialty  
- `DELETE /api/specialties/{id}` – Deletes a specialty  

---

## 📌 Example Requests

### `GET /api/patients`

Returns all patients:
```http
GET http://localhost:8080/api/patients

POST http://localhost:8080/api/patients
Content-Type: application/json

{
  "name": "Anna Nowak",
  "email": "anna.nowak@example.com"
}



