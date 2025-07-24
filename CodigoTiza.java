import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class App {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws Exception {
        boolean logroCajon = false;
        int intentos = 0;
        String entrada = "";
        int respuesta = 0;

        out.println();
        out.println("Cajón con Cerradura! Desafío: Códigos de Tiza");
        out.println("En la parte superior del cajón, hay números escritos con tiza blanca:");

        do {
            out.println();
            out.println("0, 1, 4, 9, 16 y... ?"); // 5!
            out.print("Ingresa el número que continúa la secuencia: ");
            entrada = in.readLine();

            // Validación de que la entrada sea numérica
            if (entrada.matches("[0-9]+")) {
                respuesta = Integer.parseInt(entrada);

                // Verifica si la respuesta corresponde al siguiente cuadrado perfecto (5^2 = 25)
                if (respuesta == 25) {
                    out.println();
                    out.println("El cajón hace clic... la cerradura ha cedido.");
                    out.println("PISTA: A veces el patrón está más cerca de lo que crees. Solo hay que elevarse.");
                    logroCajon = true;
                } else {
                    out.println("No parece encajar. El candado permanece cerrado.");
                }
            } else {
                out.println("Entrada inválida. Solo puedes escribir números enteros positivos.");
            }

            intentos++;

            // Pista textual tras el segundo intento fallido
            if (!logroCajon && intentos == 2) {
                out.println("Esta secuencia es potente, eh...");
            }

        } while (!logroCajon && intentos < 3);

        // Resultado final según éxito o fracaso en el minijuego
        if (!logroCajon) {
            out.println();
            out.println("Has agotado los intentos. El mecanismo del cajón se traba definitivamente.");
        } else {
            out.println();
            out.println("Has obtenido una pista clave del cajón.");
        }
    }
}
