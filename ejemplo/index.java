import javax.xml.soap.*;

public class CalculatorClient {
    public static void main(String[] args) {
        try {
            // URL del WSDL
            String url = "http://www.dneonline.com/calculator.asmx?WSDL";
            
            // Creando el cliente SOAP
            SoapClient client = new SoapClient(url);

            // Suma
            System.out.println("Suma: " + client.Add(6, 8));

            // Resta
            System.out.println("Resta: " + client.Subtract(10, 4));

            // Multiplicación
            System.out.println("Multiplicación: " + client.Multiply(5, 3));

            // División
            System.out.println("División: " + client.Divide(12, 4));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
