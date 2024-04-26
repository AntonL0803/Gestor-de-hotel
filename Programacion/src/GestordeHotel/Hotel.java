package GestordeHotel;
import java.util.*;

public class Hotel {
    private LinkedList<Habitacion> habitaciones;

    public Hotel() {
        this.habitaciones = new LinkedList<>();
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
}
