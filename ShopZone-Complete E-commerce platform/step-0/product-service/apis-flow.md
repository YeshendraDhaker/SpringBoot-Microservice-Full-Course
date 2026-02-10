# Product Service: API Endpoints Reference

---

## 📂 Category Management APIs

**1. Create Category (Admin)**
* **Endpoint:** `POST /api/categories`
* **Access:** Admin only
* **Description:** Creates a new category or subcategory

**2. Get All Categories**
* **Endpoint:** `GET /api/categories`
* **Access:** Public
* **Description:** Retrieves all categories with their hierarchy

**3. Get Active Categories**
* **Endpoint:** `GET /api/categories/active`
* **Access:** Public
* **Description:** Retrieves only categories where `isActive` is true

**4. Get Parent Categories**
* **Endpoint:** `GET /api/categories/parent`
* **Access:** Public
* **Description:** Retrieves only top-level categories (where `parent_id` is NULL)

**5. Get Subcategories**
* **Endpoint:** `GET /api/categories/{id}/subcategories`
* **Access:** Public
* **Description:** Retrieves all subcategories belonging to a specific parent ID

**6. Get Category By ID**
* **Endpoint:** `GET /api/categories/{id}`
* **Access:** Public
* **Description:** Retrieves detailed information for a single category

**7. Update Category (Admin)**
* **Endpoint:** `PUT /api/categories/{id}`
* **Access:** Admin only
* **Description:** Updates existing category details

**8. Delete Category (Admin)**
* **Endpoint:** `DELETE /api/categories/{id}`
* **Access:** Admin only
* **Description:** Deletes a category from the system (hard delete)

---

## 🏷️ Brand Management APIs

**9. Create Brand (Admin)**
* **Endpoint:** `POST /api/brands`
* **Access:** Admin only
* **Description:** Creates a new product brand

**10. Get All Brands**
* **Endpoint:** `GET /api/brands`
* **Access:** Public
* **Description:** Retrieves a list of all brands

**11. Get Active Brands**
* **Endpoint:** `GET /api/brands/active`
* **Access:** Public
* **Description:** Retrieves only brands that are currently marked as active

**12. Get Brand By ID**
* **Endpoint:** `GET /api/brands/{id}`
* **Access:** Public
* **Description:** Retrieves details for a specific brand

**13. Update Brand (Admin)**
* **Endpoint:** `PUT /api/brands/{id}`
* **Access:** Admin only
* **Description:** Updates existing brand information

**14. Delete Brand (Admin)**
* **Endpoint:** `DELETE /api/brands/{id}`
* **Access:** Admin only
* **Description:** Deletes a brand from the database

---

## 📱 Product Management APIs

**15. Create Product (Admin/Seller)**
* **Endpoint:** `POST /api/products`
* **Access:** Admin or Seller
* **Description:** Creates a new product including its images and variants

**16. Get Product By ID**
* **Endpoint:** `GET /api/products/{id}`
* **Access:** Public
* **Description:** Retrieves full product details, including images and variants

**17. Update Product (Admin/Seller)**
* **Endpoint:** `PUT /api/products/{id}`
* **Access:** Admin or Product Owner
* **Description:** Updates product information, pricing, or specifications

**18. Delete Product (Admin/Seller)**
* **Endpoint:** `DELETE /api/products/{id}`
* **Access:** Admin or Product Owner
* **Description:** Soft deletes a product by setting `is_active` to false

**19. Search Products (Advanced)**
* **Endpoint:** `GET /api/products/search`
* **Access:** Public
* **Description:** Advanced search with filtering (category, brand, price range) and pagination

**20. Get Products By Category**
* **Endpoint:** `GET /api/products/category/{categoryId}`
* **Access:** Public
* **Description:** Retrieves all products belonging to a specific category

**21. Get Products By Brand**
* **Endpoint:** `GET /api/products/brand/{brandId}`
* **Access:** Public
* **Description:** Retrieves all products belonging to a specific brand

**22. Get Featured Products**
* **Endpoint:** `GET /api/products/featured`
* **Access:** Public
* **Description:** Retrieves top-rated/featured products sorted by rating

**23. Get Trending Products**
* **Endpoint:** `GET /api/products/trending`
* **Access:** Public
* **Description:** Retrieves the most recently added products

---

## 🔗 Internal APIs (Inter-Service Communication)

**24. Get Product By ID (Internal)**
* **Endpoint:** `GET /internal/products/{id}`
* **Access:** Internal only
* **Description:** Used by Cart/Order services to fetch real-time pricing and details

**25. Get Products By IDs (Batch)**
* **Endpoint:** `POST /internal/products/batch`
* **Access:** Internal only
* **Description:** Retrieves a list of products based on an array of IDs (used for Cart checkout)

**26. Get Product By SKU (Internal)**
* **Endpoint:** `GET /internal/products/sku/{sku}`
* **Access:** Internal only
* **Description:** Retrieves specific product/variant details using its unique SKU
