package taller16

import ean.colecciones.ArbolBinarioOrdenado
import ean.colecciones.Lista
import ean.colecciones.NodoArbolBinarioOrdenado
import ean.colecciones.recorrer

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad EAN (Bogotá - Colombia)
 * Departamento de Sistemas
 * Faculta de Ingeniería
 *
 * Taller Objetos Comparadores
 * Autor: Programa de Ingeniería de Sistemas - Universidad Ean
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

class SuperHéroe(val nombre: String, val poder: Int, val universo: String): Comparable<SuperHéroe> {
    /**
     * Primer criterio de comparación es el nombre, y el segundo será el poder.
     * Compares this object with the specified object for order. Returns zero if this object is equal
     * to the specified [other] object, a negative number if it's less than [other], or a positive number
     * if it's greater than [other].
     */
    override fun compareTo(other: SuperHéroe): Int {
        return compareValuesBy(this, other, SuperHéroe::nombre, SuperHéroe::poder)
    }

}

/**
 * Clase que representa la información de un producto.
 * Use el precio del producto como criterio de comparación.
 */

data class Producto(var nombre: String, var precio: Double, var cantidad: Int) : Comparable<Producto> {

    override fun compareTo(other: Producto): Int {
        return this.precio.compareTo(other.precio)
    }

}

//--------------------------------------------------------------------
// Un comparador de productos, usando el nombre como criterio de
// comparación.
//--------------------------------------------------------------------

class ComparadorDeProductosPorNombre : Comparator<Producto> {

    // Compara los productos por nombre
    override fun compare(o1: Producto?, o2: Producto?): Int {
        return o1!!.nombre.compareTo(o2!!.nombre)
    }

}

var ComparadorPorNombreYPrecio : Comparator<Producto> = Comparator { o1, o2 ->
    val res = o1.nombre.compareTo(o2.nombre)
    if (res == 0) {
        o1.precio.compareTo(o2.precio)
    } else {
        res
    }
}

var ComparadorPorCantidad: Comparator<Producto> = Comparator { o1, o2 ->
    val res = o1.cantidad.compareTo(o2.cantidad)
    if (res == 0) {
        o1.nombre.compareTo(o2.nombre)
    } else {
        res
    }
}

/**
 * Clase que representa un Reloj
 */
class Reloj : Comparable<Reloj> {
    /**
    Atributos: Un reloj tiene horas, minutos y segundos.
    La hora están 0 y 23, los minutos y segundos entre 0 y 59
     */

    var hora: Int = 0
    var minutos: Int = 0
    var segundos: Int= 0

    /**
     * Agregue un constructor que inicialice el reloj en la hora
     * actual del computador (este es el constructor por defecto)
     */
    constructor() {
        val ahora = java.util.Calendar.getInstance()
        hora = ahora.get(java.util.Calendar.HOUR_OF_DAY)
        minutos = ahora.get(java.util.Calendar.MINUTE)
        segundos = ahora.get(java.util.Calendar.SECOND)
    }

    constructor(hora: Int, minutos: Int, segundos: Int) {
        require(hora in 0 .. 24 && minutos in 0 .. 59 && segundos in 0 .. 59)
        this.hora = hora
        this.minutos = minutos
        this.segundos = segundos
    }

    /*
     * Agregue una función toString que muestre la hora en formato hh:mm:ss
     * y otra función toAMPMString que muestre el tiempo en hh:mm:ss AMPM
     * Las horas los minutos y segundos deben siempre mostrarse con dos
     * dígitos SIEMPRE!
     */
    override fun toString(): String {
        return if (segundos < 10 && minutos < 10 && hora < 10){
            "0$hora:0$minutos:0$segundos"
        }
        else if(minutos < 10 && hora < 10){
            "0$hora:0$minutos:$segundos"
        }else if(segundos < 10 && hora < 10){
            "0$hora:$minutos:0$segundos"
        }else if(minutos < 10 && segundos < 10){
            "$hora:0$minutos:0$segundos"
        }else if(minutos < 10){
            "$hora:0$minutos:$segundos"
        }else if(segundos < 10){
            "$hora:$minutos:0$segundos"
        }else if(hora < 10){
            "0$hora:$minutos:$segundos"
        }else{
            "$hora:$minutos:$segundos"
        }
    }

    fun toAMPMString(): String {
        val ampm = if (hora < 12) "AM" else "PM"
        val hora12 = if (hora > 12) hora - 12 else hora
        return if (segundos < 10 && minutos < 10 && hora12 < 10){
            "0$hora12:0$minutos:0$segundos $ampm"
        }
        else if(minutos < 10 && hora12 < 10){
            "0$hora12:0$minutos:$segundos $ampm"
        }else if(segundos < 10 && hora12 < 10){
            "0$hora12:$minutos:0$segundos $ampm"
        }else if(minutos < 10 && segundos < 10){
            "$hora12:0$minutos:0$segundos $ampm"
        }else if(minutos < 10){
            "$hora12:0$minutos:$segundos $ampm"
        }else if(segundos < 10){
            "$hora12:$minutos:0$segundos $ampm"
        }else if(hora12 < 10){
            "0$hora12:$minutos:$segundos $ampm"
        }else{
            "$hora12:$minutos:$segundos $ampm"
        }
    }


    /*
     * Agregue métodos para avanzar el reloj un segundo y otro para retrocederlo un segundo.
     * Adicionalmente un método equals.
     */
    fun avanzarUnSegundo() {
        segundos++
        if (segundos == 60) {
            segundos = 0
            minutos++
            if (minutos == 60) {
                minutos = 0
                hora++
                if (hora == 24) {
                    hora = 0
                }
            }
        }
    }

    fun retrocederUnSegundo() {
        segundos--
        if (segundos == -1) {
            segundos = 59
            minutos--
            if (minutos == -1) {
                minutos = 59
                hora--
                if (hora == -1) {
                    hora = 23
                }
            }
        }
    }

    /**
     * La función de comparación
     */
    override fun compareTo(other: Reloj): Int {
        return compareValuesBy(this, other, Reloj::hora, Reloj::minutos, Reloj::segundos)
    }

    /**
     * La función equals
     */
    override fun equals(other: Any?): Boolean {
        if (other is Reloj) {
            return this.hora == other.hora && this.minutos == other.minutos && this.segundos == other.segundos
        }
        return false

}
}

//---------------------------------------------------------------------------

/**
 * Esta función retorna la posición del Reloj con el menor tiempo de toda la lista.
 * Escriba la función sin usar recursión. Retorne -1 si la lista está vacía.
 */
fun relojMenorTiempo(relojes: Lista<Reloj>): Int {
    if (relojes.vacia()) {
        return -1
    }
    var menorTiempo = relojes[0]
    var posicion = 0

    for (i in 1 until relojes.tam) {
        if (relojes[i] < menorTiempo) {
            posicion = i
        }
    }

    return posicion
}

/**
 * La clase Pais guarda información de los paises del mundo.
 * Esta será una clase comparable, con el nombre del país como
 * único criterio de comparación.
 */
data class Pais(val nombre: String, val continente: String, val poblacion: Int) :
        Comparable<Pais> {
    override fun compareTo(other: Pais): Int {
        return nombre.compareTo(other.nombre)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Pais

        return nombre == other.nombre
    }

    override fun hashCode(): Int {
        return nombre.hashCode()
    }


}

/**
 * Escriba una función que reciba un árbol binario ordenado de paises, y el nombre
 * de un pais y que retorne la población de ese país. Si el árbol está vacío
 * deberá retornarse null. La busqueda debe ser "inteligente", es decir, debe
 * aprovechar el hecho que el árbol está ordenado por nombre. Esta función
 * TIENE que ser recursiva.
 */
fun poblacionPais(paises: ArbolBinarioOrdenado<Pais>, nomPais: String): Int? {
    fun nodoPoblacionPais(nodo: NodoArbolBinarioOrdenado<Pais>?, nomPais: String): Int? =
        when {
            nodo == null -> null
            nodo.info.nombre == nomPais -> nodo.info.poblacion
            nodo.info.nombre > nomPais -> nodoPoblacionPais(nodo!!.izq, nomPais)
            else -> nodoPoblacionPais(nodo!!.der, nomPais)
        }


    return nodoPoblacionPais(paises.raiz!!, nomPais)

}

/**
 * Escriba una función que reciba una lista de nombres de paises y un árbol
 * binario ordenado de paises (clase que definimos anteriormente) y que
 * retorne el nombre del pais de la lista que está más poblado, de acuerdo
 * con lo que se encuentra en el árbol. Use la función anterior para encontrar
 * la población de cada país de la lista.
 */
fun paisMasPoblado(nombresPaises: Lista<String>, paises: ArbolBinarioOrdenado<Pais>): String {
    var masPoblado = ""
    var poblacionMas = 0
    recorrer(nombresPaises) {
        val poblacion = poblacionPais(paises, it)

        if (poblacion != null && poblacion > poblacionMas) {
            poblacionMas = poblacion
            masPoblado = it
        }
    }
    return masPoblado
}
