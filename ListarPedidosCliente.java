import java.util.List;
import java.util.Scanner;

public class ListarPedidosCliente {
    public void ejecutar() {
        Scanner sn = new Scanner(System.in);
        System.out.print("Ingrese el ID del cliente para ver sus pedidos: ");
        int idBuscado = sn.nextInt();

        List<String[]> todosLosPedidos = GestorArchivos.leerPedidos();
        boolean encontro = false;

        System.out.println("\nPedidos del Cliente ID: " + idBuscado);
        System.out.println("------------------------------------------");
        
        for (String[] p : todosLosPedidos) {
            int idClienteEnPedido = Integer.parseInt(p[1]); // id_cliente es la columna 1
            boolean activo = p[5].equals("1"); // activo es la columna 5

            if (idClienteEnPedido == idBuscado && activo) {
                System.out.printf("Producto: %s | Precio: %s | Cantidad: %s\n", p[2], p[3], p[4]);
                encontro = true;
            }
        }

        if (!encontro) {
            System.out.println("No se encontraron pedidos activos para este cliente.");
        }
    }
}