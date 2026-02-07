# Complete User Flow

---

## Flow 1: New Customer Registration & Login 🎯

### Step 1: Customer Registers

- **Endpoint:** `POST /api/auth/register`
- **Service:** User Service

**What Happens:**
- User Service validates email format and uniqueness
- Password is encrypted using BCrypt
- User record created with `isActive = true`
- Default role `ROLE_CUSTOMER` is assigned
- Record saved in `users` table
- User-role mapping created in `user_roles` table

---

### Step 2: Customer Logs In

- **Endpoint:** `POST /api/auth/login`
- **Service:** User Service

**What Happens:**
- User Service finds user by email
- Password verified using BCrypt
- JWT access token generated (15 minutes expiry)
- JWT refresh token generated (7 days expiry)
- JWT contains user ID, email, and roles
- User details returned to client

---

### Step 3: Customer Adds Delivery Address

- **Endpoint:** `POST /api/users/addresses`
- **Access:** Authenticated

**What Happens:**
- JWT token validated
- User ID extracted from token
- Address record created and linked to user
- If `isDefault = true`, all other addresses set to non-default
- Address saved in `addresses` table

---

### Step 4: Customer Views Profile

- **Endpoint:** `GET /api/users/profile`
- **Access:** Authenticated

**What Happens:**
- JWT token validated
- User ID extracted from token
- User record fetched
- Roles and addresses loaded
- Profile details returned

---

## Flow 2: Seller Registration 🏪

### Step 1: Seller Registers

- **Endpoint:** `POST /api/auth/register`
- **Service:** User Service

**What Happens:**
- Email validated for uniqueness
- Password encrypted using BCrypt
- User created with `ROLE_SELLER`
- User-role mapping created
- Seller is now eligible to manage products in Product Service

---

### Step 2: Seller Logs In

- **Endpoint:** `POST /api/auth/login`
- **Service:** User Service

**What Happens:**
- Seller authenticated
- JWT token generated with `ROLE_SELLER`
- Token used by Product Service for seller-only authorization

---

## Flow 3: Admin Registration 👨‍💼

### Step 1: Admin Registers

- **Endpoint:** `POST /api/auth/register`
- **Service:** User Service

**What Happens:**
- User created with `ROLE_ADMIN`
- Admin gains access to platform-level operations
- Role mapping saved in database

---

### Step 2: User with Multiple Roles

- **Endpoint:** `POST /api/auth/register`
- **Service:** User Service

**What Happens:**
- User assigned multiple roles:
  - `ROLE_CUSTOMER`
  - `ROLE_SELLER`
  - `ROLE_ADMIN`
- User can perform actions across all roles
- JWT token contains all assigned roles

---

## Flow 4: Token Refresh 🔄

### Scenario: Access Token Expired

- **Endpoint:** `POST /api/auth/refresh-token`
- **Service:** User Service

**What Happens:**
- Refresh token validated (7-day validity)
- New access token generated (15-minute validity)
- Same refresh token remains valid
- User session continues without re-login

---

## Flow 5: Inter-Service Communication 🔗

### Scenario: Cart Service Requests User Details

- **Endpoint:** `GET /internal/users/{userId}`
- **Access:** Internal Only

**What Happens:**
- Cart Service calls User Service internally
- No JWT token required
- User details retrieved by user ID
- User profile and addresses returned to calling service

**Security Note:**
- `/internal/*` endpoints must NOT be exposed via API Gateway
- Intended strictly for internal microservice communication

---
