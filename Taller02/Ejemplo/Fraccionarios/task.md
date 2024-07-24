## La Clase Fraccionario

Vamos a construir una clase para poder manipular las fracciones, quebrados o fraccionarios en el lenguaje Kotlin.
Para ello vamos a representar un fraccionario como un objeto compuesto de dos componentes, el numerador y el
denominador, de la siguiente forma:

$$
\frac{4}{5} = \textrm{Fraccionario(4, 5)}
$$

El diagrama de clases que vamos a implementar es el siguiente:

<img src="https://github.com/luiscobo/poo/blob/main/ClaseFraccionario.png?raw=true" width="50%">

Los siguientes son los métodos a implementar:

1. `constructor(num, den)`: Este método inicializa los atributos del fraccionario. Hay que colocar una precondición que impida crear un fraccionario con numerador negativo o con un denominador igual a cero. La operación debe simplificar el fraccionario una vez haga la inicialización de los atributos.
2. `simplificar()`: simplifica el fraccionario, dividiendo el numerador y el denominador por el máximo común divisor. No retorna ningún valor. Es una operación modificadora.
3. `cambiar(num, den)`: Cambia el numerador y el denominador del fraccionario. Precondición: el denominador debe ser positivo y diferente de cero.
4. `asignar(f)`: establece que el numerador y denominador de esta fracción sea el mismo numerador y denominador de la fracción f que se recibe como parámetro.
5. `igual(f)`: Permite saber si el fraccionario this es igual al fraccionario f que se pasa como parámetro. Retorna *true* si son iguales y *false* si no lo son.
6. `propia()`: Las fracciones propias son aquellas cuyo numerador es menor que el denominador.
7. `impropia()`: Las fracciones impropias son aquellas cuyo numerador es mayor que el denominador.
8. `unidad()`: Las fracciones unidad son todas las fracciones que tienen el numerador igual al denominador.
9. `mixto()`: Una fracción mixta o número mixto es la representación de una fracción impropia, en forma de número entero y fracción propia.
10. `toInt()`: obtiene la parte entera del fraccionario. Por ejemplo: la parte entera de 14/5 es 2
11. `toDouble()`: convierte a double (número real) el fraccionario. Por ejemplo: 14/5 convertido a double es 2.8
12. `menorQue(f)`: permite saber si el fraccionario es menor que f, el que se recibe como parámetro.
13. `mayorQue(f)`: permite saber si el fraccionario es mayor que f, el que se recibe como parámetro.
14. `abs()`: obtiene el valor absoluto del fraccionario
15. `invertir()`: invierte el fraccionario. Retorna el fraccionario invertido.

Además de las operaciones de la clase, debe desarrollarse los siguientes métodos externos (funciones):

* `sumarFraccionarios(f1, f2)`: Obtiene el fraccionario resultante de sumar los fraccionarios f1 y f2
* `restarFraccionarios(f1, f2)`: Obtiene el fraccionario resultante de restar los fraccionarios f1 y f2
* `multiplicarFraccionarios(f1, f2)`: obtiene el fraccionario resultante de multiplicar los fraccionarios f1 y f2
* `dividirFraccionarios(f1, f2)`: obtiene el fraccionario resultante de dividir los fraccionarios f1 y f2
* `mayor(f1, f2)`: retorna el fraccionario más grande entre f1 y f2
* `menor(f1, f2)`: retorna el fraccionario más pequeño entre f1 y f2