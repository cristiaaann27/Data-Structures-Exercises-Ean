package taller11

import ean.colecciones.Pila
import ean.colecciones.crearLista
import ean.colecciones.pilaVacia
import ean.colecciones.recorrer
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Taller11KtTest {
    @Test
    fun pruebaPromedioPares() {
        var pila = pilaVacia<Int>()
        with (pila) {
            apilar(4)
            apilar(17)
            apilar(61)
            apilar(16)
            apilar(38)
            apilar(519)
            apilar(178)
            apilar(180)
            apilar(96)
            apilar(5)
        }
        assertEquals(85.3333, promedioPares(pila), 1e-4)

        pila = pilaVacia()
        with (pila) {
            apilar(4)
            apilar(17)
            apilar(61)
            apilar(161)
            apilar(381)
            apilar(5191)
            apilar(1781)
            apilar(1801)
            apilar(96)
            apilar(5)
            apilar(200)
        }
        assertEquals(100.0, promedioPares(pila))

        println("Prueba superada 👍")
    }


    @Test
    fun pruebaEjercicio01() {
        val pila: Pila<Int> = pilaVacia()

        pila.apilar(1)
        pila.apilar(2)
        pila.apilar(3)
        pila.apilar(4)
        pila.apilar(5)
        pila.apilar(6)

        println("La pila es $pila")
        println("El tope es ${pila.tope()}")
        println("El fondo es ${obtenerFondo(pila)}")

        assertEquals(1, obtenerFondo(pila))
        println("Prueba Superada ✔")
    }

    @Test
    fun pruebaEjercicio02() {
        val p: Pila<Int> = pilaVacia()

        p.apilar(2)
        p.apilar(25)
        p.apilar(250)
        p.apilar(2500)
        p.apilar(100)
        p.apilar(125)
        p.apilar(81)

        assertEquals(350, sumarParesTresCifras(p))
        println("Prueba Superada ✔")
    }

    @Test
    fun pruebaEjercicio03() {
        var p: Pila<Int> = pilaVacia()

        p.apilar(2)
        p.apilar(25)
        p.apilar(250)
        p.apilar(50)
        p.apilar(100)
        p.apilar(95)
        p.apilar(81)

        assertEquals(mayorDeDosCifras(p), 95)
        println("Primera Prueba Superada ✔")

        p = pilaVacia()
        p.apilar(3)
        p.apilar(4)
        p.apilar(5)

        assertNull(mayorDeDosCifras(p))
        println("Prueba Superada ✔")

    }

    @Test
    fun pruebaEjercicio04() {
        val pila: Pila<Int> = pilaVacia()

        pila.apilar(1)
        pila.apilar(2)
        pila.apilar(3)
        pila.apilar(4)
        pila.apilar(5)
        pila.apilar(6)

        assertEquals(1, obtenerFondo(pila))

        guardarEnElFondo(pila, 10)

        assertEquals(10, obtenerFondo(pila))
        println("Prueba superada!")
    }


    @Test
    fun pruebaEjercicio05() {
        val pila: Pila<String> = pilaVacia()

        assertEquals(0, tamPila(pila))

        pila.apilar("Hola")
        pila.apilar("nano")
        pila.apilar("shell")
        pila.apilar("rojo")

        assertEquals(4, tamPila(pila))
        println("Prueba Superada ✔")
    }

    @Test
    fun pruebaEjercicio06() {
        val pila: Pila<String> = pilaVacia()
        val lista = crearLista("uno", "dos", "tres", "cuatro", "cinco")

        recorrer(lista) {
            pila.apilar(it)
        }

        val inv = invertirPila(pila)
        recorrer(lista) {
            assertEquals(it, inv.tope())
            inv.desapilar()
        }
        println("Prueba Superada ✔")
    }

    @Test
    fun pruebaEjercicio07() {
        val pila: Pila<Int> = pilaVacia()
        val lista = crearLista(5, 11, 8, -3, 6, 4, 31)

        recorrer(lista) {
            pila.apilar(it)
        }

        val copia = copiarPila(pila)
        for (n in lista.tam - 1 downTo 0) {
            assertEquals(lista[n], copia.tope())
            copia.desapilar()
        }
        println("Prueba Superada ✔")
    }

    @Test
    fun pruebaEjercicio08() {
        val pila: Pila<Int> = pilaVacia()
        val lista = crearLista(5, 11, 8, -3, 5, 4, 31, 5)

        recorrer(lista) {
            pila.apilar(it)
        }

        eliminarElementoPila(pila, 5)

        for (n in lista.tam - 1 downTo 0) {
            if (lista[n] != 5) {
                assertEquals(lista[n], pila.tope())
                pila.desapilar()
            }
        }
        assertTrue(pila.vacia())
        println("Prueba Superada ✔")
    }

    @Test
    fun pruebaEjercicio09() {
        val lista = crearLista<Int>(8, 1, 7, 6, -4, 5, 1, 31)
        val invlst = crearLista<Int>(8, 1, 7, 6, -4, 5, 1, 31)

        invertirLista(lista)

        for (i in 0..<lista.tam) {
            assertEquals(lista[i], invlst[lista.tam - i - 1])
        }
        println("Prueba Superada ✔")
    }

    @Test
    fun pruebaEjercicio10() {
        assertTrue(palindrome("nosubasabuson"))
        assertTrue(palindrome("lavanesabasenaval"))
        assertTrue(palindrome("logracasillasallisacargol"))
        assertFalse(palindrome("arrozconleche"))
        println("Prueba Superada ✔")
    }

    @Test
    fun pruebaEjercicio11() {
        val pila1: Pila<String> = pilaVacia()
        val pila2: Pila<String> = pilaVacia()
        val pila3: Pila<String> = pilaVacia()
        val lista = crearLista("uno", "dos", "tres", "cuatro", "cinco")

        for (i in lista.indices) {
            val elem = lista[i]
            pila1.apilar(elem)
            pila2.apilar(elem)
            pila3.apilar(elem)
            pila3.apilar(elem)
        }

        assertTrue(igualesPilas(pila1, pila2))
        assertFalse(igualesPilas(pila3, pila2))
        println("Prueba Superada ✔")
    }

    @Test
    fun pruebaContarVerbos() {
        val palabras: Pila<String> = pilaVacia()

        palabras.apilar("casa")
        palabras.apilar("casar")
        palabras.apilar("yuca")
        palabras.apilar("camisa")
        palabras.apilar("lluvia")
        palabras.apilar("llover")
        palabras.apilar("vives")
        palabras.apilar("vivir")
        palabras.apilar("partir")
        palabras.apilar("toma")
        palabras.apilar("épico")
        palabras.apilar("abrigo")
        palabras.apilar("rumor")

        assertEquals(4, contarVerbos(palabras))
        println("Prueba Superada ✔")
    }

    @Test
    fun pruebaReemplazar() {
        val pila: Pila<Int> = pilaVacia()

        pila.apilar(4)
        pila.apilar(2)
        pila.apilar(3)
        pila.apilar(5)
        pila.apilar(2)
        pila.apilar(1)

        reemplazarElementoPila(pila, 2, 7)
        var n = 0
        var x = 0

        while (!pila.vacia()) {
            n++
            if (pila.tope() == 7) {
                x++
            }
            else if (pila.tope() == 2) {
                assertEquals(7, pila.tope())
            }
            pila.desapilar()
        }
        assertTrue(n == 6 && x == 2)
        println("Prueba Superada ✔")

    }

    @Test
    fun probarPerrosMenoresEdad() {
        var pilaPerros: Pila<Perro> = pilaVacia()

        with (pilaPerros) {
            apilar(Perro("juana", "chihuahua", 12))
            apilar(Perro("lila", "bulldog", 6))
            apilar(Perro("leon", "bulldog", 5))
            apilar(Perro("dion", "pastor collie", 7))
            apilar(Perro("leila", "bulldog", 11))
            apilar(Perro("angel", "pastor collie", 3))
            apilar(Perro("angela", "chihuahua", 4))
            apilar(Perro("terso", "bulldog", 5))
        }

        val res = perrosMenoresEdad(pilaPerros, 10)
        assertEquals(crearLista("terso", "angela", "lila"), res)
        println("Prueba superada!")
    }

    @Test
    fun pruebaPerroMasJoven() {
        var pilaPerros: Pila<Perro> = pilaVacia()

        with (pilaPerros) {
            apilar(Perro("juana", "chihuahua", 12))
            apilar(Perro("lila", "bulldog", 6))
            apilar(Perro("leon", "bulldog", 5))
            apilar(Perro("dion", "pastor collie", 7))
            apilar(Perro("leila", "bulldog", 11))
            apilar(Perro("angel", "pastor collie", 3))
            apilar(Perro("angela", "chihuahua", 4))
            apilar(Perro("terso", "bulldog", 5))
            apilar(Perro("resisto", "fox terrier", 15))
            apilar(Perro("mao", "doberman", 8))
            apilar(Perro("miso", "bulldog", 16))
            apilar(Perro("rifa", "doberman", 2))
            apilar(Perro("pumba", "fox terrier", 9))
            apilar(Perro("tostao", "pastor collie", 5))
            apilar(Perro("viento", "doberman", 12))
            apilar(Perro("brisa", "fox terrier", 1))
            apilar(Perro("arrastrao", "chihuahua", 18))
        }

        var res: Perro? = perroMasJoven(pilaPerros, "labrador")
        assertNull(res)

        res = perroMasJoven(pilaPerros, "doberman")
        var p1 = Perro(nombre="rifa", raza="doberman", edad=2)
        assertEquals(p1, res)

        res = perroMasJoven(pilaPerros, "chihuahua")
        p1 = Perro(nombre="angela", raza="chihuahua", edad=4)
        assertEquals(p1, res)

        res = perroMasJoven(pilaPerros, "bulldog")
        p1 = Perro(nombre="terso", raza="bulldog", edad=5)
        assertEquals(p1, res)

        println("Prueba superada! 👍")
    }
}