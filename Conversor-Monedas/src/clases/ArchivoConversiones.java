package clases;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class ArchivoConversiones {
    private FileWriter escritura;
    private Gson gson;

    public void crearArchivo (String user) throws IOException{
        gson = new GsonBuilder().setPrettyPrinting().create();
        escritura = new FileWriter(user+"_registros.txt");
    }

    public void agregarConversion (Conversion conversion) throws IOException{

        escritura.write(conversion.toString());
        //escritura.close();
    }

    public void cerrarArchivo() throws IOException {
        escritura.close();
    }
}
