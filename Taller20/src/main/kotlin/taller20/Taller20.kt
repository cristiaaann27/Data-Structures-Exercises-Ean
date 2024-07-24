package taller20

/**
 * En el desarrollo de este ejercicio deber usarse las operaciones de
 * ORDEN SUPERIOR de eanlib (clase LISTA). No puede usarse las operaciones
 * de las clases MUTABLELIST o LIST o HASHMAP o alguna de las típicas de Kotlin
 * Procure abandonar el uso del for o el recorrer. Intente hacer todo
 * con solo funciones de orden superior.
 */

import ean.colecciones.*
import ean.pruebas.Departamento
import ean.pruebas.Municipio

// Esta clase guarda la información de un producto de una tienda
data class Producto(val codigo: Int, val nombre: String, val cantidad: Int, val precio: Int)

// Esta clase guarda la información de un rectángulo
data class Rectangulo(val base: Double, val altura: Double) {
    // Hallar el área del rectangulo
    fun area(): Double = base * altura
}

// Esta clase guarda la información de un triángulo
data class Triangulo(val id: Int,
                     val lado1: Double,
                     val lado2: Double,
                     val lado3: Double)

//-------------------------------------------------------------------
// Operaciones con la clase Departamento
//-------------------------------------------------------------------

/**
 * Obtener el nombre del departamento más antiguo de toda la lista.
 * Si la lista está vacía, retorne null
 */
fun metodo6(dptos: Lista<Departamento>): String? {
    return dptos.menorPor { it.añoCreacion }?.nombre
}

/**
 * Retorna el  departamento que tiene la superficie más grande
 * pero con una población superior a la población que se pasa
 * como parámetro.
 */
fun metodo7(dptos: Lista<Departamento>, poblacion: Int): Departamento? {
    return dptos.filtrar { it.poblacion > poblacion }.mayorPor { it.superficie }
}

/**
 * Retorne la lista de los nombres de los departamentos creados
 * en el siglo XX y que tenga un IDH entre 0.85 y 0.95
 */
fun metodo8(dptos: Lista<Departamento>): Lista<String> {
    return dptos.filtrar { it.añoCreacion in 1900..1999 && it.IDH in 0.85..0.95 }.seleccionar { it.nombre }
}

/**
 * Retorne el porcentaje de departamentos de la lista cuya densidad
 * esté por debajo del valor que se pasa como parámetro
 */
fun metodo9(deptos: Lista<Departamento>, valor: Double): Double {
    return deptos.filtrar { it.densidad < valor }.contar() * 100.0 / deptos.contar()
}

/**
 * Retorne el promedio de superficie de los departamentos de la lista
 * cuya poblacion sea superior a la población del departamento con menor
 * IDH de toda la lista
 */
fun metodo10(deptos: Lista<Departamento>): Double {
    return deptos.filtrar { it.poblacion > deptos.menorPor { it.IDH }!!.poblacion }.seleccionar { it.superficie }.promedio()
}

/**
 * Determinar la superficie total (la suma de las superficies)
 * de todos los departamentos que hacen
 * parte de la región que se pasa como parámetro
 */
fun metodo22(deptos: Lista<Departamento>, región: String): Double {
    return deptos.filtrar { it.región == región }.seleccionar { it.superficie }.sumar()
}

//-------------------------------------------------------------------
// Operaciones con la clase Municipio
//-------------------------------------------------------------------

/**
 * Determinar y retornar cuántos municipios de la lista son capitales
 */
fun metodo11(muns: Lista<Municipio>): Int {
    return muns.filtrar { it.esCapital }.contar()
}

/**
 * Determinar el nombre del municipio que no es capital y que pertenece al
 * departamento que se recibe como parámetro y que tiene la población urbana
 * más grande
 */
fun metodo12(m: Lista<Municipio>, depto: String): String {
    return m.filtrar { it.departamento == depto && !it.esCapital }.mayorPor { it.poblacionUrbana }!!.nombre
}

/**
 * Retornar el promedio de la población total (suma de la población rural y población urbana)
 * de aquellos municipios de la lista que pertenecen al departamento que se pasa
 * como parámetro y cuyo código sea múltiplo de 3 o de 5
 */
fun metodo13(municipios: Lista<Municipio>, departamento: String): Double {
    return municipios.filtrar { it.departamento == departamento && (it.codigo % 3 == 0 ||
            it.codigo % 5 == 0) }.promedioDeReales { it.poblacionRural.toDouble() + it.poblacionUrbana.toDouble() }
}


/**
 * Retorne el nombre del primer municipio que inicia con J en toda la lista
 */
fun metodo14(muns: Lista<Municipio>): String {
    return muns.encontrarPrimero { it.nombre.startsWith("J") }!!.nombre
}


/**
 * Retorne cuantos municipios de la lista que tienen un código
 * de 4 dígitos poseen una poblacion rural superior a la población
 * urbana
 */
fun metodo15(muns: Lista<Municipio>): Int {
    return muns.filtrar { it.codigo in 1000..9999 && it.poblacionRural > it.poblacionUrbana }.contar()
}

/**
 * Hallar el promedio de la población rural de aquellos municipios de
 * código par que pertenecen al departamento de menor población que hace
 * parte de la región que se pasa como parámetro
 */
fun metodo23(deptos: Lista<Departamento>, muns: Lista<Municipio>, región: String): Double {
    val deptoMenorPoblacion = deptos.filtrar { it.región == región }.menorPor { it.poblacion }!!.nombre
    return muns.filtrar { it.departamento == deptoMenorPoblacion && it.codigo % 2 == 0 }.seleccionar { it.poblacionRural }.promedio()
}

//-------------------------------------------------------------------
// Operaciones con la clase Producto
//-------------------------------------------------------------------

/**
 * Obtener el nombre de todos los productos cuyo código es par
 */
fun metodo1(productos: Lista<Producto>): Lista<String> {
    return productos.filtrar { it.codigo % 2 == 0 }.seleccionar {prod ->  prod.nombre}
}

/**
 * Obtener cuántos productos tienen un precio inferior al producto
 * cuyo código se pasa como parámetro
 */
fun metodo2(productos: Lista<Producto>, codProducto: Int): Int {
    val precioProd = productos.encontrarPrimero { it.codigo == codProducto }!!.precio
    return productos.filtrar { it.precio < precioProd }.contar()
}

/**
 * Obtener una lista con los códigos de los productos cuya cantidad sea
 * superior a la cantidad mínima que se pasa como parámetro y cuyo precio
 * esté entre mil y diez mil pesos.
 *
 */
fun metodo3(productos: Lista<Producto>, cantidadMinima: Int): Lista<Int> {
    return productos.filtrar { it.cantidad > cantidadMinima && it.precio in 1000..10000 }.seleccionar { it.codigo }
}

/**
 * EL inventario total de la lista es la suma de la multiplicación de la cantidad por el precio
 * de todos y cada uno de los productos de la lista. Este método permite saber si el
 * inventario de la lista es superior al millón de pesos o no.
 */
fun metodo4(prods: Lista<Producto>): Boolean {
    return prods.seleccionar { it.cantidad * it.precio }.sumar() > 1000000
}

/**
 * Obtener el promedio de la cantidad de aquellos productos cuyo precio
 * esté por debajo del promedio de precio de todos los productos de la lista
 */
fun metodo5(prods: Lista<Producto>): Double {
    return prods.filtrar { it.precio < prods.seleccionar { it.precio }.promedio() }.seleccionar { it.cantidad }.promedio()
}

//-------------------------------------------------------------------
// Operaciones con la clase Rectangulo
//-------------------------------------------------------------------

/**
 * Retorna el número de rectángulos que también son cuadrados
 */
fun metodo16(rects: Lista<Rectangulo>): Int {
    return rects.filtrar { it.base == it.altura }.contar()
}

/**
 * Obtiene el promedio del área de los rectángulos cuya base es inferior a su altura
 */
fun metodo17(rects: Lista<Rectangulo>): Double {
    return rects.filtrar { it.base < it.altura }.seleccionar { it.area() }.promedio()
}

/**
 * Obtiene el rectángulo de mayor área de la lsita
 */
fun metodo18(rects: Lista<Rectangulo>): Rectangulo {
    return rects.mayorPor { it.area() }!!
}

/**
 * Obtiene la lista con las diagonales de aquellos cuadrados cuya área sea
 * superior al área que se pasa como parámetros
 */
fun metodo19(rects: Lista<Rectangulo>, areaMin: Double): Lista<Double> {
    return rects.filtrar { it.base == it.altura && it.area() > areaMin }.seleccionar { hypot(it.base, it.altura) }
}

/**
 * Halla la hipotenusa del triángulo rectángulo que tiene los catetos a y b
 */
fun hypot(a: Double, b: Double): Double = Math.sqrt(a * a + b * b)

/**
 * Un triangulo es rectangulo si un lado (el mas largo) es igual a la raiz cuadrada de
 * la suma de los cuadrados de los otros dos lados. USE LA FUNCIÓN hypot DESARROLLADA
 * ANTERIORMENTE.
 */
fun esRectangulo(t: Triangulo): Boolean {
    val lados = crearLista(t.lado1, t.lado2, t.lado3)
    val mayor = lados.mayor()

    return mayor == hypot(lados.filtrar { it != mayor }.primero, lados.filtrar { it != mayor }.ultimo)
}


/**
 * Hallar el área del triángulo que se pasa como parámetro
 */
fun areaTriangulo(t: Triangulo): Double {
    val s = (t.lado1 + t.lado2 + t.lado3) / 2
    return Math.sqrt(s * (s - t.lado1) * (s - t.lado2) * (s - t.lado3))
}

/**
 * Retorna la lista de las áreas de aquellos triángulos rectángulos de la lista
 */
fun metodo20(triangulos: Lista<Triangulo>): Lista<Double> {
    return triangulos.filtrar { esRectangulo(it) }.seleccionar { areaTriangulo(it) }
}

/**
 * Obtiene la lista de los identificadores de aquellos triángulos isosceles cuya área no supera a 10
 */
fun metodo21(triangulos: Lista<Triangulo>): Lista<Int> {
    return triangulos.filtrar { it.lado1 == it.lado2 || it.lado1 == it.lado3 || it.lado2 == it.lado3 && areaTriangulo(it) <= 10 }.seleccionar { it.id }
}