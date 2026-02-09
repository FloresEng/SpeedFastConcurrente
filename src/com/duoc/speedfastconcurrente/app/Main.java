package com.duoc.speedfastconcurrente.app;

import com.duoc.speedfastconcurrente.model.EstadoPedido;
import com.duoc.speedfastconcurrente.model.Pedido;
import com.duoc.speedfastconcurrente.model.Repartidor;
import com.duoc.speedfastconcurrente.model.ZonaCarga;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Clase principal que crea los pedidos y los repartidores.
 */
public class Main {

    public static void main(String[] args) {

        //Recurso compartido
        ZonaCarga zona = new ZonaCarga(5);

        //creación de pedidos
        Pedido encomienda1 = new Pedido("Juan de Barros 3664, Quinta Normal", EstadoPedido.PENDIENTE);
        Pedido encomienda2 = new Pedido("Emilio Vaisse 770, Ñuñoa", EstadoPedido.PENDIENTE);
        Pedido encomienda3 = new Pedido("Compañía de Jesús 138, Santiago Centro", EstadoPedido.PENDIENTE);
        Pedido encomienda4 = new Pedido("Ricardo Lyon 1178, Providencia", EstadoPedido.PENDIENTE);
        Pedido encomienda5 = new Pedido("Fresia Oliva 34, Lo Prado", EstadoPedido.PENDIENTE);

        //carga de pedidos
        zona.agregarPedido(encomienda1);
        zona.agregarPedido(encomienda2);
        zona.agregarPedido(encomienda3);
        zona.agregarPedido(encomienda4);
        zona.agregarPedido(encomienda5);

        //creación de repartidores
        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.execute(new Repartidor("Javier", zona));
        executor.execute(new Repartidor("Francisca", zona));
        executor.execute(new Repartidor("Cristian", zona));

        //cierre de sistema
        try {
            Thread.sleep(10000);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }

        executor.shutdown();

        try{
            executor.awaitTermination(10, TimeUnit.SECONDS);
        }catch (InterruptedException e){
            executor.shutdownNow();
        }
        System.out.println("[SISTEMA] Todos los pedidos han sido entregados correctamente. Jornada finalizada.");
    }
}