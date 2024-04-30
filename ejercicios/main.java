package ejercicios;
import ejercicios.entities.Empleado;

import javax.swing.*;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        double supuestoSalario;
        String supuestoNombre;
        int numero;
        ArrayList<Empleado> listaEmpleados = new ArrayList<>();
        boolean continuar = true;
        int buscador;
        double salarioTotal = 0;

        JOptionPane.showMessageDialog(null, "Bienvenido al gestor de empleados");

        do {
            numero = Integer.parseInt(JOptionPane.showInputDialog(null, mostrarMenu()));

            switch (numero) {
                case 0:
                    continuar = false;
                    break;
                case 1:
                    supuestoNombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del empleado:");
                    supuestoSalario = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el salario del empleado:"));
                    Empleado nuevoEmpleado = new Empleado(supuestoNombre, supuestoSalario);
                    listaEmpleados.add(nuevoEmpleado);
                    JOptionPane.showMessageDialog(null, "El empleado " + nuevoEmpleado.getNombre() + " ha sido agregado\n" +
                            "ID: " + nuevoEmpleado.getIdEmpleado() + "\n" +
                            "Nombre: " + nuevoEmpleado.getNombre() + "\n" +
                            "Salario: " + nuevoEmpleado.getSalario());
                    break;
                case 2:
                    buscador = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el ID del empleado que desea buscar:"));
                    for (Empleado empleado : listaEmpleados) {
                        if (empleado.getIdEmpleado() == buscador) {
                            JOptionPane.showMessageDialog(null, "Empleado encontrado:\n" +
                                    "ID: " + empleado.getIdEmpleado() + "\n" +
                                    "Nombre: " + empleado.getNombre() + "\n" +
                                    "Salario: " + empleado.getSalario());
                            break;
                        }
                    }
                    break;
                case 3:
                    buscador = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el ID del empleado que desea eliminar:"));
                    for (Empleado empleado : listaEmpleados) {
                        if (empleado.getIdEmpleado() == buscador) {
                            listaEmpleados.remove(empleado);
                            JOptionPane.showMessageDialog(null, "Empleado eliminado exitosamente.");
                            break;
                        }
                    }
                    break;
                case 4:
                    for (Empleado empleado : listaEmpleados) {
                        salarioTotal += empleado.getSalario();
                    }
                    JOptionPane.showMessageDialog(null, "El salario total de todos los empleados es: " + salarioTotal);
                    break;
                case 5:
                    buscador = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el ID del empleado al que desea aumentar el salario:"));
                    boolean encontradoBuscador = false;
                    for (Empleado empleado : listaEmpleados) {
                        if (empleado.getIdEmpleado() == buscador) {
                            double aumento = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el monto del aumento:"));
                            empleado.aumentarSalario(aumento);
                            JOptionPane.showMessageDialog(null, "El salario del empleado " + empleado.getNombre() + " ha sido aumentado.");
                            encontradoBuscador = true;
                            break;
                        }
                    }
                    if (!encontradoBuscador) {
                        JOptionPane.showMessageDialog(null, "Empleado no encontrado.");
                    }
                    break;
                case 6:
                    StringBuilder mensajeEmpleados = new StringBuilder();
                    for (Empleado empleado : listaEmpleados) {
                        mensajeEmpleados.append("ID: ").append(empleado.getIdEmpleado()).append("\n");
                        mensajeEmpleados.append("Nombre: ").append(empleado.getNombre()).append("\n");
                        mensajeEmpleados.append("Salario: ").append(empleado.getSalario()).append("\n\n");
                    }
                    JOptionPane.showMessageDialog(null, "Los empleados son:\n" + mensajeEmpleados);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
                    break;
            }
        } while (continuar);
    }

    public static String mostrarMenu() {
        return "Por favor, selecciona una opción:\n" +
                "1. Agregar empleado\n" +
                "2. Buscar empleado\n" +
                "3. Eliminar empleado\n" +
                "4. Calcular salario total\n" +
                "5. Aumentar salario a un empleado\n" +
                "6. Mostrar todos los empleados\n" +
                "0. Salir";
    }
}
