package servidor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Clase que contiene la lógica principal para generar contraseñas.
 * Usa los requisitos definidos en RequisitosPass.
 */
public class ServicioPass {

    // Caracteres disponibles para cada tipo
    private static final String MAYUSCULAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String MINUSCULAS = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITOS = "0123456789";
    private static final String ESPECIALES = "!@#$%^&*()_-+=.:?";

    private Random random = new Random();

    /**
     * Calcula y devuelve la longitud total de la contraseña
     * sumando todos los requisitos.
     */
    public int getLongitudPassword(RequisitosPass requisitos) {
        return requisitos.getNumMayusculas()
                + requisitos.getNumMinusculas()
                + requisitos.getNumDigitos()
                + requisitos.getNumCaractEspeciales();
    }

    /**
     * Genera una contraseña aleatoria según los requisitos indicados.
     * Mezcla los caracteres para que no vayan en orden fijo.
     */
    public String generarPassword(RequisitosPass requisitos) {

        List<Character> caracteres = new ArrayList<>();

        // Añadir mayúsculas aleatorias
        for (int i = 0; i < requisitos.getNumMayusculas(); i++) {
            caracteres.add(MAYUSCULAS.charAt(random.nextInt(MAYUSCULAS.length())));
        }

        // Añadir minúsculas aleatorias
        for (int i = 0; i < requisitos.getNumMinusculas(); i++) {
            caracteres.add(MINUSCULAS.charAt(random.nextInt(MINUSCULAS.length())));
        }

        // Añadir dígitos aleatorios
        for (int i = 0; i < requisitos.getNumDigitos(); i++) {
            caracteres.add(DIGITOS.charAt(random.nextInt(DIGITOS.length())));
        }

        // Añadir caracteres especiales aleatorios
        for (int i = 0; i < requisitos.getNumCaractEspeciales(); i++) {
            caracteres.add(ESPECIALES.charAt(random.nextInt(ESPECIALES.length())));
        }

        // Mezclar para que no salgan agrupados por tipo
        Collections.shuffle(caracteres, random);

        // Convertir la lista a String
        StringBuilder password = new StringBuilder();
        for (char c : caracteres) {
            password.append(c);
        }

        return password.toString();
    }
}