// Cliente.java
public class Cliente {
    int id;
    String nombre, apellido, telefono;
    boolean activo;

    public Cliente(int id, String nombre, String apellido, String telefono, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.activo = activo;
    }

    public String toCSV() {
        return id + "," + nombre + "," + apellido + "," + telefono + "," + (activo ? "1" : "0");
    }
}