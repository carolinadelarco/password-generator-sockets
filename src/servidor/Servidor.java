package servidor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Clase que gestiona la conexión del servidor con el cliente
 * a través de un socket. Recibe los requisitos y devuelve
 * la contraseña generada.
 */
public class Servidor {

    // Dirección y puerto de conexión
    private static final int PUERTO = 4321;

    // Servicio para generar contraseñas
    private ServicioPass servicioPass = new ServicioPass();

    /**
     * Inicia el servidor y se queda a la espera de conexiones.
     * Por cada cliente que se conecta, gestiona la comunicación completa.
     */
    public void iniciar() {

        System.out.println("Servidor iniciado. Esperando conexiones...");

        try (ServerSocket serverSocket = new ServerSocket(PUERTO)) {

            // Bucle infinito para atender múltiples clientes
            while (true) {

                // Esperar a que un cliente se conecte
                Socket socket = serverSocket.accept();

                // Flujos de entrada y salida
                BufferedReader entrada = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);

                // Pedir el nombre del cliente
                salida.println("¿Cuál es tu nombre?");
                String nombre = entrada.readLine();

                // Dar la bienvenida al cliente
                salida.println("¡Bienvenido/a, " + nombre + "!");
                salida.println("Te ayudaré a generar una contraseña aleatoria.");

                // Crear objeto para guardar los requisitos
                RequisitosPass requisitos = new RequisitosPass();

                // Pedir número de mayúsculas
                salida.println("¿Cuántas mayúsculas quieres en tu contraseña?");
                requisitos.setNumMayusculas(Integer.parseInt(entrada.readLine()));

                // Pedir número de minúsculas
                salida.println("¿Cuántas minúsculas quieres en tu contraseña?");
                requisitos.setNumMinusculas(Integer.parseInt(entrada.readLine()));

                // Pedir número de dígitos
                salida.println("¿Cuántos dígitos quieres en tu contraseña?");
                requisitos.setNumDigitos(Integer.parseInt(entrada.readLine()));

                // Pedir número de caracteres especiales
                salida.println("¿Cuántos caracteres especiales quieres en tu contraseña?");
                requisitos.setNumCaractEspeciales(Integer.parseInt(entrada.readLine()));

                // Calcular y enviar la longitud total
                int longitud = servicioPass.getLongitudPassword(requisitos);
                salida.println("La contraseña tendrá una longitud de " + longitud + " caracteres.");

                // Preguntar si desea generar la contraseña
                salida.println("¿Deseas generar la contraseña ahora? (si/no)");
                String respuesta = entrada.readLine();

                if (respuesta.equalsIgnoreCase("si")) {
                    // Generar y enviar la contraseña
                    String password = servicioPass.generarPassword(requisitos);
                    salida.println("Tu contraseña es: " + password);
                } else {
                    // Informar que no se generará contraseña y despedirse
                    salida.println("De acuerdo, no se generará ninguna contraseña. ¡Hasta pronto!");
                }

                // Cerrar la conexión con este cliente
                socket.close();
                System.out.println("Cliente desconectado. Esperando nueva conexión...");
            }

        } catch (Exception e) {
            System.out.println("Error en el servidor: " + e.getMessage());
        }
    }
}