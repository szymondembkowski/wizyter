Elektroniczny System Zarządzania Wizytami Lekarskimi
Aplikacja umożliwia pacjentom rezerwację wizyt u lekarzy oraz lekarzom zarządzanie swoim harmonogramem. Jest to proste REST API stworzone przy użyciu Spring Boot 3, które umożliwia komunikację z aplikacją za pomocą zapytań HTTP. Aplikacja jest zaprojektowana w taki sposób, aby można było testować ją za pomocą narzędzi takich jak Postman.

Technologie
Backend:

Java – język programowania
Spring Boot 3 – framework do budowy aplikacji webowych
Hibernate / JPA – do mapowania obiektów na relacyjne bazy danych
MySQL – baza danych
REST API – komunikacja z aplikacją przez HTTP
Git – system kontroli wersji


Endpointy API:
Aplikacja udostępnia API umożliwiające wykonywanie operacji CRUD (tworzenie, odczyt, aktualizacja, usuwanie) na zasobach takich jak pacjenci, lekarze, wizyty i specjalizacje.

Pacjenci (/api/patients)
GET /api/patients – Zwraca listę wszystkich pacjentów.
POST /api/patients – Tworzy nowego pacjenta.
GET /api/patients/{id} – Zwraca szczegóły pacjenta o podanym ID.
PUT /api/patients/{id} – Aktualizuje dane pacjenta.
DELETE /api/patients/{id} – Usuwa pacjenta.

Lekarze (/api/doctors)
GET /api/doctors – Zwraca listę wszystkich lekarzy.
POST /api/doctors – Tworzy nowego lekarza.
GET /api/doctors/{id} – Zwraca dane lekarza o podanym ID.
PUT /api/doctors/{id} – Aktualizuje dane lekarza.
DELETE /api/doctors/{id} – Usuwa lekarza.

Wizyty (/api/appointments)
GET /api/appointments – Zwraca listę wszystkich wizyt.
POST /api/appointments – Tworzy nową wizytę dla pacjenta u lekarza.

Specjalizacje (/api/specialties)
GET /api/specialties – Zwraca listę wszystkich dostępnych specjalizacji.
POST /api/specialties – Tworzy nową specjalizację.
GET /api/specialties/{id} – Zwraca szczegóły specjalizacji.
PUT /api/specialties/{id} – Aktualizuje specjalizację.
DELETE /api/specialties/{id} – Usuwa specjalizację.


Przykładowe zapytania
GET /api/patients
Zwróci wszystkich pacjentów:

GET http://localhost:8080/api/patients
POST /api/patients
Utworzy nowego pacjenta:

POST http://localhost:8080/api/patients
Content-Type: application/json

{
  "name": "Anna Nowak",
  "email": "anna.nowak@example.com"
}
POST /api/appointments
Utworzy nową wizytę:

POST http://localhost:8080/api/appointments
Content-Type: application/json

{
  "patientId": 1,
  "doctorId": 2,
  "appointmentDate": "2025-04-15T14:00:00"
}
