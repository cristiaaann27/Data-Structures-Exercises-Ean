package taller15

import ean.colecciones.*
import ean.pruebas.Perro
import ean.pruebas.Persona
import ean.pruebas.Producto
import ean.utils.*
import ean.utils.max2
import kotlin.math.max


/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad EAN (Bogotá - Colombia)
 * Departamento de Tecnología de la Información y Comunicaciones
 * Faculta de Ingeniería
 *
 * Taller Árboles Binarios
 * Fecha: 17 de octubre de 2023
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */


//---------------------------------------------------------------------------------
/**
 *   Calcular el peso de un árbol binario
 */
fun <T> peso(a: Arbin<T>): Int {
    fun peso(nodo: NodoArbin<T>?): Int {
        if (nodo == null) {
            return 0
        } else {
            return 1 + peso(nodo.izq) + peso(nodo.der)
        }
    }
    // ----- Función Principal ----
    return peso(a.raiz)
}

/**
 * Permite obtener la altura de un árbol binario
 */
fun <T> alturaArbol(a: Arbin<T>): Int {
    fun alturaNodo(nodo: NodoArbin<T>?): Int {
        if (nodo == null) {
            return 0
        } else {
            return 1 + max(alturaNodo(nodo.izq), alturaNodo(nodo.der))
        }
    }

    //-------------------------------
    return alturaNodo(a.raiz)
}

/**
 * Determina si un elemento pertenece al arbol a o no
 */
fun <T> estaEnElArbol(a: Arbin<T>, elem: T): Boolean {
    fun estaEnElArbol(nodo: NodoArbin<T>?, elem: T): Boolean {
        if (nodo == null) {
            return false
        } else {
            return nodo.info == elem || estaEnElArbol(nodo.izq, elem) || estaEnElArbol(nodo.der, elem)
        }
    }

    //------------------
    return estaEnElArbol(a.raiz, elem)
}

/**
 * Dado un árbol con letras en mayúsculas, indique cuántas
 * de esas letras del árbol son vocales
 */
fun contarVocales(arbol: Arbin<String>): Int {
    fun contarVocalesNodo(nodo: NodoArbin<String>?): Int {
        if (nodo == null) {
            return 0
        } else {
            val letra = nodo.info
            val esVocal = letra == "A" || letra == "E" || letra == "I" || letra == "O" || letra == "U"
            return if (esVocal) {
                1 + contarVocalesNodo(nodo.izq) + contarVocalesNodo(nodo.der)
            } else {
                contarVocalesNodo(nodo.izq) + contarVocalesNodo(nodo.der)
            }
        }
    }
    //-----------------------
    return contarVocalesNodo(arbol.raiz)
}

/**
 * Permite determinar cuantos elementos en el árbol son de dos dígitos y la suma de ambos dígitos es 7
 */
fun contarArbol(a: Arbin<Int>): Int {
    fun contarArbolNodo(nodo: NodoArbin<Int>?): Int {
        if (nodo == null) {
            return 0
        } else {
            val esDosDigitos = nodo.info >= 10 && nodo.info <= 99
            val sumaDigitos = (nodo.info / 10) + (nodo.info % 10)
            val sumaDigitosSiete = sumaDigitos == 7
            return if (esDosDigitos && sumaDigitosSiete) {
                1 + contarArbolNodo(nodo.izq) + contarArbolNodo(nodo.der)
            } else {
                contarArbolNodo(nodo.izq) + contarArbolNodo(nodo.der)
            }
        }
    }
    //-----------------------
    return contarArbolNodo(a.raiz)
}

/**
 * Determine cuántos productos del árbol tienen una cantidad impar y el nombre termina en vocal en minúsculas
 */
fun contarProductos(a: Arbin<Producto>): Int {
    fun contarProductosNodo(nodo: NodoArbin<Producto>?): Int {
        if (nodo == null) {
            return 0
        } else {
            val esCantidadImpar = nodo.info.cantidad % 2 == 1
            val nombre = nodo.info.nombre
            val terminaVocal =
                nombre.endsWith("a") || nombre.endsWith("e") || nombre.endsWith("i") || nombre.endsWith("o") || nombre.endsWith(
                    "u"
                )
            return if (esCantidadImpar && terminaVocal) {
                1 + contarProductosNodo(nodo.izq) + contarProductosNodo(nodo.der)
            } else {
                contarProductosNodo(nodo.izq) + contarProductosNodo(nodo.der)
            }
        }
    }
    //-----------------------
    return contarProductosNodo(a.raiz)
}

/**
 * Determine cuántas personas del árbol tienen usan lentes y tienen una cédula múltiplo de seis
 */
fun contarPersonasConLentesCedulaMultiploSeis(arbolPersonas: Arbin<Persona>): Int {
    fun contarPersonasConLentesCedulaMultiploSeisNodo(nodo: NodoArbin<Persona>?): Int {
        if (nodo == null) {
            return 0
        } else {
            val usaLentes = nodo.info.tieneLentes
            val cedula = nodo.info.cedula
            val cedulaMultiploSeis = cedula % 6 == 0
            return if (usaLentes && cedulaMultiploSeis) {
                1 + contarPersonasConLentesCedulaMultiploSeisNodo(nodo.izq) + contarPersonasConLentesCedulaMultiploSeisNodo(
                    nodo.der
                )
            } else {
                contarPersonasConLentesCedulaMultiploSeisNodo(nodo.izq) + contarPersonasConLentesCedulaMultiploSeisNodo(
                    nodo.der
                )
            }
        }
    }
    //-----------------------
    return contarPersonasConLentesCedulaMultiploSeisNodo(arbolPersonas.raiz)
}

/**
 * En el árbol de personas, hay 3 estratos, retornar el estrato con la
 * mayor cantidad de mujeres sin hijos
 */
fun estratoMayorCantidadMujeresSinHijos(ap: Arbin<Persona>): Int {
    // Obtiene cuántas mujeres sin hijos viven en el estrato dado
    fun mujeresSinHijoEstrato(nodo: NodoArbin<Persona>?, estrato: Int): Int {
        if (nodo == null) {
            return 0
        } else {
            val esMujer = nodo.info.genero == "F"
            val noTieneHijos = nodo.info.hijos == 0
            val viveEnEstrato = nodo.info.estrato == estrato
            return if (esMujer && noTieneHijos && viveEnEstrato) {
                1 + mujeresSinHijoEstrato(nodo.izq, estrato) + mujeresSinHijoEstrato(nodo.der, estrato)
            } else {
                mujeresSinHijoEstrato(nodo.izq, estrato) + mujeresSinHijoEstrato(nodo.der, estrato)
            }
        }
    }

    // ------------- Hay que hallar el mejor de los 3 estratos
    val estrato1 = mujeresSinHijoEstrato(ap.raiz, 1)
    val estrato2 = mujeresSinHijoEstrato(ap.raiz, 2)
    val estrato3 = mujeresSinHijoEstrato(ap.raiz, 3)
    return when {
        estrato1 > estrato2 && estrato1 > estrato3 -> 1
        estrato2 > estrato1 && estrato2 > estrato3 -> 2
        else -> 3
    }
}

/**
 * Obtener una lista con los nombres de los perros
 * que pertenecen a la raza que se pasa como parámetro
 */
fun perrosRaza(perros: Arbin<Perro>, raza: String): Lista<String> {
    fun perrosRazaNodo(nodo: NodoArbin<Perro>?, raza: String): Lista<String> {
        if (nodo == null) {
            return listaVacia()
        }
        val razaIzq = perrosRazaNodo(nodo.izq, raza)
        val razaDer = perrosRazaNodo(nodo.der, raza)
        val resultado = Listas.concatenar(razaIzq, razaDer)
        if (nodo.info.raza == raza) {
            resultado.agregarAlFinal(nodo.info.nombre)
        }
        return resultado
    }

    // ------- Función Principal ---------
    return perrosRazaNodo(perros.raiz, raza)
}

/**
 * Encuentra el porcentaje de perros cuya edad es menor a la edad que
 * se pasa como parámetro.
 */
fun porcetajePerrosMenoresEdad(perros: Arbin<Perro>, edad: Int): Double {
    fun porcetajePerrosMenoresEdadNodo(nodo: NodoArbin<Perro>?, edad: Int): Double {
        if (nodo == null) {
            return 0.0
        } else {
            val esMenorEdad = nodo.info.edad < edad
            return if (esMenorEdad) {
                1.0 + porcetajePerrosMenoresEdadNodo(nodo.izq, edad) + porcetajePerrosMenoresEdadNodo(nodo.der, edad)
            } else {
                porcetajePerrosMenoresEdadNodo(nodo.izq, edad) + porcetajePerrosMenoresEdadNodo(nodo.der, edad)
            }
        }
    }

    // ----- Función Principal -----
    val totalPerros = peso(perros)
    val totalPerrosMenoresEdad = porcetajePerrosMenoresEdadNodo(perros.raiz, edad)
    return totalPerrosMenoresEdad * 100 / totalPerros
}

/**
 * Encuentre el porcentaje de todas las personas del árbol  cuya educación sea "PRIMARIA"
 * y cuya altura esté por encima de 160 y por debajo del número que se pasa como parámetro
 */
fun porcentaPersonasPrimaria(a: Arbin<Persona>, altura: Int): Double {
    fun porcentaPersonasPrimariaNodo(nodo: NodoArbin<Persona>?, altura: Int): Double {
        if (nodo == null) {
            return 0.0
        } else {
            val esPrimaria = nodo.info.nivelEducativo == "PRIMARIA"
            val alturaPersona = nodo.info.altura
            val estaEntreAlturas = alturaPersona >= 160 && alturaPersona <= altura
            return if (esPrimaria && estaEntreAlturas) {
                1.0 + porcentaPersonasPrimariaNodo(nodo.izq, altura) + porcentaPersonasPrimariaNodo(nodo.der, altura)
            } else {
                porcentaPersonasPrimariaNodo(nodo.izq, altura) + porcentaPersonasPrimariaNodo(nodo.der, altura)
            }
        }
    }


    // ----- Función Principal -----
    val totalPersonas = peso(a)
    val totalPersonasPrimaria = porcentaPersonasPrimariaNodo(a.raiz, altura)
    return totalPersonasPrimaria * 100 / totalPersonas
}

/**
 * Hallar el promedio de edad de las personas que tienen un ingreso inferior
 * al número que se pasa como parámetro, tenga menos de 2 hijos y tenga casa
 */
fun promedioEdadPersonasIngreso(personas: Arbin<Persona>, sueldo: Int): Double {
    fun promedioEdadPersonasIngresoNodo(nodo: NodoArbin<Persona>?, sueldo: Int): Double {
        if (nodo == null) {
            return 0.0
        } else {
            val ingreso = nodo.info.ingresos
            val tieneMenosDosHijos = nodo.info.hijos < 2
            val tieneCasa = nodo.info.tieneCasa
            return if (ingreso < sueldo && tieneMenosDosHijos && tieneCasa) {
                nodo.info.edad.toDouble() + promedioEdadPersonasIngresoNodo(
                    nodo.izq,
                    sueldo
                ) + promedioEdadPersonasIngresoNodo(nodo.der, sueldo)
            } else {
                promedioEdadPersonasIngresoNodo(nodo.izq, sueldo) + promedioEdadPersonasIngresoNodo(nodo.der, sueldo)
            }
        }
    }

    fun cantidadPersonasIngresoNodo(nodo: NodoArbin<Persona>?, sueldo: Int): Int {
        if (nodo == null) {
            return 0
        } else {
            val ingreso = nodo.info.ingresos
            val tieneMenosDosHijos = nodo.info.hijos < 2
            val tieneCasa = nodo.info.tieneCasa
            return if (ingreso < sueldo && tieneMenosDosHijos && tieneCasa) {
                1 + cantidadPersonasIngresoNodo(nodo.izq, sueldo) + cantidadPersonasIngresoNodo(nodo.der, sueldo)
            } else {
                cantidadPersonasIngresoNodo(nodo.izq, sueldo) + cantidadPersonasIngresoNodo(nodo.der, sueldo)
            }
        }
    }


    // ----- Función Principal -----
    val totalEdades = promedioEdadPersonasIngresoNodo(personas.raiz, sueldo)
    val totalPersonas = cantidadPersonasIngresoNodo(personas.raiz, sueldo)
    return totalEdades / totalPersonas
}

/**
 * Obtener la lista de los nombres de los productos que tienen un precio inferior
 * al promedio de los precios de todos los productos del árbol
 */
fun nombresProdsPrecioInfProm(productos: Arbin<Producto>): Lista<String> {
    fun promedioPrecioProductos(nodo: NodoArbin<Producto>?): Double {
        if (nodo == null) {
            return 0.0
        } else {
            val precio = nodo.info.precio
            return precio + promedioPrecioProductos(nodo.izq) + promedioPrecioProductos(nodo.der)
        }
    }

    fun listaNombresPreciosInfProm(nodo: NodoArbin<Producto>?, prom: Double): Lista<String> {
        if (nodo == null) {
            return listaVacia()
        }
        val precio = nodo.info.precio
        val esMenorProm = precio < prom
        val nombre = nodo.info.nombre
        val listaIzq = listaNombresPreciosInfProm(nodo.izq, prom)
        val listaDer = listaNombresPreciosInfProm(nodo.der, prom)
        val resultado = Listas.concatenar(listaIzq, listaDer)
        if (esMenorProm) {
            resultado.agregarAlFinal(nombre)
        }
        return resultado
    }

// ----- Función Principal -----
    val prom = promedioPrecioProductos(productos.raiz)
    val lista = listaNombresPreciosInfProm(productos.raiz, (prom / productos.peso))
    return lista
}

/**
 * Obtiene la lista del recorrido en inorden del árbol que se pase
 * como parámetro
 */
fun <T> preorden(arbol: Arbin<T>): Lista<T> {
    fun preorden(nodo: NodoArbin<T>?): Lista<T> {
        if (nodo == null) {
            return listaVacia()
        }
        val preIzq = preorden(nodo.izq)
        val preDer = preorden(nodo.der)
        val laRaiz = nodo.info
        val resultado = Listas.concatenar(crearLista(laRaiz), preIzq, preDer)
        return resultado
    }

    // ---- Función principal -----
    return preorden(arbol.raiz)
}


/**
 * Obtiene la lista del recorrido en inorden del árbol que se pase
 * como parámetro
 */
fun <T> inorden(arbol: Arbin<T>): Lista<T> {
    fun inorden(nodo: NodoArbin<T>?): Lista<T> {
        if (nodo == null) {
            return listaVacia()
        }
        val inIzq = inorden(nodo.izq)
        val inDer = inorden(nodo.der)
        val laRaiz = nodo.info
        val resultado = Listas.concatenar(inIzq, crearLista(laRaiz), inDer)
        return resultado
    }

    // ------- Proyecto Final ------
    return inorden(arbol.raiz)
}

/**
 * Obtiene la lista del recorrido en postorden del árbol que se pase
 * como parámetro
 */
fun <T> postorden(arbol: Arbin<T>): Lista<T> {
    fun postorden(nodo: NodoArbin<T>?): Lista<T> {
        if (nodo == null) {
            return listaVacia()
        }
        val postIzq = postorden(nodo.izq)
        val postDer = postorden(nodo.der)
        val laRaiz = nodo.info
        val resultado = Listas.concatenar(postIzq, postDer, crearLista(laRaiz))
        return resultado
    }
    // ------ Función Principal ------
    return postorden(arbol.raiz)
}

/**
 * Encontrar el precio del producto que tiene el nombre dado.
 * Si el árbol está vacío, retorne null.
 */
fun encontrarProducto(productos: Arbin<Producto>, nombre: String): Double? {
    fun encontrarProductoNodos(nodo: NodoArbin<Producto>?, nombre: String): Producto? {
        if (nodo == null) {
            return null
        } else {
            val esProducto = nodo.info.nombre == nombre
            val nozoIzq = encontrarProductoNodos(nodo.izq, nombre)
            val nodoDer = encontrarProductoNodos(nodo.der, nombre)
            return if (esProducto) {
                nodo.info
            } else if (nozoIzq != null) {
                nozoIzq
            } else {
                nodoDer
            }
        }
    }

    // ----- Función principal -----
    return encontrarProductoNodos(productos.raiz, nombre)?.precio
}

/**
 * De las tres cédulas que se reciben como parámetro, retornar 1 si la
 * primera persona es la más joven de las 3, 2 si la segunda persona es
 * la más joven de la 3 y 3 si es la tercera persona la más joven.
 */
fun personaMasJovenDeTres(personas: Arbin<Persona>, ced1: Int, ced2: Int, ced3: Int): Int? {
    // Encuentra la persona que tiene la cédula dada. Si el arbol está vacío, retorne ull
    fun encontrarPersona(nodo: NodoArbin<Persona>?, cedula: Int): Persona? {
        if (nodo == null) {
            return null
        }
        val esPersona = nodo.info.cedula == cedula
        val nodoIzq = encontrarPersona(nodo.izq, cedula)
        val nodoDer = encontrarPersona(nodo.der, cedula)
        return if (esPersona) {
            nodo.info
        } else if (nodoIzq != null) {
            nodoIzq
        } else {
            nodoDer
        }
    }


// Encontrar el menor de las 3 personas
    val primeraPersona = encontrarPersona(personas.raiz, ced1)
    val segundaPersona = encontrarPersona(personas.raiz, ced2)
    val terceraPersona = encontrarPersona(personas.raiz, ced3)
    return when {
        primeraPersona!!.edad < segundaPersona!!.edad && primeraPersona.edad < terceraPersona!!.edad -> 1
        segundaPersona.edad < primeraPersona.edad && segundaPersona.edad < terceraPersona!!.edad -> 2
        else -> 3
    }
}

/**
 * Encuentra a la persona más joven del árbol que pertenece al estrato dado
 */
fun personaMasJovenDeEstrato(personas: Arbin<Persona>, estrato: Int): Persona? {
    /**
     * Encuentra la persona más joven de los nodos que pertenece al estrato dado
     * Retorna null si el árbol es vacío
     */
    fun personaMasJovenEstrato(nodo: NodoArbin<Persona>?, estrato: Int): Persona? {
        if (nodo == null) {
            return null
        }
        val masJovenIzq = personaMasJovenEstrato(nodo.izq, estrato)
        val masJovenDer = personaMasJovenEstrato(nodo.der, estrato)
        val laRaiz = nodo.info
        if (laRaiz.estrato == estrato) {
            return min3(laRaiz, masJovenIzq, masJovenDer, Persona::edad)
        }
        return min2(masJovenIzq, masJovenDer, Persona::edad)

    }
    // ------ Función Principal -----
    return personaMasJovenEstrato(personas.raiz, estrato)
}