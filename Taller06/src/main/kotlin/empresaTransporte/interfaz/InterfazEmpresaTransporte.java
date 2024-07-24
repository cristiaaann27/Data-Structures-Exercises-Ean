/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 * Programa de Ingeniería de Sistemas
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Etructura de Datos - Taller 06
 * Ejercicio: Empresa de Transporte
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package empresaTransporte.interfaz;

import empresaTransporte.mundo.Camion;
import empresaTransporte.mundo.EmpresaTransporte;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;


/**
 * Ventana principal de la aplicación.
 */
@SuppressWarnings("serial")
public class InterfazEmpresaTransporte extends JFrame {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase principal del mundo.
     */
    private EmpresaTransporte empresaTransporte;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Panel con la información del camión 1.
     */
    private PanelCamion panelCamion1;

    /**
     * Panel con la información del camión 2.
     */
    private PanelCamion panelCamion2;

    /**
     * Panel con la información del camión 3.
     */
    private PanelCamion panelCamion3;

    /**
     * Panel con la información del camión 4.
     */
    private PanelCamion panelCamion4;

    /**
     * Panel con la información general.
     */
    private PanelInformacion panelInformación;

    /**
     * Panel con las opciones.
     */
    private PanelOpciones panelOpciones;

    /**
     * Panel con la imagen de banner.
     */
    private PanelImagen panelImagen;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea la ventana principal de la aplicación. <br>
     * <b>post: </b> La venta fue creada con todos sus paneles.
     */
    public InterfazEmpresaTransporte() {
        setTitle("Empresa de transporte");
        setSize(750, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        empresaTransporte = new EmpresaTransporte();

        setLayout(new BorderLayout());

        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new GridLayout(2, 2));

        panelCamion1 = new PanelCamion(this);
        panelCentral.add(panelCamion1);

        panelCamion2 = new PanelCamion(this);
        panelCentral.add(panelCamion2);

        panelCamion3 = new PanelCamion(this);
        panelCentral.add(panelCamion3);

        panelCamion4 = new PanelCamion(this);
        panelCentral.add(panelCamion4);

        add(panelCentral, BorderLayout.CENTER);

        panelOpciones = new PanelOpciones(this);
        add(panelOpciones, BorderLayout.SOUTH);

        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new BorderLayout());

        panelImagen = new PanelImagen();
        panelSuperior.add(panelImagen, BorderLayout.CENTER);

        panelInformación = new PanelInformacion();
        panelSuperior.add(panelInformación, BorderLayout.SOUTH);

        add(panelSuperior, BorderLayout.NORTH);

        setLocationRelativeTo(null);
        setResizable(false);

        actualizar();
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Actualiza la información de todos los paneles.
     */
    public void actualizar() {
        panelCamion1.actualizar(empresaTransporte.getCamion1());
        panelCamion2.actualizar(empresaTransporte.getCamion2());
        panelCamion3.actualizar(empresaTransporte.getCamion3());
        panelCamion4.actualizar(empresaTransporte.getCamion4());
        panelInformación.actualizarInformacion(empresaTransporte.darCargaTotal(), empresaTransporte.calcularCargaPromedio());
    }

    /**
     * Carga un camión.
     *
     * @param pMatricula Matrícula del camión a descargar. pMatricula != null && pMatricula != "".
     */
    public void cargar(String pMatricula) {
        String ingresado = JOptionPane.showInputDialog(this, "Peso de la carga:", "Cargar camión", JOptionPane.DEFAULT_OPTION);
        if (ingresado != null) {
            try {
                int carga = Integer.parseInt(ingresado);
                if (carga > 0) {
                    boolean cargo = empresaTransporte.cargarCamion(pMatricula, carga);
                    if (cargo == true) {
                        actualizar();
                    }
                    else {
                        JOptionPane.showMessageDialog(this, "El camión no tiene capacidad suficiente para esa carga.", "Cargar camión", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else {
                    JOptionPane.showMessageDialog(this, "El valor ingresado debe ser positivo.", "Cargar camión", JOptionPane.ERROR_MESSAGE);
                }
            }
            catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "El valor ingresado debe ser un valor numérico.", "Cargar camión", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    /**
     * Descarga un camión.
     *
     * @param pMatricula Matrícula del camión a descargar. pMatricula != null && pMatricula != "".
     */
    public void descargar(String pMatricula) {
        empresaTransporte.descargarCamion(pMatricula);
        actualizar();
    }

    /**
     * Busca y muestra el mejor camión para transportar una carga dada.
     */
    public void darMejorCamion() {
        String valor = JOptionPane.showInputDialog(this, "Peso a transportar (en Kg.)", "Buscar mejor camión", JOptionPane.DEFAULT_OPTION);
        if (valor != null) {
            try {
                int cantidad = Integer.parseInt(valor);
                Camion resultado = empresaTransporte.darMejorCamion(cantidad);
                if (resultado != null) {
                    JOptionPane.showMessageDialog(this, "El mejor camión para transportar la carga tiene la matrícula: " + resultado.getMatricula(), "Mejor camión", JOptionPane.DEFAULT_OPTION);
                }
                else {
                    JOptionPane.showMessageDialog(this, "Ningún camión puede transportar la carga.", "Mejor camión", JOptionPane.DEFAULT_OPTION);
                }
            }
            catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "El peso ingresado debe ser un valor numérico.", "Mejor camión", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Muestra la capacidad total de carga de los 4 camiones.
     */
    public void darTotalizarPeso() {
        int peso = empresaTransporte.darCapacidadTotal();
        JOptionPane.showMessageDialog(this, "La capacidad total de carga es " + peso + " kg.", "Peso Total", JOptionPane.INFORMATION_MESSAGE);
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Método para la extensión 1.
     */
    public void reqFuncOpcion1() {
        String resultado = empresaTransporte.matriculaCamionMasCargado();
        actualizar();
        JOptionPane.showMessageDialog(this,
                "La matrícula del camión más cargado es: " + resultado,
                "Respuesta",
                JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Método para la extensión 2.
     */
    public void reqFuncOpcion2() {
        int cont = empresaTransporte.cantidadCamionesDescargados();
        String resultado = "Hay " + cont + " camiones descargados";
        actualizar();
        JOptionPane.showMessageDialog(this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE);
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Ejecuta la aplicación.
     *
     * @param pArgs Parámetros de la ejecución. No son necesarios.
     */
    public static void main(String[] pArgs) {
        try {
            // Unifica la interfaz para Mac y para Windows.
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());

            InterfazEmpresaTransporte interfaz = new InterfazEmpresaTransporte();
            interfaz.setVisible(true);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}