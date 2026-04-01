package servidor;

/**
 * Clase principal que arranca el servidor.
 */
public class MainServidor {

    public static void main(String[] args) {
        // Crear el servidor y arrancarlo
        Servidor servidor = new Servidor();
        servidor.iniciar();
    }
}