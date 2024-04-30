package ejercicios.entities;

public class Empleado {
    //Atributos de Empleado
    private static int contadorId = 0;
    private int idEmpleado;
    private String nombre;
    private double salario;


    //Constructor
    public Empleado( String nombre, double salario) {
        this.idEmpleado = ++contadorId;
        this.nombre = nombre;
        this.salario = salario;
    }

    //Métodos
    //Getter
    public int getIdEmpleado() {
        //Método para obtener el ID empleado
        return idEmpleado;
    }

    public String getNombre() {
        //Método para obtener el nombre del empleado
        return nombre;
    }

    public double getSalario() {
        //Método para obtener el salario del empleado
        return salario;
    }

    //Setters
    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    // Método para aumentar el salario
    public void aumentarSalario(double aumento) {
        this.salario += aumento; // Aumenta el salario actual
    }
}
