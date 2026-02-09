# App SpeedFastConcurrente - Sumativa 2 S5 DOO II

## Autor del Proyecto
- **Nombre:** Javier Flores Soriano
- **Sección:** 003A
- **Carrera:** Analista Programador Computacional
- **Sede:** Online

---

## Descrpicón del Proyecto
Aplicación Java orientada a objetos que utiliza el patrón Productor-Consumidor para la creación de una zona de carga y repartidores que despachan las encomiendas almancenadas.

El proyecto fue desarrollado aplicando principios de POO y de manera concurrente para el control y un correcto funcionamiento de los hilos.

---

🛠️ Tecnologías utilizadas

- Java SE.
- POO.
- Concurrencia.
- Interfaces.
- Javadoc.

## 📂 Estructura del proyecto

```plaintext
src
├── app
│   └── Main.java
├── model
│   ├── EstadoPedido.java
│   ├── Pedido.java
│   ├── Repartidor.java
└── └── ZonaCarga.java

````

### **Model**

- **EstadoPedido**: ENUM que define los estados del pedido. Para su registro predeterminado se define como PENDIENTE.
- **Pedido**: Clase que crea un nuevo pedido en el sistema y cuenta con validación de datos.
- **Repartidor**: Hilos que interactúan de forma concurrente con la zona de carga para repartir las encomiendas.
- **ZonaCarga**: Recurso compartido que almacena los pedidos pendientes de ser enviados.

### **App**

- **Main**: Clase principal que permite la creación de pedidos y repartidores, además de llamar al resto de métodos para hacer la entrega de las encomiendas.

## 🖥 Ejemplo de salida por Consola
<img width="1718" height="782" alt="imagen" src="https://github.com/user-attachments/assets/ea07d62b-d2ee-407d-8690-b9b521a269c6" />

## Instrucciones para clonar y ejecutar el proyecto

1. Clona el repositorio desde GitHub:
   
```bash
git clone https://github.com/FloresEng/SpeedFastConcurrente.git
```
2. Abre el proyecto en IntelliJ IDEA.

3. Verifica que los archivos `.txt` estén correctamente ubicados.

4. Ejecuta el archivo `Main.java` desde el paquete `app`.

5. Sigue las instrucciones en consola.


---

**Repositorio GitHub:** \[ https://github.com/FloresEng/SpeedFastConcurrente.git ]
**Fecha de entrega:** \[08/02/2026]
