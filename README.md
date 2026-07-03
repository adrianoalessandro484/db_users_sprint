# db_users — Microservicio de Perfiles / Sastres

## ¿Qué hace?
Gestiona los **perfiles de usuario** (maestros y sastres/trabajadores) del taller.
Es la réplica de la tabla `profiles` de Supabase, pero ahora vive en su propia BD `db_users`.

## Stack
- Spring Boot 4.1.0
- Spring Web MVC
- Spring Data JPA + Hibernate
- Spring Cloud Netflix Eureka (cliente)

## Base de datos
- Contenedor: `erp-db-users-postgres` (postgres:16-alpine)
- DB: `db_users` (puerto host `5434` → contenedor `5432`)
- Usuario: `adriano` / Password: `password123`

## Tablas que crea
- `profiles` (id UUID, email UNIQUE, full_name, role, especialidades, carga_max, activo, created_at)

## Endpoints
| Método | Ruta                          | Descripción                       |
|--------|-------------------------------|-----------------------------------|
| GET    | `/api/profiles`               | Lista todos los perfiles          |
| GET    | `/api/profiles?role=maestro`  | Filtra por rol                    |
| GET    | `/api/profiles/{id}`          | Obtiene un perfil por id          |
| POST   | `/api/profiles`               | Crea un perfil                    |
| PUT    | `/api/profiles/{id}`          | Actualiza un perfil               |
| DELETE | `/api/profiles/{id}`          | Elimina un perfil                 |
| GET    | `/api/profiles/health`        | Healthcheck                       |

## Cómo levantarlo
```bash
./mvnw clean package -DskipTests
docker compose up -d
```
Esto levanta Postgres (`5434`) y el microservicio (`8082`) juntos.

## Puerto
`8082`