class Curso(val nombre: String, val primerCorte: Double, val segundoCorte: Double, val ciclo: Boolean) {
    fun darNotaDefinitiva(): Double {
        if (this.ciclo == true) {
            return (this.primerCorte * 0.4) + (this.segundoCorte * 0.6)
        } else {
            return (this.primerCorte * 0.6) + (this.segundoCorte * 0.4)
        }
    }

    fun aprobóElCurso(postgrado: Boolean): String {
        if (postgrado == true) {
            if (this.darNotaDefinitiva() >= 75.0) {
                return "PASÓ"
            } else {
                return "NO PASÓ"
            }
        } else {
            if (this.darNotaDefinitiva() >= 60.0) {
                return "PASÓ"
            } else {
                return "NO PASÓ"
            }
        }
    }
}

class Estudiante(
    val cedula: Int,
    val nombres: String,
    val primerCurso: Curso,
    val segundoCurso: Curso,
    val tercerCurso: Curso
) {
    fun pasóTodosLosCursos(): Boolean {
        var bandera = false
        if ((primerCurso.aprobóElCurso(false) == "PASÓ") && (segundoCurso.aprobóElCurso(false) == "PASÓ") && (tercerCurso.aprobóElCurso(
                false
            ) == "PASÓ")
        ) {
            bandera = true
        }

        return bandera
    }
}