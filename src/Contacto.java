public class Contacto {
    private String nombre;
    private int numTelefono;

    public Contacto() {
        nombre = null;
        numTelefono = 0;
    }

    public Contacto (String nombre, int numTelefono) {
        this.nombre = nombre;
        this.numTelefono = numTelefono;
    }

    public void setNombre (String nombre) {
        this.nombre = nombre;
    }

    public void setNumTelefono (int numTelefono) {
        this.numTelefono = numTelefono;
    }

    public String getNombre () {
        return nombre;
    }

    public int getNumTelefono () {
        return numTelefono;
    }
}
