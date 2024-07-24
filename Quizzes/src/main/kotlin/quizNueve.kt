import kotlin.math.pow
fun sumatoriaQuiz(n: Int): Double = if (n == 1) (1.0/2) else (((n - 1.0)/(n + 1.0)) + ((2.0 * n.toDouble().pow(2)) / (n.toDouble().pow(2) + (2*n) +1))) + sumatoriaQuiz(n - 1)