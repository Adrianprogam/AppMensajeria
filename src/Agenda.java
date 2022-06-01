import java.util.ArrayList;
public class Agenda {
    private ArrayList <Contacto> contactos;
    
    public Agenda () {
        contactos = new ArrayList<Contacto>();
    }

    public void addContacto (Contacto contacto) {
        contactos.add (contacto);
    }

    public void delContacto (int num) {
        contactos.remove (num);
    }

    public void verAgenda () {
        for (int i = 0; i<contactos.size(); i++) {
            System.out.println(i+1 + ". " + contactos.get(i).getNombre() + "    " + contactos.get(i).getNumTelefono());
        }
        if (contactos.size()==0) {
            System.out.println("\nNo tiene contactos");
        }
    }

    public void setContactos (ArrayList<Contacto> contactos) {
        this.contactos = contactos;
    }

    public ArrayList<Contacto> getContactos () {
        return contactos;
    }

    
}



