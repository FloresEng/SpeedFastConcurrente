package com.duoc.speedfastconcurrente.model;

import java.util.UUID;

/**
 * Representa una encomienda dentro del sistema.
 * Gestiona su propia identidad y estado de entrega.
 */
public class PedidoS6 {

   private UUID id;
   private String direccionEntrega;
   private String tipoPedido;

    /**
     * Crea un nuevo pedido con validación de datos
     * @param direccionEntrega Dirección física de destino.
     * @param tipoPedido de pedido (comida, encomienda, express).
     * @throws IllegalArgumentException si la dirección o el estado están vacíos.
     */

    public PedidoS6(String direccionEntrega, String tipoPedido){

        if (direccionEntrega == null || direccionEntrega.trim().isEmpty()){
            throw new IllegalArgumentException("La dirección de entrega no puede estar vacía.");
        }
        if (tipoPedido == null){
            throw new IllegalArgumentException("Debe especificar el tipo de pedido.");
        }
        this.id = UUID.randomUUID();
        this.direccionEntrega = direccionEntrega;
        this.tipoPedido = tipoPedido;
    }

    public UUID getId() {
        return id;
    }

    public String getDireccionEntrega(){
        return direccionEntrega;
    }

    public String getTipoPedido() {
        return tipoPedido;
    }


    @Override
    public String toString() {
        return "Pedido "+tipoPedido+" ("+ id +
                "), con dirección a: " + direccionEntrega;
    }
}
