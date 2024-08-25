
package Modelo;

public class DetalleVenta {
     private int codigoVenta;
    private int codigoProducto;
    private double cantidad;
    private double descuento;
    private Producto producto;
    private Venta venta;
    private String nombrepro;

    public DetalleVenta(int codigoVenta, int codigoProducto, double cantidad, double descuento) {
        this.codigoVenta = codigoVenta;
        this.codigoProducto = codigoProducto;
        this.cantidad = cantidad;
        this.descuento = descuento;
    }

    
    public DetalleVenta(int codigoVenta, int codigoProducto, double cantidad, double descuento, Producto producto, Venta venta) {
        this.codigoVenta = codigoVenta;
        this.codigoProducto = codigoProducto;
        this.cantidad = cantidad;
        this.descuento = descuento;
        this.producto = producto;
        this.venta = venta;
    }
    public DetalleVenta(int codigoVenta, String nombrepro, double cantidad, double descuento) {
        this.codigoVenta = codigoVenta;
        this.nombrepro = nombrepro;
        this.cantidad = cantidad;
        this.descuento = descuento;

    }
    
    public DetalleVenta() {
    }

    public int getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(int codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public String getNombrepro() {
        return nombrepro;
    }

    public void setNombrepro(String nombrepro) {
        this.nombrepro = nombrepro;
    }

    @Override
    public String toString() {
        return "DetalleVenta{" + "codigoVenta=" + codigoVenta + ", codigoProducto=" + codigoProducto + ", cantidad=" + cantidad + ", descuento=" + descuento + ", producto=" + producto + ", venta=" + venta + ", nombrepro=" + nombrepro + '}';
    }
    
}
