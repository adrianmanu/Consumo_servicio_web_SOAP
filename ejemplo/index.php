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
