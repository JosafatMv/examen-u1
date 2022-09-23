package server;

import utils.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DaoMethods {
    public boolean registerPersons(String nombre, String apellidoPaterno, String apellidoMaterno, String curp, String rfc, String fechaNacimiento) {

        boolean result = false;

        try(
                Connection con = new MySQLConnection().getConnection();
                PreparedStatement pstm = con.prepareStatement("INSERT INTO persons values(?,?,?,?,?,?)");
                ) {

            pstm.setString(1,curp);
            pstm.setString(2, rfc);
            pstm.setString(3,nombre);
            pstm.setString(4,apellidoPaterno);
            pstm.setString(5,apellidoMaterno);
            pstm.setString(6, fechaNacimiento);

            result = pstm.executeUpdate() == 1;

        } catch (Exception e){
            e.printStackTrace();
        }

        return result;

    }

    public BeanPerson getPerson(String curp) {

        BeanPerson person = new BeanPerson();

        try(
                Connection con = new MySQLConnection().getConnection();
                PreparedStatement pstm = con.prepareStatement("SELECT * FROM persons WHERE curp=?");
        ) {
            pstm.setString(1,curp);


            ResultSet res = pstm.executeQuery();

            while (res.next()){
                person.setNombre(res.getString("nombre"));
                person.setApellidoPaterno(res.getString("apellido_paterno"));
                person.setApellidoMaterno(res.getString("apellido_materno"));
                person.setCurp(res.getString("curp"));
                person.setRfc(res.getString("rfc"));
                person.setFechaNacimiento(res.getString("fecha_nacimiento"));
            }

        } catch (Exception e){
            e.printStackTrace();
        }

        return person;
    }

    public List<BeanPerson> getPersons() {

        List<BeanPerson> persons = new ArrayList<>();

        try(
                Connection con = new MySQLConnection().getConnection();
                PreparedStatement pstm = con.prepareStatement("SELECT * FROM persons");
        ) {
            ResultSet res = pstm.executeQuery();

            while (res.next()){

                BeanPerson person = new BeanPerson();

                person.setNombre(res.getString("nombre"));
                person.setApellidoPaterno(res.getString("apellido_paterno"));
                person.setApellidoMaterno(res.getString("apellido_materno"));
                person.setCurp(res.getString("curp"));
                person.setRfc(res.getString("rfc"));
                person.setFechaNacimiento(res.getString("fecha_nacimiento"));

                persons.add(person);
            }

        } catch (Exception e){
            e.printStackTrace();
        }

        return persons;
    }

    public boolean deletePerson(String curp) {
        boolean result = false;

        try(
                Connection con = new MySQLConnection().getConnection();
                PreparedStatement pstm = con.prepareStatement("DELETE FROM persons WHERE curp=?");
        ) {
            pstm.setString(1,curp);
            result = pstm.executeUpdate() == 1;

        } catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }

    public boolean verifyCurp(String curp) {
        boolean exist = false;

        try(
                Connection con = new MySQLConnection().getConnection();
                PreparedStatement pstm = con.prepareStatement("SELECT * FROM persons WHERE curp=?");
        ) {
            pstm.setString(1,curp);

            ResultSet res = pstm.executeQuery();

            exist = res.next();

        } catch (Exception e){
            e.printStackTrace();
        }

        return exist;
    }

    public boolean updatePerson(String nombre, String apellidoPaterno, String apellidoMaterno, String curp, String rfc, String fechaNacimiento) {
        boolean result = false;

        try(
                Connection con = new MySQLConnection().getConnection();
                PreparedStatement pstm = con.prepareStatement("UPDATE persons SET nombre=?, apellido_paterno=?, apellido_materno=?, rfc=?, fecha_nacimiento=? WHERE curp=?");
        ) {
            pstm.setString(1,nombre);
            pstm.setString(2,apellidoPaterno);
            pstm.setString(3,apellidoMaterno);
            pstm.setString(4,rfc);
            pstm.setString(5,fechaNacimiento);
            pstm.setString(6,curp);

            result = pstm.executeUpdate() == 1;

        } catch (Exception e) {
            e.printStackTrace();

        }

        return result;
    }
}
