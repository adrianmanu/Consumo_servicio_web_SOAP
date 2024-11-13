package calculatorclient;

import javax.xml.ws.Service;
import java.net.URL;
import javax.xml.namespace.QName;

// Importa las clases generadas por wsimport
import calculatorclient.CalculatorSoap;
import calculatorclient.Calculator;

public class CalculatorClient {
    public static void main(String[] args) {
        try {
            // URL del servicio WSDL
            URL url = new URL("http://www.dneonline.com/calculator.asmx?WSDL");

            // Nombre del servicio (aquí usas el nombre correcto del servicio web)
            QName qname = new QName("http://tempuri.org/", "Calculator");

            // Crear el servicio a partir del WSDL
            Service service = Service.create(url, qname);

            // Obtener el puerto (enlace al servicio web)
            CalculatorSoap calculator = service.getPort(CalculatorSoap.class);

            // Llamar a los métodos del servicio web
            System.out.println("Suma: " + calculator.add(6, 8));
            System.out.println("Resta: " + calculator.subtract(10, 4));
            System.out.println("Multiplicacion: " + calculator.multiply(5, 3));
            System.out.println("Division: " + calculator.divide(12, 4));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
