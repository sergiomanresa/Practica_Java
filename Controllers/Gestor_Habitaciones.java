package Practica_evaluacion.Controllers;

import Practica_evaluacion.excepcion.ArrayHabitacionesVacioException;
import Practica_evaluacion.models.Habitacion;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Gestor_Habitaciones {
    private ArrayList<Habitacion> listado_de_habitaciones = new ArrayList<>();

    public Gestor_Habitaciones(ArrayList<Habitacion> listado_de_habitaciones) {
        this.listado_de_habitaciones = listado_de_habitaciones;
    }

    public ArrayList<Habitacion> getListado_de_habitaciones() {
        return listado_de_habitaciones;
    }

    public void setListado_de_habitaciones(ArrayList<Habitacion> listado_de_habitaciones) {
        this.listado_de_habitaciones = listado_de_habitaciones;
    }

    public void generar_habitaciones_base(){
        listado_de_habitaciones.add(new Habitacion(1,"a1","pequeña",1,1,true,12,false));
        listado_de_habitaciones.add (new Habitacion(2,"a2","mediana",2,2,true,24,false));
        listado_de_habitaciones.add (new Habitacion(3,"a3","grande",3,3,true,36,false));
        listado_de_habitaciones.add (new Habitacion(4,"a4"," vista montaña",2,4,true,48,false));
        listado_de_habitaciones.add (new Habitacion(5,"a5","vistas a carmona",2,5,true,100,false));
    }


    /**
     *  Metodo para guardar los registros de habitaciones
     * @throws IOException
     * @throws ArrayHabitacionesVacioException
     */
    public void  guardar_registro() throws IOException, ArrayHabitacionesVacioException {
        FileWriter fw=new FileWriter("data/habitaciones", false);
        if (listado_de_habitaciones.size()>0){
            for (Habitacion h:listado_de_habitaciones){
                fw.write(h.formatear_objeto());
            }
        }else{
            throw new ArrayHabitacionesVacioException("No existe habitation");

        }
    }
}
