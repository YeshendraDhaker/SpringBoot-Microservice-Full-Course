## ER Diagram

```text
┌─────────────────┐
│     carts       │
├─────────────────┤
│ id (PK)         │
│ user_id (UQ)    │────► References User Service (user_id)
│ created_at      │
│ updated_at      │
└─────────────────┘
        │
        │ 1
        │
        │ N
        ▼
┌─────────────────┐
│   cart_items    │
├─────────────────┤
│ id (PK)         │
│ cart_id (FK)    │
│ product_id      │────► References Product Service (product_id)
│ variant_id      │────► References Product Service (variant_id)
│ quantity        │
│ price_at_add    │
│ created_at      │
│ updated_at      │
└─────────────────┘
```
## External References (via Feign Client)

### User Service
**Port:** 8081

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `GET` | `/internal/users/{userId}` | Fetch user details for cart validation |

---

### Product Service
**Port:** 8082

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `GET` | `/internal/products/{id}` | Fetch single product details |
| `POST` | `/internal/products/batch` | Fetch details for multiple products (Bulk) |
