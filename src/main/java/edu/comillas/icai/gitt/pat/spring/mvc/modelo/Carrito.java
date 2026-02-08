package edu.comillas.icai.gitt.pat.spring.mvc.modelo;

public class Carrito {
    private int idCarrito;
    private int idArticulo;
    private String descripcion;
    private int unidades;
    private double precioFinal;

    public Carrito(int idCarrito, double precioFinal, int unidades, String descripcion, int idArticulo) {
        this.idCarrito = idCarrito;
        this.precioFinal = precioFinal;
        this.unidades = unidades;
        this.descripcion = descripcion;
        this.idArticulo = idArticulo;
    }

    public static int getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(int idCarrito) {
        this.idCarrito = idCarrito;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(double precioFinal) {
        this.precioFinal = precioFinal;
    }
}
