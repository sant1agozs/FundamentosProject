import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class App {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static PrintStream out = System.out;

  public static void main(String[] args) throws Exception {
    boolean logroCuadro = false;
    int intentos = 0;
    String g1 = " ", g2 = " ", g3 = " ", g4 = " ", g5 = " ";

    out.println();
    out.println("Cuadro en la Pared! Desafío: Giro Secreto");
    out.println("Encuentras una nota numérica tirada en el suelo: 12120");
    out.println("Pistas cercanas:");
    out.println("1 = izquierda, 2 = derecha");
    out.println("0 = 4!");
    out.println("Pero hay algo más... una frase rayada con fuerza al borde de la pared:");
    out.println("\"Las respuestas deben ser escritas AL REVÉS...\"");

    do {
      out.println();
      out.println("Ingresa la secuencia de 5 respuestas invertidas:");
      out.println("Los primeros 4 deben ser palabras al revés. El último, un número invertido.");

      out.print("Paso 1: ");
      g1 = in.readLine().toLowerCase();

      out.print("Paso 2: ");
      g2 = in.readLine().toLowerCase();

      out.print("Paso 3: ");
      g3 = in.readLine().toLowerCase();

      out.print("Paso 4: ");
      g4 = in.readLine().toLowerCase();

      out.print("Paso 5: ");
      g5 = in.readLine();

      if (g1.equals("adreiuqzi") &&
          g2.equals("ahcered") &&
          g3.equals("adreiuqzi") &&
          g4.equals("ahcered") &&
          g5.equals("42")) {

        out.println();
        out.println("El cuadro se desplaza hacia un lado lentamente...");
        out.println("Dentro, una inscripción: 'A veces la verdad está del otro lado... literalmente.'");
        logroCuadro = true;
      } else {
        out.println("Nada sucede. Tal vez deberías mirar las cosas desde otro ángulo...");
      }

      intentos++;

    } while (!logroCuadro && intentos < 5);

    if (!logroCuadro) {
      out.println();
      out.println("El mecanismo del cuadro se bloquea. La pista ha quedado fuera de alcance.");
    } else {
      out.println();
      out.println("Has obtenido una pista clave del cuadro.");
}
  }
}
