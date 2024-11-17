# Consumo de Servicio Web SOAP

Este proyecto demuestra cómo consumir un servicio web SOAP utilizando diferentes lenguajes de programación: **PHP**, **Python**, **.NET** y **Java**. Se proporcionan los códigos fuente, las instrucciones de configuración y los pasos para ejecutar cada solución.

## **Índice**
1. [Introducción](#introducción)
2. [PHP: Consumo del Servicio Web SOAP](#1-php-consumo-del-servicio-web-soap)
3. [Python: Consumo del Servicio Web SOAP](#2-python-consumo-del-servicio-web-soap)
4. [.NET: Consumo del Servicio Web SOAP](#3-net-consumo-del-servicio-web-soap)
5. [Java: Consumo del Servicio Web SOAP](#4-java-consumo-del-servicio-web-soap)
6. [Resumen](#5-resumen)

---

## **Introducción**

El servicio web consumido en este proyecto es el de una calculadora básica alojado en:  
[http://www.dneonline.com/calculator.asmx?WSDL](http://www.dneonline.com/calculator.asmx?WSDL).  

Este WSDL permite ejecutar las siguientes operaciones aritméticas:
- Suma (`Add`)
- Resta (`Subtract`)
- Multiplicación (`Multiply`)
- División (`Divide`)

Cada sección contiene:
- Requisitos previos.
- Código fuente.
- Pasos para ejecutar la implementación.

---

## **1. PHP: Consumo del Servicio Web SOAP**

### **Requisitos previos**
- **XAMPP** para ejecutar PHP con soporte SOAP.

### **Pasos para configurar y ejecutar:**
1. **Instalar XAMPP:**
   - Descarga e instala XAMPP desde [https://www.apachefriends.org/index.html](https://www.apachefriends.org/index.html).
   - Asegúrate de incluir Apache y PHP durante la instalación.

2. **Habilitar SOAP en PHP:**
   - Abre el archivo `php.ini` (ubicado en `C:\xampp\php\php.ini`).
   - Descomenta la línea `;extension=soap` eliminando el punto y coma (`;`).
   - Guarda los cambios y reinicia Apache desde el panel de control de XAMPP.

3. **Guardar el código:**
   - Crea un archivo llamado `calculator.php` y pega el siguiente código en él:
     ```php
     <?php
     $client = new SoapClient("http://www.dneonline.com/calculator.asmx?WSDL");

     try {
         echo "Suma: " . $client->Add(['intA' => 6, 'intB' => 8])->AddResult . "<br>";
         echo "Resta: " . $client->Subtract(['intA' => 10, 'intB' => 4])->SubtractResult . "<br>";
         echo "Multiplicación: " . $client->Multiply(['intA' => 5, 'intB' => 3])->MultiplyResult . "<br>";
         echo "División: " . $client->Divide(['intA' => 12, 'intB' => 4])->DivideResult . "<br>";
     } catch (SoapFault $fault) {
         echo "Error: " . $fault->faultstring;
     }
     ?>
     ```

4. **Ejecutar el código:**
   - Guarda el archivo en el directorio `htdocs` de XAMPP (`C:\xampp\htdocs\calculator.php`).
   - Abre el navegador y accede a:  
     `http://localhost/calculator.php`.

---

## **2. Python: Consumo del Servicio Web SOAP**

### **Requisitos previos**
- **Python 3.6+** instalado.
- Librería **Zeep** para trabajar con SOAP.

### **Pasos para configurar y ejecutar:**
1. **Instalar Python y Zeep:**
   - Descarga Python desde [https://www.python.org/](https://www.python.org/).
   - Instala Zeep ejecutando:
     ```bash
     pip install zeep
     ```

2. **Guardar el código:**
   - Crea un archivo llamado `calculator.py` y pega el siguiente código:
     ```python
     import zeep

     client = zeep.Client(wsdl="http://www.dneonline.com/calculator.asmx?WSDL")

     try:
         print("Suma:", client.service.Add(intA=6, intB=8))
         print("Resta:", client.service.Subtract(intA=10, intB=4))
         print("Multiplicación:", client.service.Multiply(intA=5, intB=3))
         print("División:", client.service.Divide(intA=12, intB=4))
     except zeep.exceptions.Fault as fault:
         print("Error:", fault)
     ```

3. **Ejecutar el código:**
   - Navega a la carpeta donde guardaste el archivo en la terminal y ejecuta:
     ```bash
     python calculator.py
     ```

---

## **3. .NET: Consumo del Servicio Web SOAP**

### **Requisitos previos**
- **.NET SDK** instalado.
- Herramienta **dotnet-svcutil** para generar proxies.

### **Pasos para configurar y ejecutar:**
1. **Instalar .NET y dotnet-svcutil:**
   - Descarga .NET desde [https://dotnet.microsoft.com/download](https://dotnet.microsoft.com/download).
   - Instala `dotnet-svcutil` ejecutando:
     ```bash
     dotnet tool install --global dotnet-svcutil
     ```

2. **Generar las clases:**
   - Ejecuta el siguiente comando en la terminal:
     ```bash
     dotnet-svcutil http://www.dneonline.com/calculator.asmx?WSDL
     ```

3. **Crear un proyecto y pegar el código:**
   - Crea un nuevo proyecto:
     ```bash
     dotnet new console -n CalculatorClient
     cd CalculatorClient
     ```
   - Pega este código en `Program.cs`:
     ```csharp
     using System;
     using CalculatorClient.ServiceReference;

     class Program
     {
         static void Main()
         {
             var client = new CalculatorSoapClient(CalculatorSoapClient.EndpointConfiguration.CalculatorSoap);

             Console.WriteLine("Suma: " + client.AddAsync(6, 8).Result);
             Console.WriteLine("Resta: " + client.SubtractAsync(10, 4).Result);
             Console.WriteLine("Multiplicación: " + client.MultiplyAsync(5, 3).Result);
             Console.WriteLine("División: " + client.DivideAsync(12, 4).Result);
         }
     }
     ```

4. **Ejecutar el proyecto:**
   ```bash
   dotnet build
   dotnet run

## **4. Java: Consumo del Servicio Web SOAP**

### **Requisitos previos**
- **JDK 8** instalado.
- Herramienta `wsimport`.

### **Pasos para configurar y ejecutar:**

1. **Instalar JDK 8:**
   - Descarga e instala desde [https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html).

2. **Generar clases con wsimport:**
   - Abre la terminal y ejecuta el siguiente comando:
     ```bash
     wsimport -keep -p calculatorclient http://www.dneonline.com/calculator.asmx?WSDL
     ```

3. **Guardar el código:**
   - Crea un archivo llamado `CalculatorClient.java` y pega el siguiente código:
     ```java
     package calculatorclient;

     import javax.xml.ws.Service;
     import java.net.URL;
     import javax.xml.namespace.QName;

     public class CalculatorClient {
         public static void main(String[] args) {
             try {
                 URL url = new URL("http://www.dneonline.com/calculator.asmx?WSDL");
                 QName qname = new QName("http://tempuri.org/", "CalculatorSoap");

                 Service service = Service.create(url, qname);
                 CalculatorSoap calculator = service.getPort(CalculatorSoap.class);

                 System.out.println("Suma: " + calculator.add(6, 8));
                 System.out.println("Resta: " + calculator.subtract(10, 4));
                 System.out.println("Multiplicación: " + calculator.multiply(5, 3));
                 System.out.println("División: " + calculator.divide(12, 4));
             } catch (Exception e) {
                 e.printStackTrace();
             }
         }
     }
     ```

4. **Compilar y ejecutar el código:**
   - Navega a la carpeta donde generaste las clases y guardaste el archivo en la terminal y ejecuta:
     ```bash
     javac calculatorclient/CalculatorClient.java
     java calculatorclient.CalculatorClient
     ```

---

## **5. Resumen**

Este proyecto incluye implementaciones en **PHP**, **Python**, **.NET** y **Java** para consumir un servicio web SOAP, cada uno con su configuración y pasos específicos. Puedes elegir cualquiera según tus necesidades y entorno.
