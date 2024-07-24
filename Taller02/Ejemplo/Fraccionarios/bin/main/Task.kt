import kotlin.math.abs
import kotlin.math.min

/**
 * Clase: Fraccionario
 * Representa un número fraccionario con un numerador y
 * un denominador, y las diversas operaciones que ocurren
 * sobre estos.
 */

class Fraccionario() {
    //--------------------------------------------------
    // Atributos
    //--------------------------------------------------
    private var numerador: Int = 0
    private var denominador: Int = 1   // Denominador

    //--------------------------------------------------
    // Constructor
    //--------------------------------------------------
    constructor(numerador: Int, denominador: Int): this() {
        // PreRequisito: El denominador debe ser un número po
        require(denominador > 0)



        // Inicializar los atributos del fraccionario
        this.numerador = numerador
        this.denominador = denominador

        // Simplifique el fraccionario
        this.simplificar()
    }

    //--------------------------------------------------
    // Métodos
    //--------------------------------------------------

    // Obtener el numerador del fraccionario
    fun darNumerador(): Int {
        return numerador
    }

    // Obtener el denominador del fraccionario
    fun darDenominador() = denominador

    /**
     * Simplifica el fraccionario a través de encontrar
     * el MCD entre el numerador y el denominador y
     * dividiendo ambos atributos entre ese MCD.
     */
    private fun simplificar() {
        // Encuentra el máximo común divisor
        var m = 1
        for(i in 1 .. min(abs(numerador),denominador)){
            if(numerador % i == 0 && denominador % i == 0){
                m = i
            }
        }
        // ---------------------------
        // Ahora, para simplificar, dividimos el numerador
        // y el denominador entre el maximo común divisor
        numerador /= m
        denominador /= m
    }

    /**
     * Cambia el numerador y el denominador del fraccionario.
     * Precondición: el denominador debe ser positivo y diferente
     * de cero.
     * OJO: el fraccionario debe ser simplificado cuando se realice
     * el cambio
     */
    fun cambiar(numerador: Int, denominador: Int) {
        require(denominador > 0)
        this.numerador = numerador
        this.denominador = denominador
        simplificar()
    }

    /**
     * Cambia el numerador y el denominador del fraccionario por
     * el numerador y denominador del fraccionario que se recibe
     * como parámetro
     */
    fun asignar(f: Fraccionario) {
        this.numerador = f.numerador
        this.denominador = f.denominador
    }

    /**
     * Permite saber si el fraccionario this es igual al fraccionario
     * f que se pasa como parámetro. Retorna true si son iguales y
     * false si no lo son.
     */
    fun igual(f: Fraccionario): Boolean {
        return (this.numerador == f.numerador && this.denominador == f.denominador)
    }

    /**
     * Las fracciones propias son aquellas donde el valor absoluto del numerador es menor
     * que el denominador.
     * Este método retorna true si la fracción es propia y false si no lo es.
     */
    fun propia(): Boolean {
        return (abs(this.numerador) < this.denominador)
    }

    /**
     * Las fracciones impropias son aquellas donde el valor absoluto del numerador es mayor
     * que el denominador.
     * Este método retorna true si la fracción es impropia y false si no lo es
     */
    fun impropia(): Boolean {
        return (abs(this.numerador) > this.denominador)
    }

    /**
     * Las fracciones unidad son todas las fracciones que tienen el numerador igual al denominador.
     * Este método retorna true si la fracción es unidad o false si no lo es.
     */
    fun unidad(): Boolean {
        return (abs(this.numerador) == this.denominador)
    }

    /**
     * Una fracción mixta o número mixto es la representación de una fracción impropia, en forma
     * de número entero y fracción propia. Por ejemplo: 40/15 en numeros mixtos es 2, 2/3
     */
    fun toMixto(): Pair<Int, Fraccionario> {
        val entero = this.numerador/this.denominador
        val numeradorFraccion = this.numerador% this.denominador
        return Pair(entero, Fraccionario(numeradorFraccion,this.denominador))
    }

    /**
     * Obtiene la parte entera del fraccionario.
     */
    fun toInt(): Int {
        return (numerador/denominador)
    }

    /**
     * Convierte el fraccionario a double, simplemente dividiendo el
     * numerador entre denominador
     */
    fun toDouble(): Double {
        return (numerador.toDouble())/(denominador.toDouble())
    }

    /**
     * Permite saber si el fraccionario this es menor que el fraccionario
     * que se recibe como parámetro. Retorna true si es menor o false
     * si no es así
     */
    fun menorQue(f: Fraccionario) : Boolean {
        return (this.toDouble() < f.toDouble())
    }

    /**
     * Permite saber si el fraccionario es mayor que el fraccionario
     * que se recibe como parámetro. Retorna true si es mayor o false
     * si no es así
     */
    fun mayorQue(f: Fraccionario): Boolean {
        return (this.toDouble() > f.toDouble())
    }

    /**
     * Obtiene el valor absoluto
     */
    fun abs(): Fraccionario {
        return Fraccionario(abs(this.numerador),abs(this.denominador))
    }

    /**
     * Obtiene el invertido del fraccionario
     */
    fun invertir(): Fraccionario {
        val nuevoNumerador = if (this.numerador < 0){
            -abs(this.denominador)
        }else{
            abs(this.denominador)
        }
        return Fraccionario(nuevoNumerador,abs(this.numerador))
    }

    /**
     * Obtiene la representación como cadena de un fraccionario
     */
    override fun toString(): String {
        return "$numerador / $denominador"
    }

}

/**
 * Obtiene la suma de los dos fraccionarios que se reciben
 * como parámetros o datos de entrada
 */
fun sumarFraccionarios(f1: Fraccionario, f2: Fraccionario): Fraccionario {
    val numerador = (f1.darNumerador() * f2.darDenominador()) + (f1.darDenominador() * f2.darNumerador())
    val denominador = (f1.darDenominador() * f2.darDenominador())
    return Fraccionario(numerador,denominador)


}

/**
 * Obtiene la resta de las dos fraccionarios que se
 * reciben como parámetros o datos de entrada.
 */
fun restarFraccionarios(f1: Fraccionario, f2: Fraccionario): Fraccionario {
    val numerador = (f1.darNumerador() * f2.darDenominador()) - (f1.darDenominador() * f2.darNumerador())
    val denominador = (f1.darDenominador() * f2.darDenominador())
    return Fraccionario(numerador,denominador)
}

/**
 * Obtiene la multiplicación de los dos fraccionarios que
 * se reciben como parámetros o datos de entrada de la función
 */
fun multiplicarFraccionarios(f1: Fraccionario, f2: Fraccionario): Fraccionario {
    val numerador = (f1.darNumerador() * f2.darNumerador())
    val denominador = (f1.darDenominador() * f2.darDenominador())
    return Fraccionario(numerador,denominador)
}

/**
 * Obtiene la división de los dos fraccionarios.
 * Pre: el numerador del segundo fraccionario no debe ser cero
 * OJO: el numerador es el único negativo
 */
fun dividirFraccionarios(f1: Fraccionario, f2: Fraccionario): Fraccionario {
    require(f2.darNumerador() != 0)

    val numerador = f1.darNumerador() * f2.darDenominador()
    val denominador = f1.darDenominador() * f2.darNumerador()

    val resultadoNumerador = if (numerador * denominador >= 0) {
        abs(numerador)
    } else {
        -abs(numerador)
    }

    val resultadoDenominador = abs(denominador)

    return Fraccionario(resultadoNumerador, resultadoDenominador)
}
/**
 * Retorna el fraccionario más grande entre f1 y f2
 */
fun mayor(f1: Fraccionario, f2: Fraccionario): Fraccionario {
    val max: Fraccionario = if (f1.toDouble() > f2.toDouble()) f1 else f2
    return max
}

/**
 * Retorna el fraccionario más pequeño entre f1 y f2
 */
fun menor(f1: Fraccionario, f2: Fraccionario): Fraccionario {
    val min: Fraccionario = if (f1.toDouble() < f2.toDouble()) f1 else f2
    return min
}