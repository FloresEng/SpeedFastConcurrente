package com.duoc.speedfastconcurrente.model;

import java.util.UUID;

/**
 * Representa una encomienda dentro del sistema.
 * Gestiona su propia identidad y estado de entrega.
 */
public class Pedido {

   private UUID id;
   private String direccionEntrega;
   private EstadoPedido estado;

    /**
     * Crea un nuevo pedido con validación de datos
     * @param direccionEntrega Dirección física de destino.
     * @param estado del pedido, inicialmente PENDIENTE.
     * @throws IllegalArgumentException si la dirección o el estado están vacíos.
     */

    public Pedido(String direccionEntrega, EstadoPedido estado){

        if (direccionEntrega == null || direccionEntrega.trim().isEmpty()){
            throw new IllegalArgumentException("La dirección de entrega no puede estar vacía.");
        }
        if (estado == null){
            throw new IllegalArgumentException("El estado inicial del pedido es obligatorio para su registro.");
        }
        this.id = UUID.randomUUID();
        this.direccionEntrega = direccionEntrega;
        this.estado = estado;
    }

    public String getDireccionEntrega(){
        return direccionEntrega;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    /**
     * Actualiza el estado de la encomienda.
     * @param nuevoEstado a asignar.
     */
    public void setEstado(EstadoPedido nuevoEstado) {
        if (nuevoEstado != null){
            this.estado = nuevoEstado;
        }
    }

    @Override
    public String toString() {
        return "Pedido "+ id +
                ", con dirección a: " + direccionEntrega + "\nSe encuentra: " + estado;
    }
}
