package taller16

import ean.colecciones.ArbolBinarioOrdenado
import ean.utils.Listas
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Taller16Test {
    // Atributos de pruebas
    private val prod1: Producto = Producto("papa", 450.0, 5)
    private val prod2: Producto = Producto("arroz", 1300.0, 100)
    private val prod3: Producto = Producto("jamón", 7100.0, 20)
    private val prod4: Producto = Producto("arroz", 1200.5, 80)

    @Test
    fun pruebasCompararSuperHéroes() {
        val superman = SuperHéroe("Superman", 100, "Tierra 1")
        val batman1 = SuperHéroe("Batman", 43, "Tierra 1")
        val batman2 = SuperHéroe("Batman", 38, "Tierra 2")
        val arrow = SuperHéroe("Green Arrow", 21, "Tierra 1")
        val mujerMaravilla = SuperHéroe("Mujer Maravilla", 81, "Tierra 1")
        val vegeta = SuperHéroe("Vegeta", 21, "Capsule")

        // Pruebas
        assertTrue(superman > batman1)

        assertTrue(batman1 != batman2)
        assertTrue(arrow < mujerMaravilla)
        assertTrue(mujerMaravilla < vegeta )
        assertTrue(vegeta > superman)
    }

    // ------------------------------------------------------------------------------------

    // Pruebas de las clases Productos
    @Test
    fun prueba1() {
        assertTrue(prod1 < prod2)
        assertTrue(prod3 > prod4)
    }

    @Test
    fun prueba2() {
        val cmp = ComparadorDeProductosPorNombre()
        assertTrue(cmp.compare(prod1, prod2) > 0)
    }

    @Test
    fun prueba3() {
        assertTrue(ComparadorPorNombreYPrecio.compare(prod2, prod3) < 0 )
        assertTrue(ComparadorPorNombreYPrecio.compare(prod2, prod4) > 0)
    }

    @Test
    fun prueba4() {
        assertTrue(ComparadorPorCantidad.compare(prod1, prod2) < 0)
        assertTrue(ComparadorPorCantidad.compare(prod2, prod3) > 0)
    }

    @Test
    fun pruebaReloj1() {
        val r1 = Reloj()
        val r2 = Reloj(14, 21, 9)

        println(r1.toAMPMString())

        assertEquals(8, r1.toString().length)

        assertEquals("14:21:09", r2.toString())
        assertEquals("02:21:09 PM", r2.toAMPMString())
    }

    @Test
    fun pruebaReloj2() {
        val r1 = Reloj()
        val r2 = Reloj(14, 21, 9)
        val r3 = Reloj(14, 21, 59)
        val r4 = Reloj(14, 21, 59)
        val mn = Reloj(23, 59, 59)
        val cero = Reloj(0, 0, 0)
        val md = Reloj(12, 0, 0)

        assertTrue(r1 < mn)
        assertTrue(r3 == r4)
        assertNotSame(r3, r4)

        assertTrue(r3 > r2)

        r4.avanzarUnSegundo()
        assertTrue(r4 == Reloj(14, 22, 0))

        r2.avanzarUnSegundo()
        assertTrue(r2.hora == 14 && r2.minutos == 21 && r2.segundos == 10)

        assert(md < mn)

        md.retrocederUnSegundo()
        assertTrue(md.hora == 11 && md.minutos == 59 && md.segundos == 59)

        assertTrue(mn > cero)
        mn.avanzarUnSegundo()
        assertTrue(mn == cero)
        cero.retrocederUnSegundo()
        assertTrue(mn < cero)

        println("Prueba superada ✔")
    }

    @Test
    fun pruebaPais() {
        val pais1 = Pais("Colombia", "America", 50_000_000)
        val pais2 = Pais("Colombia", "Suramerica", 48_000_000)
        val pais3 = Pais("Dinamarca", "Europa", 8_000_000)
        val pais4 = Pais("Uruguay", "America", 3_000_000)

        assertTrue(pais1 < pais3)
        assertEquals(0, pais1.compareTo(pais2))
        assertTrue(pais4 > pais2)
        assertTrue(pais1 < pais4)

        println("Prueba superada 👍")
    }

    @Test
    fun pruebaBuscarPais() {
        val paises = ArbolBinarioOrdenado<Pais>()
        paises.insertarLista(Listas.crear(
            Pais("Mexico", "America", 120_000_000),
            Pais("Suecia", "Europa", 8_000_000),
            Pais("Francia", "Europa", 50_000_000),
            Pais("China", "Asia", 1_500_000_000),
            Pais("India", "Asia", 1_200_000_000),
            Pais("Egipto", "Africa", 80_000_000),
            Pais("Namibia", "Africa", 50_000_000),
            Pais("Italia", "Europa", 95_000_000),
            Pais("Australia", "Oceania", 40_000_000),
            Pais("Nicaragua", "America", 8_000_000),
            Pais("Venezuela", "America", 25_000_000),
            Pais("Etiopia", "Africa", 100_000_000),
            Pais("Arabia", "Asia", 80_000_000),
            Pais("Canada", "America", 30_000_000),
            Pais("Iran", "Asia", 140_000_000),
            Pais("Togo", "Africa", 8_000_000),
            Pais("Rumania", "Europa", 18_010_111),
            Pais("Pakistan", "Asia", 400_000_000),
            Pais("Belice", "America", 13_000_000),
            Pais("Oman", "Asia", 5_000_000)
        ))

        assertEquals(20, paises.peso)

        assertEquals(null, poblacionPais(paises, "Colombia"))
        assertEquals(140_000_000, poblacionPais(paises, "Iran"))
        assertEquals(25_000_000, poblacionPais(paises, "Venezuela"))
        assertEquals(1_200_000_000, poblacionPais(paises, "India"))

        println("Prueba superada 👍")
    }

    @Test
    fun pruebaPaisMasPoblado() {
        val paises = ArbolBinarioOrdenado<Pais>()
        paises.insertarLista(Listas.crear(
            Pais("Mexico", "America", 120_000_000),
            Pais("Suecia", "Europa", 8_000_000),
            Pais("Francia", "Europa", 50_000_000),
            Pais("China", "Asia", 1_500_000_000),
            Pais("India", "Asia", 1_200_000_000),
            Pais("Egipto", "Africa", 80_000_000),
            Pais("Namibia", "Africa", 50_000_000),
            Pais("Italia", "Europa", 95_000_000),
            Pais("Australia", "Oceania", 40_000_000),
            Pais("Nicaragua", "America", 8_000_000),
            Pais("Venezuela", "America", 25_000_000),
            Pais("Etiopia", "Africa", 100_000_000),
            Pais("Arabia", "Asia", 80_000_000),
            Pais("Canada", "America", 30_000_000),
            Pais("Iran", "Asia", 140_000_000),
            Pais("Togo", "Africa", 8_000_000),
            Pais("Rumania", "Europa", 18_010_111),
            Pais("Pakistan", "Asia", 400_000_000),
            Pais("Belice", "America", 13_000_000),
            Pais("Oman", "Asia", 5_000_000)
        ))
        var nombres = Listas.crear( "Iran", "Togo", "Oman", "Venezuela")

        var res1 = paisMasPoblado(nombres, paises)
        assertEquals("Iran", res1)

        nombres = Listas.crear("Belice", "India", "Canada", "Mexico", "Arabia", "Italia")
        res1 = paisMasPoblado(nombres, paises)
        assertEquals("India", res1)

        println("Prueba superada 👍")
    }
}