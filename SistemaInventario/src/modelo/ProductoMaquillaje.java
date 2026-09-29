package modelo;

/*
 * Proyecto: Sistema de Inventario de Maquillaje
 * Autor: Ariadna Mendez Hernandez
 *
 * Clase hija de Producto.
 * Representa específicamente un producto de maquillaje
 * e incorpora características propias como categoría y tono.
 */
public class ProductoMaquillaje extends Producto {

    private String categoria;
    private String tono;

    /**
     * Constructor de ProductoMaquillaje.
     *
     * Utiliza el constructor de la clase padre Producto
     * mediante la instrucción super.
     */
    public ProductoMaquillaje(String codigo, String nombre, String marca,
                              double precio, int existencia,
                              String categoria, String tono) {

        super(codigo, nombre, marca, precio, existencia);

        if (categoria == null || categoria.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "La categoría no puede estar vacía."
            );
        }

        if (tono == null || tono.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El tono no puede estar vacío."
            );
        }

        this.categoria = categoria;
        this.tono = tono;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {

        if (categoria == null || categoria.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "La categoría no puede estar vacía."
            );
        }

        this.categoria = categoria;
    }

    public String getTono() {
        return tono;
    }

    public void setTono(String tono) {

        if (tono == null || tono.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El tono no puede estar vacío."
            );
        }

        this.tono = tono;
    }
}