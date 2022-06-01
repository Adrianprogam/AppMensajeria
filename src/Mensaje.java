public class Mensaje {
    private String mensaje;
    private int numEmisor;
    private int numReceptor;

    public Mensaje (String mensaje, int numEmisor, int numReceptor) {
        this.mensaje = mensaje;
        this.numEmisor = numEmisor;
        this.numReceptor = numReceptor;
    }

    public void setMensaje (String mensaje) {
        this.mensaje = mensaje;
    }

    public void setNumEmisor (int numEmisor) {
        this.numEmisor = numEmisor;
    }

    public void setNumRecpetor (int numReceptor) {
        this.numReceptor = numReceptor;
    }

    public String getMensaje () {
        return mensaje;
    }

    public int getNumEmisor () {
        return numEmisor;
    }

    public int getNumReceptor () {
        return numReceptor;
    }
}
