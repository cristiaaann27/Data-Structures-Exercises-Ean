package taller11

import ean.colecciones.Lista
import ean.utils.Utils
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class EvaluadorPostfijoTest {
    //-------------------------------------
    // Métodos
    //-------------------------------------
    @Test
    fun probarBalanceador() {
        // Ejemplo de expresión bien balanceada
        assertTrue(
            chequearBalanceo("[a {b / (c-d) + e/(f+g)}-h]")
        )

        // Ejemplo de expresión mal balanceada
        assertFalse(
            chequearBalanceo("a {b [c - d ] e] ) f")
        )

        // Ejemplo de expresión mal balanceada
        assertFalse(
            chequearBalanceo("{a ( b * c ) / [d + e] / f )- g}")
        )

        assertTrue(
            chequearBalanceo("()({[()]-[[]]}){}{0}")
        )

        assertFalse(
            chequearBalanceo("{()({[()]-[[]]})]{}{0}]")
        )
        println("Prueba superada!")
    }

    @Test
    fun testReplaceDelimiters() {
        var first = reemplazarDelimitadores("x [ {a ( b * c ) / [d + e] / f }- g]")
        var secnd = dividirExpresion("x ( (a ( b * c ) / (d + e) / f )- g)")
        assertTrue(first == secnd)

        first = reemplazarDelimitadores("[ { ] { ( } f [ 2 ] )")
        secnd = dividirExpresion("( ( ) ( ( ) f ( 2 ) )")
        assertEquals(first, secnd)
        println("Prueba superada! 👍")
    }

    @Test
    fun probarConvertirInfijoPostfijo() {
        // 1. Primera prueba
        var postfijo: String = convertir("((40 + 30) - 25)")
        assertEquals("40 30 + 25 -", postfijo)
        println("Prueba 1 superada!")

        // 2. Prueba
        postfijo = convertir("(a + (b * c))")
        assertEquals("a b c * +", postfijo)
        println("Prueba 2 superada!")

        // 3. Prueba
        postfijo = convertir("((a - b) * c)")
        assertEquals("a b - c *", postfijo)
        println("Prueba 3 superada!")

        // 4. Prueba
        postfijo = convertir("((a % b) * (c % d))")
        assertEquals("a b % c d % *", postfijo)
        println("Prueba 4 superada!")

        // 5. Prueba
        postfijo = convertir("(a / (b * (c + (d - 5))))")
        assertEquals("a b c d 5 - + * /", postfijo)
        println("Prueba 5 superada!")

        // 6. Prueba
        postfijo = convertir("((a / (b - c)) * d)")
        assertEquals("a b c - / d *", postfijo)
        println("Prueba 6 superada!")

        // 7. Prueba
        postfijo = convertir("((a - ((b / ((c - d) * e)) + f )) % g)")
        assertEquals("a b c d - e * / f + - g %", postfijo)
        println("Prueba 7 superada!")

        // 8. Prueba
        postfijo = convertir("(((a - b) * c) / (((d * e) / (f % g)) + h))")
        assertEquals("a b - c * d e * f g % / h + /", postfijo)
        println("Prueba 8 superada!")

        // 9. Prueba
        postfijo = convertir("(a * (((b + c) * d) + e))")
        assertEquals("a b c + d * e + *", postfijo)
        println("Prueba 9 superada!")
    }

    @Test
    fun pruebaPostFijo() {
        var expresion = dividirExpresion("40 30 + 25 -")
        var resultado = EvaluadorPostfijo.evaluarExpresiónPostfija(expresion)
        assertEquals(45, resultado)
        println("Primera prueba superada 👍")

        expresion = dividirExpresion("27 8 2 - / 3 *")
        assertEquals(12, EvaluadorPostfijo.evaluarExpresiónPostfija(expresion))
        println("Segunda prueba superada 👍")

        expresion = dividirExpresion("30 12 % 18 15 % -")
        assertEquals(3, EvaluadorPostfijo.evaluarExpresiónPostfija(expresion))
        println("Tercera prueba superada 👍")

        expresion = dividirExpresion("5 9 + 2 * 6 5 * +")
        assertEquals(58, EvaluadorPostfijo.evaluarExpresiónPostfija(expresion))
        println("Cuarta prueba superada 👍")

        expresion = dividirExpresion("4 2 * 12 3 / + 15 -")
        assertEquals(-3, EvaluadorPostfijo.evaluarExpresiónPostfija(expresion))
        println("Quinta prueba superada 👍")

        expresion = dividirExpresion("14 8 - 5 * 7 8 * 11 6 % / 21 + -")
        assertEquals(-2, EvaluadorPostfijo.evaluarExpresiónPostfija(expresion))
        println("Sexta prueba superada 👍")
    }

    @Test
    fun pruebaFinal() {
        var aEvaluar = dividirExpresion("({[3 * 3] / (4 - 2)} + {5 * 6})")
        if (EvaluadorPostfijo.estaBalanceada(aEvaluar)) {
            EvaluadorPostfijo.reemplazarDelimitadoresPorParéntesis(aEvaluar)
            val expresiónFinal = EvaluadorPostfijo.convertirAPostfijo(aEvaluar)
            val valorFinal = EvaluadorPostfijo.evaluarExpresiónPostfija(expresiónFinal)
            assertEquals(34, valorFinal)
            println("Primera Prueba superada 👍")
        }
        else {
            fail("Algo malo ocurrió en la primera prueba")
        }

        aEvaluar = dividirExpresion("([2 + 18] % {15 - 8})")
        if (EvaluadorPostfijo.estaBalanceada(aEvaluar)) {
            EvaluadorPostfijo.reemplazarDelimitadoresPorParéntesis(aEvaluar)
            val expresiónFinal = EvaluadorPostfijo.convertirAPostfijo(aEvaluar)
            val valorFinal = EvaluadorPostfijo.evaluarExpresiónPostfija(expresiónFinal)
            assertEquals(6, valorFinal)
            println("Segunda Prueba superada 👍")
        }
        else {
            fail("Algo malo ocurrió en la segunda prueba")
        }

    }
}

//-----------------------------------------------------------------------------------------------------------

/**
 * Función de utilidad para realizar la conversión
 */

fun dividirExpresion(expresión: String): Lista<String> = Utils.parse(expresión)

fun chequearBalanceo(expresión: String): Boolean {
    val lista = dividirExpresion(expresión)
    println(lista)
    return EvaluadorPostfijo.estaBalanceada(lista)
}

fun reemplazarDelimitadores(expresión: String): Lista<String> {
    val expr = dividirExpresion(expresión)
    EvaluadorPostfijo.reemplazarDelimitadoresPorParéntesis(expr)
    return expr
}

fun convertir(expresión: String): String {
    val anExpression = Utils.parse(expresión)
    return Utils.join(EvaluadorPostfijo.convertirAPostfijo(anExpression))
}