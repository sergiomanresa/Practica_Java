package Practica_evaluacion.models;

import java.util.ArrayList;

/**
 * Clase para las habitaciones
 *
 * @author Sergio Manresa
 * @version 1.0
 * @since 11/01/2023
 */


public class Habitacion {
    private ArrayList<Habitacion> listado_de_habitaciones = new ArrayList<>();
    //Atributos
    private boolean ocupada;
    private int id;
    private String nombre;
    private String descripcion;
    private int num_camas;
    private int max_personas;
    private boolean banera;
    private double precio;

    //constructor por defecto

    public Habitacion() {
    }

    //constructor con los atributos

    public Habitacion(int id, String nombre, String descripcion, int num_camas, int max_personas, boolean banera, double precio,boolean ocupada) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.num_camas = num_camas;
        this.max_personas = max_personas;
        this.banera = banera;
        this.precio = precio;
        this.ocupada = ocupada;
    }


//ArrayList
    public ArrayList<Habitacion> getListado_de_habitaciones() {
        return listado_de_habitaciones;
    }

    public void setListado_de_habitaciones(ArrayList<Habitacion> listado_de_habitaciones) {
        this.listado_de_habitaciones = listado_de_habitaciones;
    }
    //getters y setters
    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getNum_camas() {
        return num_camas;
    }

    public void setNum_camas(int num_camas) {
        this.num_camas = num_camas;
    }

    public int getMax_personas() {
        return max_personas;
    }

    public void setMax_personas(int max_personas) {
        this.max_personas = max_personas;
    }

    public boolean isBanera() {
        return banera;
    }

    public void setBanera(boolean banera) {
        this.banera = banera;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * se encarga de generar 5 habitaciones y meterlas en un arraylist.
     * @return lista de habitaciones
     */
    public void generar_habitaciones_base(){
        listado_de_habitaciones.add(new Habitacion(1,"a1","pequeña",1,1,true,12,false));
        listado_de_habitaciones.add (new Habitacion(2,"a2","mediana",2,2,true,24,false));
        listado_de_habitaciones.add (new Habitacion(3,"a3","grande",3,3,true,36,false));
        listado_de_habitaciones.add (new Habitacion(4,"a4"," vista montaña",2,4,true,48,false));
        listado_de_habitaciones.add (new Habitacion(5,"a5","vistas a carmona",2,5,true,100,false));
    }



}
