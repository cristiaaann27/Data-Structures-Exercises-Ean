/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad EAN (Bogotá - Colombia)
 * Departamento de Tecnología - Facultad de Ingeniería
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Ejercicio: Geometría
 * Autor: Universidad EAN
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package taller05

import kotlin.math.PI
import kotlin.math.sqrt


/**
 * Ejercicio 5
 */
fun ejercicio05(r: Double): Double {
    val circuloPequeno = Circulo(r)
    val circuloGrande = Circulo(2 * r)
    return circuloGrande.area() - circuloPequeno.area()
}

/**
 * Ejercicio 6
 */
fun ejercicio06(u: Double): Double {
    val trianguloUno = Triangulo(3*u, 4*u)
    val cuadradoUno = Cuadrado(2*u)
    val rectanguloUno = Rectangulo(3*u, 4*u)
    val area = trianguloUno.area() + cuadradoUno.area() + rectanguloUno.area()
    return area
}

/**
 * Ejercicio 07
 */
fun ejercicio07(x: Double): Double {
    val cuadradoUno = Cuadrado(x)
    val circuloUno = Circulo(x/2)
    val areaSombreada = cuadradoUno.area() - circuloUno.area()
    return areaSombreada

}

/**
 * Ejercicio 08 - Hipotenusa
 */
fun ejercicio08(tri: Triangulo): Double {
    val rectanguloUno = Rectangulo(tri.base, tri.altura)
    return rectanguloUno.diagonal()
}

/**
 * Ejercicio 09
 */
fun ejercicio09(a: Double, b: Double): Double {
    val trianguloUno = Triangulo(b, a)
    val hipotenusa = ejercicio08(trianguloUno)
    val circuloUno = Circulo(hipotenusa/2)
    val area = (trianguloUno.area()) +(circuloUno.area()/2)
    return area


}

/**
 * Ejercicio 10
 */
fun ejercicio10(r: Double): Double {
    val circuloUno = Circulo(r)
    val ladoCuadrado = (r*2)/sqrt(2.0)
    val cuadradoUno = Cuadrado(ladoCuadrado)
    val area = circuloUno.area() - cuadradoUno.area()
    return area




}

/**
 * Ejercicio 11
 */
fun ejercicio11(r: Double, a: Double): Double {
    val circuloUno = Circulo(r)
    val circuloDos = Circulo(r-a)
    val area = (circuloUno.area()/2 - circuloDos.area()/2)
    return area


}

/**
 * Ejercicio 12
 */
fun ejercicio12(x: Double, y: Double, z: Double): Double {
    val trianguloUno = Triangulo(y,(z-x))
    val rectanguloUno = Rectangulo(y, x)
    val area = trianguloUno.area() + rectanguloUno.area()
    return area
}

/**
 * Ejercicio 13
 */
fun ejercicio13(a: Double, b: Double, c: Double, d: Double, e: Double): Double {
    val rectaguloUno = Rectangulo(e, c)
    val rectanguloDos = Rectangulo(a, b)
    val trianguloUno = Triangulo((e/2), (d-c))
    val area = ((trianguloUno.area() * 2)+ rectaguloUno.area()) - rectanguloDos.area()
    return area
}

/**
 * Ejercicio 14
 */
fun ejercicio14(l: Double): Double {
    val trianguloUno = TrianguloIsoscelesRectangulo(l)
    val radio = trianguloUno.cateto()
    val circuloUno = Circulo(radio)
    val area = (circuloUno.area() / 4) - (trianguloUno.area())
    return area
}

/**
 * Ejercicio 15
 */
fun ejercicio15(x: Double, y: Double): Double {
    val triaguloUno = Triangulo(x,y)
    val trianguloDos = Triangulo(2*x, 2*y)
    val area = trianguloDos.area() - triaguloUno.area()
    return area
}

/**
 * Ejercicio 16
 */
fun ejercicio16(a: Double, b: Double): Double {
    val rectanguloUno = Rectangulo(a, 2*a)
    val rectanguloDos = Rectangulo(b,a)
    val cuadradoUno = Cuadrado(b)
    val trianguloUno = Triangulo(a,a)
    val area = rectanguloUno.area() + rectanguloDos.area() + cuadradoUno.area() + trianguloUno.area()
    return area
}
