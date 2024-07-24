package tallerrecursion

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad EAN (Bogotá - Colombia)
 * Departamento de Sistemas
 * Faculta de Ingeniería
 *
 * Taller Funciones Recursivas
 * Fecha: 4 de octubre de 2023
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

import ean.colecciones.Lista
import ean.colecciones.crearLista
import kotlin.math.pow
import kotlin.math.sqrt

/**
 * Halla el factorial del número entero n
 * n! = n * (n-1) * (n-2) * ... * 2 * 1
 */
fun factorial(n: Int): Int =
    if (n == 0) 1 else n * factorial(n - 1)


/**
 * Halla el n-ésimo término de la serie de fibonacci
 */
fun fibonacci(n: Int): Int =
    if (n == 0 || n == 1) n else fibonacci(n - 1) + fibonacci(n - 2)

/**
 * Permite determinar el término n,m del triángulo de Pascal
 * n = fila, m = término
 */
fun pascal(n: Int, m: Int): Int {
    if (m == 1 || m == n + 1) return 1
    return pascal(n - 1, m - 1) + pascal(n - 1, m)
}
/**
 * Halla el valor de x^y =
 * si y es cero entonces retorne 1
 * sino retorne x multiplicado por elevar x a la y - 1
 */
fun elevar(x: Int, y: Int): Int = if (y == 0) 1 else x * elevar(x, y - 1)

/**
 * Halla la suma de todos los números enteros entre 1 y n
 */
fun sumatoria(n: Int): Int =
    if (n == 1) 1 else n + sumatoria(n - 1)

/**
 * Halla la suma de los cuadrados de los números de 1 hasta n
 */
fun sumaCuadrados(n: Int): Int = if (n == 1) 1 else n * n + sumaCuadrados(n - 1)

/**
 * Hallar el valor de la sumatoria de 1/(2i+1) desde  1 hasta n
 */
fun serie(n: Int): Double = if (n == 1) (1.0/3) else (1.0 / (2 * n + 1)) + serie(n - 1)

/**
 * Hallar el valor de la sumatoria de 1 hasta n de i/(i^2+1)
 */
fun sumatoria2(n: Int): Double = if (n == 1) (1/2.0) else (n.toDouble() / (n * n + 1)) + sumatoria2(n - 1)

/**
 * Permite saber la cantidad de digitos que posee un número entero positivo n
 */
fun contarDigitos(n: Int): Int =
    if (n < 10) 1 else 1 + contarDigitos(n / 10)

/**
 * Permite saber el número de ceros que tiene un número.
 * Por ejemplo: 2020 tiene dos ceros.
 */
fun numeroDeCeros(n: Int): Int =
    if (n < 10) if (n == 0) 1 else 0 else numeroDeCeros(n / 10) + if (n % 10 == 0) 1 else 0

/**
 * Permite hallar la suma de los dígitos de un número entero positivo n
 */
fun sumarDigitos(n: Int): Int = if (n < 10) n else n % 10 + sumarDigitos(n / 10)

/**
 * Cuenta el número de dígitos pares que tiene un número entero positivo >= 1
 */
fun cantidadDigitosPares(n: Int): Int {
    if (n < 10) return if (n % 2 == 0) 1 else 0
    return cantidadDigitosPares(n / 10) + if (n % 2 == 0) 1 else 0
}

/**
 * Determina si el número dado es binario o no.
 * Los números binarios solo contienen los dígitos 1 y 0
 * Por ejemplo: el numero 100011110 es binario, pero 231 no lo es
 */
fun esNumeroBinario(n: Int): Boolean {
    if (n < 10) return n == 0 || n == 1
    return esNumeroBinario(n / 10) && (n % 10 == 0 || n % 10 == 1)
}

/**
 * Permite saber si el número dado posee el dígito indicado
 */
fun poseeDigito(n: Int, digito: Int): Boolean {
    /*
    si el numero n posee un solo digito, entonces
       si n y el digito son iguales -> retorne true sino retorne false
    sino si el número n tiene más de un dígito, entonces
       si el ultimo dígito del número n es igual al dígito, entonces
         listo, lo encontramos, retorne true
       sino
         halle el resto de n
         mire si el resto de n posee el dígito indicado
     */
    if (n < 10) return n == digito
    return if (n % 10 == digito) true else poseeDigito(n / 10, digito)
}

/**
 * Retorna el dígito más grande que hace parte del número n
 * Ejemplo: el dígito más grande del númer 381704 es el 8
 * si el número tiene un solo dígito, el digito más grande es el numero
 * sino
 *    halle el resto y el último
 *    halla el digito mas grande del resto
 *    retorne el mayor entre el último y el dígito más grande del resto
 */
fun digitoMasGrande(n: Int): Int {
    if (n < 10) return n
    val resto = n / 10
    val ultimo = n % 10
    val digitoMasGrandeDelResto = digitoMasGrande(resto)
    return if (ultimo > digitoMasGrandeDelResto) ultimo else digitoMasGrandeDelResto
}

/**
 * Halla el máximo común divisor entre m y n, utilizando el método de
 * Euclides.
 */
fun mcd(m: Int, n: Int): Int =
    if (n == 0) m else mcd(n, m % n)

/**
 * Imprimir cada elemento de la lista, pero de manera recursiva
 */
fun <T> imprimirLista(lista: Lista<T>) {
    if (!lista.vacia()){
        val primero = lista.primero
        val resto = lista.resto()
        println(primero)
        imprimirLista(resto)
    }
}

/**
 * Obtiene recursivamente la lista de los dígitos del número entero positivo n
 * Ejemplo: digitos(351804) == [3, 5, 1, 8, 0, 4]
 */
fun digitos(n: Int): Lista<Int> {
    if (n < 10) return crearLista(n)
    val resto = n / 10
    val ultimo = n % 10
    val digitosDelResto = digitos(resto)
    digitosDelResto.agregarAlFinal(ultimo)
    return digitosDelResto
}
/**
 * Dado un número entero positivo >= 0, retorna una lista con la representación binaria
 * del número dado.
 * Ejemplo: convertirDecimalBinario(231) = List(1, 1, 0, 0, 1, 1, 1, 1, 1, 1)
 */
fun convertirDecimalBinario(n: Int): Lista<Int> {
    if (n < 2) return crearLista(n)
    val resto = n / 2
    val ultimo = n % 2
    val binarioDelResto = convertirDecimalBinario(resto)
    binarioDelResto.agregarAlFinal(ultimo)
    return binarioDelResto
}

/**
 * Determina cuantas palabras en la lista son verbos.
 * Recursivamente.
 */
fun contarVerbos(palabras: Lista<String>): Int =
    if (palabras.vacia()) 0 else {
        val primera = palabras.primero
        val resto = palabras.resto()
        val esVerbo = primera.endsWith("ar") || primera.endsWith("er") || primera.endsWith("ir")
        if (esVerbo) 1 + contarVerbos(resto) else contarVerbos(resto)
    }

/**
 * Recursion con listas: Hallar la suma de los números pares de la lista que se recibe
 * como parámetro.
 * Ejemplo: sumarParesLista([40, 21, 8, 31, 6]) == 54
 */
fun sumarParesLista(lista: Lista<Int>): Int {
    if (lista.vacia()) return 0
    val primero = lista.primero
    val resto = lista.resto()
    return if (primero % 2 == 0) primero + sumarParesLista(resto) else sumarParesLista(resto)
}

/**
 * Recursión con listas: construir una función recursiva que retorne la posición del elemento en la lista
 * Si la lista está vacía, retorne -1.
 */
fun buscarElementoEnUnaLista(lista: Lista<Int>, elem: Int): Int {
    if (lista.vacia()) return -1
    val primero = lista.primero
    val resto = lista.resto()
    return if (primero == elem) 0 else {
        val pos = buscarElementoEnUnaLista(resto, elem)
        if (pos == -1) -1 else pos + 1
    }
}

/**
 * Traduce los diversos dígitos de la lista a un número entero recursivametne
 * Ejemplo: convertirListaDigitosNumero([3, 4, 1, 7, 9]) == 34179
 */
fun convertirListaDigitosNumero(digitos: Lista<Int>): Int {
if (digitos.tam == 1) return digitos.primero
    val primero = digitos.primero
    val resto = digitos.resto()
    return primero * elevar(10, resto.tam) + convertirListaDigitosNumero(resto)
}

/**
 * Función genérica y recursiva que permite saber si un elemento está dentro
 * de la lista. No debe usarse la función indexOf o contains. Debe ser
 * recursiva. Para buscar un elemento hay que tener en cuenta
 * - si la lista está vacía, el elemento no está
 * - si el primero de la lista es igual al elemento, retornamos true (el elemento está)
 * - sino es igual al primero, entonces hay que ver si el elemento está en el resto de la lista
 */
fun <T> existeElemento(lista: Lista<T>, elem: T): Boolean {
    if (lista.vacia()) return false
    val primero = lista.primero
    val resto = lista.resto()
    return if (primero == elem) true else existeElemento(resto, elem)
}

/** Escribir una función recursiva que, sin usar pilas ni colas
 * ni ninguna otra lista, obtenga la misma lista, pero invertida
 */
fun invertirLista(lista: Lista<Char>): Lista<Char> {
    if (lista.vacia()) return lista
    val primero = lista.primero
    val resto = lista.resto()
    val invertida = invertirLista(resto)
    invertida.agregarAlFinal(primero)
    return invertida
}

/**
 * Recursividad con listas. Escriba una función recursiva
 * Obtiene el número más grande de la lista. Si la lista está vacía retorne el número
 * entero más pequeño.
 */
fun mayorDeUnaLista(lista: Lista<Int>): Int {
    if (lista.vacia()) return Int.MIN_VALUE
    val primero = lista.primero
    val resto = lista.resto()
    val mayorDelResto = mayorDeUnaLista(resto)
    return if (primero > mayorDelResto) primero else mayorDelResto
}

/**
 * Escriba una función recursiva que determine si todos los elementos
 * de la lista son positivos. Procure no crear ninguna función auxiliar.
 * Suponga que la lista nunca va a ser vacía, así que el caso trivial
 * será cuando la lista tenga un solo elemento. El cero es positivo.
 */
fun todosNumerosPositivos(lista: Lista<Int>): Boolean {
    if (lista.tam == 1) return lista.primero >= 0
    val primero = lista.primero
    val resto = lista.resto()
    return primero >= 0 && todosNumerosPositivos(resto)
}

/**
 * Escriba una función recursiva que determine si todos los números
 * pares que hay en la lista tienen dos cifras. No puede usar funciones
 * auxiliares. Suponga que la lista nunca va a ser vacía, así que el
 * caso trivial será cuando la lista tenga un solo elemento.
 */
fun todosParesDosCifras(lista: Lista<Int>): Boolean {
    if (lista.tam == 1) {
        val primero = lista.primero
        if (primero % 2 != 0 && primero in 10..99){
            return false
        }else{
            return true
        }

    }

    val primero = lista.primero
    val resto = lista.resto()
    if (primero % 2 != 0 && primero in 10..99) {
        return false
    }

    return todosParesDosCifras(resto)
}

/**
 * Escriba una función recursiva que reciba una lista de letras, y que
 * retorne la misma lista pero con cada lista convertida a
 * mayúscula. Use el método toUpper para convertir una letra a
 * mayúsculas.
 */
fun convertirMayusculas(letras: Lista<Char>): Lista<Char> {
    if (letras.vacia()) return letras
    val primero = letras.primero
    val resto = letras.resto()
    val mayuscula = primero.toUpperCase()
    val restoMayuscula = convertirMayusculas(resto)
    restoMayuscula.agregarAlPrincipio(mayuscula)
    return restoMayuscula
}

/**
 * Una clase auxiliar
 */
data class Punto(val x: Int, val y: Int) {
    fun distanciaAlOrigen(): Double = sqrt(x.toDouble().pow(2) + y.toDouble().pow(2))
}

/**
 * Recursivamente, obtener una lista con aquellos puntos que están en el origen o
 * que hacen parte del primer cuadrante.
 */
fun puntosPrimerCuadrante(puntos: Lista<Punto>): Lista<Punto> {
    if (puntos.vacia()) return puntos
    val primero = puntos.primero
    val resto = puntos.resto()
    val puntosDelResto = puntosPrimerCuadrante(resto)
    return if (primero.x >= 0 && primero.y >= 0) {
        puntosDelResto.agregarAlFinal(primero)
        puntosDelResto
    } else puntosDelResto
}

/**
 * Recursivamente, obtiene el punto que está más lejano del origen.
 * Si la lista esta vacía, retorne null
 * Si la lista tiene un solo elemento, retorne ese elemento
 * si la lista tiene más de un elemento, tome el primer elemento y
 * compárelo con el punto más lejano del resto de la lista.
 */
fun puntoMasLejano(puntos: Lista<Punto>): Punto? {
    if (puntos.vacia()) return null
    if (puntos.tam == 1) return puntos.primero
    val primero = puntos.primero
    val resto = puntos.resto()
    val puntoMasLejanoDelResto = puntoMasLejano(resto)
    return if (primero.distanciaAlOrigen() > puntoMasLejanoDelResto!!.distanciaAlOrigen()) primero else puntoMasLejanoDelResto
}

fun sumatoriaQuiz(n: Int): Double = if (n == 1) (1.0/2) else (((n - 1.0)/(n + 1.0)) + ((2.0 * n.toDouble().pow(2)) / (n.toDouble().pow(2) + (2*n) +1))) + sumatoriaQuiz(n - 1)


