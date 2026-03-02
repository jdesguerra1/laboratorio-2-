import java.io.*;
import java.util.Scanner;

public class GestionPedidos {

    private static final String PEDIDOS_FILE = "pedidos.csv";

    public static void registrarPedido() {
        Scanner sc = new Scanner(System.in);

        try {
            // Pedir datos del pedido
            System.out.print("Ingrese el ID del cliente: ");
            String idCliente = sc.nextLine();

            System.out.print("Ingrese el nombre del producto: ");
            String producto = sc.nextLine();

            System.out.print("Ingrese el precio (opcional, presione Enter si no aplica): ");
            String precio = sc.nextLine();
            if (precio.isEmpty()) {
                precio = ""; // campo vacío si no se ingresa
            }

            System.out.print("Ingrese la cantidad (opcional, presione Enter si no aplica): ");
            String cantidad = sc.nextLine();
            if (cantidad.isEmpty()) {
                cantidad = ""; // campo vacío si no se ingresa
            }

            // Calcular el próximo ID de pedido
            int nuevoId = obtenerNuevoId();

            // Crear la línea para el CSV
            String nuevaLinea = nuevoId + "," + idCliente + "," + producto + "," + precio + "," + cantidad + ",1";

            // Escribir en el archivo
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(PEDIDOS_FILE, true))) {
                bw.write(nuevaLinea);
                bw.newLine();
            }

            System.out.println("Pedido registrado exitosamente con ID: " + nuevoId);

        } catch (IOException e) {
            System.out.println("Error al registrar el pedido: " + e.getMessage());
        }
    }