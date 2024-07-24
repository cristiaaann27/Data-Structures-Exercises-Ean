package taller20

import ean.colecciones.*
import ean.pruebas.Persona
import ean.pruebas.Pruebas
import ean.utils.Listas
import ean.utils.Listas.crear
import ean.utils.Listas.similares
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Taller20Kest {
    @Test
    fun pruebaClasePersonas() {
        val personas = Pruebas.listaDePersonas()
        assertEquals(18.1018, IMC(personas[0]), 1e-4)
        assertEquals("bajo peso", nivelDePeso(personas[0]).lowercase())
        assertEquals(31.0476, IMC(personas[262]), 1e-4)
        assertEquals("obesidad", nivelDePeso(personas[262]).lowercase())
        println("Prueba superada 👍🏼")
    }

    @Test
    fun pruebaEjercicio1() {
        val personas = Pruebas.listaDePersonas()
        assertEquals(262, ejercicio1(personas))
        println("Prueba superada 👍🏼")
    }

    @Test
    fun pruebaEjercicio2() {
        val personas = Pruebas.listaDePersonas()
        val cedulas = ejercicio2(personas).ordenar()
        assertEquals(Listas.crear(1360423091, 1417207541, 1536842169, 1538042950, 1631935342, 1665017495, 1762165104, 1839033016, 1972303058), cedulas)
        println("Prueba superada 👍🏼")
    }

    @Test
    fun pruebaEjercicio3() {
        val personas = Pruebas.listaDePersonas()
        assertEquals(2, ejercicio3(personas))
        println("Prueba superada 👍🏼")
    }

    @Test
    fun pruebaEjercicio4() {
        val personas = Pruebas.listaDePersonas()

        assertEquals(56_248_000, ejercicio4(personas, "PRIMARIA"))
        assertEquals(71_011_000, ejercicio4(personas, "SECUNDARIA"))
        assertEquals(46_193_000, ejercicio4(personas, "PREGRADO"))
        println("Prueba superada 👍🏼")
    }

    @Test
    fun pruebaEjercicio5() {
        val personas = Pruebas.listaDePersonas()
        assertFalse(ejercicio5(personas, 1_000_000))
        assertTrue(ejercicio5(personas, 2_000_000))
        println("Prueba superada 👍🏼")
    }

    @Test
    fun pruebaEjercicio6() {
        val personas = Pruebas.listaDePersonas()
        assertFalse(ejercicio6(personas))
        val mujeres = personas.filtrar { it.genero == "F" }
        assertFalse(ejercicio6(mujeres))
        val hombres = personas.filtrar { it.genero == "M" && nivelDePeso(it).lowercase() == "sobrepeso" }
        assertFalse(ejercicio6(hombres))
        val otros = hombres.filtrar { it.edad <= 33 }
        assertFalse(ejercicio6(otros))
        val final = otros.filtrar { it.edad >= 24 }
        assertTrue(ejercicio6(final))
        println("Prueba superada 👍🏼")
    }

    @Test
    fun pruebaEjercicio7() {
        val personas = Pruebas.listaDePersonas()
        var res1 = ejercicio7(personas, personas[350].cedula)

        var resp = crearLista(1684818576, 1605147766, 1881862390, 1579452242, 1734680626, 1333111713, 1274693581, 1741813800, 1955490190, 1075921947)
        assertTrue(similares(resp, res1))
        println("Primera prueba superada 👍🏼")

        res1 = ejercicio7(personas, personas[100].cedula)
        resp = crearLista(1684818576, 1605147766, 1881862390, 1579452242, 1734680626, 1598111524, 1333111713, 1969848135, 1274693581, 1858723629, 1741813800, 1955490190, 1075921947)
        assertTrue(similares(resp, res1))

        println("Segunda prueba superada 👍🏼")
    }

    @Test
    fun pruebaEjercicio8() {
        val personas = Pruebas.listaDePersonas()
        assertFalse(ejercicio8(personas))
        var lst1 = personas.filtrar { it.tieneLentes }
        assertFalse(ejercicio8(lst1))
        lst1 = lst1.filtrar { it.genero == "M" }
        assertTrue(ejercicio8(lst1))
        println("Prueba superada 👍🏼")
    }

    @Test
    fun pruebaEjercicio9() {
        val personas = Pruebas.listaDePersonas()
        assertTrue(ejercicio9(personas))
        val otros = personas.filtrar { it.ingresos < 1_000_000 }
        assertFalse(ejercicio9(otros))
        println("Prueba superada 👍🏼")
    }

    @Test
    fun pruebaEjercicio10() {
        val personas = Pruebas.listaDePersonas()
        val primeros15 = personas.obtenerPrimeros(15).seleccionar { it.cedula }
        assertEquals(crear(1847000, 2233000, 2420000, 2833000, 3072000, 3182000, 3551000, 4076000, 4231000, 4334000, 4425000, 4542000, 5256000, 5343000, 5583000),
            ejercicio10(personas, primeros15))

        val ultimos15 = personas.obtenerUltimos(15).seleccionar(Persona::cedula)
        assertEquals(
            crear(1735000, 2099000, 2843000, 2944000, 3351000, 3470000, 4353000, 4541000, 4552000, 4735000, 4768000, 5059000, 5150000, 5151000, 5368000),
            ejercicio10(personas, ultimos15))

        println("Prueba superada 👍🏼")

    }

    @Test
    fun pruebaEjercicio11() {
        val personas = Pruebas.listaDePersonas()
        val lista1 = personas.filtrar { it.genero == "M" }
        assertEquals(14.8855, ejercicio11(personas, lista1.seleccionar { it.cedula }), 1e-4)
        val lista2 = lista1.filtrar { it.hijos == 1 && it.estrato == 2 }
        assertEquals(100.0, ejercicio11(personas, lista2.seleccionar { it.cedula }), 1e-4)
        val lista3 = lista1.filtrar { it.hijos <= 2 && it.estrato <= 3 }
        assertEquals(28.6765, ejercicio11(personas, lista3.seleccionar { it.cedula }), 1e-4)
        println("Prueba superada 👍")
    }
}