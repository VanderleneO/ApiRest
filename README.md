# 🛠️ API de Soporte Técnico

## ✨ Sobre el Proyecto  
Este proyecto es una **API RESTful** construida con **Spring Boot 3** que funciona como el backend de un sistema de gestión de solicitudes de soporte técnico.  
Permite a los clientes enviar solicitudes y a los agentes de soporte **gestionar su ciclo de vida completo** (crear, leer, actualizar y eliminar).

---

## 🚀 Tecnologías Utilizadas  

<p align="left">
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" width="45" height="45" alt="Java"/> 
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg" width="45" height="45" alt="Spring Boot"/> 
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/maven/maven-original.svg" width="45" height="45" alt="Maven"/> 
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/mysql/mysql-original.svg" width="45" height="45" alt="H2/MySQL"/> 
</p>

- ☕ **Java 21 SE** – Lenguaje principal  
- 🍃 **Spring & Spring Boot** – Framework robusto para el desarrollo de APIs  
- 💾 **Spring Data JPA** – Interacción con la base de datos  
- 🗄️ **H2 Database** – Base de datos en memoria para desarrollo y pruebas  
- 📦 **Maven** – Gestión de dependencias y ciclo de vida del proyecto  

---

## ⚙️ Endpoints de la API  

La API sigue principios **REST** y expone los siguientes endpoints:

### ➕ Crear una nueva solicitud
- **Método:** `POST`  
- **URL:** `/solicitudes`  
- **Body (JSON):**
```json
{
  "title": "Problema con la impresora",
  "description": "La impresora no enciende.",
  "status": "Pendiente",
  "assignee": "equipo-TI"
}
Respuesta: 201 Created + objeto creado

📋 Obtener todas las solicitudes
Método: GET

URL: /solicitudes

Respuesta: 200 OK + lista de solicitudes

🔍 Obtener una solicitud por ID
Método: GET

URL: /solicitudes/{id}

Respuesta: 200 OK si existe, 404 Not Found si no

✏️ Actualizar una solicitud
Método: PUT

URL: /solicitudes/{id}

Body (JSON): Campos a actualizar

Respuesta: 200 OK o 404 Not Found

🗑️ Eliminar una solicitud
Método: DELETE

URL: /solicitudes/{id}

Regla: Solo si status = "Atendida"

Respuestas:

204 No Content – Eliminada

403 Forbidden – No cumple la regla

404 Not Found – No existe

💻 Cómo Ejecutar el Proyecto
Clonar el repositorio:

bash
Copiar código
git clone <url-del-repo>
Navegar al directorio del proyecto:

bash
Copiar código
cd soporte-api
Ejecutar con Maven:

bash
Copiar código
./mvnw spring-boot:run   # Linux / Mac
mvnw.cmd spring-boot:run # Windows
Acceder en: 👉 http://localhost:8080


## 👨‍💻 Autor  
**Vanderlene Oliveira**