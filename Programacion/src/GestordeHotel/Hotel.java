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
}
