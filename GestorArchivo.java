import java.io.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class GestorArchivo {
    private final String ARCHIVO_CLIENTES = "clientes.csv";
    private final String ARCHIVO_PEDIDOS = "pedidos.csv";

    // GUARDAR CLIENTE (Opción 1)
    public void guardarCliente(Cliente c) {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(ARCHIVO_CLIENTES, true)))) {
            out.println(c.getId() + "," + c.getNombre() + "," + c.getApellido() + "," + c.getTelefono() + "," + c.getActivo());
            System.out.println("Cliente guardado.");
        } catch (IOException e) {
            System.out.println("Error al guardar cliente.");
        }
    }

    // LISTAR CLIENTES (Opción 2)
    public void listarClientes() {
        Path ruta = Paths.get(ARCHIVO_CLIENTES);
        try (BufferedReader br = Files.newBufferedReader(ruta, StandardCharsets.UTF_8)) {
            String linea;
            System.out.println("\nID | Nombre | Apellido | Teléfono | Activo");
            while ((linea = br.readLine()) != null) {
                String[] d = linea.split(",");
                if (d[4].equals("1")) { // Solo si activo es 1
                    System.out.println(d[0] + " | " + d[1] + " | " + d[2] + " | " + d[3] + " | SI");
                }
            }
        } catch (IOException e) { System.out.println("Archivo no encontrado."); }
    }

    // ELIMINACIÓN LÓGICA (Opción 3)
    public void eliminarCliente(int idAEliminar) {
        List<String> lineasActualizadas = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(ARCHIVO_CLIENTES))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] d = linea.split(",");
                if (Integer.parseInt(d[0]) == idAEliminar) {
                    lineasActualizadas.add(d[0] + "," + d[1] + "," + d[2] + "," + d[3] + ",0"); // Cambiamos a 0
                } else {
                    lineasActualizadas.add(linea);
                }
            }
            Files.write(Paths.get(ARCHIVO_CLIENTES), lineasActualizadas, StandardCharsets.UTF_8);
            System.out.println("Cliente desactivado (eliminación lógica).");
        } catch (IOException e) { System.out.println("Error al eliminar."); }
    }

    // GUARDAR PEDIDO (Opción 4)
    public void guardarPedido(Pedido p) {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(ARCHIVO_PEDIDOS, true)))) {
            out.println(p.getIdPedido() + "," + p.getIdCliente() + "," + p.getProducto() + "," + p.getPrecio() + "," + p.getCantidad() + "," + p.getActivo());
            System.out.println("Pedido guardado.");
        } catch (IOException e) { System.out.println("Error al guardar pedido."); }
    }

    // LISTAR PEDIDOS DE UN CLIENTE (Opción 5)
    public void listarPedidosCliente(int idBuscado) {
        try (BufferedReader br = Files.newBufferedReader(Paths.get(ARCHIVO_PEDIDOS))) {
            String linea;
            System.out.println("\nPedidos del cliente " + idBuscado + ":");
            while ((linea = br.readLine()) != null) {
                String[] d = linea.split(",");
                if (Integer.parseInt(d[1]) == idBuscado && d[5].equals("1")) {
                    System.out.println("- " + d[2] + " | Precio: " + d[3] + " | Cant: " + d[4]);
                }
            }
        } catch (IOException e) { System.out.println("No hay pedidos registrados."); }
    }
}