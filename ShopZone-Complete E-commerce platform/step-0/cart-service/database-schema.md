## Overview
* **Service Name:** Cart Service
* **Port:** 8083
* **Purpose:** Shopping cart management, add/remove items, calculate totals, apply discounts
* **Database:** PostgreSQL (`shopzone_carts`)

---

## Database Schema & ER Diagram

### Table 1: `carts`
Stores shopping cart information for users.

| Column | Type | Constraints | Description |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PRIMARY KEY, AUTO_INCREMENT | Unique cart identifier |
| `user_id` | BIGINT | UNIQUE, NOT NULL | User reference (from User Service) |
| `created_at` | TIMESTAMP | AUTO | Cart creation timestamp |
| `updated_at` | TIMESTAMP | AUTO | Last update timestamp |

**Business Rules:**
* One cart per user (`user_id` is UNIQUE)
* Cart persists even after logout
* Cart items stored in separate table

---

### Table 2: `cart_items`
Stores individual items in a cart.

| Column | Type | Constraints | Description |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PRIMARY KEY, AUTO_INCREMENT | Unique cart item identifier |
| `cart_id` | BIGINT | FOREIGN KEY → carts(id), NOT NULL | Cart reference |
| `product_id` | BIGINT | NOT NULL | Product reference (from Product Service) |
| `variant_id` | BIGINT | NULL | Product variant reference (if applicable) |
| `quantity` | INT | NOT NULL, CHECK > 0 | Item quantity |
| `price_at_addition`| DECIMAL(10,2) | NOT NULL | Product price when added (snapshot) |
| `created_at` | TIMESTAMP | AUTO | Item added timestamp |
| `updated_at` | TIMESTAMP | AUTO | Last update timestamp |

**Composite Unique Constraint:** (`cart_id`, `product_id`, `variant_id`) - Prevents duplicate items.

**Why `price_at_addition`?**
* Product prices can change.
* We store the price when the item was added.
* User sees consistent pricing during checkout.
