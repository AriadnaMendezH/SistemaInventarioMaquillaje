package tda;

import java.util.ArrayList;
import modelo.Producto;

/*
 * Proyecto: Sistema de Inventario de Maquillaje
 * Autor: Ariadna Mendez Hernandez
 *
 * TDA Inventario:
 *
 * Esta clase se encarga de almacenar y administrar
 * los productos de maquillaje registrados en el sistema.
 *
 * Incluye operaciones de búsqueda, eliminación,
 * actualización, cálculos de inventario y
 * búsqueda mediante recursividad.
 */
public class Inventario {

    // Atributos propios del TDA
    private String nombreInventario;
    private ArrayList<Producto> productos;

    /**
     * Constructor del inventario.
     */
    public Inventario(String nombreInventario) {

        if (nombreInventario == null
                || nombreInventario.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "El nombre del inventario no puede estar vacío."
            );
        }

        this.nombreInventario = nombreInventario;
        this.productos = new ArrayList<>();
    }

    /**
     * Agrega un nuevo producto al inventario.
     *
     * No permite registrar dos productos con
     * el mismo código.
     */
    public boolean agregarProducto(Producto producto) {

        if (producto == null) {
            return false;
        }

        if (buscarProducto(producto.getCodigo()) != null) {
            return false;
        }

        productos.add(producto);
        return true;
    }

    /**
     * Busca un producto mediante su código.
     */
    public Producto buscarProducto(String codigo) {

        for (Producto producto : productos) {

            if (producto.getCodigo().equalsIgnoreCase(codigo)) {
                return producto;
            }
        }

        return null;
    }

    /**
     * Elimina un producto del inventario
     * mediante su código.
     */
    public boolean eliminarProducto(String codigo) {

        Producto producto = buscarProducto(codigo);

        if (producto == null) {
            return false;
        }

        productos.remove(producto);
        return true;
    }

    /**
     * Actualiza la cantidad de unidades disponibles
     * de un producto.
     */
    public boolean actualizarExistencia(
            String codigo, int nuevaExistencia) {

        if (nuevaExistencia < 0) {
            return false;
        }

        Producto producto = buscarProducto(codigo);

        if (producto == null) {
            return false;
        }

        producto.setExistencia(nuevaExistencia);

        return true;
    }

    /**
     * Calcula el valor monetario total
     * de todos los productos de maquillaje.
     */
    public double calcularValorTotal() {

        double total = 0;

        for (Producto producto : productos) {
            total += producto.calcularValorEnStock();
        }

        return total;
    }

    /**
     * Cuenta cuántos productos tienen una
     * existencia menor o igual al límite indicado.
     */
    public int contarProductosBajoStock(int limite) {

        int contador = 0;

        for (Producto producto : productos) {

            if (producto.getExistencia() <= limite) {
                contador++;
            }
        }

        return contador;
    }

    /**
     * Determina cuál es el producto de maquillaje
     * con el precio más alto.
     */
    public Producto obtenerProductoMasCaro() {

        if (productos.isEmpty()) {
            return null;
        }

        Producto masCaro = productos.get(0);

        for (Producto producto : productos) {

            if (producto.getPrecio() > masCaro.getPrecio()) {
                masCaro = producto;
            }
        }

        return masCaro;
    }

    /**
     * Inicia la búsqueda recursiva de un producto
     * desde la primera posición de la lista.
     */
    public Producto buscarProductoRecursivo(String codigo) {

        return buscarProductoRecursivo(codigo, 0);
    }

    /**
     * Método recursivo para buscar un producto.
     *
     * CASO BASE:
     * Si la posición llega al tamaño de la lista,
     * significa que el producto no fue encontrado.
     *
     * CONDICIÓN DE AVANCE:
     * En cada llamada recursiva se aumenta
     * la posición en uno.
     */
    private Producto buscarProductoRecursivo(
            String codigo, int posicion) {

        // Caso base: se terminó de recorrer la lista.
        if (posicion >= productos.size()) {
            return null;
        }

        // Caso base: producto encontrado.
        if (productos.get(posicion)
                .getCodigo()
                .equalsIgnoreCase(codigo)) {

            return productos.get(posicion);
        }

        // Llamada recursiva avanzando una posición.
        return buscarProductoRecursivo(
                codigo, posicion + 1
        );
    }

    /**
     * Devuelve la cantidad de productos
     * registrados en el inventario.
     */
    public int obtenerCantidadProductos() {
        return productos.size();
    }

    public String getNombreInventario() {
        return nombreInventario;
    }

    public void setNombreInventario(String nombreInventario) {

        if (nombreInventario == null
                || nombreInventario.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "El nombre del inventario no puede estar vacío."
            );
        }

        this.nombreInventario = nombreInventario;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }
}