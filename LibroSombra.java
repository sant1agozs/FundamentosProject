import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class App {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static PrintStream out = System.out;

  public static void main(String[] args) throws Exception {
    boolean exito = false;   // Indica si el jugador eligió el libro correcto
    int intentos = 0;        // Lleva el conteo de intentos permitidos (máximo 3)
    String eleccion;         // Almacena la opción elegida por el usuario

    out.println();
    out.println("Desafío: El Libro de la Sombra");
    out.println("Te acercas a una biblioteca polvorienta. Tres libros llaman tu atención.");
    out.println("Una nota susurra: \"El conocimiento yace en la oscuridad...\""); // Pista clave para elegir la opción correcta

    // Se permite hasta 3 intentos para encontrar el libro correcto
    do {
      out.println();
      out.println("¿Qué libro deseas abrir?");
      out.println("1. 'El Camino del Sol'");
      out.println("2. 'La Sombra Interior'");
      out.println("3. 'Cuentos de Luz y Esperanza'");
      out.print("Ingresa el número: ");
      eleccion = in.readLine();

      // Validación de la elección del usuario
      if (eleccion.equals("2")) {
        // Libro correcto: asociado con la oscuridad según la pista inicial
        out.println();
        out.println("Entre las páginas encuentras una nota antigua:");
        out.println("PISTA: Lo invisible a veces guía lo real.");
        exito = true;
      } else if (eleccion.equals("1") || eleccion.equals("3")) {
        // Libros incorrectos: no contienen la pista clave
        out.println("Nada útil. Solo polvo y páginas en blanco.");
      } else {
        // Entrada inválida (por ejemplo, texto o número fuera de rango)
        out.println("Opción no válida.");
      }

      intentos++;

    } while (!exito && intentos < 3); // Ciclo se repite hasta acertar o agotar intentos

    // Mensaje final según el resultado del jugador
    if (exito) {
      out.println();
      out.println("Has obtenido una pista clave.");
    } else {
      out.println();
      out.println("Demasiado tarde. El silencio lo cubre todo.");
    }
  }
}
