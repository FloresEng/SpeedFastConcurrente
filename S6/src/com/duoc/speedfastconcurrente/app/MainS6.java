package com.duoc.speedfastconcurrente.app;

import com.duoc.speedfastconcurrente.vista.VentanaPrincipal;

/**
 * Clase principal que crea los pedidos y los repartidores.
 */
public class MainS6 {

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(()->{
            new VentanaPrincipal().setVisible(true);
        });

    }
}