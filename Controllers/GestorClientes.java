package Practica_evaluacion.Controllers;
/**
 * Clase para los la gestion de los clientes
 *
 * @author Sergio Manresa
 * @version 1.0
 * @since 11/01/2023
 */
import Practica_evaluacion.Utils.Validaciones;
import Practica_evaluacion.excepcion.EmailInvalidoException;
import Practica_evaluacion.excepcion.NombreNoValidoException;
import Practica_evaluacion.excepcion.NumeroInvalidoException;
import Practica_evaluacion.excepcion.StringVacioException;
import Practica_evaluacion.models.Cliente;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Scanner;

public class GestorClientes {
    private ArrayList<Cliente> listado_de_clientes = new ArrayList<>();

    public GestorClientes() {
            cargar_fichero();
    }

    public GestorClientes(ArrayList<Cliente> listado_de_clientes){
        listado_de_clientes = listado_de_clientes;
    }

    public void setListado_de_clientes(ArrayList<Cliente> listado_de_clientes) {
        listado_de_clientes = listado_de_clientes;
    }

    public ArrayList<Cliente> getListado_de_clientes() {
        return listado_de_clientes;
    }

    /**
     * Muestra los datos básicos de los clientes que se encuentran en el listado
     */
    public void mostrarCliente(){
        for (Cliente cliente :listado_de_clientes){
            System.out.println(cliente.getNombre());
            System.out.println(cliente.getApellidos());
            System.out.println(cliente.getDni());
        }
    }
    /**
     * Busca un cliente en el listado de clientes
     *
     * @param clienteBuscar
     * @return cliente encontrado
     */
    public boolean buscarCliente(Cliente clienteBuscar){
        for(Cliente cliente : listado_de_clientes){
            if(cliente.getEmail().equals(clienteBuscar.getEmail())){
                System.out.println("Cliente encontrado");
                return true;
            }
        }
        return false;
    }



    /**
     * Agrega un cliente al final del listado de clientes
     *
     * @param cliente
     */
    public void agregarCliente(Cliente cliente){
        listado_de_clientes.add(cliente);
    }

    /**
     * Genera 7 clientes de prueba
     */
    public void generarClientesBase(){
        listado_de_clientes.add( new Cliente("Antonio", "Box Sanchez","antoniob@gmail.com","636439552","89704325H","11/11/2004","PPPP34"));
        listado_de_clientes.add( new Cliente("Jorge", "Carmona Girona", "JorgeJ@gmail.com","626437351","32480956F","10/11/2004","PPPP32"));
        listado_de_clientes.add( new Cliente("Sergio", "Manresa Bernabeu", "serj@gmail.com","97683242","90832424K","12/11/2004","PPPP33"));
        listado_de_clientes.add(new Cliente("Alexis", "Escolano Mora", "AleA@gmail.com","807932488","34267823O","13/11/2004","PPPP35"));
        listado_de_clientes.add(new Cliente("Manuel", "Garcia Santamaria","ManuR@gmail.com","210987123","78634289L","14/11/2004","PPPP38"));
        listado_de_clientes.add(new Cliente("Fulgencio", "Ortuño", "Fg@gmail.com","756123890","08912345U","15/11/2004","PPPP36"));
        listado_de_clientes.add(new Cliente("Jorge", "Pelegrin", "Descapotao@gmail.com","321487945","68712323P","16/11/2004","PPPP00"));

    }

    /**
     * Carga el fichero del cliente en el gestor
     */
    private void cargar_fichero() {
        FileReader fr;
        try {
             fr=new FileReader("data/clientes");
        }
        catch (FileNotFoundException f){
            f.printStackTrace();
            return;
        }
        BufferedReader br=new BufferedReader(fr);
        String linea = "";
        String[] dato_cliente;
        while (linea!=null){
            try{
                 linea = br.readLine();
                 dato_cliente=linea.split(",");
                 listado_de_clientes.add(new Cliente(dato_cliente[0],dato_cliente[1],dato_cliente[2],dato_cliente[3],dato_cliente[4],dato_cliente[5],dato_cliente[6]));
            }catch(IOException e){
                e.printStackTrace();
            }

        }

    }

    public void registro_clientes(){
        Scanner scanner=new Scanner(System.in);


        //variables
        String dni;
        String email_usuario;
        String codigo_usuario;
        String email = "";
        String control = "";
        String nombre="";
        String apellidos="";
        String telefono="";
        String fechanacimiento="";


        System.out.println("**************");
        System.out.println("** Registro **");
        System.out.println("**************");
        System.out.println("Introduce los siguientes datos:");
        System.out.println("_______________________________");

        do {
            System.out.println("DNI:");
            dni=scanner.nextLine();
            dni=dni.toUpperCase();
        }while (!Validaciones.dni(dni));


        do {
            System.out.println("Nombre:");
            nombre=scanner.nextLine();
            nombre=nombre.toUpperCase();

            try {
                Validaciones.nombrecorrecto(nombre,false);
            }catch (StringVacioException| NombreNoValidoException e){
                System.out.printf(e.getMessage());
                continue;
            }
            break;

        }while (true);

        do {
            System.out.println("Apellidos:");
            apellidos= scanner.nextLine();
            apellidos=apellidos.toUpperCase();

            try {
                Validaciones.nombrecorrecto(apellidos,true);
            } catch (StringVacioException | NombreNoValidoException e) {
                System.out.printf(e.getMessage());
                continue;
            }
            break;
        }while (true);

        do {
            System.out.println("Email:");
            email= scanner.nextLine();

            try {
                Validaciones.emailcorrecto(email);
            } catch (StringVacioException | EmailInvalidoException e){
                System.out.printf(e.getMessage());
                continue;
            }
            break;
        }while (true);


        do {
            System.out.println("Teléfono:");
            telefono= scanner.nextLine();
            try{
                Validaciones.numerocorrecto(telefono);
            } catch (NumeroInvalidoException e){
                System.out.printf(e.getMessage());
                continue;
            }
            break;
        }while (true);
        do {
            System.out.println("Fecha de nacimiento (dd/mm/aaaa) o (dd-mm-aaaa):");
            fechanacimiento= scanner.nextLine();
            try {
                Validaciones.numerocorrecto(telefono);
            }catch (NumeroInvalidoException e){
                System.out.printf(e.getMessage());
                continue;
            }
            break;

        }while (true);
        do {
            System.out.println("Frase de control (4 palabras separadas por 1 espacio cada palabra):");
            control= scanner.nextLine();
            control=control.toUpperCase();
            try {
                Validaciones.primera_letra(control);
            }catch (StringVacioException e){

                System.out.printf(e.getMessage());

            }
            System.out.print("tu código es:");
            System.out.println(control);
            Cliente cliente=new Cliente(nombre,apellidos,email,telefono,dni);



    }
    

}
