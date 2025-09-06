# Text Analytics CRUD Application

This is a simple full-stack Text Analytics application that performs basic CRUD operations on text data and analyzes the sentiment and word count using NLP.

### 🧰 Tech Stack

- **Java (Spring Boot)** - Backend REST API for CRUD operations
- **Python (Flask)** - NLP analytics service (sentiment analysis & word count)
- **SQLite** - Lightweight local database

---

### 📁 Project Structure

text_analytics_crud_app/
│
├── backend-java/ # Spring Boot backend
├── analytics-python/ # Python Flask-based text analytics
├── README.md # Project overview and structure
├── run_instructions.md # Step-by-step run guide
└── .gitignore # Files/folders to ignore


---

### 🌐 API Endpoints (Java)

| Method | Endpoint            | Description                |
|--------|---------------------|----------------------------|
| GET    | `/api/text`         | Get all text records       |
| GET    | `/api/text/{id}`    | Get a specific record      |
| POST   | `/api/text`         | Add new text & analyze     |
| PUT    | `/api/text/{id}`    | Update text & re-analyze   |
| DELETE | `/api/text/{id}`    | Delete text entry          |

---

### 🧠 Text Analytics API (Python)

| Endpoint        | Method | Input Field |
|----------------|--------|-------------|
| `/analyze`     | POST   | `{ "text" }` |
| **Response:** `{ "word_count": 3, "sentiment": 0.5 }`

---

### 💡 Example Usage

```bash
curl -X POST http://localhost:8080/api/text \
     -H "Content-Type: application/json" \
     -d '{"text": "This is a wonderful project!"}'
