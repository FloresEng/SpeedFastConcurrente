package com.duoc.speedfastconcurrente.model;

/**
 * Clase que implementa Runnable para usar hilos.
 * Hilo simula ser un repartidor que retira y entrega encomiendas.
 */
public class RepartidorS6 implements Runnable{

    private String nombre;
    private ZonaCargaS6 zona;

    public RepartidorS6(String nombre, ZonaCargaS6 zona){

        if (nombre == null || nombre.trim().isEmpty()){
            throw new IllegalArgumentException("Debe especificar nombre de repartidor.");
        }
        if (zona == null){
            throw new IllegalArgumentException("El repartidor debe tener una zona de carga asignada.");
        }
        this.nombre = nombre;
        this.zona = zona;
    }

    @Override
    public void run() {

        while (!Thread.currentThread().isInterrupted()){
            try{

                PedidoS6 pedido = zona.retirarPedido();
                if (pedido == null){
                    System.out.println("[REPARTIDOR] "+nombre+" no le quedan encomiendas por entregar.");
                    break;
                }

                System.out.println("[ZONA DE CARGA] Pedido preparado para entrega.");
                Thread.sleep(1500);//Simula preparación de pedido

                System.out.println("[REPARTIDOR] "+nombre+" ha retirado su encomienda y se encuentra en camino. Detalles : "+pedido);
                Thread.sleep(2000);//Simula viaje

                System.out.println("[SISTEMA] Pedido entregado correctamente por "+nombre+". Detalles de entrega: "+pedido);
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
                System.out.println("[ZONA DE CARGA] [ERROR] en despacho de pedidos.");
                break;
            }
        }

    }
}
