package taller15

import ean.colecciones.Arbin
import ean.pruebas.Pruebas
import ean.pruebas.Punto
import ean.utils.Listas
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.function.Predicate

class ArBinTest {

    @Test
    fun pruebaPeso() {
        with (Pruebas) {
            assertEquals(0, peso(Arbin<Int>()))
            assertEquals(peso(arbolDeVerbos()), arbolDeVerbos().peso)
            assertEquals(14, peso(arbolDeNumeros()))
            assertEquals(519, peso(arbolDePersonas()))
            assertEquals(12, peso(arbolDePuntos()))
        }
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaAltura() {
        with (Pruebas) {
            assertEquals(5, alturaArbol(arbolDeNumeros()))
            assertEquals(10, alturaArbol(arbolDePersonas()))
            assertEquals(4, alturaArbol(arbolDeProductos()))
            assertEquals(4, alturaArbol(arbolDeVerbos()))
            println("Prueba superada 👍")
        }
    }

    @Test
    fun pruebaEstaArbin() {
        val arbol1 = Pruebas.arbolDeLetras()
        val arbol2 = Pruebas.arbolDeNumeros()
        val arbol3 = Pruebas.arbolDePuntos()

        assertTrue(estaEnElArbol(arbol1, "H"))
        assertTrue(estaEnElArbol(arbol2, 46))
        assertFalse {
            estaEnElArbol(arbol2, 72)
        }
        assertTrue {
            estaEnElArbol(arbol3, Punto(6.0, -70.0))
        }
        assertFalse {
            estaEnElArbol(arbol3, Punto(0.0, 0.0))
        }

        assertFalse {
            estaEnElArbol(Arbin<Int>(), 30)
        }
        assertTrue(estaEnElArbol(arbol1, "K"))
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaContarVocales() {
        val arbol = Pruebas.arbolDeLetras()
        val vacio = Arbin<String>()

        assertEquals(0, contarVocales(vacio))
        assertEquals(3, contarVocales(arbol))
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaContarArbol() {
        val arbol = Pruebas.arbolDeNumeros()
        assertEquals(3, contarArbol(arbol))
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaContarPRoductos() {
        val arbol = Pruebas.arbolDeProductos()
        assertEquals(5, contarProductos(arbol))
        println("Prueba superada \uD83D\uDC4D")

    }

    @Test
    fun pruebaContarPersonasConLentesCedulaMultiploSeis() {
        var ap = Pruebas.arbolDePersonas()
        assertEquals(47, contarPersonasConLentesCedulaMultiploSeis(ap))
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaEstratoMayorCantidadMujeresSinHijos() {
        var ap = Pruebas.arbolDePersonas()
        assertEquals(2, estratoMayorCantidadMujeresSinHijos(ap))
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaPerrosRaza() {
        val perros = Pruebas.arbolDePerros()
        assertEquals(Listas.crear("Lino"), perrosRaza(perros, "Pincher"))
        assertTrue(Listas.similares(Listas.crear("Brutal y Mamut", "Mandala"), perrosRaza(perros, "Doberman")))
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaPorcetajePerrosMenoresEdad() {
        val ap = Pruebas.arbolDePerros()
        assertEquals(14.2857, porcetajePerrosMenoresEdad(ap, 10), 1e-4)
        assertEquals(85.7142, porcetajePerrosMenoresEdad(ap, 20), 1e-4)
        assertEquals(92.8571, porcetajePerrosMenoresEdad(ap, 30), 1e-4)
        assertEquals(100.0, porcetajePerrosMenoresEdad(ap, 40), 1e-4)
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaPorcentaPersonasPrimaria() {
        val personas = Pruebas.arbolDePersonas()
        assertEquals(0.0, porcentaPersonasPrimaria(personas, 160))
        assertEquals(10.7900, porcentaPersonasPrimaria(personas, 170), 1e-4)
        assertEquals(19.6532, porcentaPersonasPrimaria(personas, 180), 1e-4)
        assertEquals(22.9287, porcentaPersonasPrimaria(personas, 190), 1e-4)
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaPromedioEdadPersonasIngreso() {
        val personas = Pruebas.arbolDePersonas()
        assertEquals(42.0, promedioEdadPersonasIngreso(personas, 2_000_000))
        assertEquals(41.375, promedioEdadPersonasIngreso(personas, 3_000_000), 1e-4)
        assertEquals(39.2696, promedioEdadPersonasIngreso(personas, 4_000_000), 1e-4)
        assertEquals(38.8729, promedioEdadPersonasIngreso(personas, 5_000_000), 1e-4)
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaNombresProdsPrecioInfProm() {
        val productos = Pruebas.arbolDeProductos()
        val respuesta = Listas.crear("Pescado", "Brocoli", "Naranja", "Carne", "Café")
        assertTrue(Listas.similares(respuesta, nombresProdsPrecioInfProm(productos)))
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaPreorden() {
        val a1 = Pruebas.arbolDeLetras()
        val a2 = Pruebas.arbolDeNumeros()
        val a3 = Pruebas.arbolDeVerbos()

        assertEquals(Listas.crear("A", "B", "D", "G", "E", "H", "I", "C", "F", "J", "K"), preorden(a1))
        assertEquals(Listas.crear(60, 41, 16, 25, 53, 46, 42, 55, 74, 65, 63, 62, 64, 70), preorden(a2))
        assertEquals(Listas.crear("comer", "cenar", "tener", "pedir", "sanar", "sufrir", "mecer", "adolecer", "partir", "internacionalizar", "exponer"), preorden(a3))

        println("Prueba superada 👍")
    }

    @Test
    fun pruebaInorden() {
        val a1 = Pruebas.arbolDeLetras()
        val a2 = Pruebas.arbolDeNumeros()
        val a3 = Pruebas.arbolDeVerbos()

        assertEquals(Listas.crear("G", "D", "B", "H", "E", "I", "A", "C", "J", "K", "F"), inorden(a1))
        assertEquals(Listas.crear(16, 25, 41, 42, 46, 53, 55, 60, 62, 63, 64, 65, 70, 74), inorden(a2))
        assertEquals(Listas.crear("pedir", "tener", "sanar", "cenar", "mecer", "sufrir", "adolecer", "comer", "internacionalizar", "partir", "exponer"), inorden(a3))

        println("Prueba superada 👍")
    }

    @Test
    fun pruebaPostorden() {
        val a1 = Pruebas.arbolDeLetras()
        val a2 = Pruebas.arbolDeNumeros()
        val a3 = Pruebas.arbolDeVerbos()

        assertEquals(Listas.crear("G", "D", "H", "I", "E", "B", "K", "J", "F", "C", "A"), postorden(a1))
        assertEquals(Listas.crear(25, 16, 42, 46, 55, 53, 41, 62, 64, 63, 70, 65, 74, 60), postorden(a2))
        assertEquals(Listas.crear("pedir", "sanar", "tener", "mecer", "adolecer", "sufrir", "cenar", "internacionalizar", "exponer", "partir", "comer"), postorden(a3))

        println("Prueba superada 👍")
    }

    @Test
    fun pruebaEncontrarProducto() {
        val prods = Pruebas.arbolDeProductos()

        assertEquals(61.0, encontrarProducto(prods, "Pescado"))
        assertEquals(300.0, encontrarProducto(prods, "Papa"))
        assertEquals(166.0, encontrarProducto(prods, "Brocoli"))
        assertNull(encontrarProducto(prods, "Salchicha"))

        println("Prueba superada 👍")
    }

    @Test
    fun pruebaMasJoven() {
        val personas = Pruebas.arbolDePersonas()

        assertEquals(1, personaMasJovenDeTres(personas, 1092582221, 1122663782, 1034944488))
        assertEquals(3, personaMasJovenDeTres(personas, 1541482170, 1360423091, 1936081354))
        assertEquals(2, personaMasJovenDeTres(personas, 1323059063, 1684818576, 1972303058))
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaMasJovenEstrato() {
        val personas = Pruebas.arbolDePersonas()

        val p1 = personaMasJovenDeEstrato(personas, 2)
        assert(p1 != null && p1.cedula == 1172509586 && p1.edad == 21 && p1.estrato == 2)
        val p2 = personaMasJovenDeEstrato(personas, 3)
        assert(p2 != null && p2.cedula == 1381190960 && p2.edad == 21 && p2.estrato == 3)
        val p3 = personaMasJovenDeEstrato(personas, 4)
        assert(p3 != null && p3.cedula == 1477645257 && p3.edad == 21 && p3.estrato == 4)
        assertNull(personaMasJovenDeEstrato(personas, 5))
        println("Prueba superada 👍")
    }

}