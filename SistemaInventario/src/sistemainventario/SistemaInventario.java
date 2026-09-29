package sistemainventario;

import vista.FrmInventario;

/*
 * Proyecto: Sistema de Inventario de Maquillaje
 * Autor: Ariadna Mendez Hernandez
 *
 * Clase principal de la aplicación.
 */
public class SistemaInventario {

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {

                FrmInventario ventana = new FrmInventario();

                ventana.setLocationRelativeTo(null);
                ventana.setVisible(true);
            }
        });
    }
}