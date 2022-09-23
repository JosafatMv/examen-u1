package server;

import java.util.List;

public class Methods {

    public String registerPersons(String nombre, String apellidoPaterno, String apellidoMaterno, String curp, String fechaNacimiento) {

        String rfc = getRfc(nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento);
        System.out.println(rfc);

        String curpUpperCase = curp.toUpperCase();

        boolean exist = verifyCurp(curpUpperCase);
        if (exist) {
            return "Dicha CURP ya esta registrada";
        }

        DaoMethods daoMethods = new DaoMethods();
        boolean result = daoMethods.registerPersons(nombre, apellidoPaterno, apellidoMaterno, curpUpperCase, rfc, fechaNacimiento);

        if (result) {
            return "Persona creada con exito, su RFC es:" + rfc;
        }

        return "Error al registrar a la persona";


    }

    public String getPerson(String curp) {

        boolean exist = verifyCurp(curp);
        if (!exist) {
            return "Curp inexsistente";
        }

        DaoMethods daoMethods = new DaoMethods();
        BeanPerson person = daoMethods.getPerson(curp);

        String result = person.toString();

        return result;
    }

    public String getPersons() {
        DaoMethods daoMethods = new DaoMethods();
        List<BeanPerson> persons = daoMethods.getPersons();

        String result = "";

        for (BeanPerson person : persons) {
            result += person.toString();
            result += "\n";
            result += "\n";
        }

        return result;
    }

    public boolean curpExist(String curp) {
        DaoMethods daoMethods = new DaoMethods();
        return daoMethods.verifyCurp(curp);
    }

    public String updatePerson(String nombre, String apellidoPaterno, String apellidoMaterno, String curp, String fechaNacimiento) {

        String rfc = getRfc(nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento);
        System.out.println(rfc);

        String curpUpperCase = curp.toUpperCase();

        DaoMethods daoMethods = new DaoMethods();
        boolean result = daoMethods.updatePerson(nombre, apellidoPaterno, apellidoMaterno, curpUpperCase, rfc, fechaNacimiento);

        if (result) {
            return "Persona actualizada con exito";
        }

        return "No se pudo actualizar la persona";

    }

    public String deletePerson(String curp) {

        DaoMethods daoMethods = new DaoMethods();
        boolean result = daoMethods.deletePerson(curp);

        if (result) {
            return "Persona eliminada con exito!";
        }

        return "Error al eliminar persona";
    }

    public boolean verifyCurp(String curp) {
        DaoMethods daoMethods = new DaoMethods();
        List<BeanPerson> persons = daoMethods.getPersons();
        boolean exist = false;

        for (BeanPerson person : persons) {
            if (curp.equals(person.getCurp())) {
                exist = true;
            }
        }

        return exist;
    }

    public String getRfc(String nombre, String apellidoPaterno, String apellidoMaterno, String fechaNacimiento) {
        String rfcName = "" + apellidoPaterno.charAt(0) + apellidoPaterno.charAt(1) + apellidoMaterno.charAt(0) + nombre.charAt(0);
        String datePart = fechaNacimiento.substring(2, 4) + fechaNacimiento.substring(5, 7) + fechaNacimiento.substring(8, 10);

        String alphanumerics = "abcdefghijklmnopqrstuvwxyz1234567890";
        String clave = "";
        for (int i = 0; i < 3; i++) {
            int randomNumber = (int) (Math.random() * (alphanumerics.length()) - 1);
            clave += alphanumerics.charAt(randomNumber);
        }
        String rfc = (rfcName + datePart + clave + "").toUpperCase();
        return rfc;
    }

}
