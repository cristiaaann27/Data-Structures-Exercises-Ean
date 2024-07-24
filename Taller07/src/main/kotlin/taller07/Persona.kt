package taller07

import kotlin.math.pow

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
 * Información que mantenemos de una persona
 */
class Persona (
    val cedula: Int,
    val edad: Int,
    val genero: String,  // "M" o "F"
    val hijos: Int,
    val nivelEducativo: String,
    val estrato: Int,
    val ingresos: Int,
    val peso: Int,
    val altura: Int, // en centímetros
    val fuma: Boolean,
    val tieneLentes: Boolean,
    val tieneCasa: Boolean,
    val tieneAutomovil: Boolean
){
    /**
     * Obtiene el índice de masa corporal de una persona
     * = peso / (altura en metros ^ 2)
     */
    fun IMC(): Double {
        val alturaMetros = altura / 100.0
        return peso / alturaMetros.pow(2)
    }
}

/**
 * El nivel de peso de una persona depende del imc de esa persona
 * de acuerdo a la siguiente:
 * nivel = "Bajo peso" cuando el imc está por debajo de 18.5
 * nivel = "Normal" cuando el imc está por debajo de 25.0
 * nivel = "Sobrepeso" cuando el imc está por debajo de 30.0
 * nivel = "Obesidad" cuando el imc es 30.0 o superior
 * Escriba una función que halle el nivel de peso de una persona
 * USE el método IMC HECHA ANTERIORMENTE
 */
fun nivelPeso(p: Persona): String {
    return when {
        p.IMC() < 18.5 -> "Bajo peso"
        p.IMC() < 25.0 -> "Normal"
        p.IMC() < 30.0 -> "Sobrepeso"
        else -> "Obesidad"
    }
}