public class Pedido {
    private int idPedido;
    private int idCliente;
    private String producto;
    private double precio;
    private int cantidad;
    private int activo;

    public Pedido(int idPedido, int idCliente, String producto, double precio, int cantidad, int activo) {
        this.idPedido = idPedido;
        this.idCliente = idCliente;
        this.producto = producto;
        this.precio = precio;
        this.cantidad = cantidad;
        this.activo = activo;
    }

    public int getIdPedido() { return idPedido; }
    public int getIdCliente() { return idCliente; }
    public String getProducto() { return producto; }
    public double getPrecio() { return precio; }
    public int getCantidad() { return cantidad; }
    public int getActivo() { return activo; }
}