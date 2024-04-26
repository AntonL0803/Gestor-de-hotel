package GestordeHotel;
import java.util.*;
public class Administrador extends Hotel {

    public void altaHabitacion() {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Que tipo de habitación quiere elegir?: \n(1)Individual\n(2)Doble\n(3)Familiar");
        switch(sc.nextInt()){
            case 1: Individual h1 = new Individual();
                super.anadirHabitacion(h1);
                break;
            case 2: Doble h2 = new Doble();
                super.anadirHabitacion(h2);
                break;
            case 3: Familiar h3 = new Familiar();
                super.anadirHabitacion(h3);
                break;
        }
    }
    public void bajaHabitacion(int numeroHabitacion){
            for (Habitacion habitacion : getHabitaciones()) {
                if (habitacion.getNumeroHab() == numeroHabitacion) {
                    getHabitaciones().remove(habitacion);
                    System.out.println("Habitación " + numeroHabitacion + " dada de baja.");
                    return;
                }
            }
            System.out.println("No se encontró la habitación " + numeroHabitacion);
        }
    }
}
