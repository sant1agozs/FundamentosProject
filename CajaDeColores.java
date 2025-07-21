import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class App {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static PrintStream out = System.out;

  public static void main(String[] args) throws Exception {
    String colorElegido = "";
    boolean tieneLlave = false; // Variable usada para saber si el usuario encontró la llave
    boolean entradaValida; // Se usa dentro del bucle, no se necesita valor inicial fuera
    int intentos = 1;

    // Instrucciones iniciales
    out.println("Estás frente a una caja con tres botones: rojo, azul y verde.");
    out.println("Una pista dice: 'El color del cielo al mediodía.'");

    // Bucle que permite hasta 5 intentos
    do {
      out.print("Intento #" + intentos + " - ¿Qué color eliges? (rojo, azul, verde): ");
      colorElegido = in.readLine().toLowerCase();

      // Validamos si escribió uno de los tres colores permitidos
      entradaValida = colorElegido.equals("rojo") || colorElegido.equals("azul") || colorElegido.equals("verde");

      if (!entradaValida) {
        out.println("Entrada inválida. Solo puedes elegir: rojo, azul o verde.");
      } else {
        // Aquí sí escribió un color válido
        if (colorElegido.equals("azul")) {
          out.println("¡Has elegido el color correcto! Has encontrado una llave en la caja.");
          tieneLlave = true; // Se marca que obtuvo la llave
          break; // Ya no se necesita seguir preguntando
        } else {
          out.println("¡Error! El color ingresado es incorrecto.");
        }
      }

      intentos++;

    } while (intentos <= 5 && !tieneLlave); // Sale si acierta o si se acaban los intentos

    // Resultado final
    if (tieneLlave) {
      out.println("¡Puedes avanzar a la siguiente etapa del juego!");
    } else {
      out.println("Has agotado tus intentos. Fin del juego.");
    }
  }
}
