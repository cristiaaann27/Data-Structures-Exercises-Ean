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

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Panel de manejo de opciones.
 */
@SuppressWarnings("serial")
public class PanelOpciones extends JPanel implements ActionListener {

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Comando Opción 1.
     */
    private static final String OPCION_1 = "OPCION_1";

    /**
     * Comando Opción 2.
     */
    private static final String OPCION_2 = "OPCION_2";

    /**
     * Comando buscar mejor camión.
     */
    private static final String MEJOR_CAMION = "Buscar camión";

    /**
     * Comando dar peso total.
     */
    private static final String PESO_TOTAL = "Total peso";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación.
     */
    private InterfazEmpresaTransporte principal;

    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

    /**
     * Botón Opción 1.
     */
    private JButton btnOpcion1;

    /**
     * Botón Opción 2.
     */
    private JButton btnOpcion2;

    /**
     * Botón para buscar camión.
     */
    private JButton btnBuscarCamion;

    /**
     * Botón para dar total de peso.
     */
    private JButton btnPesoTotal;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel.
     *
     * @param pPrincipal Ventana principal de la aplicación. pPrincipal != null.
     */
    public PanelOpciones(InterfazEmpresaTransporte pPrincipal) {
        principal = pPrincipal;

        setBorder(new TitledBorder("Opciones"));
        setLayout(new GridLayout(2, 2));

        btnBuscarCamion = new JButton("Buscar mejor camión");
        btnBuscarCamion.setActionCommand(MEJOR_CAMION);
        btnBuscarCamion.addActionListener(this);
        add(btnBuscarCamion);

        btnPesoTotal = new JButton("Capacidad total");
        btnPesoTotal.setActionCommand(PESO_TOTAL);
        btnPesoTotal.addActionListener(this);
        add(btnPesoTotal);

        btnOpcion1 = new JButton("Camión más cargado");
        btnOpcion1.setActionCommand(OPCION_1);
        btnOpcion1.addActionListener(this);
        add(btnOpcion1);

        btnOpcion2 = new JButton("Camiones Vacíos");
        btnOpcion2.setActionCommand(OPCION_2);
        btnOpcion2.addActionListener(this);
        add(btnOpcion2);
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Manejo de los eventos de los botones.
     *
     * @param pEvento Acción que generó el evento. pEvento != null.
     */
    public void actionPerformed(ActionEvent pEvento) {
        String comando = pEvento.getActionCommand();
        if (OPCION_1.equals(comando)) {
            principal.reqFuncOpcion1();
        }
        else if (OPCION_2.equals(comando)) {
            principal.reqFuncOpcion2();
        }
        else if (PESO_TOTAL.equals(comando)) {
            principal.darTotalizarPeso();
        }
        else if (MEJOR_CAMION.equals(comando)) {
            principal.darMejorCamion();
        }
    }

}
