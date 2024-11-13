import zeep

# URL del WSDL del servicio web
wsdl = "http://www.dneonline.com/calculator.asmx?WSDL"

# Crear un cliente para el servicio web
client = zeep.Client(wsdl=wsdl)

# Operaciones
try:
    # Suma
    result_add = client.service.Add(intA=6, intB=8)
    print("Resultado de la suma:", result_add)

    # Resta
    result_subtract = client.service.Subtract(intA=10, intB=4)
    print("Resultado de la resta:", result_subtract)

    # Multiplicación
    result_multiply = client.service.Multiply(intA=5, intB=3)
    print("Resultado de la multiplicación:", result_multiply)

    # División
    result_divide = client.service.Divide(intA=12, intB=4)
    print("Resultado de la división:", result_divide)

except zeep.exceptions.Fault as fault:
    print("Error:", fault)
