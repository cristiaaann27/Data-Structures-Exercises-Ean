/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad EAN (Bogotá - Colombia)
 * Unidad de Estudios: Estructura de Datos
 * Faculta de Ingeniería
 *
 * Proyecto Banco
 * Autor: Universidad Ean - Facultad de Ingeniería
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package taller19

import ean.colecciones.Diccionario
import ean.colecciones.Lista
import ean.colecciones.diccionarioVacio
import ean.colecciones.listaVacia
import ean.utils.Listas

/**
 * Un Banco que maneja los clientes que tienen cuentas dentro de
 * la empresa.
 */
class Banco() {

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Diccionario con los diversos clientes del banco.
     * La llave del diccionario es la cédula del cliente
     */
    private val clientes: Diccionario<Int, Cliente> = diccionarioVacio()

    // -----------------------------------------------------------------
    // Metodos
    // -----------------------------------------------------------------

    /**
     * Permite obtener el número de clientes que hay en el banco
     */
    fun darCantidadClientes(): Int {
        return clientes.tam
    }

    /**
     * Método para agregar un cliente al Banco
     * No pueden haber dos clientes con la misma cédula. Si el cliente ya
     * existe, se retorna false.
     * Si no existe la cédula del cliente, se crea el objeto Cliente con
     * los datos de entrada, y se agrega el nuevo cliente al diccionario.
     * Tenga en cuenta que la llave es la cédula y que NO PUEDE USAR
     * UN FOR PARA SABER SI EXISTE EL CLIENTE CON CEDULA
     */
    fun abrirCuenta(cedula: Int, edad: Int, deAhorros: Boolean): Boolean {
        if (clientes.buscar(cedula) == null) {
            clientes.agregar(cedula, Cliente(cedula, edad, deAhorros))
            return true
        }
        else{
            return false
        }
    }

    /**
     * Permite obtener la información del cliente que tiene la cédula
     * NO PUEDE HABER UN FOR para encontrar el cliente!
     * Si no hay un cliente con esa cédula, se retorna null
     */
    fun darCliente(cedula: Int): Cliente? {
        return clientes.buscar(cedula)
    }

    /**
     * Obtiene el saldo de la cuenta del cliente que tiene
     * la cédula dada.
     * PROHIBIDO USAR UN FOR NI UN RECORRER EN ESTA FUNCION
     * Prerrequisito: La cédula existe en el banco
     */
    fun darSaldoCliente(cedula: Int): Int {
        return clientes.buscar(cedula)!!.darSaldo()
    }

    /**
     * Deposita un dinero en la cuenta del cliente con la cedula dada.
     * Si no existe un cliente con esa cédula se debe retornar false
     * Debe tener las consideraciones establecidas en el enunciado
     * de retirar de la clase Cliente. Se retorna true si se pudo
     * hacer el depósito y false si no fue posible.
     */
    fun depositarDineroCuentaCliente(cedulaCliente: Int, dinero: Int): Boolean {
        return clientes.buscar(cedulaCliente)!!.depositar(dinero)
    }

    /**
     * Retira un dinero de la cuenta del cliente con la cédula dada
     * OJO: Si no existe el cliente con cédula dada, se retorna false
     * Debe usarse el método retirar de la clase Cliente.
     * NO PUEDE USAR UN FOR NI UN RECORRER EN ESTE MÉTODO
     */
    fun retirarDineroCuentaCliente(cedulaCliente: Int, dinero: Int): Boolean {
        return clientes.buscar(cedulaCliente)!!.retirar(dinero)
    }

    /**
     * Esta operación transfiere dinero de una cuenta de origen a una cuenta de destino.
     * Una transferencia consiste en retirar dinero del origen y depositarlo en el destino.
     * A tener en cuenta: se debe retornar false y no debe haber cambio en los saldos de
     * las cuentas si ocurre alguna de los siguientes casos
     * - los clientes de origen o de destino no existen
     * - El dinero es cero o negativo
     * - Si la cuenta de origen es de ahorros y el saldo no es suficiente para
     *   retirar el dinero
     * En cualquier otro caso se debe hacer la transferencia y retornar true
     */
    fun transferirDineroEntreClientes(clienteOrigen: Int, clienteDestino: Int, dinero: Int): Boolean {
        if (clientes.buscar(clienteOrigen) == null || clientes.buscar(clienteDestino) == null || dinero <= 0) {
            return false
        }
        if (clientes.buscar(clienteOrigen)!!.deAhorros && clientes.buscar(clienteOrigen)!!.darSaldo() < dinero) {
            return false
        }
        clientes.buscar(clienteOrigen)!!.retirar(dinero)
        clientes.buscar(clienteDestino)!!.depositar(dinero)
        return true
    }

    /**
     * Obtener la lista de las cedulas de aquellos
     * clientes que tengan cuentas de ahorros con
     * algún dinero en la cuenta.
     */
    fun cuentasAhorroSaldoPositivo(): Lista<Int> {
        val lista = listaVacia<Int>()
        for (i in 0 until clientes.tam) {
            if (clientes[i]!!.deAhorros && clientes[i]!!.darSaldo() > 0) {
                lista.agregarAlFinal(clientes[i]!!.cedula)
            }
        }
        return lista
    }

    /**
     * Obtiene el cliente que tiene una cuenta del tipo dado con
     * el saldo más grande. tipo puede ser "CORRIENTE" para cuentas
     * corrientes y "AHORROS" para cuenta de ahorros. Debe retornarse
     * null si no hay cuenta en el banco con el tipo dado.
     */
    fun cuentaConMayorSaldo(tipo: String): Cliente? {
        var mayor = Int.MIN_VALUE
        var cliente: Cliente? = null
        clientes.recorrer { _, valor ->
            if (tipo == "CORRIENTE" && !valor.deAhorros && valor.darSaldo() > mayor) {
                mayor = valor.darSaldo()
                cliente = valor
            }
            if (tipo == "AHORROS" && valor.deAhorros && valor.darSaldo() > mayor) {
                mayor = valor.darSaldo()
                cliente = valor
            }
        }
        return cliente
    }

    /**
     * Obtener la cantidad de clientes menores de edad que
     * hay en el banco.
     */
    fun menoresEdad(): Int {
        var menores = 0
        clientes.recorrer { _, valor ->
            if (valor.edad < 18) {
                menores++
            }
        }
        return menores
    }

    /**
     * Deposita en las cuentas de ahorro el interés mensua siempre y cuando
     * tengan el saldo mínimo que se pasa como dato de entrada.
     * Este interés corresponde a un 10% del saldo actual.
     * Retorne la suma de los nuevos saldos de las cuentas a quienes
     * se le depositó los intereses
     */
    fun depositarIntereses(saldoMinimo: Int): Int {
        var suma = 0
        for (i in 0 until clientes.tam) {
            if (clientes[i]!!.deAhorros && clientes[i]!!.darSaldo() >= saldoMinimo) {
                clientes[i]!!.depositar(clientes[i]!!.darSaldo() / 10)
                suma += clientes[i]!!.darSaldo()
            }
        }
        return suma
    }

    /**
     * Hallar el promedio de edad de los clientes cuyo
     * tipo sea el que se pasa como parámetro. El tipo
     * puede ser "CORRIENTE" o "AHORROS"
     */
    fun promedioEdad(tipoCliente: String): Double {
        var suma = 0
        var contador = 0
        for (i in 0 until clientes.tam) {
            if (tipoCliente == "CORRIENTE" && !clientes[i]!!.deAhorros) {
                suma += clientes[i]!!.edad
                contador++
            }
            if (tipoCliente == "AHORROS" && clientes[i]!!.deAhorros) {
                suma += clientes[i]!!.edad
                contador++
            }
        }
        return suma.toDouble() / contador
    }
}