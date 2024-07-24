package taller05

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * Pruebas de la clase Circulo
 */
class PruebaCirculo {
    @Test
    fun prueba() {
        var circ1 = Circulo(radio = 4.0)
        assertEquals(50.2655, circ1.area(), 1e-4)
        assertEquals(25.1327, circ1.longitudCircunferencia(), 1e-4)

        var circ2 = Circulo(12.5)
        assertEquals(490.8739, circ2.area(), 1e-4)
        assertEquals(78.5398, circ2.longitudCircunferencia(), 1e-4)

        println("Prueba Circulo superada 👍")
    }

}

//--------------------------------------------------------
/**
 * Pruebas de la clase Cuadrado
 */
class PruebaCuadrado {
    @Test
    fun pruebas() {
        val cuad = Cuadrado(lado = 5.0)
        assertEquals(25.0, cuad.area())
        assertEquals(7.0711, cuad.diagonal(), 1e-4)
        assertEquals(20.0, cuad.perimetro())

        val otro = Cuadrado(4.75)
        assertEquals(22.5625, otro.area(), 1e-4)
        assertEquals(6.7175, otro.diagonal(), 1e-4)
        assertEquals(19.0, otro.perimetro(), 1e-4)

        println("Prueba Cuadrado superada 🦾")
    }
}

//-------------------------------------------------------
/**
 * Pruebas de la clase Rectangulo
 */
class PruebaRectangulo {
    @Test
    fun pruebas() {
        val rect = Rectangulo(base = 3.0, altura = 4.0)
        assertEquals(12.0, rect.area())
        assertEquals(5.0, rect.diagonal())
        assertEquals(14.0, rect.perimetro())
        println("Rectangulo: Prueba superada 🦾")
    }
}

//--------------------------------------------------------
/**
 * Pruebas de la clase Triangulo
 */
class PruebaTriangulo() {
    @Test
    fun pruebas() {
        val tri = Triangulo(base = 3.0, altura = 4.0)
        assertEquals(6.0, tri.area())
        println("Prueba superada 🦾")
    }
}

//--------------------------------------------------------
/**
 * Pruebas de los diversos ejercicios
 */
internal class PruebasEjercicios {
    /**
     * Pruebas del ejercicio05
     */
    @Test
    fun pruebaEjercicio05() {
        assertEquals(37.699112, ejercicio05(2.0), 1e-6)
        assertEquals(697.0565, ejercicio05(8.6), 1e-4)
        assertEquals(1540.5386, ejercicio05(12.785), 1e-4)
        println("Ejercicio05: Prueba superada 😀")
    }

    /**
     * Pruebas del ejercicio 06
     */
    @Test
    fun pruebaEjercicio06() {
        assertEquals(550.0, ejercicio06(5.0))
        assertEquals(3017.24546, ejercicio06(11.711), 1e-4)
        assertEquals(541504.57996, ejercicio06(156.888), 1e-4)
        println("Ejercicio06: Prueba superada 😀")
    }

    /**
     * Prueba del ejercicio 07
     */
    @Test
    fun pruebaEjercicio07() {
        assertEquals(134.126147, ejercicio07(x = 25.0), 1e-6)
        assertEquals(6732.22827, ejercicio07(177.118), 1e-4)
        assertEquals(17960.3704, ejercicio07(289.295), 1e-4)
        println("Ejercicio07: Prueba superada 😀")
    }

    /**
     * Prueba del ejercicio 08
     */
    @Test
    fun pruebaEjercicio08() {
        val triangulo = Triangulo(base = 3.0, altura = 4.0)
        assertEquals(5.0, ejercicio08(triangulo))
        assertEquals(10.0, ejercicio08(Triangulo(8.0, 6.0)))
        assertEquals(100.62305, ejercicio08(Triangulo(45.0, 90.0)), 1e-4)
        println("Ejercicio08: Prueba superada 😀")
    }

    /**
     * Pruebas ejercicio 09
     */
    @Test
    fun pruebaEjercicio09() {
        assertEquals(15.81, ejercicio09(3.0, 4.0), 1e-2)
        assertEquals(63.269908, ejercicio09(8.0, 6.0), 1e-4)
        assertEquals(277.1946, ejercicio09(12.5, 16.8), 1e-4)
        println("Ejercicio09: Prueba superada 😀")
    }

    /**
     * Pruebas ejercicio 10
     */
    @Test
    fun pruebaEjercicio10() {
        assertEquals(114.1592653589793, ejercicio10(10.0), 1e-13)
        assertEquals(256.8583, ejercicio10(15.0), 1e-4)
        assertEquals(880.3653, ejercicio10(27.77), 1e-4)
        println("Ejercicio10: Prueba superada 😀")
    }

    /**
     * Pruebas ejercicio 11
     */
    @Test
    fun pruebaEjercicio11() {
        assertEquals(80.11, ejercicio11(10.0, 3.0), 1e-2)
        assertEquals(452.3893, ejercicio11(18.0, 12.0), 1e-4)
        assertEquals(628.3185, ejercicio11(25.0, 10.0), 1e-4)
        println("Ejercicio 11: Prueba superada 😀")
    }

    /**
     * Pruebas ejercicio 12
     */
    @Test
    fun pruebaEjercicio12() {
        assertEquals(72.0, ejercicio12(10.0, 6.0, 14.0))
        assertEquals(549.0, ejercicio12(25.0, 18.0, 36.0))
        assertEquals(603.0, ejercicio12(45.5, 10.0, 75.1))
        println("Ejercicio 12: Prueba superada 😀")
    }

    /**
     * Pruebas ejercicio 13
     */
    @Test
    fun pruebaEjercicio13() {
        assertEquals(13.0, ejercicio13(1.0, 2.0, 4.0, 6.0, 3.0))
        assertEquals(1260.0, ejercicio13(12.0, 20.0, 40.0, 60.0, 30.0))
        assertEquals(2250.0, ejercicio13(18.0, 25.0, 50.0, 85.0, 40.0))
        println("Ejercicio 13: Prueba superada 😀")
    }

    /**
     * Pruebas ejercicio 14
     */
    @Test
    fun pruebaEjercicio14() {
        assertEquals(3.56747, ejercicio14(5.0), 1e-5)
        assertEquals(92.79007, ejercicio14(25.5), 1e-5)
        assertEquals(234.06216, ejercicio14(40.5), 1e-5)
        println("Ejercicio14: Prueba superada 👍")
    }

    /**
     * Pruebas ejercicio 15
     */
    @Test
    fun pruebaEjercicio15() {
        assertEquals(18.0, ejercicio15(4.0, 3.0))
        assertEquals(72.0, ejercicio15(8.0, 6.0))
        assertEquals(1860.50152, ejercicio15(30.5, 40.6667), 1e-4)
        println("Ejercicio15: Prueba superada 👍")
    }

    /**
     * Pruebas ejercicio 16
     */
    @Test
    fun pruebaEjercicio16() {
        assertEquals(232.0, ejercicio16(4.0, 12.0))
        assertEquals(86.5, ejercicio16(5.0, 3.0))
        assertEquals(235.8361, ejercicio16(8.5, 4.31), 1e-4)
        println("Ejercicio16: Prueba superada 👍")
    }
}