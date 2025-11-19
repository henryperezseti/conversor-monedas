import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConversorApp {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        ConsultaMoneda consulta = new ConsultaMoneda();
        HistorialService historial = new HistorialService();

        int opcion = 0;

        while (opcion != 8) {

            System.out.println("**********************************************");
            System.out.println("Sea bienvenido/a al Conversor de Moneda =]");
            System.out.println();
            System.out.println("1) Dólar ==> Peso argentino");
            System.out.println("2) Peso argentino ==> Dólar");
            System.out.println("3) Dólar ==> Real brasileño");
            System.out.println("4) Real brasileño ==> Dólar");
            System.out.println("5) Dólar ==> Peso colombiano");
            System.out.println("6) Peso colombiano ==> Dólar");
            System.out.println("7) Ver historial");
            System.out.println("8) Salir");
            System.out.println();
            System.out.println("Elija una opción válida:");
            System.out.println("**********************************************");

            opcion = teclado.nextInt();

            if (opcion == 8) {
                System.out.println("Saliendo del sistema...");
                break;
            }

            if (opcion == 7) {
                historial.mostrar();
                continue;
            }

            System.out.println("Ingresa el valor que deseas convertir:");
            double cantidad = teclado.nextDouble();

            String base = "";
            String target = "";

            switch (opcion) {
                case 1 -> { base = "USD"; target = "ARS"; }
                case 2 -> { base = "ARS"; target = "USD"; }
                case 3 -> { base = "USD"; target = "BRL"; }
                case 4 -> { base = "BRL"; target = "USD"; }
                case 5 -> { base = "USD"; target = "COP"; }
                case 6 -> { base = "COP"; target = "USD"; }
                default -> {
                    System.out.println("Opción inválida.");
                    continue;
                }
            }

            try {
                Moneda moneda = consulta.buscarMoneda(base, target, cantidad);
                double resultado = moneda.conversion_result();

                System.out.println("**********************************************");
                System.out.println("El valor " + cantidad + " [" + base + "] corresponde al valor final de >>> "
                        + resultado + " [" + target + "]");
                System.out.println("**********************************************");

                historial.guardar(base, target, cantidad, resultado);

            } catch (Exception e) {
                System.out.println("Error al consultar moneda: " + e.getMessage());
            }
        }
    }
}