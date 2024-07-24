package tallerrecursion

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad EAN (Bogotá - Colombia)
 * Departamento de Sistemas
 * Faculta de Ingeniería
 *
 * Taller Funciones Recursivas
 * Fecha: 4 de octubre de 2023
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

import ean.colecciones.Lista
import ean.colecciones.crearLista
import ean.colecciones.listaVacia
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class TallerRecursionTest {
    @Test
    fun pruebaFactorial() {
        assertEquals(120, factorial(5))
        assertEquals(3628800, factorial(10))
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaFibonacci() {
        assertEquals(89, fibonacci(11))
        assertEquals(75_025, fibonacci(25))
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaElevar() {
        assertEquals(1024, elevar(2, 10))
        assertEquals(1_000_000, elevar(10, 6))
        assertEquals(2_097_152, elevar(8, 7))
        println("Prueba superada 👍")
    }

    // Probar el triángulo de Pascal
    @Test
    fun pruebaPascal() {
        assertEquals(3, pascal(3,2))
        assertEquals(6, pascal(4,3))
        assertEquals(120, pascal(10, 8))
        assertEquals(5005, pascal(15, 7))
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaSumatoria() {
        assertEquals(55, sumatoria(10))
        assertEquals(5050, sumatoria(100))
        assertEquals(500500, sumatoria(1000))
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaSumaCuadrados() {
        assertEquals(1240, sumaCuadrados(15))
        assertEquals(9455, sumaCuadrados(30))
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaSerie() {
        assertEquals(3.4361, serie(1000), 0.0001)
        assertEquals(4.5869, serie(10_000), 0.0001)
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaSumatoria2() {
        assertEquals(6.8136, sumatoria2(1_000), 1e-4)
        assertEquals(9.1157, sumatoria2(10_000), 1e-4)
        println("Prueba superada!")
    }

    @Test
    fun pruebaContarDigitos() {
        assertEquals(7, contarDigitos(1_215_677))
        assertEquals(1, contarDigitos(1))
        assertEquals(9, contarDigitos(865_711_981))
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaNumeroDeCeros() {
        assertEquals(2, numeroDeCeros(2020))
        assertEquals(0, numeroDeCeros(19_278))
        assertEquals(6, numeroDeCeros(1_000_000))
        assertEquals(5, numeroDeCeros(10_100_001))
        assertEquals(1, numeroDeCeros(0))
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaSumarDigitos() {
        assertEquals(15, sumarDigitos(5712))
        assertEquals(10, sumarDigitos(1234))
        println("Prueba superada 👍")
    }

    @Test
    fun probarCantidadDigitosPares() {
        assertEquals(4, cantidadDigitosPares(816_425))
        assertEquals(0, cantidadDigitosPares(73_911))
        assertEquals(6, cantidadDigitosPares(4_816_420))
        assertEquals(7, cantidadDigitosPares(214_816_420))
        println("Prueba superada 👍")
    }

    @Test
    fun probarEsNumeroBinario() {
        assertTrue(esNumeroBinario(11))
        assertTrue(esNumeroBinario(1_000_110))
        assertFalse(esNumeroBinario(410))
        assertFalse(esNumeroBinario(11_901))
        println("Prueba superada 👍")
    }

    @Test
    fun probarPoseeDigito() {
        assertTrue(poseeDigito(67_810, 7))
        assertTrue(poseeDigito(8_576, 8))
        assertFalse(poseeDigito(98_175, 4))
        assertFalse(poseeDigito(31_578_096, 2))
        println("Prueba superada 👍")
    }

    @Test
    fun probarDigitoMasGrande() {
        assertEquals(9, digitoMasGrande(17_928))
        assertEquals(1, digitoMasGrande(1_000))
        assertEquals(6, digitoMasGrande(26_403))
        assertEquals(4, digitoMasGrande(31_412))
    }

    @Test
    fun pruebaMCD() {
        assertEquals(6, mcd(270, 192))
        assertEquals(8, mcd(72, 16))
        assertEquals(16, mcd(848, 656))
        println("Prueba superada 👍")
    }

    @Test
    fun probarImprimirLista() {
        imprimirLista(crearLista(3, 1, 8, 6, 4, 2))
    }

    @Test
    fun probarDigitos() {
        assertEquals(crearLista(3, 4, 2, 1, 9), digitos(34_219))
        assertEquals(crearLista(8), digitos(8))
        assertEquals(crearLista(2, 0, 0, 1, 3, 6), digitos(200_136))
        assertEquals(crearLista(1, 2, 4, 1, 9, 8, 7, 7), digitos(12_419_877))
        println("Prueba superada 👍")
    }

    @Test
    fun probarconvertirDecimalBinario() {
        assertEquals(crearLista(1, 1, 1, 1), convertirDecimalBinario(15))
        assertEquals(crearLista(1, 0, 0, 1, 1, 0, 1), convertirDecimalBinario(77))
        assertEquals(crearLista(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), convertirDecimalBinario(1024))
        assertEquals(crearLista(1, 1, 0, 1, 1, 0, 1, 0, 0, 1), convertirDecimalBinario(873))
        assertEquals(crearLista(1, 0, 0, 0), convertirDecimalBinario(8))
        println("Prueba superada 👍")
    }

    @Test
    fun probarContarVerbos() {
        val pals = crearLista("comer", "ando", "andar", "partir", "suma", "sumar", "reir", "ir", "dono", "poder")
        assertEquals(7, contarVerbos(pals))
        assertEquals(0, contarVerbos(crearLista("nada", "come", "papa")))
        println("Prueba superada 👍")
    }

    @Test
    fun probarSumarParesLista() {
        assertEquals(30, sumarParesLista(crearLista(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)))
        assertEquals(0, sumarParesLista(crearLista(11, 21, 31, 41, 51, 61, 71)))
        assertEquals(34, sumarParesLista(crearLista(4, 10, 12, 11, 15, 8)))
        println("Prueba superada 👍")
    }

    @Test
    fun probarbuscarElementoEnUnaLista() {
        assertEquals(2, buscarElementoEnUnaLista(crearLista(40, 12, 18, 57, 1, 198, 43, 33, 12), 18))
        assertEquals(6, buscarElementoEnUnaLista(crearLista(40, 12, 18, 57, 1, 198, 43, 33, 12), 43))
        assertEquals(-1, buscarElementoEnUnaLista(crearLista(40, 12, 18, 57, 1, 198, 43, 33, 12), 6))
        println("Prueba superada 👍")
    }

    @Test
    fun probarConvertirListaDigitosNumero() {
        assertEquals(45_186, convertirListaDigitosNumero(crearLista(4, 5, 1, 8, 6)))
        assertEquals(8, convertirListaDigitosNumero(crearLista(8)))
        assertEquals(371_811, convertirListaDigitosNumero(crearLista(3, 7, 1, 8, 1, 1)))
        println("Prueba superada ☺️")
    }

    @Test
    fun probarExisteElemento() {
        assertTrue(existeElemento(crearLista("hola", "casa", "tierra", "rojo", "azul"), "casa"))
        assertFalse(existeElemento(crearLista("hola", "casa", "tierra", "rojo", "azul"), "perro"))
        assertTrue(existeElemento(crearLista(89, 11, -31, -289, 471, 264, 1000), 471))
        assertFalse(existeElemento(crearLista(89, 11, -31, -289, 471, 264, 1000), 2000))
        println("Prueba superada ☺️")
    }

    @Test
    fun probarInvertirLista() {
        val lst: Lista<Char> = crearLista('p', 'a', 'r', 'c', 'o', 's')
        val inv: Lista<Char> = crearLista('s', 'o', 'c', 'r', 'a', 'p')
        assertEquals(inv, invertirLista(lst))
        println("Prueba superada ☺️")
    }

    @Test
    fun probarMayorDeUnaLista() {
        val lst: Lista<Int> = crearLista(17, 8, -4, 30, 18, 180, 6, 2, 20)

        assertEquals(180, mayorDeUnaLista(lst))
        assertEquals(1000, mayorDeUnaLista(crearLista(89, 11, -31, -289, 471, 264, 1000)))
        println("Prueba superada ☺️")
    }

    @Test
    fun probarTodosNumerosPositivos() {
        assertTrue(todosNumerosPositivos(crearLista(17, 8, 4, 30, 0, 180, 6, 2, 20)))
        assertTrue(todosNumerosPositivos(crearLista(16)))
        assertFalse(todosNumerosPositivos(crearLista(17, 8, 4, 30, -18, 180, 6, 2, 20)))
        assertFalse(todosNumerosPositivos(crearLista(-21)))
        println("Prueba superada ☺️")
    }

    @Test
    fun probarPuntosPrimerCuadrante() {
        val lp: Lista<Punto> = crearLista(Punto(3, 4), Punto(2, -1), Punto(-5, -10), Punto(5, 6), Punto (-2, 2))
        assertEquals(2, puntosPrimerCuadrante(lp).tam)
        println("Prueba superada ☺️")
    }

    @Test
    fun probarTodosParesDosCifras() {
        assertTrue(todosParesDosCifras(crearLista(82, 106, 26, 34, 3, 10_087, 48, 70, 195, 2_311, 16)))
        assertTrue(todosParesDosCifras(crearLista(7)))
        assertTrue(todosParesDosCifras(crearLista(96)))
        assertTrue(todosParesDosCifras(crearLista(961, 189, 783, 505, 321)))
        assertFalse(todosParesDosCifras(crearLista(72, 960, 188, 11, 50, 3210)))
        println("Prueba superada ☺️")
    }

    fun letrasDeString(frase: String): Lista<Char> {
        val res = listaVacia<Char>()
        for (c in frase) {
            res.agregarAlFinal(c)
        }
        return res
    }

    @Test
    fun probarConvertirMayusculas() {
        val res = crearLista('L', 'A', ' ', 'C', 'A', 'S', 'A', ' ', 'A', 'Z', 'U', 'L', ' ', 'E', 'S', 'T', 'A', ' ', 'L', 'E', 'J', 'O', 'S')
        assertEquals(res, convertirMayusculas(letrasDeString("La casa azul esta lejos")))
        println("Prueba superada ☺️")
    }

    @Test
    fun probarPuntoMasLejano() {
        val lp: Lista<Punto> = crearLista(Punto(3, 4), Punto(2, -1), Punto(-5, -10), Punto(5, 6), Punto (-2, 2))
        assertEquals(Punto(-5, -10), puntoMasLejano(lp))
        assertNull(puntoMasLejano(listaVacia()))
        println("Prueba superada ☺️")
    }
}