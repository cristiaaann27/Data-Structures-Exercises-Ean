/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 * Departamento de Tecnologías de la Información y Comunicaciones
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Proyecto Exposición Canina.
 * Fecha: Marzo 2023
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package taller09

import kotlin.math.min


/**
 * Un perro es un objeto que participa en una
 * exposición canina, con los atributos que
 * se muestran a continuación.
 */
data class Perro(
    val placa: String,  // El identificador del perro
    val nombre: String, // El nombre del perro
    val raza: String,   // La raza del perro
    val edad: Int,      // La edad en años del perro,
    var puntos: Int     // El puntaje en la exposicion
) {
    // Retorna el año en que nació el perro, suponiendo que estamos en 2023
    fun añoNacimiento(): Int {
        return 2023 - edad
    }
}

// --------------------------------------------------------------------------

/**
 * Un nodo es un objeto especial capaz de referenciar a otro objeto
 * de la misma clase. En este caso usaremos un nodo sencillamente
 * encadenado que tiene un solo nodo siguiente.
 */
class NodoPerro(var info: Perro, var sig: NodoPerro? = null)

// ---------------------------------------------------------------------------

/**
 * Es la clase que se encarga de manejar, organizar, almacenar los perros.
 * No hay dos perros con la misma placa
 */
class ExposicionPerros() {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es la referencia a la cabeza de la lista, al primer perro.
     */
    var cabeza: NodoPerro? = null

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Obtiene la cantidad de nodos en la lista
     */
    fun numPerros(): Int {
        var contador = 0
        var p = cabeza
        while (p != null) {
            contador++
            p = p.sig
        }
        return contador
    }

    /**
     * La función recorre la lista buscando al perro que tiene la placa
     * que se pasa como parámetro. Retorna true si encontró el perro con
     * la placa y false si ningún perro tiene esa placa.
     */
    fun existePerro(placa: String): Boolean {
        var p = cabeza
        while (p != null) {
            if (p.info.placa == placa) {
                return true
            }
            p = p.sig
        }
        return false
    }

    /**
     * Encuentra y retorna el perro que tiene la placa que se
     * pasa como parámetro.
     *
     * Si no existe ningún perro con esa placa, debe retornarse
     * null.
     */
    fun obtenerPerroConPlaca(placa: String): Perro? {
        var p = cabeza
        while (p != null) {
            if (p.info.placa == placa) {
                return p.info
            }
            p = p.sig
        }
        return null
    }

    /**
     * Obtiene el perro que se encuentra en la posición
     * dada de la lista de nodos. Si la posición supera
     * al último nodo de la lista, deberá retornarse null.
     *
     * Las posiciones van desde cero en adelante.
     */
    fun obtenerPerroEnPosicion(posicion: Int): Perro? {
        require(posicion >= 0)
        if (posicion >= numPerros()) {
            return null
        }
        var p = cabeza
        var contador = 0
        while (contador != posicion) {
            p = p!!.sig
            contador++
        }
        return p!!.info
    }

    /**
     * Obtiene la posición dentro de la lista de nodos
     * donde se encuentra el perro que tiene la placa
     * que se pasa como parámetro.
     *
     * Si no existe un perro con esa placa dentro de la
     * lista de nodos, se debe retornar el valor -1
     */
    fun obtenerPosicionPerro(placa: String): Int {
        var p = cabeza
        var contador = 0
        while (p != null) {
            if (p.info.placa == placa) {
                return contador
            }
            p = p.sig
            contador++
        }
        return -1
    }

    /**
     * Crea un nodo con el perro dado dentro de él y lo coloca de primero
     * en la lista de nodos sencillamente encadenados.
     *
     * Si ya existe un perro con la misma placa que perro.placa debe
     * retornarse false. Si se pudo agregar el perro al principio de
     * la lista de nodos, se debe retornar true.
     */
    fun agregarAlPrincipio(perro: Perro): Boolean {
        if (existePerro(perro.placa)) {
            return false
        }
        val nuevoNodo = NodoPerro(perro)
        if (cabeza != null) {
            nuevoNodo.sig = cabeza
        }
        cabeza = nuevoNodo
        return true
    }

    /**
     * Crea un nodo con el perro dado dentro de él y lo coloca de último
     * en la lista de nodos sencillamente encadenados.
     *
     * Si ya existe un perro con la misma placa que perro.placa debe
     * retornarse false. Si se pudo agregar el perro al principio de
     * la lista de nodos, se debe retornar true.
     */
    fun agregarAlFinal(perro: Perro): Boolean {
        if (existePerro(perro.placa)) {
            return false
        }
        val nuevoNodo = NodoPerro(perro)
        if (cabeza == null) {
            cabeza = nuevoNodo
        } else {
            var p = cabeza
            while (p!!.sig != null) {
                p = p.sig
            }
            p.sig = nuevoNodo
        }
        return true
    }

    /**
     * Crea un nodo con el perro dado dentro de él y lo coloca en la
     * posición indicada. Si la posición es superior al número de
     * nodos en la lista, deberá agregarse el nuevo nodo al final
     * de la lista.
     *
     * Si ya existe un perro con la misma placa que perro.placa debe
     * retornarse false. Si se pudo agregar el perro al principio de
     * la lista de nodos, se debe retornar true.
     */
    fun agregarEnPosicion(posicion: Int, perro: Perro): Boolean {
        require(posicion >= 0)
        if(existePerro(perro.placa)){
            return false
        }
        else if (posicion == 0) {
            return agregarAlPrincipio(perro)
        } else if (posicion >= numPerros()) {
            return agregarAlFinal(perro)
        }else{
            var p = cabeza
            var contador = 0
            while (contador != posicion - 1 ) {
                p = p!!.sig
                contador++
            }
            val nuevoNodo = NodoPerro(perro)
            nuevoNodo.sig = p!!.sig
            p.sig = nuevoNodo
            return true
        }


    }

    /**
     * Elimina el nodo del perro que está de primero en la lista
     * de nodos.
     *
     * El método retorna false si la lista está vacía y
     * debe retornar true en caso contrario (indicando
     * que se pudo eliminar el nodo).
     */
    fun eliminarPrimero(): Boolean {
        if (cabeza == null) {
            return false
        }
        cabeza = cabeza!!.sig
        return true
    }

    /**
     * Elimina el nodo que está de último en la lista
     * de nodos.
     *
     * El método retorna false si la lista está vacía y
     * debe retornar true en caso contrario (indicando
     * que se pudo eliminar el nodo).
     */
    fun eliminarUltimo(): Boolean {
        if (cabeza == null) {
            return false
        }
        if (cabeza!!.sig == null) {
            cabeza = null
            return true
        }
        var p = cabeza
        while (p!!.sig!!.sig != null) {
            p = p.sig
        }
        p.sig = null
        return true
    }

    /**
     * Elimina de la lista el nodo que se encuentra en
     * la posición dada. Esta posición debe estar entre
     * 0 y el número de nodos - 1.
     *
     * El método debe retornar true si la posición es
     * válida (indicando que se pudo eliminar el nodo)
     * y debe retornar false si la posición es inválida
     */
    fun eliminarPosicion(posicion: Int): Boolean {

        if (posicion >= numPerros() || posicion < 0) {
            return false
        }
        when (posicion){
            0 -> return eliminarPrimero()
            numPerros() - 1 -> return eliminarUltimo()
            else -> {
                var p = cabeza
                var contador = 0
                while (contador != (posicion - 1)){
                    p = p!!.sig
                    contador++
                }
                p!!.sig = p!!.sig!!.sig
                return true
            }
        }

    }

    /**
     * Le suma a los puntos del perro con la placa dada
     * los puntos adicionales que se pasa como parámetro
     *
     * Se retorna true si se hizo el cambio a los puntos
     * (existe el perro con la placa dada) y false si el
     * perro con la placa dada no existe.
     */
    fun aumentarPuntosPerro(placa: String, puntosAdicionales: Int): Boolean {
        require(puntosAdicionales > 0)
        var p = cabeza
        while (p != null){
            if (p.info.placa == placa){
                p.info.puntos += puntosAdicionales
                return true
            }
            p = p.sig
        }
        return false
    }

    /**
     * Obtiene y retorna cuántos perros tienen una
     * edad entre los parámetros minimo y maximo
     * inclusives.
     */
    fun contarPerrosRangoEdad(minimo: Int, maximo: Int): Int {
        var p = cabeza
        var contador = 0
        while (p != null){
            if (p.info.edad >= minimo && p.info.edad <= maximo){
                contador++

            }
            p = p.sig
        }
        return contador
    }

    /**
     * Obtiene y retorna la suma de los puntos de los
     * perros cuyo nombre comienza por la letra que se
     * recibe como parámetro y cuya edad es par.
     */
    fun sumarPuntosPerros(letra: Char): Int {
        var p = cabeza
        var contador = 0
        while (p != null){
            if (p.info.nombre.startsWith(letra) && p.info.edad % 2 == 0){
                contador += p.info.puntos
            }
            p = p.sig
        }
        return contador
    }

    /**
     * Obtiene y retorna el promedio de la edad
     * de todos los perros de la lista de nodos
     */
    fun promedioEdadPerros(): Double {
        var p = cabeza
        var contador = 0
        var suma = 0
        while (p != null){
            suma += p.info.edad
            contador++
            p = p.sig
        }
        return suma.toDouble() / contador
    }

    /**
     * Obtiene y retorna el PERRO ganador de la
     * exposición, es decir, aquel perro que
     * posee el puntaje más alto. Si la lista
     * está vacía deberá retornarse null
     */
    fun ganador(): Perro? {
        when {
            numPerros() == 0 -> {
                return null
            }
            else -> {
                var p = cabeza
                var ganador = cabeza
                while (p != null) {
                    if (p.info.puntos > ganador!!.info.puntos) {
                        ganador = p
                    }
                    p = p.sig
                }
                return ganador?.info
            }
        }
    }

    /**
     * Obtiene y retorna la placa del perro
     * más joven de la lista que tienen una
     * cantidad de puntos inferior o igual
     * al puntaje que se pasa como parámetro.
     *
     * Si la lista está vacía, deberá retornarse
     * null.
     */
    fun masJoven(puntaje: Int): String? {
        when {
            numPerros() == 0 -> {
                return null
            }
            else -> {
                var p = cabeza
                var masJoven: NodoPerro? = null

                while (p != null) {
                    if (p.info.puntos <= puntaje && (masJoven == null || p.info.edad < masJoven.info.edad)) {
                        masJoven = p
                    }
                    p = p.sig
                }
                return masJoven?.info?.placa
            }
        }
    }

    /**
     * Obtiene y retorna el porcentaje de perros
     * que tienen un nombre que finaliza en la
     * letra que se pasa como parámetro.
     *
     * El porcentaje debe estar entre 0.0 y 100.0
     * OJO: Si la lista está vacía, debe retornar 0.0
     */
    fun porcentajePerrosFinalizanLetra(letra: Char): Double {
        when {
            numPerros() == 0 -> {
                return 0.0
            }
            else -> {
                var p = cabeza
                var contador = 0
                while (p != null) {
                    if (p.info.nombre.endsWith(letra)) {
                        contador++
                    }
                    p = p.sig
                }
                return (contador.toDouble() / numPerros()) * 100
            }
        }
    }
}