import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {

        private static final String API_KEY = "822adeca3cdd465a6d58854d";

        public Moneda buscarMoneda(String base, String target, Double amount){
            String url;

            if (amount == null) {
                url = "https://v6.exchangerate-api.com/v6/" + API_KEY +
                        "/pair/" + base + "/" + target;
            }else {
                url = "https://v6.exchangerate-api.com/v6/" + API_KEY +
                        "/pair/" + base + "/" + target + "/" + amount;
            }

            URI direccion = URI.create(url);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(direccion)
                    .build();
            try {
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
                return new Gson().fromJson(response.body(), Moneda.class);
            } catch (Exception e) {
                throw new RuntimeException("Error al consultar la conversión de moneda");
            }
        }
}
