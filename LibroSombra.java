import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class App {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws Exception {
        boolean logroLibro = false;
        int intentosLibro = 0;
        String seleccion;

        out.println();
        out.println("Estantería Antigua – Desafío: El Libro de la Sombra");
        out.println("Te acercas a una estantería cubierta de polvo...");
        out.println("Justo al lado, hay una nota escrita a mano:");
        out.println("\"Cuando la luz desaparece... su opuesto revela la verdad.\"");

        do {
            out.println();
            out.println("Selecciona uno de los siguientes libros:");
            out.println("1. 'El Silencio de las Estrellas'");
            out.println("2. 'La Oscuridad que Respira'");
            out.println("3. 'Susurros entre Sombras'");

            out.print("Ingresa el número del libro que deseas examinar: ");
            seleccion = in.readLine();

            switch (seleccion) {
                case "2":
                    out.println();
                    out.println("Has encontrado un fragmento suelto entre las páginas...");
                    out.println("PISTA: 'No todo lo que brilla es oro... pero algo escondido sí lo es.'");
                    logroLibro = true;
                    break;
                case "1":
                case "3":
                    out.println();
                    out.println("Hoja tras hoja… solo encuentras polvo y garabatos sin sentido.");
                    break;
                default:
                    out.println("Opción inválida. Aún así, sientes que has perdido tiempo valioso...");
                    break;
            }

            intentosLibro++;

        } while (!logroLibro && intentosLibro < 3);

        if (!logroLibro) {
            out.println();
            out.println("Has agotado tus intentos. La pista se ha perdido entre las sombras del olvido.");
        } else {
            out.println();
            out.println("Has obtenido una pista clave de la estantería.");
            }
        }
}
