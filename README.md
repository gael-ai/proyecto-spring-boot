# 🚀 Proyecto Spring Boot

Proyecto Spring Boot completo con arquitectura MVC, MySQL, Spring Data JPA y API REST.

## 📋 Requisitos Previos

- ☕ **Java 17+** - [Descargar](https://www.oracle.com/java/technologies/downloads/)
- 🗄️ **MySQL 8.0+** - [Descargar](https://dev.mysql.com/downloads/mysql/)
- 📝 **VS Code** - [Descargar](https://code.visualstudio.com/)
- 🔨 **Maven** (Incluido en Spring Boot)

## 🛠️ Instalación y Configuración

### 1️⃣ Clonar el Repositorio

```bash
git clone https://github.com/tu-usuario/proyecto-spring-boot.git
cd proyecto-spring-boot
```

### 2️⃣ Crear la Base de Datos en MySQL

```sql
CREATE DATABASE bd_demo;
USE bd_demo;
```

### 3️⃣ Configurar Conexión a MySQL

Edita el archivo `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/bd_demo
spring.datasource.username=root
spring.datasource.password=tu_contraseña
```

### 4️⃣ Instalar Dependencias (Automático)

VS Code descargará automáticamente las dependencias de Maven al abrir el proyecto.

Si no lo hace automáticamente, ejecuta:

```bash
mvn clean install
```

### 5️⃣ Ejecutar la Aplicación

**Opción A - Desde VS Code:**
- Abre `src/main/java/com/ejemplo/ProyectoSpringApplication.java`
- Haz clic en el botón **"Run"** arriba del código

**Opción B - Desde Terminal:**

```bash
mvn spring-boot:run
```

**Opción C - Spring Boot Dashboard:**
- Presiona `Ctrl + Shift + P`
- Escribe: `Spring Boot Dashboard`
- Haz clic en el botón ▶️

### 6️⃣ Verificar que está Funcionando

Deberías ver algo como esto en la consola:

```
===============================================
✅ Aplicación Spring Boot iniciada correctamente
📍 URL: http://localhost:8080
📍 API Usuarios: http://localhost:8080/api/usuarios
===============================================
```

## 📚 Estructura del Proyecto

```
proyecto-spring-boot/
├── src/
│   ├── main/
│   │   ├── java/com/ejemplo/
│   │   │   ├── controller/        → Controladores REST
│   │   │   ├── service/           → Lógica de negocio
│   │   │   ├── repository/        → Acceso a datos
│   │   │   ├── model/             → Entidades
│   │   │   ├── config/            → Configuraciones
│   │   │   └── ProyectoSpringApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── application-dev.properties
│   └── test/
├── pom.xml                         → Dependencias Maven
├── .gitignore
└── README.md
```

## 🔌 API REST - Endpoints

### 📌 Usuarios

#### GET - Obtener todos los usuarios
```bash
curl http://localhost:8080/api/usuarios
```

#### GET - Obtener usuario por ID
```bash
curl http://localhost:8080/api/usuarios/1
```

#### GET - Buscar usuario por email
```bash
curl http://localhost:8080/api/usuarios/email/juan@example.com
```

#### GET - Buscar usuarios por nombre
```bash
curl http://localhost:8080/api/usuarios/buscar/Juan
```

#### POST - Crear nuevo usuario
```bash
curl -X POST http://localhost:8080/api/usuarios \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "Juan Pérez",
    "email": "juan@example.com",
    "telefono": "123456789"
  }'
```

#### PUT - Actualizar usuario
```bash
curl -X PUT http://localhost:8080/api/usuarios/1 \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "Juan Actualizado",
    "email": "juan.nuevo@example.com",
    "telefono": "987654321"
  }'
```

#### DELETE - Eliminar usuario
```bash
curl -X DELETE http://localhost:8080/api/usuarios/1
```

#### GET - Contar total de usuarios
```bash
curl http://localhost:8080/api/usuarios/stats/total
```

## 📊 Probar con Postman o Insomnia

### 1. Descargar Postman
https://www.postman.com/downloads/

### 2. Crear una colección:
- **GET** `http://localhost:8080/api/usuarios` → Obtener todos
- **POST** `http://localhost:8080/api/usuarios` → Crear usuario
- **PUT** `http://localhost:8080/api/usuarios/1` → Actualizar
- **DELETE** `http://localhost:8080/api/usuarios/1` → Eliminar

## 🔧 Dependencias Principales

```xml
✅ Spring Web           → APIs REST
✅ Spring Data JPA      → Acceso a BD
✅ MySQL Connector      → Driver MySQL
✅ Validation           → Validación de datos
✅ Spring Boot DevTools → Reinicio automático
✅ Lombok (opcional)    → Reducir boilerplate
```

## 📝 Notas Importantes

- ⚠️ Asegúrate que **MySQL esté corriendo** antes de iniciar la aplicación
- 🔑 Las credenciales por defecto son: usuario `root`, contraseña `123456`
- 🗄️ La base de datos `bd_demo` se crea automáticamente con Hibernate (`ddl-auto=update`)
- 💾 Las tablas se generan automáticamente desde las entidades
- 🐛 Revisa la consola para ver logs de Hibernate y SQL

## 🚀 Próximos Pasos

- [ ] Agregar más entidades (Productos, Órdenes, etc.)
- [ ] Implementar autenticación con JWT
- [ ] Agregar validaciones más complejas
- [ ] Crear tests unitarios
- [ ] Documentar con Swagger/OpenAPI
- [ ] Desplegar en la nube (Heroku, AWS, etc.)

## 📧 Contacto

Si tienes preguntas, abre un issue o contacta al equipo de desarrollo.

---

**¡Felicidades! Ahora tienes un proyecto Spring Boot completamente funcional.** 🎉