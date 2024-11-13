using System;
using CalculatorClient.ServiceReference; // Ajusta este espacio de nombres si es diferente

class Program
{
    static void Main()
    {
        // Crear una instancia del cliente del servicio
        var client = new CalculatorSoapClient(CalculatorSoapClient.EndpointConfiguration.CalculatorSoap);

        try
        {
            // Suma
            var sumResult = client.AddAsync(6, 8).Result;
            Console.WriteLine("Suma: " + sumResult);

            // Resta
            var subtractResult = client.SubtractAsync(10, 4).Result;
            Console.WriteLine("Resta: " + subtractResult);

            // Multiplicación
            var multiplyResult = client.MultiplyAsync(5, 3).Result;
            Console.WriteLine("Multiplicación: " + multiplyResult);

            // División
            var divideResult = client.DivideAsync(12, 4).Result;
            Console.WriteLine("División: " + divideResult);
        }
        catch (Exception ex)
        {
            Console.WriteLine("Error: " + ex.Message);
        }
        finally
        {
            client.CloseAsync().Wait();
        }
    }
}
