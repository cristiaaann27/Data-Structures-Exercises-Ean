package taller11
import ean.colecciones.*

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad EAN (Bogotá - Colombia)
 * Departamento de Sistemas
 * Faculta de Ingeniería
 *
 * Proyecto Taller de Pilas
 * Autor: Universidad EAN
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */



/**
 * A partir de una pila de palabras, retornar cuántas de esas
 * palabras son verbos. La pila original no debe verse modificada
 */
fun contarVerbos(palabras: Pila<String>): Int {
    val copia = palabras.copiar()
    var contador = 0
    while (!copia.vacia()) {
        val palabra = copia.desapilar()
        if (palabra.endsWith("ar") || palabra.endsWith("er") || palabra.endsWith("ir")) {
            contador++
        }
    }
    return contador
}

/**
 * Cuál es el promedio de los números pares que están en la
 * pila. La pila original no debe verse modificada
 */
fun promedioPares(pilaNums: Pila<Int>): Double {
    var suma = 0
    var contador = 0
    val copia = pilaNums.copiar()
    while (!copia.vacia()) {
        val num = copia.desapilar()
        if (num % 2 == 0) {
            suma += num
            contador++
        }
    }
    return if (contador > 0) suma.toDouble() / contador else 0.0
}

/**
 * Ejercicio 02
 * Función para sumar los números pares de tres cifras que hay en una
 * pila de enteros. La pila original no debe verse modificada.
 */
fun sumarParesTresCifras(pila: Pila<Int>): Int {
    var suma = 0
    val copia = pila.copiar()
    while (!copia.vacia()) {
        val num = copia.desapilar()
        if (num in 100..999 && num % 2 == 0) {
            suma += num
        }
    }
    return suma
}

/**
 * Ejercicio 03
 * Función para determinar cuál es el número más grande de dos cifras que hay
 * en una pila de números. Si no existe ningún número de dos cifras, retorne
 * null. La pila original no debe verse modificada.
 */
fun mayorDeDosCifras(pila: Pila<Int>): Int? {
    var mayor: Int? = null
    val copia = pila.copiar()
    while (!copia.vacia()) {
        val num = copia.desapilar()
        if (num in 10..99) {
            if (mayor == null || num > mayor) {
                mayor = num
            }
        }
    }
    return mayor
}

/**
 * Ejercicio 01
 * Obtener y retornar el fondo de la pila. La pila original no debe verse
 * modificada.
 */
fun <T> obtenerFondo(pila: Pila<T>): T {
    val copia = pila.copiar()
    val temp = pilaVacia<T>()
    while (!copia.vacia()) {
        temp.apilar(copia.desapilar())
    }
    return temp.tope()
}

/**
 * Ejercicio 04
 * Hacer una función externa que permita guardar un elemento en el fondo
 * de la pila. GEnérica. La pila original si debe verse modificada.
 */
fun <T> guardarEnElFondo(p: Pila<T>, elem: T) {
    val temp = pilaVacia<T>()
    while (!p.vacia()) {
        temp.apilar(p.desapilar())
    }
    p.apilar(elem)
    while (!temp.vacia()) {
        p.apilar(temp.desapilar())
    }
}

/**
 * Ejercicio 05
 * Función genérica para obtener el tamaño de una pila. La pila
 * original no debe verse modificada.
 */
fun <T> tamPila(p: Pila<T>) : Int {
    val copia = p.copiar()
    var contador = 0
    while (!copia.vacia()) {
        copia.desapilar()
        contador++
    }
    return contador
}

/**
 * Ejercicio 06
 * Función genérica que permite Invertir una pila en otra.
 * Recibe la pila y retorna la pila, pero invertida.
 * La pila original no debe verse modificada.
 * Solo puede usarse las operaciones de las pilas, no listas.
 */
fun <T> invertirPila(pila: Pila<T>): Pila<T> {
    val copia = pila.copiar()
    val temp = pilaVacia<T>()
    while (!copia.vacia()) {
        temp.apilar(copia.desapilar())
    }
    return temp
}


/**
 * Ejercicio 07
 * Función genérica que copia una pila en otra.
 * La función recibe la pila y retorna la copia.
 * No debe usarse el método copy de la pila ni listas.
 * La pila original no debe verse modificada.
 */
fun <T> copiarPila(pila: Pila<T>): Pila<T> {
    val copia = pilaVacia<T>()
    val temp = pilaVacia<T>()
    while (!pila.vacia()) {
        val e = pila.desapilar()
        temp.apilar(e)
    }
    while (!temp.vacia()) {
        val e = temp.desapilar()
        pila.apilar(e)
        copia.apilar(e)
    }
    return copia
}


/**
 * Ejercicio 08
 * Función genérica que recibe una pila y un elemento
 * y que elimina de la pila todas las ocurrencias del
 * elemento que se recibe como parámetro.
 * No debe retornar nada.
 */
fun <T> eliminarElementoPila(pila: Pila<T>, elem: T) {
    val temp = pilaVacia<T>()
    while (!pila.vacia()) {
        val e = pila.desapilar()
        if (e != elem) {
            temp.apilar(e)
        }
    }
    while (!temp.vacia()) {
        pila.apilar(temp.desapilar())
    }
}

/**
 * Ejercicio 09
 * Invertir una lista de números utilizando una pila. La función no retorna,
 * debe modificar la lista
 */
fun invertirLista(lista: Lista<Int>) {
    val pila = pilaVacia<Int>()
    recorrer(lista) {
        pila.apilar(it)
    }
    var i = 0
    while (!pila.vacia()) {
        lista[i] = pila.desapilar()
        i++
    }
}


/**
 * Ejercicio 10
 * Usar una pila de letras para Determinar si una frase es palindrome o no
 * Retorne true si la frase es palíndrome y false si no lo es.
 */
fun palindrome(frase: String): Boolean {
    val pila = pilaVacia<Char>()
    for (c in frase) {
        pila.apilar(c)
    }
    var esPalindrome = true
    for (c in frase) {
        if (c != pila.desapilar()) {
            esPalindrome = false
            break
        }
    }
    return esPalindrome
}

/**
 * Ejercicio 11
 * Determinar si dos pilas son iguales.
 * Retorne true si son idénticas o false si no es así
 * Las pilas no deben ser modificadas.
 */
fun <T> igualesPilas(pila1: Pila<T>, pila2: Pila<T>): Boolean {
    var iguales = true
    val temp1 = pilaVacia<T>()
    val temp2 = pilaVacia<T>()
    while (!pila1.vacia() && !pila2.vacia()) {
        val e1 = pila1.desapilar()
        val e2 = pila2.desapilar()
        temp1.apilar(e1)
        temp2.apilar(e2)
        if (e1 != e2) {
            iguales = false
            break
        }
    }
    while (!temp1.vacia()) {
        pila1.apilar(temp1.desapilar())
    }
    while (!temp2.vacia()) {
        pila2.apilar(temp2.desapilar())
    }
    return iguales
}

/**
 * Escriba una función que reemplace cada aparición del elemento
 * oldItem por el elemento newItem en la pila.
 */
fun reemplazarElementoPila(pila: Pila<Int>, oldItem: Int, newItem: Int) {
    val temp = pilaVacia<Int>()
    while (!pila.vacia()) {
        val elem = pila.desapilar()
        if (elem == oldItem) {
            temp.apilar(newItem)
        } else {
            temp.apilar(elem)
        }
    }
    while (!temp.vacia()) {
        pila.apilar(temp.desapilar())
    }
}

// Una clase que representa perros
data class Perro(val nombre: String, val raza: String, val edad: Int)

/**
 * Escriba una función que reciba una pila de perros y que retorne
 * una lista con los nombres de aquellos perros que tengan un nombre
 * que termine en vocal y cuya edad sea inferior a la edad que se
 * pasa como parámetro. La pila original no debe verse modificada.
 */
fun perrosMenoresEdad(perros: Pila<Perro>, edad: Int): Lista<String> {
    val copia = perros.copiar()
    val nombres = crearLista<String>()
    while (!copia.vacia()) {
        val perro = copia.desapilar()
        if (perro.edad < edad && (perro.nombre.endsWith("a") || perro.nombre.endsWith("e") ||
            perro.nombre.endsWith("i") || perro.nombre.endsWith("o") || perro.nombre.endsWith("u"))
        ) {
            nombres.agregarAlFinal(perro.nombre)
        }
    }
    return nombres
}

/**
 * Escriba esta función que reciba una pila de perros y que retorne
 * el perro más joven que pertenece a la raza que se pasa como
 * parámetro. La pila original no debe verse modificada, no puede
 * usarse listas ni funciones de orden superior. Si no hay perros
 * de esa raza, deberá retornarse null.
 */
fun perroMasJoven(perros: Pila<Perro>, raza: String): Perro? {
    var perroMasJoven: Perro? = null
    val copia = perros.copiar()
    while (!copia.vacia()) {
        val perro = copia.desapilar()
        if (perro.raza == raza) {
            if (perroMasJoven == null || perro.edad < perroMasJoven.edad) {
                perroMasJoven = perro
            }
        }
    }
    return perroMasJoven
}
