# 🛤️ Kafka Order Tracking System – Complete Curriculum
### *Building Real-time Event-Driven Systems with Spring Boot & Kafka*

---

## 🏗️ Phase 1: Kafka Basics & Setup
### 📂 Installation & Fundamentals
* **Topics Covered:**
    * Install Kafka with Docker (Zookeeper + Kafka + Kafka UI)
    * Core Concepts: Brokers, Topics, Partitions, Consumer Groups, Offsets
* **Hands-on:**
    * Practice CLI commands: Create topics, produce messages, and consume messages
    * Understanding Partitioning and Lead Replicas

### 🚀 Spring Boot Integration
* **Topics Covered:**
    * Setup multi-module project structure
    * Configure Spring Kafka dependencies
    * Create shared event models (OrderEvent, OrderStatus)
* **Hands-on:**
    * Setup `order-service`, `notification-service`, and `tracking-service`
    * Test basic Producer ➔ Consumer flow using Spring Kafka

---

## 📦 Phase 2: Building the Core Flow
### ⚙️ Build Core Order Flow
* **Topics Covered:**
    * Order Service (Producer): REST API to create orders
    * Notification Service (Consumer): Listen to events, send email/SMS notifications
* **Hands-on:**
    * Publish events to Kafka from Order Service
    * Implement Listeners in Notification Service
    * Test end-to-end: Create order ➔ Event published ➔ Notification sent

---

## 🔄 Phase 3: Multiple Consumers & Reliability
### 👥 Adding More Consumers
* **Tracking Service:**
    * Store order status in database
    * Provide tracking API for end-users
* **Analytics Service:**
    * Calculate metrics (total orders, revenue, popular items)
* **Learning Points:**
    * Different consumer groups reading the same topic
    * Parallel processing and scaling consumers

### 🛡️ Error Handling & Reliability
* **Topics Covered:**
    * Dead Letter Topics (DLT) for failed messages
    * Retry mechanisms with exponential backoff
    * Manual offset commits for reliability
    * Handling "Poison Pill" messages
* **Idempotency:**
    * Enable idempotent producers (avoid duplicates)
    * Add unique event IDs for deduplication
    * Implement Exactly-once Semantics (EOS)
* **Hands-on:**
    * Test failure scenarios: Network issues, service crashes, and message format errors

---

## 🚀 Phase 4: Production-Ready Features
### 📊 Monitoring & Observability
* **Topics Covered:**
    * Setup Prometheus + Grafana for Kafka metrics
    * Monitor consumer lag, throughput, and partition distribution
    * Add structured logging with correlation IDs
    * Setup alerts for high consumer lag

### ⚡ Performance Optimization
* **Topics Covered:**
    * Tune Producer: Batching, compression, and buffer size
    * Optimize Consumer: Fetch size and poll interval
    * Right-sizing partition counts for high throughput
* **Hands-on:**
    * Load testing with JMeter to find bottlenecks

### 🚢 Deployment
* **Topics Covered:**
    * Dockerize all microservices
    * Create Kubernetes manifests (Deployments, Services, ConfigMaps)
    * Setup health checks and readiness probes
* **Hands-on:**
    * Deploy to local K8s cluster (Minikube/Kind)
    * Create a basic CI/CD pipeline for automated deployment

---

## 🎓 Phase 5: Advanced Kafka Topics (Optional)
### 📜 Schema Management
* **Topics Covered:**
    * Setup Confluent Schema Registry
    * Use Avro for message serialization
    * Implement schema evolution (backward/forward compatibility)

### 🌊 Kafka Streams
* **Topics Covered:**
    * Build real-time analytics with Kafka Streams
    * Windowed aggregations (e.g., orders per hour)
    * Stateful processing (running totals/leaderboards)

### 🔐 Security & Multi-Environment
* **Topics Covered:**
    * Enable SSL/TLS encryption for data in transit
    * Configure SASL authentication
    * Setup ACLs (Access Control Lists) for topic access
    * Environment-specific configs (dev, staging, prod)

---

## ✅ Final Deliverables
* ✅ Source code for 4+ Microservices.
* ✅ Docker Compose file for the entire Kafka ecosystem.
* ✅ Grafana Dashboards for monitoring.
* ✅ Kubernetes Deployment scripts
