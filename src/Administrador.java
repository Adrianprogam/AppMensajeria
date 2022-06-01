public class Administrador extends Usuario {
    private Agenda agenda;
    
    public Administrador (int numTelefono) {
        super(numTelefono);
        this.agenda = new Agenda();
    }
    
}
