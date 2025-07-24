import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class App {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static PrintStream out = System.out;

  public static void main(String[] args) throws Exception {
    // Minijuego: Las Manecillas del Juicio
    int intentos = 0;
    boolean completado = false;

    // Respuestas parciales (binarios → decimales, suma de dígitos, multiplicaciones, último paso)
    String r1 = "", r2 = "", r3 = "", r4 = "", suma = "", mult = "", morse = "";

    out.println("Te encuentras en una sala oscura con un antiguo reloj empotrado en la pared.");
    out.println("En una mesa cercana hay una hoja de papel quemada que dice:");
    out.println("\"(0001)(0001):(0011)(0100)\"");
    out.println("¿Qué haremos con estos binarios?");
    out.println("Tal vez si los desciframos uno a uno...");

    // Hasta 5 intentos para resolver toda la cadena de pasos
    while (intentos < 5 && !completado) {
      // Paso 1: decodificar los binarios a la hora 11:34
      out.print("¿Qué número representa el primer 0001? ");
      r1 = in.readLine();

      out.print("¿Y el siguiente 0001? ");
      r2 = in.readLine();

      out.print("¿Qué representa 0011? ");
      r3 = in.readLine();

      out.print("¿Y 0100? ");
      r4 = in.readLine();

      // Validación exacta de la hora 11:34 (1,1 : 3,4)
      if (r1.equals("1") && r2.equals("1") && r3.equals("3") && r4.equals("4")) {
        out.println("\nHas formado la hora: 11:34.");
        out.println("Las manecillas marcan el tiempo exacto. Pero...");

        // Paso 2: suma de los dígitos 1 + 1 + 3 + 4
        out.println("¿Qué sucede si sumamos cada dígito de la hora?");
        out.print("Ingresa la suma de 1 + 1 + 3 + 4: ");
        suma = in.readLine();

        if (suma.equals("9")) {
          out.println("\nCorrecto, 9.");
          out.println("Parece que hay algo más escondido detrás del tiempo...");
          out.println("Una inscripción aparece: 'Multiplica la suma de la hora por la cantidad de desafíos en este lugar.'");

          // Paso 3: multiplicar por la cantidad de desafíos (6) → 9 x 6 = 54
          out.print("¿Cuál es el resultado de 9 x 6? ");
          mult = in.readLine();

          if (mult.equals("54")) {
            out.println("\nMuy bien... el número es 54.");
            out.println("Una hoja ennegrecida cae desde el techo con una sola frase:");
            out.println("\"Usa el lenguaje del silencio para continuar.\"");
            
            out.print("Ingresa el número 54 multiplicado por 4: ");
            morse = in.readLine();

            if (morse.equals("216")) {
              out.println("\nLas manecillas giran violentamente y luego se detienen en seco.");
              out.println("Un compartimento oculto se abre bajo tus pies. Has desbloqueado el último secreto!");
              completado = true;
            } else {
              out.println("Ese no es el valor correcto...");
            }

          } else {
            out.println("La ecuación no parece dar con la cerradura...");
          }

        } else {
          out.println("El reloj tiembla pero no reacciona...");
        }

      } else {
        out.println("Los binarios no forman una hora coherente...");
      }

      intentos++;
    }

    // Resolución final
    if (!completado) {
      out.println("\nEl reloj emite un sonido agudo y se apaga. El acceso ha sido denegado.");
    } else {
      out.println("\n¡Has resuelto el enigma de las manecillas del juicio!");
    }
  }
}
