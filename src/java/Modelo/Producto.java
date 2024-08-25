
package Modelo;


public class Producto {
    private int codigoProducto;
    private String nombre;
    private double precio;
    private String imagen;
      private String descrip;
      private String categoria;
       private int stock;

    public Producto(int codigoProducto, String nombre, double precio, String imagen, String descrip,String categoria,int stock) {
        this.codigoProducto = codigoProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.imagen = imagen;
         this.descrip = descrip;
          this.categoria = categoria;
         this.stock = stock;
        
    }

    public Producto(int codigoProducto, String nombre, double precio,String descrip,String categoria,int stock) {
        this.codigoProducto = codigoProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.descrip = descrip;
        this.categoria = categoria;
        this.stock = stock;
    }

    public Producto(String nombre, double precio, String imagen,String descrip,String categoria,int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.imagen = imagen;
        this.descrip = descrip;
        this.categoria = categoria;
          this.stock = stock;
    }
        public Producto(String nombre, double precio, String imagen,int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.imagen = imagen;
          this.stock = stock;
    }
          public Producto(int codigoProducto, String nombre, double precio,int stock) {
        this.codigoProducto = codigoProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }


    public Producto() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getParameter(String txtStock) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
   
      
}
