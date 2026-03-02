import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestorArchivos {
    private static final String FILE_CLIENTES = "clientes.csv";
    private static final String FILE_PEDIDOS = "pedidos.csv";

    // Cargar Clientes desde CSV
    public static List<Cliente> leerClientes() {
        List<Cliente> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_CLIENTES))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] d = linea.split(",");
                lista.add(new Cliente(Integer.parseInt(d[0]), d[1], d[2], d[3], d[4].equals("1")));
            }
        } catch (IOException e) { System.out.println("Archivo de clientes no encontrado, iniciando nuevo."); }
        return lista;
    }

    // Cargar Pedidos desde CSV (Similar para el archivo pedidos.csv)
    public static List<String[]> leerPedidos() {
        List<String[]> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PEDIDOS))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lista.add(linea.split(","));
            }
        } catch (IOException e) { }
        return lista;
    }
    
    // Método para guardar listas (lo usarán tus compañeros al registrar o borrar)
    public static void guardarClientes(List<Cliente> clientes) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_CLIENTES))) {
            for (Cliente c : clientes) pw.println(c.toCSV());
        } catch (IOException e) { e.printStackTrace(); }
    }
}