package server;

public class BeanPerson {
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String curp;
    private String rfc;
    private String fechaNacimiento;

    public BeanPerson(){

    }
    public BeanPerson(String nombre, String apellidoPaterno, String apellidoMaterno, String curp, String rfc, String fechaNacimiento) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.curp = curp;
        this.rfc = rfc;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Nombre de la persona: '" + nombre + '\'' +
                "\nApellido paterno de la persona:'" + apellidoPaterno + '\'' +
                "\nApellido materno de la persona:'" + apellidoMaterno + '\'' +
                "\nCURP de la persona:'" + curp + '\'' +
                "\nRFC de la persona:'" + rfc + '\'' +
                "\nFecha de nacimiento de la persona:'" + fechaNacimiento + '\'';
    }
}
