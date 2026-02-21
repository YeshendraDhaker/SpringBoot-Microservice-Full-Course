# Complete Cart Flow

## 🛒 Flow 1: Customer Adds Items to Cart

---

### Step 1: User Browses Products
* **Action:** John is on the Product Listing Page.
* **Context:** Sees "iPhone 15 Pro - ₹1,37,555" and clicks **"Add to Cart"**.

### Step 2: Frontend Calls Cart API
* **Action:** `POST /api/cart/items`
* **Internal Process ("What Happens"):**
    1.  **Auth Validation:** Cart Service validates JWT token and extracts `userId` (userId = 1).
    2.  **Cart Check:** Checks if user has an existing cart. If **NO**, a new cart is created.
    3.  **Service Discovery:** Calls Product Service (`GET /internal/products/502`) to fetch real-time data.
    4.  **Validation:**
        * Ensures product exists and is marked as active.
        * Ensures specific variant exists and has stock available.
    5.  **Persistence:** Creates a `cart_items` record with the following snapshot:
        * `cart_id`: 1
        * `product_id`: 502
        * `variant_id`: 5022
        * `quantity`: 1
        * `price_at_addition`: 137555.00
* **Result:** Returns updated cart with 1 item and calculated totals.

---

### Step 3: User Adds Another Product
* **Action:** `POST /api/cart/items` (Product 503, No Variant)
* **Internal Process ("What Happens"):**
    1.  **Cart Check:** Recognizes user already has `cart_id = 1`.
    2.  **Service Discovery:** Calls Product Service for product 503.
    3.  **Update Logic:** Adds a new item entry to the existing cart.
    4.  **Recalculation:** Updates `itemCount`, `totalItems`, and `total` price.
* **Result:** Returns updated cart with 2 unique items.

---

### Step 4: User Increases Quantity
* **Action:** `PUT /api/cart/items/1`
* **Internal Process ("What Happens"):**
    1.  **Ownership Check:** Finds `cart_item` with ID 1 and verifies it belongs to the authenticated user's cart.
    2.  **Stock Validation:** Calls Product Service to verify if the requested quantity (2) is available (Current stock: 30).
    3.  **Update:** Since stock is available, the quantity is updated from 1 to 2.
    4.  **Math:** Recalculates item subtotal ($137,555 \times 2 = 275,110$) and the overall cart total.
* **Result:** Returns updated cart reflecting the new quantity and increased total.
