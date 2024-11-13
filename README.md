# Consumo de Servicio Web SOAP

Este proyecto demuestra cómo consumir un servicio web SOAP utilizando diferentes lenguajes de programación: PHP, Python, .NET y Java. Se incluyen los pasos necesarios para configurar, ejecutar y obtener resultados desde un servicio SOAP.

## **Índice**
1. [PHP: Consumo del Servicio Web SOAP](#php-consumo-del-servicio-web-soap)
2. [Python: Consumo del Servicio Web SOAP](#python-consumo-del-servicio-web-soap)
3. [.NET: Consumo del Servicio Web SOAP](#net-consumo-del-servicio-web-soap)
4. [Java: Consumo del Servicio Web SOAP](#java-consumo-del-servicio-web-soap)
5. [Resumen](#resumen)

---

## **1. PHP: Consumo del Servicio Web SOAP**

### **Requisitos:**
- **XAMPP** para ejecutar PHP con soporte SOAP.

### **Pasos para Configurar y Ejecutar el Código PHP:**

1. **Instalación de XAMPP:**
   - Descarga e instala XAMPP desde [aquí](https://www.apachefriends.org/index.html).
   - Durante la instalación, asegúrate de que se incluya el servicio Apache y PHP.

2. **Configuración de SOAP en PHP:**
   - Abre el archivo `php.ini` (ubicado en `C:\xampp\php\php.ini`).
   - Descomenta la línea `;extension=soap` eliminando el punto y coma (`;`).
   - Guarda los cambios y reinicia el servidor Apache desde el panel de control de XAMPP.

3. **Código PHP para Consumir el Servicio Web:**
   ```php
   <?php
   // Crear el cliente SOAP
   $client = new SoapClient("http://www.dneonline.com/calculator.asmx?WSDL");

   // Obtener las funciones disponibles
   $functions = $client->__getFunctions();
   echo "<pre>";
   print_r($functions);
   echo "</pre>";

   // Obtener los tipos disponibles
   $types = $client->__getTypes();
   echo "<pre>";
   print_r($types);
   echo "</pre>";

   // Suma
   try {
       $result = $client->Add(['intA' => 6, 'intB' => 8]); 
       echo "Resultado de la suma: " . $result->AddResult . "<br>";
   } catch (SoapFault $fault) {
       echo "Error en la suma: " . $fault->faultcode . ". " . $fault->faultstring . "<br>";
   }

   // Resta
   try {
       $result = $client->Subtract(['intA' => 10, 'intB' => 4]); 
       echo "Resultado de la resta: " . $result->SubtractResult . "<br>";
   } catch (SoapFault $fault) {
       echo "Error en la resta: " . $fault->faultcode . ". " . $fault->faultstring . "<br>";
   }

   // Multiplicación
   try {
       $result = $client->Multiply(['intA' => 5, 'intB' => 3]); 
       echo "Resultado de la multiplicación: " . $result->MultiplyResult . "<br>";
   } catch (SoapFault $fault) {
       echo "Error en la multiplicación: " . $fault->faultcode . ". " . $fault->faultstring . "<br>";
   }

   // División
   try {
       $result = $client->Divide(['intA' => 12, 'intB' => 4]); 
       echo "Resultado de la división: " . $result->DivideResult . "<br>";
   } catch (SoapFault $fault) {
       echo "Error en la división: " . $fault->faultcode . ". " . $fault->faultstring . "<br>";
   }
   ?>
