import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class App {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static PrintStream out = System.out;

  public static void main(String[] args) throws Exception {

    // Variables que controlan el estado del juego
    String opcion;
    boolean enigmaNumericoResuelto = false;
    boolean cajaColoresResuelta = false;
    boolean libroSombraResuelto = false;
    boolean codigosTizaResuelto = false;
    boolean cuadroContradiccionResuelto = false;
    boolean manecillasJuicioResuelto = false;
    int minijuegosCompletados = 0;     // Contador de minijuegos ganados
    int intentosEscapeFallidos = 0;    // Contador de intentos de huida fallidos
    String predefinido = "Este desafío ya ha sido completado";

    // Bucle principal que muestra el menú hasta que el jugador quiera salir o haya perdido
    do {
      out.println("\n===== EL ULTIMO JUICIO =====");
      out.println("Selecciona el minijuego que deseas jugar:");
      out.println("1. Enigma Numérico");
      out.println("2. Caja de Colores");
      out.println("3. El Libro de la Sombra");
      out.println("4. Códigos de Tiza");
      out.println("5. El Cajón de la Contradicción");
      out.println("6. Las Manecillas del Juicio");
      out.println("7. Ver estado de progreso");
      out.println("0. Intentar huir");
      out.print("Opción: ");
      opcion = in.readLine();

      // Switch que llama a la rutina correspondiente
      switch (opcion) {
        case "1": // Enigma Numérico
          if (!enigmaNumericoResuelto) {
            boolean completado = jugarEnigmaNumerico();
            if (completado) { enigmaNumericoResuelto = true; minijuegosCompletados++; }
          } else { out.println(predefinido); }
          break;

        case "2": // Caja de Colores
          if (!cajaColoresResuelta) {
            boolean completado = jugarCajaColores();
            if (completado) { cajaColoresResuelta = true; minijuegosCompletados++; }
          } else { out.println(predefinido); }
          break;

        case "3": // Libro de la Sombra
          if (!libroSombraResuelto) {
            boolean completado = jugarLibroSombra();
            if (completado) { libroSombraResuelto = true; minijuegosCompletados++; }
          } else { out.println(predefinido); }
          break;

        case "4": // Códigos de Tiza
          if (!codigosTizaResuelto) {
            boolean completado = jugarCodigosTiza();
            if (completado) { codigosTizaResuelto = true; minijuegosCompletados++; }
          } else { out.println(predefinido); }
          break;

        case "5": // Cuadro de la Contradicción
          if (!cuadroContradiccionResuelto) {
            boolean completado = jugarCuadroContradiccion();
            if (completado) { cuadroContradiccionResuelto = true; minijuegosCompletados++; }
          } else { out.println(predefinido); }
          break;

        case "6": // Manecillas del Juicio
          if (!manecillasJuicioResuelto) {
            boolean completado = jugarManecillasJuicio();
            if (completado) { manecillasJuicioResuelto = true; minijuegosCompletados++; }
          } else { out.println(predefinido); }
          break;

        case "7": // Mostrar progreso actual
          verProgreso(
            enigmaNumericoResuelto,
            cajaColoresResuelta,
            libroSombraResuelto,
            codigosTizaResuelto,
            cuadroContradiccionResuelto,
            manecillasJuicioResuelto,
            minijuegosCompletados
          );
          break;

        case "0": // Intentar huir
          if (minijuegosCompletados < 6) { // Aún no completó todo
            intentosEscapeFallidos++;
            if (intentosEscapeFallidos == 1) {
              out.println("Una voz firme retumba en la habitación:");
              out.println("'No puedes escapar todavía... Debes enfrentar el último desafío.'");
            } else {
              out.println("Ignoraste la advertencia... La habitación se oscurece.");
              out.println("Quedas atrapado para siempre en este Escape Room.");
            }
          } else { // Ganó todos los minijuegos
            out.println("Con todos los desafíos completados, la puerta principal se abre.");
            out.println("¡Has logrado escapar con éxito del Escape Room!");
          }
          break;

        default: // Entrada inválida
          out.println("Opción no válida. Intenta de nuevo.");
      }

    } while (!(opcion.equals("0") && intentosEscapeFallidos >= 2)); // Condición de salida definitiva
  }

  // ================== RUTINAS DE MINIJUEGOS ==================

  // Minijuego 1: Adivinar un número entre 10 y 20 divisible por 3
  static boolean jugarEnigmaNumerico() throws Exception {
    String entradaUsuario;
    int numero, intentos = 1;
    boolean acertado = false;
    boolean entradaValida;

    out.println("Una puerta mágica bloquea tu paso. Un enigma está grabado sobre ella:");
    out.println("\"Soy mayor que 10, menor que 20 y divisible por 3.\"");
    out.println("Tienes 3 intentos para descubrir el número correcto.");

    do {
      out.print("Intento #" + intentos + " - Ingresa tu número: ");
      entradaUsuario = in.readLine();
      entradaValida = entradaUsuario.matches("\\d+"); // Validar que sea número

      if (entradaValida) {
        numero = Integer.parseInt(entradaUsuario);
        if (numero == 12 || numero == 15 || numero == 18) { // Respuestas correctas
          out.println("¡Correcto! La puerta se abre lentamente y puedes avanzar.");
          acertado = true;
        } else {
          out.println("Incorrecto. Esa no es la clave que abre la puerta.");
          if (numero > 10 && numero < 20)
            out.println("Pista: Vas por buen camino. Recuerda que debe ser divisible entre 3.");
          out.println("Intentos restantes: " + (3 - intentos));
          intentos++;
        }
      } else {
        out.println("Entrada inválida. Solo puedes ingresar números enteros positivos.");
        out.println("Intento no válido. Aún tienes " + (3 - intentos + 1) + " intento(s).");
      }
    } while (!acertado && intentos <= 3);

    if (!acertado)
      out.println("Has agotado todos los intentos. La puerta permanece cerrada.");

    return acertado;
  }

  // Minijuego 2: Elegir el color correcto (azul)
  static boolean jugarCajaColores() throws Exception {
    String colorElegido;
    boolean entradaValida;
    boolean tieneLlave = false;
    int intentos = 1;

    out.println("Estás frente a una caja con tres botones: rojo, azul y verde.");
    out.println("Una pista dice: 'El color del cielo al mediodía.'");

    do {
      out.print("Intento #" + intentos + " - ¿Qué color eliges? (rojo, azul, verde): ");
      colorElegido = in.readLine().toLowerCase();

      entradaValida = colorElegido.equals("rojo") || colorElegido.equals("azul") || colorElegido.equals("verde");

      if (!entradaValida) {
        out.println("Entrada inválida. Solo puedes elegir: rojo, azul o verde.");
      } else {
        if (colorElegido.equals("azul")) { // Respuesta correcta
          out.println("¡Has elegido el color correcto! Has encontrado una llave en la caja.");
          tieneLlave = true;
          break;
        } else {
          out.println("¡Error! El color ingresado es incorrecto.");
        }
      }

      intentos++;

    } while (intentos <= 5 && !tieneLlave);

    if (!tieneLlave)
      out.println("Has agotado tus intentos. Fin del juego.");
    else
      out.println("¡Puedes avanzar a la siguiente etapa del juego!");

    return tieneLlave;
  }

  // Minijuego 3: Elegir el libro correcto (El segundo)
  static boolean jugarLibroSombra() throws Exception {
    String seleccion;
    int intentos = 0;
    boolean pistaEncontrada = false;

    out.println("Te acercas a una estantería polvorienta. Hay tres libros:");
    out.println("1. 'La luz de la esperanza'");
    out.println("2. 'Oscuridad y silencio'");
    out.println("3. 'Colores del día'");
    out.println("Una nota dice: 'Donde no hay luz, todo cobra sentido...'");

    do {
      out.print("¿Cuál libro eliges? (1-3): ");
      seleccion = in.readLine();
      intentos++;

      if (seleccion.equals("2")) { // Libro correcto
        out.println("Has abierto el libro correcto. Dentro encuentras una nota antigua con una pista.");
        pistaEncontrada = true;
      } else if (seleccion.equals("1") || seleccion.equals("3")) {
        out.println("No hay nada dentro. Solo polvo...");
      } else {
        out.println("Opción inválida. Solo puedes elegir entre 1, 2 o 3.");
      }
    } while (!pistaEncontrada && intentos < 3);

    if (!pistaEncontrada)
      out.println("No lograste encontrar la pista. Alguien te observa desde la oscuridad.");

    return pistaEncontrada;
  }

  // Minijuego 4: Secuencia de cuadrados perfectos (respuesta 25)
  static boolean jugarCodigosTiza() throws Exception {
    String respuesta;
    int intentos = 0;
    boolean correcto = false;

    out.println("Sobre una pizarra hay una secuencia incompleta:");
    out.println("Secuencia: 0, 1, 4, 9, 16, ?");

    do {
      out.print("¿Cuál es el número que sigue?: ");
      respuesta = in.readLine();
      intentos++;

      if (respuesta.matches("[0-9]+") && respuesta.equals("25")) { // Cuadrado de 5
        out.println("¡Correcto! Has descifrado la secuencia.");
        correcto = true;
      } else {
        if (intentos == 2)
          out.println("Pista: Esta secuencia es... potente, eh...");
        out.println("Incorrecto.");
      }

    } while (!correcto && intentos < 3);

    if (!correcto)
      out.println("La pizarra se borra sola. Has perdido la oportunidad.");

    return correcto;
  }

  // Minijuego 5: Resolver secuencia invertida con izquierda/derecha y factorial
  static boolean jugarCuadroContradiccion() throws Exception {
    boolean logroCuadro = false;
    int intentos = 0;
    String g1, g2, g3, g4, g5;

    out.println();
    out.println("Cuadro en la Pared – Desafío: Giro Secreto");
    out.println("Encuentras una nota numérica tirada en el suelo: 12120");
    out.println("Pistas cercanas:");
    out.println("1 = izquierda, 2 = derecha");
    out.println("0 = 4!");
    out.println("Una frase rayada dice: \"Las respuestas deben ser escritas AL REVÉS...\"");

    do {
      // Se piden 5 respuestas
      out.println("\nIngresa la secuencia de 5 respuestas invertidas:");
      out.print("Paso 1: "); g1 = in.readLine().toLowerCase();
      out.print("Paso 2: "); g2 = in.readLine().toLowerCase();
      out.print("Paso 3: "); g3 = in.readLine().toLowerCase();
      out.print("Paso 4: "); g4 = in.readLine().toLowerCase();
      out.print("Paso 5: "); g5 = in.readLine();

      // Combinación correcta
      if (g1.equals("adreiuqzi") && g2.equals("ahcered") && g3.equals("adreiuqzi") &&
          g4.equals("ahcered") && g5.equals("42")) {
        out.println("¡Acertaste!");
        out.println("El cuadro se desplaza hacia un lado lentamente...");
        out.println("Dentro, una inscripción: 'A veces la verdad está del otro lado... literalmente.'");
        logroCuadro = true;
      } else {
        out.println("Nada sucede. Tal vez deberías mirar las cosas desde otro ángulo...");
      }

      intentos++;

    } while (!logroCuadro && intentos < 5);

    if (!logroCuadro)
      out.println("El mecanismo del cuadro se bloquea. La pista ha quedado fuera de alcance.");

    return logroCuadro;
  }

  // Minijuego 6: Desafío final con binarios, suma, multiplicación y número oculto
  static boolean jugarManecillasJuicio() throws Exception {
    int intentos = 0;
    boolean completado = false;
    String r1 = "", r2 = "", r3 = "", r4 = "", suma = "", mult = "", morse = "";

    out.println("Te encuentras en una sala oscura con un antiguo reloj empotrado en la pared.");
    out.println("En una mesa cercana hay una hoja de papel quemada que dice:");
    out.println("\"(0001)(0001):(0011)(0100)\"");
    out.println("¿Qué haremos con estos binarios?");
    out.println("Tal vez si los desciframos uno a uno...");

    while (intentos < 5 && !completado) {
      // Preguntar cada número binario
      out.print("¿Qué número representa el primer 0001? ");
      r1 = in.readLine();

      out.print("¿Y el siguiente 0001? ");
      r2 = in.readLine();

      out.print("¿Qué representa 0011? ");
      r3 = in.readLine();

      out.print("¿Y 0100? ");
      r4 = in.readLine();

      // Validación correcta → hora 11:34
      if (r1.equals("1") && r2.equals("1") && r3.equals("3") && r4.equals("4")) {
        out.println("\nHas formado la hora: 11:34.");
        out.println("Las manecillas marcan el tiempo exacto. Pero...");

        // Suma de los dígitos
        out.println("¿Qué sucede si sumamos cada dígito de la hora?");
        out.print("Ingresa la suma de 1 + 1 + 3 + 4: ");
        suma = in.readLine();

        if (suma.equals("9")) {
          out.println("\nCorrecto, 9.");
          out.println("Parece que hay algo más escondido detrás del tiempo...");
          out.println("Una inscripción aparece: 'Multiplica la suma de la hora por la cantidad de desafíos en este lugar.'");

          // Multiplicación por total de minijuegos (6)
          out.print("¿Cuál es el resultado de 9 x 6? ");
          mult = in.readLine();

          if (mult.equals("54")) {
            out.println("\nMuy bien... el número es 54.");
            out.println("Una hoja ennegrecida cae desde el techo con una sola frase:");
            out.println("\"Usa el lenguaje del silencio para continuar.\"");

            // Paso final
            out.print("Ingresa el número 54 multiplicado por 4: ");
            morse = in.readLine();

            if (morse.equals("216")) {
              out.println("\nLas manecillas giran violentamente y luego se detienen en seco.");
              out.println("Un compartimento oculto se abre bajo tus pies. Has desbloqueado el último secreto.");
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

    if (!completado) {
      out.println("\nEl reloj emite un sonido agudo y se apaga. El acceso ha sido denegado.");
    } else {
      out.println("\n¡Has resuelto el enigma de las manecillas del juicio!");
    }

    return completado;
  }

  // ================== Mostrar progreso de minijuegos ==================
  static void verProgreso(
      boolean enigmaNumericoResuelto,
      boolean cajaColoresResuelta,
      boolean libroSombraResuelto,
      boolean codigosTizaResuelto,
      boolean cuadroContradiccionResuelto,
      boolean manecillasJuicioResuelto,
      int minijuegosCompletados
  ) {
    out.println("\n===== PROGRESO DEL JUGADOR =====");
    out.println("Desafíos:");
    // Mostrar estado de cada minijuego (Completado / Sin completar)
    out.println("1. Enigma Numérico: " + (enigmaNumericoResuelto ? "Completado" : "Sin completar"));
    out.println("2. Caja de Colores: " + (cajaColoresResuelta ? "Completado" : "Sin completar"));
    out.println("3. El Libro de la Sombra: " + (libroSombraResuelto ? "Completado" : "Sin completar"));
    out.println("4. Códigos de Tiza: " + (codigosTizaResuelto ? "Completado" : "Sin completar"));
    out.println("5. El Cajón de la Contradicción: " + (cuadroContradiccionResuelto ? "Completado" : "Sin completar"));
    out.println("6. Las Manecillas del Juicio: " + (manecillasJuicioResuelto ? "Completado" : "Sin completar"));
    // Mostrar el total de juegos completados
    out.println("Total completados: " + minijuegosCompletados + "/6");
  }
}
