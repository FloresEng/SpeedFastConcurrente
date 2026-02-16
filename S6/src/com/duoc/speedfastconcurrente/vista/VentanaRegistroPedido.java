package com.duoc.speedfastconcurrente.vista;

import com.duoc.speedfastconcurrente.model.PedidoS6;
import com.duoc.speedfastconcurrente.model.ZonaCargaS6;

import javax.swing.*;
import java.awt.*;

public class VentanaRegistroPedido extends JFrame {

    private JTextField txtDireccion;
    private JComboBox<String> cbtipo;
    private ZonaCargaS6 zona;

    public VentanaRegistroPedido(ZonaCargaS6 zona){
        this.zona = zona;

        setTitle("Registro de Pedido");
        setSize(450,250);
        setLayout(new GridLayout(3,2,10,70));

        add(new JLabel("Dirección:"));
        txtDireccion = new JTextField();
        add(txtDireccion);

        add(new JLabel("Tipo pedido:"));
        cbtipo = new JComboBox<>(new String[]{"Comida", "Encomienda", "Express"});
        add(cbtipo);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(e -> guardarPedido());
        add(btnGuardar, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void guardarPedido(){
        if (txtDireccion.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Todos los campos son obligatorios", "ERROR",JOptionPane.ERROR_MESSAGE);
            return;
        }
        PedidoS6 nuevo = new PedidoS6(txtDireccion.getText(), cbtipo.getSelectedItem().toString());
        zona.agregarPedido(nuevo);

        JOptionPane.showMessageDialog(this, "Pedido registrado correctamente");
        dispose();
    }
}
