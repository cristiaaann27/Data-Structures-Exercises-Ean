package taller07

import ean.colecciones.Lista
import ean.colecciones.listaVacia

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
     * Permite obtener la cantidad de hombres en la lista de personas
     */
    fun cantHombres(): Int {
        var cant = 0
        for (i in 0 ..< personas.tam) {
            val p = personas[i]
            if (p.genero == "M") {
                cant++
            }
        }
        return cant
    }

    /**
     * Obtiene la cantidad de mujeres que tienen automóvil
     */
    fun contarMujeresConAutomovil(): Int {
        var cant = 0
        for (i in 0 ..< personas.tam) {
            val p = personas[i]
            if (p.genero == "F" && p.tieneAutomovil) {
                cant++
            }
        }
        return cant
    }

    /**
     * Permite sabe cuántos fumadores tienen menos de la edad especificada
     * pertenecen al estrato 2 o 4
     */
    fun ejercicio1(edad: Int): Int {
        var cant = 0
        for (i in 0 ..< personas.tam) {
            val p = personas[i]
            if (p.edad < edad && (p.estrato == 2 || p.estrato == 4) && p.fuma) {
                cant++
            }
        }
        return cant
    }

    /**
     * Encuentra la cantidad de personas que tienen automóvil
     * pero no tienen hijos y cuyos ingresos no superan los dos millones
     * de pesos y que cuyo nivel educativo es de PRIMARIA o PREGRADO
     */
    fun ejercicio2(): Int {
        var cant = 0
        for (i in 0 ..< personas.tam) {
            val p = personas[i]
            if (p.tieneAutomovil && p.hijos == 0 && p.ingresos < 2000000 &&
                (p.nivelEducativo == "PRIMARIA" || p.nivelEducativo == "PREGRADO")) {
                cant++
            }
        }
        return cant
    }

    /**
     * Obtener el porcentaje de todas las personas  de aquellas mujeres de cédula par
     * que tienen casa pero no hijos ni tienen automóvil y cuyos ingresos están
     * entre los 1 y 3 millones de pesos
     */
    fun ejercicio3(): Double {
        var cant = 0
        for (i in 0 ..< personas.tam) {
            val p = personas[i]
            if (p.genero == "F" && p.cedula % 2 == 0 && p.tieneCasa && !p.tieneAutomovil &&
                p.hijos == 0 && p.ingresos in 1000000 .. 3000000) {
                cant++
            }
        }
        return (cant * 100.0) / personas.tam
    }

    /**
     * Obtener la cantidad de personas cuyo índice de masa
     * corporal enté entre 25.0 y 30.0
     */
    fun ejercicio4(): Int {
        var cant = 0
        for (i in 0 ..< personas.tam) {
            val p = personas[i]
            if (p.IMC() in 25.0 .. 30.0) {
                cant++
            }
        }
        return cant
    }

    /**
     * Encontrar la suma de los ingresos de aquellas personas
     * que no fuman y que sean mayores de 50 años de edad
     */
    fun ejercicio5(): Int {
        var suma = 0
        for (i in 0 ..< personas.tam) {
            val p = personas[i]
            if (p.edad > 50 && !p.fuma) {
                suma += p.ingresos
            }
        }
        return suma
    }

    /**
     * Método que retorne la suma de los pesos
     * de las personas de genero femenino, cuyo cédula es par
     * y que son madres
     */
    fun ejercicio6(): Int {
        var suma = 0
        for (i in 0 ..< personas.tam) {
            val p = personas[i]
            if (p.genero == "F" && p.cedula % 2 == 0 && p.hijos > 0) {
                suma += p.peso
            }
        }
        return suma
    }

    /**
     * Método que retorne el promedio de edad
     * de los hombres que se ganan entre 2 y 3 millones
     */
    fun ejercicio7(): Double {
        var sumaEdad = 0
        var cant = 0
        for (i in 0 ..< personas.tam) {
            val p = personas[i]
            if (p.genero == "M" && p.ingresos in 2000000 .. 3000000) {
                sumaEdad += p.edad
                cant++
            }
        }
        return sumaEdad.toDouble() / cant
    }

    /**
     * ¿Cual es el promedio de ingresos de aquellas personas que tienen una
     * altura inferior a 170 centímetros, y que pesan entre 80 y 90 kilos
     * y no fuman ni usan lentes y cuyo nivel educativo sea igual al que
     * se pasa como parámetro
     */
    fun ejercicio8(nivel: String): Double {
        var sumaIngresos = 0
        var cant = 0
        for (i in 0 ..< personas.tam) {
            val p = personas[i]
            if (p.altura < 170 && p.peso in 80 .. 90 && !p.fuma && !p.tieneLentes &&
                p.nivelEducativo == nivel) {
                sumaIngresos += p.ingresos
                cant++
            }
        }
        return sumaIngresos.toDouble() / cant
    }

    /**
     * Halle el promedio de edad de los hombres obesos.
     * User la función nivelPeso
     */
    fun ejercicio9(): Double {
        var sumaEdad = 0
        var cant = 0
        for (i in 0 ..< personas.tam) {
            val p = personas[i]
            if (p.genero == "M" && nivelPeso(p) == "Obesidad") {
                sumaEdad += p.edad
                cant++
            }
        }
        return sumaEdad.toDouble() / cant
    }

}