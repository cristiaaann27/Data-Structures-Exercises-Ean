package taller05

import kotlin.math.sqrt

class TrianguloIsoscelesRectangulo(val hipotenusa: Double) {
    fun cateto(): Double {
        return hipotenusa / sqrt(2.0)
    }
    fun area(): Double {
        return (cateto() * cateto()) / 2
    }
    fun perimetro(): Double {
        return hipotenusa + (cateto() * 2)

    }
}