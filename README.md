# SR ENTERPRISES

A lightweight, formal e-commerce platform. The Next.js storefront talks only to a Spring Boot REST API; Spring Boot owns authentication, authorization, pricing, inventory and orders.

## Run locally

1. Copy `.env.example` to `.env` and set a strong `JWT_SECRET` and `INITIAL_ADMIN_PASSWORD`.
2. Run `docker compose up -d postgres`.
3. Backend: `cd backend && mvn spring-boot:run` (Java 21 and Maven required).
4. Frontend: `cd frontend && npm install && npm run dev`.

Frontend is at `http://localhost:3000`; API health is at `http://localhost:8080/api/health`.

## Structure

- `backend/` Spring Boot API, Flyway migrations and JPA persistence
- `frontend/` Next.js App Router storefront and admin UI

## Environment

`DATABASE_URL`, `DATABASE_USERNAME`, `DATABASE_PASSWORD`, `JWT_SECRET`, `INITIAL_ADMIN_EMAIL`, `INITIAL_ADMIN_PASSWORD`, and `CORS_ALLOWED_ORIGINS` configure the API. Storage variables are reserved for an S3-compatible upload provider. Never commit `.env` files.

## Deployment

Deploy `frontend` on Vercel with `NEXT_PUBLIC_API_URL` set to the API URL. Deploy `backend` as a Java 21 service with PostgreSQL environment variables. Flyway runs migrations automatically at startup. Configure CORS to the Vercel origin.

## Security

Passwords use BCrypt; JWTs are signed server-side; role checks occur at endpoint and service boundaries. DTOs prevent entity exposure. Prices and stock are recalculated in a database transaction during checkout.

## Implemented API groups

- `POST /api/auth/register`, `POST /api/auth/login`
- `GET /api/products`, `GET /api/products/{slug}`, privileged `POST /api/products`
- `GET /api/categories`
- Authenticated `POST /api/orders`, `GET /api/orders`, `GET /api/orders/{id}`
- Privileged `/api/admin/orders`, `/api/admin/inventory`, `/api/admin/users`, and `/api/admin/audit-logs`

Order creation takes only product IDs and quantities from the client. The server locks inventory, loads the active product price, persists the order, creates inventory history, and emits an audit record in one transaction.
