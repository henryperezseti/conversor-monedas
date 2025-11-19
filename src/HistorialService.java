import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class HistorialService {

    private final List<String> historial = new ArrayList<>();

    public void guardar(String base, String target, double cantidad, double resultado) {
        LocalDateTime ahora = LocalDateTime.now();
        String timestamp = ahora.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        String registro = timestamp + " | " + cantidad + " " + base + " => " + resultado + " " + target;

        historial.add(registro);
    }

    public void mostrar() {
        System.out.println("************* HISTORIAL DE CONVERSIONES *************");

        if (historial.isEmpty()) {
            System.out.println("Aún no has realizado ninguna conversión.");
        } else {
            historial.forEach(System.out::println);
        }

        System.out.println("*****************************************************");
    }
}