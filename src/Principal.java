import java.util.Scanner;
import java.util.ArrayList;
public class Principal {
    static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    static ArrayList<Mensaje> chats = new ArrayList<Mensaje>();

    public static boolean comprobarTelefono (int telefono) { //Comprueba si el número introducido es de 9 dígitos
        boolean b = false;
        String temp = Integer.toString(telefono);
        if (temp.length()==9) {
            b = true;
        }
        return b;
        }

    public static boolean comprobarMenu (int num) { //Comprueba que el número introducido es una opción válida del menú
        boolean b = false;
        if (num>0 && num<8) {
            b = true;
        }
        return b;
    }

    public static boolean numeroRegistrado (int telefono) { //Comprueba si un número se ha registrado con anterioridad
        boolean b = false;
        for (int i = 0; i<usuarios.size(); i++) {
            if (usuarios.get(i).getNumTelefono()==telefono) {
                b = true;
            }
        }
        return b;
    }

    public static int recorrerArray (int telefono) { //Devuelve la posicion en la que se encuentra el usuario en el array de usuarios registrados
        int num = 0;
        for (int i = 0; i<usuarios.size(); i++) {
            if (usuarios.get(i).getNumTelefono()==telefono) {
                num = i;
            }
        }
        return num;
    }
    

    public static void imprimirMenu () {
        System.out.println("\n         MENÚ");
        System.out.println("=====================");
        System.out.println("1) Enviar mensaje");
        System.out.println("2) Ver mensajes enviados");
        System.out.println("3) Ver mensajes recibidos");
        System.out.println("4) Ver mensajes recibidos de un número");
        System.out.println("5) Ver/editar agenda");
        System.out.println("6) Cerrar sesión");
        System.out.println("7) Funciones administrador");
        System.out.print("\n¿Que desea hacer? ");
    }

    public static void imprimirMenuAgenda () {
        System.out.println("\n1) Añadir contacto");
        System.out.println("2) Eliminar contacto");
        System.out.println("3) Volver atrás");
        System.out.print("\n¿Que desea hacer? ");
    }

    public static void verMensajesEnviados (int telefono) {
        for (int i = 0; i<chats.size(); i++) {
            if (chats.get(i).getNumEmisor()==telefono) {
                System.out.println(chats.get(i).getMensaje() + "  " + chats.get(i).getNumReceptor());
            }
        }
    }

    public static void verMensajesRecibidos (int telefono) {
        for (int i = 0; i<chats.size(); i++) {
            if (chats.get(i).getNumReceptor()==telefono) {
                System.out.println(chats.get(i).getMensaje() + "  " + chats.get(i).getNumEmisor());
            }
        }
    }

    public static void verMensajesRecibidosDe (int telefono1, int telefono2) {
        for (int i = 0; i<chats.size(); i++) {
            if (chats.get(i).getNumReceptor()==telefono1 && chats.get(i).getNumEmisor()==telefono2) {
                System.out.println(chats.get(i).getMensaje() + "  " + chats.get(i).getNumEmisor());
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int numMenu = 0;
            System.out.print("\nIntroduzca su número de teléfono, por favor ");
            int telefono = sc.nextInt();
            if (comprobarTelefono(telefono)==true) {
                if (numeroRegistrado(telefono)==true) {
                    System.out.println("\nBienvenido de nuevo"); //Si ya estás registrado te da la bienvenida
                }

                if (numeroRegistrado(telefono)==false) {
                    System.out.println("\nPulsa 5 si eres admnisitrador");
                    int n = sc.nextInt();
                    if (n==5) {
                        System.out.println("Número registrado correctamente como un administrador");
                        Administrador a = new Administrador(telefono);
                        usuarios.add(a);
                    }
                    else {
                        System.out.println("\nNúmero registrado correctamente como usuario"); //Si no estabas registrado, te avisa de que tu número se ha registrado
                        Usuario u = new Usuario(telefono);
                        usuarios.add(u);
                    }
                }
                
                while (numMenu<1 || numMenu >7) {
                    imprimirMenu();
                    numMenu = sc.nextInt();
                    if (comprobarMenu(numMenu) == true) {
                        switch (numMenu) {
                            case 1:
                                System.out.print("\nEscribe el número del destinatario ");
                                int numEnviar = sc.nextInt();
                                if (comprobarTelefono(numEnviar)==true) {
                                    System.out.println("\nEscribe el mensaje ");
                                    chats.add(usuarios.get(recorrerArray(telefono)).enviarMensaje(numEnviar));
                                    System.out.println("\nMensaje enviado");
                                    System.out.println(chats.get(0).getMensaje());
                                    System.out.println(chats.get(0).getNumEmisor());
                                    System.out.println(chats.get(0).getNumReceptor());
                                    numMenu=0;
                                }
                                else {
                                    System.out.println("\nNúmero no válido");
                                    numMenu=0;
                                }
                                break;
                            case 2:
                                System.out.println("\nEstos son los mensajes que has enviado");
                                System.out.println();
                                verMensajesEnviados(telefono);
                                numMenu=0;
                                break;
                            case 3:
                                System.out.println("Estos son los mensajes que has recibido");
                                System.out.println();
                                verMensajesRecibidos(telefono);
                                numMenu=0;
                                break;
                            case 4:
                                System.out.println("Indica el número");
                                int telefono2 = sc.nextInt();
                                verMensajesRecibidosDe(telefono, telefono2);
                                numMenu=0;
                                break;
                            case 5:
                                int numMenuAgenda = 0;
                                usuarios.get(recorrerArray(telefono)).getAgenda().verAgenda();
                                while (numMenuAgenda<1 || numMenuAgenda>3) {
                                    imprimirMenuAgenda();
                                    numMenuAgenda = sc.nextInt();
                                    if (numMenuAgenda>0 && numMenuAgenda<4) {
                                        switch (numMenuAgenda) {
                                            case 1:
                                                System.out.print("\nIntroduce un nombre ");
                                                sc.nextLine();
                                                String nombre = sc.nextLine();
                                                System.out.print("\nIntroduce su número ");
                                                int numero = sc.nextInt();
                                                if (comprobarTelefono(numero)==true) {
                                                    Contacto contacto = new Contacto(nombre, numero);
                                                    usuarios.get(recorrerArray(telefono)).getAgenda().addContacto(contacto);
                                                    System.out.println("\nContacto añadido");
                                                }
                                                else {
                                                    System.out.println("\nNúmero no válido");
                                                }
                                                numMenuAgenda = 0;
                                                break;
                                            case 2:
                                                if (usuarios.get(recorrerArray(telefono)).getAgenda().getContactos().size()>0) {
                                                    System.out.println("\nIntroduce el número del índice de la agenda del contacto que quieras eliminar ");
                                                    int indice = sc.nextInt();
                                                    usuarios.get(recorrerArray(telefono)).getAgenda().delContacto(indice-1);
                                                    System.out.println("\nContacto eliminado");
                                                }
                                                else {
                                                    System.out.println("\nNo hay contactos que eliminar");
                                                }
                                                numMenuAgenda = 0;
                                                break;
                                            case 3:
                                                numMenu = 0;
                                                break;
                                        }
                                    }
                                    else {
                                        System.out.println("\nVuelve a intentarlo");
                                    }
                                }
                                break;
                            case 6:
                                System.out.println("\nSesión cerrada correctamente, vuelva pronto");
                                break;
                            case 7:
                                int n2 = recorrerArray(telefono);
                                if (usuarios.get(n2)instanceof Administrador) {
                                    System.out.println("\nIntroduce el número al que desea observar");
                                    int n3 = sc.nextInt();
                                    System.out.println(("\n1) Ver mensajes enviados"));
                                    System.out.println(("2) Ver mensajes recibidos"));
                                    System.out.println(("\nIntroduce un número"));
                                    int n4 = sc.nextInt();
                                    if (n4==1) {
                                        verMensajesEnviados(n3);
                                    }
                                    if (n4==2) {
                                        verMensajesRecibidos(n3);
                                    }
                                }
                                else {
                                    System.out.println("\nFunción exclusiva de administradores");
                                    numMenu=0;
                                }
                                break;
                            
                        }
                }
                else {
                    System.out.println("\nVuelve a intentarloaa");
                }
            }

            }
            else {
                System.out.println("\nIntroduce un número correcto");
            }
        }
    }
}
