# API Endpoints

## 🛒 Cart Management APIs (Public)

### 1. Get Current User's Cart
* **Endpoint:** `GET /api/cart`
* **Access:** Authenticated (requires JWT)
* **Headers:** `Authorization: Bearer <token>` or `Cookie: accessToken=<token>`
* **Description:** Retrieves current user's cart with all items and calculated totals.
* **Calculated Fields:**
    * `itemCount`: Number of unique products.
    * `totalItems`: Total quantity of all items combined.
    * `subtotal`: Sum of all item subtotals.
    * `total`: `subtotal` + `tax` - `discount`.

---

### 2. Add Item to Cart
* **Endpoint:** `POST /api/cart/items`
* **Access:** Authenticated
* **Description:** Adds a product/variant to cart or increases quantity if already exists.
* **What Happens:**
    1.  **Auth Check:** Validates user is authenticated.
    2.  **External Call:** Calls Product Service for current price and details.
    3.  **Product Validation:** Validates product exists and is active.
    4.  **Variant Validation:** Validates `variantId` if provided.
    5.  **Stock Check:** Checks real-time stock availability.
    6.  **Persistence:** Creates a new cart if the user doesn't have one.
    7.  **Logic:** If item exists → increments quantity; if new → adds with current snapshot price.
* **Error Responses:** * `404 Not Found`: Product not found.
    * `400 Bad Request`: Product out of stock or quantity exceeds available stock.

---

### 3. Update Cart Item Quantity
* **Endpoint:** `PUT /api/cart/items/{itemId}`
* **Access:** Authenticated
* **Path Parameter:** `itemId` - Cart item ID.
* **Business Logic:**
    * If **quantity = 0** → Remove item from cart.
    * If **quantity > available stock** → Return error.
    * **Recalculation:** Updates the specific item and triggers a total cart recalculation.

---

### 4. Remove Item from Cart
* **Endpoint:** `DELETE /api/cart/items/{itemId}`
* **Access:** Authenticated
* **Description:** Removes a specific item from the cart.

---

### 5. Clear Cart
* **Endpoint:** `DELETE /api/cart`
* **Access:** Authenticated
* **Description:** Removes all items from the cart (the cart record itself remains).
* **Use Case:** Triggered manually or after successful order placement.

---

### 6. Sync Cart Prices
* **Endpoint:** `POST /api/cart/sync-prices`
* **Access:** Authenticated
* **Description:** Updates all cart items with current product prices from the Product Service.
* **When to Call:** * Right before checkout.
    * When a user returns to an old session.
    * Manual refresh by user.

---

### 7. Validate Cart (Pre-Checkout)
* **Endpoint:** `POST /api/cart/validate`
* **Access:** Authenticated
* **Description:** Comprehensive validation of stock, price changes, and product status.
* **Issue Types:**
    | Issue | Description |
    | :--- | :--- |
    | `OUT_OF_STOCK` | Product no longer available. |
    | `INSUFFICIENT_STOCK` | Not enough quantity (requested vs available). |
    | `PRICE_CHANGED` | Price increased/decreased since addition. |
    | `PRODUCT_INACTIVE` | Product deactivated by admin. |
    | `VARIANT_UNAVAILABLE` | Specific variant is out of stock. |

---

## 🔗 Internal APIs (For Order Service)

### 8. Get Cart By User ID (Internal)
* **Endpoint:** `GET /internal/cart/user/{userId}`
* **Access:** Internal only (Feign Client)
* **Description:** Retrieves cart for a specific user to process an order.

### 9. Clear Cart After Order (Internal)
* **Endpoint:** `POST /internal/cart/user/{userId}/clear`
* **Access:** Internal only
* **Description:** Clears the cart automatically after the Order Service confirms successful placement.
