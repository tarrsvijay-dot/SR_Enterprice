# SR ENTERPRISES — Project Explanation

## Problem and objective
The project gives SR ENTERPRISES a secure online catalogue and ordering system while providing staff controlled stock and order operations. Its objective is to prevent incorrect pricing, overselling, and unauthorized administration.

## Key concepts
- **Spring Boot** provides the REST API and dependency-managed backend.
- **REST API** is the HTTP contract between the web app and backend.
- **PostgreSQL/JPA/Hibernate** persist normalized users, products, inventory, orders and logs.
- **JWT** is a signed short-lived authentication token sent with requests.
- **RBAC** grants actions based on roles, not merely hidden UI controls.
- **Inventory** changes are recorded as transactions for traceability.
- **Audit logging** records important administrative actions without secrets.

## Viva questions
**Why not trust prices from the browser?** A browser can be altered, so checkout looks up product prices again on the server.  
**Why use transactions for orders?** The stock check, decrement and order insert succeed together or all roll back.  
**Why DTOs?** They expose a stable, safe API shape instead of persistence internals.  
**How are passwords protected?** BCrypt stores a one-way hash; plaintext is never persisted.

