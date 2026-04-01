package servidor;

/**
 * Clase que almacena los requisitos de la contraseña
 * que el cliente quiere generar.
 */
public class RequisitosPass {

    // Atributos  
    private int numMayusculas;
    private int numMinusculas;
    private int numDigitos;
    private int numCaractEspeciales;

    // Constructor vacío
    public RequisitosPass() {}

    // Getters
    public int getNumMayusculas() {
        return numMayusculas;
    }

    public int getNumMinusculas() {
        return numMinusculas;
    }

    public int getNumDigitos() {
        return numDigitos;
    }

    public int getNumCaractEspeciales() {
        return numCaractEspeciales;
    }

    // Setters
    public void setNumMayusculas(int numMayusculas) {
        this.numMayusculas = numMayusculas;
    }

    public void setNumMinusculas(int numMinusculas) {
        this.numMinusculas = numMinusculas;
    }

    public void setNumDigitos(int numDigitos) {
        this.numDigitos = numDigitos;
    }

    public void setNumCaractEspeciales(int numCaractEspeciales) {
        this.numCaractEspeciales = numCaractEspeciales;
    }

    // toString para ver los valores  
    @Override
    public String toString() {
        return "RequisitosPass{"
                + "numMayusculas=" + numMayusculas
                + ", numMinusculas=" + numMinusculas
                + ", numDigitos=" + numDigitos
                + ", numCaractEspeciales=" + numCaractEspeciales
                + '}';
    }
}