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

import kotlin.math.pow
import kotlin.math.sqrt

/**
 * Ejercicio 3: La clase Rectángulo
 * Escriba la clase Rectángulo tal como se presenta en el diagrama de clases
 */
class Rectangulo(private val base: Double, private val altura: Double) {
    fun area(): Double {
        return base * altura
    }
    fun diagonal(): Double {
        return sqrt(base.pow(2) + altura.pow(2))
    }
    fun perimetro():Double {
        return (base * 2) + (altura * 2)
    }
}

