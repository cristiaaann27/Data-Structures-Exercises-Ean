package taller07

import ean.colecciones.Lista
import ean.colecciones.listaVacia
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import java.io.FileReader
import java.io.Reader

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
 * Obtiene los datos de un grupo de personas a partir del archivo de
 * personas.csv
 */
fun leerArchivoPersonas(): Lista<Persona> {
    val personas: Lista<Persona> = listaVacia()
    try {
        val datos: Reader = FileReader("./data/Personas.csv")
        val registros = CSVParser(datos, CSVFormat.DEFAULT.withHeader())
        for (registro in registros) {
            val cedula = registro["\uFEFFCédula"].toInt()
            val edad = registro["Edad"].toInt()
            val genero = if (registro["Genero"] == "0") "M" else "F"
            val hijos = registro["No de hijos"].toInt()
            val educacion = when (registro["Nivel Educativo"]) {
                "1" -> "PRIMARIA"
                "2" -> "SECUNDARIA"
                "3" -> "PREGRADO"
                "4" -> "POSTGRADO"
                else -> "NINGUNO"
            }
            val estrato = registro["Estrato Socio"].toInt()
            val ingresos = registro["Ingresos"].toInt()
            val peso = registro["Peso"].toInt()
            val talla = registro["Talla"].toInt()
            val fuma = registro["Fuma"] == "1"
            val lentes = registro["Lentes"] == "1"
            val casa = registro["Casa propia"] == "1"
            val automovil = registro["Automovil"] == "1"
            val persona = Persona(
                cedula,
                edad,
                genero,
                hijos,
                educacion,
                estrato,
                ingresos,
                peso,
                talla,
                fuma,
                lentes,
                casa,
                automovil
            )
            personas.agregarAlFinal(persona)
        }
    }
    catch (ex: Exception) {
        ex.printStackTrace()
    }
    return personas
}