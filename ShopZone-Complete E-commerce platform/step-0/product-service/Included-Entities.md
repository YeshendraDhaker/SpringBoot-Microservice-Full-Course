# Service Overview: Product Service

* **Port:** 8082
* **Purpose:** Product catalog management, categories, brands, search, and inventory information
* **Database:** MySQL (`shopzone_products`)

---

## Database Schema & ER Diagram

### Table 1: categories
Stores product categories (hierarchical structure).

| Column | Type | Constraints | Description |
| :--- | :--- | :--- | :--- |
| **id** | BIGINT | PRIMARY KEY, AUTO_INCREMENT | Unique category identifier |
| **name** | VARCHAR(100) | UNIQUE, NOT NULL | Category name (e.g., "Electronics") |
| **description** | TEXT | NULL | Category description |
| **image_url** | VARCHAR(500) | NULL | Category image |
| **is_active** | BOOLEAN | DEFAULT TRUE | Active status |
| **parent_id** | BIGINT | FOREIGN KEY → `categories(id)` | Parent category (for subcategories) |
| **created_at** | TIMESTAMP | AUTO | Creation timestamp |
| **updated_at** | TIMESTAMP | AUTO | Last update timestamp |

**Example Hierarchy:**
* Electronics (parent_id = NULL)
    * Smartphones (parent_id = 1)
    * Laptops (parent_id = 1)
* Fashion (parent_id = NULL)
    * Men's Clothing (parent_id = 2)
    * Women's Clothing (parent_id = 2)

---

### Table 2: brands
Stores product brands.

| Column | Type | Constraints | Description |
| :--- | :--- | :--- | :--- |
| **id** | BIGINT | PRIMARY KEY, AUTO_INCREMENT | Unique brand identifier |
| **name** | VARCHAR(100) | UNIQUE, NOT NULL | Brand name (e.g., "Apple", "Samsung") |
| **description** | TEXT | NULL | Brand description |
| **logo_url** | VARCHAR(500) | NULL | Brand logo URL |
| **is_active** | BOOLEAN | DEFAULT TRUE | Active status |
| **created_at** | TIMESTAMP | AUTO | Creation timestamp |
| **updated_at** | TIMESTAMP | AUTO | Last update timestamp |

---

### Table 3: products
Stores main product information.

| Column | Type | Constraints | Description |
| :--- | :--- | :--- | :--- |
| **id** | BIGINT | PRIMARY KEY, AUTO_INCREMENT | Unique product identifier |
| **name** | VARCHAR(255) | NOT NULL | Product name |
| **description** | TEXT | NULL | Product description |
| **category_id** | BIGINT | FOREIGN KEY → `categories(id)`, NOT NULL | Category reference |
| **brand_id** | BIGINT | FOREIGN KEY → `brands(id)` | Brand reference |
| **base_price** | DECIMAL(10,2) | NOT NULL | Base price before discount |
| **discount_percentage** | DECIMAL(5,2) | DEFAULT 0 | Discount % (0-100) |
| **sku** | VARCHAR(100) | UNIQUE, NOT NULL | Stock Keeping Unit (unique code) |
| **is_active** | BOOLEAN | DEFAULT TRUE | Active status |
| **specifications** | TEXT | NULL | Product specifications (JSON or text) |
| **average_rating** | DECIMAL(3,2) | DEFAULT 0 | Average customer rating (0-5) |
| **review_count** | INT | DEFAULT 0 | Total number of reviews |
| **created_at** | TIMESTAMP | AUTO | Creation timestamp |
| **updated_at** | TIMESTAMP | AUTO | Last update timestamp |

> **Calculated Field (Not stored):**
> `final_price = base_price - (base_price × discount_percentage / 100)`

---

### Table 4: product_images
Stores product images (multiple images per product).

| Column | Type | Constraints | Description |
| :--- | :--- | :--- | :--- |
| **id** | BIGINT | PRIMARY KEY, AUTO_INCREMENT | Unique image identifier |
| **product_id** | BIGINT | FOREIGN KEY → `products(id)`, NOT NULL | Product reference |
| **image_url** | VARCHAR(500) | NOT NULL | Image URL |
| **is_primary** | BOOLEAN | DEFAULT FALSE | Primary/featured image flag |
| **display_order** | INT | DEFAULT 0 | Display order (0, 1, 2...) |

**Business Rule:** Only one image per product can have `is_primary = true`.

---

### Table 5: product_variants
Stores product variants (color, size, storage, etc.).

| Column | Type | Constraints | Description |
| :--- | :--- | :--- | :--- |
| **id** | BIGINT | PRIMARY KEY, AUTO_INCREMENT | Unique variant identifier |
| **product_id** | BIGINT | FOREIGN KEY → `products(id)`, NOT NULL | Product reference |
| **variant_name** | VARCHAR(100) | NOT NULL | Variant name (e.g., "iPhone 15 Pro - 256GB - Blue") |
| **sku** | VARCHAR(100) | UNIQUE, NOT NULL | Variant SKU |
| **price** | DECIMAL(10,2) | NULL | Variant-specific price (overrides base price) |
| **attributes** | JSON | NULL | Variant attributes: `{"color": "Blue", "storage": "256GB"}` |
| **stock_quantity** | INT | DEFAULT 0 | Available stock |
| **is_available** | BOOLEAN | DEFAULT TRUE | Availability status |
