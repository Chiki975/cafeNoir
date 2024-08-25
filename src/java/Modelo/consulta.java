package Modelo;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author xibar
 */
public class consulta {
      private int codigoVenta;
    private String nombrepro;
    private int cantidad;
    private double descuento;

    public consulta(int codigoVenta, String nombrepro, int cantidad, double descuento) {
        this.codigoVenta = codigoVenta;
        this.nombrepro = nombrepro;
        this.cantidad = cantidad;
        this.descuento = descuento;
    }

    public consulta() {
    }
    

    public int getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(int codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    public String getNombrepro() {
        return nombrepro;
    }

    public void setNombrepro(String nombrepro) {
        this.nombrepro = nombrepro;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }
    
    
}

