import kotlin.math.atan2
import kotlin.math.sqrt

// Taller 02 de Estructura de Datos

/**
 * Un número complejo consta de una parte real
 * y una parte imaginaria.
 */

class NumeroComplejo(var parteReal: Double, var parteImaginaria: Double) {
    //----------------------------------------------
    // Constructor: este constructor secundario
    // inicializa la parte real en el dato de entrada
    // y la parte imaginaria en cero.
    //--------------------------------------------
    constructor(numero: Double) : this(numero, 0.0) {

    }

    //-------------------------------------------------
    // Métodos
    //-------------------------------------------------

    /**
     * Obtiene el valor absoluto, módulo o magnitud del número complejo.
     */
    fun abs(): Double {
        return sqrt((this.parteReal*this.parteReal)+(this.parteImaginaria*this.parteImaginaria))
    }

    /**
     * Obtiene el argumento o fase de un número complejo.
     */
    fun arg(): Double {
        return atan2(this.parteImaginaria,this.parteReal)
    }

    /**
     * Obtiene el conjugado del número complejo actual
     */
    fun conjugado(): NumeroComplejo {
        return NumeroComplejo(this.parteReal,-(this.parteImaginaria))
    }

    /**
     *  retorna el número complejo inverso o recíproco
     */
    fun inverso(): NumeroComplejo {
        val primeraExpresion = this.parteReal /((this.parteReal*this.parteReal)+(this.parteImaginaria*this.parteImaginaria))
        val segundaExpresion = -(this.parteImaginaria) /((this.parteReal*this.parteReal)+(this.parteImaginaria*this.parteImaginaria))
        return NumeroComplejo(primeraExpresion,segundaExpresion)
    }

    /**
     * Permite saber si el número complejo es igual al número complejo
     * que se recibe como parámetro. Retorna true si las partes reales
     * son iguales y las partes imaginarias son iguales
     */
    fun igual(comp: NumeroComplejo): Boolean {
        return (this.parteReal == comp.parteReal && this.parteImaginaria == comp.parteImaginaria)
    }

    override fun toString(): String {
        return String.format("%.2f + %.2fi", parteReal, parteImaginaria)
    }
}

//--------------------------------------------------------------------------------------------

/**
 * Encuentra la suma entre dos números complejos
 */
fun sumarComplejos(c1: NumeroComplejo, c2: NumeroComplejo): NumeroComplejo {
    val primeraExpresion = (c1.parteReal + c2.parteReal)
    val segundaExpresion = (c1.parteImaginaria + c2.parteImaginaria)
    return NumeroComplejo(primeraExpresion,segundaExpresion)
}

/**
 * Encuentra y retorna la resta entre dos números complejos
 */
fun restarComplejos(c1: NumeroComplejo, c2: NumeroComplejo): NumeroComplejo {
    val primeraExpresion = (c1.parteReal - c2.parteReal)
    val segundaExpresion = (c1.parteImaginaria - c2.parteImaginaria)
    return NumeroComplejo(primeraExpresion,segundaExpresion)
}

/**
 * Encuentra y retorna la multiplicación entre un número real y
 * un número complejo
 */
fun prodEscalarComplejo(r: Double, c: NumeroComplejo): NumeroComplejo {
    val primeraExpresion = (r * c.parteReal)
    val segundaExpresion = (r * c.parteImaginaria)
    return NumeroComplejo(primeraExpresion,segundaExpresion)
}

/**
 * Encuentra y retorna la multiplicación de los números complejos
 * que se reciben como parámetros.
 */
fun multiplicarComplejos(c1: NumeroComplejo, c2: NumeroComplejo): NumeroComplejo {
    val primeraExpresion = ((c1.parteReal * c2.parteReal) - (c1.parteImaginaria*c2.parteImaginaria))
    val segundaExpresion = ((c1.parteReal * c2.parteImaginaria) + (c1.parteImaginaria * c2.parteReal))
    return NumeroComplejo(primeraExpresion,segundaExpresion)
}

/**
 * Encuentre y retorna la división entre dos números complejos
 */
fun dividirComplejos(c1: NumeroComplejo, c2: NumeroComplejo): NumeroComplejo {
    val primeraExpresion = (((c1.parteReal * c2.parteReal) + (c1.parteImaginaria*c2.parteImaginaria)) / ((c2.parteReal*c2.parteReal)+(c2.parteImaginaria*c2.parteImaginaria)))
    val segundaExpresion = (((c1.parteImaginaria * c2.parteReal) - (c1.parteReal*c2.parteImaginaria)) / ((c2.parteReal*c2.parteReal)+(c2.parteImaginaria*c2.parteImaginaria)))
    return NumeroComplejo(primeraExpresion,segundaExpresion)
}

