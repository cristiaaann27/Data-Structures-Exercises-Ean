package taller20

import ean.colecciones.*
import ean.pruebas.Persona
import ean.utils.max3
import kotlin.math.pow

/**
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad EAN (Bogotá - Colombia)
 * Departamento de Sistemas
 * Facultad de Ingeniería
 *
 * Proyecto Programación Funcional
 * Autor: Universidad Ean
 * Unidad de Estudios: Estructura de Datos
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
// Método interno para hallar el Indice de Masa Corporal = peso / (altura en metros)ˆ2
fun IMC(persona: Persona): Double {
    val altura = persona.altura / 100.0
    return persona.peso / altura.pow(2)
}

// A partir del IMC permite obtener la categoría del estado del peso, así:
//    IMC                 Nivel de peso
//    Por debajo de 18.5  Bajo peso
//    [18.5, 25.0)        Normal
//    [25.0 – 30)         Sobrepeso
//    30.0 o más          Obesidad
fun nivelDePeso(persona: Persona): String {
    val imc = IMC(persona)
    return when {
        imc < 18.5 -> "Bajo peso"
        imc < 25.0 -> "Normal"
        imc < 30.0 -> "Sobrepeso"
        else -> "Obesidad"
    }
}

/**
 * Ejercicio 1: Cuantos hombres hay en la lista que se recibe como parámetro
 * Genero == "M"
 */
fun ejercicio1(personas: Lista<Persona>): Int {
    return personas.contar { it.genero == "M" }
}

/**
 * Cuál es la cédula de los hombres obesos que nacieron hace más de 55 años
 */
fun ejercicio2(personas: Lista<Persona>): Lista<Int> {
return personas
        .filtrar { nivelDePeso(it) == "Obesidad" && it.edad > 55 }
        .seleccionar { it.cedula }
}

/**
 * De los estratos 2, 3 o 4, cuál tiene la mayor cantidad de mujeres fumadoras sin hijos
 */
fun ejercicio3(personas: Lista<Persona>): Int {
    val estrato = personas.mayorPor { personas.contar{ it.genero == "F" && it.estrato in 2..4 && it.fuma && it.hijos == 0 } }!!.estrato
    return estrato

}

/**
 * Hallar la suma de los ingresos de las personas que tienen casa, usan lentes, no tienen automóvil y tienen el nivel
 * educativo que se pasa como parámetro
 */
fun ejercicio4(personas: Lista<Persona>, nivel: String): Int {
    return personas
        .filtrar { it.nivelEducativo == nivel  && it.tieneCasa && it.tieneLentes && !it.tieneAutomovil }.sumarEnteros { it.ingresos }
}

/**
 * Determine si hay alguna mujer que tiene casa y automovil, pero con un ingreso inferior al que se pasa como parámetro
 */
fun ejercicio5(personas: Lista<Persona>, ingreso: Int): Boolean {
    return personas
        .filtrar { it.genero == "F"  && it.tieneCasa && it.tieneAutomovil && it.ingresos < ingreso }.contar() > 0

}

/**
 * Determine si todas las personas de la lista son hombres con sobrepeso y que nacieron en la última década del siglo XX
 */
fun ejercicio6(personas: Lista<Persona>): Boolean {
    return personas
        .filtrar { it.genero == "M" && nivelDePeso(it) == "Sobrepeso" && it.edad in 23..33 }.contar() == personas.contar()

}

/**
 * Encuentre y retorne las cédulas de aquellas mujeres (genero == "F") con un nivel de estudio
 * PREGRADO que tienen un peso superior al peso de la persona cuya cédula
 * se recibe como parámetro
 */
fun ejercicio7(personas: Lista<Persona>, cedula: Int): Lista<Int> {
    val peso = personas.encontrarPrimero { it.cedula == cedula }!!.peso
    return personas
        .filtrar { it.genero == "F" && it.nivelEducativo == "PREGRADO" && it.peso > peso }.seleccionar { it.cedula }

}

/**
 * Determine si la persona más alta de la lista es hombre de peso normal que usa lentes
 */
fun ejercicio8(personas: Lista<Persona>): Boolean {
    val masAlta = personas.mayorPor { it.altura }!!
    return masAlta.genero == "M" && nivelDePeso(masAlta) == "Normal" && masAlta.tieneLentes
}

/**
 * Determine si el promedio de ingresos de hombres con nivel educativo pregrado
 * es superior al promedio de ingresos de las mujeres con nivel educativo pregrado
 */
fun ejercicio9(personas: Lista<Persona>): Boolean {
    val hombres = personas.filtrar { it.genero == "M" }
    val mujeres = personas.filtrar { it.genero == "F" }
    val promHombres = hombres.filtrar { it.nivelEducativo == "PREGRADO" }.promedioDeEnteros { it.ingresos }
    val promMujeres = mujeres.filtrar { it.nivelEducativo == "PREGRADO" }.promedioDeEnteros { it.ingresos }
    return promHombres > promMujeres
}

/**
 * Esta función recibe una lista de personas y una lista con las cédulas de esas
 * personas, y debe retornar los ingresos de las personas que se encuentran en
 * la lista de cédulas. Esta lista de ingresos debe quedar ordenada ascendentemente
 */
fun ejercicio10(personas: Lista<Persona>, cedulas: Lista<Int>): Lista<Int> {
    return cedulas
        .seleccionar { ced -> personas.encontrarPrimero { it.cedula == ced }!!.ingresos }
        .ordenarCon({ a, b -> a - b })
}

/**
 * Escriba una función que reciba una lista de personas y una lista de cédulas
 * y que determine el porcentaje de hombres de esa lista de cédulas que son de estrato
 * 2 o 3 y que tienen un hijo
 */
fun ejercicio11(personas: Lista<Persona>, cedulas: Lista<Int>): Double {

    val personasCedula = cedulas.seleccionar { ced -> personas.encontrarPrimero { it.cedula == ced }!! }
    return personasCedula.porcentaje { it.genero == "M" && it.estrato in 2..3 && it.hijos == 1 }


}