package Practica_evaluacion.models;

/**
 * Clase para las reservas
 *
 * @author Sergio Manresa
 * @version 1.0
 * @since 11/01/2023
 */
public class Reservas {
    //atributos
    //el cod va a ser un numero aleatorio
    private int cod;
    private String id_cliente;
    private int id_habitacion;
    private String fecha_entrada;
    private String fecha_salida;

    //constructor por defecto
    public Reservas() {
    }

    //constructor con los atributos
    public Reservas(int cod, String id_cliente, int id_habitacion, String fecha_entrada, String fecha_salida) {
        this.cod = cod;
        this.id_cliente = id_cliente;
        this.id_habitacion = id_habitacion;
        this.fecha_entrada = fecha_entrada;
        this.fecha_salida = fecha_salida;
    }

    //getters y setters
    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_habitacion() {
        return id_habitacion;
    }

    public void setId_habitacion(int id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    public String getFecha_entrada() {
        return fecha_entrada;
    }

    public void setFecha_entrada(String fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }

    public String getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(String fecha_salida) {
        this.fecha_salida = fecha_salida;
    }
}
