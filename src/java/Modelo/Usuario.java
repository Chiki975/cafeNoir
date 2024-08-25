
package Modelo;

public class Usuario {
      private int codusu;
    private String apeUsu;
    private String nomUsu;
    private String distrito;
    private String perfil;
    private String correo;
    private String claseUsu;

    public Usuario() {
    }

    
    public Usuario(int codusu, String apeUsu, String nomUsu, String distrito, String perfil, String correo, String claseUsu) {
        this.codusu = codusu;
        this.apeUsu = apeUsu;
        this.nomUsu = nomUsu;
        this.distrito = distrito;
        this.perfil = perfil;
        this.correo = correo;
        this.claseUsu = claseUsu;
    }

    public int getCodusu() {
        return codusu;
    }

    public void setCodusu(int codusu) {
        this.codusu = codusu;
    }

    public String getApeUsu() {
        return apeUsu;
    }

    public void setApeUsu(String apeUsu) {
        this.apeUsu = apeUsu;
    }

    public String getNomUsu() {
        return nomUsu;
    }

    public void setNomUsu(String nomUsu) {
        this.nomUsu = nomUsu;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClaseUsu() {
        return claseUsu;
    }

    public void setClaseUsu(String claseUsu) {
        this.claseUsu = claseUsu;
    }
    
    
}
