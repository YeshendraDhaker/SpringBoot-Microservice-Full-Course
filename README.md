# Master Microservices with Real-World Projects 
## Practical Implementation-Driven Course

---

## MODULE 1: Foundation & Setup

### Introduction & Fundamentals

1. **Monolithic vs SOA vs Microservices**
   - Practical comparisons with real company migrations

2. **Microservices Definition & Core Concepts**
   - Key characteristics and when to use them

3. **The Strangler Fig Pattern**
    - Migrating monolith to microservices
    - Progressive modernization strategy

### Development Environment Setup
4. **Setting Up Your Development Environment**
   - IntelliJ IDEA Ultimate setup
   - Docker Desktop installation
   - Kubernetes setup
   - Git and version control basics

### Project Architecture Planning
5. **Identifying Microservices Boundaries**
   - Domain-driven design basics
   - Bounded contexts

6. **Sizing Microservices - E-commerce Use Case**
   - Breaking down an e-commerce platform
   - Service identification strategy

7. **Sizing Microservices - Streaming Platform Use Case**
   - Breaking down Netflix-like architecture

8. **Sizing Microservices - Real-time Service Use Case**
    - Breaking down Uber-like ride-sharing architecture
---

## MODULE 2: E-COMMERCE PLATFORM - Core Microservices (45 lectures)
**Duration: ~12 hours**
**Project: Building "ShopZone" - Complete E-commerce Platform**

### Project Setup & Architecture
1. **Project Introduction - ShopZone Platform**
   - Platform requirements and features
   - Microservices we'll build
   - Technology stack overview

2. **Complete Project Setup - All Services**
   - Creating multi-module Maven/Gradle project
   - Setting up 8 core services:
     - User Service (Authentication & User Management)
     - Product Service (Catalog Management)
     - Inventory Service (Stock Management)
     - Cart Service (Shopping Cart)
     - Order Service (Order Processing)
     - Payment Service (Payment Gateway Integration)
     - Notification Service (Email/SMS)
     - API Gateway (Entry Point)
   - Database setup for each service
   - Docker Compose initial configuration

3. **Understanding the Data Flow**
   - How services communicate
   - Data consistency patterns
   - Transaction boundaries

### User Service Implementation
4. **User Service - Database Design**
   - Entity modeling with Spring Data JPA
   - User, Role, and Permission tables
   - Audit fields implementation

5. **User Service - Registration API**
   - Creating user registration endpoint
   - Password encryption with BCrypt
   - Input validation with Bean Validation
   - DTO pattern implementation

6. **User Service - Authentication API**
   - Login endpoint
   - JWT token generation
   - Refresh token mechanism

7. **User Service - Profile Management APIs**
   - Get user profile
   - Update profile
   - Change password
   - Delete account
   - Global exception handling

8. **User Service - API Documentation**
   - Springdoc OpenAPI integration
   - Swagger UI customization
   - API annotations and examples

### Product Service Implementation
9. **Product Service - Database Design**
   - Product, Category, Brand entities
   - Product variants and attributes
   - Image management

10. **Product Service - Admin APIs**
    - Create product with variants
    - Update product details
    - Delete product (soft delete)
    - Bulk operations

11. **Product Service - Customer APIs**
    - Search products with filters
    - Get product details
    - Browse by category
    - Featured products

12. **Product Service - Advanced Search**
    - Elasticsearch integration
    - Full-text search
    - Faceted search
    - Search suggestions

### Inventory Service Implementation
13. **Inventory Service - Stock Management**
    - Real-time stock tracking
    - Reserve inventory API
    - Release inventory API
    - Stock level alerts

14. **Inventory Service - Warehouse Management**
    - Multi-warehouse support
    - Location-based inventory
    - Stock transfer between warehouses
   
15. **Config Service - Centralized Configuration $${\color{red}LIVE}$$**
    - Understnading the problem
    - Implementing a centralized configuration server connect all services

### Cart Service Implementation
15. **Cart Service - Cart Operations**
    - Add to cart
    - Update cart items
    - Remove from cart
    - Clear cart
    - Cart persistence (Redis)

16. **Cart Service - Price Calculation**
    - Real-time price sync with Product Service
    - Discount application
    - Tax calculation
    - Shipping cost estimation

### Order Service Implementation
17. **Order Service - Database Design**
    - Order, OrderItem, OrderStatus entities
    - Order history and tracking

18. **Order Service - Create Order API**
    - Order placement flow
    - Inventory validation
    - Payment initiation
    - Order confirmation

19. **Order Service - Order Management APIs**
    - Get order details
    - List user orders
    - Cancel order
    - Return/Refund flow

20. **Order Service - Order State Machine**
    - Status transitions
    - State management with Spring State Machine
    - Event-driven status updates

### Payment Service Implementation
21. **Payment Service - Payment Gateway Integration**
    - Stripe/Razorpay integration
    - Payment intent creation
    - Webhook handling
    - Payment confirmation

22. **Payment Service - Multiple Payment Methods**
    - Credit/Debit card
    - UPI
    - Wallet integration
    - COD (Cash on Delivery)

23. **Payment Service - Transaction Management**
    - Payment history
    - Refund processing
    - Payment reconciliation

### Notification Service Implementation
24. **Notification Service - Email Notifications**
    - SMTP configuration
    - Email templates with Thymeleaf
    - Order confirmation email
    - Password reset email

25. **Notification Service - SMS Notifications**
    - Twilio integration
    - SMS templates
    - OTP generation and verification

26. **Notification Service - Push Notifications**
    - Firebase Cloud Messaging
    - Browser push notifications
    - Mobile app notifications

### Inter-Service Communication
27. **Understanding Service Communication Patterns**
    - Synchronous vs Asynchronous
    - When to use each pattern

28. **Implementing REST Client with Feign - Part 1**
    - Feign Client basics
    - Service-to-service calls
    - Error handling

29. **Implementing REST Client with Feign - Part 2**
    - Request/Response interceptors
    - Circuit breaker with Feign
    - Fallback mechanisms

30. **Testing Inter-Service Communication**
    - Integration testing strategies
    - WireMock for API mocking

### Dockerization
31. **What are Containers & Docker Basics**
    - Container vs VM
    - Docker architecture

32. **Docker Installation & Docker Hub**
    - Setup verification
    - Docker Hub account

33. **Creating Dockerfile for Each Service**
    - Multi-stage builds
    - Optimizing image size
    - Best practices

34. **Building Docker Images - All Services**
    - Building images for all 8 services
    - Image tagging strategy
    - Pushing to Docker Hub

35. **Introduction to Docker Compose**
    - Why Docker Compose
    - YAML structure

36. **Docker Compose for ShopZone - Part 1**
    - Setting up all services
    - Service dependencies
    - Network configuration

37. **Docker Compose for ShopZone - Part 2**
    - Environment variables
    - Volume mounts
    - Health checks

38. **Running ShopZone with Docker Compose**
    - Starting all services
    - Troubleshooting common issues
    - Viewing logs

39. **Docker Networking Deep Dive**
    - Service discovery in Docker
    - Network isolation
    - Port mapping strategies

40. **Docker Commands Masterclass**
    - Essential commands
    - Debugging containers
    - Performance monitoring

### Database Management
41. **Setting up MySQL Databases**
    - Database per service pattern
    - MySQL containers
    - Database initialization scripts

42. **Database Migration Strategies**
    - Flyway integration
    - Version control for schemas
    - Rollback strategies

### Configuration Management
43. **Configuration Challenges in Microservices**
    - Environment-specific configs
    - Secrets management

44. **Spring Cloud Config Server Setup**
    - Config server implementation
    - Git-based configuration
    - Refresh strategies

45. **Integrating Config Server with All Services**
    - Client configuration
    - Profile-based configs (dev, qa, prod)
    - Runtime configuration refresh

---

## MODULE 3: E-COMMERCE - Service Discovery & API Gateway (22 lectures)
**Duration: ~7 hours**

### Service Discovery
1. **Why Service Discovery in Microservices**
   - Dynamic service registration
   - Load balancing needs

2. **Traditional Load Balancers vs Service Discovery**
   - Limitations of traditional approach
   - Client-side load balancing

3. **Setting up Eureka Server**
   - Eureka server configuration
   - Dashboard overview

4. **Registering All ShopZone Services with Eureka**
   - Client configuration in all services
   - Service metadata
   - Health checks

5. **Client-Side Load Balancing**
   - How it works
   - Load balancing algorithms

6. **Eureka Self-Preservation Mode**
   - Network partition handling
   - Configuration tuning

7. **Service Deregistration & Heartbeats**
   - Graceful shutdown
   - Heartbeat mechanism

8. **Testing Service Discovery**
   - Multiple instances
   - Load distribution verification

### API Gateway Implementation
9. **Why API Gateway is Critical**
   - Single entry point
   - Cross-cutting concerns
   - Security enforcement

10. **Spring Cloud Gateway Architecture**
    - How it works internally
    - Request flow

11. **Building API Gateway for ShopZone**
    - Gateway setup
    - Basic routing configuration

12. **Custom Routing Patterns**
    - Path-based routing
    - Header-based routing
    - Predicate factories

13. **Implementing Request/Response Filters**
    - Pre-filters
    - Post-filters
    - Custom filters

14. **Gateway Logging & Tracing**
    - Request logging
    - Correlation IDs
    - Distributed tracing setup

15. **Rate Limiting at Gateway**
    - Redis rate limiter
    - Per-user rate limits
    - API throttling

16. **Gateway Security**
    - CORS configuration
    - Request validation
    - Header manipulation

17. **API Gateway Patterns**
    - Backend for Frontend (BFF)
    - API composition
    - Aggregation patterns

18. **Gateway Performance Optimization**
    - Caching strategies
    - Connection pooling
    - Timeout configuration

19. **Docker Images for Service Discovery Components**
    - Eureka server image
    - Gateway image
    - Pushing to Docker Hub

20. **Updating Docker Compose**
    - Adding Eureka and Gateway
    - Service dependencies
    - Network configuration

21. **Testing Complete Service Discovery Flow**
    - End-to-end testing
    - Multiple service instances
    - Load balancing verification

22. **Gateway Monitoring & Health Checks**
    - Actuator endpoints
    - Custom health indicators

---

## MODULE 4: E-COMMERCE - Resilience & Reliability (18 lectures)
**Duration: ~5 hours**

### Resilience Patterns
1. **Why Resilience is Critical**
   - Cascade failures
   - Real-world outage examples

2. **Common Failure Scenarios in ShopZone**
   - Payment service downtime
   - Inventory service slow response
   - Database connection issues

3. **Circuit Breaker Pattern Deep Dive**
   - How it works
   - When to use

4. **Circuit Breaker States**
   - Closed, Open, Half-Open
   - Transition logic

5. **Implementing Circuit Breaker in Gateway**
   - Resilience4j integration
   - Configuration

6. **Circuit Breaker - Gateway Part 2**
   - Fallback responses
   - Testing circuit breaker

7. **Circuit Breaker with Feign Client - Part 1**
   - Service-level circuit breakers
   - Order → Payment scenario

8. **Circuit Breaker with Feign Client - Part 2**
   - Order → Inventory scenario
   - Fallback methods

9. **HTTP Timeout Configurations**
   - Connection timeout
   - Read timeout
   - Circuit breaker timeout

### Retry Pattern
10. **Retry Pattern Introduction**
    - When to retry
    - Exponential backoff

11. **Implementing Retry in Gateway**
    - Retry configuration
    - Conditions for retry

12. **Implementing Retry in Services - Part 1**
    - Payment retries
    - Idempotency

13. **Implementing Retry in Services - Part 2**
    - Notification retries
    - Retry with circuit breaker

### Rate Limiting
14. **Rate Limiter Pattern**
    - Protecting services from overload
    - Rate limiting strategies

15. **Redis Rate Limiter**
    - Why Redis
    - Configuration

16. **Implementing Rate Limiter**
    - Gateway-level rate limiting
    - Service-level rate limiting

### Bulkhead Pattern
17. **Bulkhead Pattern Introduction**
    - Resource isolation
    - Thread pool bulkhead vs Semaphore bulkhead

18. **Testing All Resilience Patterns**
    - Simulating failures
    - Monitoring behavior
    - Recovery verification

---

## MODULE 5: E-COMMERCE - Event-Driven Architecture (20 lectures)
**Duration: ~6 hours**

### Event-Driven Fundamentals
1. **Why Event-Driven Architecture**
   - Decoupling services
   - Scalability benefits

2. **Event-Driven Models**
   - Event notification
   - Event-carried state transfer
   - Event sourcing

3. **ShopZone Event-Driven Scenarios**
   - Order placed → Inventory update
   - Order placed → Email notification
   - Payment success → Order status update
   - Low stock → Notification to admin

### RabbitMQ Implementation
4. **Introduction to RabbitMQ**
   - AMQP protocol
   - RabbitMQ architecture

5. **Why Spring Cloud Functions**
   - Functional programming model
   - Cloud-agnostic approach

6. **Event Schema Design**
   - Event structure
   - Versioning events
   - Best practices

7. **Notification Service - Event Consumer Part 1**
   - Spring Cloud Function setup
   - Consuming OrderPlaced events
   - Email sending logic

8. **Notification Service - Event Consumer Part 2**
   - Consuming PaymentSuccess events
   - SMS notification logic

9. **Notification Service - Event Consumer Part 3**
   - Error handling
   - Dead letter queue
   - Retry mechanism

10. **Why Spring Cloud Stream**
    - Abstraction over messaging
    - Multiple binder support

11. **Order Service - Event Publisher Part 1**
    - Publishing OrderPlaced event
    - Integration with order creation

12. **Order Service - Event Publisher Part 2**
    - Publishing OrderCancelled event
    - Publishing OrderShipped event

13. **Inventory Service - Event Consumer**
    - Consuming OrderPlaced event
    - Deducting stock
    - Publishing StockLow event

14. **Payment Service - Event Publisher**
    - Publishing PaymentSuccess event
    - Publishing PaymentFailed event

15. **Testing Event Flow with RabbitMQ**
    - RabbitMQ management UI
    - Tracing message flow
    - Testing failure scenarios

16. **RabbitMQ Docker Setup**
    - RabbitMQ container
    - Management plugin
    - Configuration

17. **Complete E-commerce Event Flow Demo**
    - End-to-end order placement
    - Event tracing
    - Failure recovery

### Apache Kafka Implementation
18. **Introduction to Apache Kafka**
    - Kafka architecture
    - Topics, partitions, consumer groups

19. **RabbitMQ vs Kafka - When to Use What**
    - Comparison
    - Use cases
    - Decision making

20. **Migrating ShopZone to Kafka**
    - Kafka setup
    - Producer/Consumer configuration
    - Testing with Kafka
    - Docker Compose with Kafka

---

## MODULE 6: E-COMMERCE - Security (18 lectures)
**Duration: ~5 hours**

### OAuth2 & OpenID Connect
1. **Microservices Security Challenges**
   - Authentication in distributed systems
   - Token propagation

2. **Problems OAuth2 Solves**
   - Delegated authorization
   - Secure API access

3. **OAuth2 Deep Dive**
   - OAuth2 flows
   - Tokens and scopes

4. **OAuth2 Terminology**
   - Resource owner, Client, Authorization server
   - Resource server, Access token

5. **OpenID Connect**
   - Authentication vs Authorization
   - ID tokens
   - UserInfo endpoint

### Keycloak Setup
6. **Introduction to Keycloak**
   - Why Keycloak
   - Features overview

7. **Keycloak Setup & Configuration**
   - Installation
   - Realm creation
   - Client registration

8. **Configuring ShopZone Realm**
   - Creating clients for services
   - User federation
   - Roles and groups

### Client Credentials Flow
9. **Client Credentials Grant Flow**
   - When to use
   - Flow diagram

10. **Securing Service-to-Service Communication**
    - Client credentials for Feign clients
    - Token acquisition
    - Token caching

11. **Gateway as OAuth2 Client**
    - Spring Security OAuth2 Client
    - Token relay

12. **Resource Server Configuration - Part 1**
    - JWT validation
    - Public key configuration

13. **Resource Server Configuration - Part 2**
    - Securing endpoints
    - Method security

### Authorization Code Flow
14. **Authorization Code Grant Flow**
    - User login flow
    - Authorization code exchange

15. **Implementing User Login**
    - Gateway OAuth2 login
    - Session management
    - Logout

16. **Role-Based Access Control (RBAC)**
    - Customer role
    - Admin role
    - Seller role
    - Authorization rules

17. **Testing Security End-to-End**
    - User registration and login
    - Accessing protected APIs
    - Service-to-service calls

18. **Security with Docker Compose**
    - Keycloak container
    - Network security
    - Environment variables for secrets

---

## MODULE 7: E-COMMERCE - Observability (20 lectures)
**Duration: ~6 hours**

### Logging
1. **Observability vs Monitoring**
   - Three pillars: Logs, Metrics, Traces
   - Why observability matters

2. **Centralized Logging Challenges**
   - Log aggregation needs
   - Correlation across services

3. **Introduction to Grafana Stack**
   - Loki for logs
   - Tempo for traces
   - Grafana for visualization

4. **Structured Logging Setup**
   - JSON logging
   - Log correlation IDs
   - Best practices

5. **Loki & Promtail Setup**
   - Loki configuration
   - Promtail agent setup

6. **Integrating Services with Loki - Part 1**
   - Log shipping configuration
   - Labels and filters

7. **Integrating Services with Loki - Part 2**
   - Multi-service logging
   - Log querying in Grafana

8. **Grafana Dashboard for Logs**
   - Creating log dashboards
   - Log panels
   - Query language

### Metrics & Monitoring
9. **Introduction to Metrics**
   - Counter, Gauge, Histogram
   - Metric naming conventions

10. **Micrometer Setup**
    - Spring Boot Actuator
    - Micrometer registry

11. **Custom Metrics in ShopZone**
    - Order count metrics
    - Payment success rate
    - API latency metrics

12. **Prometheus Setup**
    - Prometheus configuration
    - Service discovery
    - Scraping endpoints

13. **Prometheus Demo**
    - Query language (PromQL)
    - Exploring metrics

14. **Grafana-Prometheus Integration**
    - Adding Prometheus datasource
    - Testing connection

15. **Grafana Dashboards**
    - Pre-built dashboards
    - Custom dashboards for ShopZone
    - Panels and visualizations

### Alerting
16. **Creating Alerts - Part 1**
    - Alert rules in Grafana
    - Notification channels
    - Email alerts

17. **Creating Alerts - Part 2**
    - Slack integration
    - PagerDuty integration
    - Alert testing

### Distributed Tracing
18. **Distributed Tracing Introduction**
    - Why tracing matters
    - Trace, Span concepts

19. **OpenTelemetry Integration**
    - OpenTelemetry setup
    - Auto-instrumentation
    - Manual instrumentation

20. **Tempo Setup & Integration**
    - Tempo configuration
    - Trace visualization
    - Linking logs to traces

---

## MODULE 8: Containerization & Orchestration (44 lectures)
**Duration: ~10 hours**

### Kubernetes Fundamentals
1. **Container Orchestration Challenges**
   - Scaling
   - Self-healing
   - Service discovery

2. **Introduction to Kubernetes**
   - What is K8s
   - Why K8s

3. **Kubernetes Architecture Deep Dive**
   - Control plane components
   - Worker node components
   - etcd, API server, Scheduler, Controller Manager

4. **Setting up Local Kubernetes**
   - Docker Desktop K8s
   - kubectl installation
   - Verifying setup

5. **Kubernetes Dashboard**
   - Installing dashboard
   - Accessing dashboard
   - Dashboard tour

### Deploying ShopZone to Kubernetes
6. **Kubernetes YAML Deep Dive**
   - Deployment manifest
   - Service manifest
   - ConfigMap and Secret

7. **Creating ConfigMaps**
   - Application properties as ConfigMap
   - Environment variables
   - Mounting as files

8. **Creating Secrets**
   - Database credentials
   - API keys
   - Managing sensitive data

9. **Deploying Config Server**
   - Config Server deployment
   - Service exposure

10. **Deploying User Service**
    - Deployment creation
    - Service exposure
    - Environment variables

11. **Deploying All Core Services**
    - Product, Inventory, Cart Services
    - Order, Payment Services
    - Notification Service

12. **Deploying Gateway & Eureka**
    - Gateway deployment
    - Eureka deployment
    - LoadBalancer service

13. **Testing ShopZone on Kubernetes**
    - Accessing services
    - Testing end-to-end flows
    - Troubleshooting

### Kubernetes Features
14. **Self-Healing Demo**
    - Pod failure simulation
    - Auto-restart verification

15. **Auto-Scaling**
    - Horizontal Pod Autoscaler (HPA)
    - CPU-based scaling
    - Custom metric scaling

16. **Rollout & Rollback**
    - Rolling update strategy
    - Blue-green deployment
    - Rollback demonstration

17. **Kubernetes Service Types**
    - ClusterIP
    - NodePort
    - LoadBalancer
    - ExternalName

18. **Service Types Demo**
    - Creating different service types
    - When to use each

### Helm Package Manager
19. **Problems with Manual YAML**
    - Repetition
    - Environment management
    - Version control

20. **Introduction to Helm**
    - Helm architecture
    - Charts, Values, Templates
    - Helm vs kubectl

21. **Installing Helm**
    - Installation
    - Verification

22. **Understanding Helm Chart Structure**
    - Chart.yaml
    - values.yaml
    - templates/

23. **Creating Helm Chart for User Service**
    - Chart scaffolding
    - Template creation
    - Values file

24. **Creating Helm Chart for All Services**
    - Parameterizing deployments
    - Service templates
    - ConfigMap and Secret templates

25. **Environment-Specific Values**
    - values-dev.yaml
    - values-qa.yaml
    - values-prod.yaml

26. **Helm Template Command**
    - Dry-run
    - Debugging templates

27. **Installing Services with Helm**
    - helm install command
    - Release management
    - Verifying installation

28. **Helm Upgrade**
    - Updating releases
    - helm upgrade command

29. **Helm History & Rollback**
    - Viewing release history
    - Rolling back changes

30. **Helm Uninstall**
    - Removing releases
    - Cleanup

### Installing Infrastructure with Helm
31. **Installing Keycloak with Helm**
    - Bitnami Keycloak chart
    - Custom values
    - Persistence

32. **Installing Kafka with Helm**
    - Bitnami Kafka chart
    - Zookeeper setup

33. **Installing Prometheus with Helm**
    - Prometheus operator
    - ServiceMonitor resources

34. **Installing Loki Stack with Helm**
    - Loki-stack chart
    - Promtail configuration

35. **Installing Grafana with Helm**
    - Grafana chart
    - Datasource configuration
    - Dashboard provisioning

### Advanced Kubernetes
36. **Kubernetes Discovery Client**
    - Spring Cloud Kubernetes
    - Service discovery without Eureka

37. **Server-Side Service Discovery**
    - K8s native service discovery
    - Comparing with client-side

### Cloud Deployment
38. **Google Kubernetes Engine (GKE) Setup**
    - GCP account setup
    - gcloud SDK installation

39. **Creating GKE Cluster**
    - Cluster creation
    - Node pool configuration

40. **Deploying ShopZone to GKE**
    - Helm chart deployment
    - LoadBalancer setup
    - DNS configuration

41. **Testing on GKE**
    - Accessing application
    - Performance testing

42. **Monitoring on GKE**
    - GCP monitoring integration
    - Cloud logging

43. **Kubernetes Ingress**
    - Ingress resource
    - Ingress controller
    - Path-based routing

44. **Cleaning Up GKE**
    - Deleting cluster
    - Cost management

---

## MODULE 9: PROJECT - NETFLIX  (35 lectures)
**Duration: ~12 hours**
**Project: Building "StreamFlix" - Video Streaming Platform**

### Project Setup & Architecture
1. **StreamFlix - Project Introduction**
   - Features overview
   - Microservices architecture
   - Technology stack

2. **StreamFlix - Complete Project Setup**
   - Setting up 10 microservices:
     - User Service (Authentication)
     - Profile Service (User Profiles)
     - Content Service (Movies/Series Catalog)
     - Video Service (Video Storage & Streaming)
     - Encoding Service (Video Transcoding)
     - Recommendation Service (AI-based Recommendations)
     - Subscription Service (Plans & Billing)
     - Playback Service (Video Playback State)
     - Search Service (Elasticsearch-based Search)
     - Admin Service (Content Management)
   - API Gateway
   - Database setup
   - Docker Compose

3. **Understanding Video Streaming Architecture**
   - CDN integration
   - Adaptive bitrate streaming
   - HLS/DASH protocols

### Core Services Implementation
4. **User Service - Authentication & Authorization**
   - OAuth2 implementation
   - Social login (Google, Facebook)
   - JWT tokens
   - Refresh token rotation

5. **Profile Service - Multi-Profile Support**
   - Creating profiles
   - Profile switching
   - Watch history per profile
   - Parental controls

6. **Content Service - Catalog Management**
   - Movie/Series CRUD
   - Genres, Cast, Crew management
   - Content metadata
   - IMDb integration

7. **Video Service - Video Upload & Storage**
   - Multipart file upload
   - AWS S3 integration
   - Video metadata extraction
   - Thumbnail generation

8. **Encoding Service - Video Transcoding**
   - FFmpeg integration
   - Multiple resolution encoding
   - HLS playlist generation
   - Progress tracking
   - S3 upload of encoded videos

9. **Recommendation Service - Part 1**
   - Collaborative filtering
   - Content-based filtering
   - Hybrid approach

10. **Recommendation Service - Part 2**
    - Machine Learning model integration
    - Real-time recommendations
    - Trending content

11. **Subscription Service - Payment Integration**
    - Subscription plans
    - Stripe integration
    - Subscription lifecycle
    - Trial period handling
    - Auto-renewal

12. **Playback Service - Streaming State**
    - Watch position tracking
    - Resume playback
    - Continue watching list
    - Redis for state management

13. **Search Service - Elasticsearch**
    - Elasticsearch setup
    - Indexing content
    - Full-text search
    - Autocomplete
    - Filters and facets

14. **Admin Service - Content Management**
    - Admin dashboard APIs
    - Content approval workflow
    - Analytics APIs
    - User management

### Advanced Features
15. **Video CDN Integration**
    - CloudFront setup
    - Signed URLs for security
    - Edge caching
    - Geographic distribution

16. **Adaptive Bitrate Streaming**
    - HLS implementation
    - Quality switching
    - Network-based adaptation

17. **Real-time Analytics**
    - View count tracking
    - Watch time analytics
    - Kafka streaming
    - Real-time dashboards

18. **Recommendation Engine Training**
    - Collecting user interaction data
    - Model training pipeline
    - A/B testing recommendations

### Event-Driven Architecture
19. **StreamFlix Event Schema**
    - VideoUploaded event
    - EncodingCompleted event
    - VideoWatched event
    - SubscriptionChanged event

20. **Video Encoding Pipeline - Part 1**
    - VideoUploaded event publisher
    - Encoding Service consumer
    - Asynchronous processing

21. **Video Encoding Pipeline - Part 2**
    - EncodingCompleted event
    - Content Service update
    - Notification to uploader

22. **Analytics Pipeline**
    - VideoWatched events
    - Real-time aggregation
    - Storing in time-series DB

23. **Recommendation Pipeline**
    - User interaction events
    - ML model update trigger
    - Real-time vs batch processing

### Resilience & Performance
24. **Caching Strategy**
    - Redis for caching
    - Cache-aside pattern
    - Content catalog caching
    - Recommendation caching

25. **Circuit Breaker for Video Encoding**
    - Handling encoding failures
    - Fallback to lower quality
    - Retry mechanism

26. **Rate Limiting for API Gateway**
    - User-based rate limits
    - API tier limits
    - Preventing abuse

27. **Database Optimization**
    - Query optimization
    - Indexing strategy
    - Connection pooling
    - Read replicas

### Security
28. **Video Content Protection**
    - DRM integration
    - Token-based video access
    - Preventing unauthorized downloads
    - Watermarking

29. **API Security**
    - OAuth2 flows
    - Scope-based access
    - Service-to-service security

### Testing & Deployment
30. **Integration Testing**
    - Testcontainers
    - API testing
    - Event flow testing

31. **Load Testing**
    - JMeter setup
    - Simulating concurrent users
    - Identifying bottlenecks
    - Performance tuning

32. **Kubernetes Deployment**
    - Helm charts for all services
    - StatefulSets for databases
    - Horizontal scaling
    - Resource limits

33. **Monitoring StreamFlix**
    - Metrics for video streaming
    - Alerting on encoding failures
    - User experience metrics

34. **Complete StreamFlix Demo**
    - End-to-end user journey
    - Admin workflows
    - Performance demonstration
    - Failover scenarios

35. **StreamFlix Review & Best Practices**
    - Architecture review
    - Lessons learned
    - Production considerations

---

## MODULE 10: PROJECT - UBER (34 lectures)
**Duration: ~11 hours**
**Project: Building "RideShare" - Real-time Ride-Sharing Platform**

### Project Setup & Architecture
1. **RideShare - Project Introduction**
   - Features overview
   - Real-time requirements
   - Geo-spatial challenges
   - Microservices architecture

2. **RideShare - Complete Project Setup**
   - Setting up 12 microservices:
     - User Service (Riders & Drivers)
     - Auth Service (Authentication)
     - Ride Service (Ride Management)
     - Matching Service (Rider-Driver Matching)
     - Location Service (Real-time Location Tracking)
     - Pricing Service (Dynamic Pricing)
     - Payment Service (Payments & Wallets)
     - Notification Service (Push Notifications)
     - Rating Service (Reviews & Ratings)
     - Trip Service (Trip History & Analytics)
     - Driver-Onboarding Service (Driver Verification)
     - Support Service (Customer Support)
   - API Gateway
   - WebSocket server

3. **Understanding Real-time Architecture**
   - WebSocket vs Server-Sent Events
   - Message queues for real-time updates
   - Geo-spatial databases

### Core Services Implementation
4. **User Service - Riders & Drivers**
   - User registration
   - Driver registration
   - Profile management
   - Document verification

5. **Auth Service - OAuth2 & JWT**
   - Phone number authentication
   - OTP verification
   - JWT tokens
   - Device management

6. **Location Service - Part 1**
   - Real-time location tracking
   - Redis Geospatial
   - Location update APIs
   - Driver availability zones

7. **Location Service - Part 2**
   - WebSocket for live location
   - Location history
   - Route tracking
   - ETA calculation

8. **Ride Service - Ride Lifecycle**
   - Request ride
   - Ride state machine
   - Accept/Decline ride
   - Start/End trip
   - Ride cancellation

9. **Matching Service - Algorithm**
   - Nearest driver algorithm
   - Redis Geospatial queries
   - Driver scoring
   - Surge area detection
   - Matching optimization

10. **Pricing Service - Dynamic Pricing**
    - Base fare calculation
    - Distance & time-based pricing
    - Surge pricing algorithm
    - Promo codes & discounts
    - Fare estimation

11. **Payment Service - Wallet & Transactions**
    - Wallet creation
    - Add money to wallet
    - Payment processing
    - Ride payment flow
    - Stripe/Razorpay integration
    - Transaction history

12. **Notification Service - Push Notifications**
    - Firebase Cloud Messaging
    - Driver notification (new ride request)
    - Rider notification (driver accepted)
    - Real-time updates
    - Email notifications

13. **Rating Service - Reviews & Ratings**
    - Rate rider/driver
    - Reviews storage
    - Average rating calculation
    - Rating aggregation

14. **Trip Service - Trip History**
    - Trip history APIs
    - Trip analytics
    - Ride receipts
    - Export trip data

15. **Driver Onboarding Service**
    - Document upload
    - Background verification
    - Vehicle registration
    - Approval workflow
    - Admin review APIs

### Real-time Communication
16. **WebSocket Server Setup**
    - Spring WebSocket
    - STOMP protocol
    - Message broker
    - Connection management

17. **Live Location Broadcasting**
    - Driver location updates
    - Broadcasting to riders
    - Rider location to driver
    - Optimizing broadcast frequency

18. **Real-time Ride Updates**
    - Ride status updates via WebSocket
    - Push notifications
    - Event-driven updates

### Event-Driven Architecture with Kafka
19. **RideShare Event Schema**
    - RideRequested event
    - RideAccepted event
    - RideStarted event
    - RideCompleted event
    - PaymentCompleted event
    - LocationUpdated event

20. **Ride Request Flow**
    - Publishing RideRequested event
    - Matching Service consumer
    - Notifying drivers
    - Timeout handling

21. **Ride Acceptance Flow**
    - RideAccepted event
    - Notifying rider
    - Updating ride status
    - Analytics tracking

22. **Payment Flow**
    - RideCompleted event
    - Payment processing
    - PaymentCompleted event
    - Wallet update

23. **Analytics Pipeline**
    - All events to analytics topic
    - Real-time aggregation
    - Driver performance metrics
    - Revenue tracking

### Geo-spatial Features
24. **Redis Geospatial Deep Dive**
    - GEOADD command
    - GEORADIUS queries
    - Finding nearby drivers
    - Performance optimization

25. **Route Planning**
    - Google Maps API integration
    - Direction API
    - Distance Matrix API
    - ETA calculation
    - Polyline encoding

26. **Heat Maps for Demand**
    - Aggregating ride requests
    - Identifying surge areas
    - Visualizing on maps

### Advanced Features
27. **Dynamic Pricing Engine**
    - Demand-supply analysis
    - Surge multiplier calculation
    - Real-time price updates
    - Machine learning for prediction

28. **Driver Assignment Optimization**
    - Multiple factors (rating, distance, acceptance rate)
    - Optimization algorithm
    - Fairness considerations

29. **Fraud Detection**
    - Unusual patterns
    - Fake GPS detection
    - Account verification

### Testing & Deployment
30. **Load Testing Real-time System**
    - Simulating thousands of concurrent users
    - WebSocket load testing
    - Kafka throughput testing
    - Identifying bottlenecks

31. **Kubernetes Deployment**
    - Helm charts for all services
    - WebSocket server scaling
    - Kafka cluster setup
    - Redis cluster

32. **Monitoring Real-time Metrics**
    - WebSocket connection metrics
    - Kafka lag monitoring
    - Location update frequency
    - Match rate metrics

33. **Complete RideShare Demo**
    - End-to-end ride flow
    - Real-time location tracking
    - Multiple concurrent rides
    - Failover demonstration

34. **RideShare Review & Production Tips**
    - Architecture review
    - Scaling considerations
    - Cost optimization
    - Lessons learned

---

## MODULE 11: Advanced Topics & Best Practices (12 lectures)
**Duration: ~4 hours**

### Code Quality & Optimization
1. **Spring Boot BOM - Part 1**
   - Dependency management
   - Version consistency

2. **Spring Boot BOM - Part 2**
   - Custom BOM creation
   - Multi-module projects

3. **Spring Boot BOM - Part 3**
   - Best practices
   - Implementation in projects

4. **Spring Boot BOM - Part 4**
   - Real-world examples

5. **Shared Libraries - Part 1**
   - Common code extraction
   - Shared DTOs
   - Exception handling

6. **Shared Libraries - Part 2**
   - Versioning shared libraries
   - Distribution strategies

### Service Mesh
7. **Introduction to Service Mesh**
   - What is service mesh
   - Capabilities
   - When to use

8. **Service Mesh Components**
   - Data plane
   - Control plane
   - Sidecar proxy

9. **mTLS Deep Dive**
   - How TLS works
   - Certificate management

10. **mTLS Implementation**
    - Mutual authentication
    - Service-to-service encryption

### Production Considerations
11. **Kubernetes Ingress Deep Dive**
    - Ingress controllers
    - Path-based routing
    - SSL/TLS termination

12. **Production Checklist**
    - Security hardening
    - Performance optimization
    - Disaster recovery
    - Cost optimization
    - Monitoring & alerting

---

## BONUS MODULE: Interview Preparation (8 lectures)
**Duration: ~3 hours**

1. **Microservices Architecture Interview Questions**
   - Design questions
   - Pattern questions
   - Best practices

2. **Spring Boot & Spring Cloud Questions**
   - Core concepts
   - Configuration
   - Common issues

3. **Docker & Kubernetes Questions**
   - Container concepts
   - Orchestration
   - Deployment strategies

4. **System Design - E-commerce Platform**
   - Designing from scratch
   - Scaling considerations
   - Trade-offs

5. **System Design - Video Streaming Platform**
   - Streaming architecture
   - CDN integration
   - Encoding pipeline

6. **System Design - Ride-Sharing Platform**
   - Real-time requirements
   - Geo-spatial challenges
   - Matching algorithm

7. **Common Pitfalls & How to Avoid Them**
   - Anti-patterns
   - Best practices
   - Lessons from production

---

## Course Wrap-up (1 lecture)

---

## TOTAL COURSE STATISTICS

**Total Modules:** 12 (11 core + 1 bonus)
**Total Lectures:** ~405 lectures
**Total Duration:** ~104+ hours

## KEY TECHNOLOGIES COVERED

- **Backend:** Spring Boot, Spring Cloud, Spring Security
- **Service Discovery:** Eureka, Spring Cloud Kubernetes
- **API Gateway:** Spring Cloud Gateway
- **Resilience:** Resilience4j (Circuit Breaker, Retry, Rate Limiter, Bulkhead)
- **Messaging:** RabbitMQ, Apache Kafka
- **Databases:** MySQL, PostgreSQL, MongoDB, Redis
- **Search:** Elasticsearch
- **Security:** OAuth2, OpenID Connect, Keycloak, JWT
- **Observability:** Grafana, Loki, Prometheus, Tempo, OpenTelemetry
- **Containerization:** Docker, Docker Compose
- **Orchestration:** Kubernetes, Helm
- **Cloud:** Google Cloud Platform (GKE)
- **Real-time:** WebSocket, Server-Sent Events
- **Geo-spatial:** Redis Geospatial, Google Maps API
- **Video Processing:** FFmpeg, HLS, DASH
- **CDN:** AWS CloudFront, AWS S3

## WHAT MAKES THIS COURSE UNIQUE

✅ **3 Complete Production-Grade Projects** instead of toy examples
✅ **Real-world scenarios** Amazon, Netflix, Uber
✅ **Hands-on implementation** from day one (Module 2 onwards)
✅ **Event-driven architecture** with RabbitMQ & Kafka
✅ **Complete Observability** stack (Logging, Metrics, Tracing)
✅ **Security best practices** with OAuth2 & Keycloak
✅ **Kubernetes deployment** on local and cloud (GKE)
✅ **Advanced features** like dynamic pricing, video encoding, real-time tracking
✅ **Interview preparation** module with system design
✅ **No time wasted** on basic Spring Boot tutorials

## LEARNING APPROACH

1. **Module 1:** Foundation & Setup (Understand the WHY)
2. **Modules 2-8:** E-commerce Platform (Learn by Building)
3. **Module 9:** Netflix Clone (Consolidate with Complex Use Case)
4. **Module 10:** Uber Clone (Master Real-time & Geo-spatial)
5. **Module 11:** Advanced Topics (Production-Ready)
6. **Bonus:** Interview Prep (Get the Job)

Every concept is learned by implementing it in a real project! 🚀
