import java.lang.Math.toRadians
import kotlin.math.acos
import kotlin.math.cos
import kotlin.math.sin

/*
Ejercicio 2: Distancia entre dos puntos en la tierra
 */

fun distanciaPuntosTierra(x1: Double, y1: Double, x2: Double, y2: Double): Double {
    val t1 = toRadians(x1)
    val g1 = toRadians(y1)
    val t2 = toRadians(x2)
    val g2 = toRadians(y2)
    return 6371.01 * acos(sin(t1) * sin(t2) + cos(t1) * cos(t2) * cos(g1 - g2))
}