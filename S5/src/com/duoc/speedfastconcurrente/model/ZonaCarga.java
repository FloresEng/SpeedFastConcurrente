package com.duoc.speedfastconcurrente.model;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Clase que actúa como monitor para los pedidos pendientes.
 * Utiliza BlockingQueue + synchronized para garantizar el control de la concurrencia.
 */
public class ZonaCarga {

    private final BlockingQueue<Pedido> pedidosPendientes;

    /**
     * Inicializa la zona de carga con una capacidad fija.
     * @param capacidad cantidad de pedidos que soporta la zona.
     */
    public ZonaCarga(int capacidad) {

        if (capacidad <= 0){
            throw new IllegalArgumentException("La capacidad debe ser mayor a cero.");
        }
        this.pedidosPendientes = new ArrayBlockingQueue<>(capacidad);
    }

    /**
     * Agrega un pedido a la cola de forma sincronizada.
     * @param p Pedido a añadir.
     */
    public synchronized void agregarPedido(PedidoS6 p){

        if (p == null){
            System.out.println("[ERROR] No se puede agregar un pedido nulo/vacío.");
            return;
        }
        try {
            pedidosPendientes.put(p);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("[ERROR] Proceso de carga interrumpido.");
        }
    }

    /**
     * Retira un pedido de la cola esperando un tiempo máximo.
     * @return el pedido retirado o null si se agota el tiempo de espera.
     */
    public synchronized Pedido retirarPedido(){

        try{
            return pedidosPendientes.poll(2, TimeUnit.SECONDS);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
            System.out.println("[ZONA DE CARGA] Repartidor interrumpido mientras esperaba encomienda.");
            return null;
        }
    }
}
