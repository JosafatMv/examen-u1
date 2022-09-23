package client;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class RPCClient {
    public static void main(String[] args) throws MalformedURLException, XmlRpcException{
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://localhost:1200"));
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);

        Scanner sc = new Scanner(System.in);

        String opt;
        String response;


        do {

            System.out.println("-----Menú de opciones-----");
            System.out.println("1. Registro de personas");
            System.out.println("2. Consultar persona por CURP");
            System.out.println("3. Modificar persona");
            System.out.println("4. Consultar personas");
            System.out.println("5. Eliminar persona");
            System.out.println("6. Salir");

            opt = sc.next();

            switch (opt){
                case "1":
                    System.out.println("-----Registro de personas-----");

                    System.out.println("Ingrese el nombre:");
                    String nombre = sc.next();

                    System.out.println("Ingrese el primer apellido:");
                    String apellidoPaterno = sc.next();

                    System.out.println("Ingrese el segundo apellido:");
                    String apellidoMaterno = sc.next();

                    System.out.println("Ingrese la CURP:");
                    String curp = sc.next();

                    System.out.println("Ingrese la fecha de nacimiento(2003-04-19):");
                    String fechaNacimiento = sc.next();


                    Object[] info = {nombre, apellidoPaterno, apellidoMaterno, curp, fechaNacimiento};
                    response =  (String) client.execute("Methods.registerPersons", info);
                    System.out.println("");
                    System.out.println(response);
                    System.out.println("");

                    break;

                case "2":
                    System.out.println("-----Consultar persona-----");

                    System.out.println("Ingrese la curp de la persona:");
                    String curpABuscar = sc.next();


                    Object[] infoABuscar = {curpABuscar};
                    response =  (String) client.execute("Methods.getPerson", infoABuscar);
                    System.out.println("");
                    System.out.println(response);
                    System.out.println("");
                    break;

                case "3":
                    System.out.println("-----Modificar persona-----");

                    System.out.println("Ingrese la curp de la persona:");
                    String curpAModificar = sc.next();


                    Object[] infoAVerificar = {curpAModificar};
                    boolean curpExist =  (Boolean) client.execute("Methods.curpExist", infoAVerificar);

                    if (curpExist){
                        System.out.println("Ingrese el nombre:");
                        String nombreAModificar = sc.next();

                        System.out.println("Ingrese el primer apellido:");
                        String apellidoPaternoAModificar = sc.next();

                        System.out.println("Ingrese el segundo apellido:");
                        String apellidoMaternoAModificar = sc.next();

                        System.out.println("Ingrese la fecha de nacimiento (2003-04-19):");
                        String fechaNacimientoAModificar = sc.next();



                        Object[] infoAModificar = {nombreAModificar, apellidoPaternoAModificar, apellidoMaternoAModificar, curpAModificar, fechaNacimientoAModificar};
                        response =  (String) client.execute("Methods.updatePerson", infoAModificar);
                        System.out.println("");
                        System.out.println(response);
                        System.out.println("");
                    }else{
                        System.out.println("");
                        System.out.println("La curp no existe");
                        System.out.println("");
                    }

                    break;

                case "4":
                    System.out.println("-----Lista de personas-----");

                    Object[] nullObj = {};
                    response =  (String) client.execute("Methods.getPersons", nullObj);

                    System.out.println(response);
                    break;

                case "5":
                    System.out.println("-----Eliminar persona-----");

                    System.out.println("Ingrese la curp de la persona:");
                    String curpAEliminar = sc.next();


                    Object[] infoAEliminar = {curpAEliminar};
                    response =  (String) client.execute("Methods.deletePerson", infoAEliminar);
                    System.out.println("");
                    System.out.println(response);
                    System.out.println("");
                    break;
            }


        } while (!opt.equals("6"));


    }

}
