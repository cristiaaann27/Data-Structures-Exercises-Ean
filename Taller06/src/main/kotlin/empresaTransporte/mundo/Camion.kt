/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 * Programa de Ingeniería de Sistemas
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Etructura de Datos - Taller 06
 * Ejercicio: Empresa de Transporte
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package empresaTransporte.mundo


/**
 * Camión de la empresa de transporte.
 */
class Camion(
    val matricula: String, // Matricula del camión.
    var capacidad: Int,    // Capacidad del camión (en Kg).
    val consumo: Double) {    // Consumo de gasolina del camión (en galones de gasolina/kilómetro).

    // -----------------------------------------------------------------
    // Atributos Adicionales
    // -----------------------------------------------------------------

    /**
     * Carga actual del camión (en Kg).
     */
    var cargaActual: Int = 0

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Carga el camión con la carga dada por parámetro.
     * Retorna true si se logra cargar el camión (el pesoCarga es inferior
     * a la capacidad). Si es así, a la capacidad le asignamos el pesoCarga
     * Se retorna false en caso contrario.
     */
    fun cargar(pesoCarga: Int): Boolean {
        if (pesoCarga <= capacidad) {
            capacidad = pesoCarga
            return true
        }
        return false

    }

    /**
     * Descarga el camión. Es decir, la carga actual del camión queda en cero.
     */
    fun descargar(): Unit {
        cargaActual = 0

    }
}