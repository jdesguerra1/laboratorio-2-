import java.is BufferendReader;
import java.is FileReader;
import java.is IOException;

public class gestionclientes{

private static final String clientes_file = "clientes.cvs";

public static void listarciente(){
    try(bufferedReader br = new BufferendReader(new FileReader(clientes_file))){
        String linea;
        System.out.println("=== listado de clientes ===");
        while ((linea = br.readLine()) != null){
            if (linea.startsWith("id_cliente")){
                continue;
            }

            String[] datos = linea.split(" , ");
            if (datos.length >= 5) {
                String id = datos[0];
                String nombre = datos[1];
                String apellido = datos[2];
                String telefono = datos[3];
                String activos = datos[4];
            }

            if("1".equals(activo)){
                System.out.println("ID: "+id+
                " | Nombre: "+nombre+
                " | Apellido: "+apellido+
                " | Telefono: "+ telefono
            }
        }
    }
} catch (IOException e){
    System.out.println("error al leer el archivo de clientes: "+e.getMEssage());
    
}

}
 public static void main(String[] arg){
    listarciente();
 }