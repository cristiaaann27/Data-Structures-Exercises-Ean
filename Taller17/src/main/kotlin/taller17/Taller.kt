/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas
 *
 * Taller de Ordenamiento
 * Estructura de Datos
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package taller17

import ean.colecciones.Lista
import java.util.Comparator

/**
 * Algoritmo de Burbuja. Usar el ordenamiento natural del objeto
 * Complejidad: O(n^2)
 */
fun bubbleSort(a: Lista<Int>): Unit {
    val n = a.tam
    for (i in 0 until n ) {
        for (j in 0 until n - 1) {
            if (a[j] > a[j + 1]) {

                val temp = a[j]
                a[j] = a[j + 1]
                a[j + 1] = temp
            }
        }
    }
}

/**
 * Algoritmo de ordenamiento por burbuja. Usar el comparador
 * que se tiene como parámetro para realizar el ordenamiento.
 * Complejidad: O(n^2)
 */
fun ordenarPorBurbuja(lista: Lista<String>, comparador: Comparator<String>) {
    val n = lista.tam
    for (i in 0 until n ) {
        for (j in 0 until n - 1) {
            if (comparador.compare(lista[j], lista[j + 1]) > 0) {
                val temp = lista[j]
                lista[j] = lista[j + 1]
                lista[j + 1] = temp
            }
        }
    }

}

/**
 * Desarrolle la busqueda binaria del elemento en la lista a
 */
fun busquedaBinaria(a: Lista<Int>, elem: Int): Int {
    val n = a.tam
    var inicio = 0
    var fin = n - 1
    while (inicio <= fin) {
        val medio = (inicio + fin) / 2
        when {
            a[medio] == elem -> return medio
            a[medio] > elem -> fin = medio - 1
            else -> inicio = medio + 1
        }
    }
    return -1
}

/**
 * Información de un aspirante a un empleo en una bolsa de empleo
 */
data class Aspirante(val nombre: String,
                     val profesion: String,
                     val añosExperiencia: Int,
                     val edad: Int,
                     val telefono: String) : Comparable<Aspirante> {
    override fun compareTo(other: Aspirante): Int = this.nombre.compareTo(other.nombre)
}

/**
 * Ordena la lista de aspirantes por nombre usando el algoritmo de burbuja
 */
fun ordenarPorNombre(aspirantes: Lista<Aspirante>) {
    val n = aspirantes.tam
    for (i in 0 until n ) {
        for (j in 0 until n - 1) {
            if (aspirantes[j] > aspirantes[j + 1]) {
                val temp = aspirantes[j]
                aspirantes[j] = aspirantes[j + 1]
                aspirantes[j + 1] = temp
            }
        }
    }
}

/**
 * Ordena la lista de aspirantes por edad usando el algoritmo de selección
 */
fun ordenarPorEdad(aspirantes: Lista<Aspirante>) {
    val n = aspirantes.tam
    for (i in 0 until n - 1) {
        var min = i
        for (j in i + 1 until n) {
            if (aspirantes[j].edad < aspirantes[min].edad) {
                min = j
            }
        }
        if (min != i) {
            val temp = aspirantes[i]
            aspirantes[i] = aspirantes[min]
            aspirantes[min] = temp
        }
    }
}

/**
 * Ordena la lista de aspirantes por profesión utilizando el algoritmo de inserción
 */
fun ordenarPorAñosDeExperiencia(aspirantes: Lista<Aspirante>) {
    val n = aspirantes.tam
    for (i in 1 until n) {
        val temp = aspirantes[i]
        var j = i - 1
        while (j >= 0 && aspirantes[j].añosExperiencia > temp.añosExperiencia) {
            aspirantes[j + 1] = aspirantes[j]
            j--
        }
        aspirantes[j + 1] = temp
    }
}

/**
 * Ordena la lista de aspirantes por profesión usando el algoritmo de ordenamiento shell sort
 */
fun ordenarPorProfesion(aspirantes: Lista<Aspirante>) {
    val n = aspirantes.tam
    var salto = n / 2
    while (salto > 0) {
        for (i in salto until n) {
            val temp = aspirantes[i]
            var j = i
            while (j >= salto && aspirantes[j - salto].profesion > temp.profesion) {
                aspirantes[j] = aspirantes[j - salto]
                j -= salto
            }
            aspirantes[j] = temp
        }
        salto /= 2
    }
}

/**
 * Ordena la lista de aspirantes por nombre utilizando el algoritmo de ordenamiento merge sort
 */
fun ordenarPorNombreConMergeSort(a: Lista<Aspirante>) {
    /**
     * Obtiene los elementos de la lista ubicados en la mitad inferior de la misma
     * es decir, en las posiciones desde la cero hasta la mitad de la lista
     */
    fun obtenerMitadInferior(lista: Lista<Aspirante>): Lista<Aspirante> {
        val resultado = Lista<Aspirante>()
        for (i in 0 until lista.tam / 2) {
            resultado.agregarAlFinal(lista[i])
        }
        return resultado
    }

    /**
     * Obtiene los elementos de la lista ubicados en la mitad superior de la misma
     * es decir, en las posiciones desde la mitad + 1 hasta el final de la lista
     */
    fun obtenerMitadSuperior(lista: Lista<Aspirante>): Lista<Aspirante> {
        val resultado = Lista<Aspirante>()
        for (i in lista.tam / 2 until lista.tam) {
            resultado.agregarAlFinal(lista[i])
        }
        return resultado
    }

    /**
     * Retorna la mezcla ordenada de las listas a y b, usando el nombre como criterio
     */
    fun mezclarListas(a: Lista<Aspirante>, b: Lista<Aspirante>): Lista<Aspirante> {
        val resultado = Lista<Aspirante>()
        var i = 0
        var j = 0
        while (i < a.tam && j < b.tam) {
            if (a[i].nombre < b[j].nombre) {
                resultado.agregarAlFinal(a[i])
                i++
            }
            else {
                resultado.agregarAlFinal(b[j])
                j++
            }
        }
        while (i < a.tam) {
            resultado.agregarAlFinal(a[i])
            i++
        }
        while (j < b.tam) {
            resultado.agregarAlFinal(b[j])
            j++
        }
        return resultado
    }

    //------------------------------------------------------------------------------
    // Función Principal del MergeSort
    //------------------------------------------------------------------------------
    if (a.tam >= 2) {
        if (a.tam == 2) {
            if (a[0].nombre > a[1].nombre) {
                val temp = a[0]
                a[0] = a[1]
                a[1] = temp
            }
        }
        else {
            // Algoritmo MergeSort.

            // 1. Particione la lista en dos mitades
            val p: Lista<Aspirante> = obtenerMitadInferior(a)
            val q: Lista<Aspirante> = obtenerMitadSuperior(a)

            // 2. ordene cada mitad usando mergesort
            ordenarPorNombreConMergeSort(p)
            ordenarPorNombreConMergeSort(q)

            // 3. Mezcle las dos listas ordenadas y copielas a la lista de resultado
            val resultado = mezclarListas(p, q)
            a.limpiar()
            a.agregarLista(resultado)
        }
    }
}

/**
 * Ordene la lista de aspirantes por nombre utilizando el algoritmo de ordenamiento quick sort
 */
fun ordenarPorNombreConQuickSort(lista: Lista<Aspirante>) {
    /**
     * Obtener los aspirantes que tengan un nombre inferior al pivote en la lista a
     */
    fun menoresAlPivote(a: Lista<Aspirante>, pivote: Aspirante): Lista<Aspirante> {
        val resultado = Lista<Aspirante>()
        for (i in 1 until a.tam) {
            if (a[i].nombre < pivote.nombre) {
                resultado.agregarAlFinal(a[i])
            }
        }
        return resultado
    }

    /**
     * Obtener los aspirantes que tengan un nombre superior al pivote en la lista a
     */
    fun mayoresAlPivote(a: Lista<Aspirante>, pivote: Aspirante): Lista<Aspirante> {
        val resultado = Lista<Aspirante>()
        for (i in 1 until a.tam) {
            if (a[i].nombre >= pivote.nombre) {
                resultado.agregarAlFinal(a[i])
            }
        }
        return resultado
    }

    //-----------------------------------------------------------------
    // Función Principal
    //-----------------------------------------------------------------
    if (lista.tam >= 2) {
        if (lista.tam == 2) {
            if (lista[0] > lista[1]) {
                val temp = lista[0]
                lista[0] = lista[1]
                lista[1] = temp
            }
        }
        else {
            // Algoritmo QuickSort

            // 1. Obtener el pivote, en este caso puede ser el nombre del primer elemento
            val pivote = lista[0]

            // 2. Obtener los menores y los mayores al pivote
            val mayores = mayoresAlPivote(lista, pivote)
            val menores = menoresAlPivote(lista, pivote)

            // 3. Ordene estas dos últimas listas usando el quicksort
            ordenarPorNombreConQuickSort(mayores)
            ordenarPorNombreConQuickSort(menores)

            // 4. Ahora pegamos los pedazos junto con el pivote
            lista.limpiar()
            lista.agregarLista(menores)
            lista.agregarAlFinal(pivote)
            lista.agregarLista(mayores)
        }
    }
}

/**
 * Busca un Aspirante según su nombre y retorna la posición en la que se encuentra.
 * Si no se encuentra ningún aspirante con ese nombre se retorna -1.
 * Utilice la búsqueda lineal típica
 */
fun buscarAspirante(lista: Lista<Aspirante>, nombre: String): Int {
    for (i in 0 until lista.tam) {
        if (lista[i].nombre == nombre) {
            return i
        }
    }
    return -1
}

/**
 * Busca un aspirante según su nombre, utilizando una búsqueda binaria.
 * Si no se encuentra ningún aspirante con ese nombre se retorna -1.
 * OJO: la lista de aspirantes ya está ordenada, puede confiar en eso
 */
fun buscarBinarioPorNombre(lista: Lista<Aspirante>, nombre: String): Int {
    var inicio = 0
    var fin = lista.tam - 1
    while (inicio <= fin) {
        val medio = (inicio + fin) / 2
        when {
            lista[medio].nombre == nombre -> return medio
            lista[medio].nombre > nombre -> fin = medio - 1
            else -> inicio = medio + 1
        }
    }
    return -1
}

//----------------------------------------------------------------------------------

/**
 * Se retornó la posición donde se encuentra el aspirante más joven.
 * Si no hay aspirantes en la lista se retornó -1
 */
fun buscarAspiranteMasJoven(aspirantes: Lista<Aspirante>): Int {
    var pos = -1
    var edad = Int.MAX_VALUE
    for (i in 0 until aspirantes.tam) {
        if (aspirantes[i].edad < edad) {
            pos = i
            edad = aspirantes[i].edad
        }
    }
    return pos
}

/**
 * Se retornó la posición donde se encuentra el aspirante con mayor experiencia.
 * Si no hay aspirantes en la bolsa se retornó -1
 */
fun buscarAspiranteMayorExperiencia(aspirantes: Lista<Aspirante>): Int {
    var pos = -1
    var experiencia = Int.MIN_VALUE
    for (i in 0 until aspirantes.tam) {
        if (aspirantes[i].añosExperiencia > experiencia) {
            pos = i
            experiencia = aspirantes[i].añosExperiencia
        }
    }
    return pos
}

