package cliente;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Clase que gestiona la conexión del cliente con el servidor
 * a través de un socket. Envía los requisitos y recibe
 * la contraseña generada.
 */
public class Cliente {

    // Dirección y puerto de conexión
    private static final String DIRECCION = "localhost";
    private static final int PUERTO = 4321;

    // Para leer la entrada del usuario por teclado
    private BufferedReader teclado = new BufferedReader(
            new InputStreamReader(System.in));

    /**
     * Inicia la conexión con el servidor y gestiona
     * la comunicación.
     */
    public void iniciar() {

        try (Socket socket = new Socket(DIRECCION, PUERTO)) {

            // Flujos de entrada y salida con el servidor
            BufferedReader entrada = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);

            // Recibir y mostrar pregunta del nombre, enviar respuesta
            System.out.println(entrada.readLine());
            salida.println(teclado.readLine());

            // Recibir y mostrar bienvenida
            System.out.println(entrada.readLine());

            // Recibir y mostrar introducción a la funcionalidad
            System.out.println(entrada.readLine());

            // Recibir pregunta de mayúsculas, leer y enviar respuesta
            System.out.println(entrada.readLine());
            salida.println(teclado.readLine());

            // Recibir pregunta de minúsculas, leer y enviar respuesta
            System.out.println(entrada.readLine());
            salida.println(teclado.readLine());

            // Recibir pregunta de dígitos, leer y enviar respuesta
            System.out.println(entrada.readLine());
            salida.println(teclado.readLine());

            // Recibir pregunta de caracteres especiales, leer y enviar respuesta
            System.out.println(entrada.readLine());
            salida.println(teclado.readLine());

            // Recibir y mostrar la longitud total de la contraseña
            System.out.println(entrada.readLine());

            // Recibir pregunta de confirmación, leer y enviar respuesta
            System.out.println(entrada.readLine());
            String respuesta = teclado.readLine();
            salida.println(respuesta);

            // Recibir y mostrar el mensaje final del servidor
            System.out.println(entrada.readLine());

        } catch (Exception e) {
            System.out.println("Error en el cliente: " + e.getMessage());
        }
    }
}