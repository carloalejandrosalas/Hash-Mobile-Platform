
package controllers;


public class listaclientes {

   private String estado;
   private String ciudad;
   private String localidad;
   private String nombre;
   private String telefono;
   private String correo;
   private String plan;
   private String tipo_plan;

    public listaclientes(String estado, String ciudad, String localidad, String nombre, String telefono, String correo, String plan, String tipo_plan) {
        this.estado = estado;
        this.ciudad = ciudad;
        this.localidad = localidad;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.plan = plan;
        this.tipo_plan = tipo_plan;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getTipo_plan() {
        return tipo_plan;
    }

    public void setTipo_plan(String tipo_plan) {
        this.tipo_plan = tipo_plan;
    }
    
    
}

    