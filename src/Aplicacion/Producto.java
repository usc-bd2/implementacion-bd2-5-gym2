package Aplicacion;

public class Producto {
    private Integer idProducto;
    private String nombre;
    private String descripcion;
    private Float precio;
    private Integer stock;
   
    public Producto() {
    }
    
    //id
    public Integer getIdProducto() {
        return idProducto;
    }
    
    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }
    
    //nombre
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    //descripcion
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    //precio
    public Float getPrecio() {
        return precio;
    }
    
    public void setPrecio(Float precio) {
        this.precio = precio;
    }
    
    //stock
    public Integer getStock() {
        return stock;
    }
    
    public void setStock(Integer stock) {
        this.stock = stock;
    }
} 