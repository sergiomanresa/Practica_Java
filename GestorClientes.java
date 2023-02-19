package Practica_evaluacion;
/**
 * Clase para los la gestion de los clientes
 *
 * @author Sergio Manresa
 * @version 1.0
 * @since 11/01/2023
 */
import java.util.ArrayList;
import java.util.Arrays;

public class GestorClientes {
    private ArrayList<Clientes> listado_de_clientes = new ArrayList<>();

    public GestorClientes() {
    }

    public GestorClientes(ArrayList<Clientes> Listado_de_clientes){
        listado_de_clientes = Listado_de_clientes;
    }

    public void setListado_de_clientes(ArrayList<Clientes> Listado_de_clientes) {
        listado_de_clientes = Listado_de_clientes;
    }

    public ArrayList<Clientes> getListado_de_clientes() {
        return listado_de_clientes;
    }

    /**
     * Muestra los datos básicos de los clientes que se encuentran en el listado
     */
    public void mostrarCliente(){
        for (Clientes clientes:listado_de_clientes){
            System.out.println(clientes.getNombre());
            System.out.println(clientes.getApellidos());
            System.out.println(clientes.getDni());
        }
    }
    /**
     * Busca un cliente en el listado de clientes
     *
     * @param clienteBuscar
     * @return cliente encontrado
     */
    public boolean buscarCliente(Clientes clienteBuscar){
        for(Clientes cliente : listado_de_clientes){
            if(cliente.equals(clienteBuscar)){
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
    public void agregarCliente(Clientes cliente){
        listado_de_clientes.add(cliente);
    }

    /**
     * Genera 7 clientes de prueba
     */
    public void generarClientesBase(){
        listado_de_clientes.add( new Clientes("Antonio", "Box Sanchez","antoniob@gmail.com","636439552","89704325H","11/11/2004","PPPP34"));
        listado_de_clientes.add( new Clientes("Jorge", "Carmona Girona", "JorgeJ@gmail.com","626437351","32480956F","10/11/2004","PPPP32"));
        listado_de_clientes.add( new Clientes("Sergio", "Manresa Bernabeu", "serj@gmail.com","97683242","90832424K","12/11/2004","PPPP33"));
        listado_de_clientes.add(new Clientes("Alexis", "Escolano Mora", "AleA@gmail.com","807932488","34267823O","13/11/2004","PPPP35"));
        listado_de_clientes.add(new Clientes("Manuel", "Garcia Santamaria","ManuR@gmail.com","210987123","78634289L","14/11/2004","PPPP38"));
        listado_de_clientes.add(new Clientes("Fulgencio", "Ortuño", "Fg@gmail.com","756123890","08912345U","15/11/2004","PPPP36"));
        listado_de_clientes.add(new Clientes("Jorge", "Pelegrin", "Descapotao@gmail.com","321487945","68712323P","16/11/2004","PPPP00"));

    }
    

}
