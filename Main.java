import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestorArchivo gestor = new GestorArchivo();
        int opcion = 0;

        while (opcion != 6) {
            System.out.println("\n--- GESTIÓN DE CLIENTES Y PEDIDOS ---");
            System.out.println("1. Registrar cliente\n2. Listar clientes\n3. Eliminar cliente\n4. Registrar pedido\n5. Listar pedidos de un cliente\n6. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("ID: "); int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Nombre: "); String n = sc.nextLine();
                    System.out.print("Apellido: "); String a = sc.nextLine();
                    System.out.print("Tel: "); String t = sc.nextLine();
                    gestor.guardarCliente(new Cliente(id, n, a, t, 1));
                    break;
                case 2:
                    gestor.listarClientes();
                    break;
                case 3:
                    System.out.print("ID a eliminar: ");
                    gestor.eliminarCliente(sc.nextInt());
                    break;
                case 4:
                    System.out.print("ID Pedido: "); int ip = sc.nextInt();
                    System.out.print("ID Cliente: "); int ic = sc.nextInt(); sc.nextLine();
                    System.out.print("Producto: "); String pr = sc.nextLine();
                    System.out.print("Precio: "); double pre = sc.nextDouble();
                    System.out.print("Cantidad: "); int can = sc.nextInt();
                    gestor.guardarPedido(new Pedido(ip, ic, pr, pre, can, 1));
                    break;
                case 5:
                    System.out.print("ID del cliente: ");
                    gestor.listarPedidosCliente(sc.nextInt());
                    break;
            }
        }
    }
}