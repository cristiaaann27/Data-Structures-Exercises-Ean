fun pivotearPila(pila: Pila<Int>): Pila<Int>{
    val copia = pila.copiar()
    val tempPares = pilaVacia<Int>()
    val pilaOrdenada = pilaVacia<Int>
    while (!copia.vacia()) {
        val num = copia.desapilar()
        if (num % 2 != 0){
            pilaOrdenada.apilar(num)
        }
        else{
            tempPares.apilar(num)
        }

    }
    while (!tempPares.vacia()){
        pilaOrdenada.apilar(tempPares.desapilar())
    }
    return pilaOrdenada
}