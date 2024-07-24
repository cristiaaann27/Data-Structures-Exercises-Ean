package Quizzes
import kotlin.math.ln


data class Perro(val nombre: String, val añoNacimiento: Int, val esGrande: Boolean, val raza: String, val esMacho: Boolean, val peso: Int){
    fun edadCronológica(): Int{
        return 2023 -  this.añoNacimiento
    }
    fun edadBiológica(): Int{
        val edadCronológica = (this.edadCronológica()).toDouble()
        if(esMacho){
            return (10 * (ln(edadCronológica)) + 31).toInt()
        }else{
            return (16 * (ln(edadCronológica)) + 17).toInt()
        }
    }
}

class TiendaDeMascotas(val nombre: String){

    var perros: Lista<Perro> = listaVacia()

    fun metodo1(raza:String): Int{
        var contador = 0
        for (i in 0 ..< perros.tam){
            val p = perros[i]
            if  (p.raza == raza && p.edadBiológica() >= 20 && p.esMacho && p.esGrande){
                contador++
            }
        }
        return contador
    }
    fun metodo2(edad:Int): Int{
        for (i in 0..<perros.tam) {
            val p = perros[i]
            if (p.edadBiológica() == edad && p.esMacho && p.esGrande && p.nombre != "Firulais" && p.nombre != "Satori") {
                return p.peso
            }
        }
        return -1
    }

}