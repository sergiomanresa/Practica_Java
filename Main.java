package Practica_evaluacion;

import java.sql.Date;
import java.sql.Time;
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
        ArrayList<String> room = new ArrayList<>();
        ArrayList<Clientes> cliente =new ArrayList<>();
        GestorClientes gestor=new GestorClientes(cliente);
        gestor.generarClientesBase();
        ArrayList<Habitacion> habitacion_reserva=new ArrayList<>();
        ArrayList<Habitacion> habitacion_repetidas=new ArrayList<>();


        //variables
        String opcion_habitaciones2="";
        String opcion_habitaciones="";
        boolean habitacion_no_repetida=true;
        int opcion_=0;
        int incremento=0;
        int codigo_factura= (int) (Math.random()*10000+1);
        String tarjeta="";
        String pregunta="";
        int precio=0;
        int persona_final=0;
        int people=0;
        String fecha_salida="";
        String fecha_entrada="";
        String personas="";
        char caso = ' ';
        String opcion="";
        String email_usuario;
        String codigo_usuario;
        String email = "";
        String control = "";
        String nombre="";
        String apellidos="";
        String telefono="";
        String fechanacimiento="";


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
                        System.out.println("**************");
                        System.out.println("** Registro **");
                        System.out.println("**************");
                        System.out.println("Introduce los siguientes datos:");
                        System.out.println("_______________________________");

                        do {
                            System.out.println("Nombre:");
                            nombre=scanner.nextLine();
                            nombre=nombre.toUpperCase();
                        }while (!Practica_evaluacion.Validaciones.nombrecorrecto(nombre,false));
                        do {
                            System.out.println("Apellidos:");
                            apellidos= scanner.nextLine();
                            apellidos=apellidos.toUpperCase();
                        }while (!Practica_evaluacion.Validaciones.nombrecorrecto(apellidos,true));
                        do {
                            System.out.println("Email:");
                            email= scanner.nextLine();
                        }while (!Practica_evaluacion.Validaciones.emailcorrecto(email));
                        do {
                            System.out.println("Teléfono:");
                            telefono= scanner.nextLine();
                        }while (!Practica_evaluacion.Validaciones.numerocorrecto(telefono));
                        do {
                            System.out.println("Fecha de nacimiento (dd/mm/aaaa) o (dd-mm-aaaa):");
                            fechanacimiento= scanner.nextLine();
                        }while (!Practica_evaluacion.Validaciones.fechaCorrecta(fechanacimiento));
                        do {
                            System.out.println("Frase de control (4 palabras separadas por 1 espacio cada palabra):");
                            control= scanner.nextLine();
                            control=control.toUpperCase();
                            //aquí nos aseguramos de que si todos los parámetros son correctos imprima el código de seguridad
                            control = Practica_evaluacion.Validaciones.primera_letra(control);
                        }while (control.equals("ERROR"));

                        if ( Practica_evaluacion.Validaciones.comprobarentradas(nombre,apellidos,email,telefono,fechanacimiento,control)){
                            System.out.print("tu código es:");
                            System.out.println(control);

                        }else{
                            System.out.println("has fallado la autentificación  vuelve a empezar");
                        }
                        break;
                    case '2':
                            System.out.println("Dime tu email de usuario:");
                            email_usuario = scanner.nextLine();
                            System.out.println("Dime tu código:");
                            codigo_usuario= scanner.nextLine();
                            //aquí nos encargaremos de que el código y el email sean iguales a los que están registrados
                            //y que el usuario, email o ambas estén vacíos
                        if (!Validaciones.noTieneNada(email_usuario)||!Validaciones.noTieneNada(codigo_usuario)){
                           if(!Validaciones.igual(email,control,email_usuario,codigo_usuario)){
                               do {
                                   System.out.printf("*****Bienvenido al hotel*******\n");
                                   System.out.printf("\n1. Reserva de habitación");
                                   System.out.printf("\n2. Atención al cliente");
                                   System.out.printf("\n3. Pago online con factura");
                                   System.out.printf("\n4. Salir\n");
                                   System.out.println("\n Opción en numero: ");
                                   opcion = scanner.nextLine();
                                   if (opcion.length()==1){
                                       caso=opcion.charAt(0);
                                   } else{
                                       System.out.println("opción invalida");
                                   }
                               }while (!opcion.equals("1")||!opcion.equals("2")||!opcion.equals("3")||!opcion.equals("4"));
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
                                        }while (Validaciones.comprobar_fecha_entrada_salida(fecha_entrada,fecha_salida));

                                        people=persona_final;
                                        Habitacion habitacion = new Habitacion();
                                        habitacion.generar_habitaciones_base();
                                        for (Habitacion habitacion_ : habitacion.getListado_de_habitaciones()){
                                            if (habitacion_.getMax_personas()== people && !habitacion_.isOcupada()){
                                                System.out.println("Tenemos disponibles para esa fecha: ");
                                                System.out.println("Opción: "+ (++incremento));
                                                System.out.println("Habitación "+ habitacion_.getNombre()+" para "+ habitacion_.getMax_personas()+" personas ");
                                                opcion_habitaciones+=habitacion_.getId();
                                                precio+= habitacion_.getPrecio();
                                                habitacion_reserva.add(habitacion_);
                                                habitacion_posible.add(habitacion_);
                                                habitacion_elegida.put(incremento,new String(opcion_habitaciones));
                                                System.out.println("son "+habitacion_.getPrecio()+" euros");
                                            }
                                        }
                                        people=persona_final;
                                                for (Habitacion habitacion_ : habitacion.getListado_de_habitaciones()) {
                                                    habitacion_repetidas.add(habitacion_);
                                                    if (persona_final != habitacion_.getMax_personas()){
                                                        habitacion_no_repetida=true;
                                                        for (Habitacion habitacion_comp : habitacion.getListado_de_habitaciones()) {
                                                            if (!habitacion_.equals(habitacion_comp)){
                                                                if ((habitacion_.getMax_personas() + habitacion_comp.getMax_personas() == persona_final) && (!habitacion_comp.isOcupada() && !habitacion_.isOcupada())){
                                                                    for (Habitacion habitacion__ : habitacion_repetidas){
                                                                        if (habitacion_comp.equals(habitacion__)){
                                                                            habitacion_no_repetida=false;
                                                                        }
                                                                    }
                                                                    if(habitacion_no_repetida){
                                                                        opcion_habitaciones2="";
                                                                        System.out.println("Opción: "+ (++incremento));
                                                                        System.out.println("Habitación "+ habitacion_.getNombre()+" para "+ habitacion_.getMax_personas()+" personas ");
                                                                        System.out.println("Habitación "+ habitacion_comp.getNombre()+" para "+ habitacion_comp.getMax_personas()+" personas ");
                                                                        System.out.println(habitacion_.getPrecio()+habitacion_comp.getPrecio()+" euros");
                                                                        opcion_habitaciones2+=habitacion_.getId()+","+habitacion_comp.getId();
                                                                        habitacion_posible.add(habitacion_);
                                                                        habitacion_posible.add(habitacion_comp);
                                                                        habitacion_elegida.put(incremento,new String(opcion_habitaciones2));
                                                                    }
                                                                }
                                                                habitacion_no_repetida=true;
                                                            }
                                                        }
                                                    }
                                                }
                                        do {
                                            do {
                                                System.out.println("Opción en numero: ");
                                                opcion = scanner.nextLine();
                                            }while (Validaciones.noTieneNada(opcion)||!Validaciones.solo_numero(opcion));

                                            if (opcion_<0 || opcion_>habitacion_elegida.size()){
                                                System.out.println("Opción no valida");
                                            }
                                        }while (opcion_<0 || opcion_>habitacion_elegida.size());

                                        break;

                                    case '2':
                                        do {
                                            System.out.println("***** PREGUNTAS FRECUENTES *****");
                                            ArrayList<String> preguntas = new ArrayList<String>();
                                            ArrayList<String>respuestas = new ArrayList<String>();
                                            preguntas.add(" Salir");
                                            preguntas.add(" Agregar preguntas");
                                            preguntas.add(" ¿Cómo puedo llamar fuera del hotel con el teléfono de la habitación?");
                                            preguntas.add(" ¿Es gratis la comida de la nevera de la habitation?");
                                            respuestas.add("pulsando el * puedes llamar");
                                            respuestas.add("No no es gratis");
                                            for (int i=0; i<preguntas.size(); i++) {
                                                System.out.println(i + ". "+preguntas.get(i));
                                            }
                                            System.out.println("Opción en número: ");
                                            opcion=scanner.nextLine();
                                            if (!Validaciones.solo_numero(opcion)|| Validaciones.noTieneNada(opcion)){
                                                System.out.println("Solo números");
                                            }
                                            else{
                                                if (opcion.equals("1")){
                                                    System.out.println("Dime la pregunta: ");
                                                    pregunta=scanner.nextLine();
                                                    if (!Validaciones.noTieneNada(pregunta)){
                                                        preguntas.add(pregunta);
                                                        System.out.println("El administrador a recibido la pregunta espere la posible respuesta");
                                                    }else{
                                                        System.out.println("no dejes en blanco la pregunta");
                                                    }
                                                }
                                                else if(Integer.parseInt(opcion)!=0) {
                                                    System.out.println(respuestas.get(Integer.parseInt(opcion)-2));
                                                }
                                            }
                                        }while (!opcion.equals("0"));
                                    break;

                                    case '3':
                                        do {
                                            System.out.println("******* Pago online ********");
                                            System.out.println("opciones de pago : ");
                                            System.out.println("1.Mediante tarjeta de crédito.");
                                            System.out.println("2.Mediante Bizum. ");
                                            System.out.println("0.Salir. ");
                                            System.out.println("opción en numero:");
                                            opcion= scanner.nextLine();
                                            if (!Validaciones.solo_numero(opcion)){
                                                System.out.println("solo números");
                                            }
                                            else{
                                                if (opcion.equals("1")){
                                                    System.out.println("******* Pago mediante tarjeta de crédito ********");
                                                    do {
                                                        System.out.println("Introduce el numero de la tarjeta:");
                                                        tarjeta= scanner.nextLine();

                                                        if (!Validaciones.solo_numero(tarjeta)||!Validaciones.validación_tarjeta(tarjeta)||Validaciones.noTieneNada(tarjeta)){

                                                        }else {
                                                            Validaciones.tipo_tarjeta(tarjeta);
                                                        }
                                                    }while (!Validaciones.solo_numero(tarjeta) || !Validaciones.validación_tarjeta(tarjeta) || Validaciones.noTieneNada(tarjeta));
                                                    System.out.println("*******_Factura_********");
                                                    System.out.println("Datos del cliente: ");
                                                    for (Clientes clientes : gestor.getListado_de_clientes()){
                                                        if (clientes.getNombre().equals("Manuel"))
                                                            System.out.println(clientes.infoBasica());
                                                    }
                                                    String fecha = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
                                                    System.out.println("Fecha factura: "+fecha );
                                                    System.out.println("Código Factura: "+ codigo_factura);
                                                    System.out.println("Descripcion o Concepto"+);
                                                    Validaciones.detectar_id(opcion_habitaciones2);

                                                    System.out.println("Precio total: "+precio);

                                                }
                                                else if (opcion.equals("2")) {
                                                    System.out.println("******* Pago mediante Bizum ********");
                                                    System.out.println("Numero de teléfono:");
                                                    System.out.println("694463985");
                                                }
                                                else if (opcion.equals("0")){
                                                    System.out.println("Saliendo...");
                                                }
                                                else{
                                                    System.out.println("numero fuera de rango ");
                                                }
                                            }
                                        }while (!opcion.equals("1") && !opcion.equals("2") && !opcion.equals("0"));
                                    break;
                                }
                           }
                            else
                                System.out.printf("Tienes que volver al principio\n");
                            break;
                        }
                        else {
                            System.out.printf("No dejes en blanco el email o el código\n ");
                        }
                        break;
                    case '0':
                        System.out.println("Hasta luego");
                        break;

                }
            }
        }
    }