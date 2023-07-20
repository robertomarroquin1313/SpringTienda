package com.portafolio.SpringTienda.Domain.Persistence.Entity;

import jakarta.persistence.*;


@Entity
@Table(name = "compras_producto")
public class  ComprasProducto {
    @EmbeddedId
    private ComprasProductoPk id;

    @Column(name = "stock")
    private Integer cantidad;

    @Column(name = "total")
    private Double total;

    @Column(name="estado")
    private Boolean estado;



    @ManyToOne
    @MapsId("idCompra")
    @JoinColumn(name = "id_compra",insertable = false,updatable = false)
    private Compra compra;

    @ManyToOne
    @JoinColumn(name = "id_producto",insertable = false,updatable = false)
    private Producto producto;

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public ComprasProductoPk getId() {
        return id;
    }

    public void setId(ComprasProductoPk id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
