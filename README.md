# Proyecto: Simple Scanner para Identificación de Tokens

Este proyecto implementa un scanner sencillo en Java que es capaz de identificar ciertos tipos de tokens en un archivo de texto. Los tokens identificados son operadores aritméticos, dígitos, identificadores (IDs) y caracteres desconocidos que no encajan en las categorías mencionadas.

## Cómo Ejecutar el Proyecto

1. **Compilar los Archivos Java:**
    - Abre una terminal en el directorio del proyecto.
    - Ejecuta el siguiente comando para compilar los archivos:
      ```bash
      javac Token.java Scanner.java Compiler.java
      ```

2. **Ejecutar el Programa:**
    - Después de compilar, ejecuta el programa con el siguiente comando:
      ```bash
      java Compiler
      ```
    - Esto leerá el contenido de `input.txt`, escaneará los tokens, y escribirá los resultados en `output.txt`.

3. **Revisar la Salida:**
    - Abre el archivo `output.txt` en el mismo directorio para ver los tokens que fueron identificados por el scanner. Cada línea del archivo representará un token con su tipo, valor, línea y columna.

## Ejemplo de `output.txt`

Para el contenido de `input.txt`, el archivo `output.txt` podría verse así:

```plaintext
Token(type=3, value="int", line=1, column=1)
Token(type=3, value="x", line=1, column=5)
Token(type=5, value="=", line=1, column=7)
Token(type=2, value="5", line=1, column=9)
Token(type=1, value="+", line=1, column=11)
Token(type=2, value="10", line=1, column=13)
...
```

## Estructura del Proyecto

El proyecto se compone de los siguientes archivos:

1. **`Token.java`**
    - Define la estructura de un token, que incluye:
        - `type`: Tipo de token (por ejemplo, operador aritmético, dígito, identificador).
        - `value`: El valor léxico (la cadena original del token).
        - `line`: El número de línea donde se encontró el token en el archivo.
        - `column`: El número de columna donde se encontró el token en la línea.
        - `next`: Referencia al siguiente token en la lista encadenada.

2. **`Scanner.java`**
    - Contiene la lógica del scanner:
        - **Tipos de Tokens**: Define los tipos de tokens (operadores aritméticos, dígitos, identificadores, etc.).
        - **Métodos**:
            - `addToken(int type, String value, int line, int column)`: Añade un nuevo token a la lista encadenada.
            - `scan(String filepath)`: Lee un archivo de texto línea por línea, identifica los tokens y los añade a la lista.
            - `getTokens()`: Devuelve la lista de tokens identificados.

3. **`Compiler.java`**
    - Es el punto de entrada del programa:
        - Utiliza la clase `Scanner` para escanear un archivo llamado `input.txt`.
        - Escribe los tokens identificados en un archivo de salida llamado `output.txt`.

4. **`input.txt`**
    - Un archivo de texto que contiene el código fuente de ejemplo que el scanner analizará. Puedes usar un archivo con contenido como:
      ```plaintext
      int x = 5 + 10;
      float y = x * 2.0;
      y = y / (x - 1);
      if (x > y) {
          y = y - 1;
      } else {
          y = y + 1;
      }
      ```

## Requisitos del Proyecto

El scanner debe ser capaz de identificar los siguientes tokens:
- **Operadores aritméticos (`arith_op`)**: `+`, `-`, `*`, `/`, `%`.
- **Dígitos (`digit`)**: `0`, `1`, `2`, `3`, `4`, `5`, `6`, `7`, `8`, `9`.
- **Letras (`alpha`)**: Letras mayúsculas y minúsculas de `a` a `z` y de `A` a `Z`.
- **Identificadores (`id`)**: Secuencias que comienzan con una letra (`alpha`) y pueden contener letras y dígitos (`alpha_num`).
- **Caracteres desconocidos (`unknown`)**: Cualquier carácter que no encaje en las categorías anteriores.

El scanner recibe como parámetro un archivo con el texto a evaluar. La salida es una lista encadenada de los tokens identificados, incluyendo un token especial para caracteres que no pudieron ser clasificados.
