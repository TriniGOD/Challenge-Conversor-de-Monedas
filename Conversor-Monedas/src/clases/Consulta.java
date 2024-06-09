package clases;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Consulta {
    public Conversion buscarConversion (String moneda1, String moneda2){
        URI direccion =URI.create("https://v6.exchangerate-api.com/v6/de145b4a010e13b38ef9e42c/pair/"+moneda1+"/"+moneda2);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try{
            HttpResponse<String> response = client
                                            .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Conversion.class);
        } catch (Exception e){
            throw new RuntimeException("Alguna de las dos monedas (o ambas) no fueron encontradas");
        }
    }
}
