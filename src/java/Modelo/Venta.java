/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Timestamp;

public class Venta {
     private int codigoVenta;
    private String cliente;
     private int codusu;
    private Timestamp fecha;
       private String fchreser;
          private String hrareser;
             private String obser;
              private int estado;

    public Venta(int codigoVenta, int codusu, String cliente, Timestamp fecha,String fchreser,String hrareser,String obser, int estado) {
        this.codigoVenta = codigoVenta;
          this.codusu = codusu;
        this.cliente = cliente;
        this.fecha = fecha;
         this.fchreser = fchreser;
        this.hrareser = hrareser;
        this.obser = obser;
         this.estado = estado;
    }
    public Venta(int codigoVenta, int codusu, String cliente, Timestamp fecha,String fchreser,String hrareser,String obser) {
        this.codigoVenta = codigoVenta;
          this.codusu = codusu;
        this.cliente = cliente;
        this.fecha = fecha;
         this.fchreser = fchreser;
        this.hrareser = hrareser;
        this.obser = obser;
        
    }
      public Venta(int codigoVenta, String cliente, Timestamp fecha) {
        this.codigoVenta = codigoVenta;
        this.cliente = cliente;
        this.fecha = fecha;
 
    }

    public Venta() {
    }

    public int getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(int codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public String getFchreser() {
        return fchreser;
    }

    public void setFchreser(String fchreser) {
        this.fchreser = fchreser;
    }

    public String getHrareser() {
        return hrareser;
    }

    public void setHrareser(String hrareser) {
        this.hrareser = hrareser;
    }

    public String getObser() {
        return obser;
    }

    public void setObser(String obser) {
        this.obser = obser;
    }

    public int getCodusu() {
        return codusu;
    }

    public void setCodusu(int codusu) {
        this.codusu = codusu;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
}
