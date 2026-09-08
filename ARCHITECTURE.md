# Architecture

```
Browser → Next.js → Spring Boot REST API → PostgreSQL
                                      ↘ S3-compatible object storage
```

Next.js renders the public and admin interface and keeps only the access token in session storage. Spring Boot is authoritative for every business operation. A JWT filter establishes the authenticated principal; Spring Security and service checks enforce `SUPER_ADMIN`, `ADMIN`, `STAFF`, and `CUSTOMER` access. Product image records store external URLs, not image bytes.

