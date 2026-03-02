import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- GESTIÓN DE PEDIDOS ---");
            System.out.println("1. Registrar Cliente");
            System.out.println("2. Listar Clientes");
            System.out.println("3. Eliminar Cliente");
            System.out.println("4. Registrar Pedido");
            System.out.println("5. Listar Pedidos de un Cliente");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = sn.nextInt();

            switch (opcion) {
                case 1: /* Instancia de clase de compañero A */ break;
                case 2: /* Instancia de clase de compañero B */ break;
                case 5:
                    // AQUÍ LLAMAS A TU CLASE
                    ListarPedidosCliente buscador = new ListarPedidosCliente();
                    buscador.ejecutar();
                    break;
                case 6:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }
}