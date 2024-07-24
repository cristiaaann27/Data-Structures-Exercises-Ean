package taller20

import ean.colecciones.*
import ean.pruebas.Departamento
import ean.pruebas.Pruebas.leerArchivoDepartamentos
import ean.pruebas.Pruebas.leerArchivoMunicipios
import ean.utils.Listas
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Taller20Test {
    // Configura las listas para los métodos relacionados con productos
    private fun configurarEscenariosProductos(): Lista<Producto> {
        return Listas.crear(
            Producto(1, "Papa", 20, 2000),
            Producto(2, "Arroz", 5, 800),
            Producto(3, "Jamón", 120, 6_000),
            Producto(4, "Queso", 280, 15_000),
            Producto(5, "Pera", 33, 5_400),
            Producto(6, "Cebolla", 316, 815),
            Producto(7, "Leche", 177, 4_500),
            Producto(999, "Café", 511, 14_750)
        )
    }

    // Configura la lista de rectangulos
    private fun configurarRectangulos(): Lista<Rectangulo> {
        val lr: Lista<Rectangulo> = listaVacia()

        lr.agregarAlFinal(Rectangulo(4.0, 10.0))
        lr.agregarAlFinal(Rectangulo(8.0, 6.0))
        lr.agregarAlFinal(Rectangulo(3.0, 3.0))
        lr.agregarAlFinal(Rectangulo(4.0, 3.0))
        lr.agregarAlFinal(Rectangulo(2.0, 10.0))
        lr.agregarAlFinal(Rectangulo(6.0, 6.0))
        lr.agregarAlFinal(Rectangulo(3.0, 4.0))
        lr.agregarAlFinal(Rectangulo(5.0, 8.0))
        lr.agregarAlFinal(Rectangulo(9.0, 11.0))
        lr.agregarAlFinal(Rectangulo(20.0, 12.0))
        lr.agregarAlFinal(Rectangulo(6.0, 10.0))
        lr.agregarAlFinal(Rectangulo(14.0, 18.5))
        lr.agregarAlFinal(Rectangulo(4.0, 5.0))
        lr.agregarAlFinal(Rectangulo(10.0, 10.0))
        lr.agregarAlFinal(Rectangulo(8.0, 6.0))
        lr.agregarAlFinal(Rectangulo(21.0, 3.0))
        lr.agregarAlFinal(Rectangulo(5.0, 5.0))
        return lr
    }

    // Configura la lista de triángulos
    private fun configurarTriangulos(): Lista<Triangulo> {
        val lt: Lista<Triangulo> = listaVacia()

        lt.agregarAlFinal(Triangulo(1, 3.0, 4.0, 5.0))
        lt.agregarAlFinal(Triangulo(2, 4.0, 10.0, 2.0))
        lt.agregarAlFinal(Triangulo(3, 3.0, 4.0, 5.0))
        lt.agregarAlFinal(Triangulo(4, 8.0, 6.0, 15.0))
        lt.agregarAlFinal(Triangulo(5, 4.0, 5.0, 4.0))
        lt.agregarAlFinal(Triangulo(6, 12.0, 15.0, 15.0))
        lt.agregarAlFinal(Triangulo(7, 15.0, 36.0, 39.0))
        lt.agregarAlFinal(Triangulo(8, 2.0, 2.0, 3.0))
        lt.agregarAlFinal(Triangulo(9, 23.0, 24.0, 25.0))
        lt.agregarAlFinal(Triangulo(10, 52.0, 20.0, 48.0))
        return lt
    }

    private fun <T> similares(a: Lista<T>, b: Lista<T>): Boolean {
        if (a.tam != b.tam) {
            return false
        }
        return a.contieneLista(b)
    }

    @Test
    fun pruebaMetodo1() {
        val listap = configurarEscenariosProductos()

        assertTrue(similares(crearLista("Arroz", "Cebolla", "Queso"), metodo1(listap)))
        println("Prueba superada!!!")
    }

    @Test
    fun pruebaMetodo2() {
        val listap = configurarEscenariosProductos()

        assertEquals(7, metodo2(listap, 4))
        assertEquals(2, metodo2(listap, 1))
        println("Prueba superada!!")
    }

    @Test
    fun pruebaMetodo3() {
        val listap = configurarEscenariosProductos()

        assertTrue(similares(crearLista(1, 3, 5, 7), metodo3(listap, 10)))
        println("Prueba superada!!!")
    }

    @Test
    fun pruebaMetodo4() {
        val listap = configurarEscenariosProductos()

        assertTrue(metodo4(listap))
        assertFalse(metodo4(listap.filtrar { it.cantidad < 100 }))
        println("Prueba superada!!!")
    }

    @Test
    fun pruebaMetodo5() {
        val listaP = configurarEscenariosProductos()

        assertEquals(111.83333, metodo5(listaP), 1e-5)
        println("Prueba superada!!!")
    }

    @Test
    fun pruebaMetodo6() {
        val listaD = leerArchivoDepartamentos()

        assertEquals("Bogotá", metodo6(listaD))
        println("Prueba superada!!!")
    }

    @Test
    fun pruebaMetodo7() {
        val listaD = leerArchivoDepartamentos()

        assertEquals("Amazonas", metodo7(listaD, 0)!!.nombre)
        assertEquals("Antioquia", metodo7(listaD, 1_000_000)!!.nombre)
        assertNull(metodo7(listaD, 15_000_000))
        println("Prueba superada!!!")
    }

    @Test
    fun pruebaMetodo8() {
        val listaD = leerArchivoDepartamentos()

        assertTrue(similares(crearLista("Casanare", "Valle del Cauca"), metodo8(listaD)))
        println("Prueba superada!!!")
    }

    @Test
    fun pruebaMetodo9() {
        val listaD = leerArchivoDepartamentos()

        assertEquals(15.151515, metodo9(listaD, 5.0), 1e-6)
        assertEquals(75.757575, metodo9(listaD, 100.0), 1e-6)
        println("Prueba superada!!!")
    }

    @Test
    fun pruebaMetodo10() {
        val listaD = leerArchivoDepartamentos()

        assertEquals(25807.47368, metodo10(listaD), 1e-5)
        println("Prueba superada!!!")
    }

    @Test
    fun pruebaMetodo22() {
        val listaD = leerArchivoDepartamentos()
        assertEquals(222119.0, metodo22(listaD, "Andina"))
        assertEquals(131680.0, metodo22(listaD, "Caribe"))
        assertEquals(402845.0, metodo22(listaD, "Amazonía"))
        println("Prueba superada!!! 👍🏼")
    }

    @Test
    fun pruebaMetodo23() {
        val listaD = leerArchivoDepartamentos()
        val listaM = leerArchivoMunicipios()

        assertEquals(8139.0, metodo23(listaD, listaM, "Andina"))
        assertEquals(10882.5, metodo23(listaD, listaM, "Caribe"))
        assertEquals(2259.0, metodo23(listaD, listaM, "Amazonía"))

        println("Prueba superada!!! 👍🏼")
    }

    @Test
    fun pruebaMetodo11() {
        val lm = leerArchivoMunicipios()

        assertEquals(32, metodo11(lm))
        println("Prueba superada!!!")
    }

    @Test
    fun pruebaMetodo12() {
        val lm = leerArchivoMunicipios()

        assertEquals("Puerto Nariño", metodo12(lm, "Amazonas"))
        assertEquals("Duitama", metodo12(lm, "Boyacá"))
        assertEquals("Soledad", metodo12(lm, "Atlántico"))
        println("Prueba superada!!!")
    }

    @Test
    fun pruebaMetodo13() {
        val lm = leerArchivoMunicipios()

        assertEquals(38710.31578, metodo13(lm, "Huila"), 1e-5)
        assertEquals(21835.4, metodo13(lm, "Caquetá"))
        println("Prueba superada!!!")
    }

    @Test
    fun pruebaMetodo14() {
        val lm = leerArchivoMunicipios()

        assertEquals("Jambaló", metodo14(lm))
        println("Prueba superada!!!")
    }

    @Test
    fun pruebaMetodo15() {
        val lm = leerArchivoMunicipios()

        assertEquals(104, metodo15(lm))
        println("Prueba superada!!!")
    }

    @Test
    fun pruebaMetodo16() {
        val lr = configurarRectangulos()

        assertEquals(4, metodo16(lr))
        println("Prueba superada!!!")
    }

    @Test
    fun pruebaMetodo17() {
        val lr = configurarRectangulos()

        assertEquals(68.75, metodo17(lr))
        println("Prueba superada!!!")
    }

    @Test
    fun pruebaMetodo18() {
        val lr = configurarRectangulos()

        assertEquals(Rectangulo(base=14.0, altura=18.5), metodo18(lr))
        println("Prueba superada!!!")
    }

    @Test
    fun pruebaMetodo19() {
        val lr = configurarRectangulos()
        val res = metodo19(lr, 25.0)

        assertEquals(2, res.tam)
        assertEquals(8.4852, res[0], 1e-4)
        assertEquals(14.1421, res[1], 1e-4)
        println("Prueba superada!!!")
    }

    @Test
    fun pruebaMetodo20() {
        val lt = configurarTriangulos()

        assertTrue(similares(crearLista(6.0, 6.0, 270.0, 480.0), metodo20(lt)))
        println("Prueba superada!!!")
    }

    @Test
    fun pruebaMetodo21() {
        val lt = configurarTriangulos()

        assertTrue(similares(crearLista(5, 8), metodo21(lt)))
        println("Prueba superada!!!")
    }
}