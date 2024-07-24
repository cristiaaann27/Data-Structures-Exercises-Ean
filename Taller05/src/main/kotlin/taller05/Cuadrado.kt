/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad EAN (Bogotá - Colombia)
 * Departamento de Tecnología - Facultad de Ingeniería
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Ejercicio: Geometría
 * Autor: Universidad EAN
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package taller05

import kotlin.math.sqrt

/**
 * Ejercicio 2: La clase Cuadrado
 * Escriba la clase Cuadrado tal como se presenta en el diagrama de clases
 */
class Cuadrado(private val lado: Double) {
    fun area(): Double {
        return lado * lado
    }
    fun diagonal(): Double {
        return lado * sqrt(2.0)
    }
    fun perimetro(): Double {
        return lado * 4
    }
}

