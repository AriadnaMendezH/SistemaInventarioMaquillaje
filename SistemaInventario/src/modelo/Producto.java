package modelo;

/*
 * Proyecto: Sistema de Inventario de Maquillaje
 * Autor: Ariadna Mendez Hernandez
 *
 * Esta clase representa un producto general almacenado
 * dentro del inventario de productos de maquillaje.
 *
 * Se aplica encapsulamiento mediante atributos privados
 * y validaciones en el constructor y métodos setters.
 */
public class Producto {

    // Atributos del producto
    private String codigo;
    private String nombre;
    private String marca;
    private double precio;
    private int existencia;

    /**
     * Constructor de la clase Producto.
     * Valida los datos antes de crear el objeto.
     */
    public Producto(String codigo, String nombre, String marca,
                    double precio, int existencia) {

        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El código no puede estar vacío."
            );
        }

        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El nombre no puede estar vacío."
            );
        }

        if (marca == null || marca.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "La marca no puede estar vacía."
            );
        }

        if (precio <= 0) {
            throw new IllegalArgumentException(
                    "El precio debe ser mayor que cero."
            );
        }

        if (existencia < 0) {
            throw new IllegalArgumentException(
                    "La existencia no puede ser negativa."
            );
        }

        this.codigo = codigo;
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.existencia = existencia;
    }

    // Getters

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMarca() {
        return marca;
    }

    public double getPrecio() {
        return precio;
    }

    public int getExistencia() {
        return existencia;
    }

    // Setters con validaciones

    public void setCodigo(String codigo) {

        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El código no puede estar vacío."
            );
        }

        this.codigo = codigo;
    }

    public void setNombre(String nombre) {

        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El nombre no puede estar vacío."
            );
        }

        this.nombre = nombre;
    }

    public void setMarca(String marca) {

        if (marca == null || marca.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "La marca no puede estar vacía."
            );
        }

        this.marca = marca;
    }

    public void setPrecio(double precio) {

        if (precio <= 0) {
            throw new IllegalArgumentException(
                    "El precio debe ser mayor que cero."
            );
        }

        this.precio = precio;
    }

    public void setExistencia(int existencia) {

        if (existencia < 0) {
            throw new IllegalArgumentException(
                    "La existencia no puede ser negativa."
            );
        }

        this.existencia = existencia;
    }

    /**
     * Aumenta la cantidad disponible de un producto.
     */
    public void aumentarExistencia(int cantidad) {

        if (cantidad <= 0) {
            throw new IllegalArgumentException(
                    "La cantidad debe ser mayor que cero."
            );
        }

        existencia += cantidad;
    }

    /**
     * Disminuye la cantidad disponible del producto
     * solamente cuando existe suficiente stock.
     */
    public boolean disminuirExistencia(int cantidad) {

        if (cantidad <= 0 || cantidad > existencia) {
            return false;
        }

        existencia -= cantidad;
        return true;
    }

    /**
     * Calcula el valor monetario de todas las unidades
     * disponibles de este producto.
     */
    public double calcularValorEnStock() {
        return precio * existencia;
    }
}