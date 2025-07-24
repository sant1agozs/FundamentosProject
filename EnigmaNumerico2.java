import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class App {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static PrintStream out = System.out;

  public static void main(String[] args) throws Exception {
    String entradaUsuario = "";
    int numero = 0;
    boolean acertado = false;
    int intentos = 1;
    boolean entradaValida = false;

    out.println("Una puerta mágica bloquea tu paso. Un enigma está grabado sobre ella:");
    out.println("\"Soy mayor que 10, menor que 20 y divisible por 3.\"");
    out.println("Tienes 3 intentos para descubrir el número correcto.");

    do {
      out.print("Intento #" + intentos + " - Ingresa tu número: ");
      entradaUsuario = in.readLine();

      // Validación manual de un valor numerico positivo
      entradaValida = entradaUsuario.matches("\\d+");

      if (entradaValida) {
        numero = Integer.parseInt(entradaUsuario);

        if (numero == 12 || numero == 15 || numero == 18) {
          out.println("¡Correcto! La puerta se abre lentamente y puedes avanzar.");
          acertado = true;
        } else {
          out.println("Incorrecto. Esa no es la clave que abre la puerta.");

          // Pista si está cerca del rango correcto
          if (numero > 10 && numero < 20) {
            out.println("Pista: Vas por buen camino. Recuerda que debe ser divisible entre 3.");
          }

          out.println("Intentos restantes: " + (3 - intentos));
          intentos++;
        }

      } else {
        out.println("Entrada inválida. Solo puedes ingresar números enteros positivos.");
        out.println("Intento no válido. Aún tienes " + (3 - intentos + 1) + " intento(s).");
        // No se incrementa el contador si la entrada no fue válida
      }

    } while (!acertado && intentos <= 3);

    if (!acertado) {
      out.println("Has agotado todos los intentos.");
      out.println("La puerta permanece cerrada! Inténtalo de nuevo.");
    } else {
      out.println("¡Felicidades! Has resuelto el enigma.");
    }
  }
}
