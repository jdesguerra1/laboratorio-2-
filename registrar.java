public class Cliente{
    private int id;
    private String nombre;
    private String apellido;
    private String telefono;
    private int activo; //1 para activo y 0 para inactivo

    public Cliente(int id, String nombre,String apellido,String telefono,int activo){
        this.id=id;
        this.nombre=nombre;
        this.apellido=apellido;
        this.telefono=telefono;
        this.activo=activo;
    }
    public String toCSV(){
        return id + "," + nombre + "," + apellido + "," + telefono + "," + activo;

    }
}

public class RegistroClientes{
    public static void guardar(Cliente c){
        try (FileWriter fw = new FileWriter("clientes.csv", true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println(c.toCSV());
        } catch (IOException e) {
            System.out.println("Error al guardar.");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 1. Pedir datos al usuario
        System.out.print("Digite el Nombre: ");
        String nom = sc.nextLine();
        System.out.print("Digite el Apellido: ");
        String ape = sc.nextLine();
        System.out.print("Digite el Teléfono: ");
        String tel = sc.nextLine();
        
        // 2. Crear el objeto 
        Cliente nuevo = new Cliente(1, nom, ape, tel, 1);
        
        guardar(nuevo);
        
        System.out.println("Cliente guardado");
    }
    }

}