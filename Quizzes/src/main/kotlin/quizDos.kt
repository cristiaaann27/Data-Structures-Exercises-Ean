class Rectángulo (val b: Double, val h: Double){

    fun hallarÁrea(): Double{
        return b*h
    }

}

class Trapecio (val baseMayor: Double, val baseMenor: Double, val altura: Double){

    fun hallarÁrea(): Double{
        return ((baseMayor + baseMenor) / 2) * altura
    }

}

fun ejercicio03(u: Double, w: Double, x: Double, y: Double, z: Double): Double{
    val rectánguloUno = Rectángulo(z, y)
    val rectánguloDos = Rectángulo(u, u)
    val trapecioUno = Trapecio(w, u, (x-y-u))
    val area = rectánguloUno.hallarÁrea() + rectánguloDos.hallarÁrea() + trapecioUno.hallarÁrea()
    return area
}