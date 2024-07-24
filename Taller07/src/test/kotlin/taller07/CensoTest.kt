package taller07

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
    fun pruebaIMC() {
        val censo = crearCenso()
        val p1 = censo.personas[0]
        val p2 = censo.personas[100]
        val p3 = censo.personas[200]
        assertEquals(18.1018, p1.IMC(), 1e-4)
        assertEquals(33.0236, p2.IMC(), 1e-4)
        assertEquals(25.5296, p3.IMC(), 1e-4)
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaNivelPeso() {
        val censo = crearCenso()
        val p1 = censo.personas[0]
        val p2 = censo.personas[100]
        val p3 = censo.personas[200]
        assertEquals("Bajo peso", nivelPeso(p1))
        assertEquals("Obesidad", nivelPeso(p2))
        assertEquals("Sobrepeso", nivelPeso(p3))
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaCantHombres() {
        val censo = crearCenso()
        assertEquals(262, censo.cantHombres())

        val censo2 = crearCenso(censo, 125, 250)
        assertEquals(65, censo2.cantHombres())
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaContarMujeresConAutomovil() {
        val censo = crearCenso()
        assertEquals(142, censo.contarMujeresConAutomovil())

        val censo2 = crearCenso(censo, 150, 300)
        assertEquals(43, censo2.contarMujeresConAutomovil())
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaEjercicio1() {
        val censo = crearCenso()
        assertEquals(89, censo.ejercicio1(40))
        assertEquals(142,censo.ejercicio1(50))
        assertEquals(182,censo.ejercicio1(60))
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaEjercicio2() {
        val censo = crearCenso()
        assertEquals(4,  censo.ejercicio2())

        val censo2 = crearCenso(censo, 100, 400)
        assertEquals(3, censo2.ejercicio2())
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaEjercicio3() {
        val censo = crearCenso()
        assertEquals(0.3853, censo.ejercicio3(), 1e-4)

        val censo2 = crearCenso(censo, 100, 400)
        assertEquals(0.6644, censo2.ejercicio3(), 1e-4)
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaEjercicio4() {
        val censo = crearCenso()
        assertEquals(183, censo.ejercicio4())

        val censo2 = crearCenso(censo, 350, 500)
        assertEquals(57, censo2.ejercicio4())
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaEjercicio5() {
        val censo = crearCenso()
        assertEquals(161_844_000, censo.ejercicio5())
        val censo2 = crearCenso(censo, 80, 249)
        assertEquals(50_390_000, censo2.ejercicio5())
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaEjercicio6() {
        val censo = crearCenso()
        assertEquals(8_067, censo.ejercicio6())
        val censo2 = crearCenso(censo, 120, 388)
        assertEquals(4_227, censo2.ejercicio6())
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaEjercicio7() {
        val censo = crearCenso()
        assertEquals(40.8333, censo.ejercicio7(), 1e-4)
        val censo2 = crearCenso(censo, 120, 388)
        assertEquals(41.8965, censo2.ejercicio7(), 1e-4)
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaEjercicio8() {
        val censo = crearCenso()
        assertEquals(2_954_500.0, censo.ejercicio8("POSTGRADO"))
        assertEquals(2_199_000.0, censo.ejercicio8("PREGRADO"))
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaEjercicio9() {
        val censo = crearCenso()
        assertEquals(40.70175, censo.ejercicio9(), 1e-5)
        println("Prueba superada 👍")
    }
}