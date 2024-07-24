package taller08

import ean.colecciones.Lista
import ean.colecciones.listaVacia
import ean.colecciones.recorrer


/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad EAN (Bogotá - Colombia)
 * Departamento de Tecnología - Facultad de Ingeniería
 * Licenciado bajo el esquema Academic Free License version 2.1
 *
 * Ejercicio: Listas de Personas
 * Autor: Universidad EAN
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

/**
 * Un censo guarda información de un grupo de personas
 */
class Censo() {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    var personas: Lista<Persona> = listaVacia()

    /**
     * De los 3 estratos que hay en la lista de personas (2, 3 o 4)
     * hallar y obtener aquel estrato que tenga el promedio de
     * ingresos menor
     */
    fun ejercicio1(): Int {
        var estrato2 = 0
        var estrato3 = 0
        var estrato4 = 0
        var totalPersonasDos = 0
        var totalPersonasTres = 0
        var totalPersonasCuatro = 0
        recorrer(personas) {
            when (it.estrato) {
                2 -> {
                    estrato2 += it.ingresos
                    totalPersonasDos++
                }
                3 -> {
                    estrato3 += it.ingresos
                    totalPersonasTres++
                }
                4 -> {
                    estrato4 += it.ingresos
                    totalPersonasCuatro++
                }
            }

        }
        val promedio2 = estrato2 / totalPersonasDos
        val promedio3 = estrato3 / totalPersonasTres
        val promedio4 = estrato4 / totalPersonasCuatro

        return when {
            promedio2 < promedio3 && promedio2 < promedio4 -> 2
            promedio3 < promedio2 && promedio3 < promedio4 -> 3
            else -> 4
        }
    }

    /**
     * Obtener la cédula de la persona más joven de la lista
     */
    fun ejercicio2(): Int {
        var cedula = 0
        var edad = Int.MAX_VALUE
        for (i in 0..<personas.tam) {
            val p = personas[i]
            if (p.edad < edad) {
                edad = p.edad
                cedula = p.cedula
            }
        }
        return cedula
    }

    /**
     * Obtiene la posición en la lista donde se encuentra
     * la mujer que tienen los ingresos más altos. Si no
     * existe una mujer con ingresos altos, retorne -1
     */
    fun ejercicio3(): Int {
        var ingresos = 0
        var posicion = -1
        for (i in 0..<personas.tam) {
            val p = personas[i]
            if (p.genero == "F" && p.ingresos > ingresos) {
                ingresos = p.ingresos
                posicion = i
            }
        }
        return posicion
    }

    /**
     * Obtener la persona que mida más de 175 centímetros y que no use
     * lentes que tengo el peso más grande. Retorne null si no se
     * encuentra una persona con esas características
     */
    fun ejercicio4(): Persona? {
        var peso = 0
        var persona: Persona? = null
        for (i in 0..<personas.tam) {
            val p = personas[i]
            if (p.altura > 175 && !p.tieneLentes && p.peso > peso) {
                peso = p.peso
                persona = p
            }
        }
        return persona
    }

    /**
     * Obtener la persona de la altura más pequeña que tiene el nivel educativo
     * que se pasa como parámetro y tiene el género que se pasa como parámetro
     * también y que no tiene hijos. Si no existe una persona con esas características
     * retorne null.
     */
    fun ejercicio5(nivelEducativo: String, genero: String): Persona? {
        var altura = Int.MAX_VALUE
        var persona: Persona? = null
        for (i in 0..<personas.tam) {
            val p = personas[i]
            if (p.nivelEducativo == nivelEducativo && p.genero == genero && p.hijos == 0 && p.altura < altura) {
                altura = p.altura
                persona = p
            }
        }
        return persona
    }

    /**
     * Obtener la posición de la persona que tiene la cédula dada como
     * parámetro. Retorna -1 si no existe una persona con esa cédula.
     */
    fun ejercicio6(cedula: Int): Int {
        for (i in 0..<personas.tam) {
            val p = personas[i]
            if (p.cedula == cedula) {
                return i
            }
        }
        return -1
    }

    /**
     * Obtener la primera persona de la lista que sea mujer, tenga
     * ingresos superiores a los dos millones y cuya altura esté
     * entre 160 y 170 centímetros. Retorna null si no hay una persona
     * con esas características
     */
    fun ejercicio7(): Persona? {
        for (i in 0..<personas.tam) {
            val p = personas[i]
            if (p.genero == "F" && p.ingresos > 2000000 && p.altura in 160..170) {
                return p
            }
        }
        return null
    }

    /**
     * Obtener la lista con las cédulas de las personas que sean
     * de género femenino con una edad que no supera los 35 años
     * y con un peso entre 65 y 75 kilos y cuya altura sea múltiplo de 3.
     */
    fun ejercicio8(): Lista<Int> {
        val lista = listaVacia<Int>()
        recorrer(personas) {
            if (it.genero == "F" && it.edad < 35 && it.peso in 65..75 && it.altura % 3 == 0) {
                lista.agregarAlFinal(it.cedula)
            }
        }
        return lista
    }

    /**
     * Obtener la lista de las personas de la lista con una edad inferior
     * a la edad que se pasa como parámetro y que poseen el género que se
     * pasa como parámetro y que tienen hijos
     */
    fun ejercicio9(edad: Int, genero: String): Lista<Persona> {
        val lista = listaVacia<Persona>()
        recorrer(personas) {
            if (it.edad < edad && it.genero == genero && it.hijos > 0) {
                lista.agregarAlFinal(it)
            }
        }
        return lista
    }

}

/**
 * Escribir una función que obtenga cuántas personas tienen una edad por debajo
 * del promedio de edad de la lista
 */
fun ejercicio10(lista: Lista<Persona>): Int {
    var edades = 0
    recorrer(lista) {
        edades += it.edad
    }
    val promedio = edades / lista.tam
    var menores = 0
    recorrer(lista) {
        if (it.edad <= promedio) {
            menores++
        }
    }
    return menores
}