fun areaTerreno(c: Double): Double {
    val areaCuadrado:Double = c*c
    val areaTotal:Double = areaCuadrado * 7
    return areaTotal
}
fun ventaPlatos(cantidadPlatosCorrientes: Int, cantidadPlatosEjecutivos: Int): Int {
    val ventaPlatosCorrientes:Int = cantidadPlatosCorrientes * 11000
    val ventaPlatosEjecutivos:Int = cantidadPlatosEjecutivos * 20000
    val total:Int = ventaPlatosCorrientes + ventaPlatosEjecutivos
    return total
}