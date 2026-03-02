public static void EliminarCliente(int idCliente) {
    String archivo = "clientes.csv";
    List<String> lineas = new ArrayList<>();
    boolean encontrado = false;

    try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
        String linea;

        while ((linea = br.readLine()) != null) {
            String[] datos = linea.split(",");

            if (datos[0].equals(String.valueOf(idCliente))) {
                datos[4] = "0"; 
                encontrado = true;
                linea = String.join(",", datos);
            }

            lineas.add(linea);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    // Sobrescribir archivo con cambios
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
        for (String l : lineas) {
            bw.write(l);
            bw.newLine();
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    if (encontrado) {
        System.out.println("Cliente eliminado lógicamente.");
    } else {
        System.out.println("Cliente no encontrado.");
    }
}