# Password Generator using Sockets

A Java client-server application that generates random passwords using sockets.

## About this project

Built to practice socket programming and client-server architecture in Java. The client sends password requirements to the server, which generates and returns a secure random password — all through a TCP socket connection.

## How it works

1. The client connects to the server via socket
2. The user sets password requirements: uppercase, lowercase, digits, special characters
3. The server generates the password and sends it back to the client

## Technologies

- Java
- Sockets (TCP/IP)
- Object-Oriented Programming

## Project Structure

```text
├── servidor/
│   ├── RequisitosPass.java   # POJO storing password requirements
│   ├── ServicioPass.java     # Password generation logic
│   ├── Servidor.java         # Server socket management
│   └── MainServidor.java     # Server entry point
├── cliente/
│   ├── Cliente.java          # Client socket management
│   └── MainCliente.java      # Client entry point
```
## How to run

1. Run `MainServidor.java` first
2. Then run `MainCliente.java`
3. Follow the console instructions to set your password requirements
