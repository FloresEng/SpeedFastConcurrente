package com.duoc.speedfastconcurrente.vista;

import com.duoc.speedfastconcurrente.model.RepartidorS6;
import com.duoc.speedfastconcurrente.model.ZonaCargaS6;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class VentanaPrincipal extends JFrame {

    private ZonaCargaS6 zona = new ZonaCargaS6(50);

    public VentanaPrincipal(){
        setTitle("Gestión de Pedidos - SpeedFast");
        setSize(600,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3,1,25,30));

        JButton btnRegistrar = new JButton("Registrar Pedido");
        JButton btnListar = new JButton("Listar Pedidos");
        JButton btnIniciar = new JButton("Iniciar Entregas");

        btnRegistrar.addActionListener(e -> new VentanaRegistroPedido(zona).setVisible(true));
        btnListar.addActionListener(e -> {
            if (zona.estaVacia()){
                JOptionPane.showMessageDialog(this,"Aún no hay pedidos registrados", "Atención",JOptionPane.WARNING_MESSAGE);
                return;
            }

            new VentanaListaPedidos(zona).setVisible(true);
        });

        btnIniciar.addActionListener(e -> {

            if (zona.estaVacia()){
                JOptionPane.showMessageDialog(this,"No hay pedidos por entregar", "Atención",JOptionPane.WARNING_MESSAGE);
                return;
            }

            JOptionPane.showMessageDialog(this,"GPS de envíos a través de la consola");
            ExecutorService executor = Executors.newFixedThreadPool(3);

            executor.execute(new RepartidorS6("Javier", zona));
            executor.execute(new RepartidorS6("Francisca", zona));
            executor.execute(new RepartidorS6("Cristian", zona));

            //cierre de sistema
            try {
                Thread.sleep(10000);
            }catch (InterruptedException exception){
                Thread.currentThread().interrupt();
            }

            executor.shutdown();

            try{
                executor.awaitTermination(10, TimeUnit.SECONDS);
            }catch (InterruptedException exception){
                executor.shutdownNow();
            }
            System.out.println("[SISTEMA] Todos los pedidos han sido entregados correctamente. Jornada finalizada.");
        });

        add(btnRegistrar);
        add(btnListar);
        add(btnIniciar);

        setLocationRelativeTo(null);

    }

}
