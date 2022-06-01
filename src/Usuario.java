import java.util.Scanner;

public class Usuario {
    private int numTelefono;
    private Agenda agenda;

    public Usuario (int numTelefono) {
        this.numTelefono = numTelefono;
        this.agenda = new Agenda();
    }

    public Mensaje enviarMensaje (int destinatario) {
        Scanner sc = new Scanner(System.in);
        String temporal = sc.nextLine();
        Mensaje m = new Mensaje(temporal, this.getNumTelefono(), destinatario);
        return m;
        
    }

    public void setNumTelefono (int numTelefono) {
        this.numTelefono = numTelefono;
    }

    public void setAgenda (Agenda agenda) {
        this.agenda = agenda;
    }

    public int getNumTelefono () {
        return numTelefono;
    }

    public Agenda getAgenda () {
        return agenda;
    }
}
