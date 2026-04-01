# Password Generator using Sockets

Java client-server application that generates random passwords using sockets.

## Description
A server and a client communicate through a socket. The client sends the password requirements (uppercase, lowercase, digits and special characters) and the server generates and returns a random password.

## Technologies
- Java
- Sockets
- Object-Oriented Programming

## Project Structure
- `servidor/RequisitosPass` - POJO that stores password requirements
- `servidor/ServicioPass` - Logic to generate the password
- `servidor/Servidor` - Manages the server socket connection
- `servidor/MainServidor` - Server entry point
- `cliente/Cliente` - Manages the client socket connection
- `cliente/MainCliente` - Client entry point

## How to run
1. Run `MainServidor.java` first
2. Then run `MainCliente.java`
3. Follow the instructions in the console