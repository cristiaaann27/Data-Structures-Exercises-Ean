package taller08

import ean.colecciones.crearLista
import ean.colecciones.listaVacia
import ean.colecciones.recorrer
import ean.colecciones.subLista
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class CensoTest {

    fun crearCenso(censo: Censo? = null, ini: Int = 0, fin: Int = -1): Censo {
        val result: Censo = Censo()
        if (censo == null) {
            result.personas = leerArchivoPersonas()
        }
        else {
            result.personas = subLista(censo.personas, ini, fin)
        }
        return result
    }

    @Test
    fun pruebaEjercicio1() {
        val censo = crearCenso()
        assertEquals(2, censo.ejercicio1())

        var cens2 = crearCenso(censo, 400, 518)
        assertEquals(3, cens2.ejercicio1())

        cens2 = crearCenso(censo, 200, 388)
        assertEquals(4, cens2.ejercicio1())

        cens2 = crearCenso(censo, 1, 500)
        assertEquals(2,cens2.ejercicio1())
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaEjercicio2() {
        val censo = crearCenso()
        assertEquals(1293791906, censo.ejercicio2())

        var cens2 = crearCenso(censo, 400, 518)
        assertEquals(1769839902, cens2.ejercicio2())

        cens2 = crearCenso(censo, 200, 388)
        assertEquals(1410048261, cens2.ejercicio2())

        cens2 = crearCenso(censo, 1, 500)
        assertEquals(1293791906, cens2.ejercicio2())

        println("Prueba ejercicio 2 superada 👍")
    }

    @Test
    fun pruebaEjercicio3() {
        val censo = crearCenso()
        assertEquals(152, censo.ejercicio3())

        var cens2 = crearCenso(censo, 400, 518)
        assertEquals(102, cens2.ejercicio3())

        cens2 = crearCenso(censo, 200, 388)
        assertEquals(43, cens2.ejercicio3())

        cens2 = crearCenso(censo, 1, 500)
        assertEquals(151, cens2.ejercicio3())

        println("Prueba ejercicio3 superada 👍")
    }

    @Test
    fun pruebaEjercicio4() {
        val censo = crearCenso()
        var p = censo.ejercicio4()
        assertNotNull(p)
        if (p != null) {
            assert(p.cedula == 1176039127 && p.peso == 97 && p.altura == 180)
        }

        var cens2 = crearCenso(censo, 400, 518)
        p = cens2.ejercicio4()
        assertNotNull(p)
        if (p != null) {
            assert(p.cedula == 1786198213 && p.peso == 96 && p.altura == 176)
        }

        cens2 = crearCenso(censo, 200, 388)
        p = cens2.ejercicio4()
        assertNotNull(p)
        if (p != null) {
            assert(p.cedula == 1895741361 && p.peso == 96 && p.altura == 178)
        }

        cens2 = crearCenso(censo, 6, 10)
        p = cens2.ejercicio4()
        assertNull(p)

        println("Prueba ejercicio4 superada 👍")

    }

    @Test
    fun pruebaEjercicio5() {
        val censo = crearCenso()

        var p = censo.ejercicio5("PRIMARIA", "F")
        assertNotNull(p)
        if (p != null) {
            assertEquals(1803118544, p.cedula )
        }

        p = censo.ejercicio5("SECUNDARIA", "F")
        assertNotNull(p)
        if (p != null) {
            assertEquals(1833824926, p.cedula )
        }

        p = censo.ejercicio5("PRIMARIA", "M")
        assertNotNull(p)
        if (p != null) {
            assertEquals(1080216646, p.cedula )
        }

        p = censo.ejercicio5("UNIVERSIDAD", "F")
        assertNull(p)

        p = censo.ejercicio5("POSTGRADO", "F")
        assertNotNull(p)
        if (p != null) {
            assertEquals(1912665644, p.cedula )
        }

        println("Prueba ejercicio5 superada 👍")
    }

    @Test
    fun pruebaEjercicio6() {
        val censo = crearCenso()
        var p = censo.personas[41]
        var x = censo.ejercicio6(p.cedula)
        assertEquals(41, x)

        p = censo.personas[275]
        x = censo.ejercicio6(p.cedula)
        assertEquals(275, x)

        p = censo.personas[389]
        x = censo.ejercicio6(p.cedula)
        assertEquals(389, x)

        x = censo.ejercicio6(1_000)
        assertEquals(-1, x)

        println("Prueba ejercicio5 superada 👍")

    }

    @Test
    fun pruebaEjercicio7() {
        val censo = crearCenso()
        var p = censo.ejercicio7()
        assertNotNull(p)
        if (p != null) {
            assertEquals(1371229610, p.cedula)
        }

        var cens2 = crearCenso(censo, 65, 185)
        p = cens2.ejercicio7()
        assertNotNull(p)
        if (p != null) {
            assertEquals(1859973010, p.cedula)
        }

        cens2 = crearCenso(censo, 198, 219)
        p = cens2.ejercicio7()
        assertNotNull(p)
        if (p != null) {
            assertEquals(1281424353, p.cedula)
        }

        cens2 = crearCenso(censo, 340, 345)
        assertNull(cens2.ejercicio7())

        println("Prueba ejercicio7 superada 👍")
    }

    @Test
    fun pruebaEjercicio8() {
        var censo = crearCenso()
        var resultado = crearLista(1994927121, 1273072222, 1892221344, 1681941323, 1192588192, 1565415040, 1261807268, 1465817816, 1695156498)
        assertTrue(similares(resultado, censo.ejercicio8()))

        var cens2 = crearCenso(censo, 191, 457)
        resultado = crearLista(1565415040, 1261807268, 1465817816, 1695156498)
        assertTrue(similares(resultado, cens2.ejercicio8()))

        println("Prueba ejercicio8 superada 👍")
    }

    @Test
    fun pruebaEjercicio9() {
        val censo = crearCenso()
        val res = censo.ejercicio9(22, "M")
        val ced =  crearLista(1293791906, 1450653362, 1877341455, 1769839902, 1330358778, 1490975423)
        val res2 = listaVacia<Int>()
        recorrer(res) {
            res2.agregarAlFinal(it.cedula)
        }
        assertTrue(similares(ced, res2))
        println("Prueba ejercicio9 superada 👍")
    }

    @Test
    fun pruebaEjercicio10() {
        val censo = crearCenso()
        assertEquals(252, ejercicio10(censo.personas))
        var cens2 = crearCenso(censo, 57, 89)
        assertEquals(18, ejercicio10(cens2.personas))
        cens2 = crearCenso(censo, 191, 363)
        assertEquals(88, ejercicio10(cens2.personas))
        println("Prueba ejercicio10 superada 👍")
    }
}