## Taller 02 - Programación Orientada por Objetos en Kotlin

### Números complejos
Todo número complejo puede representarse como la suma de un número real y un número imaginario 
(que es un múltiplo real de la unidad imaginaria, que se indica con la letra $i$, o en forma polar).

### La clase NumeroComplejo
Vamos a desarrollar la clase número complejo. Para ello vamos a representar los números complejos
de la siguiente manera:

$$
4 + 5i = \textrm{NumeroComplejo(4.0, 5.0)}
$$

El diagrama de clases es el siguiente:

`Aquí va el diagrama de clase`

Los métodos son los siguientes:

1. `abs()`: obtiene el valor absolutos, módulo o magnitud del número complejo. Para esto tenga 
    en cuenta que si $x$ es la parte real y $y$ es la parte imaginaria, el valor absoluto se halla
$$
\sqrt{x^2 + y^2}
$$

2. `arg()`: obtiene el argumento o fase de un número complejo. Este argumento es el ángulo $\phi$
   que forman el eje de las abscisas y el vector representado por el número complejo. Este ángulo
   viene dado por la siguiente expresión:
$$
\phi = \textrm{atan2}(y, x)
$$
   donde $y$ es la parte imaginaria del número complejo y $x$ es la parte real. Adicionalmente
   $\textrm{atan2}(y, x)$ es la función arcotangente definida de la siguiente manera:

![Función arcotangente](https://wikimedia.org/api/rest_v1/media/math/render/svg/fdea743a3c598491f190fcb7a7d69ec0a633b0b8)

3. `conjugado()`: $\bar{z}$ Es un nuevo número complejo definido así: 
$$
z = a + bi \Leftrightarrow \bar{z} = a - bi
$$

4. `inverso()`: retorna el número complejo inverso. Para hallar este inverso, se tiene la siguiente
   fórmula. Si $z = a + bi$, entonces:

$$
z^{-1} = \frac{a}{a^2 + b^2} + \frac{-b}{a^2 + b^2}i
$$

5. `igual(comp)`: permite saber si el número complejo es igual al número complejo que se pasa
   como parámetro.

Adicionalmente, debemos desarrollar las siguientes operaciones:

* `sumarComplejos(c1, c2)`: obtiene la suma de los dos números complejos. Así si $c1 = a + bi$ y $c2 = c + di$
  entonces tenemos que:
$$
c1 + c2 = (a + c) + (b + d)i
$$

* `restarComplejos(c1, c2)`: La fórmula es igual a:
$$
c1 - c2 = (a - c) + (b - d)i
$$

* `prodEscalarComplejo(r, c)`: Halla la multiplicación entre un número real y un número complejo. Tenemos que
  $r$ es un número real y $c = a + bi$ es un número complejo. El resultado del producto escalar 
  es el siguiente:

$$
r \times c = (r \cdot a) + (r \cdot b)i
$$

* `multiplicarComplejos(c1, c2)`: obtiene y retorna la multiplicación de los números complejos
  $c1$ y $c2$. Esta se halla de la siguiente forma, si tomamos que $c1 = a + bi$ y $c2 = c + di$
  el resultado es:

$$
c1 \cdot c2 = (a + bi) \cdot (c +di) = (ac - bd) + (ad + bc)i
$$

* `dividirComplejos(c1, c2)`: obtiene y retorna la división de los números complejos
  $c1$ y $c2$. Esta se halla de la siguiente forma, si tomamos que $c1 = a + bi$ y $c2 = c + di$
  el resultado es:

$$
c1 \div c2 = \frac{a + bi}{c + di} =  \frac{ac + bd}{c^2 + d^2} + \frac{bc - ad}{c^2 + d^2}i
$$