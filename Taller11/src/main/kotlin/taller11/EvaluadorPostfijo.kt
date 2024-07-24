package taller11

import ean.colecciones.*

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad EAN (Bogotá - Colombia)
 * Departamento de Sistemas
 * Facultad de Ingeniería
 * <p>
 * Proyecto Taller Evaluador Postfijo - Utilidad de las Pilas
 * Autor: Universidad EAN
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

/**
 * Objeto que permite convertir una expresión infija normal a una
 * expresión en notaciónpostfija. Utiliza pilas para realizar la conversión.
 */
object EvaluadorPostfijo {

    //-------------------------------------
    // Métodos
    //-------------------------------------

    /**
     * Verifica que la expresión tiene los símbolos de agrupación bien balanceados
     * @return true si la expresión está balanceados
     */
    fun estaBalanceada(expresion: Lista<String>): Boolean {
        val pilaSimbolos: Pila<String> = pilaVacia()

        for (i in 0..expresion.tam - 1) {
            if (expresion[i] == "(" || expresion[i] == "[" || expresion[i] == "{") {
                pilaSimbolos.apilar(expresion[i])
            } else if (expresion[i] == ")" || expresion[i] == "]" || expresion[i] == "}") {
                if (pilaSimbolos.vacia()) {
                    return false
                } else {
                    val simboloDesapilado = pilaSimbolos.desapilar()
                    if (simboloDesapilado == "(" && expresion[i] != ")") {
                        return false
                    } else if (simboloDesapilado == "[" && expresion[i] != "]") {
                        return false
                    } else if (simboloDesapilado == "{" && expresion[i] != "}") {
                        return false
                    }
                }
            }
        }
        return pilaSimbolos.vacia()
    }


    /**
     * Transforma la expresión, cambiando los simbolos de agrupación [] y {} por ()
     */
    fun reemplazarDelimitadoresPorParéntesis(expresion: Lista<String>): Unit {
        for (i in 0..expresion.tam - 1) {
            if (expresion[i] == "[" || expresion[i] == "{") {
                expresion[i] = "("
            } else if (expresion[i] == "]" || expresion[i] == "}") {
                expresion[i] = ")"
            }
        }
    }

    /**
     * Realiza la conversión de la notación infija a postfija
     * @return la expresión convertida a postfija
     */
    fun convertirAPostfijo(expresion: Lista<String>): Lista<String> {
        val pila: Pila<String> = pilaVacia()
        val lista = listaVacia<String>()

        for (i in 0..expresion.tam - 1) {
            if (expresion[i] == "+" || expresion[i] == "-" || expresion[i] == "*" || expresion[i] == "/" || expresion[i] == "%") {
                pila.apilar(expresion[i])
            } else if (expresion[i] == ")") {
                lista.agregarAlFinal(pila.desapilar())
            } else if (expresion[i] != "(") {
                lista.agregarAlFinal(expresion[i])
            }

        }
        return lista
    }


    /**
     * Realiza la evaluación de la expresión postfija almacenada en la lista
     * llamada "expresión". Realiza las operaciones de acuerdo al algoritmo
     * presentado.
     */
    fun evaluarExpresiónPostfija(expresion: Lista<String>): Int {
        val pila: Pila<Int> = pilaVacia()

        recorrer(expresion){
            if (it == "+" || it == "-" || it == "*" || it == "/" || it == "%") {
                val operando2 = pila.desapilar()
                val operando1 = pila.desapilar()
                when (it) {
                    "+" -> pila.apilar(operando1 + operando2)
                    "-" -> pila.apilar(operando1 - operando2)
                    "*" -> pila.apilar(operando1 * operando2)
                    "/" -> pila.apilar(operando1 / operando2)
                    "%" -> pila.apilar(operando1 % operando2)
                }
            } else {
                pila.apilar(it.toInt())
            }
        }

        return pila.tope()
    }
}
