# Chat Application

This is a real-time chat application built using Spring Boot and WebSocket. The application allows users to join, chat, and leave chat rooms in real-time.

## Features

- Real-time messaging using WebSocket
- User management with notifications for new messages
- Persistent chat history
- Multiple chat rooms support

## Technologies Used

### Backend

- Spring Boot
- WebSocket
- Maven

### Frontend

- HTML, CSS, JavaScript

### Database

- MongoDB (for storing chat history and user data)

## Prerequisites

Before running this application, make sure you have:

- Java 11 or higher
- Maven 3.6 or higher
- MongoDB installed and running

## Getting Started

### Clone the repository

```bash
git clone <repository-url>
cd ChatApplication
ChatApplication/
│
├── src/main/java/com/practise/local/
│   ├── ChatApplication.java               # Main Spring Boot Application
│   ├── config/WebSocketConfig.java        # WebSocket configuration
│   ├── controller/
│   │   ├── ChatController.java            # Handles chat messages
│   │   └── UserController.java            # Manages user-related operations
│   ├── model/
│   │   ├── ChatMessage.java               # Represents a chat message
│   │   ├── ChatNotification.java          # Notification model for new messages
│   │   ├── ChatRoom.java                  # Represents a chat room
│   │   └── User.java                      # Represents a user
│   ├── repository/
│   │   ├── ChatMessageRepository.java     # Repository for chat messages
│   │   └── UserRepository.java            # Repository for user data
│   └── service/
│       ├── ChatMessageService.java        # Service to manage chat messages
│       └── UserService.java               # Service to manage user operations
│
├── src/main/resources/static/              # Static files (HTML, CSS, JS)
├── pom.xml                                 # Project dependencies
├── HELP.md                                 # Help and additional information
└── README.md                               # Project documentation (this file)
