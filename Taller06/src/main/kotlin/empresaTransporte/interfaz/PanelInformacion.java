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

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 * Panel para mostrar la información general del barco.
 */
@SuppressWarnings("serial")
public class PanelInformacion extends JPanel {

    // ------------------------------------------------------------
    // Atributos de interfaz
    // ------------------------------------------------------------

    /**
     * Etiqueta Total de carga.
     */
    private JLabel lblCargaTotal;

    /**
     * Etiqueta Promedio carga.
     */
    private JLabel lblPromedioCarga;

    /**
     * Campo de texto para el total de la carga.
     */
    private JTextField txtTotalCarga;

    /**
     * Campo de texto para el promedio de carga por camión.
     */
    private JTextField txtPromedioCarga;

    // ------------------------------------------------------------
    // Constructor
    // ------------------------------------------------------------

    /**
     * Constructor del panel de información de la empresa de transporte.
     */
    public PanelInformacion() {
        setLayout(new GridLayout(2, 2, 2, 2));

        setBorder(new CompoundBorder(new EmptyBorder(4, 3, 3, 3), new TitledBorder("Información")));

        lblCargaTotal = new JLabel("Carga total:");
        add(lblCargaTotal);
        txtTotalCarga = new JTextField();
        txtTotalCarga.setEditable(false);
        add(txtTotalCarga);

        lblPromedioCarga = new JLabel("Carga promedio:");
        add(lblPromedioCarga);
        txtPromedioCarga = new JTextField();
        txtPromedioCarga.setEditable(false);
        add(txtPromedioCarga);
    }

    // ------------------------------------------------------------
    // Métodos
    // ------------------------------------------------------------

    /**
     * Actualiza el panel.
     *
     * @param pCargaTotal    Carga total de los 4 camiones. pCargaTotal >= 0.
     * @param pCargaPromedio Promedio de carga por camión. pCargaPromedio >= 0.
     */
    public void actualizarInformacion(int pCargaTotal, double pCargaPromedio) {
        txtTotalCarga.setText(pCargaTotal + " Kg.");
        txtPromedioCarga.setText(pCargaPromedio + " Kg.");
    }
}
