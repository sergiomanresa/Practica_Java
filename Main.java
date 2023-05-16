package Practica_evaluacion;

import Practica_evaluacion.Controllers.GestorClientes;
import Practica_evaluacion.Utils.Validaciones;
import Practica_evaluacion.models.Cliente;
import Practica_evaluacion.models.Habitacion;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
            //Arraylists,Hashmap y scanner
            Scanner scanner=new Scanner(System.in);
            HashMap<Integer,String> habitacion_elegida = new HashMap<>();
            ArrayList<Habitacion> habitacion_posible= new ArrayList<>();
            ArrayList<Cliente> cliente =new ArrayList<>();
            GestorClientes gestor=new GestorClientes(cliente);
            gestor.generarClientesBase();
            ArrayList<Habitacion> habitacion_reserva=new ArrayList<>();
            ArrayList<Habitacion> habitacion_repetidas=new ArrayList<>();
            GestorClientes gestorClientes=new GestorClientes();


            //variables


            String opcion_habitaciones2="";
            String opcion_habitaciones="";
            boolean habitacion_no_repetida=true;
            int opcion_=0;
            int incremento=0;
            int persona_final=0;
            int people=0;
            String fecha_salida="";
            String fecha_entrada="";
            String personas="";
            char caso = ' ';
            String opcion="";



            //menu
            while(!opcion.equals("0")){
                System.out.println("************************");
                System.out.println("****  MUÑÓN DREAMS  ****");
                System.out.println("************************");
                System.out.println("1. Registro usuario");
                System.out.println("2. Login usuario");
                System.out.println("0. Salir");
                System.out.println("Opción en numero:");
                opcion = scanner.nextLine();

                if (opcion.length()==1)
                    caso=opcion.charAt(0);
                else
                    System.out.println("opcion invalida");

                switch (caso){

                    case '1' :
                        gestorClientes.registro_clientes();
                        break;
                    case '2':
                        gestorClientes.login_cliente();

                        switch (caso){
                            case '1':
                                System.out.println("*******RESERVAR HABITACIÓN********");
                                do {
                                    do {
                                        System.out.println("¿Para cuántas personas se hace la reserva?(Máximo 9 personas)");
                                        personas= scanner.nextLine();
                                    }while (Validaciones.noTieneNada(personas)||!Validaciones.solo_numero(personas));
                                    persona_final= Integer.parseInt(personas);
                                }while (!Validaciones.solo_numero(personas)|| !(persona_final <=9));

                                do {
                                    System.out.println("¿Cuál es la fecha de entrada?");
                                    fecha_entrada= scanner.nextLine();
                                    System.out.println("¿Cuál es la fecha de salida?");
                                    fecha_salida= scanner.nextLine();
                                }while (!Validaciones.comprobar_fecha_entrada_salida(fecha_entrada,fecha_salida));

                                people=persona_final;
                                Habitacion habitacion = new Habitacion();
                                habitacion.generar_habitaciones_base();
                                // Se itera sobre la lista de habitaciones y se busca aquellas que sean adecuadas para el número de personas y no estén ocupadas.
                                for (Habitacion habitacion_ : habitacion.getListado_de_habitaciones()){
                                    if (habitacion_.getMax_personas()== people && !habitacion_.isOcupada()){
                                        System.out.println("Tenemos disponibles para esa fecha: ");
                                        System.out.println("Opción: "+ (++incremento));
                                        System.out.println("Habitación "+ habitacion_.getNombre()+" para "+ habitacion_.getMax_personas()+" personas ");
                                        opcion_habitaciones+=habitacion_.getId();
                                        dinero_habitaciones+= habitacion_.getPrecio();
                                        habitacion_reserva.add(habitacion_);
                                        habitacion_posible.add(habitacion_);
                                        habitacion_elegida.put(incremento, opcion_habitaciones);
                                        System.out.println("son "+habitacion_.getPrecio()+" euros");
                                        dinero_habitaciones+= 0.0;

                                    }
                                }

                                people=persona_final;
                                //Se itera de nuevo sobre la lista de habitaciones, pero esta vez se buscan combinaciones de habitaciones que en conjunto puedan alojar al número de personas requerido.
                                for (Habitacion habitacion_ : habitacion.getListado_de_habitaciones()) {
                                    habitacion_repetidas.add(habitacion_);
                                    if (persona_final != habitacion_.getMax_personas()){
                                        habitacion_no_repetida=true;
                                        for (Habitacion habitacion_comp : habitacion.getListado_de_habitaciones()) {
                                            if (!habitacion_.equals(habitacion_comp)){
                                                if ((habitacion_.getMax_personas() + habitacion_comp.getMax_personas() == persona_final) && (!habitacion_comp.isOcupada() && !habitacion_.isOcupada())){
                                                    for (Habitacion habitacion__ : habitacion_repetidas){
                                                        if (habitacion_comp.equals(habitacion__)) {
                                                            habitacion_no_repetida = false;
                                                            break;
                                                        }
                                                    }
                                                    if(habitacion_no_repetida){
                                                        opcion_habitaciones2="";
                                                        System.out.println("Opción: "+ (++incremento));
                                                        System.out.println("Habitación "+ habitacion_.getNombre()+" para "+ habitacion_.getMax_personas()+" personas ");
                                                        System.out.println("Habitación "+ habitacion_comp.getNombre()+" para "+ habitacion_comp.getMax_personas()+" personas ");
                                                        System.out.println(habitacion_.getPrecio()+habitacion_comp.getPrecio()+" euros");
                                                        opcion_habitaciones2+=habitacion_.getId()+","+habitacion_comp.getId();
                                                        dinero_habitaciones+= habitacion_.getPrecio()+habitacion_comp.getPrecio();
                                                        habitacion_posible.add(habitacion_);
                                                        habitacion_posible.add(habitacion_comp);
                                                        habitacion_elegida.put(incremento, opcion_habitaciones2);
                                                    }

                                                }
                                                habitacion_no_repetida=true;
                                            }
                                        }
                                    }
                                }
                                int max = 0;
                                for(int opcion__ : habitacion_elegida.keySet()){
                                    max = opcion__;
                                }
                                do {
                                    do {
                                        System.out.println("Opción en numero: ");
                                        opcion = scanner.nextLine();
                                    }while (Validaciones.noTieneNada(opcion)||!Validaciones.solo_numero(opcion) && Integer.parseInt(opcion)>max || Integer.parseInt(opcion)<0);

                                    if (opcion_<0 || opcion_>habitacion_elegida.size()){
                                        System.out.println("Opción no valida");
                                    }
                                }while (opcion_<0 || opcion_>habitacion_elegida.size());

                                break;

                            case '2':
                                do {
                                    gestorClientes.Preguntas();
                                }while (!opcion.equals("0"));
                                break;

                            case '3':
                                do {
                                   gestorClientes.pago();
                                }while (!opcion.equals("1") && !opcion.equals("2") && !opcion.equals("0"));
                                break;
                        }
                    case '0':
                        System.out.println("Hasta luego");
                        break;
                }
                break;
            }
        }
    }}