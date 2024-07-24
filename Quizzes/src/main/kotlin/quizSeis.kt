data class Partido (val golesFavor: Int, val golesContra: Int, val nombreEquipoContrario: String){
    fun resultado(): String{
        return when{
            golesFavor > golesContra -> "GANÓ"
            golesFavor < golesContra -> "PERDIÓ"
            else -> "EMPATÓ"
        }
    }
    fun puntos(): Int{
        return when{
            resultado() == "GANÓ" -> 3
            resultado() == "PERDIÓ" -> 0
            else -> 1
        }
    }
}


class EquipoFutbol(var nombre:String){

    // clase nodo
    class NodoPartido(var info: Partido, var sig: NodoPartido? = null)

    // atributos
    var prim: NodoPartido? = null

    // metodos
    fun puntosTotales(): Int{
        if (prim == null){
            return 0
        }else{
            var p = prim
            var suma = 0
            while(p != null){
                suma += p.info.puntos()
                p = p.sig
            }
            return suma
        }

    }


    fun promedio(letra: Char): Double{
        var p = prim
        var contador = 0
        var suma = 0
        while (p != null){
            if(p.info.nombreEquipoContrario.startsWith(letra) && (p.info.resultado() == "GANÓ" || p.info.resultado() == "EMPATÓ")){
                suma += p.info.golesFavor
                contador++
            }
            p = p.sig
        }
        return suma.toDouble() / contador
    }
}