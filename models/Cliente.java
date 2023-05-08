package Practica_evaluacion.models;

/**
 * Clase para los clientes
 *
 * @author Sergio Manresa
 * @version 1.0
 * @since 11/01/2023
 */
public class Cliente {
    //Atributos
    private String Nombre;
    private String Apellidos;
    private String Email;
    private String Telefono;
    private String Dni;
    private String Fecha_de_nacimiento;
    private String Codigo_de_Acceso;
    //Contructor por defecto
    public Cliente(String nombre, String apellidos, String email, String telefono, String dni) {
    }
    //Contructor con los atributos de los clientes
    public Cliente(String nombre, String apellidos, String email, String telefono, String dni, String fecha_de_nacimiento, String codigo_de_Acceso) {
        Nombre = nombre;
        Apellidos = apellidos;
        Email = email;
        Telefono = telefono;
        Dni = dni;
        Fecha_de_nacimiento = fecha_de_nacimiento;
        Codigo_de_Acceso = codigo_de_Acceso;
    }
    //getter y setters
    public Cliente(String nombre, String apellidos, String dni) {
        Nombre = nombre;
        Apellidos = apellidos;
        Dni = dni;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getDni() {
        return Dni;
    }

    public void setDni(String dni) {
        Dni = dni;
    }

    public String getFecha_de_nacimiento() {
        return Fecha_de_nacimiento;
    }

    public void setFecha_de_nacimiento(String fecha_de_nacimiento) {
        Fecha_de_nacimiento = fecha_de_nacimiento;
    }

    public String getCodigo_de_Acceso() {
        return Codigo_de_Acceso;
    }

    public void setCodigo_de_Acceso(String codigo_de_Acceso) {
        Codigo_de_Acceso = codigo_de_Acceso;
    }

    @Override
    public String toString() {
        return "Clientes{" +
                "Nombre='" + Nombre + '\'' +
                ", Apellidos='" + Apellidos + '\'' +
                ", Email='" + Email + '\'' +
                ", Telefono='" + Telefono + '\'' +
                ", Dni='" + Dni + '\'' +
                ", Fecha_de_nacimiento='" + Fecha_de_nacimiento + '\'' +
                ", Codigo_de_Acceso='" + Codigo_de_Acceso + '\'' +
                '}';
    }

    /**
     *
     * @return información basica de los clientes
     */
    public String infoBasica(){
        return  Nombre +"\n"+
                Apellidos +"\n"+
                Email +"\n"+
                Dni
               ;
    }


}
