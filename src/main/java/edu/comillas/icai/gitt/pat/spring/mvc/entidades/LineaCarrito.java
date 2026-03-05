package edu.comillas.icai.gitt.pat.spring.mvc.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.comillas.icai.gitt.pat.spring.mvc.entidades.Carrito;
import jakarta.persistence.*;

@Entity
public class LineaCarrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idArticulo;
    private Double precioUnitario;
    private Integer unidades;
    private Double costeLinea; // (precioUnitario * unidades)

    @ManyToOne
    @JoinColumn(name = "carrito_id")
    @JsonIgnore // Evita bucles infinitos al convertir a JSON
    private Carrito carrito;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getIdArticulo() { return idArticulo; }
    public void setIdArticulo(Long idArticulo) { this.idArticulo = idArticulo; }
    public Double getPrecioUnitario() { return precioUnitario; }
    public void setPrecioUnitario(Double precioUnitario) { this.precioUnitario = precioUnitario; }
    public Integer getUnidades() { return unidades; }
    public void setUnidades(Integer unidades) { this.unidades = unidades; }
    public Double getCosteLinea() { return costeLinea; }
    public void setCosteLinea(Double costeLinea) { this.costeLinea = costeLinea; }
    public Carrito getCarrito() { return carrito; }
    public void setCarrito(Carrito carrito) { this.carrito = carrito; }
}
