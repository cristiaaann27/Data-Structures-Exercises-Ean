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
 * Empresa de transporte.
 */
class EmpresaTransporte() {

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * Camión 1 de la empresa.
     */
    val camion1 = Camion("BAC213", 150, 85.0)

    /**
     * Camión 2 de la empresa.
     */
    val camion2 = Camion("CAP384", 190, 70.0)

    /**
     * Camión 3 de la empresa.
     */
    val camion3 = Camion("GER273", 280, 100.0)

    /**
     * Camión 4 de la empresa.
     */
    val camion4 = Camion("JKV232", 215, 110.0)

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Carga el camión que posee la matricula dada con la carga dada por parámetro.
     * Retorna true si pudo realizar la carga, false en caso contrario.
     */
    fun cargarCamion(matriculaCamion: String, pesoCargar: Int): Boolean {
        val camionACargar = when (matriculaCamion) {
            camion1.matricula -> camion1
            camion2.matricula -> camion2
            camion3.matricula -> camion3
            camion4.matricula -> camion4
            else -> return false // Matrícula no válida
        }
        if (pesoCargar <= camionACargar.capacidad) {
            // Realizar la carga
            camionACargar.cargaActual = pesoCargar
            return true
        } else {
            return false
        }

    }

    /**
     * Descarga el camión que posee la matrícula dada por parámetro.
     */
    fun descargarCamion(matriculaCamion: String): Unit {
        val camionADescargar = when (matriculaCamion) {
            camion1.matricula -> camion1
            camion2.matricula -> camion2
            camion3.matricula -> camion3
            camion4.matricula -> camion4
            else -> return // Matrícula no válida
        }
        camionADescargar.descargar()
    }

    /**
     * Retorna la capacidad total de carga de todos los camiones. Es decir,
     * la suma de las capacidades de los 4 camiones.
     */
    fun darCapacidadTotal(): Int {
        return this.camion1.capacidad + this.camion2.capacidad + this.camion3.capacidad + this.camion4.capacidad
    }

    /**
     * Retorna la carga total de los camiones.
     */
    fun darCargaTotal(): Int {
        return this.camion1.cargaActual + this.camion2.cargaActual + this.camion3.cargaActual + this.camion4.cargaActual
    }

    /**
     * Retorna la carga promedio por camión.
     * O sea, la carga total dividida por el número de camiones.
     */
    fun calcularCargaPromedio(): Double {
        return this.darCargaTotal() / 4.0
    }

    /**
     * Retorna el mejor camión para transportar la carga especificada.
     * El mejor camión es aquel que tiene la capacidad para cargar la
     * carga dada y además tiene un menor consumo de gasolina.
     * Si ningún camión es apto para la carga retorna null.
     */
    fun darMejorCamion(pesoCarga: Int): Camion? {
        var mejorCamion: Camion? = null

        for (camion in listOf(camion1, camion2, camion3, camion4)) {
            if (camion.capacidad >= pesoCarga) {
                if (mejorCamion == null || camion.consumo < mejorCamion.consumo) {
                    mejorCamion = camion
                }
            }
        }

        return mejorCamion
    }

    /**
     * Retorna la matrícula de aquel camión de los cuatro camiones de la
     * empresa de transporte que tiene la carga actual más grande.
     */
    fun matriculaCamionMasCargado(): String {
        return when{
            (camion1.cargaActual > camion2.cargaActual) && (camion1.cargaActual > camion3.cargaActual) && (camion1.cargaActual > camion4.cargaActual) -> camion1.matricula
            (camion2.cargaActual > camion1.cargaActual) && (camion2.cargaActual > camion3.cargaActual) && (camion2.cargaActual > camion4.cargaActual) -> camion2.matricula
            (camion3.cargaActual > camion1.cargaActual) && (camion3.cargaActual > camion2.cargaActual) && (camion3.cargaActual > camion4.cargaActual) -> camion3.matricula
            (camion4.cargaActual > camion1.cargaActual) && (camion4.cargaActual > camion2.cargaActual) && (camion4.cargaActual > camion3.cargaActual) -> camion4.matricula
            else -> "No hay camiones cargados"
        }
    }

    /**
     * Obtiene y retorna cuántos camiones están descargados.
     */
    fun cantidadCamionesDescargados(): Int {
        var cantidad = 0
        if (camion1.cargaActual == 0) {
            cantidad++
        }
        if (camion2.cargaActual == 0) {
            cantidad++
        }
        if (camion3.cargaActual == 0) {
            cantidad++
        }
        if (camion4.cargaActual == 0) {
            cantidad++
        }
        return cantidad
    }
}