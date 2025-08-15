import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class App {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;
    static String[][] inventario = new String[5][3];

    public static void main(String[] args) throws Exception {

        for (int i = 0; i < inventario.length; i++) {
            for (int j = 0; j < inventario[i].length; j++) {
                inventario[i][j] = "";
            }
        }

        int opcionMenu = 0;
        do {
            out.println("\n1) Llenar inventario");
            out.println("2) Facturar");
            out.println("3) Salir");
            out.print("Elige una opción: ");
            opcionMenu = Integer.parseInt(in.readLine());

            switch (opcionMenu) {
                case 1:
                    llenarInventario();
                    break;
                case 2:
                    procesarFactura();
                    break;
                case 3:
                    out.println("Programa finalizado.");
                    break;
                default:
                    out.println("Opción inválida.");
            }
        } while (opcionMenu != 3);
    }

    static void llenarInventario() throws Exception {

        for (int i = 0; i < inventario.length; i++) {
            out.print("Código (ENTER para finalizar): ");
            String codigo = in.readLine();
            if (codigo.isEmpty()) {
                break;
            }

            out.print("Nombre: ");
            String nombre = in.readLine();

            out.print("Precio unitario: ");
            String precio = in.readLine();

            inventario[i][0] = codigo;
            inventario[i][1] = nombre;
            inventario[i][2] = precio;
        }
    }

    static void procesarFactura() throws Exception {
        int total = 0;

        while (true) {
            out.print("Código (FIN para finalizar): ");
            String codigo = in.readLine();
            if (codigo.equalsIgnoreCase("FIN")) {
                break;
            }

            out.print("Cantidad: ");
            int cantidad = Integer.parseInt(in.readLine());

            int indice = -1;
            for (int i = 0; i < inventario.length; i++) {
                if (inventario[i][0].equalsIgnoreCase(codigo)) {
                    indice = i;
                    break;
                }
            }

            if (indice != -1) {
                int precio = Integer.parseInt(inventario[indice][2]);
                int importe = cantidad * precio;
                out.println(inventario[indice][1] + " -> " + importe);
                total += importe;
            }
        }
        out.println("Total a pagar: " + total);
    }
}
