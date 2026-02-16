package com.duoc.speedfastconcurrente.vista;

import com.duoc.speedfastconcurrente.model.PedidoS6;
import com.duoc.speedfastconcurrente.model.ZonaCargaS6;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VentanaListaPedidos extends JFrame {

    private JTable tabla;
    private DefaultTableModel model;
    private ZonaCargaS6 zona;

    public VentanaListaPedidos(ZonaCargaS6 zona){
        this.zona = zona;
        setTitle("Lista de pedidos");
        setSize(500,300);
        setLayout(new BorderLayout());

        //Configuración tabla
        String[] columnas = {"Tipo pedido","ID","Dirección"};
        model = new DefaultTableModel(columnas,0);
        tabla = new JTable(model);

        actualizarTabla();

        add(new JScrollPane(tabla),BorderLayout.CENTER);

        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.addActionListener(e -> actualizarTabla());
        add(btnActualizar, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void actualizarTabla(){
        model.setRowCount(0);//limpiamos tabla
        for (PedidoS6 p : zona.getPedidosPendientes()){
            model.addRow(new Object[]{p.getTipoPedido(),p.getId(),p.getDireccionEntrega()});
        }
    }
}
