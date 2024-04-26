package GestordeHotel;
import java.util.*;

public class Hotel {
    private LinkedList<Habitacion> habitaciones;
    private LinkedList<Reserva> reservas;

    public Hotel() {
        this.habitaciones = new LinkedList<>();
        this.reservas = new LinkedList<>();
    }
    public LinkedList<Habitacion> getHabitaciones(){
        return habitaciones;
    }

    public void anadirHabitacion(Habitacion habitacion){
        habitaciones.add(habitacion);
    }

    public void imprimirHab(){
        for(Habitacion elto : habitaciones){
            elto.toString();
        }
    }
    public void cambiarDatosHabitacion(int numeroHabitacion) {
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getNumeroHab() == numeroHabitacion) {
                habitacion.cambiarDatos();
                return;
            }
        }
        System.out.println("No se encontró la habitación " + numeroHabitacion);
    }

    public boolean habitacionDisponibleParaFecha(int numeroHabitacion, String fechaInicio, String fechaFin) {
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getNumeroHab() == numeroHabitacion) {
                return habitacion.disponibleParaFecha(fechaInicio, fechaFin);
            }
        }
        return false;
    }

    public void reservarHabitacion(int numeroHabitacion, String nombreCliente, String fechaInicio, String fechaFin) {
        if (habitacionDisponibleParaFecha(numeroHabitacion, fechaInicio, fechaFin)) {
            reservas.add(new Reserva(numeroHabitacion, nombreCliente, fechaInicio, fechaFin));
            for (Habitacion habitacion : habitaciones) {
                if (habitacion.getNumeroHab() == numeroHabitacion) {
                    habitacion.setDisponibilidad(true);
                }
            }
            System.out.println("Reserva realizada: Habitación " + numeroHabitacion + " para " + nombreCliente +
                    " desde " + fechaInicio + " hasta " + fechaFin);
        } else {
            System.out.println("La habitación no está disponible para las fechas especificadas.");
        }
    }
}
