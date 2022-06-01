public class MensajeMultimedia extends Mensaje{
    String nombreArchivo;
    double tamanoArchivo;

    public MensajeMultimedia (String mensaje, int numEmisor, int numReceptor, String nombreArchivo, double tamanoArchivo) {
        super(mensaje, numEmisor, numReceptor);
        this.nombreArchivo = nombreArchivo;
        this.tamanoArchivo = tamanoArchivo;
    }

    public void setNombreArchivo (String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public void setTamanoArchivo (double tamanoArchivo) {
        this.tamanoArchivo = tamanoArchivo;
    }

    public String getNombreArchivo () {
        return nombreArchivo;
    }
    
    public double getTamanoArchivo () {
        return tamanoArchivo;
    }
}
