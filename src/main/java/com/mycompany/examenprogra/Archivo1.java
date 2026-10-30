--- START OF FILE Producto.java ---
package com.mycompany.examenprogra;public class Producto {
private int id;
private String nombre;
private int existencias;public Producto(int id, String nombre, int existencias) {
    this.id = id;
    this.nombre = nombre;
    this.existencias = existencias;
}

public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}

public String getNombre() {
    return nombre;
}

public void setNombre(String nombre) {
    this.nombre = nombre;
}

public int getExistencias() {
    return existencias;
}

public void setExistencias(int existencias) {
    this.existencias = existencias;
}

@Override
public String toString() {
    return "ID: " + id + " Nombre: " + nombre + " Existencias: " + existencias;
}
}--- START OF FILE Pedido.java ---
package com.mycompany.examenprogra;public class Pedido {
private int folio;
private int idProducto;
private int cantidad;public Pedido(int folio, int idProducto, int cantidad) {
    this.folio = folio;
    this.idProducto = idProducto;
    this.cantidad = cantidad;
}

public int getFolio() {
    return folio;
}

public void setFolio(int folio) {
    this.folio = folio;
}

public int getIdProducto() {
    return idProducto;
}

public void setIdProducto(int idProducto) {
    this.idProducto = idProducto;
}

public int getCantidad() {
    return cantidad;
}

public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
}

@Override
public String toString() {
    return "Folio: " + folio + " ID Producto: " + idProducto + " Cantidad: " + cantidad;
}
}--- START OF FILE NodoProducto.java ---
package com.mycompany.examenprogra;public class NodoProducto {
private Producto dato;
private NodoProducto siguiente;public NodoProducto(Producto dato) {
    this.dato = dato;
    this.siguiente = null;
}

public Producto getDato() {
    return dato;
}

public void setDato(Producto dato) {
    this.dato = dato;
}

public NodoProducto getSiguiente() {
    return siguiente;
}

public void setSiguiente(NodoProducto siguiente) {
    this.siguiente = siguiente;
}
}--- START OF FILE NodoPedido.java ---
package com.mycompany.examenprogra;public class NodoPedido {
private Pedido dato;
private NodoPedido siguiente;public NodoPedido(Pedido dato) {
    this.dato = dato;
    this.siguiente = null;
}

public Pedido getDato() {
    return dato;
}

public void setDato(Pedido dato) {
    this.dato = dato;
}

public NodoPedido getSiguiente() {
    return siguiente;
}

public void setSiguiente(NodoPedido siguiente) {
    this.siguiente = siguiente;
}
}--- START OF FILE Lista1.java ---
package com.mycompany.examenprogra;public class Lista1 {
private NodoProducto inicio;
private NodoProducto fin;   public Lista1() {
    this.inicio = null;
    this.fin = null;
}

public void insertar(Producto unProducto) {
    NodoProducto nuevoNodo = new NodoProducto(unProducto);
    if (this.inicio == null) {
        this.inicio = nuevoNodo;
        this.fin = nuevoNodo;
        this.fin.setSiguiente(this.inicio);
    } else {
        this.fin.setSiguiente(nuevoNodo);
        nuevoNodo.setSiguiente(this.inicio);
        this.fin = nuevoNodo;
    }
}

public Producto buscar(int idBuscado) {
    if (this.inicio == null) {
        return null;
    }
    NodoProducto aux = this.inicio;
    do {
        if (aux.getDato().getId() == idBuscado) {
            return aux.getDato();
        }
        aux = aux.getSiguiente();
    } while (aux != this.inicio);
    return null;
}

public void mostrar() {
    if (this.inicio == null) {
        System.out.println("Lista vacia");
        return;
    }
    NodoProducto aux = this.inicio;
    do {
        System.out.println(aux.getDato().toString());
        aux = aux.getSiguiente();
    } while (aux != this.inicio);
}
}--- START OF FILE Cola1.java ---
package com.mycompany.examenprogra;public class Cola1 {
private NodoPedido inicio;
private NodoPedido fin;public Cola1() {
    this.inicio = null;
    this.fin = null;
}

public void encolar(Pedido unPedido) {
    NodoPedido nuevoNodo = new NodoPedido(unPedido);
    if (this.inicio == null) {
        this.inicio = nuevoNodo;
        this.fin = nuevoNodo;
    } else {
        this.fin.setSiguiente(nuevoNodo);
        this.fin = nuevoNodo;
    }
}

public Pedido desencolar() {
    if (this.inicio == null) {
        return null;
    }
    Pedido valorEliminado = this.inicio.getDato();
    this.inicio = this.inicio.getSiguiente();
    if (this.inicio == null) {
        this.fin = null;
    }
    return valorEliminado;
}

public void devolverAlFrente(Pedido unPedido) {
    NodoPedido nuevoNodo = new NodoPedido(unPedido);
    if (this.inicio == null) {
        this.inicio = nuevoNodo;
        this.fin = nuevoNodo;
    } else {
        nuevoNodo.setSiguiente(this.inicio);
        this.inicio = nuevoNodo;
    }
}

public Pedido elementoFrente() {
    if (this.inicio == null) {
        return null;
    }
    return this.inicio.getDato();
}

public boolean estaVacia() {
    return this.inicio == null;
}

public void mostrar() {
    if (this.inicio == null) {
        System.out.println("Cola de pedidos vacia");
        return;
    }
    NodoPedido aux = this.inicio;
    while (aux != null) {
        System.out.println(aux.getDato().toString());
        aux = aux.getSiguiente();
    }
}
}--- START OF FILE Cola2.java ---
package com.mycompany.examenprogra;public class Cola2 {
private NodoPedido inicio;
private NodoPedido fin;public Cola2() {
    this.inicio = null;
    this.fin = null;
}

public void encolar(Pedido unPedido) {
    NodoPedido nuevoNodo = new NodoPedido(unPedido);
    if (this.inicio == null) {
        this.inicio = nuevoNodo;
        this.fin = nuevoNodo;
    } else {
        this.fin.setSiguiente(nuevoNodo);
        this.fin = nuevoNodo;
    }
}

public Pedido retirarUltimo() {
    if (this.inicio == null) {
        return null;
    }
    if (this.inicio == this.fin) {
        Pedido valorEliminado = this.inicio.getDato();
        this.inicio = null;
        this.fin = null;
        return valorEliminado;
    }
    NodoPedido aux = this.inicio;
    while (aux.getSiguiente() != this.fin) {
        aux = aux.getSiguiente();
    }
    Pedido valorEliminado = this.fin.getDato();
    this.fin = aux;
    this.fin.setSiguiente(null);
    return valorEliminado;
}

public boolean estaVacia() {
    return this.inicio == null;
}

public void mostrar() {
    if (this.inicio == null) {
        System.out.println("Historial vacio");
        return;
    }
    NodoPedido aux = this.inicio;
    while (aux != null) {
        System.out.println(aux.getDato().toString());
        aux = aux.getSiguiente();
    }
}
}--- START OF FILE ExamenProgra.java ---
package com.mycompany.examenprogra;import java.util.Scanner;public class ExamenProgra {public static void main(String[] args) {
    Scanner teclado = new Scanner(System.in);
    Lista1 listaProductos = new Lista1();
    Cola1 pendientes = new Cola1();
    Cola2 historial = new Cola2();
    
    int opc = 0;
    int folioAct = 1;

    do {
        System.out.println("\nMenu de Cafeteria");
        System.out.println("1. Registrar un producto y sus existencias iniciales");
        System.out.println("2. Agregar un pedido");
        System.out.println("3. Preparar el siguiente pedido");
        System.out.println("4. Deshacer mi ultima preparacion");
        System.out.println("5. Mostrar productos e historial");
        System.out.println("6. Salir");
        System.out.print("Elige una opcion: ");
        opc = teclado.nextInt();
        teclado.nextLine();

        switch (opc) {
            case 1:
                System.out.print("Ingresa el ID del producto: ");
                int idProd = teclado.nextInt();
                teclado.nextLine();
                
                System.out.print("Ingresa el nombre del producto: ");
                String nomProd = teclado.nextLine();
                
                System.out.print("Ingresa la cantidad de existencias: ");
                int cant = teclado.nextInt();
                teclado.nextLine();
                
                Producto unProducto = new Producto(idProd, nomProd, cant);
                listaProductos.insertar(unProducto);
                System.out.println("Producto registrado");
                break;
                
            case 2:
                System.out.print("Ingresa el ID del producto a pedir: ");
                int idPed = teclado.nextInt();
                teclado.nextLine();
                
                System.out.print("Ingresa la cantidad a pedir: ");
                int cantPed = teclado.nextInt();
                teclado.nextLine();
                
                Pedido unPedido = new Pedido(folioAct, idPed, cantPed);
                pendientes.encolar(unPedido);
                System.out.println("Pedido agregado a la cola con folio: " + folioAct);
                folioAct++;
                break;
                
            case 3:
                if (pendientes.estaVacia()) {
                    System.out.println("No hay pedidos pendientes");
                } else {
                    Pedido pedidoFrente = pendientes.elementoFrente();
                    Producto prodBuscado = listaProductos.buscar(pedidoFrente.getIdProducto());
                    
                    if (prodBuscado != null) {
                        if (prodBuscado.getExistencias() >= pedidoFrente.getCantidad()) {
                            prodBuscado.setExistencias(prodBuscado.getExistencias() - pedidoFrente.getCantidad());
                            Pedido preparado = pendientes.desencolar();
                            historial.encolar(preparado);
                            System.out.println("Pedido preparado exitosamente");
                        } else {
                            System.out.println("No alcanzan las existencias. El pedido se queda al frente de la cola");
                        }
                    } else {
                        System.out.println("El producto no existe. Se descartara el pedido");
                        pendientes.desencolar();
                    }
                }
                break;
                
            case 4:
                if (historial.estaVacia()) {
                    System.out.println("No hay preparaciones para deshacer");
                } else {
                    Pedido ultimoPrep = historial.retirarUltimo();
                    Producto prodRestaurar = listaProductos.buscar(ultimoPrep.getIdProducto());
                    
                    if (prodRestaurar != null) {
                        prodRestaurar.setExistencias(prodRestaurar.getExistencias() + ultimoPrep.getCantidad());
                    }
                    
                    pendientes.devolverAlFrente(ultimoPrep);
                    System.out.println("Preparacion deshecha. Pedido devuelto al frente y existencias restauradas");
                }
                break;
                
            case 5:
                System.out.println("--- Lista1: Productos ---");
                listaProductos.mostrar();
                System.out.println("--- Cola1: Pedidos Pendientes ---");
                pendientes.mostrar();
                System.out.println("--- Cola2: Historial ---");
                historial.mostrar();
                break;
                
            case 6:
                System.out.println("Saliendo...");
                break;
                
            default:
                System.out.println("Opcion invalida");
                break;
        }
    } while (opc != 6);
}
}
