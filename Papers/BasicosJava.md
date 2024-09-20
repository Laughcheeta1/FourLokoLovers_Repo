# Java Basics

### Base
public class Clase {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}


### I/O
To use `BufferedReader` and `BufferedWriter` in Java, you can follow these examples:


#### BufferedReader
```java
BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
System.out.print("Enter your name: ");
try {
    String name = reader.readLine();
    System.out.println("Hello, " + name);
} catch (IOException e) {
    e.printStackTrace();
}
```


#### BufferedReader with Unknown Number of Inputs
```java
while ((line = reader.readLine()) != null && !line.equalsIgnoreCase("exit")) {
    System.out.println("You entered: " + line);
}
```


#### BufferedWriter
```java
BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
try {
    writer.write("Hello, World!");
    writer.newLine();
    writer.write("This is an example of BufferedWriter.");
    writer.flush();
} catch (IOException e) {
    e.printStackTrace();
} finally {
    try {
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
```


#### Variables limits
- **byte**: 
    - Size: 8 bits
    - Range: -128 to 127

- **short**: 
    - Size: 16 bits
    - Range: -32,768 to 32,767

- **int**: 
    - Size: 32 bits
    - Range: -2^31 to 2^31 - 1 (-2,147,483,648 to 2,147,483,647) o (-2*10^9 to 2*10^9)

- **long**: 
    - Size: 64 bits
    - Range: -2^63 to 2^63 - 1 (-9223372036854775808 to 9223372036854775807) o (-9*10^18 to 9*10^18)

- **float**: 
    - Size: 32 bits
    - Range: 1.40239846e-45f to 3.40282347e+38f

- **double**: 
    - Size: 64 bits
    - Range: 4.94065645841246544e-324 to 1.79769313486231570e+308

- **char**: 
    - Size: 16 bits (unsigned)
    - Range: 0 to 65,535 (represents a single 16-bit Unicode character)

- **boolean**: 
    - Size: unsigned 8 bits
    - Values: `true` or `false`

- **unsigned**: 
    Se pueden hacer con las clases Wrapper, por ejemplo:
    ```java
    Integer.toUnsignedLong(23500);
    ```


#### Arimetica modular
`(a + b) mod m = ((a mod m) + (b mod m)) mod m`
`(a - b) mod m = ((a mod m) - (b mod m)) mod m`
`(a * b) mod m = ((a mod m) * (b mod m)) mod m`
`(a / b) mod m = ((a mod m) * (b^-1 mod m)) mod m`

Generalmente cuando el resultado de una operación es muy grande, se hace modulo `10^9 + 7`.

Si se quiere evitar que el modulo sea negativo, se puede hacer:
```java
int mod(int a, int m) {
    return (a % m + m) % m;
}
```
Pero esto solo se requiere cuando se trabaja con restas o números negativos.

Para hacer la inversa de un número `a` en modulo `m`, se puede hacer con el algoritmo de Euclides extendido:
```java 
long inv(long a, long m) {
    long m0 = m, t, q;
    long x0 = 0, x1 = 1;
    if (m == 1) return 0;
    while (a > 1) {
        q = a / m;
        t = m;
        m = a % m;
        a = t;
        t = x0;
        x0 = x1 - q * x0;
        x1 = t;
    }
    if (x1 < 0) x1 += m0;
    return x1;
}
```


#### Formattear numeros decimales
```java
double number = 123.456789;
System.out.println(String.format("%.2f", number)); // 123.46
```


#### Comparar numeros
Para comparar dos números decimales, se puede hacer con un margen de error debido a como funcionan los numeros binarios:
```java
double x = 0.3*3+0.1;
System.out.println(x); // 0.9999999999999999
```
En general basta con sencillamente comparar que la resta de dos numeros decimales sea menor que 10^-9:
```java
double a = 0.3*3+0.1;
double b = 1;
if (Math.abs(a-b) < 1e-9) {
    System.out.println("Son iguales");
}
```


## Nota:
Recordar que e significa 10^, por lo que 1e-9 es igual a 10^-9.